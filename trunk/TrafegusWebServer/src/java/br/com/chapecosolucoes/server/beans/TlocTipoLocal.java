/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

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
@Table(name = "tloc_tipo_local")
@NamedQueries({
    @NamedQuery(name = "TlocTipoLocal.findAll", query = "SELECT t FROM TlocTipoLocal t")})
public class TlocTipoLocal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tloc_codigo", nullable = false)
    private Integer tlocCodigo;
    @Column(name = "tloc_descricao", length = 50)
    private String tlocDescricao;
    @OneToMany(mappedBy = "tlocTipoLocal")
    private Collection<TlocTransportadorLocal> tlocTransportadorLocalCollection;
    @OneToMany(mappedBy = "tlocTipoLocal")
    private Collection<ElocEmbarcadorLocal> elocEmbarcadorLocalCollection;

    public TlocTipoLocal() {
    }

    public TlocTipoLocal(Integer tlocCodigo) {
        this.tlocCodigo = tlocCodigo;
    }

    public Integer getTlocCodigo() {
        return tlocCodigo;
    }

    public void setTlocCodigo(Integer tlocCodigo) {
        this.tlocCodigo = tlocCodigo;
    }

    public String getTlocDescricao() {
        return tlocDescricao;
    }

    public void setTlocDescricao(String tlocDescricao) {
        this.tlocDescricao = tlocDescricao;
    }

    public Collection<TlocTransportadorLocal> getTlocTransportadorLocalCollection() {
        return tlocTransportadorLocalCollection;
    }

    public void setTlocTransportadorLocalCollection(Collection<TlocTransportadorLocal> tlocTransportadorLocalCollection) {
        this.tlocTransportadorLocalCollection = tlocTransportadorLocalCollection;
    }

    public Collection<ElocEmbarcadorLocal> getElocEmbarcadorLocalCollection() {
        return elocEmbarcadorLocalCollection;
    }

    public void setElocEmbarcadorLocalCollection(Collection<ElocEmbarcadorLocal> elocEmbarcadorLocalCollection) {
        this.elocEmbarcadorLocalCollection = elocEmbarcadorLocalCollection;
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
        if (!(object instanceof TlocTipoLocal)) {
            return false;
        }
        TlocTipoLocal other = (TlocTipoLocal) object;
        if ((this.tlocCodigo == null && other.tlocCodigo != null) || (this.tlocCodigo != null && !this.tlocCodigo.equals(other.tlocCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.TlocTipoLocal[tlocCodigo=" + tlocCodigo + "]";
    }

}
