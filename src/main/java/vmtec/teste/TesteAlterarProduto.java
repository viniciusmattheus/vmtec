package vmtec.teste;

import vmtec.modelo.Acao;
import vmtec.modelo.Produto;

public class TesteAlterarProduto {

	public static void main(String[] args) {

		Produto produto = new Produto();
		produto.setProdutoID(6);
		produto.setNome("AOC Hero 27");
		produto.setTipo("monitor");
		produto.setPreco(1.049);
		produto.setQtdEstoque(3);
		
		Acao altera = new Acao();
		altera.alterarProduto(produto);
	}
}
