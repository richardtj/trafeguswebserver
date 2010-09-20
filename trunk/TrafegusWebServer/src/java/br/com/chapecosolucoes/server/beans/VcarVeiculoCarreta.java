/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

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
@Table(name = "vcar_veiculo_carreta", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VcarVeiculoCarreta.findAll", query = "SELECT v FROM VcarVeiculoCarreta v"),
    @NamedQuery(name = "VcarVeiculoCarreta.findByVcarVeicOrasCodigo", query = "SELECT v FROM VcarVeiculoCarreta v WHERE v.vcarVeicOrasCodigo = :vcarVeicOrasCodigo"),
    @NamedQuery(name = "VcarVeiculoCarreta.findByVcarNumeroPalets", query = "SELECT v FROM VcarVeiculoCarreta v WHERE v.vcarNumeroPalets = :vcarNumeroPalets")})
public class VcarVeiculoCarreta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vcar_veic_oras_codigo", nullable = false)
    private Integer vcarVeicOrasCodigo;
    @Column(name = "vcar_numero_palets")
    private Integer vcarNumeroPalets;
    @OneToOne(mappedBy = "vcarVeiculoCarreta", fetch = FetchType.EAGER)
    private VccaVeiculoCavaloCarreta vccaVeiculoCavaloCarreta;
    @JoinColumn(name = "vcar_veic_oras_codigo", referencedColumnName = "veic_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "vcar_evca_codigo", referencedColumnName = "evca_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private EvcaEstatusVeiculoCarga evcaEstatusVeiculoCarga;

    public VcarVeiculoCarreta() {
    }

    public VcarVeiculoCarreta(Integer vcarVeicOrasCodigo) {
        this.vcarVeicOrasCodigo = vcarVeicOrasCodigo;
    }

    public Integer getVcarVeicOrasCodigo() {
        return vcarVeicOrasCodigo;
    }

    public void setVcarVeicOrasCodigo(Integer vcarVeicOrasCodigo) {
        this.vcarVeicOrasCodigo = vcarVeicOrasCodigo;
    }

    public Integer getVcarNumeroPalets() {
        return vcarNumeroPalets;
    }

    public void setVcarNumeroPalets(Integer vcarNumeroPalets) {
        this.vcarNumeroPalets = vcarNumeroPalets;
    }

    public VccaVeiculoCavaloCarreta getVccaVeiculoCavaloCarreta() {
        return vccaVeiculoCavaloCarreta;
    }

    public void setVccaVeiculoCavaloCarreta(VccaVeiculoCavaloCarreta vccaVeiculoCavaloCarreta) {
        this.vccaVeiculoCavaloCarreta = vccaVeiculoCavaloCarreta;
    }

    public VeicVeiculo getVeicVeiculo() {
        return veicVeiculo;
    }

    public void setVeicVeiculo(VeicVeiculo veicVeiculo) {
        this.veicVeiculo = veicVeiculo;
    }

    public EvcaEstatusVeiculoCarga getEvcaEstatusVeiculoCarga() {
        return evcaEstatusVeiculoCarga;
    }

    public void setEvcaEstatusVeiculoCarga(EvcaEstatusVeiculoCarga evcaEstatusVeiculoCarga) {
        this.evcaEstatusVeiculoCarga = evcaEstatusVeiculoCarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vcarVeicOrasCodigo != null ? vcarVeicOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VcarVeiculoCarreta)) {
            return false;
        }
        VcarVeiculoCarreta other = (VcarVeiculoCarreta) object;
        if ((this.vcarVeicOrasCodigo == null && other.vcarVeicOrasCodigo != null) || (this.vcarVeicOrasCodigo != null && !this.vcarVeicOrasCodigo.equals(other.vcarVeicOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.VcarVeiculoCarreta[vcarVeicOrasCodigo=" + vcarVeicOrasCodigo + "]";
    }

}
