package com.projetobiblioteca.GestaoBiblioteca.Controllers;

import com.projetobiblioteca.GestaoBiblioteca.Dtos.AutorRequestDots;
import com.projetobiblioteca.GestaoBiblioteca.Model.AutorModel;
import com.projetobiblioteca.GestaoBiblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/autor")
public class AutorController {

    AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/criar")
    public ResponseEntity<AutorRequestDots> criarAutor(@RequestBody AutorRequestDots dto) {
        AutorModel autorM = new  AutorModel();

        autorM.setNome(dto.nome());
        autorM.setNacionalidade(dto.nacionalidade());

        autorRepository.save(autorM);
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping()
    public ResponseEntity<List<AutorModel>> mostarAutores() {
        List<AutorModel> listAutor =  autorRepository.findAll();
        return ResponseEntity.ok(listAutor);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AutorRequestDots> atualizarAutor(@RequestBody AutorRequestDots dto, @PathVariable UUID id) {
        return autorRepository.findById(id).map(autorEncontrado -> {
                autorEncontrado.setNome(dto.nome());
                autorEncontrado.setNacionalidade(dto.nacionalidade());
                autorRepository.save(autorEncontrado);

                return ResponseEntity.ok(dto);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<AutorModel> deletarAutor(@PathVariable UUID id) {
        return autorRepository.findById(id).map(autorEncontrado -> {
            autorRepository.delete(autorEncontrado);
            return ResponseEntity.ok(autorEncontrado);
        }).orElse(ResponseEntity.notFound().build());
    }
}
