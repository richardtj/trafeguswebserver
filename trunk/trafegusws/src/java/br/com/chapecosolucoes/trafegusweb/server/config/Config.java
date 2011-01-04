/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Config {

    private static Config instance = null;
    private Properties props = null;

    private Config() throws Exception {
        File file = new File("config.properties");
        FileInputStream fis = null;
        props = new Properties();
        if(file.exists())
        {
            fis = new FileInputStream(file);
            props.load(fis);
            fis.close();
        }
    }

    public static Config getInstance() throws Exception {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public String getValue(String key) {
        return props.getProperty(key);
    }

    public void setValue(String key, String value) throws Exception {
        props.setProperty(key, value);
        saveProperties();
    }

    private void saveProperties() throws Exception {
        File file = new File("config.properties");
        FileOutputStream fos = new FileOutputStream(file);
        props.store(fos, "Configuracões de acesso - Trafegus WEB");
        fos.close();
    }
}
