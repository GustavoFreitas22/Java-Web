<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%> <!-- Import do JSTL -->
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/> <!-- Configura��o para contexto dinamico -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="${linkServletNovaEmpresa}" method="post">

        Nome: <input type="text" name="nome"  />
        Data Abertura: <input type="text" name="dataAbertura"  />

        <input type="submit" />
    </form>

</body>
</html>