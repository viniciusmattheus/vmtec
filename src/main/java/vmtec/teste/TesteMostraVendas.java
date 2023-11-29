package vmtec.teste;

import java.util.List;

import vmtec.modelo.Acao;
import vmtec.modelo.Venda;

public class TesteMostraVendas {

	public static void main(String[] args) {
		
		Acao mostra = new Acao();
		List<Venda> vendas = mostra.mostraVendas();
		
		for(Venda venda:vendas)
			System.out.println(venda);
	}

}
