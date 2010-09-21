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
public class RposRecebimentoPosicaoPK implements Serializable {

    private Integer rpos_rece_codigo;

    public RposRecebimentoPosicaoPK() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    public Integer getRpos_rece_codigo() {
        return rpos_rece_codigo;
    }

    public void setRpos_rece_codigo(Integer rpos_rece_codigo) {
        this.rpos_rece_codigo = rpos_rece_codigo;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RposRecebimentoPosicaoPK)) {
            return false;
        }
        RposRecebimentoPosicaoPK other = (RposRecebimentoPosicaoPK) object;
        return true;
    }
}
