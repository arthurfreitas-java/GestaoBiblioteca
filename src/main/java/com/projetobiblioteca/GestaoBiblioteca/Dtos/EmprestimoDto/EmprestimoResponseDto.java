package com.projetobiblioteca.GestaoBiblioteca.Dtos.EmprestimoDto;

import com.projetobiblioteca.GestaoBiblioteca.Model.EmprestimoModel;

import java.time.LocalDate;
import java.util.UUID;

public record EmprestimoResponseDto(UUID LivroId, LocalDate Vencimento) {
    public EmprestimoResponseDto(EmprestimoModel model) {
        this(model.getLivroId(), model.getDataEmprestimoVencimento());
    }
}
