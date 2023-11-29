package vmtec.modelo;

import java.sql.Date;

public class Cliente {
	
	//Construtor
	public Cliente(String nome, String email, Date nascimento, String celular, String cpf) {
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.celular = celular;
		this.cpf = cpf;
	}
	
	//Atributos
	private Integer clienteID;
	private String nome;
	private String email;
	private Date nascimento;
	private String celular;
	private String cpf;
	
	//Getters e Setters
	public Integer getClienteID() {
		return clienteID;
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
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
