package br.com.ada.repositorio;

import br.com.ada.model.Aluno;
import br.com.ada.model.Disciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepositoryBase<Disciplina, Integer> {
}
