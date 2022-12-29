package br.com.ada.service;


import br.com.ada.dto.AlunoResponse;
import br.com.ada.dto.DisciplinaResponse;
import br.com.ada.dto.ProfessorRequest;
import br.com.ada.dto.ProfessorResponse;
import br.com.ada.mapper.AlunoMapper;
import br.com.ada.mapper.DisciplinaMapper;
import br.com.ada.mapper.ProfessorMapper;
import br.com.ada.model.Aluno;
import br.com.ada.model.Professor;
import br.com.ada.repositorio.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class ProfessorService {

    private final ProfessorMapper professorMapper;
    private final DisciplinaMapper disciplinaMapper;
    private final ProfessorRepository professorRepository;

    private final AlunoMapper alunoMapper;

    @Inject
    public ProfessorService(ProfessorMapper professorMapper, ProfessorRepository professorRepository, DisciplinaMapper disciplinaMapper, AlunoMapper alunoMapper){
        this.professorMapper = professorMapper;
        this.professorRepository = professorRepository;
        this.disciplinaMapper = disciplinaMapper;
        this.alunoMapper = alunoMapper;
    }

    public List<ProfessorResponse> listarProfessores() {
        List<ProfessorResponse> professores = professorRepository.listAll().stream()
                .map(professorMapper::toResponse).collect(Collectors.toList());
        return professores;
    }

    public ProfessorResponse getProfessorById(Integer id) {
        ProfessorResponse professorResponse = professorMapper.toResponse(professorRepository.findById(id));
        return professorResponse;
    }

    @Transactional
    public void salvarProfessor(ProfessorRequest professorRequest) {
        professorRepository.persist(professorMapper.toEntity(professorRequest));
    }

    @Transactional
    public ProfessorResponse alterarProfessor(Integer id, Professor professor) {
        log.info("Alterando o professor");
        Professor professorAlterado = professorRepository.findById(id);
        professorAlterado.setNome(professor.getNome());
        professorRepository.persist(professorAlterado);
        return professorMapper.toResponse(professorAlterado);
    }

    @Transactional
    public void deletarProfessor(Integer id) {
        log.info("Deletando professor");
        professorRepository.findByIdOptional(id).ifPresent(professorRepository::delete);
    }

    public DisciplinaResponse buscarDisciplinaPorTutorId(Integer idProfessor) {
        Professor professor = professorRepository.findById(idProfessor);
        return disciplinaMapper.toResponse(professor.getDisciplina());
    }

    public List<AlunoResponse> buscarTutoradosPorId(Integer idProfessor) {
        List<Aluno> alunos = professorRepository.findById(idProfessor).getAlunos();
        return alunos.stream().map(alunoMapper::toResponse).collect(Collectors.toList());
    }
}