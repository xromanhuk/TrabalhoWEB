<%-- 
    Document   : index
    Created on : 24/10/2016, 19:38:25
    Author     : xroma
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.DAO.ProdutoDAO"%>
<%@ page import="br.com.controller.LoginController" %>
<%-- LoginController.estaLogado(request)--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/heroic-features.css" rel="stylesheet">
    </head>
    <body>
        <Form method="post" action="ServletProdutoList">
            <div class="col-lg-6" style="position: absolute;right: 15%;margin-top: 5%;">
                <div class="input-group">

                    <input type="text" class="form-control" name="pesq" placeholder="Search for...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">Pesquisar!</button>
                    </span>

                </div>
            </div>
        </form>
        <div class="panel panel-primary" style="position: absolute;margin-top: 3%;width:70%;left: 15%;margin-top: 8%">
            <div class="panel-heading">Carrinho de Compra</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <tr>
                        <th>Descrição</th> <th>Informação</th> <th>Valor</th> <th>Selecione o Produto</th>
                    </tr>
                    <%
                        ResultSet rst = null;
                        ProdutoDAO prod = new ProdutoDAO();
                        if (request.getParameter("acao") == null || request.getParameter("acao").equals(null)) {
                            rst = prod.consultaGeral();
                        } else {
                            rst = (ResultSet) request.getAttribute("consulta");
                        }
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
                            <a href="ServletProdutoList?acao=add&id=<%= id%>&descricao=<%= desc%>&informacao=<%= info%>&valor=<%= valor%>"/> <button type="submit" class="btn btn-default btn-lg" style="background-color:#AB82FF">
                                <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true">
                                    Comprar
                                </span>
                            </button>
                        </td>
                    </tr>
                    <% }%>
                </table>
            </div>
        </div>
    </body>
</html>