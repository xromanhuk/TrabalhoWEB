package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.controller.FilterProduto;
import java.sql.ResultSet;
import br.com.DAO.ProdutoDAO;
import br.com.controller.LoginController;

public final class CadastroProduto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--LoginController.estaLogado(request)-->\n");
 if (LoginController.estaLogado(request)) { 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastro de Produto</title>\n");
      out.write("        <!-- CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/reset.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <h1 style=\"text-align: center\"> <span class=\" label label-primary\">Roma´s</span></h1>\n");
      out.write("            <ul class=\"nav navbar-nav\">\n");
      out.write("                <li class=\"active\"><a href=\"#\">Cadastro de Produto</a></li>\n");
      out.write("                <li><a href=\"ListaProduto.jsp\">Listagem de Produtos</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <div class=\"panel panel-primary\" style=\"position: absolute;margin-top: 3%;width:70%;left: 15%;\">\n");
      out.write("            <div class=\"panel-heading\">Produto</div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("                <form  action=\"ServletProdutoSalvar\" method=\"");
      out.print( metod);
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print( id);
      out.write("\" name=\"id\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Nome do Produto</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"nome\" value=\"");
      out.print( ds);
      out.write("\" placeholder=\"Nome do Produto\"><!--required=\"\" autofocus=\"\"-->\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Descrição do produto</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"descricao\" value=\"");
      out.print( inf);
      out.write("\" placeholder=\"Descrição\"><!--required=\"\" autofocus=\"\"-->\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>Valor do Produto</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"valor\" value=\"");
      out.print( vl);
      out.write("\" placeholder=\"Valor do Produto\"><!--required=\"\" autofocus=\"\"-->\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-default\">Gravar</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            ");
 if (request.getAttribute("errMsg") != null && !request.getAttribute("errMsg").equals("")) {
      out.write("\n");
      out.write("            <div class=\"alert alert-danger\">\n");
      out.write("                <strong></strong> ");
      out.print( request.getAttribute("errMsg"));
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
 } else {
        response.sendRedirect("Senha.jsp");
    }

      out.write('\n');
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
