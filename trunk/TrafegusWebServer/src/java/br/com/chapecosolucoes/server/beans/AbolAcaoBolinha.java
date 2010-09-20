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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "abol_acao_bolinha", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "AbolAcaoBolinha.findAll", query = "SELECT a FROM AbolAcaoBolinha a"),
    @NamedQuery(name = "AbolAcaoBolinha.findByAbolApadCodigo", query = "SELECT a FROM AbolAcaoBolinha a WHERE a.abolApadCodigo = :abolApadCodigo"),
    @NamedQuery(name = "AbolAcaoBolinha.findByAbolCor", query = "SELECT a FROM AbolAcaoBolinha a WHERE a.abolCor = :abolCor")})
public class AbolAcaoBolinha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "abol_apad_codigo", nullable = false)
    private Integer abolApadCodigo;
    @Column(name = "abol_cor")
    private Integer abolCor;
    @JoinColumn(name = "abol_apad_codigo", referencedColumnName = "apad_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private ApadAcaoPadrao apadAcaoPadrao;

    public AbolAcaoBolinha() {
    }

    public AbolAcaoBolinha(Integer abolApadCodigo) {
        this.abolApadCodigo = abolApadCodigo;
    }

    public Integer getAbolApadCodigo() {
        return abolApadCodigo;
    }

    public void setAbolApadCodigo(Integer abolApadCodigo) {
        this.abolApadCodigo = abolApadCodigo;
    }

    public Integer getAbolCor() {
        return abolCor;
    }

    public void setAbolCor(Integer abolCor) {
        this.abolCor = abolCor;
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
        hash += (abolApadCodigo != null ? abolApadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbolAcaoBolinha)) {
            return false;
        }
        AbolAcaoBolinha other = (AbolAcaoBolinha) object;
        if ((this.abolApadCodigo == null && other.abolApadCodigo != null) || (this.abolApadCodigo != null && !this.abolApadCodigo.equals(other.abolApadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.AbolAcaoBolinha[abolApadCodigo=" + abolApadCodigo + "]";
    }

}
