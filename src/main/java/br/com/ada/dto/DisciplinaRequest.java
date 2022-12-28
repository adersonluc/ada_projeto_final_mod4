package br.com.ada.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DisciplinaRequest {


    @NotBlank(message = "O nome não deve estar em branco")
    @Size(min = 2, message = "O número deve possuir mais de um caracter")
    private String nome;

    public DisciplinaRequest() {
    }

    public DisciplinaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
