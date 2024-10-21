package br.edu.fatecitaquera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecitaquera.models.entity.Aluno;
import br.edu.fatecitaquera.models.repository.AlunoRepository;

@RestController
public class AlunoController {
	
	/* ENDPOINTS
	 * GET		/api/alunos		--listAll()
	 * GET		/api/alunos/1 	--getById()
	 * POST		/api/alunos		--insert()
	 * PUT		/api/alunos/1	--update()
	 * DELETE	/api/alunos/1	--delete()
	 * 
	 */
	
	// injeção de dependência
	@Autowired
	private AlunoRepository alunoRepository;
	
	// listar todos
	@GetMapping("/api/alunos")
	public List listAll() {
		return alunoRepository.findAll();
	}
	
	// consultar por Id
	@GetMapping("/api/alunos/{id}")
	public Aluno getById(@PathVariable("id") Integer id) {
		Aluno aluno = alunoRepository.findById(id).get();
		return aluno;
	}
	//consultar pelo Nome
	@GetMapping("/api/alunos/nome/{nome}")
	public Aluno getByNome(@PathVariable("nome") String nome) {
		Aluno aluno =  alunoRepository.findByNome (nome);
		return aluno;
	}
	//consultar pelo primeiro nome

	@GetMapping("/api/alunos/primeiro-nome/{nome}")
	public Aluno getByPrimeiroNome(@PathVariable("nome") String nome) {
		Aluno aluno =  alunoRepository.findByNomeStartsWith (nome);
		return aluno;
	}
	
	//consultar pelo ultimo nome

	@GetMapping("/api/alunos/ultimo-nome/{nome}")
	public Aluno getByUltimoNome(@PathVariable("nome") String nome) {
		Aluno aluno =  alunoRepository.findByNomeEndsWith (nome);
		return aluno;
	}
	//consultar por qualquer nome
	@GetMapping("/api/alunos/qualquer-nome/{nome}")
	public Aluno getByQualquerNome(@PathVariable("nome") String nome) {
		Aluno aluno =  alunoRepository.findByNomeContains (nome);
		return aluno;
	}
	// apagar
	@DeleteMapping("/api/alunos/{id}")
	public String delete(@PathVariable("id") Integer id) {
		alunoRepository.deleteById(id);
		return "Excluído com sucesso";
	}
	
	// incluir
	@PostMapping("/api/alunos")
	public Aluno insert(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	// alterar
	@PutMapping("/api/alunos/{id}")
	public Aluno update(@RequestBody Aluno aluno, @PathVariable("id") Integer id) {
		Aluno alunoUpdate = alunoRepository.findById(id).get();
		alunoUpdate.setNome(aluno.getNome());
		alunoUpdate.setEmail(aluno.getEmail());
		alunoUpdate.setEndereco(aluno.getEndereco());
		alunoUpdate.setDataNascimento(aluno.getDataNascimento());
		alunoUpdate.setPeriodo(aluno.getPeriodo());
		return alunoRepository.save(alunoUpdate);
	}
	
	
	@GetMapping("/")
	public String index() {
		return "<h1>Alou </h1>";
	}
	
}
