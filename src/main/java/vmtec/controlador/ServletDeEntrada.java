package vmtec.controlador;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vmtec.modelo.Acao;
import vmtec.modelo.Colaborador;
import vmtec.modelo.Compra;
import vmtec.modelo.DetalhesVenda;
import vmtec.modelo.Produto;
import vmtec.modelo.Venda;

/**
 * Servlet implementation class ServletDeEntrada
 */

@WebServlet("/entrada")
public class ServletDeEntrada extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Captura a ação do usuário
		String acao = request.getParameter("acao");
		
		//Seção de login
		HttpSession sessao = request.getSession();
		
		//Autenticação e autorização
		Boolean colaboradorNaoLogado = sessao.getAttribute("colaboradorLogado") == null;
		Boolean paginaProtegida = !(acao.equals("login") || acao.equals("formlogin") || acao.equals("formcolaborador") || acao.equals("cadastracolaborador"));
		
		
		if(colaboradorNaoLogado && paginaProtegida) {
			response.sendRedirect("Http://localhost:8080/vmtec/entrada?acao=formlogin");
			return;
		}
		
		if(acao.equals("login")) {
			String login = request.getParameter("txtlogin");
			String senha = request.getParameter("txtsenha");
			
			Acao acessa = new Acao();
			Colaborador colaborador = acessa.acessaColaborador(login, senha); 
			
			if(colaborador != null) {
				sessao = request.getSession();
				sessao.setAttribute("colaboradorLogado", colaborador);
				response.sendRedirect("Http://localhost:8080/vmtec/entrada?acao=produtos");
			} else {
				response.sendRedirect("Http://localhost:8080/vmtec/entrada?acao=formlogin");
			}
		}else if(acao.equals("formcolaborador")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visao/cadastracolaborador.jsp");
			dispatcher.forward(request, response);
		}else if(acao.equals("cadastracolaborador")) {
			String nomecola = request.getParameter("txtnome");
			String emailcola = request.getParameter("txtemail");
			String senhacola = request.getParameter("txtsenha");
			
			Colaborador colaborador = new Colaborador(nomecola, emailcola, senhacola);
			Acao novo = new Acao();
			
			novo.cadastraColaborador(colaborador);
			
			response.sendRedirect("Http://localhost:8080/vmtec/entrada?acao=formlogin");
		}
		
		if(acao.equals("formlogin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visao/login.jsp");
			dispatcher.forward(request, response);
		}else if(acao.equals("produtos")) {		//mostrar dados do banco na página web (Redirecionamento Server Side)
			Acao mostra = new Acao();
			List<Produto> produtos = mostra.mostraProdutos();
			
			request.setAttribute("listadeprodutos", produtos); //atribuindo a requisição a lista de produtos
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visao/produtos.jsp");
			dispatcher.forward(request, response);
		}else if(acao.equals("formcadastraproduto")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visao/cadastraproduto.jsp");
			dispatcher.forward(request, response);	
		}else if(acao.equals("cadastraproduto")) {
			String nome = request.getParameter("txtnome");
			String tipo = request.getParameter("txttipo");
			double preco = Double.parseDouble(request.getParameter("txtpreco"));
			int quantidadeEstoque = Integer.parseInt(request.getParameter("txtestoque"));
			
			Produto produto = new Produto(nome, tipo, preco, quantidadeEstoque);
			
			Acao cadastra = new Acao();
			cadastra.cadastraProduto(produto);
			
			response.sendRedirect("Http://localhost:8080/vmtec/entrada?acao=produtos");
		}else if(acao.equals("mostraporid")) {
			Integer codigo = Integer.parseInt(request.getParameter("id"));
			
			Acao mostra = new Acao();
			Produto produto = mostra.mostraPorID(codigo);
			
			request.setAttribute("produto", produto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visao/alteraproduto.jsp");
			dispatcher.forward(request, response);			
		}else if(acao.equals("alteraproduto")) {
			Integer codigo = Integer.parseInt(request.getParameter("txtid"));
			String nome = request.getParameter("txtnome");
			String tipo = request.getParameter("txttipo");
			Double preco = Double.parseDouble(request.getParameter("txtpreco"));
			Integer quantidadeEstoque = Integer.parseInt(request.getParameter("txtestoque"));
			
			Produto produto = new Produto(codigo, nome, tipo, preco, quantidadeEstoque);
			Acao altera = new Acao();
			altera.alterarProduto(produto);
			
			response.sendRedirect("Http://localhost:8080/vmtec/entrada?acao=produtos");
		}else if(acao.equals("excluirporid")) {
			Integer codigo = Integer.parseInt(request.getParameter("id"));
			
			Acao excluir = new Acao();
			excluir.excluirProduto(codigo);
			
			response.sendRedirect("Http://localhost:8080/vmtec/entrada?acao=produtos");
		}else if(acao.equals("formcompras")) {
			Acao mostra = new Acao();
			List<Compra> compras = mostra.mostraCompras();
			
			request.setAttribute("listadecompras", compras);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visao/comprasfornecedor.jsp");
			dispatcher.forward(request, response); 
		}else if(acao.equals("formvendas")) {
			Acao mostra = new Acao();
			List<Venda> vendas = mostra.mostraVendas();
			
			request.setAttribute("listadevendas", vendas);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visao/vendascliente.jsp");
			dispatcher.forward(request, response); 
		}else if(acao.equals("detalhevenda")) {
			Integer codigo = Integer.parseInt(request.getParameter("id"));
			
			Acao mostra = new Acao();
			DetalhesVenda venda = mostra.detalhePorID(codigo);
			
			request.setAttribute("detalhe", venda);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/visao/detalhevenda.jsp");
			dispatcher.forward(request, response);
		}else if(acao.equals("detalhevenda")) {
			String cliente = request.getParameter("txtcliente");
			String email = request.getParameter("txtemail");
			String celular = request.getParameter("txtcelular");
			String produto = request.getParameter("txtproduto");
			Date data = Date.valueOf(request.getParameter("txtestoque"));
			Float total = Float.parseFloat(request.getParameter("txttotal"));
			
			DetalhesVenda detalhe = new DetalhesVenda(cliente, email, celular, produto, data, total);
			Acao mostra = new Acao();
			mostra.mostraDetalhesVendas(detalhe);
		}else if(acao.equals("logout")) {
			sessao.invalidate();
			response.sendRedirect("Http://localhost:8080/vmtec/entrada?acao=formlogin");
		}	
	}
}
