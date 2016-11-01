package br.com.DAO;

import br.com.conexao.Mysql;
import static br.com.conexao.Mysql.resultset;
import java.sql.ResultSet;

/**
 *
 * @author xroma
 */
public class UsuarioDAO extends Mysql {

    private StringBuffer sql = new StringBuffer();

    public ResultSet consultaUsuario(String usuario) {
        sql.delete(0, sql.length());
        sql.append("SELECT * FROM CAD_USUARIO WHERE USUARIO = '").append(usuario).append("'");
        executeSQL(sql.toString());
        return resultset;
    }
}
