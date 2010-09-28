/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
 * @author Emerson
 */
@Entity
@Table(name = "hpmo_historico_pesquisa_motor", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "HpmoHistoricoPesquisaMotor.findAll", query = "SELECT h FROM HpmoHistoricoPesquisaMotor h"),
    @NamedQuery(name = "HpmoHistoricoPesquisaMotor.findByHpmoCodigo", query = "SELECT h FROM HpmoHistoricoPesquisaMotor h WHERE h.hpmoCodigo = :hpmoCodigo"),
    @NamedQuery(name = "HpmoHistoricoPesquisaMotor.findByHpmoPrazoValidade", query = "SELECT h FROM HpmoHistoricoPesquisaMotor h WHERE h.hpmoPrazoValidade = :hpmoPrazoValidade"),
    @NamedQuery(name = "HpmoHistoricoPesquisaMotor.findByHpmoDataCadastro", query = "SELECT h FROM HpmoHistoricoPesquisaMotor h WHERE h.hpmoDataCadastro = :hpmoDataCadastro"),
    @NamedQuery(name = "HpmoHistoricoPesquisaMotor.findByHpmoCodigoGr", query = "SELECT h FROM HpmoHistoricoPesquisaMotor h WHERE h.hpmoCodigoGr = :hpmoCodigoGr"),
    @NamedQuery(name = "HpmoHistoricoPesquisaMotor.findByHpmoImportado", query = "SELECT h FROM HpmoHistoricoPesquisaMotor h WHERE h.hpmoImportado = :hpmoImportado"),
    @NamedQuery(name = "HpmoHistoricoPesquisaMotor.findByHpmoMensagem", query = "SELECT h FROM HpmoHistoricoPesquisaMotor h WHERE h.hpmoMensagem = :hpmoMensagem"),
    @NamedQuery(name = "HpmoHistoricoPesquisaMotor.findByHpmoValorMaximo", query = "SELECT h FROM HpmoHistoricoPesquisaMotor h WHERE h.hpmoValorMaximo = :hpmoValorMaximo")})
public class HpmoHistoricoPesquisaMotor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hpmo_codigo", nullable = false)
    private Integer hpmoCodigo;
    @Column(name = "hpmo_prazo_validade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hpmoPrazoValidade;
    @Column(name = "hpmo_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hpmoDataCadastro;
    @Column(name = "hpmo_codigo_gr")
    private Integer hpmoCodigoGr;
    @Column(name = "hpmo_importado")
    private Character hpmoImportado;
    @Column(name = "hpmo_mensagem", length = 5000)
    private String hpmoMensagem;
    @Column(name = "hpmo_valor_maximo", precision = 15, scale = 2)
    private BigDecimal hpmoValorMaximo;
    @OneToMany(mappedBy = "hpmoHistoricoPesquisaMotor")
    private Collection<ViagViagem> viagViagemCollection;
    @OneToMany(mappedBy = "hpmoHistoricoPesquisaMotor")
    private Collection<HpprHistoricoPesquisaProd> hpprHistoricoPesquisaProdCollection;
    @JoinColumn(name = "hpmo_veic_oras_codigo", referencedColumnName = "veic_oras_codigo")
    @ManyToOne
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "hpmo_tpro_codigo", referencedColumnName = "tpro_codigo")
    @ManyToOne
    private TproProduto tproProduto;
    @JoinColumn(name = "hpmo_moto_pfis_pess_oras_codigo", referencedColumnName = "moto_pfis_pess_oras_codigo")
    @ManyToOne
    private MotoMotorista motoMotorista;
    @JoinColumn(name = "hpmo_epmo_codigo", referencedColumnName = "epmo_codigo")
    @ManyToOne
    private EpmoEstatusPesquisaMotoris epmoEstatusPesquisaMotoris;

    public HpmoHistoricoPesquisaMotor() {
    }

    public HpmoHistoricoPesquisaMotor(Integer hpmoCodigo) {
        this.hpmoCodigo = hpmoCodigo;
    }

    public Integer getHpmoCodigo() {
        return hpmoCodigo;
    }

    public void setHpmoCodigo(Integer hpmoCodigo) {
        this.hpmoCodigo = hpmoCodigo;
    }

    public Date getHpmoPrazoValidade() {
        return hpmoPrazoValidade;
    }

    public void setHpmoPrazoValidade(Date hpmoPrazoValidade) {
        this.hpmoPrazoValidade = hpmoPrazoValidade;
    }

    public Date getHpmoDataCadastro() {
        return hpmoDataCadastro;
    }

    public void setHpmoDataCadastro(Date hpmoDataCadastro) {
        this.hpmoDataCadastro = hpmoDataCadastro;
    }

    public Integer getHpmoCodigoGr() {
        return hpmoCodigoGr;
    }

    public void setHpmoCodigoGr(Integer hpmoCodigoGr) {
        this.hpmoCodigoGr = hpmoCodigoGr;
    }

    public Character getHpmoImportado() {
        return hpmoImportado;
    }

    public void setHpmoImportado(Character hpmoImportado) {
        this.hpmoImportado = hpmoImportado;
    }

    public String getHpmoMensagem() {
        return hpmoMensagem;
    }

    public void setHpmoMensagem(String hpmoMensagem) {
        this.hpmoMensagem = hpmoMensagem;
    }

    public BigDecimal getHpmoValorMaximo() {
        return hpmoValorMaximo;
    }

    public void setHpmoValorMaximo(BigDecimal hpmoValorMaximo) {
        this.hpmoValorMaximo = hpmoValorMaximo;
    }

    public Collection<ViagViagem> getViagViagemCollection() {
        return viagViagemCollection;
    }

    public void setViagViagemCollection(Collection<ViagViagem> viagViagemCollection) {
        this.viagViagemCollection = viagViagemCollection;
    }

    public Collection<HpprHistoricoPesquisaProd> getHpprHistoricoPesquisaProdCollection() {
        return hpprHistoricoPesquisaProdCollection;
    }

    public void setHpprHistoricoPesquisaProdCollection(Collection<HpprHistoricoPesquisaProd> hpprHistoricoPesquisaProdCollection) {
        this.hpprHistoricoPesquisaProdCollection = hpprHistoricoPesquisaProdCollection;
    }

    public VeicVeiculo getVeicVeiculo() {
        return veicVeiculo;
    }

    public void setVeicVeiculo(VeicVeiculo veicVeiculo) {
        this.veicVeiculo = veicVeiculo;
    }

    public TproProduto getTproProduto() {
        return tproProduto;
    }

    public void setTproProduto(TproProduto tproProduto) {
        this.tproProduto = tproProduto;
    }

    public MotoMotorista getMotoMotorista() {
        return motoMotorista;
    }

    public void setMotoMotorista(MotoMotorista motoMotorista) {
        this.motoMotorista = motoMotorista;
    }

    public EpmoEstatusPesquisaMotoris getEpmoEstatusPesquisaMotoris() {
        return epmoEstatusPesquisaMotoris;
    }

    public void setEpmoEstatusPesquisaMotoris(EpmoEstatusPesquisaMotoris epmoEstatusPesquisaMotoris) {
        this.epmoEstatusPesquisaMotoris = epmoEstatusPesquisaMotoris;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hpmoCodigo != null ? hpmoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HpmoHistoricoPesquisaMotor)) {
            return false;
        }
        HpmoHistoricoPesquisaMotor other = (HpmoHistoricoPesquisaMotor) object;
        if ((this.hpmoCodigo == null && other.hpmoCodigo != null) || (this.hpmoCodigo != null && !this.hpmoCodigo.equals(other.hpmoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.HpmoHistoricoPesquisaMotor[hpmoCodigo=" + hpmoCodigo + "]";
    }

}