package com.projetobiblioteca.GestaoBiblioteca.Dtos.LivroGet;

import com.projetobiblioteca.GestaoBiblioteca.Model.LivroModel;

import java.util.UUID;

public record LivroResponseGetDto(String titulo, UUID id, UUID idAutor) {
    public LivroResponseGetDto(LivroModel model) {
        this(model.getTitulo(), model.getId(), model.getAutor().getId());
    }

}
