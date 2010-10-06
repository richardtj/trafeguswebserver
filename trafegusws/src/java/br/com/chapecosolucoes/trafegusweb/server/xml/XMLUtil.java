/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.xml;

import com.thoughtworks.xstream.XStream;

/**
 *
 * @author Emerson
 */
public class XMLUtil {

    private XStream stream = null;
    private static XMLUtil instance = null;

    private XMLUtil() {
        stream = new XStream();
    }

    public static XMLUtil getIntance() {
        if (instance == null) {
            instance = new XMLUtil();
        }
        return instance;
    }

    public String toXML(Object object) {
        return stream.toXML(object);
    }

    public String toXML(String alias, Object object) {
        stream.alias(alias, object.getClass());
        return stream.toXML(object);
    }
}
