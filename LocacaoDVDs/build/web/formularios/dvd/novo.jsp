<%-- 
    Document   : novo
    Created on : 29/09/2015, 01:08:20
    Author     : erich
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formatacao.css"/>
        <title>Novo DVD</title>
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

        <h1>Criar DVD</h1>

        <form method="post" action="${pageContext.request.contextPath}/dVDsServlet">

            <input name="acao" type="hidden" value="criar"/>

            <table>
                <tr>
                    <td>Título:</td>
                    <td><input name="titulo" type="text" size="50"/></td>
                </tr>
                <tr>
                    <td>Ano de lançamento:</td>
                    <td><input name="ano_de_lancamento" type="text" size="50"/></td>
                </tr>
                <tr>
                    <td>Ator principal:</td>
                    <td>
                        <jsp:useBean id="ator_principal_services" scope="page" class="locacaodvds.servicos.AtorServices"/>
                        <select name="ator_principal_id">
                            <c:forEach items="${ator_principal_services.todos}" var="atorp">
                                <option value="${atorp.id}">${atorp.id} - ${atorp.nome} ${atorp.sobrenome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Ator coadjuvante:</td>
                    <td>
                        <jsp:useBean id="ator_coadjuvante_services" scope="page" class="locacaodvds.servicos.AtorServices"/>
                        <select name="ator_coadjuvante_id">
                            <c:forEach items="${ator_coadjuvante_services.todos}" var="atorc">
                                <option value="${atorc.id}">${atorc.id} - ${atorc.nome} ${atorc.sobrenome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Data de lançamento:</td>
                    <td><input name="data_de_lancamento" type="text" size="50"/></td>
                </tr>
                <tr>
                    <td>Duração em minutos:</td>
                    <td><input name="duracao_em_minutos" type="text" size="50"/></td>
                </tr>
                <tr>
                    <td>Gênero:</td>
                    <td>
                        <jsp:useBean id="genero_services" scope="page" class="locacaodvds.servicos.GeneroServices"/>
                        <select name="genero_id">
                            <c:forEach items="${genero_services.todos}" var="genero">
                                <option value="${genero.id}">${genero.id} - ${genero.descricao}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Classificação Etária:</td>
                    <td>
                        <jsp:useBean id="classificacao_etaria_services" scope="page" class="locacaodvds.servicos.ClassificacaoEtariaServices"/>
                        <select name="classificacao_etaria_id">
                            <c:forEach items="${classificacao_etaria_services.todos}" var="classificacao_etaria">
                                <option value="${classificacao_etaria.id}">${classificacao_etaria.id} - ${classificacao_etaria.descricao}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><a href="listagem.jsp"><button>Voltar</button></a></td>
                    <td><input type="submit" value="Criar"</td>
                </tr>
            </table>
        </form>
                        <!--
        <footer>
            <h4>Desenvolvido por Erich Bonisch Neto</h4>
        </footer>
                        -->
    </body>
</html>
