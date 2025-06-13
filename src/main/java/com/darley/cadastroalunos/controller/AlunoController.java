package com.darley.cadastroalunos.controller;

import com.darley.cadastroalunos.model.Aluno;
import com.darley.cadastroalunos.repository.AlunoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
