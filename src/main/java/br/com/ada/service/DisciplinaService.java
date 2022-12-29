package br.com.ada.service;

import br.com.ada.dto.DisciplinaRequest;
import br.com.ada.dto.DisciplinaResponse;
import br.com.ada.mapper.DisciplinaMapper;
import br.com.ada.model.Disciplina;
import br.com.ada.model.Professor;
import br.com.ada.repositorio.DisciplinaRepository;
import br.com.ada.repositorio.ProfessorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DisciplinaService {

    private final DisciplinaMapper disciplinaMapper;
    private final DisciplinaRepository disciplinaRepository;

    private final ProfessorRepository professorRepository;

    @Inject
    public DisciplinaService(DisciplinaMapper disciplinaMapper, DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository){
        this.disciplinaMapper = disciplinaMapper;
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
    }

    public List<DisciplinaResponse> listarDisciplinas() {
        return disciplinaMapper.toResponse(disciplinaRepository.listAll());
    }

    public DisciplinaResponse listarDisciplinaPorId(Integer id) {
        return disciplinaMapper.toResponse(disciplinaRepository.findById(id));
    }

    @Transactional
    public void salvarDisciplina(DisciplinaRequest disciplinaRequest) {
        disciplinaRepository.persist(disciplinaMapper.toEntity(disciplinaRequest));
    }

    @Transactional
    public Disciplina alterarDisciplina(Integer id, Disciplina disciplina) {
        Disciplina disciplinaAlterada = disciplinaRepository.findById(id);
        disciplinaAlterada.setNome(disciplina.getNome());
        disciplinaRepository.persist(disciplinaAlterada);
        return disciplinaAlterada;
    }

    @Transactional
    public void deletarDisciplina(Integer id) {
        disciplinaRepository.deleteById(id);
    }

    @Transactional
    public DisciplinaResponse atualizarProfessorDaDisciplina(Integer idDisciplina, Integer idProfessor) {
        Professor professor = professorRepository.findById(idProfessor);
        Disciplina disciplina = disciplinaRepository.findById(idDisciplina);
        disciplina.setTitular(professor);
        disciplinaRepository.persist(disciplina);
        return disciplinaMapper.toResponse(disciplinaRepository.findById(idDisciplina));
    }
}
