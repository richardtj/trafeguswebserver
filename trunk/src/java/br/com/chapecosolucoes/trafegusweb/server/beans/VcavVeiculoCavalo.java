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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "vcav_veiculo_cavalo", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VcavVeiculoCavalo.findAll", query = "SELECT v FROM VcavVeiculoCavalo v"),
    @NamedQuery(name = "VcavVeiculoCavalo.findByVcavVeicOrasCodigo", query = "SELECT v FROM VcavVeiculoCavalo v WHERE v.vcavVeicOrasCodigo = :vcavVeicOrasCodigo")})
public class VcavVeiculoCavalo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vcav_veic_oras_codigo", nullable = false)
    private Integer vcavVeicOrasCodigo;
    @OneToMany(mappedBy = "vcavVeiculoCavalo")
    private Collection<VccaVeiculoCavaloCarreta> vccaVeiculoCavaloCarretaCollection;
    @JoinColumn(name = "vcav_veic_oras_codigo", referencedColumnName = "veic_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "vcav_tope_codigo", referencedColumnName = "tope_codigo")
    @ManyToOne
    private TopeTipoOperacao topeTipoOperacao;
    @JoinColumn(name = "vcav_eras_codigo", referencedColumnName = "eras_codigo")
    @ManyToOne
    private ErasEstacaoRastreamento erasEstacaoRastreamento;

    public VcavVeiculoCavalo() {
    }

    public VcavVeiculoCavalo(Integer vcavVeicOrasCodigo) {
        this.vcavVeicOrasCodigo = vcavVeicOrasCodigo;
    }

    public Integer getVcavVeicOrasCodigo() {
        return vcavVeicOrasCodigo;
    }

    public void setVcavVeicOrasCodigo(Integer vcavVeicOrasCodigo) {
        this.vcavVeicOrasCodigo = vcavVeicOrasCodigo;
    }

    public Collection<VccaVeiculoCavaloCarreta> getVccaVeiculoCavaloCarretaCollection() {
        return vccaVeiculoCavaloCarretaCollection;
    }

    public void setVccaVeiculoCavaloCarretaCollection(Collection<VccaVeiculoCavaloCarreta> vccaVeiculoCavaloCarretaCollection) {
        this.vccaVeiculoCavaloCarretaCollection = vccaVeiculoCavaloCarretaCollection;
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
        hash += (vcavVeicOrasCodigo != null ? vcavVeicOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VcavVeiculoCavalo)) {
            return false;
        }
        VcavVeiculoCavalo other = (VcavVeiculoCavalo) object;
        if ((this.vcavVeicOrasCodigo == null && other.vcavVeicOrasCodigo != null) || (this.vcavVeicOrasCodigo != null && !this.vcavVeicOrasCodigo.equals(other.vcavVeicOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VcavVeiculoCavalo[vcavVeicOrasCodigo=" + vcavVeicOrasCodigo + "]";
    }

}
