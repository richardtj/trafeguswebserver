/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Emerson
 */
@Embeddable
public class ReceRecebimentoPK implements Serializable {

    private Integer rece_codigo;

    public ReceRecebimentoPK() {
    }

    public Integer getRece_codigo() {
        return rece_codigo;
    }

    public void setRece_codigo(Integer rece_codigo) {
        this.rece_codigo = rece_codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceRecebimentoPK)) {
            return false;
        }
        ReceRecebimentoPK other = (ReceRecebimentoPK) object;
        return true;
    }
}
