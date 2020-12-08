<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">   
        <title>Promoções do Hotel</title>
    </head>
    <body>
 

        <div align="center">

            <h1>Bem vindo ${requestScope.hotel.nome}</h1>
        <br/>
	<div align="center">
		<table border="1">
			<caption>Promoções de Quartos Cadastradas</caption>
			<tr>
				<th>Descrição do Quarto</th>
				<th>Valor</th>
				<th>Data Inicial</th>
				<th>Data Final</th>
				<th>Site</th>
				<th>URL</th>
			</tr>
			<c:forEach var="promocao" items="${requestScope.listaPromocao}">
				<tr>
					<td>${promocao.quarto}</td>
					<td>${promocao.valor}</td>
					<td>${promocao.dataInicial}</td>
					<td>${promocao.dataFinal}</td>
					<td>${promocao.site.nome}</td>
					<td>${promocao.site.url}</td>
                                        
				</tr>
			</c:forEach>
		</table>
	</div>
        <br/>
        <a href="index.jsp">Voltar</a>
</body>
</html>