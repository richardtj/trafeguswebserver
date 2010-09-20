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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "rpos_recebimento_posicao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RposRecebimentoPosicao.findAll", query = "SELECT r FROM RposRecebimentoPosicao r"),
    @NamedQuery(name = "RposRecebimentoPosicao.findByRposReceCodigo", query = "SELECT r FROM RposRecebimentoPosicao r WHERE r.rposReceCodigo = :rposReceCodigo"),
    @NamedQuery(name = "RposRecebimentoPosicao.findByRposLatitude", query = "SELECT r FROM RposRecebimentoPosicao r WHERE r.rposLatitude = :rposLatitude"),
    @NamedQuery(name = "RposRecebimentoPosicao.findByRposLongitude", query = "SELECT r FROM RposRecebimentoPosicao r WHERE r.rposLongitude = :rposLongitude"),
    @NamedQuery(name = "RposRecebimentoPosicao.findByRposDescricaoIntegrada", query = "SELECT r FROM RposRecebimentoPosicao r WHERE r.rposDescricaoIntegrada = :rposDescricaoIntegrada"),
    @NamedQuery(name = "RposRecebimentoPosicao.findByRposDescricaoSistema", query = "SELECT r FROM RposRecebimentoPosicao r WHERE r.rposDescricaoSistema = :rposDescricaoSistema"),
    @NamedQuery(name = "RposRecebimentoPosicao.findByRposEsisCodigo", query = "SELECT r FROM RposRecebimentoPosicao r WHERE r.rposEsisCodigo = :rposEsisCodigo"),
    @NamedQuery(name = "RposRecebimentoPosicao.findByRposEstatusGe", query = "SELECT r FROM RposRecebimentoPosicao r WHERE r.rposEstatusGe = :rposEstatusGe"),
    @NamedQuery(name = "RposRecebimentoPosicao.findByRposDataComputadorBordo", query = "SELECT r FROM RposRecebimentoPosicao r WHERE r.rposDataComputadorBordo = :rposDataComputadorBordo")})
public class RposRecebimentoPosicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RposRecebimentoPosicaoPK rposRecebimentoPosicaoPK;
    @Basic(optional = false)
    @Column(name = "rpos_rece_codigo", nullable = false)
    private int rposReceCodigo;
    @Column(name = "rpos_latitude", precision = 15, scale = 10)
    private BigDecimal rposLatitude;
    @Column(name = "rpos_longitude", precision = 15, scale = 10)
    private BigDecimal rposLongitude;
    @Column(name = "rpos_descricao_integrada", length = 200)
    private String rposDescricaoIntegrada;
    @Column(name = "rpos_descricao_sistema", length = 200)
    private String rposDescricaoSistema;
    @Column(name = "rpos_esis_codigo")
    private Integer rposEsisCodigo;
    @Column(name = "rpos_estatus_ge", length = 100)
    private String rposEstatusGe;
    @Column(name = "rpos_data_computador_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rposDataComputadorBordo;

    public RposRecebimentoPosicao() {
    }

    public RposRecebimentoPosicao(RposRecebimentoPosicaoPK rposRecebimentoPosicaoPK) {
        this.rposRecebimentoPosicaoPK = rposRecebimentoPosicaoPK;
    }

    public RposRecebimentoPosicao(RposRecebimentoPosicaoPK rposRecebimentoPosicaoPK, int rposReceCodigo) {
        this.rposRecebimentoPosicaoPK = rposRecebimentoPosicaoPK;
        this.rposReceCodigo = rposReceCodigo;
    }

    public RposRecebimentoPosicaoPK getRposRecebimentoPosicaoPK() {
        return rposRecebimentoPosicaoPK;
    }

    public void setRposRecebimentoPosicaoPK(RposRecebimentoPosicaoPK rposRecebimentoPosicaoPK) {
        this.rposRecebimentoPosicaoPK = rposRecebimentoPosicaoPK;
    }

    public int getRposReceCodigo() {
        return rposReceCodigo;
    }

    public void setRposReceCodigo(int rposReceCodigo) {
        this.rposReceCodigo = rposReceCodigo;
    }

    public BigDecimal getRposLatitude() {
        return rposLatitude;
    }

    public void setRposLatitude(BigDecimal rposLatitude) {
        this.rposLatitude = rposLatitude;
    }

    public BigDecimal getRposLongitude() {
        return rposLongitude;
    }

    public void setRposLongitude(BigDecimal rposLongitude) {
        this.rposLongitude = rposLongitude;
    }

    public String getRposDescricaoIntegrada() {
        return rposDescricaoIntegrada;
    }

    public void setRposDescricaoIntegrada(String rposDescricaoIntegrada) {
        this.rposDescricaoIntegrada = rposDescricaoIntegrada;
    }

    public String getRposDescricaoSistema() {
        return rposDescricaoSistema;
    }

    public void setRposDescricaoSistema(String rposDescricaoSistema) {
        this.rposDescricaoSistema = rposDescricaoSistema;
    }

    public Integer getRposEsisCodigo() {
        return rposEsisCodigo;
    }

    public void setRposEsisCodigo(Integer rposEsisCodigo) {
        this.rposEsisCodigo = rposEsisCodigo;
    }

    public String getRposEstatusGe() {
        return rposEstatusGe;
    }

    public void setRposEstatusGe(String rposEstatusGe) {
        this.rposEstatusGe = rposEstatusGe;
    }

    public Date getRposDataComputadorBordo() {
        return rposDataComputadorBordo;
    }

    public void setRposDataComputadorBordo(Date rposDataComputadorBordo) {
        this.rposDataComputadorBordo = rposDataComputadorBordo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rposRecebimentoPosicaoPK != null ? rposRecebimentoPosicaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RposRecebimentoPosicao)) {
            return false;
        }
        RposRecebimentoPosicao other = (RposRecebimentoPosicao) object;
        if ((this.rposRecebimentoPosicaoPK == null && other.rposRecebimentoPosicaoPK != null) || (this.rposRecebimentoPosicaoPK != null && !this.rposRecebimentoPosicaoPK.equals(other.rposRecebimentoPosicaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.RposRecebimentoPosicao[rposRecebimentoPosicaoPK=" + rposRecebimentoPosicaoPK + "]";
    }

}
