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
        return listaDeAlunos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AlunoResponse toResponse(Aluno aluno){
        try {
            return AlunoResponse.builder()
                    .id(aluno.getId())
                    .nome(aluno.getNome())
                    .tutor(aluno.getTutor().getNome())
                    .build();
        } catch(NullPointerException e){
            return AlunoResponse.builder()
                    .id(aluno.getId())
                    .nome(aluno.getNome())
                    .build();
        }
    }

    public Aluno toEntity(AlunoRequest alunoRequest){

        Objects.requireNonNull(alunoRequest, "Aluno não deve ser nulo");

        return Aluno.builder()
                .nome(alunoRequest.getNome())
                .build();

    }

}
