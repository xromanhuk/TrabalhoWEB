package br.com.DAO;

import br.com.conexao.Mysql;
import static br.com.conexao.Mysql.resultset;
import br.com.modelo.Produto;
import java.sql.ResultSet;

/**
 *
 * @author xroma
 */
public class ProdutoDAO extends Mysql {

    private StringBuffer sql = new StringBuffer();

    public void inserirProduto(Produto prod) {

        sql.delete(0, sql.length());

        sql.append("INSERT INTO CAD_PRODUTO (DS_PRODUTO,DS_INFORMACAO,VL_PRODUTO)");
        sql.append(" VALUES ('").append(prod.getDs_produto()).append("','");
        sql.append(prod.getDs_informacao()).append("',");
        sql.append(prod.getVl_produto()).append(")");

        super.incluirtSQL(sql.toString());

    }

    public void alterarProduto(Produto prod) {
        sql.delete(0, sql.length());
        sql.append("UPDATE CAD_PRODUTO SET DS_PRODUTO = '").append(prod.getDs_produto());
        sql.append("', DS_INFORMACAO = '").append(prod.getDs_informacao());
        sql.append("', VL_PRODUTO = '").append(prod.getVl_produto());
        sql.append("' WHERE ID_PRODUTO = ").append(prod.getId_produto());
//        System.out.println(sql.toString());
        super.updateSQL(sql.toString());
    }

    public void excluirProduto(Produto prod) {
        sql.delete(0, sql.length());
        sql.append("DELETE FROM CAD_PRODUTO WHERE ID_PRODUTO = ");
        sql.append(prod.getId_produto());

        super.deleteSQL(sql.toString());
    }

    public ResultSet consultaGeral() {
        sql.delete(0, sql.length());
        sql.append("SELECT * FROM CAD_PRODUTO ");
        executeSQL(sql.toString());
        return resultset;
    }

    public ResultSet consultaCodigo(int id) {
        sql.delete(0, sql.length());
        sql.append("SELECT * FROM CAD_PRODUTO WHERE ID_PRODUTO = ").append(id);
        executeSQL(sql.toString());
        return resultset;
    }

    public ResultSet consultaDescricao(String descricao) {
        sql.delete(0, sql.length());
        sql.append("SELECT * FROM CAD_PRODUTO  WHERE DS_PRODUTO LIKE '%");
        sql.append(descricao).append("%'");
        executeSQL(sql.toString());
        return resultset;
    }

//    public static void main(String[] args) throws SQLException {
//
//        ProdutoDAO p = new ProdutoDAO();
//
//        ResultSet r = p.consultaCodigo(4);
//
//        r.first();
//        System.out.println(r.getString("ds_produto"));
//        System.out.println(r.getString("ds_informacao"));
//        System.out.println(r.getString("vl_produto"));
//    }
}
