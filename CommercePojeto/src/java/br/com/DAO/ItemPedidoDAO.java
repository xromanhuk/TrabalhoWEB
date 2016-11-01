package br.com.DAO;

import br.com.conexao.Mysql;
import br.com.modelo.ItemPedido;

/**
 *
 * @author xroma
 */
public class ItemPedidoDAO extends Mysql {

    private StringBuffer sql = new StringBuffer();

    public void inserirProduto(ItemPedido itped) {

       sql.delete(0, sql.length());

        sql.append("INSERT INTO PEDIDO_ITEM (ID_PEDIDO,QUANTIDADE,VL_UNITARIO,ID_PRODUTO)");
        sql.append(" VALUES (").append(itped.getId_pedido());
        sql.append(",").append(itped.getQuantidade());
        sql.append(",").append(itped.getVl_produto());
        sql.append(",").append(itped.getId_produto()).append(")");

        super.incluirtSQL(sql.toString());

    }
}
