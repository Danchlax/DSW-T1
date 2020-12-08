<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">   
        <script>
            $(function () {
                
                $("#cidade").autocomplete({
                    select: function (event, ui) {
                        var url_string = window.location.href;
                        var url = url_string.split('?', 1);
                        $(window.document.location).attr('href', url[0]+"?cidade="+ui.item.value);
                    },
                    source: "buscaPorNome",
                    minLength: 2
                });
            });
        </script>
        <title>Hoteis</title>
    </head>
    <body>
 

        <div align="center">

            <div class="ui-widget">
                <label for="cidade">Buscar por Cidade</label>
                <input id="cidade" name="cidade" placeholder="Digite o nome da cidade">
            </div>
        <br/>
	<div align="center">
		<table border="1">
			<caption>Lista de Hoteis</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cep</th>
				<th>Logradouro</th>
				<th>Número</th>
				<th>Bairro</th>
				<th>Cidade</th>
                                <th>UF</th>
			</tr>
			<c:forEach var="hotel" items="${requestScope.listaHoteis}">
				<tr>
					<td>${hotel.id}</td>
					<td>${hotel.nome}</td>
					<td>${hotel.cep}</td>
					<td>${hotel.logradouro}</td>
					<td>${hotel.numero}</td>
					<td>${hotel.bairro}</td>
					<td>${hotel.cidade.nome}</td>
                                        <td>${hotel.cidade.estado.sigla}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
        <br/>
        <a href="index.jsp">Voltar</a>
</body>
</html>