package vmtec.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Acao {
	
	//Método responsável por fazer o acesso dos colaboradores
	public Colaborador acessaColaborador(String email, String senha) {
		Connection con = Conexao.obterConexao();
		Colaborador colaborador = null;
		String sql = "SELECT * FROM login WHERE usuarioEmail=? AND usuarioSenha=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, email);
			preparador.setString(2, senha);
			
			ResultSet resultado = preparador.executeQuery();
			if(resultado.next()) {
				colaborador = new Colaborador();
				colaborador.setCodigo(resultado.getInt("usuarioID"));
				colaborador.setNome(resultado.getString("usuarioNome"));
				colaborador.setEmail(resultado.getString("usuarioEmail"));
				colaborador.setSenha(resultado.getString("usuarioSenha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return colaborador;
	}
	
	//Método responsável por cadastrar o colaborador da empresa
	public void cadastraColaborador(Colaborador colaborador) {
		
		//Abrindo conexão com banco de dados
		Connection con = Conexao.obterConexao();
		
		//String de comando para inserir no banco de dados
		String sql = "INSERT INTO login(usuarioNome,usuarioEmail,usuarioSenha) VALUES(?,?,?)";
		
		try {
			//Preparando a linha de instrução
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, colaborador.getNome());
			preparador.setString(2, colaborador.getEmail());
			preparador.setString(3, colaborador.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Colaborador cadastrado com Sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar Colaborador");
			e.printStackTrace();
		}
	}
	
	//Método responsável por cadastrar o Cliente
	public void cadastraCliente(Cliente cliente) {
		Connection con = Conexao.obterConexao();
		String sql = "INSERT INTO cliente(clienteNome,clienteEmail,clienteNascimento,clienteCelular,clienteCPF) VALUES(?,?,?,?,?)";		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getEmail());
			preparador.setDate(3, cliente.getNascimento());
			preparador.setString(4, cliente.getCelular());
			preparador.setString(5, cliente.getCpf());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cliente cadastrado com Sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar Cliente");
			e.printStackTrace();
		}
	}
	
	//Método responsável por cadastrar a compra para estoque
	public void cadastraCompra(Compra compra) {
		Connection con = Conexao.obterConexao();			
		String sql = "INSERT INTO compra(compraProduto,compraQtd,compraFornecedor,compraDate,compraValorProduto,produto_produtoID) VALUES(?,?,?,?,?,?)";		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, compra.getProduto());
			preparador.setInt(2, compra.getQuantidade());
			preparador.setString(3, compra.getFornecedor());
			preparador.setDate(4, compra.getData());
			preparador.setDouble(5, compra.getValorProduto());
			preparador.setInt(6, compra.getProdutoID());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Compra para Estoque cadastrada com Sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar Compra");
			e.printStackTrace();
		}
	}
	
	//Método responsável por mostrar as Compras
	public List<Compra> mostraCompras(){
		Connection con = Conexao.obterConexao();
		List<Compra> compras = new ArrayList<>();
		String sql = "SELECT * FROM compra";		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Compra compra = new Compra();
				compra.setCompraID(resultado.getInt("compraID"));
				compra.setProduto(resultado.getString("compraProduto"));
				compra.setQuantidade(resultado.getInt("compraQtd"));
				compra.setFornecedor(resultado.getString("compraFornecedor"));
				compra.setData(resultado.getDate("compraDate"));
				compra.setValorProduto(resultado.getDouble("compraValorProduto"));
				compra.setProdutoID(resultado.getInt("produto_produtoID"));
				
				compras.add(compra);
			}
			
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return compras;
	}
	
	//Método responsável por cadastrar Produto
	public void cadastraProduto(Produto produto) {
		Connection con = Conexao.obterConexao();				
		String sql = "INSERT INTO produto(produtoNome,produtoTipo,produtoPreco,produtoQtdEstoque) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, produto.getNome());
			preparador.setString(2, produto.getTipo());
			preparador.setDouble(3, produto.getPreco());
			preparador.setInt(4, produto.getQtdEstoque());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Produto cadastrado com Sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar novo Produto");
			e.printStackTrace();
		}
	}
	
	//Método reponsável por mostrar produto por ID
	public Produto mostraPorID(int id) {
		Connection con = Conexao.obterConexao();
		String sql = "SELECT * FROM produto WHERE produtoID = ?";
		Produto produto = null;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				produto = new Produto();
				produto.setProdutoID(resultado.getInt("produtoID"));
				produto.setNome(resultado.getString("produtoNome"));
				produto.setTipo(resultado.getString("produtoTipo"));
				produto.setPreco(resultado.getDouble("produtoPreco"));
				produto.setQtdEstoque(resultado.getInt("produtoQtdEstoque"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produto;
	}
	
	//Método responsável mostrar todos os produtos
	public List<Produto> mostraProdutos() {
		Connection con = Conexao.obterConexao();
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produto";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Produto produto = new Produto();
				produto.setProdutoID(resultado.getInt("produtoID"));
				produto.setNome(resultado.getString("produtoNome"));
				produto.setTipo(resultado.getString("produtoTipo"));
				produto.setPreco(resultado.getDouble("produtoPreco"));
				produto.setQtdEstoque(resultado.getInt("produtoQtdEstoque"));
				
				produtos.add(produto);
			}
			
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	} 
	
	//Método responsável por editar Produto
	public void alterarProduto(Produto produto) {
		Connection con = Conexao.obterConexao();
		String sql = "UPDATE produto SET produtoNome=?, produtoTipo=?, produtoPreco=?, produtoQtdEstoque=? WHERE produtoID=?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, produto.getNome());
			preparador.setString(2, produto.getTipo());
			preparador.setDouble(3, produto.getPreco());
			preparador.setInt(4, produto.getQtdEstoque());
			preparador.setInt(5, produto.getProdutoID());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("O Produto foi alterado com Sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao alterar Produto");
			e.printStackTrace();
		}
	}
	
	//Método responsável por excluir Produto
	public void excluirProduto(int codigo) {
		Connection con = Conexao.obterConexao();
		String sql = "DELETE FROM produto WHERE produtoID=? ";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			preparador.execute();
			preparador.close();
			System.out.println("Produto excluido com Sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao excluir Produto");
			e.printStackTrace();
		}
	}
	
	//Método responsável mostrar Venda
	public List<Venda> mostraVendas() {
		Connection con = Conexao.obterConexao();
		List<Venda> vendas = new ArrayList<>();
		String sql = "SELECT * FROM venda";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Venda venda = new Venda();
				venda.setVendaID(resultado.getInt("vendaID"));
				venda.setData(resultado.getDate("vendaData"));
				venda.setTotal(resultado.getFloat("vendaTotal"));
				venda.setClienteID(resultado.getInt("cliente_clienteID"));
				venda.setProdutoID(resultado.getInt("produto_produtoID"));
				
				vendas.add(venda);
			}
			
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendas;
	}
	
	//Método responsável por pegar ID da venda
	public DetalhesVenda detalhePorID(int venda) {
		Connection con = Conexao.obterConexao();
		String sql = "SELECT c.clienteNome,c.clienteEmail,c.clienteCelular,p.produtoNome,v.vendaData,v.vendaTotal FROM cliente c INNER JOIN venda v ON c.clienteID = v.cliente_clienteID INNER JOIN produto p ON v.produto_produtoID = p.produtoID WHERE vendaID = ?";
		DetalhesVenda detalhe = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, venda);
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				detalhe = new DetalhesVenda();
				detalhe.setCliente(resultado.getString("c.clienteNome"));
				detalhe.setEmail(resultado.getString("c.clienteEmail"));
				detalhe.setCelular(resultado.getString("c.clienteCelular"));
				detalhe.setProduto(resultado.getString("p.produtoNome"));
				detalhe.setData(resultado.getDate("v.vendaData"));
				detalhe.setTotal(resultado.getFloat("vendaTotal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detalhe;
	}

	//Método responsável mostrar detalhes da venda
	public void mostraDetalhesVendas(DetalhesVenda detalhe) {
		Connection con = Conexao.obterConexao();
		String sql = "SELECT c.clienteNome,c.clienteEmail,c.clienteCelular,p.produtoNome,v.vendaData,v.vendaTotal FROM cliente c INNER JOIN venda v ON c.clienteID = v.cliente_clienteID INNER JOIN produto p ON v.produto_produtoID = p.produtoID WHERE vendaID = ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);		
			preparador.setString(1, detalhe.getCliente());
			preparador.setString(2, detalhe.getEmail());
			preparador.setString(3, detalhe.getCelular());
			preparador.setString(4, detalhe.getProduto());
			preparador.setDate(5, detalhe.getData());
			preparador.setFloat(6, detalhe.getTotal());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

}

