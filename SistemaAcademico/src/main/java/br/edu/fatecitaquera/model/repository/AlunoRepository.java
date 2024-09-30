package br.edu.fatecitaquera.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecitaquera.model.entity.Aluno;

//O que é interface?
//não tem implementação - é um contrato


public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
