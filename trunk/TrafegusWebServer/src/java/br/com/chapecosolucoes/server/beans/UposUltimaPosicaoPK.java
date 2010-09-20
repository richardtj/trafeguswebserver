/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Emerson
 */
@Embeddable
public class UposUltimaPosicaoPK implements Serializable {
    @Column(name = "upos_vtec_codigo")
    private Integer uposVtecCodigo;
    @Column(name = "upos_term_numero_terminal", length = 30)
    private String uposTermNumeroTerminal;

    public UposUltimaPosicaoPK() {
    }

    public UposUltimaPosicaoPK(Integer uposVtecCodigo, String uposTermNumeroTerminal) {
        this.uposVtecCodigo = uposVtecCodigo;
        this.uposTermNumeroTerminal = uposTermNumeroTerminal;
    }

    public Integer getUposVtecCodigo() {
        return uposVtecCodigo;
    }

    public void setUposVtecCodigo(Integer uposVtecCodigo) {
        this.uposVtecCodigo = uposVtecCodigo;
    }

    public String getUposTermNumeroTerminal() {
        return uposTermNumeroTerminal;
    }

    public void setUposTermNumeroTerminal(String uposTermNumeroTerminal) {
        this.uposTermNumeroTerminal = uposTermNumeroTerminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uposVtecCodigo != null ? uposVtecCodigo.hashCode() : 0);
        hash += (uposTermNumeroTerminal != null ? uposTermNumeroTerminal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UposUltimaPosicaoPK)) {
            return false;
        }
        UposUltimaPosicaoPK other = (UposUltimaPosicaoPK) object;
        if ((this.uposVtecCodigo == null && other.uposVtecCodigo != null) || (this.uposVtecCodigo != null && !this.uposVtecCodigo.equals(other.uposVtecCodigo))) {
            return false;
        }
        if ((this.uposTermNumeroTerminal == null && other.uposTermNumeroTerminal != null) || (this.uposTermNumeroTerminal != null && !this.uposTermNumeroTerminal.equals(other.uposTermNumeroTerminal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.UposUltimaPosicaoPK[uposVtecCodigo=" + uposVtecCodigo + ", uposTermNumeroTerminal=" + uposTermNumeroTerminal + "]";
    }

}
