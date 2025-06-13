package com.darley.cadastroalunos.service;

import com.darley.cadastroalunos.model.Aluno;
import com.darley.cadastroalunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);

    }
}
