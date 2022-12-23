package br.com.ada.service;

import br.com.ada.mapper.DisciplinaMapper;
import br.com.ada.model.Disciplina;
import br.com.ada.repositorio.DisciplinaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DisciplinaService {

    private final DisciplinaMapper disciplinaMapper;
    private final DisciplinaRepository disciplinaRepository;

    @Inject
    public DisciplinaService(DisciplinaMapper disciplinaMapper, DisciplinaRepository disciplinaRepository){
        this.disciplinaMapper = disciplinaMapper;
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.listAll();
    }

    public Disciplina listarDisciplinaPorId(Integer id) {
        return disciplinaRepository.findById(id);
    }

    @Transactional
    public void salvarDisciplina(Disciplina disciplina) {
        disciplinaRepository.persist(disciplina);
    }

    @Transactional
    public Disciplina alterarDisciplina(Integer id, Disciplina disciplina) {
        Disciplina disciplinaAlterada = disciplinaRepository.findById(id);
        disciplinaAlterada.setNome(disciplina.getNome());
        disciplinaRepository.persist(disciplinaAlterada);
        return disciplinaAlterada;
    }

    @Transactional
    public void deletarDisciplina(Integer id) {
        disciplinaRepository.deleteById(id);
    }
}
