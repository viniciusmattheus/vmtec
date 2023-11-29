package vmtec.teste;

import vmtec.modelo.Acao;
import vmtec.modelo.Colaborador;

public class TesteAcessaColaborador {

	public static void main(String[] args) {

		Acao acessa = new Acao();
		Colaborador colaborador = acessa.acessaColaborador("viniciusmatheus@vmtec.com.br", "vini271097");
		
		System.out.println(colaborador);

	}

}
