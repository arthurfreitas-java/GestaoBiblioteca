package com.projetobiblioteca.GestaoBiblioteca.Repository;

import com.projetobiblioteca.GestaoBiblioteca.Model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, UUID> {
}
