package com.projetobiblioteca.GestaoBiblioteca.Service;

import java.time.LocalDate;

public class ServiceEmprestimo {
    public boolean LivroPego (LocalDate dataAtual, LocalDate dataVencimento) {
        if (dataAtual.isAfter(dataVencimento)) {
            return true;
        } else if (dataAtual.isAfter(dataVencimento)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean LivroPegoBoolean (boolean pego) {
        if (pego == true) {
            return true;
        } else {
            return false;
        }
    }
}
