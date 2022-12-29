package br.com.ada.mapper;

import br.com.ada.dto.ProfessorRequest;
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

        try {
            return ProfessorResponse.builder()
                    .id(professor.getId())
                    .nome(professor.getNome())
                    .disciplina(professor.getDisciplina().getNome())
                    .alunos(professor.getAlunos().stream().map(aluno -> aluno.getNome()).collect(Collectors.toList()))
                    .build();
        } catch(NullPointerException e){
            return ProfessorResponse.builder()
                    .id(professor.getId())
                    .nome(professor.getNome())
                    .build();
        }
    }

    public Professor toEntity(ProfessorRequest professorRequest) {

        Objects.requireNonNull(professorRequest, "O professor não deve ser nulo");

        return Professor.builder()
                .nome(professorRequest.getNome())
                .build();

    }
}
