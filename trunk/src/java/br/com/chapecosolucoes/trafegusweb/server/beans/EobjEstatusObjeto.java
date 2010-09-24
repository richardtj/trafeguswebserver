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
@Table(name = "eobj_estatus_objeto", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EobjEstatusObjeto.findAll", query = "SELECT e FROM EobjEstatusObjeto e"),
    @NamedQuery(name = "EobjEstatusObjeto.findByEobjCodigo", query = "SELECT e FROM EobjEstatusObjeto e WHERE e.eobjCodigo = :eobjCodigo"),
    @NamedQuery(name = "EobjEstatusObjeto.findByEobjDescricao", query = "SELECT e FROM EobjEstatusObjeto e WHERE e.eobjDescricao = :eobjDescricao"),
    @NamedQuery(name = "EobjEstatusObjeto.findByEobjCodigoGr", query = "SELECT e FROM EobjEstatusObjeto e WHERE e.eobjCodigoGr = :eobjCodigoGr")})
public class EobjEstatusObjeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eobj_codigo", nullable = false)
    private Integer eobjCodigo;
    @Column(name = "eobj_descricao", length = 50)
    private String eobjDescricao;
    @Column(name = "eobj_codigo_gr")
    private Integer eobjCodigoGr;
    @OneToMany(mappedBy = "eobjEstatusObjeto")
    private Collection<OrasObjetoRastreado> orasObjetoRastreadoCollection;
    @OneToMany(mappedBy = "eobjEstatusObjeto")
    private Collection<VtraVeiculoTransportador> vtraVeiculoTransportadorCollection;
    @OneToMany(mappedBy = "eobjEstatusObjeto")
    private Collection<VembVeiculoEmbarcador> vembVeiculoEmbarcadorCollection;

    public EobjEstatusObjeto() {
    }

    public EobjEstatusObjeto(Integer eobjCodigo) {
        this.eobjCodigo = eobjCodigo;
    }

    public Integer getEobjCodigo() {
        return eobjCodigo;
    }

    public void setEobjCodigo(Integer eobjCodigo) {
        this.eobjCodigo = eobjCodigo;
    }

    public String getEobjDescricao() {
        return eobjDescricao;
    }

    public void setEobjDescricao(String eobjDescricao) {
        this.eobjDescricao = eobjDescricao;
    }

    public Integer getEobjCodigoGr() {
        return eobjCodigoGr;
    }

    public void setEobjCodigoGr(Integer eobjCodigoGr) {
        this.eobjCodigoGr = eobjCodigoGr;
    }

    public Collection<OrasObjetoRastreado> getOrasObjetoRastreadoCollection() {
        return orasObjetoRastreadoCollection;
    }

    public void setOrasObjetoRastreadoCollection(Collection<OrasObjetoRastreado> orasObjetoRastreadoCollection) {
        this.orasObjetoRastreadoCollection = orasObjetoRastreadoCollection;
    }

    public Collection<VtraVeiculoTransportador> getVtraVeiculoTransportadorCollection() {
        return vtraVeiculoTransportadorCollection;
    }

    public void setVtraVeiculoTransportadorCollection(Collection<VtraVeiculoTransportador> vtraVeiculoTransportadorCollection) {
        this.vtraVeiculoTransportadorCollection = vtraVeiculoTransportadorCollection;
    }

    public Collection<VembVeiculoEmbarcador> getVembVeiculoEmbarcadorCollection() {
        return vembVeiculoEmbarcadorCollection;
    }

    public void setVembVeiculoEmbarcadorCollection(Collection<VembVeiculoEmbarcador> vembVeiculoEmbarcadorCollection) {
        this.vembVeiculoEmbarcadorCollection = vembVeiculoEmbarcadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eobjCodigo != null ? eobjCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EobjEstatusObjeto)) {
            return false;
        }
        EobjEstatusObjeto other = (EobjEstatusObjeto) object;
        if ((this.eobjCodigo == null && other.eobjCodigo != null) || (this.eobjCodigo != null && !this.eobjCodigo.equals(other.eobjCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EobjEstatusObjeto[eobjCodigo=" + eobjCodigo + "]";
    }

}
