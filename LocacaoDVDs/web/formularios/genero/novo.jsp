<%-- 
    Document   : novo
    Created on : 29/09/2015, 00:14:57
    Author     : erich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formatacao.css"/>
        <title>Novo Gênero</title>
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
        <h1>Criar Gênero</h1>
        <form method="post" action="${pageContext.request.contextPath}/generosServlet">

            <input name="acao" type="hidden" value="criar"/>

            <table>
                <tr>
                    <td>Descrição:</td>
                    <td><input name="descricao" type="text" size="20"/></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/formularios/genero/listagem.jsp"><button>Voltar</button></a></td>
                    <td><input type="submit" value="Criar"/></td>
                </tr>
            </table>
        </form>
        <footer>
            <h4>Desenvolvido por Erich Bonisch Neto</h4>
        </footer>
    </body>
</html>
