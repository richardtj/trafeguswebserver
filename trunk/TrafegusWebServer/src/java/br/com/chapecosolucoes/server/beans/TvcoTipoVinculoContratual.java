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
@Table(name = "tvco_tipo_vinculo_contratual", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TvcoTipoVinculoContratual.findAll", query = "SELECT t FROM TvcoTipoVinculoContratual t"),
    @NamedQuery(name = "TvcoTipoVinculoContratual.findByTvcoCodigo", query = "SELECT t FROM TvcoTipoVinculoContratual t WHERE t.tvcoCodigo = :tvcoCodigo"),
    @NamedQuery(name = "TvcoTipoVinculoContratual.findByTvcoDescricao", query = "SELECT t FROM TvcoTipoVinculoContratual t WHERE t.tvcoDescricao = :tvcoDescricao")})
public class TvcoTipoVinculoContratual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tvco_codigo", nullable = false)
    private Integer tvcoCodigo;
    @Column(name = "tvco_descricao", length = 50)
    private String tvcoDescricao;
    @OneToMany(mappedBy = "tvcoTipoVinculoContratual", fetch = FetchType.EAGER)
    private List<TembTransportadorEmbarcador> tembTransportadorEmbarcadorList;
    @OneToMany(mappedBy = "tvcoTipoVinculoContratual", fetch = FetchType.EAGER)
    private List<VembVeiculoEmbarcador> vembVeiculoEmbarcadorList;
    @OneToMany(mappedBy = "tvcoTipoVinculoContratual", fetch = FetchType.EAGER)
    private List<VtraVeiculoTransportador> vtraVeiculoTransportadorList;

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

    public List<TembTransportadorEmbarcador> getTembTransportadorEmbarcadorList() {
        return tembTransportadorEmbarcadorList;
    }

    public void setTembTransportadorEmbarcadorList(List<TembTransportadorEmbarcador> tembTransportadorEmbarcadorList) {
        this.tembTransportadorEmbarcadorList = tembTransportadorEmbarcadorList;
    }

    public List<VembVeiculoEmbarcador> getVembVeiculoEmbarcadorList() {
        return vembVeiculoEmbarcadorList;
    }

    public void setVembVeiculoEmbarcadorList(List<VembVeiculoEmbarcador> vembVeiculoEmbarcadorList) {
        this.vembVeiculoEmbarcadorList = vembVeiculoEmbarcadorList;
    }

    public List<VtraVeiculoTransportador> getVtraVeiculoTransportadorList() {
        return vtraVeiculoTransportadorList;
    }

    public void setVtraVeiculoTransportadorList(List<VtraVeiculoTransportador> vtraVeiculoTransportadorList) {
        this.vtraVeiculoTransportadorList = vtraVeiculoTransportadorList;
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
        return "br.com.chapecosolucoes.server.beans.TvcoTipoVinculoContratual[tvcoCodigo=" + tvcoCodigo + "]";
    }

}
