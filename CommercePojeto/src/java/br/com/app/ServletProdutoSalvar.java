package br.com.app;

import br.com.DAO.ProdutoDAO;
import br.com.modelo.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xroma
 */
public class ServletProdutoSalvar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String desc = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));

        Produto prd = new Produto();
        ProdutoDAO daoprod = new ProdutoDAO();

        prd.setId_produto(id);
        prd.setDs_produto(nome);
        prd.setDs_informacao(desc);
        prd.setVl_produto(valor);

        daoprod.alterarProduto(prd);
        response.sendRedirect("ListaProduto.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String desc = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));

        Produto prd = new Produto();
        ProdutoDAO daoprod = new ProdutoDAO();

        prd.setDs_produto(nome);
        prd.setDs_informacao(desc);
        prd.setVl_produto(valor);

        daoprod.inserirProduto(prd);
        response.sendRedirect("ListaProduto.jsp");

    }

}
