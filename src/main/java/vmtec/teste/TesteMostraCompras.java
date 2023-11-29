package vmtec.teste;

import java.util.List;

import vmtec.modelo.Acao;
import vmtec.modelo.Compra;

public class TesteMostraCompras {

	public static void main(String[] args) {

		Acao mostra = new Acao();
		List<Compra> compras = mostra.mostraCompras();
		
		for(Compra compra:compras)
			System.out.println(compra);
	}
}
