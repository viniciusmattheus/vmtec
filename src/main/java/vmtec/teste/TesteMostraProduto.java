package vmtec.teste;

import java.util.List;

import vmtec.modelo.Acao;
import vmtec.modelo.Produto;

public class TesteMostraProduto {

	public static void main(String[] args) {

		Acao mostra = new Acao();
		List<Produto> produto = mostra.mostraProdutos();
		
		for(Produto produtos:produto) {
			System.out.println(produtos);
		}
	}
}
