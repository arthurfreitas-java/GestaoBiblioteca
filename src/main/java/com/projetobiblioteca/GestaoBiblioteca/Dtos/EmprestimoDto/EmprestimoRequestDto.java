package com.projetobiblioteca.GestaoBiblioteca.Dtos.EmprestimoDto;

import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record EmprestimoRequestDto(@NotNull UUID LivroId) {
}
