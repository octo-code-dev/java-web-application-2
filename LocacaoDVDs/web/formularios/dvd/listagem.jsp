<%-- 
    Document   : listagem
    Created on : 29/09/2015, 03:18:46
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
        <title>Lista de DVDs</title>
    </head>
    <body>
        <header>
            <img src="${pageContext.request.contextPath}/images/DVD.svg">
            <span>Cadastro de DVDs</span>
        </header>
        <nav>
            <a class="btn" href="${pageContext.request.contextPath}/index.jsp">Página Inicial</a>
            <a class="btn" href="${pageContext.request.contextPath}/formularios/genero/listagem.jsp">Gênero</a>
            <a class="btn" href="${pageContext.request.contextPath}/formularios/classificacao_etaria/listagem.jsp">Classificação Etária</a>
            <a class="btn" href="${pageContext.request.contextPath}/formularios/ator/listagem.jsp">Ator</a>
            <a class="btn" href="${pageContext.request.contextPath}/formularios/dvd/listagem.jsp">DVD</a>
        </nav>
        <main>
        <h1>Lista de DVDs</h1>
        <a href="${pageContext.request.contextPath}/formularios/dvd/novo.jsp"><button>Novo</button></a><br/><br/>
        <table>
            <thead>
                <tr>
                    <th>Alterar</th>
                    <th>Excluir</th>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Ano de lançamento</th>
                    <th>Ator principal</th>
                    <th>Ator coadjuvante</th>
                    <th>Data de lançamento</th>
                    <th>Duração em minutos</th>
                    <th>Gênero</th>
                    <th>Classificação Etária</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="locacaodvds.servicos.DVDServices"/>
                <c:forEach items="${servicos.todos}" var="dvd">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/dVDsServlet?acao=prepAlteracao&id=${dvd.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/dVDsServlet?acao=prepExclusao&id=${dvd.id}">Excluir</a></td>
                        <td>${dvd.id}</td>
                        <td>${dvd.titulo}</td>
                        <td>${dvd.ano_de_lancamento}</td>
                        <td>${dvd.ator_principal_id.nome} ${dvd.ator_principal_id.sobrenome}</td>
                        <td>${dvd.ator_coadjuvante_id.nome} ${dvd.ator_coadjuvante_id.sobrenome}</td>
                        <fmt:formatDate pattern="dd/MM/yyyy" scope="page" var="data_de_lancamento" value="${dvd.data_de_lancamento}"/>
                        <td>${data_de_lancamento}</td>
                        <td>${dvd.duracao_em_minutos}</td>
                        <td>${dvd.genero_id.descricao}</td>
                        <td><div class="classificacao-etaria">${dvd.classificacao_etaria_id.descricao}</div></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </main>
        <footer>
            <div class="footer-email">
                <strong>Enter your email address</strong>
                <input type="text" value="Email address">
                <button>Subscribe</button>
            </div>
            <div class="footer-text">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt distinctio earum repellat quaerat voluptatibus placeat nam, commodi optio pariatur est quia magnam eum harum corrupti dicta, aliquam sequi voluptate quas.
            </div>
            <div class="footer-links">
                <div>
                <h5>Lorem Ipsum</h5>
                <a href="#">Lorem Ipsum</a>
                <a href="#">Lorem Ipsum</a>
                <a href="#">Lorem Ipsum</a>
                </div>
                <div>
                <h5>Lorem Ipsum</h5>
                <a href="#">Lorem Ipsum</a>
                <a href="#">Lorem Ipsum</a>
                <a href="#">Lorem Ipsum</a>
                </div>
                <div>
                <h5>Lorem Ipsum</h5>
                <a href="#">Lorem Ipsum</a>
                <a href="#">Lorem Ipsum</a>
                <a href="#">Lorem Ipsum</a>
                </div>
                <div>
                <h5>Lorem Ipsum</h5>
                <a href="#">Lorem Ipsum</a>
                <a href="#">Lorem Ipsum</a>
                <a href="#">Lorem Ipsum</a>
                </div>
            </div>
            <div class="copyright">
                <span>&copy; 2021 DVDs Enterprise</span>
            </div>
        </footer>
    </body>
</html>
