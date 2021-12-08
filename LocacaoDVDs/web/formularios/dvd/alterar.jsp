<%-- 
    Document   : alterar
    Created on : 29/09/2015, 02:27:12
    Author     : erich
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formatacao.css"/>
        <title>Alterar DVD</title>
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
        
        <h1>Alterar DVD</h1>

        <form method="post" action="${pageContext.request.contextPath}/dVDsServlet">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.dvd.id}"/>

            <table>
                <tr>
                    <td>Título:</td>
                    <td><input name="titulo" type="text" size="50" value="${requestScope.dvd.titulo}"/></td>
                </tr>
                <tr>
                    <td>Ano de lançamento:</td>
                    <td><input name="ano_de_lancamento" type="text" size="10" value="${requestScope.dvd.ano_de_lancamento}"/></td>
                </tr>
                <tr>
                    <td>Ator principal:</td>
                    <td>
                        <jsp:useBean id="ator_principal_id_services" scope="page" class="locacaodvds.servicos.AtorServices"/>
                        <select name="ator_principal_id">
                            <c:forEach items="${ator_principal_id_services.todos}" var="atorp">
                                <c:choose>
                                    <c:when test="${requestScope.dvd.ator_principal_id.id eq atorp.id}">
                                        <option value="${atorp.id}" selected="true">${atorp.id} - ${atorp.nome} ${atorp.sobrenome}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${atorp.id}">${atorp.id} - ${atorp.nome} ${atorp.sobrenome}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Ator coadjuvante:</td>
                    <td>
                        <jsp:useBean id="ator_coadjuvante_id_services" scope="page" class="locacaodvds.servicos.AtorServices"/>
                        <select name="ator_coadjuvante_id">
                            <c:forEach items="${ator_coadjuvante_id_services.todos}" var="atorc">
                                <c:choose>
                                    <c:when test="${requestScope.dvd.ator_coadjuvante_id.id eq atorc.id}">
                                        <option value="${atorc.id}" selected="true">${atorc.id} - ${atorc.nome} ${atorc.sobrenome}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${atorc.id}">${atorc.id} - ${atorc.nome} ${atorc.sobrenome}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Data de lançamento:</td>
                    <fmt:formatDate pattern="dd/MM/yyyy" scope="page" value="${requestScope.dvd.data_de_lancamento}" var="data"/>
                    <td><input name="data_de_lancamento" type="text" size="25" value="${data}"/></td>
                </tr>
                <tr>
                    <td>Duração em minutos:</td>
                    <td><input name="duracao_em_minutos" type="text" size="10" value="${requestScope.dvd.duracao_em_minutos}"/></td>
                </tr>
                <tr>
                    <td>Gênero:</td>
                    <td>
                        <jsp:useBean id="genero_id_servicos" scope="page" class="locacaodvds.servicos.GeneroServices"/>
                        <select name="genero_id">
                            <c:forEach items="${genero_id_servicos.todos}" var="genero">
                                <c:choose>
                                    <c:when test="${requestScope.dvd.genero_id.id eq genero.id}">
                                        <option value="${genero.id}" selected="true">${genero.id} - ${genero.descricao}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${genero.id}">${genero.id} - ${genero.descricao}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Classificação Etária:</td>
                    <td>
                        <jsp:useBean id="classificacao_etaria_services" scope="page" class="locacaodvds.servicos.ClassificacaoEtariaServices"/>
                        <select name="classificacao_etaria_id">
                            <c:forEach items="${classificacao_etaria_services.todos}" var="classificacao">
                                <c:choose>
                                    <c:when test="${requestScope.dvd.classificacao_etaria_id.id eq classificacao_etaria.id}">
                                        <option value="${classificacao_etaria.id}" selected="true">${classificacao.id} - ${classificacao.descricao}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${classificacao.id}">${classificacao.id} - ${classificacao.descricao}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><a href="formularios/dvd/listagem.jsp"><button>Voltar</button></a></td>
                    <td><input type="submit" value="Alterar"/></td>
                </tr>
            </table>
        </form>
        <footer>
            <h4>Desenvolvido por Erich Bonisch Neto</h4>
        </footer>
    </body>
</html>
