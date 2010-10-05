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
@Table(name = "evca_estatus_veiculo_carga")
@NamedQueries({
    @NamedQuery(name = "EvcaEstatusVeiculoCarga.findAll", query = "SELECT e FROM EvcaEstatusVeiculoCarga e")})
public class EvcaEstatusVeiculoCarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "evca_codigo")
    private Integer evcaCodigo;
    @Column(name = "evca_descricao")
    private String evcaDescricao;
    @Column(name = "evca_codigo_gr")
    private Integer evcaCodigoGr;
    @OneToMany(mappedBy = "evcaEstatusVeiculoCarga")
    private Set<VtruVeiculoTruck> vtruVeiculoTruckSet;
    @OneToMany(mappedBy = "evcaEstatusVeiculoCarga")
    private Set<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaSet;
    @OneToMany(mappedBy = "evcaEstatusVeiculoCarga")
    private Set<VveiViagemVeiculo> vveiViagemVeiculoSet;

    public EvcaEstatusVeiculoCarga() {
    }

    public EvcaEstatusVeiculoCarga(Integer evcaCodigo) {
        this.evcaCodigo = evcaCodigo;
    }

    public Integer getEvcaCodigo() {
        return evcaCodigo;
    }

    public void setEvcaCodigo(Integer evcaCodigo) {
        this.evcaCodigo = evcaCodigo;
    }

    public String getEvcaDescricao() {
        return evcaDescricao;
    }

    public void setEvcaDescricao(String evcaDescricao) {
        this.evcaDescricao = evcaDescricao;
    }

    public Integer getEvcaCodigoGr() {
        return evcaCodigoGr;
    }

    public void setEvcaCodigoGr(Integer evcaCodigoGr) {
        this.evcaCodigoGr = evcaCodigoGr;
    }

    public Set<VtruVeiculoTruck> getVtruVeiculoTruckSet() {
        return vtruVeiculoTruckSet;
    }

    public void setVtruVeiculoTruckSet(Set<VtruVeiculoTruck> vtruVeiculoTruckSet) {
        this.vtruVeiculoTruckSet = vtruVeiculoTruckSet;
    }

    public Set<VucaVeiculoUtilitarioCarga> getVucaVeiculoUtilitarioCargaSet() {
        return vucaVeiculoUtilitarioCargaSet;
    }

    public void setVucaVeiculoUtilitarioCargaSet(Set<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaSet) {
        this.vucaVeiculoUtilitarioCargaSet = vucaVeiculoUtilitarioCargaSet;
    }

    public Set<VveiViagemVeiculo> getVveiViagemVeiculoSet() {
        return vveiViagemVeiculoSet;
    }

    public void setVveiViagemVeiculoSet(Set<VveiViagemVeiculo> vveiViagemVeiculoSet) {
        this.vveiViagemVeiculoSet = vveiViagemVeiculoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evcaCodigo != null ? evcaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvcaEstatusVeiculoCarga)) {
            return false;
        }
        EvcaEstatusVeiculoCarga other = (EvcaEstatusVeiculoCarga) object;
        if ((this.evcaCodigo == null && other.evcaCodigo != null) || (this.evcaCodigo != null && !this.evcaCodigo.equals(other.evcaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EvcaEstatusVeiculoCarga[evcaCodigo=" + evcaCodigo + "]";
    }

}
