/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "veic_veiculo")
@NamedQueries({
    @NamedQuery(name = "VeicVeiculo.findAll", query = "SELECT v FROM VeicVeiculo v"),
    @NamedQuery(name = "VeicVeiculo.findByVeicOrasCodigo", query = "SELECT v FROM VeicVeiculo v WHERE v.veicOrasCodigo = :veicOrasCodigo"),
    @NamedQuery(name = "VeicVeiculo.findByVeicPlaca", query = "SELECT v FROM VeicVeiculo v WHERE v.veicPlaca = :veicPlaca"),
    @NamedQuery(name = "VeicVeiculo.findByVeicAnoFabricacao", query = "SELECT v FROM VeicVeiculo v WHERE v.veicAnoFabricacao = :veicAnoFabricacao"),
    @NamedQuery(name = "VeicVeiculo.findByVeicAnoModelo", query = "SELECT v FROM VeicVeiculo v WHERE v.veicAnoModelo = :veicAnoModelo"),
    @NamedQuery(name = "VeicVeiculo.findByVeicRenavam", query = "SELECT v FROM VeicVeiculo v WHERE v.veicRenavam = :veicRenavam"),
    @NamedQuery(name = "VeicVeiculo.findByVeicChassi", query = "SELECT v FROM VeicVeiculo v WHERE v.veicChassi = :veicChassi"),
    @NamedQuery(name = "VeicVeiculo.findByVeicCor", query = "SELECT v FROM VeicVeiculo v WHERE v.veicCor = :veicCor"),
    @NamedQuery(name = "VeicVeiculo.findByVeicObservacao", query = "SELECT v FROM VeicVeiculo v WHERE v.veicObservacao = :veicObservacao"),
    @NamedQuery(name = "VeicVeiculo.findByVeicTamanho", query = "SELECT v FROM VeicVeiculo v WHERE v.veicTamanho = :veicTamanho"),
    @NamedQuery(name = "VeicVeiculo.findByVeicFatorVelocidade", query = "SELECT v FROM VeicVeiculo v WHERE v.veicFatorVelocidade = :veicFatorVelocidade"),
    @NamedQuery(name = "VeicVeiculo.findByVeicFatorRpm", query = "SELECT v FROM VeicVeiculo v WHERE v.veicFatorRpm = :veicFatorRpm"),
    @NamedQuery(name = "VeicVeiculo.findByVeicSenhaProprietario", query = "SELECT v FROM VeicVeiculo v WHERE v.veicSenhaProprietario = :veicSenhaProprietario"),
    @NamedQuery(name = "VeicVeiculo.findByVeicTelefone", query = "SELECT v FROM VeicVeiculo v WHERE v.veicTelefone = :veicTelefone"),
    @NamedQuery(name = "VeicVeiculo.findByVeicFrota", query = "SELECT v FROM VeicVeiculo v WHERE v.veicFrota = :veicFrota")})
public class VeicVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "veic_oras_codigo")
    private Integer veicOrasCodigo;
    @Column(name = "veic_placa")
    private String veicPlaca;
    @Column(name = "veic_ano_fabricacao")
    private String veicAnoFabricacao;
    @Column(name = "veic_ano_modelo")
    private String veicAnoModelo;
    @Column(name = "veic_renavam")
    private String veicRenavam;
    @Column(name = "veic_chassi")
    private String veicChassi;
    @Column(name = "veic_cor")
    private String veicCor;
    @Column(name = "veic_observacao")
    private String veicObservacao;
    @Column(name = "veic_tamanho")
    private BigDecimal veicTamanho;
    @Column(name = "veic_fator_velocidade")
    private BigDecimal veicFatorVelocidade;
    @Column(name = "veic_fator_rpm")
    private BigDecimal veicFatorRpm;
    @Column(name = "veic_senha_proprietario")
    private String veicSenhaProprietario;
    @Column(name = "veic_telefone")
    private String veicTelefone;
    @Column(name = "veic_frota")
    private String veicFrota;
    @JoinColumn(name = "veic_tvei_codigo", referencedColumnName = "tvei_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private TveiTipoVeiculo tveiTipoVeiculo;
    @JoinColumn(name = "veic_pess_oras_codigo_propri", referencedColumnName = "pess_oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private PessPessoa pessPessoa;
    @JoinColumn(name = "veic_oras_codigo", referencedColumnName = "oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private OrasObjetoRastreado orasObjetoRastreado;
    @JoinColumn(name = "veic_mvec_codigo", referencedColumnName = "mvec_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private MvecModeloVeiculo mvecModeloVeiculo;
    @JoinColumn(name = "veic_moto_pfis_pess_oras_codigo", referencedColumnName = "moto_pfis_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private MotoMotorista motoMotorista;
    @JoinColumn(name = "veic_cida_codigo_emplacamento", referencedColumnName = "cida_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private CidaCidade cidaCidade;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private VcarVeiculoCarreta vcarVeiculoCarreta;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private VtruVeiculoTruck vtruVeiculoTruck;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private VucaVeiculoUtilitarioCarga vucaVeiculoUtilitarioCarga;
    @OneToMany(mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private Collection<VtraVeiculoTransportador> vtraVeiculoTransportadorCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private VupaVeiculoUtilitarioPasse vupaVeiculoUtilitarioPasse;
    @OneToMany(mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private Collection<VembVeiculoEmbarcador> vembVeiculoEmbarcadorCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private VmotVeiculoMoto vmotVeiculoMoto;
    @OneToMany(mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private Collection<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private VcavVeiculoCavalo vcavVeiculoCavalo;
    @OneToMany(mappedBy = "veicVeiculo", fetch = FetchType.LAZY)
    private Collection<VveiViagemVeiculo> vveiViagemVeiculoCollection;

    public VeicVeiculo() {
    }

    public VeicVeiculo(Integer veicOrasCodigo) {
        this.veicOrasCodigo = veicOrasCodigo;
    }

    public Integer getVeicOrasCodigo() {
        return veicOrasCodigo;
    }

    public void setVeicOrasCodigo(Integer veicOrasCodigo) {
        this.veicOrasCodigo = veicOrasCodigo;
    }

    public String getVeicPlaca() {
        return veicPlaca;
    }

    public void setVeicPlaca(String veicPlaca) {
        this.veicPlaca = veicPlaca;
    }

    public String getVeicAnoFabricacao() {
        return veicAnoFabricacao;
    }

    public void setVeicAnoFabricacao(String veicAnoFabricacao) {
        this.veicAnoFabricacao = veicAnoFabricacao;
    }

    public String getVeicAnoModelo() {
        return veicAnoModelo;
    }

    public void setVeicAnoModelo(String veicAnoModelo) {
        this.veicAnoModelo = veicAnoModelo;
    }

    public String getVeicRenavam() {
        return veicRenavam;
    }

    public void setVeicRenavam(String veicRenavam) {
        this.veicRenavam = veicRenavam;
    }

    public String getVeicChassi() {
        return veicChassi;
    }

    public void setVeicChassi(String veicChassi) {
        this.veicChassi = veicChassi;
    }

    public String getVeicCor() {
        return veicCor;
    }

    public void setVeicCor(String veicCor) {
        this.veicCor = veicCor;
    }

    public String getVeicObservacao() {
        return veicObservacao;
    }

    public void setVeicObservacao(String veicObservacao) {
        this.veicObservacao = veicObservacao;
    }

    public BigDecimal getVeicTamanho() {
        return veicTamanho;
    }

    public void setVeicTamanho(BigDecimal veicTamanho) {
        this.veicTamanho = veicTamanho;
    }

    public BigDecimal getVeicFatorVelocidade() {
        return veicFatorVelocidade;
    }

    public void setVeicFatorVelocidade(BigDecimal veicFatorVelocidade) {
        this.veicFatorVelocidade = veicFatorVelocidade;
    }

    public BigDecimal getVeicFatorRpm() {
        return veicFatorRpm;
    }

    public void setVeicFatorRpm(BigDecimal veicFatorRpm) {
        this.veicFatorRpm = veicFatorRpm;
    }

    public String getVeicSenhaProprietario() {
        return veicSenhaProprietario;
    }

    public void setVeicSenhaProprietario(String veicSenhaProprietario) {
        this.veicSenhaProprietario = veicSenhaProprietario;
    }

    public String getVeicTelefone() {
        return veicTelefone;
    }

    public void setVeicTelefone(String veicTelefone) {
        this.veicTelefone = veicTelefone;
    }

    public String getVeicFrota() {
        return veicFrota;
    }

    public void setVeicFrota(String veicFrota) {
        this.veicFrota = veicFrota;
    }

    public TveiTipoVeiculo getTveiTipoVeiculo() {
        return tveiTipoVeiculo;
    }

    public void setTveiTipoVeiculo(TveiTipoVeiculo tveiTipoVeiculo) {
        this.tveiTipoVeiculo = tveiTipoVeiculo;
    }

    public PessPessoa getPessPessoa() {
        return pessPessoa;
    }

    public void setPessPessoa(PessPessoa pessPessoa) {
        this.pessPessoa = pessPessoa;
    }

    public OrasObjetoRastreado getOrasObjetoRastreado() {
        return orasObjetoRastreado;
    }

    public void setOrasObjetoRastreado(OrasObjetoRastreado orasObjetoRastreado) {
        this.orasObjetoRastreado = orasObjetoRastreado;
    }

    public MvecModeloVeiculo getMvecModeloVeiculo() {
        return mvecModeloVeiculo;
    }

    public void setMvecModeloVeiculo(MvecModeloVeiculo mvecModeloVeiculo) {
        this.mvecModeloVeiculo = mvecModeloVeiculo;
    }

    public MotoMotorista getMotoMotorista() {
        return motoMotorista;
    }

    public void setMotoMotorista(MotoMotorista motoMotorista) {
        this.motoMotorista = motoMotorista;
    }

    public CidaCidade getCidaCidade() {
        return cidaCidade;
    }

    public void setCidaCidade(CidaCidade cidaCidade) {
        this.cidaCidade = cidaCidade;
    }

    public VcarVeiculoCarreta getVcarVeiculoCarreta() {
        return vcarVeiculoCarreta;
    }

    public void setVcarVeiculoCarreta(VcarVeiculoCarreta vcarVeiculoCarreta) {
        this.vcarVeiculoCarreta = vcarVeiculoCarreta;
    }

    public VtruVeiculoTruck getVtruVeiculoTruck() {
        return vtruVeiculoTruck;
    }

    public void setVtruVeiculoTruck(VtruVeiculoTruck vtruVeiculoTruck) {
        this.vtruVeiculoTruck = vtruVeiculoTruck;
    }

    public VucaVeiculoUtilitarioCarga getVucaVeiculoUtilitarioCarga() {
        return vucaVeiculoUtilitarioCarga;
    }

    public void setVucaVeiculoUtilitarioCarga(VucaVeiculoUtilitarioCarga vucaVeiculoUtilitarioCarga) {
        this.vucaVeiculoUtilitarioCarga = vucaVeiculoUtilitarioCarga;
    }

    public Collection<VtraVeiculoTransportador> getVtraVeiculoTransportadorCollection() {
        return vtraVeiculoTransportadorCollection;
    }

    public void setVtraVeiculoTransportadorCollection(Collection<VtraVeiculoTransportador> vtraVeiculoTransportadorCollection) {
        this.vtraVeiculoTransportadorCollection = vtraVeiculoTransportadorCollection;
    }

    public VupaVeiculoUtilitarioPasse getVupaVeiculoUtilitarioPasse() {
        return vupaVeiculoUtilitarioPasse;
    }

    public void setVupaVeiculoUtilitarioPasse(VupaVeiculoUtilitarioPasse vupaVeiculoUtilitarioPasse) {
        this.vupaVeiculoUtilitarioPasse = vupaVeiculoUtilitarioPasse;
    }

    public Collection<VembVeiculoEmbarcador> getVembVeiculoEmbarcadorCollection() {
        return vembVeiculoEmbarcadorCollection;
    }

    public void setVembVeiculoEmbarcadorCollection(Collection<VembVeiculoEmbarcador> vembVeiculoEmbarcadorCollection) {
        this.vembVeiculoEmbarcadorCollection = vembVeiculoEmbarcadorCollection;
    }

    public VmotVeiculoMoto getVmotVeiculoMoto() {
        return vmotVeiculoMoto;
    }

    public void setVmotVeiculoMoto(VmotVeiculoMoto vmotVeiculoMoto) {
        this.vmotVeiculoMoto = vmotVeiculoMoto;
    }

    public Collection<HpmoHistoricoPesquisaMotor> getHpmoHistoricoPesquisaMotorCollection() {
        return hpmoHistoricoPesquisaMotorCollection;
    }

    public void setHpmoHistoricoPesquisaMotorCollection(Collection<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorCollection) {
        this.hpmoHistoricoPesquisaMotorCollection = hpmoHistoricoPesquisaMotorCollection;
    }

    public VcavVeiculoCavalo getVcavVeiculoCavalo() {
        return vcavVeiculoCavalo;
    }

    public void setVcavVeiculoCavalo(VcavVeiculoCavalo vcavVeiculoCavalo) {
        this.vcavVeiculoCavalo = vcavVeiculoCavalo;
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
        hash += (veicOrasCodigo != null ? veicOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VeicVeiculo)) {
            return false;
        }
        VeicVeiculo other = (VeicVeiculo) object;
        if ((this.veicOrasCodigo == null && other.veicOrasCodigo != null) || (this.veicOrasCodigo != null && !this.veicOrasCodigo.equals(other.veicOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VeicVeiculo[veicOrasCodigo=" + veicOrasCodigo + "]";
    }

}
