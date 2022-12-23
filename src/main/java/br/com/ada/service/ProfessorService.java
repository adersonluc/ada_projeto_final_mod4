package br.com.ada.service;


import br.com.ada.mapper.ProfessorMapper;
import br.com.ada.model.Professor;
import br.com.ada.repositorio.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Slf4j
public class ProfessorService {

    private final ProfessorMapper professorMapper;
    private final ProfessorRepository professorRepository;

    @Inject
    public ProfessorService(ProfessorMapper professorMapper, ProfessorRepository professorRepository){
        this.professorMapper = professorMapper;
        this.professorRepository = professorRepository;
    }

    public List<Professor> listarProfessores() {
        log.info("Listando professores");
        List<Professor> professores = professorRepository.listAll();
        return professores;
    }

    public Professor getProfessorById(Integer id) {
        log.info("Listando professor");
        Professor professor = professorRepository.findById(id);
        return professor;
    }

    @Transactional
    public void salvarProfessor(Professor professor) {
        log.info("Salvando o professor");
        professorRepository.persist(professor);
    }

    @Transactional
    public Professor alterarProfessor(Integer id, Professor professor) {
        log.info("Alterando o professor");
        Professor professorAlterado = professorRepository.findById(id);
        professorAlterado.setNome(professor.getNome());
        professorRepository.persist(professorAlterado);
        return professorAlterado;
    }

    @Transactional
    public void deletarProfessor(Integer id) {
        log.info("Deletando professor");
        professorRepository.findByIdOptional(id).ifPresent(professorRepository::delete);
    }
}