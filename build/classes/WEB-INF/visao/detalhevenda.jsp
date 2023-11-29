<%@page import="vmtec.modelo.Colaborador"%>
<%@page import="vmtec.modelo.DetalhesVenda"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VM Tec - Detalhe Venda</title>

<style type="text/css">
*{
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


h1{
	display: flex;
	justify-content: center;
	align-itens: center;
}

div{
	background-color: rgba(0, 0, 0, 0.5);
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	padding: 20px;
	border-radius: 15px;
	color: #fff;
}

input{
	padding: 10px;
	border: none;
	outline: none;
	font-size: 15px;
	width: 90%;
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

	<% 	//Está pegando a sessao que já está criada
		HttpSession sessao = request.getSession();
		//Pegando da sessao o aluno logado
		Colaborador colaboradorLogado = (Colaborador)sessao.getAttribute("colaboradorLogado");
		
		DetalhesVenda detalhes = (DetalhesVenda)request.getAttribute("detalhe");
	%>
	<header>
		<section>
			<a href="entrada?acao=produtos" class="logo">VM Tec</a>
			<p>Olá <%=colaboradorLogado.getNome() %></p>
			<a href="entrada?acao=logout" class="sair">Sair do Sistema</a>		
		</section>
		
		<nav>
			<a href="entrada?acao=produtos"><button>Produtos</button></a>
			<a href="entrada?acao=formcadastraproduto"><button>Cadastrar Produto</button></a>
			<a href="entrada?acao=formcompras"><button>Compras Fornecedor</button></a>
			<a href="entrada?acao=formvendas"><button>Vendas Cliente</button></a>		
		</nav>		
	</header>
	
	<form action="entrada" method="post">
		<div>
			<h1>Detalhes da Compra</h1><br>
			Cliente: <input type="text" name="txtcliente" value="<%=detalhes.getCliente() %>" readonly><br><br>
			Email: <input type="text" name="txtemail" value="<%=detalhes.getEmail() %>" readonly><br><br>
			Celular: <input type="text" name="txtcelular" value="<%=detalhes.getCelular() %>" readonly><br><br>
			Produto Comprador: <input type="text" name="txtproduto" value="<%=detalhes.getProduto() %>" readonly><br><br>
			Data da Compra: <input type="text" name="txtdata" value="<%=detalhes.getData() %>" readonly><br><br>
			Total da Compra: <input type="text" name="txttotal" value="<%=detalhes.getTotal() %>" readonly><br><br>
		</div>
	</form>

</body>
</html>