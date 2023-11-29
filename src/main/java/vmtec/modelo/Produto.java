package vmtec.modelo;

public class Produto {
	//Construtor
	public Produto() {}
	
	//Com o atributo id
	public Produto(Integer id, String nome, String tipo, Double preco, Integer quantidade) {
		this.produtoID = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.quantidadeEstoque = quantidade;
	}
	
	//Sem o atributo id
	public Produto(String nome, String tipo, Double preco, Integer quantidade) {
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.quantidadeEstoque = quantidade;
	}
	
	//Atributos
	private Integer produtoID;
	private String nome;
	private String tipo;
	private Double preco;
	private Integer quantidadeEstoque;
	
	@Override
	public String toString() {
		return "Produto [id=" + produtoID + ", nome=" + nome + ", tipo=" + tipo + ", preco=" + preco 
				+ ", quantidadeEstoque" + quantidadeEstoque + "]" ;
	}
	
	//Getters e Setters
	public void setProdutoID(int produtoID) {
		this.produtoID = produtoID;
	}
	public Integer getProdutoID() {
		return this.produtoID;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getPreco() {
		return this.preco;
	}
	
	public void setQtdEstoque(Integer quantidade) {
		this.quantidadeEstoque = quantidade;
	}
	
	public Integer getQtdEstoque() {
		return this.quantidadeEstoque;
	}
}
