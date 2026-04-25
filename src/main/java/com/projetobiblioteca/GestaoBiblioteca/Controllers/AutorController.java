package com.projetobiblioteca.GestaoBiblioteca.Controllers;

import com.projetobiblioteca.GestaoBiblioteca.Dtos.AutorPost.AutorRequestDots;
import com.projetobiblioteca.GestaoBiblioteca.Dtos.AutorPost.AutorResponseDto;
import com.projetobiblioteca.GestaoBiblioteca.Model.AutorModel;
import com.projetobiblioteca.GestaoBiblioteca.Repository.AutorRepository;
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
    public ResponseEntity<AutorResponseDto> criarAutor(@RequestBody AutorRequestDots dto) {
        AutorModel autorM = new  AutorModel();

        autorM.setNome(dto.nome());
        autorM.setNacionalidade(dto.nacionalidade());

        autorRepository.save(autorM);
        AutorResponseDto responseDto = new AutorResponseDto(autorM);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/mostrarAutor")
    public ResponseEntity<List<AutorModel>> mostarAutores() {
        List<AutorModel> listAutor =  autorRepository.findAll();
        return ResponseEntity.ok(listAutor);
    }

    @GetMapping("/mostrarAutor/{id}")
    public ResponseEntity<AutorResponseDto> mostarAutor(@PathVariable UUID id) {
        return autorRepository.findById(id).map(autor -> {
            AutorResponseDto responseDto = new AutorResponseDto(autor);
            return ResponseEntity.ok(responseDto);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AutorResponseDto> atualizarAutor(@RequestBody AutorRequestDots dto, @PathVariable UUID id) {
        return autorRepository.findById(id).map(autorEncontrado -> {
                autorEncontrado.setNome(dto.nome());
                autorEncontrado.setNacionalidade(dto.nacionalidade());
                autorRepository.save(autorEncontrado);

                AutorResponseDto responseDto = new AutorResponseDto(autorEncontrado);
                return ResponseEntity.ok(responseDto);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletarAutor(@PathVariable UUID id) {
            return autorRepository.findById(id).map(autor -> {
                autorRepository.delete(autor);
                return ResponseEntity.noContent().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
