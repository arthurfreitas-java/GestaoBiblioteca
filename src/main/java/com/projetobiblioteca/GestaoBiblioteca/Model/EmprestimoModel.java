package com.projetobiblioteca.GestaoBiblioteca.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="tb-emprestimos")
public class EmprestimoModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID id;
    UUID livroId;
    Boolean pego;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmprestimo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmprestimoVencimento;

    public void dataEmprestimoVencimento(LocalDate dataEmprestimo) {
        this.dataEmprestimoVencimento = dataEmprestimo.plusMonths(1);
    }

    public LocalDate getDataEmprestimoVencimento() {
        return dataEmprestimoVencimento;
    }

    public void setDataEmprestimoVencimento(LocalDate dataEmprestimoVencimento) {
        this.dataEmprestimoVencimento = dataEmprestimoVencimento;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public UUID getLivroId() {
        return livroId;
    }

    public void setLivroId(UUID livroId) {
        this.livroId = livroId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getPego() {
        return pego;
    }

    public void setPego(Boolean pego) {
        this.pego = pego;
    }
}
