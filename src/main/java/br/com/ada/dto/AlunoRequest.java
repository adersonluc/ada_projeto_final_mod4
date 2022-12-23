package br.com.ada.dto;

public class AlunoRequest {

    private String nome;

    public AlunoRequest() {
    }

    public AlunoRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
