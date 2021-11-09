package org.guilherme.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String parentesco;
    private LocalDate nascimento;
    @ElementCollection
    @CollectionTable(name = "contato", joinColumns = @JoinColumn(name = "pessoa_id"))
    @Fetch( FetchMode.JOIN)
    private List<Contato> contatos;
    private String username;

    public Pessoa(){}

    public Pessoa(Long id, String nome, String sobrenome, String parentesco, LocalDate nascimento, List<Contato> contatos) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.parentesco = parentesco;
        this.nascimento = nascimento;
        this.contatos = contatos;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public List<Contato> getContato() {
        return contatos;
    }

    public void setContato(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", parentesco='" + parentesco + '\'' +
                ", dataNascimento=" + nascimento +
                ", contatos=" + contatos +
                '}';
    }
}
