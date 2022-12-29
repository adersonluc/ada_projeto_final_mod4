package br.com.ada.mapper;

import br.com.ada.dto.DisciplinaRequest;
import br.com.ada.dto.DisciplinaResponse;
import br.com.ada.model.Disciplina;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class DisciplinaMapper {

    public List<DisciplinaResponse> toResponse(List<Disciplina> listaDeDisciplinas){
        return listaDeDisciplinas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public DisciplinaResponse toResponse(Disciplina disciplina){

        try {
            return DisciplinaResponse.builder()
                    .id(disciplina.getId())
                    .nome(disciplina.getNome())
                    .titular(disciplina.getTitular().getNome())
                    .build();
        } catch(NullPointerException e){
            return DisciplinaResponse.builder()
                    .id(disciplina.getId())
                    .nome(disciplina.getNome())
                    .build();
        }
    }

    public Disciplina toEntity(DisciplinaRequest disciplinaRequest) {
        return Disciplina.builder()
                .nome(disciplinaRequest.getNome())
                .build();
    }
}
