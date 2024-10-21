package br.edu.fatecitaquera.controller.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.fatecitaquera.models.entity.Aluno;
import br.edu.fatecitaquera.models.repository.AlunoRepository;

@Controller
@RequestMapping("/alunos")
public class AlunoWebController {
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping("/list")
	public String listAll(Model model) {
		List<Aluno> aluno = alunoRepository.findAll();
		model.addAttribute("alunos", aluno);
		return "list";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteCliente(@PathVariable Integer id) {
		Optional<Aluno> alunoDelete = alunoRepository.findById(id);
		if (alunoDelete.isPresent()) 
			alunoRepository.deleteById(id);
		
		return "redirect:/alunos/list";
	}

}
