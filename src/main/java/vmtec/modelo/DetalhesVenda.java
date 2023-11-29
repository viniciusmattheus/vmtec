package vmtec.modelo;

import java.sql.Date;

public class DetalhesVenda {
	
	public DetalhesVenda() {}
	
	public DetalhesVenda(String cliente, String email, String celular, String produto, Date data, Float total) {
		this.cliente = cliente;
		this.email = email;
		this.celular = celular;
		this.produto = produto;
		this.data = data;
		this.total = total;
	}
	private String cliente;
	private String email;
	private String celular;
	private String produto;
	private Date data;
	private Float total;
	
	@Override
	public String toString() {
		return "Detalhes: [cliente=" + cliente + ", email=" + email + ", celular=" + celular 
				+ ", produto=" + produto + ", data=" + data + ", total= " + total + "]";
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCliente() {
		return cliente;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCelular() {
		return celular;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getProduto() {
		return produto;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getData() {
		return data;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Float getTotal() {
		return total;
	}
}
