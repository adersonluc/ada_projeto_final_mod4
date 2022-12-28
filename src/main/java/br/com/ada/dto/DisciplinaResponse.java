package br.com.ada.dto;

import br.com.ada.model.Professor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@JsonIgnoreProperties
public class DisciplinaResponse {

    @NotNull
    private Integer id;

    @NotBlank(message = "O nome não deve estar em branco")
    @Size(min = 2, message = "O número deve possuir mais de um caracter")
    private String nome;

    @NotNull
    private Professor titular;

    public DisciplinaResponse() {
    }

    public DisciplinaResponse(Integer id, String nome, Professor titular) {
        this.id = id;
        this.nome = nome;
        this.titular = titular;
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

    public Professor getTitular() {
        return titular;
    }

    public void setTitular(Professor titular) {
        this.titular = titular;
    }
}
