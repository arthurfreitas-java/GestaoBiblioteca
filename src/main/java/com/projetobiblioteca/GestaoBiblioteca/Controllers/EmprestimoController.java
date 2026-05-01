package com.projetobiblioteca.GestaoBiblioteca.Controllers;

import com.projetobiblioteca.GestaoBiblioteca.Dtos.EmprestimoDto.EmprestimoRequestDto;
import com.projetobiblioteca.GestaoBiblioteca.Dtos.EmprestimoDto.EmprestimoResponseDto;
import com.projetobiblioteca.GestaoBiblioteca.Model.EmprestimoModel;
import com.projetobiblioteca.GestaoBiblioteca.Model.LivroModel;
import com.projetobiblioteca.GestaoBiblioteca.Repository.EmprestimoRepository;
import com.projetobiblioteca.GestaoBiblioteca.Repository.LivroRepository;
import com.projetobiblioteca.GestaoBiblioteca.Service.ServiceEmprestimo;
import org.hibernate.engine.spi.EntityEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    EmprestimoRepository emprestimoRepository;
    ServiceEmprestimo serviceEmprestimo;
    LivroRepository livroRepository;

    public EmprestimoController(EmprestimoRepository emprestimoRepository, ServiceEmprestimo serviceEmprestimo, LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.serviceEmprestimo = serviceEmprestimo;
        this.livroRepository = livroRepository;
    }

    @PostMapping("/criarEmprestimo")
    public ResponseEntity<?> criarEmprestimo(@RequestBody EmprestimoRequestDto dto) {
        EmprestimoModel model = new EmprestimoModel();
        LivroModel modelL = new LivroModel();

        model.setLivroId(dto.LivroId());
        model.setDataEmprestimo(LocalDate.now());
        model.dataEmprestimoVencimento(model.getDataEmprestimo());

        ServiceEmprestimo service = new ServiceEmprestimo();

        Boolean resService = service.LivroPego(model.getDataEmprestimo(), model.getDataEmprestimoVencimento());

        if (resService == true) {
            model.setPego(true);

            if (modelL.getPego() == true) {
                return ResponseEntity.badRequest().build();
            } else {
                return livroRepository.findById(dto.LivroId()).map(livro -> {
                    modelL.setPego(model.getPego());

                    emprestimoRepository.save(model);

                    EmprestimoResponseDto resDto = new EmprestimoResponseDto(model);

                    return ResponseEntity.ok(resDto);
                }).orElse(ResponseEntity.notFound().build());
            }

        } else {
            model.setPego(false);
            return ResponseEntity.noContent().build();
        }
    }
}
