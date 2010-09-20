/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "rper_recebimento_periferico", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RperRecebimentoPeriferico.findAll", query = "SELECT r FROM RperRecebimentoPeriferico r"),
    @NamedQuery(name = "RperRecebimentoPeriferico.findByRperCodigo", query = "SELECT r FROM RperRecebimentoPeriferico r WHERE r.rperCodigo = :rperCodigo"),
    @NamedQuery(name = "RperRecebimentoPeriferico.findByRperReceCodigo", query = "SELECT r FROM RperRecebimentoPeriferico r WHERE r.rperReceCodigo = :rperReceCodigo"),
    @NamedQuery(name = "RperRecebimentoPeriferico.findByRperViolado", query = "SELECT r FROM RperRecebimentoPeriferico r WHERE r.rperViolado = :rperViolado"),
    @NamedQuery(name = "RperRecebimentoPeriferico.findByRperValor", query = "SELECT r FROM RperRecebimentoPeriferico r WHERE r.rperValor = :rperValor"),
    @NamedQuery(name = "RperRecebimentoPeriferico.findByRperCodigoGr", query = "SELECT r FROM RperRecebimentoPeriferico r WHERE r.rperCodigoGr = :rperCodigoGr"),
    @NamedQuery(name = "RperRecebimentoPeriferico.findByRperEsisCodigo", query = "SELECT r FROM RperRecebimentoPeriferico r WHERE r.rperEsisCodigo = :rperEsisCodigo"),
    @NamedQuery(name = "RperRecebimentoPeriferico.findByRperEstatusGe", query = "SELECT r FROM RperRecebimentoPeriferico r WHERE r.rperEstatusGe = :rperEstatusGe"),
    @NamedQuery(name = "RperRecebimentoPeriferico.findByRperDataComputadorBordo", query = "SELECT r FROM RperRecebimentoPeriferico r WHERE r.rperDataComputadorBordo = :rperDataComputadorBordo")})
public class RperRecebimentoPeriferico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RperRecebimentoPerifericoPK rperRecebimentoPerifericoPK;
    @Basic(optional = false)
    @Column(name = "rper_codigo", nullable = false)
    private int rperCodigo;
    @Column(name = "rper_rece_codigo")
    private Integer rperReceCodigo;
    @Column(name = "rper_violado", length = 10)
    private String rperViolado;
    @Column(name = "rper_valor", length = 50)
    private String rperValor;
    @Column(name = "rper_codigo_gr")
    private Integer rperCodigoGr;
    @Column(name = "rper_esis_codigo")
    private Integer rperEsisCodigo;
    @Column(name = "rper_estatus_ge", length = 100)
    private String rperEstatusGe;
    @Column(name = "rper_data_computador_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rperDataComputadorBordo;
    @JoinColumn(name = "rper_eppa_codigo", referencedColumnName = "eppa_codigo")
    @ManyToOne
    private EppaEventoPerifericoPadrao eppaEventoPerifericoPadrao;

    public RperRecebimentoPeriferico() {
    }

    public RperRecebimentoPeriferico(RperRecebimentoPerifericoPK rperRecebimentoPerifericoPK) {
        this.rperRecebimentoPerifericoPK = rperRecebimentoPerifericoPK;
    }

    public RperRecebimentoPeriferico(RperRecebimentoPerifericoPK rperRecebimentoPerifericoPK, int rperCodigo) {
        this.rperRecebimentoPerifericoPK = rperRecebimentoPerifericoPK;
        this.rperCodigo = rperCodigo;
    }

    public RperRecebimentoPerifericoPK getRperRecebimentoPerifericoPK() {
        return rperRecebimentoPerifericoPK;
    }

    public void setRperRecebimentoPerifericoPK(RperRecebimentoPerifericoPK rperRecebimentoPerifericoPK) {
        this.rperRecebimentoPerifericoPK = rperRecebimentoPerifericoPK;
    }

    public int getRperCodigo() {
        return rperCodigo;
    }

    public void setRperCodigo(int rperCodigo) {
        this.rperCodigo = rperCodigo;
    }

    public Integer getRperReceCodigo() {
        return rperReceCodigo;
    }

    public void setRperReceCodigo(Integer rperReceCodigo) {
        this.rperReceCodigo = rperReceCodigo;
    }

    public String getRperViolado() {
        return rperViolado;
    }

    public void setRperViolado(String rperViolado) {
        this.rperViolado = rperViolado;
    }

    public String getRperValor() {
        return rperValor;
    }

    public void setRperValor(String rperValor) {
        this.rperValor = rperValor;
    }

    public Integer getRperCodigoGr() {
        return rperCodigoGr;
    }

    public void setRperCodigoGr(Integer rperCodigoGr) {
        this.rperCodigoGr = rperCodigoGr;
    }

    public Integer getRperEsisCodigo() {
        return rperEsisCodigo;
    }

    public void setRperEsisCodigo(Integer rperEsisCodigo) {
        this.rperEsisCodigo = rperEsisCodigo;
    }

    public String getRperEstatusGe() {
        return rperEstatusGe;
    }

    public void setRperEstatusGe(String rperEstatusGe) {
        this.rperEstatusGe = rperEstatusGe;
    }

    public Date getRperDataComputadorBordo() {
        return rperDataComputadorBordo;
    }

    public void setRperDataComputadorBordo(Date rperDataComputadorBordo) {
        this.rperDataComputadorBordo = rperDataComputadorBordo;
    }

    public EppaEventoPerifericoPadrao getEppaEventoPerifericoPadrao() {
        return eppaEventoPerifericoPadrao;
    }

    public void setEppaEventoPerifericoPadrao(EppaEventoPerifericoPadrao eppaEventoPerifericoPadrao) {
        this.eppaEventoPerifericoPadrao = eppaEventoPerifericoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rperRecebimentoPerifericoPK != null ? rperRecebimentoPerifericoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RperRecebimentoPeriferico)) {
            return false;
        }
        RperRecebimentoPeriferico other = (RperRecebimentoPeriferico) object;
        if ((this.rperRecebimentoPerifericoPK == null && other.rperRecebimentoPerifericoPK != null) || (this.rperRecebimentoPerifericoPK != null && !this.rperRecebimentoPerifericoPK.equals(other.rperRecebimentoPerifericoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.RperRecebimentoPeriferico[rperRecebimentoPerifericoPK=" + rperRecebimentoPerifericoPK + "]";
    }

}
