<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VM Tec - Login</title>

<style type="text/css">

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

	<form method="post" action="entrada">
		<div>
			<h1>Login</h1><br><br>
			<input type="text" name="txtlogin" placeholder="Email"><br><br>
			<input type="password" name="txtsenha" placeholder="Senha"><br><br>
			<input type="submit" value="Acessar Sistema" class="btn"><br><br>
			<input type="hidden" name="acao" value="login">
			<a href="entrada?acao=formcolaborador" class="btn">Cadastrar Novo Colaborador</a>
		</div>
	</form>
	
</body>
</html>