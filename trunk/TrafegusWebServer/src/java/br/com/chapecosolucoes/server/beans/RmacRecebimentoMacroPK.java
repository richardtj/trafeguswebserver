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
public class RmacRecebimentoMacroPK implements Serializable {

    private Integer rmac_rece_codigo;

    public RmacRecebimentoMacroPK() {
    }

    public Integer getRmac_rece_codigo() {
        return rmac_rece_codigo;
    }

    public void setRmac_rece_codigo(Integer rmac_rece_codigo) {
        this.rmac_rece_codigo = rmac_rece_codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmacRecebimentoMacroPK)) {
            return false;
        }
        RmacRecebimentoMacroPK other = (RmacRecebimentoMacroPK) object;
        return true;
    }
}
