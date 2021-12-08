<%-- 
    Document   : alterar
    Created on : 29/09/2015, 02:20:17
    Author     : erich
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formatacao.css"/>
        <title>Alterar Ator</title>
    </head>
    <body>
        <header>
            <h1>Cadastro de DVDs</h1>
        </header>
        <nav>
            <a class="btn" href="${pageContext.request.contextPath}/index.jsp">Página Inicial</a>
            <a class="btn" href="${pageContext.request.contextPath}/formularios/genero/listagem.jsp">Gênero</a>
            <a class="btn" href="${pageContext.request.contextPath}/formularios/classificacao_etaria/listagem.jsp">Classificação Etária</a>
            <a class="btn" href="${pageContext.request.contextPath}/formularios/ator/listagem.jsp">Ator</a>
            <a class="btn" href="${pageContext.request.contextPath}/formularios/dvd/listagem.jsp">DVD</a>
        </nav>


        <form method="post" action="${pageContext.request.contextPath}/atoresServlet">
            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.ator.id}"/>
            <h1>Alterar Ator</h1>                
            <table>
                <tr class="alt">
                    <td>Nome:</td>
                    <td><input name="nome" type="text" size="25" value="${requestScope.ator.nome}"/></td>
                </tr>
                <tr class="alt">
                    <td>Sobrenome:</td>
                    <td><input name="sobrenome" type="text" size="25" value="${requestScope.ator.sobrenome}"/></td>
                </tr>
                <tr class="alt">
                    <td>Data de estreia:</td>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${requestScope.ator.data_de_estreia}" var="data_de_estreia" scope="page"/>
                    <td><input name="data_de_estreia" type="text" size="25" value="${data_de_estreia}"/></td>
                </tr>
                <tr class="alt">
                    <td><a href="${pageContext.request.contextPath}/formularios/ator/listagem.jsp"><button>Voltar</button></a></td>
                    <td><input type="submit" value="Alterar"></td>
                </tr>
            </table>
        </form>
        <footer>
            <h4>Desenvolvido por Erich Bonisch Neto</h4>
        </footer>
    </body>
</html>
