/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "tloc_transportador_local", catalog = "trafegus_transc", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tloc_refe_codigo", "tloc_tran_pess_oras_codigo"})})
@NamedQueries({
    @NamedQuery(name = "TlocTransportadorLocal.findAll", query = "SELECT t FROM TlocTransportadorLocal t"),
    @NamedQuery(name = "TlocTransportadorLocal.findByTlocCodigo", query = "SELECT t FROM TlocTransportadorLocal t WHERE t.tlocCodigo = :tlocCodigo"),
    @NamedQuery(name = "TlocTransportadorLocal.findByTlocRaio", query = "SELECT t FROM TlocTransportadorLocal t WHERE t.tlocRaio = :tlocRaio"),
    @NamedQuery(name = "TlocTransportadorLocal.findByTlocDataCadastro", query = "SELECT t FROM TlocTransportadorLocal t WHERE t.tlocDataCadastro = :tlocDataCadastro"),
    @NamedQuery(name = "TlocTransportadorLocal.findByTlocCodigoGr", query = "SELECT t FROM TlocTransportadorLocal t WHERE t.tlocCodigoGr = :tlocCodigoGr"),
    @NamedQuery(name = "TlocTransportadorLocal.findByTlocImportado", query = "SELECT t FROM TlocTransportadorLocal t WHERE t.tlocImportado = :tlocImportado")})
public class TlocTransportadorLocal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tloc_codigo", nullable = false)
    private Integer tlocCodigo;
    @Column(name = "tloc_raio")
    private Integer tlocRaio;
    @Column(name = "tloc_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tlocDataCadastro;
    @Column(name = "tloc_codigo_gr")
    private Integer tlocCodigoGr;
    @Column(name = "tloc_importado")
    private Character tlocImportado;
    @JoinColumn(name = "tloc_tran_pess_oras_codigo", referencedColumnName = "tran_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TranTransportador tranTransportador;
    @JoinColumn(name = "tloc_tloc_codigo", referencedColumnName = "tloc_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TlocTipoLocal tlocTipoLocal;
    @JoinColumn(name = "tloc_refe_codigo", referencedColumnName = "refe_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private RefeReferencia refeReferencia;

    public TlocTransportadorLocal() {
    }

    public TlocTransportadorLocal(Integer tlocCodigo) {
        this.tlocCodigo = tlocCodigo;
    }

    public Integer getTlocCodigo() {
        return tlocCodigo;
    }

    public void setTlocCodigo(Integer tlocCodigo) {
        this.tlocCodigo = tlocCodigo;
    }

    public Integer getTlocRaio() {
        return tlocRaio;
    }

    public void setTlocRaio(Integer tlocRaio) {
        this.tlocRaio = tlocRaio;
    }

    public Date getTlocDataCadastro() {
        return tlocDataCadastro;
    }

    public void setTlocDataCadastro(Date tlocDataCadastro) {
        this.tlocDataCadastro = tlocDataCadastro;
    }

    public Integer getTlocCodigoGr() {
        return tlocCodigoGr;
    }

    public void setTlocCodigoGr(Integer tlocCodigoGr) {
        this.tlocCodigoGr = tlocCodigoGr;
    }

    public Character getTlocImportado() {
        return tlocImportado;
    }

    public void setTlocImportado(Character tlocImportado) {
        this.tlocImportado = tlocImportado;
    }

    public TranTransportador getTranTransportador() {
        return tranTransportador;
    }

    public void setTranTransportador(TranTransportador tranTransportador) {
        this.tranTransportador = tranTransportador;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tlocCodigo != null ? tlocCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TlocTransportadorLocal)) {
            return false;
        }
        TlocTransportadorLocal other = (TlocTransportadorLocal) object;
        if ((this.tlocCodigo == null && other.tlocCodigo != null) || (this.tlocCodigo != null && !this.tlocCodigo.equals(other.tlocCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.TlocTransportadorLocal[tlocCodigo=" + tlocCodigo + "]";
    }

}
