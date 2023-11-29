package vmtec.teste;

import vmtec.modelo.Acao;
import vmtec.modelo.Produto;

public class TesteCadastraProduto {

	public static void main(String[] args) {
		
		//Criando objeto
		Produto produto = new Produto("ELG F80N", "Suporte", 179.00, 10);
		
		Acao cadastra = new Acao();
		cadastra.cadastraProduto(produto);
	}
}
