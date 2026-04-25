package com.projetobiblioteca.GestaoBiblioteca.Dtos.LivroPost;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

public record LivroDto(@NotNull String titulo, @NotNull UUID idAutor) {
}
