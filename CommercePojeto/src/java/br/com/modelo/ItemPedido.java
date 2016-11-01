package br.com.modelo;

/**
 *
 * @author xroma
 */
public class ItemPedido {

    private int id_pedido;
    private int quantidade;
    private double vl_produto;
    private int id_produto;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getVl_produto() {
        return vl_produto;
    }

    public void setVl_produto(double vl_unitario) {
        this.vl_produto = vl_unitario;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

}
