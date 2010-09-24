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
@Table(name = "vmot_veiculo_moto", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VmotVeiculoMoto.findAll", query = "SELECT v FROM VmotVeiculoMoto v"),
    @NamedQuery(name = "VmotVeiculoMoto.findByVmotVeicOrasCodigo", query = "SELECT v FROM VmotVeiculoMoto v WHERE v.vmotVeicOrasCodigo = :vmotVeicOrasCodigo")})
public class VmotVeiculoMoto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vmot_veic_oras_codigo", nullable = false)
    private Integer vmotVeicOrasCodigo;
    @JoinColumn(name = "vmot_veic_oras_codigo", referencedColumnName = "veic_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "vmot_tope_codigo", referencedColumnName = "tope_codigo")
    @ManyToOne
    private TopeTipoOperacao topeTipoOperacao;
    @JoinColumn(name = "vmot_eras_codigo", referencedColumnName = "eras_codigo")
    @ManyToOne
    private ErasEstacaoRastreamento erasEstacaoRastreamento;

    public VmotVeiculoMoto() {
    }

    public VmotVeiculoMoto(Integer vmotVeicOrasCodigo) {
        this.vmotVeicOrasCodigo = vmotVeicOrasCodigo;
    }

    public Integer getVmotVeicOrasCodigo() {
        return vmotVeicOrasCodigo;
    }

    public void setVmotVeicOrasCodigo(Integer vmotVeicOrasCodigo) {
        this.vmotVeicOrasCodigo = vmotVeicOrasCodigo;
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

    public ErasEstacaoRastreamento getErasEstacaoRastreamento() {
        return erasEstacaoRastreamento;
    }

    public void setErasEstacaoRastreamento(ErasEstacaoRastreamento erasEstacaoRastreamento) {
        this.erasEstacaoRastreamento = erasEstacaoRastreamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vmotVeicOrasCodigo != null ? vmotVeicOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VmotVeiculoMoto)) {
            return false;
        }
        VmotVeiculoMoto other = (VmotVeiculoMoto) object;
        if ((this.vmotVeicOrasCodigo == null && other.vmotVeicOrasCodigo != null) || (this.vmotVeicOrasCodigo != null && !this.vmotVeicOrasCodigo.equals(other.vmotVeicOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VmotVeiculoMoto[vmotVeicOrasCodigo=" + vmotVeicOrasCodigo + "]";
    }

}
