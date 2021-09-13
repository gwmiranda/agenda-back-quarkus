package org.guilherme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.guilherme.entity.Pessoa;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {}