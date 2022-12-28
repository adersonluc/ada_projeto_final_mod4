package br.com.ada.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Entity
@Table(name = "tb_professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @NotBlank(message = "O nome não deve estar em branco")
    @Size(min = 2, message = "O número deve possuir mais de um caracter")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "titular")
    @JsonIgnore
    private Disciplina disciplina;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tutor")
    private List<Aluno> alunos;

    public Professor() {
    }

    public Professor(Integer id, String nome, Disciplina disciplina, List<Aluno> alunos) {
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
