 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.conexao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emerson
 */
public class ConnectionManager extends Thread {

    private static ConnectionManager instance = null;
    private boolean go = false;
    private final int itervalo = (1000 * 60);
    private final int inatividadeMax = 5;
    private HashMap<String, Integer> map = null;

    private ConnectionManager() {
        map = new HashMap<String, Integer>();
    }

    @Override
    public void run() {
        Thread.currentThread().setName("ConnectionManagerThread");
        while (this.go) {
            try {
                analizaInatividade();
                Thread.sleep(itervalo);
            } catch (Exception ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void analizaInatividade() throws Exception {
        for (Iterator it = map.keySet().iterator(); it.hasNext();) {
            String idSessao = (String) it.next();
            Integer tempo = map.get(idSessao);
            tempo = tempo - 1;
            if (tempo == 0) {
                Conexao.getInstance().logout(idSessao);
            } else {
                map.remove(idSessao);
                map.put(idSessao, tempo);
            }
        }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public void setaConexaoAtiva(String idSessao) {
        map.remove(idSessao);
        map.put(idSessao, inatividadeMax);
    }

    public void setaConexaoInativa(String idSessao) {
        map.remove(idSessao);
    }
}
