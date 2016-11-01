package br.com.DAO;

import br.com.conexao.Mysql;
import br.com.modelo.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author xroma
 */
public class PedidoDAO extends Mysql {
    
    private StringBuffer sql = new StringBuffer();
    
    public void inserirPedido(Pedido pedido) {
        sql.delete(0, sql.length());
        sql.append("INSERT INTO PEDIDO (ID_USUARIO)");
        sql.append(" VALUES (").append(pedido.getId_usuario()).append(")");
        super.incluirtSQL(sql.toString());
    }
    
    public ResultSet ultimaSeq() {
        sql.delete(0, sql.length());
        sql.append("SELECT MAX(ID) AS MAX FROM PEDIDO");
        super.executeSQL(sql.toString());
        return resultset;
    }
    
//    public static void main(String[] args) throws SQLException {
//        
//        PedidoDAO pe = new PedidoDAO();
//        
//        ResultSet r = pe.ultimaSeq();
//        r.first();
//        System.out.println(r.getInt("MAX"));
//        
//    }
}
