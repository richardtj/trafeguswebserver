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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "alin_acao_linha")
@NamedQueries({
    @NamedQuery(name = "AlinAcaoLinha.findAll", query = "SELECT a FROM AlinAcaoLinha a"),
    @NamedQuery(name = "AlinAcaoLinha.findByAlinApadCodigo", query = "SELECT a FROM AlinAcaoLinha a WHERE a.alinApadCodigo = :alinApadCodigo"),
    @NamedQuery(name = "AlinAcaoLinha.findByAlinCorFundo", query = "SELECT a FROM AlinAcaoLinha a WHERE a.alinCorFundo = :alinCorFundo")})
public class AlinAcaoLinha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "alin_apad_codigo")
    private Integer alinApadCodigo;
    @Column(name = "alin_cor_fundo")
    private Integer alinCorFundo;
    @JoinColumn(name = "alin_apad_codigo", referencedColumnName = "apad_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ApadAcaoPadrao apadAcaoPadrao;

    public AlinAcaoLinha() {
    }

    public AlinAcaoLinha(Integer alinApadCodigo) {
        this.alinApadCodigo = alinApadCodigo;
    }

    public Integer getAlinApadCodigo() {
        return alinApadCodigo;
    }

    public void setAlinApadCodigo(Integer alinApadCodigo) {
        this.alinApadCodigo = alinApadCodigo;
    }

    public Integer getAlinCorFundo() {
        return alinCorFundo;
    }

    public void setAlinCorFundo(Integer alinCorFundo) {
        this.alinCorFundo = alinCorFundo;
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
        hash += (alinApadCodigo != null ? alinApadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlinAcaoLinha)) {
            return false;
        }
        AlinAcaoLinha other = (AlinAcaoLinha) object;
        if ((this.alinApadCodigo == null && other.alinApadCodigo != null) || (this.alinApadCodigo != null && !this.alinApadCodigo.equals(other.alinApadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.AlinAcaoLinha[alinApadCodigo=" + alinApadCodigo + "]";
    }

}
