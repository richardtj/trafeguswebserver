/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Emerson
 */
@Entity
@Table(name = "eras_estacao_rastreamento")
@NamedQueries({
    @NamedQuery(name = "ErasEstacaoRastreamento.findAll", query = "SELECT e FROM ErasEstacaoRastreamento e"),
    @NamedQuery(name = "ErasEstacaoRastreamento.findByErasCodigo", query = "SELECT e FROM ErasEstacaoRastreamento e WHERE e.erasCodigo = :erasCodigo"),
    @NamedQuery(name = "ErasEstacaoRastreamento.findByErasDescricao", query = "SELECT e FROM ErasEstacaoRastreamento e WHERE e.erasDescricao = :erasDescricao"),
    @NamedQuery(name = "ErasEstacaoRastreamento.findByErasMaximoObjetoRastreado", query = "SELECT e FROM ErasEstacaoRastreamento e WHERE e.erasMaximoObjetoRastreado = :erasMaximoObjetoRastreado"),
    @NamedQuery(name = "ErasEstacaoRastreamento.findByErasDataCadastro", query = "SELECT e FROM ErasEstacaoRastreamento e WHERE e.erasDataCadastro = :erasDataCadastro"),
    @NamedQuery(name = "ErasEstacaoRastreamento.findByErasCodigoGr", query = "SELECT e FROM ErasEstacaoRastreamento e WHERE e.erasCodigoGr = :erasCodigoGr"),
    @NamedQuery(name = "ErasEstacaoRastreamento.findByErasImportado", query = "SELECT e FROM ErasEstacaoRastreamento e WHERE e.erasImportado = :erasImportado"),
    @NamedQuery(name = "ErasEstacaoRastreamento.findByErasLayoutMonitor", query = "SELECT e FROM ErasEstacaoRastreamento e WHERE e.erasLayoutMonitor = :erasLayoutMonitor")})
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
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.LAZY)
    private Collection<ErusEstacaoRastreamentoUsu> erusEstacaoRastreamentoUsuCollection;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.LAZY)
    private Collection<VtruVeiculoTruck> vtruVeiculoTruckCollection;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.LAZY)
    private Collection<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaCollection;
    @JoinColumn(name = "eras_sras_codigo", referencedColumnName = "sras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrasSeparacaoRastreamento srasSeparacaoRastreamento;
    @JoinColumn(name = "eras_gris_pjur_pess_oras_codigo", referencedColumnName = "gris_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private GrisGerenciadoraRisco grisGerenciadoraRisco;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.LAZY)
    private Collection<ContContainer> contContainerCollection;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.LAZY)
    private Collection<VupaVeiculoUtilitarioPasse> vupaVeiculoUtilitarioPasseCollection;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.LAZY)
    private Collection<VmotVeiculoMoto> vmotVeiculoMotoCollection;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.LAZY)
    private Collection<VcavVeiculoCavalo> vcavVeiculoCavaloCollection;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.LAZY)
    private Collection<MaloMalote> maloMaloteCollection;

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

    public Collection<ErusEstacaoRastreamentoUsu> getErusEstacaoRastreamentoUsuCollection() {
        return erusEstacaoRastreamentoUsuCollection;
    }

    public void setErusEstacaoRastreamentoUsuCollection(Collection<ErusEstacaoRastreamentoUsu> erusEstacaoRastreamentoUsuCollection) {
        this.erusEstacaoRastreamentoUsuCollection = erusEstacaoRastreamentoUsuCollection;
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

    public Collection<ContContainer> getContContainerCollection() {
        return contContainerCollection;
    }

    public void setContContainerCollection(Collection<ContContainer> contContainerCollection) {
        this.contContainerCollection = contContainerCollection;
    }

    public Collection<VupaVeiculoUtilitarioPasse> getVupaVeiculoUtilitarioPasseCollection() {
        return vupaVeiculoUtilitarioPasseCollection;
    }

    public void setVupaVeiculoUtilitarioPasseCollection(Collection<VupaVeiculoUtilitarioPasse> vupaVeiculoUtilitarioPasseCollection) {
        this.vupaVeiculoUtilitarioPasseCollection = vupaVeiculoUtilitarioPasseCollection;
    }

    public Collection<VmotVeiculoMoto> getVmotVeiculoMotoCollection() {
        return vmotVeiculoMotoCollection;
    }

    public void setVmotVeiculoMotoCollection(Collection<VmotVeiculoMoto> vmotVeiculoMotoCollection) {
        this.vmotVeiculoMotoCollection = vmotVeiculoMotoCollection;
    }

    public Collection<VcavVeiculoCavalo> getVcavVeiculoCavaloCollection() {
        return vcavVeiculoCavaloCollection;
    }

    public void setVcavVeiculoCavaloCollection(Collection<VcavVeiculoCavalo> vcavVeiculoCavaloCollection) {
        this.vcavVeiculoCavaloCollection = vcavVeiculoCavaloCollection;
    }

    public Collection<MaloMalote> getMaloMaloteCollection() {
        return maloMaloteCollection;
    }

    public void setMaloMaloteCollection(Collection<MaloMalote> maloMaloteCollection) {
        this.maloMaloteCollection = maloMaloteCollection;
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
