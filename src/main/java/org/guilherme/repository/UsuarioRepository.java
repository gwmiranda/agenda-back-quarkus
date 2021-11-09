package org.guilherme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.guilherme.entity.Usuario;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> verificarLogin(Usuario usuario) {
        return find(
            "SELECT u.username, u.senha FROM Usuario u WHERE u.username = ?1 AND u.senha = ?2",
                usuario.getUsername(),
                usuario.getSenha())
            .list();
    }
}