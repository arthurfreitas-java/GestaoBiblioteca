package com.projetobiblioteca.GestaoBiblioteca.Controllers;

import com.projetobiblioteca.GestaoBiblioteca.Dtos.LivroGet.LivroResponseGetDto;
import com.projetobiblioteca.GestaoBiblioteca.Dtos.LivroPost.LivroDto;
import com.projetobiblioteca.GestaoBiblioteca.Dtos.LivroPost.LivroResponseDto;
import com.projetobiblioteca.GestaoBiblioteca.Dtos.LivroPut.LivroRequestPutDto;
import com.projetobiblioteca.GestaoBiblioteca.Model.LivroModel;
import com.projetobiblioteca.GestaoBiblioteca.Repository.AutorRepository;
import com.projetobiblioteca.GestaoBiblioteca.Repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    LivroRepository livroRepository;
    AutorRepository autorRepository;

    public LivrosController(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    @PostMapping("/criarlivros")
    public ResponseEntity<LivroResponseDto> criarLivro(@RequestBody LivroDto livroDto) {
        return autorRepository.findById(livroDto.idAutor()).map(autor -> {
            LivroModel model = new LivroModel();
            model.setTitulo(livroDto.titulo());
            model.setAutor(autor);

            livroRepository.save(model);

            LivroResponseDto resDto = new LivroResponseDto(model.getTitulo(), model.getId(), model.getAutor().getId());

            return ResponseEntity.ok(resDto);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/mostrarLivros")
    public ResponseEntity<List<LivroResponseGetDto>> mostrarLivros() {
        List<LivroModel> listaModel = livroRepository.findAll();

        List<LivroResponseGetDto> resDto = listaModel.stream().map(livro -> new LivroResponseGetDto(livro)).toList();

        return ResponseEntity.ok().body(resDto);

    }

    @PutMapping("/editarlivros/{id}")
    public ResponseEntity<LivroResponseGetDto> ediatrLivro(@PathVariable UUID id, @RequestBody LivroRequestPutDto dto) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(dto.titulo());
            livroRepository.save(livro);
            LivroResponseGetDto resDto = new LivroResponseGetDto(livro);
            return ResponseEntity.ok().body(resDto);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletarLivros/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable UUID id) {
        return livroRepository.findById(id).map(livro -> {
            livroRepository.delete(livro);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
