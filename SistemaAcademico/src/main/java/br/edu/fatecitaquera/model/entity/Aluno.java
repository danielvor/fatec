package br.edu.fatecitaquera.model.entity;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// JAVABEAN
@Entity
@Table(name="tb_aluno")
public class Aluno {
	// atributos
	// ra >> autoincremento
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ra;
	@Column(name="nome_aluno")
	private String nome;
	private String email;
	private Date dataNascimento;
	private String endereco;
	private String periodo;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(int ra, String nome, String email, Date dataNascimento, String endereco, String periodo) {
		this.ra = ra;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.periodo = periodo;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}
