/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "veic_veiculo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"veic_placa"})})
@NamedQueries({
    @NamedQuery(name = "VeicVeiculo.findAll", query = "SELECT v FROM VeicVeiculo v")})
public class VeicVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "veic_oras_codigo", nullable = false)
    private Integer veicOrasCodigo;
    @Column(name = "veic_placa", length = 10)
    private String veicPlaca;
    @Column(name = "veic_ano_fabricacao", length = 4)
    private String veicAnoFabricacao;
    @Column(name = "veic_ano_modelo", length = 4)
    private String veicAnoModelo;
    @Column(name = "veic_renavam", length = 50)
    private String veicRenavam;
    @Column(name = "veic_chassi", length = 50)
    private String veicChassi;
    @Column(name = "veic_cor", length = 20)
    private String veicCor;
    @Column(name = "veic_observacao", length = 5000)
    private String veicObservacao;
    @Column(name = "veic_tamanho", precision = 15, scale = 2)
    private BigDecimal veicTamanho;
    @Column(name = "veic_fator_velocidade", precision = 15, scale = 2)
    private BigDecimal veicFatorVelocidade;
    @Column(name = "veic_fator_rpm", precision = 15, scale = 2)
    private BigDecimal veicFatorRpm;
    @Column(name = "veic_senha_proprietario", length = 20)
    private String veicSenhaProprietario;
    @Column(name = "veic_telefone", length = 20)
    private String veicTelefone;
    @Column(name = "veic_frota", length = 10)
    private String veicFrota;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo")
    private VucaVeiculoUtilitarioCarga vucaVeiculoUtilitarioCarga;
    @OneToMany(mappedBy = "veicVeiculo")
    private Collection<VembVeiculoEmbarcador> vembVeiculoEmbarcadorCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo")
    private VmotVeiculoMoto vmotVeiculoMoto;
    @OneToMany(mappedBy = "veicVeiculo")
    private Collection<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo")
    private VcavVeiculoCavalo vcavVeiculoCavalo;
    @JoinColumn(name = "veic_tvei_codigo", referencedColumnName = "tvei_codigo")
    @ManyToOne
    private TveiTipoVeiculo tveiTipoVeiculo;
    @JoinColumn(name = "veic_pess_oras_codigo_propri", referencedColumnName = "pess_oras_codigo")
    @ManyToOne
    private PessPessoa pessPessoa;
    @JoinColumn(name = "veic_oras_codigo", referencedColumnName = "oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrasObjetoRastreado orasObjetoRastreado;
    @JoinColumn(name = "veic_mvec_codigo", referencedColumnName = "mvec_codigo")
    @ManyToOne
    private MvecModeloVeiculo mvecModeloVeiculo;
    @JoinColumn(name = "veic_moto_pfis_pess_oras_codigo", referencedColumnName = "moto_pfis_pess_oras_codigo")
    @ManyToOne
    private MotoMotorista motoMotorista;
    @JoinColumn(name = "veic_cida_codigo_emplacamento", referencedColumnName = "cida_codigo")
    @ManyToOne
    private CidaCidade cidaCidade;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo")
    private VcarVeiculoCarreta vcarVeiculoCarreta;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo")
    private VtruVeiculoTruck vtruVeiculoTruck;
    @OneToMany(mappedBy = "veicVeiculo")
    private Collection<VtraVeiculoTransportador> vtraVeiculoTransportadorCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veicVeiculo")
    private VupaVeiculoUtilitarioPasse vupaVeiculoUtilitarioPasse;
    @OneToMany(mappedBy = "veicVeiculo")
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

    public VucaVeiculoUtilitarioCarga getVucaVeiculoUtilitarioCarga() {
        return vucaVeiculoUtilitarioCarga;
    }

    public void setVucaVeiculoUtilitarioCarga(VucaVeiculoUtilitarioCarga vucaVeiculoUtilitarioCarga) {
        this.vucaVeiculoUtilitarioCarga = vucaVeiculoUtilitarioCarga;
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
        return "br.com.chapecosolucoes.server.beans.VeicVeiculo[veicOrasCodigo=" + veicOrasCodigo + "]";
    }

}
