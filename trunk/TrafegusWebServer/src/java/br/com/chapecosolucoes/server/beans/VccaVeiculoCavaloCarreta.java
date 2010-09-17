/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "vcca_veiculo_cavalo_carreta", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"vcca_vcar_veic_oras_codigo"})})
@NamedQueries({
    @NamedQuery(name = "VccaVeiculoCavaloCarreta.findAll", query = "SELECT v FROM VccaVeiculoCavaloCarreta v")})
public class VccaVeiculoCavaloCarreta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vcca_codigo", nullable = false)
    private Integer vccaCodigo;
    @Column(name = "vcca_sequencia")
    private Integer vccaSequencia;
    @Column(name = "vcca_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vccaDataCadastro;
    @Column(name = "vcca_codigo_gr")
    private Integer vccaCodigoGr;
    @Column(name = "vcca_importado")
    private Character vccaImportado;
    @JoinColumn(name = "vcca_vcav_veic_oras_codigo", referencedColumnName = "vcav_veic_oras_codigo")
    @ManyToOne
    private VcavVeiculoCavalo vcavVeiculoCavalo;
    @JoinColumn(name = "vcca_vcar_veic_oras_codigo", referencedColumnName = "vcar_veic_oras_codigo")
    @OneToOne
    private VcarVeiculoCarreta vcarVeiculoCarreta;
    @JoinColumn(name = "vcca_cont_oras_codigo", referencedColumnName = "cont_oras_codigo")
    @ManyToOne
    private ContContainer contContainer;

    public VccaVeiculoCavaloCarreta() {
    }

    public VccaVeiculoCavaloCarreta(Integer vccaCodigo) {
        this.vccaCodigo = vccaCodigo;
    }

    public Integer getVccaCodigo() {
        return vccaCodigo;
    }

    public void setVccaCodigo(Integer vccaCodigo) {
        this.vccaCodigo = vccaCodigo;
    }

    public Integer getVccaSequencia() {
        return vccaSequencia;
    }

    public void setVccaSequencia(Integer vccaSequencia) {
        this.vccaSequencia = vccaSequencia;
    }

    public Date getVccaDataCadastro() {
        return vccaDataCadastro;
    }

    public void setVccaDataCadastro(Date vccaDataCadastro) {
        this.vccaDataCadastro = vccaDataCadastro;
    }

    public Integer getVccaCodigoGr() {
        return vccaCodigoGr;
    }

    public void setVccaCodigoGr(Integer vccaCodigoGr) {
        this.vccaCodigoGr = vccaCodigoGr;
    }

    public Character getVccaImportado() {
        return vccaImportado;
    }

    public void setVccaImportado(Character vccaImportado) {
        this.vccaImportado = vccaImportado;
    }

    public VcavVeiculoCavalo getVcavVeiculoCavalo() {
        return vcavVeiculoCavalo;
    }

    public void setVcavVeiculoCavalo(VcavVeiculoCavalo vcavVeiculoCavalo) {
        this.vcavVeiculoCavalo = vcavVeiculoCavalo;
    }

    public VcarVeiculoCarreta getVcarVeiculoCarreta() {
        return vcarVeiculoCarreta;
    }

    public void setVcarVeiculoCarreta(VcarVeiculoCarreta vcarVeiculoCarreta) {
        this.vcarVeiculoCarreta = vcarVeiculoCarreta;
    }

    public ContContainer getContContainer() {
        return contContainer;
    }

    public void setContContainer(ContContainer contContainer) {
        this.contContainer = contContainer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vccaCodigo != null ? vccaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VccaVeiculoCavaloCarreta)) {
            return false;
        }
        VccaVeiculoCavaloCarreta other = (VccaVeiculoCavaloCarreta) object;
        if ((this.vccaCodigo == null && other.vccaCodigo != null) || (this.vccaCodigo != null && !this.vccaCodigo.equals(other.vccaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.VccaVeiculoCavaloCarreta[vccaCodigo=" + vccaCodigo + "]";
    }

}
