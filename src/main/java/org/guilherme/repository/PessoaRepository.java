package org.guilherme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.guilherme.entity.Pessoa;
import org.guilherme.entity.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.tools.JavaFileManager;
import java.util.List;

@RequestScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {

    public List<Pessoa> contatosPorUsuario(String username) {
        return find(
            "SELECT p FROM Pessoa p WHERE p.username = ?1",
            username)
            .list();
    }
}