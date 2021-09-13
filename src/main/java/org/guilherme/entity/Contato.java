package org.guilherme.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Contato {

    private Integer contato;

    public Contato(){}

    public Contato(Integer contato) {
        this.contato = contato;
    }

    public Integer getContato() {
        return contato;
    }

    public void setContato(Integer contato) {
        this.contato = contato;
    }
}
