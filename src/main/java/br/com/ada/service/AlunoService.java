package br.com.ada.service;

import br.com.ada.dto.AlunoRequest;
import br.com.ada.dto.AlunoResponse;
import br.com.ada.mapper.AlunoMapper;
import br.com.ada.model.Aluno;
import br.com.ada.repositorio.AlunoRepository;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Slf4j
public class AlunoService {

    private final AlunoMapper alunoMapper;

    private final AlunoRepository alunoRepository;

    @Inject
    public AlunoService(AlunoMapper alunoMapper, AlunoRepository alunoRepository){
        this.alunoMapper = alunoMapper;
        this.alunoRepository = alunoRepository;
    }
    public List<AlunoResponse> listarAlunos() {
        return alunoMapper.toResponse(alunoRepository.listAll());
    }

    public AlunoResponse listarAlunoPorId(Integer id) {
        return alunoMapper.toResponse(alunoRepository.findById(id));
    }

    @Transactional
    public void salvarAluno(AlunoRequest alunoRequest) {
        alunoRepository.persist(alunoMapper.toEntity(alunoRequest));
    }

    @Transactional
    public AlunoResponse alterarAluno(Integer id, AlunoRequest alunoRequest) {
        Aluno alunoAlterado = alunoRepository.findById(id);
        alunoAlterado.setNome(alunoRequest.getNome());
        alunoRepository.persist(alunoAlterado);
        return alunoMapper.toResponse(alunoAlterado);
    }

    @Transactional
    public void deletarAluno(Integer id) {
        alunoRepository.deleteById(id);
    }
}
