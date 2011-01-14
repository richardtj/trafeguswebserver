/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.conexao;

import br.com.chapecosolucoes.trafegusweb.server.config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;

/**
 *
 * @author Emerson
 */
public class Conexao {

    private static Conexao instance = null;
    private HashMap<String, Connection> map = null;

    private Conexao() throws Exception {
        this.map = new HashMap<String, Connection>();
    }

    private Connection createConnection() throws Exception {
        String url = Config.getInstance().getValue("trafegusweb.url");
        String usuario = Config.getInstance().getValue("trafegusweb.usuario");
        String senha = Config.getInstance().getValue("trafegusweb.senha");

        url = (url == null ? "jdbc:postgresql://172.1.2.110:5432/desenvolvimento" : url);
        usuario = (usuario == null ? "postgres" : usuario);
        senha = (senha == null ? "postgres" : senha);

        Config.getInstance().setValue("trafegusweb.url", url);
        Config.getInstance().setValue("trafegusweb.usuario", usuario);
        Config.getInstance().setValue("trafegusweb.senha", senha);

        Class.forName("org.postgresql.Driver").newInstance();
        return DriverManager.getConnection(url, usuario, senha);
    }

    public static Conexao getInstance() throws Exception {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }

    public ResultSet executeQuery(String sql, String idSessao) throws Exception {
        ResultSet result = null;
        result = Conexao.getInstance().getConnection(idSessao).createStatement().executeQuery(sql);
        return result;
    }

    public String queryToXML(ResultSet resultSet) throws Exception {
        String result = "";

        result += "<results>/n";

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int colCount = rsmd.getColumnCount();


        while (resultSet.next()) {
            result += "<row>/n";
            for (int ii = 1; ii <= colCount; ii++) {
                String columnName = rsmd.getColumnLabel(ii).trim().toLowerCase();
                Object value = (resultSet.getObject(ii) == null ? "" : resultSet.getObject(ii).toString());
                result += "<" + columnName + ">" + value.toString() + "</" + columnName + ">/n";
            }
            result += "</row>";
        }

        resultSet.close();
        resultSet = null;

        result += "</results>";
        return result;
    }

    public Connection getConnection(String idSessao) throws Exception {
        Connection con = null;
        if (map.containsKey(idSessao)) {
            con = map.get(idSessao);
        } else {
            con = this.createConnection();
            this.map.put(idSessao, con);
        }
        ConnectionManager.getInstance().setaConexaoAtiva(idSessao);
        return con;
    }

    public String queryToXML(String sql, String codUsuario) throws Exception {
        return this.queryToXML(this.executeQuery(sql, codUsuario));
    }

    public void logout(String idSessao) throws Exception {
        Connection con = null;
        if (map.containsKey(idSessao)) {
            con = map.get(idSessao);
            map.remove(idSessao);
            con.close();
            con = null;
            ConnectionManager.getInstance().setaConexaoInativa(idSessao);
        }
    }
}
