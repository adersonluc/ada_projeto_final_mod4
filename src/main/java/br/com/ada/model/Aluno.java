package br.com.ada.model;


import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @NotBlank(message = "O nome não deve estar em branco")
    @Size(min = 2, message = "O número deve possuir mais de um caracter")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor")
    private Professor tutor;

    public Aluno() {
    }

    public Aluno(Integer id, String nome, Professor tutor) {
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

    public Professor getTutor() {
        return tutor;
    }

    public void setTutor(Professor tutor) {
        this.tutor = tutor;
    }
}
