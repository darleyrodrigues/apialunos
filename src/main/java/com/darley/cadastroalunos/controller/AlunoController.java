package com.darley.cadastroalunos.controller;

import com.darley.cadastroalunos.model.Aluno;
import com.darley.cadastroalunos.repository.AlunoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @DeleteMapping("{id}")
    public void deletar(@PathVariable ("id") UUID id){
        alunoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") UUID id,
                           @RequestBody Aluno aluno){
        aluno.setId(id);
        alunoRepository.save(aluno);
    }

    @GetMapping
    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }
}