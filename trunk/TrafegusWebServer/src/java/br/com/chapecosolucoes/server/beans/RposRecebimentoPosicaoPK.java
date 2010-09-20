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

    public RposRecebimentoPosicaoPK() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
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
