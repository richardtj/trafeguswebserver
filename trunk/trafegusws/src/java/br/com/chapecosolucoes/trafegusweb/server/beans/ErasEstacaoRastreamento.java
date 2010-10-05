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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "eras_estacao_rastreamento")
@NamedQueries({
    @NamedQuery(name = "ErasEstacaoRastreamento.findAll", query = "SELECT e FROM ErasEstacaoRastreamento e")})
public class ErasEstacaoRastreamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "eras_descricao")
    private String erasDescricao;
    @Column(name = "eras_maximo_objeto_rastreado")
    private Integer erasMaximoObjetoRastreado;
    @Column(name = "eras_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date erasDataCadastro;
    @Column(name = "eras_codigo_gr")
    private Integer erasCodigoGr;
    @Column(name = "eras_importado")
    private Character erasImportado;
    @Column(name = "eras_layout_monitor")
    private String erasLayoutMonitor;
    @OneToMany(mappedBy = "erasEstacaoRastreamento")
    private Set<VtruVeiculoTruck> vtruVeiculoTruckSet;
    @OneToMany(mappedBy = "erasEstacaoRastreamento")
    private Set<VupaVeiculoUtilitarioPasse> vupaVeiculoUtilitarioPasseSet;
    @OneToMany(mappedBy = "erasEstacaoRastreamento")
    private Set<VmotVeiculoMoto> vmotVeiculoMotoSet;
    @OneToMany(mappedBy = "erasEstacaoRastreamento")
    private Set<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaSet;
    @JoinColumn(name = "eras_sras_codigo", referencedColumnName = "sras_codigo")
    @ManyToOne
    private SrasSeparacaoRastreamento srasSeparacaoRastreamento;
    @JoinColumn(name = "eras_gris_pjur_pess_oras_codigo", referencedColumnName = "gris_pjur_pess_oras_codigo")
    @ManyToOne
    private GrisGerenciadoraRisco grisGerenciadoraRisco;

    public ErasEstacaoRastreamento() {
    }

    public ErasEstacaoRastreamento(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

    public Integer getErasCodigo() {
        return erasCodigo;
    }

    public void setErasCodigo(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

    public String getErasDescricao() {
        return erasDescricao;
    }

    public void setErasDescricao(String erasDescricao) {
        this.erasDescricao = erasDescricao;
    }

    public Integer getErasMaximoObjetoRastreado() {
        return erasMaximoObjetoRastreado;
    }

    public void setErasMaximoObjetoRastreado(Integer erasMaximoObjetoRastreado) {
        this.erasMaximoObjetoRastreado = erasMaximoObjetoRastreado;
    }

    public Date getErasDataCadastro() {
        return erasDataCadastro;
    }

    public void setErasDataCadastro(Date erasDataCadastro) {
        this.erasDataCadastro = erasDataCadastro;
    }

    public Integer getErasCodigoGr() {
        return erasCodigoGr;
    }

    public void setErasCodigoGr(Integer erasCodigoGr) {
        this.erasCodigoGr = erasCodigoGr;
    }

    public Character getErasImportado() {
        return erasImportado;
    }

    public void setErasImportado(Character erasImportado) {
        this.erasImportado = erasImportado;
    }

    public String getErasLayoutMonitor() {
        return erasLayoutMonitor;
    }

    public void setErasLayoutMonitor(String erasLayoutMonitor) {
        this.erasLayoutMonitor = erasLayoutMonitor;
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

    public Set<VucaVeiculoUtilitarioCarga> getVucaVeiculoUtilitarioCargaSet() {
        return vucaVeiculoUtilitarioCargaSet;
    }

    public void setVucaVeiculoUtilitarioCargaSet(Set<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaSet) {
        this.vucaVeiculoUtilitarioCargaSet = vucaVeiculoUtilitarioCargaSet;
    }

    public SrasSeparacaoRastreamento getSrasSeparacaoRastreamento() {
        return srasSeparacaoRastreamento;
    }

    public void setSrasSeparacaoRastreamento(SrasSeparacaoRastreamento srasSeparacaoRastreamento) {
        this.srasSeparacaoRastreamento = srasSeparacaoRastreamento;
    }

    public GrisGerenciadoraRisco getGrisGerenciadoraRisco() {
        return grisGerenciadoraRisco;
    }

    public void setGrisGerenciadoraRisco(GrisGerenciadoraRisco grisGerenciadoraRisco) {
        this.grisGerenciadoraRisco = grisGerenciadoraRisco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erasCodigo != null ? erasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErasEstacaoRastreamento)) {
            return false;
        }
        ErasEstacaoRastreamento other = (ErasEstacaoRastreamento) object;
        if ((this.erasCodigo == null && other.erasCodigo != null) || (this.erasCodigo != null && !this.erasCodigo.equals(other.erasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.ErasEstacaoRastreamento[erasCodigo=" + erasCodigo + "]";
    }

}
