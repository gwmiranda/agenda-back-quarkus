package org.guilherme.service;

import org.guilherme.entity.Usuario;
import org.guilherme.repository.UsuarioRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@RequestScoped
public class UsuarioService implements Service<Usuario> {

    @Inject
    UsuarioRepository repository;

    @Override
    public void gravar(Usuario Usuario) {
        repository.persist(Usuario);
    }

    @Override
    public void deletar(Long id) {
        if (!repository.deleteById(id)) {
            throw new WebApplicationException(404);
        }
    }

    @Override
    public void atualizar(Long id, Usuario Usuario) {
        Usuario p = repository.findById(id);

        if(p == null){
            throw new NotFoundException();
        }

        p.setUsername(Usuario.getSenha());
        p.setSenha(Usuario.getSenha());

        repository.persist(p);
    }

    @Override
    public Usuario procurarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List listar() {
        return repository.listAll();
    }

    public Boolean verificarLogin(Usuario usuario){
        return !repository.verificarLogin(usuario).isEmpty();
    }
}