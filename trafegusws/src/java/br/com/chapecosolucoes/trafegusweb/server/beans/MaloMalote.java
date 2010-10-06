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
@Table(name = "malo_malote")
@NamedQueries({
    @NamedQuery(name = "MaloMalote.findAll", query = "SELECT m FROM MaloMalote m"),
    @NamedQuery(name = "MaloMalote.findByMaloOrasCodigo", query = "SELECT m FROM MaloMalote m WHERE m.maloOrasCodigo = :maloOrasCodigo"),
    @NamedQuery(name = "MaloMalote.findByMaloIdentificador", query = "SELECT m FROM MaloMalote m WHERE m.maloIdentificador = :maloIdentificador")})
public class MaloMalote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "malo_oras_codigo")
    private Integer maloOrasCodigo;
    @Column(name = "malo_identificador")
    private String maloIdentificador;
    @JoinColumn(name = "malo_oras_codigo", referencedColumnName = "oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private OrasObjetoRastreado orasObjetoRastreado;
    @JoinColumn(name = "malo_eras_codigo", referencedColumnName = "eras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private ErasEstacaoRastreamento erasEstacaoRastreamento;

    public MaloMalote() {
    }

    public MaloMalote(Integer maloOrasCodigo) {
        this.maloOrasCodigo = maloOrasCodigo;
    }

    public Integer getMaloOrasCodigo() {
        return maloOrasCodigo;
    }

    public void setMaloOrasCodigo(Integer maloOrasCodigo) {
        this.maloOrasCodigo = maloOrasCodigo;
    }

    public String getMaloIdentificador() {
        return maloIdentificador;
    }

    public void setMaloIdentificador(String maloIdentificador) {
        this.maloIdentificador = maloIdentificador;
    }

    public OrasObjetoRastreado getOrasObjetoRastreado() {
        return orasObjetoRastreado;
    }

    public void setOrasObjetoRastreado(OrasObjetoRastreado orasObjetoRastreado) {
        this.orasObjetoRastreado = orasObjetoRastreado;
    }

    public ErasEstacaoRastreamento getErasEstacaoRastreamento() {
        return erasEstacaoRastreamento;
    }

    public void setErasEstacaoRastreamento(ErasEstacaoRastreamento erasEstacaoRastreamento) {
        this.erasEstacaoRastreamento = erasEstacaoRastreamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maloOrasCodigo != null ? maloOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaloMalote)) {
            return false;
        }
        MaloMalote other = (MaloMalote) object;
        if ((this.maloOrasCodigo == null && other.maloOrasCodigo != null) || (this.maloOrasCodigo != null && !this.maloOrasCodigo.equals(other.maloOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.MaloMalote[maloOrasCodigo=" + maloOrasCodigo + "]";
    }

}
