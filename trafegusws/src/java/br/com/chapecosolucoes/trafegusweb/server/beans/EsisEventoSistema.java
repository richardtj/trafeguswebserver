/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "esis_evento_sistema")
@NamedQueries({
    @NamedQuery(name = "EsisEventoSistema.findAll", query = "SELECT e FROM EsisEventoSistema e"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisCodigo", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisCodigo = :esisCodigo"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisDataCadastro", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisDataCadastro = :esisDataCadastro"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisDataInicio", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisDataInicio = :esisDataInicio"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisDataFim", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisDataFim = :esisDataFim"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisDescricao", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisDescricao = :esisDescricao"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisValor", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisValor = :esisValor"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisViolacaoGeradaIntegracao", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisViolacaoGeradaIntegracao = :esisViolacaoGeradaIntegracao"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisImportado", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisImportado = :esisImportado"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisUsuCodigoLeitura", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisUsuCodigoLeitura = :esisUsuCodigoLeitura"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisDataLeitura", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisDataLeitura = :esisDataLeitura"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisDataTratamentoServidor", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisDataTratamentoServidor = :esisDataTratamentoServidor"),
    @NamedQuery(name = "EsisEventoSistema.findByEsisDescTratamento", query = "SELECT e FROM EsisEventoSistema e WHERE e.esisDescTratamento = :esisDescTratamento")})
public class EsisEventoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "esis_codigo")
    private Integer esisCodigo;
    @Column(name = "esis_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataCadastro;
    @Column(name = "esis_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataInicio;
    @Column(name = "esis_data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataFim;
    @Column(name = "esis_descricao")
    private String esisDescricao;
    @Column(name = "esis_valor")
    private String esisValor;
    @Column(name = "esis_violacao_gerada_integracao")
    private Character esisViolacaoGeradaIntegracao;
    @Column(name = "esis_importado")
    private Character esisImportado;
    @Column(name = "esis_usu_codigo_leitura")
    private Integer esisUsuCodigoLeitura;
    @Column(name = "esis_data_leitura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataLeitura;
    @Column(name = "esis_data_tratamento_servidor")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataTratamentoServidor;
    @Column(name = "esis_desc_tratamento")
    private String esisDescTratamento;
    @JoinColumn(name = "esis_term_codigo", referencedColumnName = "term_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private TermTerminal termTerminal;
    @JoinColumn(name = "esis_pgai_codigo", referencedColumnName = "pgai_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private PgaiPgAssociaItem pgaiPgAssociaItem;
    @JoinColumn(name = "esis_espa_codigo", referencedColumnName = "espa_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private EspaEventoSistemaPadrao espaEventoSistemaPadrao;

    public EsisEventoSistema() {
    }

    public EsisEventoSistema(Integer esisCodigo) {
        this.esisCodigo = esisCodigo;
    }

    public Integer getEsisCodigo() {
        return esisCodigo;
    }

    public void setEsisCodigo(Integer esisCodigo) {
        this.esisCodigo = esisCodigo;
    }

    public Date getEsisDataCadastro() {
        return esisDataCadastro;
    }

    public void setEsisDataCadastro(Date esisDataCadastro) {
        this.esisDataCadastro = esisDataCadastro;
    }

    public Date getEsisDataInicio() {
        return esisDataInicio;
    }

    public void setEsisDataInicio(Date esisDataInicio) {
        this.esisDataInicio = esisDataInicio;
    }

    public Date getEsisDataFim() {
        return esisDataFim;
    }

    public void setEsisDataFim(Date esisDataFim) {
        this.esisDataFim = esisDataFim;
    }

    public String getEsisDescricao() {
        return esisDescricao;
    }

    public void setEsisDescricao(String esisDescricao) {
        this.esisDescricao = esisDescricao;
    }

    public String getEsisValor() {
        return esisValor;
    }

    public void setEsisValor(String esisValor) {
        this.esisValor = esisValor;
    }

    public Character getEsisViolacaoGeradaIntegracao() {
        return esisViolacaoGeradaIntegracao;
    }

    public void setEsisViolacaoGeradaIntegracao(Character esisViolacaoGeradaIntegracao) {
        this.esisViolacaoGeradaIntegracao = esisViolacaoGeradaIntegracao;
    }

    public Character getEsisImportado() {
        return esisImportado;
    }

    public void setEsisImportado(Character esisImportado) {
        this.esisImportado = esisImportado;
    }

    public Integer getEsisUsuCodigoLeitura() {
        return esisUsuCodigoLeitura;
    }

    public void setEsisUsuCodigoLeitura(Integer esisUsuCodigoLeitura) {
        this.esisUsuCodigoLeitura = esisUsuCodigoLeitura;
    }

    public Date getEsisDataLeitura() {
        return esisDataLeitura;
    }

    public void setEsisDataLeitura(Date esisDataLeitura) {
        this.esisDataLeitura = esisDataLeitura;
    }

    public Date getEsisDataTratamentoServidor() {
        return esisDataTratamentoServidor;
    }

    public void setEsisDataTratamentoServidor(Date esisDataTratamentoServidor) {
        this.esisDataTratamentoServidor = esisDataTratamentoServidor;
    }

    public String getEsisDescTratamento() {
        return esisDescTratamento;
    }

    public void setEsisDescTratamento(String esisDescTratamento) {
        this.esisDescTratamento = esisDescTratamento;
    }

    public TermTerminal getTermTerminal() {
        return termTerminal;
    }

    public void setTermTerminal(TermTerminal termTerminal) {
        this.termTerminal = termTerminal;
    }

    public PgaiPgAssociaItem getPgaiPgAssociaItem() {
        return pgaiPgAssociaItem;
    }

    public void setPgaiPgAssociaItem(PgaiPgAssociaItem pgaiPgAssociaItem) {
        this.pgaiPgAssociaItem = pgaiPgAssociaItem;
    }

    public EspaEventoSistemaPadrao getEspaEventoSistemaPadrao() {
        return espaEventoSistemaPadrao;
    }

    public void setEspaEventoSistemaPadrao(EspaEventoSistemaPadrao espaEventoSistemaPadrao) {
        this.espaEventoSistemaPadrao = espaEventoSistemaPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esisCodigo != null ? esisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsisEventoSistema)) {
            return false;
        }
        EsisEventoSistema other = (EsisEventoSistema) object;
        if ((this.esisCodigo == null && other.esisCodigo != null) || (this.esisCodigo != null && !this.esisCodigo.equals(other.esisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EsisEventoSistema[esisCodigo=" + esisCodigo + "]";
    }

}
