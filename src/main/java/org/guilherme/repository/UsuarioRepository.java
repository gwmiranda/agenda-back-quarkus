package org.guilherme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.guilherme.entity.Usuario;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> verificarLogin(Usuario usuario) {
        return  find(
            "username = ?1 and senha = ?2",
            usuario.getUsername(),
            usuario.getSenha()
        ).list();
    }
}

//            "username = :username and senha = :senha",
//            Parameters.with(
//                "username", usuario.getUsername()).and("senha", usuario.getSenha())