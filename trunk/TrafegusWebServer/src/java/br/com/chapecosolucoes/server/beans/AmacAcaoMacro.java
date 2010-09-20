/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

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
@Table(name = "amac_acao_macro", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "AmacAcaoMacro.findAll", query = "SELECT a FROM AmacAcaoMacro a"),
    @NamedQuery(name = "AmacAcaoMacro.findByAmacApadCodigo", query = "SELECT a FROM AmacAcaoMacro a WHERE a.amacApadCodigo = :amacApadCodigo")})
public class AmacAcaoMacro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "amac_apad_codigo", nullable = false)
    private Integer amacApadCodigo;
    @JoinColumn(name = "amac_mpad_codigo", referencedColumnName = "mpad_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private MpadMacroPadrao mpadMacroPadrao;
    @JoinColumn(name = "amac_apad_codigo", referencedColumnName = "apad_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private ApadAcaoPadrao apadAcaoPadrao;

    public AmacAcaoMacro() {
    }

    public AmacAcaoMacro(Integer amacApadCodigo) {
        this.amacApadCodigo = amacApadCodigo;
    }

    public Integer getAmacApadCodigo() {
        return amacApadCodigo;
    }

    public void setAmacApadCodigo(Integer amacApadCodigo) {
        this.amacApadCodigo = amacApadCodigo;
    }

    public MpadMacroPadrao getMpadMacroPadrao() {
        return mpadMacroPadrao;
    }

    public void setMpadMacroPadrao(MpadMacroPadrao mpadMacroPadrao) {
        this.mpadMacroPadrao = mpadMacroPadrao;
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
        hash += (amacApadCodigo != null ? amacApadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmacAcaoMacro)) {
            return false;
        }
        AmacAcaoMacro other = (AmacAcaoMacro) object;
        if ((this.amacApadCodigo == null && other.amacApadCodigo != null) || (this.amacApadCodigo != null && !this.amacApadCodigo.equals(other.amacApadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.AmacAcaoMacro[amacApadCodigo=" + amacApadCodigo + "]";
    }

}
