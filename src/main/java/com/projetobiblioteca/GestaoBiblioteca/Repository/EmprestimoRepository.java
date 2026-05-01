package com.projetobiblioteca.GestaoBiblioteca.Repository;

import com.projetobiblioteca.GestaoBiblioteca.Model.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, UUID> {
}
