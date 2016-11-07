package br.com.app;

import br.com.DAO.ProdutoDAO;
import br.com.modelo.Produto;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xroma
 */
public class ServletProdutoList extends HttpServlet {

    public ArrayList<Produto> produtos = new ArrayList<>();

    ProdutoDAO prodDAO = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        switch (request.getParameter("acao")) {

            case "add":
                Produto p = new Produto();
                p.setQtd(1);
                int id = Integer.parseInt(request.getParameter("id"));
                p.setId_produto(id);
                p.setDs_produto(request.getParameter("descricao"));
                p.setDs_informacao(request.getParameter("informacao"));
                p.setVl_produto(Double.parseDouble(request.getParameter("id")));

                boolean add = true;
                for (Produto produto : produtos) {
                    if (id == produto.getId_produto()) {
                        produto.setQtd(produto.getQtd() + 1);
                        add = false;
                    }
                }

                if (add) {
                    produtos.add(p);
                }

                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("produto", produtos);
                response.sendRedirect("CarrinhoCompra.jsp");

                break;

            case "remov":
                try {
                    int idprd = Integer.parseInt(request.getParameter("id"));
                    for (Produto prod : produtos) {
                        if (idprd == prod.getId_produto()) {
                            produtos.remove(prod);
                        }
                    }
                } catch (Exception e) {

                }
                response.sendRedirect("CarrinhoCompra.jsp");

                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ResultSet res = prodDAO.consultaDescricao(request.getParameter("pesq"));

        request.setAttribute("consulta", res);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp?acao=pesq");
        rd.forward(request, response);
    }

}
