/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "vtru_veiculo_truck")
@NamedQueries({
    @NamedQuery(name = "VtruVeiculoTruck.findAll", query = "SELECT v FROM VtruVeiculoTruck v"),
    @NamedQuery(name = "VtruVeiculoTruck.findByVtruVeicOrasCodigo", query = "SELECT v FROM VtruVeiculoTruck v WHERE v.vtruVeicOrasCodigo = :vtruVeicOrasCodigo")})
public class VtruVeiculoTruck implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vtru_veic_oras_codigo")
    private Integer vtruVeicOrasCodigo;
    @JoinColumn(name = "vtru_veic_oras_codigo", referencedColumnName = "veic_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "vtru_tope_codigo", referencedColumnName = "tope_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private TopeTipoOperacao topeTipoOperacao;
    @JoinColumn(name = "vtru_evca_codigo", referencedColumnName = "evca_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private EvcaEstatusVeiculoCarga evcaEstatusVeiculoCarga;
    @JoinColumn(name = "vtru_eras_codigo", referencedColumnName = "eras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private ErasEstacaoRastreamento erasEstacaoRastreamento;

    public VtruVeiculoTruck() {
    }

    public VtruVeiculoTruck(Integer vtruVeicOrasCodigo) {
        this.vtruVeicOrasCodigo = vtruVeicOrasCodigo;
    }

    public Integer getVtruVeicOrasCodigo() {
        return vtruVeicOrasCodigo;
    }

    public void setVtruVeicOrasCodigo(Integer vtruVeicOrasCodigo) {
        this.vtruVeicOrasCodigo = vtruVeicOrasCodigo;
    }

    public VeicVeiculo getVeicVeiculo() {
        return veicVeiculo;
    }

    public void setVeicVeiculo(VeicVeiculo veicVeiculo) {
        this.veicVeiculo = veicVeiculo;
    }

    public TopeTipoOperacao getTopeTipoOperacao() {
        return topeTipoOperacao;
    }

    public void setTopeTipoOperacao(TopeTipoOperacao topeTipoOperacao) {
        this.topeTipoOperacao = topeTipoOperacao;
    }

    public EvcaEstatusVeiculoCarga getEvcaEstatusVeiculoCarga() {
        return evcaEstatusVeiculoCarga;
    }

    public void setEvcaEstatusVeiculoCarga(EvcaEstatusVeiculoCarga evcaEstatusVeiculoCarga) {
        this.evcaEstatusVeiculoCarga = evcaEstatusVeiculoCarga;
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
        hash += (vtruVeicOrasCodigo != null ? vtruVeicOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtruVeiculoTruck)) {
            return false;
        }
        VtruVeiculoTruck other = (VtruVeiculoTruck) object;
        if ((this.vtruVeicOrasCodigo == null && other.vtruVeicOrasCodigo != null) || (this.vtruVeicOrasCodigo != null && !this.vtruVeicOrasCodigo.equals(other.vtruVeicOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VtruVeiculoTruck[vtruVeicOrasCodigo=" + vtruVeicOrasCodigo + "]";
    }

}
