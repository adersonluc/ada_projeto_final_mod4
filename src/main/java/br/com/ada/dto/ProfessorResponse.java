package br.com.ada.dto;

import br.com.ada.model.Aluno;
import br.com.ada.model.Disciplina;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@JsonIgnoreProperties
public class ProfessorResponse {

    @NotNull
    private Integer id;

    @NotBlank(message = "O nome não deve estar em branco")
    @Size(min = 2, message = "O número deve possuir mais de um caracter")
    private String nome;

    private String disciplina;

    private List<String> alunos;

    public ProfessorResponse() {
    }

    public ProfessorResponse(Integer id, String nome, String disciplina, List<String> alunos) {
        this.id = id;
        this.nome = nome;
        this.disciplina = disciplina;
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<String> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<String> alunos) {
        this.alunos = alunos;
    }
}
