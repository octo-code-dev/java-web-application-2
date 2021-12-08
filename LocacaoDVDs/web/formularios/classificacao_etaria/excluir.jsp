<%-- 
    Document   : excluir
    Created on : 29/09/2015, 02:53:56
    Author     : erich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formatacao.css"/>
        <title>Excluir Classificação Etária</title>
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
        <h1>Excluir Classificação Etária</h1>

        <form method="post" action="${pageContext.request.contextPath}/classificacoesEtariasServlet">

            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.classificacaoEtaria.id}"/>

            <table>
                <tr>
                    <td>Descrição:</td>
                    <td>${requestScope.classificacaoEtaria.descricao}</td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/formularios/classificacao_etaria/listagem.jsp"><button>Voltar</button></a></td>
                    <td><input type="submit" value="Excluir"/></td>
                </tr>
            </table>
        </form>
        <footer>
            <h4>Desenvolvido por Erich Bonisch Neto</h4>
        </footer>
    </body>
</html>
