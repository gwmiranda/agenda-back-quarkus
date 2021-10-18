package org.guilherme.service;

import org.guilherme.entity.Pessoa;
import org.guilherme.repository.PessoaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@ApplicationScoped
public class PessoaService implements Service<Pessoa> {

    @Inject
    PessoaRepository repository;

    @Override
    public void salvar(Pessoa pessoa) {
        repository.persist(pessoa);
    }

    @Override
    public void deletar(Long id) {
        if (!repository.deleteById(id)) {
            throw new WebApplicationException(404);
        }
    }

    @Override
    public void atualizar(Long id, Pessoa pessoa) {
        Pessoa p = repository.findById(id);

        if(p == null){
            throw new NotFoundException();
        }

        p.setNome(pessoa.getNome());
        p.setSobrenome(pessoa.getSobrenome());
        p.setNascimento(pessoa.getNascimento());
        p.setParentesco(pessoa.getParentesco());
        p.setContato(pessoa.getContato());
        repository.persist(p);
    }

    @Override
    public Pessoa procurarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List listar() {
        return repository.listAll();
    }
}