<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VM Tec - Cadastra Colaborador</title>

<style>

*{
	margin: 0;
	padding: 0;
}

body{
	background-image: linear-gradient(89deg, #5F9EA0, #F5F5F5);
	font-family: Arial;
	font-size: 12px;
}

div{
	background-color: rgba(0, 0, 0, 0.5);
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	padding: 60px;
	border-radius: 15px;
	color: #fff;
}

input{
	padding: 10px;
	border: none;
	outline: none;
	font-size: 15px;
	width: 100%;
}

.btn{
	background-color: #5F9EA0;
	border: none;
	padding: 10px;
	width: 100%;
	border-radius: 10px;
	color: #fff;
	font-size: 15px;
	cursor: pointer;
	text-decoration:none;
}

.btn:hover{
	background-color: #008B8B;
}

</style>

</head>
<body>

	<header>
		<section>
			<a href="#" class="logo">.</a>
		</section>
	</header>
	
	<form action="entrada" method="post">
		<div>
			<h1>Cadastrar Colaborador</h1><br><br>
			<p>Nome:</p>
			<input type="text" name="txtnome"><br><br>
			<p>Email:</p>
			<input type="text" name="txtemail" placeholder="Use: @vmtec.com.br"><br><br>
			<p>Senha:</p>
			<input type="password" name="txtsenha" placeholder="Máximo 10 caracteres"><br><br>
			
			<input type="submit" value="Salvar Colaborador" class="btn">
			<input type="hidden" name="acao" value="cadastracolaborador">		
		</div>
	</form>	

</body>
</html>