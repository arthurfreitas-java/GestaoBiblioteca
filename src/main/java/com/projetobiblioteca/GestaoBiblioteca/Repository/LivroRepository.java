package com.projetobiblioteca.GestaoBiblioteca.Repository;

import com.projetobiblioteca.GestaoBiblioteca.Model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<LivroModel, UUID> {
}
