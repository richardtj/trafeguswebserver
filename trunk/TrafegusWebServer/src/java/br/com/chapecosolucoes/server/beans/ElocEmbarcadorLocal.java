/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "eloc_embarcador_local")
@NamedQueries({
    @NamedQuery(name = "ElocEmbarcadorLocal.findAll", query = "SELECT e FROM ElocEmbarcadorLocal e")})
public class ElocEmbarcadorLocal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eloc_codigo", nullable = false)
    private Integer elocCodigo;
    @Column(name = "eloc_raio", precision = 5, scale = 2)
    private BigDecimal elocRaio;
    @Column(name = "eloc_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date elocDataCadastro;
    @Column(name = "eloc_codigo_gr")
    private Integer elocCodigoGr;
    @Column(name = "eloc_importado")
    private Character elocImportado;
    @JoinColumn(name = "eloc_tloc_codigo", referencedColumnName = "tloc_codigo")
    @ManyToOne
    private TlocTipoLocal tlocTipoLocal;
    @JoinColumn(name = "eloc_refe_codigo", referencedColumnName = "refe_codigo")
    @ManyToOne
    private RefeReferencia refeReferencia;
    @JoinColumn(name = "eloc_emba_pjur_pess_oras_codigo", referencedColumnName = "emba_pjur_pess_oras_codigo")
    @ManyToOne
    private EmbaEmbarcador embaEmbarcador;

    public ElocEmbarcadorLocal() {
    }

    public ElocEmbarcadorLocal(Integer elocCodigo) {
        this.elocCodigo = elocCodigo;
    }

    public Integer getElocCodigo() {
        return elocCodigo;
    }

    public void setElocCodigo(Integer elocCodigo) {
        this.elocCodigo = elocCodigo;
    }

    public BigDecimal getElocRaio() {
        return elocRaio;
    }

    public void setElocRaio(BigDecimal elocRaio) {
        this.elocRaio = elocRaio;
    }

    public Date getElocDataCadastro() {
        return elocDataCadastro;
    }

    public void setElocDataCadastro(Date elocDataCadastro) {
        this.elocDataCadastro = elocDataCadastro;
    }

    public Integer getElocCodigoGr() {
        return elocCodigoGr;
    }

    public void setElocCodigoGr(Integer elocCodigoGr) {
        this.elocCodigoGr = elocCodigoGr;
    }

    public Character getElocImportado() {
        return elocImportado;
    }

    public void setElocImportado(Character elocImportado) {
        this.elocImportado = elocImportado;
    }

    public TlocTipoLocal getTlocTipoLocal() {
        return tlocTipoLocal;
    }

    public void setTlocTipoLocal(TlocTipoLocal tlocTipoLocal) {
        this.tlocTipoLocal = tlocTipoLocal;
    }

    public RefeReferencia getRefeReferencia() {
        return refeReferencia;
    }

    public void setRefeReferencia(RefeReferencia refeReferencia) {
        this.refeReferencia = refeReferencia;
    }

    public EmbaEmbarcador getEmbaEmbarcador() {
        return embaEmbarcador;
    }

    public void setEmbaEmbarcador(EmbaEmbarcador embaEmbarcador) {
        this.embaEmbarcador = embaEmbarcador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elocCodigo != null ? elocCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElocEmbarcadorLocal)) {
            return false;
        }
        ElocEmbarcadorLocal other = (ElocEmbarcadorLocal) object;
        if ((this.elocCodigo == null && other.elocCodigo != null) || (this.elocCodigo != null && !this.elocCodigo.equals(other.elocCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.ElocEmbarcadorLocal[elocCodigo=" + elocCodigo + "]";
    }

}
