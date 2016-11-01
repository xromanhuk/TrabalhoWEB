package br.com.modelo;

/**
 *
 * @author xroma
 */
public class Produto {

    private int id_produto;
    private String ds_produto;
    private String ds_informacao;
    private double vl_produto;
    private int qtd;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getDs_produto() {
        return ds_produto;
    }

    public void setDs_produto(String ds_produto) {
        this.ds_produto = ds_produto;
    }

    public String getDs_informacao() {
        return ds_informacao;
    }

    public void setDs_informacao(String ds_informacao) {
        this.ds_informacao = ds_informacao;
    }

    public double getVl_produto() {
        return vl_produto;
    }

    public void setVl_produto(double vl_produto) {
        this.vl_produto = vl_produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

}
