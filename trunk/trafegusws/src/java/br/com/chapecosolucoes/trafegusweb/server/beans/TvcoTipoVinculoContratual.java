/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Set;
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
 * @author emerson
 */
@Entity
@Table(name = "tvco_tipo_vinculo_contratual")
@NamedQueries({
    @NamedQuery(name = "TvcoTipoVinculoContratual.findAll", query = "SELECT t FROM TvcoTipoVinculoContratual t")})
public class TvcoTipoVinculoContratual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tvco_codigo")
    private Integer tvcoCodigo;
    @Column(name = "tvco_descricao")
    private String tvcoDescricao;
    @OneToMany(mappedBy = "tvcoTipoVinculoContratual")
    private Set<VtraVeiculoTransportador> vtraVeiculoTransportadorSet;

    public TvcoTipoVinculoContratual() {
    }

    public TvcoTipoVinculoContratual(Integer tvcoCodigo) {
        this.tvcoCodigo = tvcoCodigo;
    }

    public Integer getTvcoCodigo() {
        return tvcoCodigo;
    }

    public void setTvcoCodigo(Integer tvcoCodigo) {
        this.tvcoCodigo = tvcoCodigo;
    }

    public String getTvcoDescricao() {
        return tvcoDescricao;
    }

    public void setTvcoDescricao(String tvcoDescricao) {
        this.tvcoDescricao = tvcoDescricao;
    }

    public Set<VtraVeiculoTransportador> getVtraVeiculoTransportadorSet() {
        return vtraVeiculoTransportadorSet;
    }

    public void setVtraVeiculoTransportadorSet(Set<VtraVeiculoTransportador> vtraVeiculoTransportadorSet) {
        this.vtraVeiculoTransportadorSet = vtraVeiculoTransportadorSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tvcoCodigo != null ? tvcoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TvcoTipoVinculoContratual)) {
            return false;
        }
        TvcoTipoVinculoContratual other = (TvcoTipoVinculoContratual) object;
        if ((this.tvcoCodigo == null && other.tvcoCodigo != null) || (this.tvcoCodigo != null && !this.tvcoCodigo.equals(other.tvcoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TvcoTipoVinculoContratual[tvcoCodigo=" + tvcoCodigo + "]";
    }

}
