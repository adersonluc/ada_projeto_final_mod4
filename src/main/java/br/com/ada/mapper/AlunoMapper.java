package br.com.ada.mapper;

import br.com.ada.dto.AlunoRequest;
import br.com.ada.dto.AlunoResponse;
import br.com.ada.model.Aluno;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class AlunoMapper {

    public List<AlunoResponse> toResponse(List<Aluno> listaDeAlunos){
        Objects.requireNonNull(listaDeAlunos, "Lista de alunos não deve ser nulo");

        return listaDeAlunos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AlunoResponse toResponse(Aluno aluno) throws NullPointerException{
        Objects.requireNonNull(aluno, "Aluno não deve ser nulo");

        return AlunoResponse.builder()
                .id(aluno.getId())
                .nome(aluno.getNome())
                .tutor(aluno.getTutor().getNome())
                .build();
    }

    public Aluno toEntity(AlunoRequest alunoRequest){

        Objects.requireNonNull(alunoRequest, "Aluno não deve ser nulo");

        return Aluno.builder()
                .nome(alunoRequest.getNome())
                .build();

    }

}
