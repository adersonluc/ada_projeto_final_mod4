package br.com.ada.dto;

public class DisciplinaRequest {

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
