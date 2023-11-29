package vmtec.teste;



import java.sql.Date;

import vmtec.modelo.Acao;
import vmtec.modelo.Cliente;

public class TesteCadastraCliente {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("Rosangela", "rosangela@gmail.com", new Date(1978-05-19), "1140028922", "XXXXXXXXX");
		
		Acao cadastra = new Acao();
		cadastra.cadastraCliente(cliente);
	}
}
