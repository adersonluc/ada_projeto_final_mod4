package br.com.ada.dto;

public class ProfessorRequest {

    private String nome;

    public ProfessorRequest() {
    }

    public ProfessorRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
