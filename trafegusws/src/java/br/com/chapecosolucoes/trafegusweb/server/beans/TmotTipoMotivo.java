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
import javax.persistence.FetchType;
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
@Table(name = "tmot_tipo_motivo")
@NamedQueries({
    @NamedQuery(name = "TmotTipoMotivo.findAll", query = "SELECT t FROM TmotTipoMotivo t"),
    @NamedQuery(name = "TmotTipoMotivo.findByTmotCodigo", query = "SELECT t FROM TmotTipoMotivo t WHERE t.tmotCodigo = :tmotCodigo"),
    @NamedQuery(name = "TmotTipoMotivo.findByTmotDescricao", query = "SELECT t FROM TmotTipoMotivo t WHERE t.tmotDescricao = :tmotDescricao")})
public class TmotTipoMotivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tmot_codigo")
    private Integer tmotCodigo;
    @Column(name = "tmot_descricao")
    private String tmotDescricao;
    @OneToMany(mappedBy = "tmotTipoMotivo", fetch = FetchType.LAZY)
    private Collection<MotiMotivo> motiMotivoCollection;

    public TmotTipoMotivo() {
    }

    public TmotTipoMotivo(Integer tmotCodigo) {
        this.tmotCodigo = tmotCodigo;
    }

    public Integer getTmotCodigo() {
        return tmotCodigo;
    }

    public void setTmotCodigo(Integer tmotCodigo) {
        this.tmotCodigo = tmotCodigo;
    }

    public String getTmotDescricao() {
        return tmotDescricao;
    }

    public void setTmotDescricao(String tmotDescricao) {
        this.tmotDescricao = tmotDescricao;
    }

    public Collection<MotiMotivo> getMotiMotivoCollection() {
        return motiMotivoCollection;
    }

    public void setMotiMotivoCollection(Collection<MotiMotivo> motiMotivoCollection) {
        this.motiMotivoCollection = motiMotivoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmotCodigo != null ? tmotCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmotTipoMotivo)) {
            return false;
        }
        TmotTipoMotivo other = (TmotTipoMotivo) object;
        if ((this.tmotCodigo == null && other.tmotCodigo != null) || (this.tmotCodigo != null && !this.tmotCodigo.equals(other.tmotCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TmotTipoMotivo[tmotCodigo=" + tmotCodigo + "]";
    }

}
