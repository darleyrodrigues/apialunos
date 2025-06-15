package com.darley.cadastroalunos.service;

import com.darley.cadastroalunos.model.Aluno;
import com.darley.cadastroalunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno buscarPorId(UUID id){
        return alunoRepository.findById(id).orElse(null);
    }

    public void deletar(UUID id){
        alunoRepository.deleteById(id);
    }

    public void atualizar(UUID id, Aluno aluno){
        aluno.setId(id);
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }
}
