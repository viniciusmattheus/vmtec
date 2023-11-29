package vmtec.modelo;

import java.sql.Date;

public class Compra {
	
	public Compra() {}
	
	public Compra(String produto, Integer quantidade, String fornecedor, Date data, Double valorProduto,
			Integer produtoID) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.fornecedor = fornecedor;
		this.data = data;
		this.valorProduto = valorProduto;
		this.produtoID = produtoID;
	}
	
	@Override
	public String toString() {
		return "Compra [id=" + compraID + ", produto=" + produto + ", quantidade=" + quantidade
				+ ", fornecedor=" + fornecedor + ", data=" + data + ", valor do Produto=" + valorProduto
				+ ", ID Produto=" + produtoID + "]";
	}
	
	private Integer compraID;
	private String produto;
	private Integer quantidade;
	private String fornecedor;
	private Date data;
	private Double valorProduto;
	private Integer produtoID;
	
	public void setCompraID(Integer compraID) {
		this.compraID = compraID;
	}
	public Integer getCompraID() {
		return compraID;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public Integer getProdutoID() {
		return produtoID;
	}
	public void setProdutoID(Integer produtoID) {
		this.produtoID = produtoID;
	}
	
	
	

}
