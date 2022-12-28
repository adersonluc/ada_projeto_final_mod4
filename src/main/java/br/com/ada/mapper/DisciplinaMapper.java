package br.com.ada.mapper;

import br.com.ada.dto.DisciplinaResponse;
import br.com.ada.model.Disciplina;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class DisciplinaMapper {

    public List<DisciplinaResponse> toResponse(List<Disciplina> listaDeDisciplinas){
        Objects.requireNonNull(listaDeDisciplinas, "Lista de Disciplinas não deve ser nula");

        return listaDeDisciplinas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public DisciplinaResponse toResponse(Disciplina disciplina){

        Objects.requireNonNull(disciplina, "Disciplina não deve ser nula");

        return DisciplinaResponse.builder()
                .id(disciplina.getId())
                .nome(disciplina.getNome())
                .titular(disciplina.getTitular())
                .build();

    }

}
