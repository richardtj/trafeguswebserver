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
public class RperRecebimentoPerifericoPK implements Serializable {

    private Integer rper_codigo;

    public RperRecebimentoPerifericoPK() {
    }

    public Integer getRper_codigo() {
        return rper_codigo;
    }

    public void setRper_codigo(Integer rper_codigo) {
        this.rper_codigo = rper_codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RperRecebimentoPerifericoPK)) {
            return false;
        }
        RperRecebimentoPerifericoPK other = (RperRecebimentoPerifericoPK) object;
        return true;
    }
}
