/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

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

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "htpg_historico_troca_pg")
@NamedQueries({
    @NamedQuery(name = "HtpgHistoricoTrocaPg.findAll", query = "SELECT h FROM HtpgHistoricoTrocaPg h"),
    @NamedQuery(name = "HtpgHistoricoTrocaPg.findByHtpgCodigo", query = "SELECT h FROM HtpgHistoricoTrocaPg h WHERE h.htpgCodigo = :htpgCodigo"),
    @NamedQuery(name = "HtpgHistoricoTrocaPg.findByHtpgDataHora", query = "SELECT h FROM HtpgHistoricoTrocaPg h WHERE h.htpgDataHora = :htpgDataHora"),
    @NamedQuery(name = "HtpgHistoricoTrocaPg.findByHtpgPgAnterior", query = "SELECT h FROM HtpgHistoricoTrocaPg h WHERE h.htpgPgAnterior = :htpgPgAnterior"),
    @NamedQuery(name = "HtpgHistoricoTrocaPg.findByHtpgPgPosterior", query = "SELECT h FROM HtpgHistoricoTrocaPg h WHERE h.htpgPgPosterior = :htpgPgPosterior")})
public class HtpgHistoricoTrocaPg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "htpg_codigo")
    private Integer htpgCodigo;
    @Column(name = "htpg_data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date htpgDataHora;
    @Column(name = "htpg_pg_anterior")
    private Integer htpgPgAnterior;
    @Column(name = "htpg_pg_posterior")
    private Integer htpgPgPosterior;
    @JoinColumn(name = "htpg_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UsuaUsuario usuaUsuario;
    @JoinColumn(name = "htpg_oras_codigo", referencedColumnName = "oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrasObjetoRastreado orasObjetoRastreado;

    public HtpgHistoricoTrocaPg() {
    }

    public HtpgHistoricoTrocaPg(Integer htpgCodigo) {
        this.htpgCodigo = htpgCodigo;
    }

    public Integer getHtpgCodigo() {
        return htpgCodigo;
    }

    public void setHtpgCodigo(Integer htpgCodigo) {
        this.htpgCodigo = htpgCodigo;
    }

    public Date getHtpgDataHora() {
        return htpgDataHora;
    }

    public void setHtpgDataHora(Date htpgDataHora) {
        this.htpgDataHora = htpgDataHora;
    }

    public Integer getHtpgPgAnterior() {
        return htpgPgAnterior;
    }

    public void setHtpgPgAnterior(Integer htpgPgAnterior) {
        this.htpgPgAnterior = htpgPgAnterior;
    }

    public Integer getHtpgPgPosterior() {
        return htpgPgPosterior;
    }

    public void setHtpgPgPosterior(Integer htpgPgPosterior) {
        this.htpgPgPosterior = htpgPgPosterior;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public OrasObjetoRastreado getOrasObjetoRastreado() {
        return orasObjetoRastreado;
    }

    public void setOrasObjetoRastreado(OrasObjetoRastreado orasObjetoRastreado) {
        this.orasObjetoRastreado = orasObjetoRastreado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (htpgCodigo != null ? htpgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HtpgHistoricoTrocaPg)) {
            return false;
        }
        HtpgHistoricoTrocaPg other = (HtpgHistoricoTrocaPg) object;
        if ((this.htpgCodigo == null && other.htpgCodigo != null) || (this.htpgCodigo != null && !this.htpgCodigo.equals(other.htpgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.HtpgHistoricoTrocaPg[htpgCodigo=" + htpgCodigo + "]";
    }

}
