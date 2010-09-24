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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "evca_estatus_veiculo_carga", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EvcaEstatusVeiculoCarga.findAll", query = "SELECT e FROM EvcaEstatusVeiculoCarga e"),
    @NamedQuery(name = "EvcaEstatusVeiculoCarga.findByEvcaCodigo", query = "SELECT e FROM EvcaEstatusVeiculoCarga e WHERE e.evcaCodigo = :evcaCodigo"),
    @NamedQuery(name = "EvcaEstatusVeiculoCarga.findByEvcaDescricao", query = "SELECT e FROM EvcaEstatusVeiculoCarga e WHERE e.evcaDescricao = :evcaDescricao"),
    @NamedQuery(name = "EvcaEstatusVeiculoCarga.findByEvcaCodigoGr", query = "SELECT e FROM EvcaEstatusVeiculoCarga e WHERE e.evcaCodigoGr = :evcaCodigoGr")})
public class EvcaEstatusVeiculoCarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "evca_codigo", nullable = false)
    private Integer evcaCodigo;
    @Column(name = "evca_descricao", length = 50)
    private String evcaDescricao;
    @Column(name = "evca_codigo_gr")
    private Integer evcaCodigoGr;
    @OneToMany(mappedBy = "evcaEstatusVeiculoCarga")
    private Collection<VcarVeiculoCarreta> vcarVeiculoCarretaCollection;
    @OneToMany(mappedBy = "evcaEstatusVeiculoCarga")
    private Collection<VtruVeiculoTruck> vtruVeiculoTruckCollection;
    @OneToMany(mappedBy = "evcaEstatusVeiculoCarga")
    private Collection<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaCollection;
    @OneToMany(mappedBy = "evcaEstatusVeiculoCarga")
    private Collection<VveiViagemVeiculo> vveiViagemVeiculoCollection;

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

    public Collection<VcarVeiculoCarreta> getVcarVeiculoCarretaCollection() {
        return vcarVeiculoCarretaCollection;
    }

    public void setVcarVeiculoCarretaCollection(Collection<VcarVeiculoCarreta> vcarVeiculoCarretaCollection) {
        this.vcarVeiculoCarretaCollection = vcarVeiculoCarretaCollection;
    }

    public Collection<VtruVeiculoTruck> getVtruVeiculoTruckCollection() {
        return vtruVeiculoTruckCollection;
    }

    public void setVtruVeiculoTruckCollection(Collection<VtruVeiculoTruck> vtruVeiculoTruckCollection) {
        this.vtruVeiculoTruckCollection = vtruVeiculoTruckCollection;
    }

    public Collection<VucaVeiculoUtilitarioCarga> getVucaVeiculoUtilitarioCargaCollection() {
        return vucaVeiculoUtilitarioCargaCollection;
    }

    public void setVucaVeiculoUtilitarioCargaCollection(Collection<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaCollection) {
        this.vucaVeiculoUtilitarioCargaCollection = vucaVeiculoUtilitarioCargaCollection;
    }

    public Collection<VveiViagemVeiculo> getVveiViagemVeiculoCollection() {
        return vveiViagemVeiculoCollection;
    }

    public void setVveiViagemVeiculoCollection(Collection<VveiViagemVeiculo> vveiViagemVeiculoCollection) {
        this.vveiViagemVeiculoCollection = vveiViagemVeiculoCollection;
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
