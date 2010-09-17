/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "MaloMalote.findAll", query = "SELECT m FROM MaloMalote m")})
public class MaloMalote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "malo_oras_codigo", nullable = false)
    private Integer maloOrasCodigo;
    @Column(name = "malo_identificador", length = 30)
    private String maloIdentificador;
    @JoinColumn(name = "malo_oras_codigo", referencedColumnName = "oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrasObjetoRastreado orasObjetoRastreado;
    @JoinColumn(name = "malo_eras_codigo", referencedColumnName = "eras_codigo")
    @ManyToOne
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
        return "br.com.chapecosolucoes.server.beans.MaloMalote[maloOrasCodigo=" + maloOrasCodigo + "]";
    }

}
