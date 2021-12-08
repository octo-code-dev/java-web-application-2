<%-- 
    Document   : listagem
    Created on : 29/09/2015, 03:06:48
    Author     : erich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formatacao.css"/>
        <title>Lista de Gêneros</title>
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
        <h1>Lista de Gêneros</h1>
        <a href="${pageContext.request.contextPath}/formularios/genero/novo.jsp"><button>Novo</button></a><br/><br/>
        <table>
            <thead>
                <tr>
                    <th>Alterar</th>
                    <th>Excluir</th>
                    <th>ID</th>
                    <th>Descrição</th>
                </tr>
            </thead>
            <tbody>
                <jsp:useBean id="servicos" scope="page" class="locacaodvds.servicos.GeneroServices"/>
                <c:forEach items="${servicos.todos}" var="genero">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/generosServlet?acao=prepAlteracao&id=${genero.id}"><button>Alterar</button></a></td>
                        <td><a href="${pageContext.request.contextPath}/generosServlet?acao=prepExclusao&id=${genero.id}"><button>Excluir</button></a></td>
                        <td>${genero.id}</td>
                        <td>${genero.descricao}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <footer>
            <h4>Desenvolvido por Erich Bonisch Neto</h4>
        </footer>
    </body>
</html>
