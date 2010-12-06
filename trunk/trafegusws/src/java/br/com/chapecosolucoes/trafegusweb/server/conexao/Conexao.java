/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Emerson
 */
public class Conexao {

    private static Conexao instance = null;
    private Connection connection = null;

    private Conexao() throws Exception {
        Class.forName("org.postgresql.Driver").newInstance();
        this.connection = DriverManager.getConnection("jdbc:postgresql://172.1.2.110:5432/desenvolvimento", "postgres", "postgres");
    }

    public static Conexao getInstance() throws Exception {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }

    public ResultSet executeQuery(String sql) throws Exception {
        ResultSet result = null;
        result = Conexao.getInstance().getConnection().createStatement().executeQuery(sql);
        return result;
    }

    public String queryToXML(ResultSet resultSet) throws ParserConfigurationException, SQLException, TransformerConfigurationException, TransformerException {
        String result = "";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element results = doc.createElement("results");
        doc.appendChild(results);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int colCount = rsmd.getColumnCount();
        while (resultSet.next()) {
            Element row = doc.createElement("row");
            results.appendChild(row);
            for (int ii = 1; ii <= colCount; ii++) {
                String columnName = rsmd.getColumnLabel(ii);
                Object value = resultSet.getObject(ii);
                Element node = doc.createElement(columnName.toLowerCase());
                if (value != null) {
                    node.appendChild(doc.createTextNode(value.toString()));
                } else {
                    node.appendChild(doc.createTextNode(""));
                }
                row.appendChild(node);
                columnName = null;
                value = null;
                node = null;
            }
            row = null;

        }

        result = getDocumentAsXml(doc);

        factory = null;
        builder = null;
        doc = null;
        rsmd = null;
        resultSet.close();
        resultSet = null;

        return result;
    }

    private String getDocumentAsXml(Document doc) throws TransformerConfigurationException, TransformerException {

        String result = "";

        DOMSource domSource = new DOMSource(doc);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        java.io.StringWriter sw = new java.io.StringWriter();
        StreamResult sr = new StreamResult(sw);
        transformer.transform(domSource, sr);

        result = sw.toString();

        domSource = null;
        sr = null;
        sw = null;
        tf = null;
        transformer = null;

        return result;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public String queryToXML(String sql) throws Exception {
        return this.queryToXML(this.executeQuery(sql));
    }
}
