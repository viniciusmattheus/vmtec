package vmtec.teste;

import vmtec.modelo.Acao;
import vmtec.modelo.Colaborador;

public class TesteCadastraColaborador {

	public static void main(String[] args) {
		
		Colaborador colaborador = new Colaborador("Marcelo Fontana","marcelofontana@vmtec.com.br","marcelo123");
		
		Acao cadastra = new Acao();
		cadastra.cadastraColaborador(colaborador);
	}

}
