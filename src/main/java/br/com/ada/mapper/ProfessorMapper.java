package br.com.ada.mapper;

import br.com.ada.dto.ProfessorResponse;
import br.com.ada.model.Professor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProfessorMapper {

    public List<ProfessorResponse> toResponse(List<Professor> listaDeProfessores){
        Objects.requireNonNull(listaDeProfessores, "Lista de professores não deve ser nulo");

        return listaDeProfessores.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProfessorResponse toResponse(Professor professor){

        Objects.requireNonNull(professor, "Professor não deve ser nulo");

        return ProfessorResponse.builder()
                .id(professor.getId())
                .nome(professor.getNome())
                .build();

    }

}
