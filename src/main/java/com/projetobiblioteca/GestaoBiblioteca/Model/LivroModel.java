package com.projetobiblioteca.GestaoBiblioteca.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="tb-Livros")
public class LivroModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID id;
    String titulo;
    boolean pegoLivro = true;


    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private AutorModel autor;

    public AutorModel getAutor() {
        return autor;
    }

    public void setAutor(AutorModel autor) {
        this.autor = autor;
    }

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

    public boolean getPego() {
        return pegoLivro;
    }

    public void setPego(boolean pegoLivro) {
        this.pegoLivro = pegoLivro;
    }
}
