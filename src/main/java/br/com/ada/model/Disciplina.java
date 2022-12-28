package br.com.ada.model;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Entity
@Table(name = "tb_disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @NotBlank(message = "O nome não deve estar em branco")
    @Size(min = 2, message = "O número deve possuir mais de um caracter")
    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToOne
    @JoinColumn(name="titular", unique = true)
    private Professor titular;

    public Disciplina() {
    }

    public Disciplina(Integer id, String nome, Professor titular) {
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
