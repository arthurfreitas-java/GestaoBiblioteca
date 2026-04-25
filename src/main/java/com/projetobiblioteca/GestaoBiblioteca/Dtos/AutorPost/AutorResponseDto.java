package com.projetobiblioteca.GestaoBiblioteca.Dtos.AutorPost;

import com.projetobiblioteca.GestaoBiblioteca.Model.AutorModel;

public record AutorResponseDto(String nome, String nacionalidade) {
    public AutorResponseDto(AutorModel model) {
        this(model.getNome(), model.getNacionalidade());
    }
}