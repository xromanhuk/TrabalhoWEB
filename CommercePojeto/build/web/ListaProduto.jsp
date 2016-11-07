<%-- 
    Document   : ListarProdutos
    Created on : 17/10/2016, 20:35:28
    Author     : xroma
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.DAO.ProdutoDAO"%>
<%@ page import="br.com.controller.LoginController" %>

<% if (LoginController.estaLogado(request)) { %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Produtos</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/heroic-features.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <h1 style="text-align: center"> <span class=" label label-primary">Roma´s</span></h1>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Lista de Produtos</a></li>
            </ul>
        </nav>
        <div style="position: absolute;right: 15%;">
            <button type="submit" class="btn btn-default btn-lg" onclick="location.href = 'CadastroProduto.jsp'">
                <span class="glyphicon glyphicon-file" aria-hidden="true"></span> Cadastrar Produto
            </button>
        </div>
        <br/>
        <div class="panel panel-primary" style="position: absolute;margin-top: 3%;width:70%;left: 15%;">
            <div class="panel-heading">Cadastro de Produto</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tr>
                        <th>Descrição</th> <th>Informação</th> <th>Valor</th> <th>Alterar</th><th>Deletar</th>
                    </tr>
                    <%
                        ProdutoDAO prod = new ProdutoDAO();
                        ResultSet rst = prod.consultaGeral();
                        while (rst.next()) {
                            String id = rst.getString("id_produto");
                            String desc = rst.getString("ds_produto");
                            String info = rst.getString("ds_informacao");
                            String valor = rst.getString("vl_produto");

                    %>
                    <tr>
                        <td>
                            <%= desc%>
                        </td>
                        <td>
                            <%= info%>
                        </td>
                        <td>
                            <%= valor%>
                        </td> 
                        <td> 
                            <a href="CadastroProduto.jsp?id=<%= id%>"/> <button type="submit" class="btn btn-default btn-lg">
                                <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
                            </button>
                        </td>
                        <td> 
                            <a href="ServletProduto?id=<%= id%>"/> <button type="submit" class="btn btn-default btn-lg">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                        </td>
                    </tr>
                    <% }%>
                </table>
            </div>
        </div>
    </body>
</html>
<% } else {
        response.sendRedirect("Senha.jsp");
    }
%>