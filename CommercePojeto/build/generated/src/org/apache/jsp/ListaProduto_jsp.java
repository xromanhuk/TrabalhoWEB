package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import br.com.DAO.ProdutoDAO;
import br.com.controller.LoginController;

public final class ListaProduto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 if (LoginController.estaLogado(request)) { 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Listagem de Produtos</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/heroic-features.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <h1 style=\"text-align: center\"> <span class=\" label label-primary\">Roma´s</span></h1>\n");
      out.write("            <ul class=\"nav navbar-nav\">\n");
      out.write("                <li class=\"active\"><a href=\"#\">Lista de Produtos</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <div style=\"position: absolute;right: 15%;\">\n");
      out.write("            <button type=\"submit\" class=\"btn btn-default btn-lg\" onclick=\"location.href = 'CadastroProduto.jsp'\">\n");
      out.write("                <span class=\"glyphicon glyphicon-file\" aria-hidden=\"true\"></span> Cadastrar Produto\n");
      out.write("            </button>\n");
      out.write("        </div>\n");
      out.write("        <br/>\n");
      out.write("        <div class=\"panel panel-primary\" style=\"position: absolute;margin-top: 3%;width:70%;left: 15%;\">\n");
      out.write("            <div class=\"panel-heading\">Cadastro de Produto</div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("                <table class=\"table table-bordered\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Descrição</th> <th>Informação</th> <th>Valor</th> <th>Alterar</th><th>Deletar</th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        ProdutoDAO prod = new ProdutoDAO();
                        ResultSet rst = prod.consultaGeral();
                        while (rst.next()) {
                            String id = rst.getString("id_produto");
                            String desc = rst.getString("ds_produto");
                            String info = rst.getString("ds_informacao");
                            String valor = rst.getString("vl_produto");

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            ");
      out.print( desc);
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
      out.print( info);
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
      out.print( valor);
      out.write("\n");
      out.write("                        </td> \n");
      out.write("                        <td> \n");
      out.write("                            <a href=\"CadastroProduto.jsp?id=");
      out.print( id);
      out.write("\"/> <button type=\"submit\" class=\"btn btn-default btn-lg\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-wrench\" aria-hidden=\"true\"></span>\n");
      out.write("                            </button>\n");
      out.write("                        </td>\n");
      out.write("                        <td> \n");
      out.write("                            <a href=\"ServletProduto?id=");
      out.print( id);
      out.write("\"/> <button type=\"submit\" class=\"btn btn-default btn-lg\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-trash\" aria-hidden=\"true\"></span>\n");
      out.write("                            </button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
 } else {
        response.sendRedirect("Senha.jsp");
    }

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
