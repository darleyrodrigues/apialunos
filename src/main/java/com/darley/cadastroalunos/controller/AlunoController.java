package com.darley.cadastroalunos.controller;

import com.darley.cadastroalunos.model.Aluno;
import com.darley.cadastroalunos.repository.AlunoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }

    @GetMapping("{id}")
    public Aluno buscarPorId(@PathVariable ("id") UUID id){
        return alunoRepository.findById(id).orElse(null);
    }
}
