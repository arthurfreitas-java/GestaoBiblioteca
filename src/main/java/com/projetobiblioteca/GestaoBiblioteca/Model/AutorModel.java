package com.projetobiblioteca.GestaoBiblioteca.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb-autores")

public class AutorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID autorId;
    String nome;
    String nacionalidade;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<LivroModel> livros;

    public UUID getId() {
        return autorId;
    }

    public void setId(UUID id) {
        this.autorId = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
