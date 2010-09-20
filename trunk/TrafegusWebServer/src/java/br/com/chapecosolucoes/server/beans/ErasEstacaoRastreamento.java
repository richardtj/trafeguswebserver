/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "eras_estacao_rastreamento", catalog = "trafegus_transc", schema = "public")
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
    @Column(name = "eras_codigo", nullable = false)
    private Integer erasCodigo;
    @Column(name = "eras_descricao", length = 50)
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
    @Column(name = "eras_layout_monitor", length = 50000)
    private String erasLayoutMonitor;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.EAGER)
    private List<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaList;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.EAGER)
    private List<ContContainer> contContainerList;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.EAGER)
    private List<VmotVeiculoMoto> vmotVeiculoMotoList;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.EAGER)
    private List<VcavVeiculoCavalo> vcavVeiculoCavaloList;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.EAGER)
    private List<ErusEstacaoRastreamentoUsu> erusEstacaoRastreamentoUsuList;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.EAGER)
    private List<VtruVeiculoTruck> vtruVeiculoTruckList;
    @JoinColumn(name = "eras_sras_codigo", referencedColumnName = "sras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private SrasSeparacaoRastreamento srasSeparacaoRastreamento;
    @JoinColumn(name = "eras_gris_pjur_pess_oras_codigo", referencedColumnName = "gris_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private GrisGerenciadoraRisco grisGerenciadoraRisco;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.EAGER)
    private List<VupaVeiculoUtilitarioPasse> vupaVeiculoUtilitarioPasseList;
    @OneToMany(mappedBy = "erasEstacaoRastreamento", fetch = FetchType.EAGER)
    private List<MaloMalote> maloMaloteList;

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

    public List<VucaVeiculoUtilitarioCarga> getVucaVeiculoUtilitarioCargaList() {
        return vucaVeiculoUtilitarioCargaList;
    }

    public void setVucaVeiculoUtilitarioCargaList(List<VucaVeiculoUtilitarioCarga> vucaVeiculoUtilitarioCargaList) {
        this.vucaVeiculoUtilitarioCargaList = vucaVeiculoUtilitarioCargaList;
    }

    public List<ContContainer> getContContainerList() {
        return contContainerList;
    }

    public void setContContainerList(List<ContContainer> contContainerList) {
        this.contContainerList = contContainerList;
    }

    public List<VmotVeiculoMoto> getVmotVeiculoMotoList() {
        return vmotVeiculoMotoList;
    }

    public void setVmotVeiculoMotoList(List<VmotVeiculoMoto> vmotVeiculoMotoList) {
        this.vmotVeiculoMotoList = vmotVeiculoMotoList;
    }

    public List<VcavVeiculoCavalo> getVcavVeiculoCavaloList() {
        return vcavVeiculoCavaloList;
    }

    public void setVcavVeiculoCavaloList(List<VcavVeiculoCavalo> vcavVeiculoCavaloList) {
        this.vcavVeiculoCavaloList = vcavVeiculoCavaloList;
    }

    public List<ErusEstacaoRastreamentoUsu> getErusEstacaoRastreamentoUsuList() {
        return erusEstacaoRastreamentoUsuList;
    }

    public void setErusEstacaoRastreamentoUsuList(List<ErusEstacaoRastreamentoUsu> erusEstacaoRastreamentoUsuList) {
        this.erusEstacaoRastreamentoUsuList = erusEstacaoRastreamentoUsuList;
    }

    public List<VtruVeiculoTruck> getVtruVeiculoTruckList() {
        return vtruVeiculoTruckList;
    }

    public void setVtruVeiculoTruckList(List<VtruVeiculoTruck> vtruVeiculoTruckList) {
        this.vtruVeiculoTruckList = vtruVeiculoTruckList;
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

    public List<VupaVeiculoUtilitarioPasse> getVupaVeiculoUtilitarioPasseList() {
        return vupaVeiculoUtilitarioPasseList;
    }

    public void setVupaVeiculoUtilitarioPasseList(List<VupaVeiculoUtilitarioPasse> vupaVeiculoUtilitarioPasseList) {
        this.vupaVeiculoUtilitarioPasseList = vupaVeiculoUtilitarioPasseList;
    }

    public List<MaloMalote> getMaloMaloteList() {
        return maloMaloteList;
    }

    public void setMaloMaloteList(List<MaloMalote> maloMaloteList) {
        this.maloMaloteList = maloMaloteList;
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
        return "br.com.chapecosolucoes.server.beans.ErasEstacaoRastreamento[erasCodigo=" + erasCodigo + "]";
    }

}
