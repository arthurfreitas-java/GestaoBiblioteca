package com.projetobiblioteca.GestaoBiblioteca.Controllers;

import com.projetobiblioteca.GestaoBiblioteca.Dtos.LivroDto;
import com.projetobiblioteca.GestaoBiblioteca.Model.LivroModel;
import com.projetobiblioteca.GestaoBiblioteca.Repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    LivroRepository livroRepository;

    public LivrosController(LivroRepository livro) {
        this.livroRepository = livro;
    }

    @PostMapping("/criarlivros")
    public ResponseEntity<LivroDto> criarLivro(@RequestBody LivroDto livroDto) {
        LivroModel model = new LivroModel();

        model.setTitulo(livroDto.titulo());
        model.setIdAutor(livroDto.idAutor());

        livroRepository.save(model);
        return ResponseEntity.ok().body(livroDto);
    }

    @GetMapping("/mostrarLivros")
    public ResponseEntity<List<LivroModel>> mostrarLivros() {
        return ResponseEntity.ok().body(livroRepository.findAll());
    }

    @GetMapping("/mostrarlivros/{id}")
    public ResponseEntity<LivroModel> mostrarUmLivro(@PathVariable UUID id) {
        return livroRepository.findById(id).map (livro -> ResponseEntity.ok(livro)).orElse(ResponseEntity.notFound().build());
    }
}
