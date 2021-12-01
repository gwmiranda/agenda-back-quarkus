package org.guilherme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import org.guilherme.entity.Pessoa;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {

    public List<Pessoa> contatosPorUsuario(String username) {
        return find(
                "username = :username",
                Parameters.with("username", username)
        ).list();
    }
}