package br.com.ada.service;

import br.com.ada.dto.AlunoRequest;
import br.com.ada.dto.AlunoResponse;
import br.com.ada.mapper.AlunoMapper;
import br.com.ada.model.Aluno;
import br.com.ada.model.Professor;
import br.com.ada.repositorio.AlunoRepository;
import br.com.ada.repositorio.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
@Slf4j
public class AlunoService {

    private final AlunoMapper alunoMapper;

    private final AlunoRepository alunoRepository;

    private final ProfessorRepository professorRepository;

    @Inject
    public AlunoService(AlunoMapper alunoMapper, AlunoRepository alunoRepository, ProfessorRepository professorRepository){
        this.alunoMapper = alunoMapper;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
    }
    public List<AlunoResponse> listarAlunos() {
        return alunoMapper.toResponse(alunoRepository.listAll());
    }

    public AlunoResponse listarAlunoPorId(Integer id) {
        return alunoMapper.toResponse(alunoRepository.findById(id));
    }

    @Transactional
    public void salvarAluno(@Valid AlunoRequest alunoRequest) {
        alunoRepository.persist(alunoMapper.toEntity(alunoRequest));
    }

    @Transactional
    public AlunoResponse alterarAluno(Integer id,@Valid AlunoRequest alunoRequest) {
        Aluno alunoAlterado = alunoRepository.findById(id);
        alunoAlterado.setNome(alunoRequest.getNome());
        alunoRepository.persist(alunoAlterado);
        return alunoMapper.toResponse(alunoAlterado);
    }

    @Transactional
    public void deletarAluno(Integer id) {
        alunoRepository.deleteById(id);
    }

    @Transactional
    public AlunoResponse atualizarTutorDoAluno(Integer idAluno, Integer idProfessor) {
        Aluno aluno = alunoRepository.findById(idAluno);
        Professor professor = professorRepository.findById(idProfessor);
        aluno.setTutor(professor);
        alunoRepository.persist(aluno);
        return alunoMapper.toResponse(alunoRepository.findById(idAluno));
    }
}
