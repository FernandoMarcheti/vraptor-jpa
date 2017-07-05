<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link href="<c:url value='/css/bootstrap.css'/>" type="text/css" rel="stylesheet" />
    	<link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Título</title>
	</head>
	<body>
		<header>
		</header>
		<nav>
			<ul class="nav nav-tabs">
				<li><a href="<c:url value='/'/>"> Home </a></li>
				<li><a href="<c:url value='/usuario/lista'/>"> Usuários </a></li>
				<li><a href="<c:url value='/horalancada/lista'/>"> Horas Cadastradas</a></li>
				<li><a href="<c:url value='/horalancada/form'/>">Cadastrar Horas</a></li>
				
				<c:choose >
					<c:when test="${usuarioLogado.isLogado()}">
						<li><a href="<c:url value='/horalancada/relatorioDeHoras'/>">Relatório de Horas</a></li>
						<li><a href="<c:url value='/login/deslogar'/>">Sair</a></li>
					</c:when>
				</c:choose>
			</ul>
		</nav>
		<div class="container">
			<main class="col-sm-8">
						
