package vmtec.modelo;

public class Colaborador {
	//Construtor
	
	public Colaborador() {}
	
	public Colaborador(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	//Atributos
	private Integer codigo;
	private String nome;
	private String email;
	private String senha;
	
	@Override
	public String toString() {
		return "Colaborador [id=" + codigo + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
	//Getters e Setters
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
