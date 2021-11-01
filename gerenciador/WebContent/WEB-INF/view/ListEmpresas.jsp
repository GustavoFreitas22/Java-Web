<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List, com.freitas.dev.model.Empresa"  %>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <c:url value="/entrada" var="linkRemove"></c:url>
    <c:url value="/entrada" var="linkEdita"></c:url>
    <c:url value="/entrada?acao=Logout" var="LinkSair"></c:url>
    
<!DOCTYPE html>
<html>
<head>
<!-- Meta tags Obrigatórias -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">



<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.min.css"
	rel="stylesheet" />
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>

<meta charset="ISO-8859-1">
<title>List Java</title>
</head>
<body>

User: ${userLogado.login}

<br>
<br> 

<h1>Lista de empresas:</h1>

<ul>
	<c:forEach items="${empresas}" var="empresa">
	
		<li> ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>-<a href="${linkRemove}?acao=RemoveEmpresa&id=${empresa.id}">Remover / </a><a href="${linkEdita}?acao=MostraEmpresa&id=${empresa.id}">Editar</a></li>
	</c:forEach>
</ul>

<br>
<br>

<a href="${LinkSair}">Sair</a>

</body>
</html>