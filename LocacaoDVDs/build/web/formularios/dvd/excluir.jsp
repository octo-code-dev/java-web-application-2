<%-- 
    Document   : excluir
    Created on : 29/09/2015, 02:58:20
    Author     : erich
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formatacao.css"/>
        <title>Excluir DVD</title>
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
        
        <h1>Excluir DVD</h1>

        <form method="post" action="${pageContext.request.contextPath}/dVDsServlet">

            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.dvd.id}"/>

            <table>
                <tr>
                    <td>Título:</td>
                    <td>${requestScope.dvd.titulo}</td>
                </tr>
                <tr>
                    <td>Ano de lançamento:</td>
                    <td>${requestScope.dvd.ano_de_lancamento}</td>
                </tr>
                <tr>
                    <td>Ator principal:</td>
                    <td>${requestScope.dvd.ator_principal_id.id}</td>
                </tr>
                <tr>
                    <td>Ator coadjuvante:</td>
                    <td>${requestScope.dvd.ator_coadjuvante_id.id}</td>
                </tr>
                <tr>
                    <td>Data de lançamento:</td>
                    <fmt:formatDate pattern="dd/MM/yyyy" scope="page" value="${requestScope.dvd.data_de_lancamento}" var="data_de_lancamento"/>
                    <td>${data_de_lancamento}</td>
                </tr>
                <tr>
                    <td>Duração em minutos:</td>
                    <td>${requestScope.dvd.duracao_em_minutos}</td>
                </tr>
                <tr>
                    <td>Gênero:</td>
                    <td>${requestScope.dvd.genero_id.id}</td>
                </tr>
                <tr>
                    <td>Classificação Etária:</td>
                    <td>${requestScope.dvd.classificacao_etaria_id.id}</td>
                </tr>
                <tr>
                    <td><a href="formularios/dvd/listagem.jsp"><button>Voltar</button></a></td>
                    <td><input type="submit" value="Excluir"</td>
                </tr>
            </table>
        </form>
        <footer>
            <h4>Desenvolvido por Erich Bonisch Neto</h4>
        </footer>
    </body>
</html>
