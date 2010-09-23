/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.server.operations;

import br.com.chapecosolucoes.server.beans.CrefClasseReferencia;
import br.com.chapecosolucoes.server.beans.UsuaUsuario;
import br.com.chapecosolucoes.server.util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author emerson
 */
public class Operations {

    private static Operations instance;

    private Operations() {
    }

    public static Operations getIntance() {
        if (instance == null) {
            instance = new Operations();
        }
        return instance;
    }

    public UsuaUsuario solicitaAcesso(String usuario, String senha) {
        UsuaUsuario result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createNamedQuery("UsuaUsuario.findByUsuaLoginAndSenha");
        q.setParameter(1, usuario);
        q.setParameter(2, senha);
        result = (UsuaUsuario) q.getSingleResult();
        em.getTransaction().commit();
        return result;
    }

    public List<CrefClasseReferencia> solicitaClassesReferencias(Integer codEmpresa) {
        ArrayList<CrefClasseReferencia> result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createNamedQuery("SELECT c FROM CrefClasseReferencia c WHERE c.crefCodigo = :crefCodigo");
        q.setParameter(1, codEmpresa);
        result = (ArrayList<CrefClasseReferencia>) q.getResultList();
        em.getTransaction().commit();
        return result;
    }
}
