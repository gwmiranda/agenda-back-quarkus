package org.guilherme.entity;

public abstract class UsuarioLogado {

    private static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        UsuarioLogado.usuarioLogado = usuarioLogado;
    }
}
