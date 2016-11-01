<%@page import="br.com.controller.FilterProduto"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="br.com.DAO.ProdutoDAO"%>
<%@ page import="br.com.controller.LoginController" %>
<!--LoginController.estaLogado(request)-->
<% if (LoginController.estaLogado(request)) { %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produto</title>
        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/custom.css">
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <h1 style="text-align: center"> <span class=" label label-primary">Roma´s</span></h1>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Cadastro de Produto</a></li>
                <li><a href="ListaProduto.jsp">Listagem de Produtos</a></li>
            </ul>
        </nav>
        <%
            String ds = "";
            String inf = "";
            String vl = "";
            String id = "";
            String metod = "post";
            String cod = request.getParameter("id");
            if (cod != null && !cod.equals("")) {
                ProdutoDAO p = new ProdutoDAO();

                int chave = Integer.parseInt(request.getParameter("id"));
                ResultSet result = p.consultaCodigo(chave);

                id = Integer.toString(chave);

                result.first();
                ds = result.getString("ds_produto");
                inf = result.getString("ds_informacao");
                vl = result.getString("vl_produto");

                metod = "get";
            }
        %>
        <div class="panel panel-primary" style="position: absolute;margin-top: 3%;width:70%;left: 15%;">
            <div class="panel-heading">Produto</div>
            <div class="panel-body">
                <form  action="ServletProdutoSalvar" method="<%= metod%>">
                    <input type="hidden" value="<%= id%>" name="id">
                    <div class="form-group">
                        <label>Nome do Produto</label>
                        <input type="text" class="form-control" name="nome" value="<%= ds%>" placeholder="Nome do Produto"><!--required="" autofocus=""-->
                    </div>
                    <div class="form-group">
                        <label>Descrição do produto</label>
                        <input type="text" class="form-control" name="descricao" value="<%= inf%>" placeholder="Descrição"><!--required="" autofocus=""-->
                    </div>
                    <div class="form-group">
                        <label>Valor do Produto</label>
                        <input type="text" class="form-control" name="valor" value="<%= vl%>" placeholder="Valor do Produto"><!--required="" autofocus=""-->
                    </div>
                    <button type="submit" class="btn btn-default">Gravar</button>
                </form>
            </div>
            <% if (request.getAttribute("errMsg") != null && !request.getAttribute("errMsg").equals("")) {%>
            <div class="alert alert-danger">
                <strong></strong> <%= request.getAttribute("errMsg")%>
            </div>
            <% } %>
        </div>

    </body>
</html>

<% } else {
        response.sendRedirect("senha.jsp");
    }
%>
