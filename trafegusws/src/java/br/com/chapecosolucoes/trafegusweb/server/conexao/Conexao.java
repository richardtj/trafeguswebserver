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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emerson
 */
public class Conexao {

    private static ThreadLocal<Conexao> instance = new ThreadLocal<Conexao>() {

        @Override
        protected Conexao initialValue() {
            return new Conexao();
        }
    };
    private Connection connection;

    private Conexao() {
        try {
            this.connection = this.createConnection();
        } catch (Exception ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public static Conexao getInstance() {
        return instance.get();
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
        return this.connection;
    }

    public String queryToXML(String sql, String codUsuario) throws Exception {
        return this.queryToXML(this.executeQuery(sql, codUsuario));
    }

    public void logout(String idSessao) throws Exception {
        this.connection.close();
        close();
    }

    private static void removeInstance() {
        instance.remove();
    }

      public void close() {
        removeInstance();
    }
}
