package org.guilherme.service;

import org.guilherme.entity.Pessoa;

import java.util.List;

public interface Service<T> {

    void gravar(T object);

    void deletar(Long id);

    void atualizar(Long id, T object);

    T procurarPorId(Long id);

    List<T> listar();
}
