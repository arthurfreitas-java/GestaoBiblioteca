package com.projetobiblioteca.GestaoBiblioteca.Dtos.LivroPost;

import com.projetobiblioteca.GestaoBiblioteca.Model.LivroModel;

import java.util.UUID;

public record LivroResponseDto(String titulo, UUID id, UUID idAutor) {
    public LivroResponseDto(LivroModel model) {
        this(model.getTitulo(), model.getId(), model.getAutor().getId());
    }
}
