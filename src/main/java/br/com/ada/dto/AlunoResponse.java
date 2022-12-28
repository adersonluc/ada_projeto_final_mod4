package br.com.ada.dto;

import br.com.ada.model.Professor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@JsonIgnoreProperties
public class AlunoResponse {

    @NotNull
    private Integer id;

    @NotBlank(message = "O nome não deve estar em branco")
    @Size(min = 2, message = "O número deve possuir mais de um caracter")
    private String nome;

    private String tutor;
    public AlunoResponse() {
    }

    public AlunoResponse(Integer id, String nome, String tutor) {
        this.id = id;
        this.nome = nome;
        this.tutor = tutor;
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

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}
