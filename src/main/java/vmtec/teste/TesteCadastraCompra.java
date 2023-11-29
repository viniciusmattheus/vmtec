package vmtec.teste;

import java.sql.Date;

import vmtec.modelo.Acao;
import vmtec.modelo.Compra;

public class TesteCadastraCompra {

	public static void main(String[] args) {

		Compra compra = new Compra();
		
		compra.setProduto("Keychron K10 Pro QMK");
		compra.setQuantidade(3);
		compra.setFornecedor("Keychron");
		compra.setData(new Date(2023-10-11));
		compra.setValorProduto(789.50);
		compra.setProdutoID(2);
		
		Acao cadastra = new Acao();
		cadastra.cadastraCompra(compra);
	}
}
