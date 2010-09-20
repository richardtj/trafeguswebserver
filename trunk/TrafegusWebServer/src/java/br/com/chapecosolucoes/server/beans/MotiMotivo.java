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
@Table(name = "moti_motivo", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "MotiMotivo.findAll", query = "SELECT m FROM MotiMotivo m"),
    @NamedQuery(name = "MotiMotivo.findByMotiCodigo", query = "SELECT m FROM MotiMotivo m WHERE m.motiCodigo = :motiCodigo"),
    @NamedQuery(name = "MotiMotivo.findByMotiDescricao", query = "SELECT m FROM MotiMotivo m WHERE m.motiDescricao = :motiDescricao")})
public class MotiMotivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "moti_codigo", nullable = false)
    private Integer motiCodigo;
    @Column(name = "moti_descricao", length = 100)
    private String motiDescricao;
    @JoinColumn(name = "moti_tmot_codigo", referencedColumnName = "tmot_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TmotTipoMotivo tmotTipoMotivo;
    @OneToMany(mappedBy = "motiMotivo", fetch = FetchType.EAGER)
    private List<VestViagemEstatus> vestViagemEstatusList;

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

    public List<VestViagemEstatus> getVestViagemEstatusList() {
        return vestViagemEstatusList;
    }

    public void setVestViagemEstatusList(List<VestViagemEstatus> vestViagemEstatusList) {
        this.vestViagemEstatusList = vestViagemEstatusList;
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
