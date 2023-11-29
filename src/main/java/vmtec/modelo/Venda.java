package vmtec.modelo;

import java.sql.Date;

public class Venda {
	
	private Integer vendaID;
	private Date data;
	private Float total;
	private Integer clienteID;
	private Integer produtoID;
	
	@Override
	public String toString() {
		return "Venda [id=" + vendaID + ", data=" + data + ", total=" + total
				+ ", clienteID=" + clienteID + ", produtoID=" + produtoID + "]";
	}
	public void setVendaID(int vendaID) {
		this.vendaID = vendaID;
	}
	public Integer getVendaID() {
		return vendaID;
	}
	public void setData(Date data){
		this.data = data;
	}
	public Date getData() {
		return data;
	}
	public void setTotal(float total){
		this.total =  total;
	}
	public Float getTotal() {
		return total;
	}
	public void setClienteID(int clienteID){
		this.clienteID = clienteID;
	}
	public Integer getClienteID() {
		return clienteID;
	}
	public void setProdutoID(int produtoID){
		this.produtoID = produtoID;
	}
	public Integer getProdutoID() {
		return produtoID;
	}

}
