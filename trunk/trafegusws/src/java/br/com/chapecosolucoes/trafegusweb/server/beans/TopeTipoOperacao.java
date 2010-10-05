/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "tope_tipo_operacao")
@NamedQueries({
    @NamedQuery(name = "TopeTipoOperacao.findAll", query = "SELECT t FROM TopeTipoOperacao t")})
public class TopeTipoOperacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tope_codigo")
    private Integer topeCodigo;
    @Column(name = "tope_descricao")
    private String topeDescricao;
    @Column(name = "tope_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date topeDataCadastro;
    @Column(name = "tope_codigo_gr")
    private Integer topeCodigoGr;
    @Column(name = "tope_importado")
    private Character topeImportado;
    @OneToMany(mappedBy = "topeTipoOperacao")
    private Set<VtruVeiculoTruck> vtruVeiculoTruckSet;
    @OneToMany(mappedBy = "topeTipoOperacao")
    private Set<VupaVeiculoUtilitarioPasse> vupaVeiculoUtilitarioPasseSet;
    @OneToMany(mappedBy = "topeTipoOperacao")
    private Set<VmotVeiculoMoto> vmotVeiculoMotoSet;
    @OneToMany(mappedBy = "topeTipoOperacao")
    private Set<ViagViagem> viagViagemSet;
    @OneToMany(mappedBy = "topeTipoOperacao")
    private Set<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaSet;

    public TopeTipoOperacao() {
    }

    public TopeTipoOperacao(Integer topeCodigo) {
        this.topeCodigo = topeCodigo;
    }

    public Integer getTopeCodigo() {
        return topeCodigo;
    }

    public void setTopeCodigo(Integer topeCodigo) {
        this.topeCodigo = topeCodigo;
    }

    public String getTopeDescricao() {
        return topeDescricao;
    }

    public void setTopeDescricao(String topeDescricao) {
        this.topeDescricao = topeDescricao;
    }

    public Date getTopeDataCadastro() {
        return topeDataCadastro;
    }

    public void setTopeDataCadastro(Date topeDataCadastro) {
        this.topeDataCadastro = topeDataCadastro;
    }

    public Integer getTopeCodigoGr() {
        return topeCodigoGr;
    }

    public void setTopeCodigoGr(Integer topeCodigoGr) {
        this.topeCodigoGr = topeCodigoGr;
    }

    public Character getTopeImportado() {
        return topeImportado;
    }

    public void setTopeImportado(Character topeImportado) {
        this.topeImportado = topeImportado;
    }

    public Set<VtruVeiculoTruck> getVtruVeiculoTruckSet() {
        return vtruVeiculoTruckSet;
    }

    public void setVtruVeiculoTruckSet(Set<VtruVeiculoTruck> vtruVeiculoTruckSet) {
        this.vtruVeiculoTruckSet = vtruVeiculoTruckSet;
    }

    public Set<VupaVeiculoUtilitarioPasse> getVupaVeiculoUtilitarioPasseSet() {
        return vupaVeiculoUtilitarioPasseSet;
    }

    public void setVupaVeiculoUtilitarioPasseSet(Set<VupaVeiculoUtilitarioPasse> vupaVeiculoUtilitarioPasseSet) {
        this.vupaVeiculoUtilitarioPasseSet = vupaVeiculoUtilitarioPasseSet;
    }

    public Set<VmotVeiculoMoto> getVmotVeiculoMotoSet() {
        return vmotVeiculoMotoSet;
    }

    public void setVmotVeiculoMotoSet(Set<VmotVeiculoMoto> vmotVeiculoMotoSet) {
        this.vmotVeiculoMotoSet = vmotVeiculoMotoSet;
    }

    public Set<ViagViagem> getViagViagemSet() {
        return viagViagemSet;
    }

    public void setViagViagemSet(Set<ViagViagem> viagViagemSet) {
        this.viagViagemSet = viagViagemSet;
    }

    public Set<VucaVeiculoUtilitarioCarga> getVucaVeiculoUtilitarioCargaSet() {
        return vucaVeiculoUtilitarioCargaSet;
    }

    public void setVucaVeiculoUtilitarioCargaSet(Set<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaSet) {
        this.vucaVeiculoUtilitarioCargaSet = vucaVeiculoUtilitarioCargaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (topeCodigo != null ? topeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TopeTipoOperacao)) {
            return false;
        }
        TopeTipoOperacao other = (TopeTipoOperacao) object;
        if ((this.topeCodigo == null && other.topeCodigo != null) || (this.topeCodigo != null && !this.topeCodigo.equals(other.topeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TopeTipoOperacao[topeCodigo=" + topeCodigo + "]";
    }

}
