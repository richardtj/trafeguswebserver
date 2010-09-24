/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "tcom_tipo_comunicacao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TcomTipoComunicacao.findAll", query = "SELECT t FROM TcomTipoComunicacao t"),
    @NamedQuery(name = "TcomTipoComunicacao.findByTcomCodigo", query = "SELECT t FROM TcomTipoComunicacao t WHERE t.tcomCodigo = :tcomCodigo"),
    @NamedQuery(name = "TcomTipoComunicacao.findByTcomDescricao", query = "SELECT t FROM TcomTipoComunicacao t WHERE t.tcomDescricao = :tcomDescricao")})
public class TcomTipoComunicacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tcom_codigo", nullable = false)
    private Integer tcomCodigo;
    @Column(name = "tcom_descricao", length = 50)
    private String tcomDescricao;
    @OneToMany(mappedBy = "tcomTipoComunicacao")
    private Collection<VtecVersaoTecnologia> vtecVersaoTecnologiaCollection;

    public TcomTipoComunicacao() {
    }

    public TcomTipoComunicacao(Integer tcomCodigo) {
        this.tcomCodigo = tcomCodigo;
    }

    public Integer getTcomCodigo() {
        return tcomCodigo;
    }

    public void setTcomCodigo(Integer tcomCodigo) {
        this.tcomCodigo = tcomCodigo;
    }

    public String getTcomDescricao() {
        return tcomDescricao;
    }

    public void setTcomDescricao(String tcomDescricao) {
        this.tcomDescricao = tcomDescricao;
    }

    public Collection<VtecVersaoTecnologia> getVtecVersaoTecnologiaCollection() {
        return vtecVersaoTecnologiaCollection;
    }

    public void setVtecVersaoTecnologiaCollection(Collection<VtecVersaoTecnologia> vtecVersaoTecnologiaCollection) {
        this.vtecVersaoTecnologiaCollection = vtecVersaoTecnologiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcomCodigo != null ? tcomCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcomTipoComunicacao)) {
            return false;
        }
        TcomTipoComunicacao other = (TcomTipoComunicacao) object;
        if ((this.tcomCodigo == null && other.tcomCodigo != null) || (this.tcomCodigo != null && !this.tcomCodigo.equals(other.tcomCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TcomTipoComunicacao[tcomCodigo=" + tcomCodigo + "]";
    }

}
