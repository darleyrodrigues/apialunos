package com.darley.cadastroalunos.controller;

import com.darley.cadastroalunos.model.Aluno;
import com.darley.cadastroalunos.repository.AlunoRepository;
import com.darley.cadastroalunos.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping("{id}")
    public Aluno buscarPorId(@PathVariable ("id") UUID id){
        return alunoService.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable ("id") UUID id){
        alunoService.deletar(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") UUID id,
                           @RequestBody Aluno aluno){
        alunoService.atualizar(id, aluno);
    }

    @GetMapping
    public List<Aluno> listarTodos(){
        return alunoService.listarTodos();
    }
}