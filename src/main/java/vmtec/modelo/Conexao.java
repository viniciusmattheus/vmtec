package vmtec.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Método responsável pela conexão com banco de dados.
 * Usando as API's que fazem parte da biblioteca JDK(Java Development Kit).
*/
public class Conexao {
	
	public static Connection obterConexao() {
		Connection con = null;
		try {
			//DriverManager gerencia uma lista de drivers de banco de dados.
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/vmtec","root","root");
			System.out.println("Banco de Dados conectado com sucesso!");
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Não foi possível conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		
		return con;	
	}
}
