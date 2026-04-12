package com.projetobiblioteca.GestaoBiblioteca.Controllers;

import com.projetobiblioteca.GestaoBiblioteca.Dtos.AutorRequestDots;
import com.projetobiblioteca.GestaoBiblioteca.Model.AutorModel;
import com.projetobiblioteca.GestaoBiblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping("/criar")
    public ResponseEntity<AutorRequestDots> criarAutor(@RequestBody AutorRequestDots dto) {
        AutorModel autorM = new  AutorModel();

        autorM.setNome(dto.nome());
        autorM.setNacionalidade(dto.nacionalidade());

        autorRepository.save(autorM);
        return ResponseEntity.ok().body(dto);
    }
}
