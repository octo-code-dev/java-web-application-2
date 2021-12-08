<%-- 
    Document   : listagem
    Created on : 29/09/2015, 03:15:23
    Author     : erich
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formatacao.css"/>
        <title>Lista de Atores</title>
    </head>
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
    <body>
        <h1>Lista de Atores</h1>
        <a href="${pageContext.request.contextPath}/formularios/ator/novo.jsp"><button>Novo</button></a><br/><br/>
        <table>
            <thead>
                <tr>
                    <th>Alterar</th>
                    <th>Excluir</th>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Data de estreia</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="locacaodvds.servicos.AtorServices"/>
                <c:forEach items="${servicos.todos}" var="ator">
                    <tr>
                        <td><a  href="${pageContext.request.contextPath}/atoresServlet?acao=prepAlteracao&id=${ator.id}"><button>Alterar</button></a></td>
                        <td><a href="${pageContext.request.contextPath}/atoresServlet?acao=prepExclusao&id=${ator.id}"><button>Excluir</button></a></td>
                        <td>${ator.id}</td>
                        <td>${ator.nome}</td>
                        <td>${ator.sobrenome}</td>
                        <fmt:formatDate pattern="dd/MM/yyyy" scope="page" var="data" value="${ator.data_de_estreia}"/>
                        <td>${data}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <footer>
            <h4>Desenvolvido por Erich Bonisch Neto</h4>
        </footer>
    </body>
</html>
