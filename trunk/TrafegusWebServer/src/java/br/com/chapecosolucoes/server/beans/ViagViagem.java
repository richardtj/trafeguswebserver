/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
@Table(name = "viag_viagem", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViagViagem.findAll", query = "SELECT v FROM ViagViagem v"),
    @NamedQuery(name = "ViagViagem.findByViagCodigo", query = "SELECT v FROM ViagViagem v WHERE v.viagCodigo = :viagCodigo"),
    @NamedQuery(name = "ViagViagem.findByViagDataCadastro", query = "SELECT v FROM ViagViagem v WHERE v.viagDataCadastro = :viagDataCadastro"),
    @NamedQuery(name = "ViagViagem.findByViagValorCarga", query = "SELECT v FROM ViagViagem v WHERE v.viagValorCarga = :viagValorCarga"),
    @NamedQuery(name = "ViagViagem.findByViagPrevisaoInicio", query = "SELECT v FROM ViagViagem v WHERE v.viagPrevisaoInicio = :viagPrevisaoInicio"),
    @NamedQuery(name = "ViagViagem.findByViagPrevisaoFim", query = "SELECT v FROM ViagViagem v WHERE v.viagPrevisaoFim = :viagPrevisaoFim"),
    @NamedQuery(name = "ViagViagem.findByViagDataInicio", query = "SELECT v FROM ViagViagem v WHERE v.viagDataInicio = :viagDataInicio"),
    @NamedQuery(name = "ViagViagem.findByViagDataFim", query = "SELECT v FROM ViagViagem v WHERE v.viagDataFim = :viagDataFim"),
    @NamedQuery(name = "ViagViagem.findByViagDistancia", query = "SELECT v FROM ViagViagem v WHERE v.viagDistancia = :viagDistancia"),
    @NamedQuery(name = "ViagViagem.findByViagTempoTermForaAreaRisco", query = "SELECT v FROM ViagViagem v WHERE v.viagTempoTermForaAreaRisco = :viagTempoTermForaAreaRisco"),
    @NamedQuery(name = "ViagViagem.findByViagTempoTermEmAreaRisco", query = "SELECT v FROM ViagViagem v WHERE v.viagTempoTermEmAreaRisco = :viagTempoTermEmAreaRisco"),
    @NamedQuery(name = "ViagViagem.findByViagTempoTermFimViagem", query = "SELECT v FROM ViagViagem v WHERE v.viagTempoTermFimViagem = :viagTempoTermFimViagem"),
    @NamedQuery(name = "ViagViagem.findByViagCodigoPai", query = "SELECT v FROM ViagViagem v WHERE v.viagCodigoPai = :viagCodigoPai"),
    @NamedQuery(name = "ViagViagem.findByViagCodigoGr", query = "SELECT v FROM ViagViagem v WHERE v.viagCodigoGr = :viagCodigoGr"),
    @NamedQuery(name = "ViagViagem.findByViagImportado", query = "SELECT v FROM ViagViagem v WHERE v.viagImportado = :viagImportado")})
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
    private List<VlocViagemLocal> vlocViagemLocalList;

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

    public List<VlocViagemLocal> getVlocViagemLocalList() {
        return vlocViagemLocalList;
    }

    public void setVlocViagemLocalList(List<VlocViagemLocal> vlocViagemLocalList) {
        this.vlocViagemLocalList = vlocViagemLocalList;
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
