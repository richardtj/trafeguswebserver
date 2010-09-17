/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

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
@Table(name = "viag_viagem")
@NamedQueries({
    @NamedQuery(name = "ViagViagem.findAll", query = "SELECT v FROM ViagViagem v")})
public class ViagViagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "viag_codigo", nullable = false)
    private Integer viagCodigo;
    @Column(name = "viag_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagDataCadastro;
    @Column(name = "viag_valor_carga", precision = 15, scale = 2)
    private BigDecimal viagValorCarga;
    @Column(name = "viag_previsao_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagPrevisaoInicio;
    @Column(name = "viag_previsao_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagPrevisaoFim;
    @Column(name = "viag_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagDataInicio;
    @Column(name = "viag_data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagDataFim;
    @Column(name = "viag_distancia", precision = 15, scale = 2)
    private BigDecimal viagDistancia;
    @Column(name = "viag_tempo_term_fora_area_risco")
    private Integer viagTempoTermForaAreaRisco;
    @Column(name = "viag_tempo_term_em_area_risco")
    private Integer viagTempoTermEmAreaRisco;
    @Column(name = "viag_tempo_term_fim_viagem")
    private Integer viagTempoTermFimViagem;
    @Column(name = "viag_codigo_pai")
    private Integer viagCodigoPai;
    @Column(name = "viag_codigo_gr")
    private Integer viagCodigoGr;
    @Column(name = "viag_importado")
    private Character viagImportado;
    @OneToMany(mappedBy = "viagViagem")
    private Collection<VterViagemTerminal> vterViagemTerminalCollection;
    @OneToMany(mappedBy = "viagViagem")
    private Collection<VrotViagemRota> vrotViagemRotaCollection;
    @OneToMany(mappedBy = "viagViagem")
    private Collection<VestViagemEstatus> vestViagemEstatusCollection;
    @OneToMany(mappedBy = "viagViagem")
    private Collection<VtemViagemTemperatura> vtemViagemTemperaturaCollection;
    @JoinColumn(name = "viag_ttra_codigo", referencedColumnName = "ttra_codigo")
    @ManyToOne
    private TtraTipoTransporte ttraTipoTransporte;
    @JoinColumn(name = "viag_tran_pess_oras_codigo", referencedColumnName = "tran_pess_oras_codigo", nullable = false)
    @ManyToOne(optional = false)
    private TranTransportador tranTransportador;
    @JoinColumn(name = "viag_tope_codigo", referencedColumnName = "tope_codigo")
    @ManyToOne
    private TopeTipoOperacao topeTipoOperacao;
    @JoinColumn(name = "viag_pgpg_codigo", referencedColumnName = "pgpg_codigo")
    @ManyToOne
    private PgpgPg pgpgPg;
    @JoinColumn(name = "viag_hpmo_codigo", referencedColumnName = "hpmo_codigo")
    @ManyToOne
    private HpmoHistoricoPesquisaMotor hpmoHistoricoPesquisaMotor;
    @JoinColumn(name = "viag_emba_pjur_pess_oras_codigo", referencedColumnName = "emba_pjur_pess_oras_codigo")
    @ManyToOne
    private EmbaEmbarcador embaEmbarcador;
    @OneToMany(mappedBy = "viagViagem")
    private Collection<VconViagemConhecimento> vconViagemConhecimentoCollection;
    @OneToMany(mappedBy = "viagViagem")
    private Collection<VveiViagemVeiculo> vveiViagemVeiculoCollection;
    @OneToMany(mappedBy = "viagViagem")
    private Collection<VlocViagemLocal> vlocViagemLocalCollection;

    public ViagViagem() {
    }

    public ViagViagem(Integer viagCodigo) {
        this.viagCodigo = viagCodigo;
    }

    public Integer getViagCodigo() {
        return viagCodigo;
    }

    public void setViagCodigo(Integer viagCodigo) {
        this.viagCodigo = viagCodigo;
    }

    public Date getViagDataCadastro() {
        return viagDataCadastro;
    }

    public void setViagDataCadastro(Date viagDataCadastro) {
        this.viagDataCadastro = viagDataCadastro;
    }

    public BigDecimal getViagValorCarga() {
        return viagValorCarga;
    }

    public void setViagValorCarga(BigDecimal viagValorCarga) {
        this.viagValorCarga = viagValorCarga;
    }

    public Date getViagPrevisaoInicio() {
        return viagPrevisaoInicio;
    }

    public void setViagPrevisaoInicio(Date viagPrevisaoInicio) {
        this.viagPrevisaoInicio = viagPrevisaoInicio;
    }

    public Date getViagPrevisaoFim() {
        return viagPrevisaoFim;
    }

    public void setViagPrevisaoFim(Date viagPrevisaoFim) {
        this.viagPrevisaoFim = viagPrevisaoFim;
    }

    public Date getViagDataInicio() {
        return viagDataInicio;
    }

    public void setViagDataInicio(Date viagDataInicio) {
        this.viagDataInicio = viagDataInicio;
    }

    public Date getViagDataFim() {
        return viagDataFim;
    }

    public void setViagDataFim(Date viagDataFim) {
        this.viagDataFim = viagDataFim;
    }

    public BigDecimal getViagDistancia() {
        return viagDistancia;
    }

    public void setViagDistancia(BigDecimal viagDistancia) {
        this.viagDistancia = viagDistancia;
    }

    public Integer getViagTempoTermForaAreaRisco() {
        return viagTempoTermForaAreaRisco;
    }

    public void setViagTempoTermForaAreaRisco(Integer viagTempoTermForaAreaRisco) {
        this.viagTempoTermForaAreaRisco = viagTempoTermForaAreaRisco;
    }

    public Integer getViagTempoTermEmAreaRisco() {
        return viagTempoTermEmAreaRisco;
    }

    public void setViagTempoTermEmAreaRisco(Integer viagTempoTermEmAreaRisco) {
        this.viagTempoTermEmAreaRisco = viagTempoTermEmAreaRisco;
    }

    public Integer getViagTempoTermFimViagem() {
        return viagTempoTermFimViagem;
    }

    public void setViagTempoTermFimViagem(Integer viagTempoTermFimViagem) {
        this.viagTempoTermFimViagem = viagTempoTermFimViagem;
    }

    public Integer getViagCodigoPai() {
        return viagCodigoPai;
    }

    public void setViagCodigoPai(Integer viagCodigoPai) {
        this.viagCodigoPai = viagCodigoPai;
    }

    public Integer getViagCodigoGr() {
        return viagCodigoGr;
    }

    public void setViagCodigoGr(Integer viagCodigoGr) {
        this.viagCodigoGr = viagCodigoGr;
    }

    public Character getViagImportado() {
        return viagImportado;
    }

    public void setViagImportado(Character viagImportado) {
        this.viagImportado = viagImportado;
    }

    public Collection<VterViagemTerminal> getVterViagemTerminalCollection() {
        return vterViagemTerminalCollection;
    }

    public void setVterViagemTerminalCollection(Collection<VterViagemTerminal> vterViagemTerminalCollection) {
        this.vterViagemTerminalCollection = vterViagemTerminalCollection;
    }

    public Collection<VrotViagemRota> getVrotViagemRotaCollection() {
        return vrotViagemRotaCollection;
    }

    public void setVrotViagemRotaCollection(Collection<VrotViagemRota> vrotViagemRotaCollection) {
        this.vrotViagemRotaCollection = vrotViagemRotaCollection;
    }

    public Collection<VestViagemEstatus> getVestViagemEstatusCollection() {
        return vestViagemEstatusCollection;
    }

    public void setVestViagemEstatusCollection(Collection<VestViagemEstatus> vestViagemEstatusCollection) {
        this.vestViagemEstatusCollection = vestViagemEstatusCollection;
    }

    public Collection<VtemViagemTemperatura> getVtemViagemTemperaturaCollection() {
        return vtemViagemTemperaturaCollection;
    }

    public void setVtemViagemTemperaturaCollection(Collection<VtemViagemTemperatura> vtemViagemTemperaturaCollection) {
        this.vtemViagemTemperaturaCollection = vtemViagemTemperaturaCollection;
    }

    public TtraTipoTransporte getTtraTipoTransporte() {
        return ttraTipoTransporte;
    }

    public void setTtraTipoTransporte(TtraTipoTransporte ttraTipoTransporte) {
        this.ttraTipoTransporte = ttraTipoTransporte;
    }

    public TranTransportador getTranTransportador() {
        return tranTransportador;
    }

    public void setTranTransportador(TranTransportador tranTransportador) {
        this.tranTransportador = tranTransportador;
    }

    public TopeTipoOperacao getTopeTipoOperacao() {
        return topeTipoOperacao;
    }

    public void setTopeTipoOperacao(TopeTipoOperacao topeTipoOperacao) {
        this.topeTipoOperacao = topeTipoOperacao;
    }

    public PgpgPg getPgpgPg() {
        return pgpgPg;
    }

    public void setPgpgPg(PgpgPg pgpgPg) {
        this.pgpgPg = pgpgPg;
    }

    public HpmoHistoricoPesquisaMotor getHpmoHistoricoPesquisaMotor() {
        return hpmoHistoricoPesquisaMotor;
    }

    public void setHpmoHistoricoPesquisaMotor(HpmoHistoricoPesquisaMotor hpmoHistoricoPesquisaMotor) {
        this.hpmoHistoricoPesquisaMotor = hpmoHistoricoPesquisaMotor;
    }

    public EmbaEmbarcador getEmbaEmbarcador() {
        return embaEmbarcador;
    }

    public void setEmbaEmbarcador(EmbaEmbarcador embaEmbarcador) {
        this.embaEmbarcador = embaEmbarcador;
    }

    public Collection<VconViagemConhecimento> getVconViagemConhecimentoCollection() {
        return vconViagemConhecimentoCollection;
    }

    public void setVconViagemConhecimentoCollection(Collection<VconViagemConhecimento> vconViagemConhecimentoCollection) {
        this.vconViagemConhecimentoCollection = vconViagemConhecimentoCollection;
    }

    public Collection<VveiViagemVeiculo> getVveiViagemVeiculoCollection() {
        return vveiViagemVeiculoCollection;
    }

    public void setVveiViagemVeiculoCollection(Collection<VveiViagemVeiculo> vveiViagemVeiculoCollection) {
        this.vveiViagemVeiculoCollection = vveiViagemVeiculoCollection;
    }

    public Collection<VlocViagemLocal> getVlocViagemLocalCollection() {
        return vlocViagemLocalCollection;
    }

    public void setVlocViagemLocalCollection(Collection<VlocViagemLocal> vlocViagemLocalCollection) {
        this.vlocViagemLocalCollection = vlocViagemLocalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viagCodigo != null ? viagCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViagViagem)) {
            return false;
        }
        ViagViagem other = (ViagViagem) object;
        if ((this.viagCodigo == null && other.viagCodigo != null) || (this.viagCodigo != null && !this.viagCodigo.equals(other.viagCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.ViagViagem[viagCodigo=" + viagCodigo + "]";
    }

}
