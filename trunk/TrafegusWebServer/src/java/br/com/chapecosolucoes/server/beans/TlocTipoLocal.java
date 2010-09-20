/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "tloc_tipo_local", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TlocTipoLocal.findAll", query = "SELECT t FROM TlocTipoLocal t"),
    @NamedQuery(name = "TlocTipoLocal.findByTlocCodigo", query = "SELECT t FROM TlocTipoLocal t WHERE t.tlocCodigo = :tlocCodigo"),
    @NamedQuery(name = "TlocTipoLocal.findByTlocDescricao", query = "SELECT t FROM TlocTipoLocal t WHERE t.tlocDescricao = :tlocDescricao")})
public class TlocTipoLocal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tloc_codigo", nullable = false)
    private Integer tlocCodigo;
    @Column(name = "tloc_descricao", length = 50)
    private String tlocDescricao;
    @OneToMany(mappedBy = "tlocTipoLocal", fetch = FetchType.EAGER)
    private List<TlocTransportadorLocal> tlocTransportadorLocalList;
    @OneToMany(mappedBy = "tlocTipoLocal", fetch = FetchType.EAGER)
    private List<ElocEmbarcadorLocal> elocEmbarcadorLocalList;

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

    public List<TlocTransportadorLocal> getTlocTransportadorLocalList() {
        return tlocTransportadorLocalList;
    }

    public void setTlocTransportadorLocalList(List<TlocTransportadorLocal> tlocTransportadorLocalList) {
        this.tlocTransportadorLocalList = tlocTransportadorLocalList;
    }

    public List<ElocEmbarcadorLocal> getElocEmbarcadorLocalList() {
        return elocEmbarcadorLocalList;
    }

    public void setElocEmbarcadorLocalList(List<ElocEmbarcadorLocal> elocEmbarcadorLocalList) {
        this.elocEmbarcadorLocalList = elocEmbarcadorLocalList;
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
