package com.projetobiblioteca.GestaoBiblioteca.Model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="tb-Livros")
public class LivroModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    UUID id;
    String titulo;
    UUID idAutor;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorModel autor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(UUID idAutor) {
        this.idAutor = idAutor;
    }
}
