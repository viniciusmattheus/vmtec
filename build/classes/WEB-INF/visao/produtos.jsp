<%@page import="vmtec.modelo.Colaborador"%>
<%@page import="java.util.List"%>
<%@page import="vmtec.modelo.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VM Tec - Produtos</title>

<style>
* {
	margin: 0;
	padding: 0;
}

body{
	background-image: linear-gradient(89deg, #5F9EA0, #F5F5F5);
	font-family: Arial;
}

section{
	position: fixed;
	top: 0;
	left: 0;
	width: 95%;
	padding: 5px 25px;
	background-color: #F5F5F5;
	display: flex;
	justify-content: space-between;
	align-items: center;
	/*flex-direction: column;*/
	z-index: 100;
}

.logo{
	background-image: linear-gradient(89deg, #F5F5F5, #5F9EA0);
	font-size: 32px;
	padding: 10px;
	border-radius: 20px;
	color: #000000;
	text-decoration: none;
	font-weight: 500;
}

nav{
	margin-top: 57px;
	display: flex;
	justify-content: center;
	align-items: center;
}

div{
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 20px;
}

button{
	background-color: #5F9EA0;
	border: none;
	margin: 2px;
	padding: 10px;
	border-radius: 10px;
	color: #fff;
	font-size: 15px;
	cursor: pointer;
}

button:hover{
	background-color: #008B8B;
}

table{
	background-color: rgba(0, 0, 0, 0.7);
	color: #fff;
	width: 90%;
	border-radius: 15px 15px 0 0;
}

td{
	text-align: center;
	padding: 5px;
}

tr{
	border: 1px solid #fff;
}

.acao{
	background-color: #5F9EA0;
	border: none;
	padding: 5px;
	border-radius: 10px;
	color: #000000;
	font-size: 15px;
	cursor: pointer;
	text-decoration: none;
}

.acao:hover{
	background-color: #008B8B;
}

.sair{
	color: #000000;
	text-decoration: none;
	padding: 10px;
	border-radius: 10px;
}

.sair:hover{
	background-color: #bd2113;
}

</style>

</head>
<body>

	<%
	//Está pegando a sessao que já está criada
	HttpSession sessao = request.getSession();
	//Pegando da sessao o aluno logado
	Colaborador colaboradorLogado = (Colaborador)sessao.getAttribute("colaboradorLogado");
	
	List<Produto> produtos = (List<Produto>)request.getAttribute("listadeprodutos");
	%>
	
	<header>
		<section>
			<a href="entrada?acao=produtos" class="logo">VM Tec</a>
			<p>Olá <%=colaboradorLogado.getNome() %></p>
			<a href="entrada?acao=logout" class="sair">Sair do Sistema</a>		
		</section>
		
		<nav>
			<a href="entrada?acao=formcadastraproduto"><button>Cadastrar Produto</button></a>
			<a href="entrada?acao=formcompras"><button>Compras Fornecedor</button></a>
			<a href="entrada?acao=formvendas"><button>Vendas Cliente</button></a>		
		</nav>		
	</header>
	<div>
		<table>
			<thead>
				<tr>
					<th>ID<hr></th>
					<th>Produto<hr></th>
					<th>Tipo<hr></th>
					<th>Preço<hr></th>
					<th>Qtd em Estoque<hr></th>			
					<th colspan="2">Ação<hr></th>
				</tr>
			</thead>			
			<tbody>
				<%for(Produto produto:produtos) {%>
					<tr>
						<td><%=produto.getProdutoID() %></td>
						<td><%=produto.getNome() %></td>
						<td><%=produto.getTipo() %></td>
						<td><%=produto.getPreco() %></td>
						<td><%=produto.getQtdEstoque() %></td>
						<td><a href="entrada?acao=mostraporid&id=<%=produto.getProdutoID() %>" class="acao">Alterar</a></td>
						<td><a href="entrada?acao=excluirporid&id=<%=produto.getProdutoID() %>" class="acao">Excluir</a></td>
					</tr>
				<%}%>
			</tbody>			
		</table>
	</div>
</body>
</html>