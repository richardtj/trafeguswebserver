/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "vuca_veiculo_utilitario_carga", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VucaVeiculoUtilitarioCarga.findAll", query = "SELECT v FROM VucaVeiculoUtilitarioCarga v"),
    @NamedQuery(name = "VucaVeiculoUtilitarioCarga.findByVucaVeicOrasCodigo", query = "SELECT v FROM VucaVeiculoUtilitarioCarga v WHERE v.vucaVeicOrasCodigo = :vucaVeicOrasCodigo")})
public class VucaVeiculoUtilitarioCarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vuca_veic_oras_codigo", nullable = false)
    private Integer vucaVeicOrasCodigo;
    @JoinColumn(name = "vuca_veic_oras_codigo", referencedColumnName = "veic_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "vuca_tope_codigo", referencedColumnName = "tope_codigo")
    @ManyToOne
    private TopeTipoOperacao topeTipoOperacao;
    @JoinColumn(name = "vuca_evca_codigo", referencedColumnName = "evca_codigo")
    @ManyToOne
    private EvcaEstatusVeiculoCarga evcaEstatusVeiculoCarga;
    @JoinColumn(name = "vuca_eras_codigo", referencedColumnName = "eras_codigo")
    @ManyToOne
    private ErasEstacaoRastreamento erasEstacaoRastreamento;

    public VucaVeiculoUtilitarioCarga() {
    }

    public VucaVeiculoUtilitarioCarga(Integer vucaVeicOrasCodigo) {
        this.vucaVeicOrasCodigo = vucaVeicOrasCodigo;
    }

    public Integer getVucaVeicOrasCodigo() {
        return vucaVeicOrasCodigo;
    }

    public void setVucaVeicOrasCodigo(Integer vucaVeicOrasCodigo) {
        this.vucaVeicOrasCodigo = vucaVeicOrasCodigo;
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
        hash += (vucaVeicOrasCodigo != null ? vucaVeicOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VucaVeiculoUtilitarioCarga)) {
            return false;
        }
        VucaVeiculoUtilitarioCarga other = (VucaVeiculoUtilitarioCarga) object;
        if ((this.vucaVeicOrasCodigo == null && other.vucaVeicOrasCodigo != null) || (this.vucaVeicOrasCodigo != null && !this.vucaVeicOrasCodigo.equals(other.vucaVeicOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VucaVeiculoUtilitarioCarga[vucaVeicOrasCodigo=" + vucaVeicOrasCodigo + "]";
    }

}
