package br.com.app;

import br.com.controller.LoginController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xroma
 */
public class ServletLogin extends HttpServlet {

    public static boolean erro = false;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        if (LoginController.login(usuario, senha)) {
            response.addCookie(LoginController.getCookie("usuario", usuario));
            response.addCookie(LoginController.getCookie("senha", senha));

            String acao = request.getParameter("tem");
            if (acao.equals("nao")) {
                response.sendRedirect("CarrinhoCompra.jsp");
            } else {
                response.sendRedirect("CadastroProduto.jsp");
            }

        } else {
            erro = true;
            response.sendRedirect("senha.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
