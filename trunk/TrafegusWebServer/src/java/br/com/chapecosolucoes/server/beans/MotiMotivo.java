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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "moti_motivo")
@NamedQueries({
    @NamedQuery(name = "MotiMotivo.findAll", query = "SELECT m FROM MotiMotivo m")})
public class MotiMotivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "moti_codigo", nullable = false)
    private Integer motiCodigo;
    @Column(name = "moti_descricao", length = 100)
    private String motiDescricao;
    @JoinColumn(name = "moti_tmot_codigo", referencedColumnName = "tmot_codigo")
    @ManyToOne
    private TmotTipoMotivo tmotTipoMotivo;
    @OneToMany(mappedBy = "motiMotivo")
    private Collection<VestViagemEstatus> vestViagemEstatusCollection;

    public MotiMotivo() {
    }

    public MotiMotivo(Integer motiCodigo) {
        this.motiCodigo = motiCodigo;
    }

    public Integer getMotiCodigo() {
        return motiCodigo;
    }

    public void setMotiCodigo(Integer motiCodigo) {
        this.motiCodigo = motiCodigo;
    }

    public String getMotiDescricao() {
        return motiDescricao;
    }

    public void setMotiDescricao(String motiDescricao) {
        this.motiDescricao = motiDescricao;
    }

    public TmotTipoMotivo getTmotTipoMotivo() {
        return tmotTipoMotivo;
    }

    public void setTmotTipoMotivo(TmotTipoMotivo tmotTipoMotivo) {
        this.tmotTipoMotivo = tmotTipoMotivo;
    }

    public Collection<VestViagemEstatus> getVestViagemEstatusCollection() {
        return vestViagemEstatusCollection;
    }

    public void setVestViagemEstatusCollection(Collection<VestViagemEstatus> vestViagemEstatusCollection) {
        this.vestViagemEstatusCollection = vestViagemEstatusCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (motiCodigo != null ? motiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotiMotivo)) {
            return false;
        }
        MotiMotivo other = (MotiMotivo) object;
        if ((this.motiCodigo == null && other.motiCodigo != null) || (this.motiCodigo != null && !this.motiCodigo.equals(other.motiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.MotiMotivo[motiCodigo=" + motiCodigo + "]";
    }

}
