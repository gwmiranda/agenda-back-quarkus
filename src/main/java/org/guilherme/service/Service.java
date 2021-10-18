package org.guilherme.service;

import org.guilherme.entity.Pessoa;

import java.util.List;

public interface Service<T> {

    void salvar(T object);

    void deletar(Long id);

    void atualizar(Long id, T object);

    Pessoa procurarPorId(Long id);

    List<T> listar();
}
