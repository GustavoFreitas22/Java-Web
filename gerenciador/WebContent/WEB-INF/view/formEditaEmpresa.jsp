<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


	
       <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet" />
   <link href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.min.css" rel="stylesheet" />
   <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
	
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



 
   <form action="${linkEntradaServlet }" method="post">

        Nome: <input type="text" name="nome" value="${empresa.nome }" />
        Data Abertura: <input type="text" name="data"  value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
        <input type="hidden" name="id" value="${empresa.id }">
        <input type="hidden" name="acao" value="AlteraEmpresa">
        <input type="submit" />
    </form>

    

</body>
</html>