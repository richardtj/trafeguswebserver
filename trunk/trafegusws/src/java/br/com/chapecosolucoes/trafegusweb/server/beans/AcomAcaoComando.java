/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "acom_acao_comando")
@NamedQueries({
    @NamedQuery(name = "AcomAcaoComando.findAll", query = "SELECT a FROM AcomAcaoComando a"),
    @NamedQuery(name = "AcomAcaoComando.findByAcomApadCodigo", query = "SELECT a FROM AcomAcaoComando a WHERE a.acomApadCodigo = :acomApadCodigo")})
public class AcomAcaoComando implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "acom_apad_codigo")
    private Integer acomApadCodigo;
    @JoinColumn(name = "acom_cpad_codigo", referencedColumnName = "cpad_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private CpadComandoPadrao cpadComandoPadrao;
    @JoinColumn(name = "acom_apad_codigo", referencedColumnName = "apad_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private ApadAcaoPadrao apadAcaoPadrao;

    public AcomAcaoComando() {
    }

    public AcomAcaoComando(Integer acomApadCodigo) {
        this.acomApadCodigo = acomApadCodigo;
    }

    public Integer getAcomApadCodigo() {
        return acomApadCodigo;
    }

    public void setAcomApadCodigo(Integer acomApadCodigo) {
        this.acomApadCodigo = acomApadCodigo;
    }

    public CpadComandoPadrao getCpadComandoPadrao() {
        return cpadComandoPadrao;
    }

    public void setCpadComandoPadrao(CpadComandoPadrao cpadComandoPadrao) {
        this.cpadComandoPadrao = cpadComandoPadrao;
    }

    public ApadAcaoPadrao getApadAcaoPadrao() {
        return apadAcaoPadrao;
    }

    public void setApadAcaoPadrao(ApadAcaoPadrao apadAcaoPadrao) {
        this.apadAcaoPadrao = apadAcaoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acomApadCodigo != null ? acomApadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcomAcaoComando)) {
            return false;
        }
        AcomAcaoComando other = (AcomAcaoComando) object;
        if ((this.acomApadCodigo == null && other.acomApadCodigo != null) || (this.acomApadCodigo != null && !this.acomApadCodigo.equals(other.acomApadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.AcomAcaoComando[acomApadCodigo=" + acomApadCodigo + "]";
    }

}
