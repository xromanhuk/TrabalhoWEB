package br.com.app;

import br.com.DAO.ItemPedidoDAO;
import br.com.DAO.PedidoDAO;
import br.com.DAO.UsuarioDAO;
import br.com.modelo.ItemPedido;
import br.com.modelo.Pedido;
import br.com.modelo.Produto;
import br.com.modelo.Usuario;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xroma
 */
public class ServletPedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookie[] = request.getCookies();
        Boolean achou = false;
        for (int i = 0; i < cookie.length; i++) {
            if (cookie[i].getName().equals("usuario") || cookie[i].getName().equals("senha")) {
                achou = true;
            }
        }

        if (achou == false) {

            response.sendRedirect("Senha.jsp?tem=nao");

        } else {

            Cookie[] cookies = request.getCookies();
            String nome      = cookies[1].getValue();
            String senha     = cookies[2].getValue();
            
            ItemPedidoDAO itemDAO = new ItemPedidoDAO();
            PedidoDAO pedidoDAO   = new PedidoDAO();
            UsuarioDAO us         = new UsuarioDAO();
            Pedido pedido         = new Pedido();
            ItemPedido item       = new ItemPedido();
            Usuario usuario       = new Usuario();

            try {
                ResultSet rst = us.consultaUsuario(nome);
                while (rst.next()) {
                    pedido.setId_usuario(rst.getInt("id"));
                }
                //Inserio o pedido e id do usuario
                pedidoDAO.inserirPedido(pedido);
            } catch (SQLException ex) {

            }

            try {
                ResultSet rst = pedidoDAO.ultimaSeq();
                while (rst.next()) {
                    pedido.setId(rst.getInt("MAX"));
                }
            } catch (SQLException ex) {

            }

            HttpSession sessao = request.getSession();
            ArrayList<Produto> produtos = (ArrayList) sessao.getAttribute("produto");
            //inseri o item do pedido
            for (Produto p : produtos) {
                item.setId_pedido(pedido.getId());
                item.setId_produto(p.getId_produto());
                item.setQuantidade(p.getQtd());
                item.setVl_produto(p.getVl_produto());
                itemDAO.inserirProduto(item);
            }

            response.sendRedirect("CarrinhoCompra.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
