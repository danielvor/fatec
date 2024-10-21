package br.edu.fatecitaquera.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecitaquera.models.entity.Aluno;

// O que é uma Interface? Ela não tem implementação, ela indica o que implementar. É um contrato.

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	public Aluno findByNome(String nome);
	
	public Aluno findByNomeStartsWith(String nome);
	
	public Aluno findByNomeEndsWith(String nome);
	
	public Aluno findByNomeContains(String nome);
}
