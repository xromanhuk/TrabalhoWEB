<%-- 
    Document   : CarrinhoCompra
    Created on : 17/10/2016, 20:36:58
    Author     : xroma
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.modelo.Produto"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.DAO.ProdutoDAO"%>
<%@ page import="br.com.controller.LoginController" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho de Compra</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/heroic-features.css" rel="stylesheet">
    </head>
    <body>

        <div class="panel panel-primary" style="position: absolute;margin-top: 3%;width:70%;left: 15%;">
            <div class="panel-heading">Carrinho de Compra</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <%
                        HttpSession sessao = request.getSession();
                        ArrayList<Produto> produtos = (ArrayList) sessao.getAttribute("produto");
                    %>
                    <tr>
                        <th>Descrição</th> <th>Informação</th> <th>Valor</th> <th>Quantidade</th> <th>SubTotal</th><th>Remover</th>
                    </tr>
                    <%
                        for (Produto p : produtos) {
                    %>
                    <tr>
                        <td> <%= p.getDs_produto()%></td>
                        <td> <%= p.getDs_informacao()%></td>
                        <td> <%= p.getVl_produto()%></td> 
                        <td> <%= p.getQtd()%></td> 
                        <td> <%= p.getVl_produto() * p.getQtd()%></td> 
                        <td> 
                            <a href="ServletProdutoList?acao=remov&id=<%= p.getId_produto()%>" /> <button type="submit" class="btn btn-default btn-lg">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                        </td>
                    </tr>
                    <% }%>
                </table>
            </div>
            <div style="position: absolute;right: 0%; margin-top: 2%;">
                <a href="ServletPedido"/> <button type="submit" class="btn btn-default btn-lg"/>
                <span class="glyphicon glyphicon-file" aria-hidden="true"></span> Finalizar Compra
                </button>
            </div>
        </div>
    </body>
</html>
<!--onclick="location.href = 'Senha.jsp?id=0'"-->