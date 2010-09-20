/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "view_evento_acao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewEventoAcao.findAll", query = "SELECT v FROM ViewEventoAcao v"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisCodigo", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisCodigo = :esisCodigo"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisDataCadastro", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisDataCadastro = :esisDataCadastro"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisDataInicio", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisDataInicio = :esisDataInicio"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisDataFim", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisDataFim = :esisDataFim"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisDataLeitura", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisDataLeitura = :esisDataLeitura"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisDescricao", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisDescricao = :esisDescricao"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisEspaCodigo", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisEspaCodigo = :esisEspaCodigo"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisPgaiCodigo", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisPgaiCodigo = :esisPgaiCodigo"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisTermCodigo", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisTermCodigo = :esisTermCodigo"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisUsuCodigoLeitura", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisUsuCodigoLeitura = :esisUsuCodigoLeitura"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisValor", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisValor = :esisValor"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisViolacaoGeradaIntegracao", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisViolacaoGeradaIntegracao = :esisViolacaoGeradaIntegracao"),
    @NamedQuery(name = "ViewEventoAcao.findByEsisDataTratamentoServidor", query = "SELECT v FROM ViewEventoAcao v WHERE v.esisDataTratamentoServidor = :esisDataTratamentoServidor"),
    @NamedQuery(name = "ViewEventoAcao.findByApadCodigo", query = "SELECT v FROM ViewEventoAcao v WHERE v.apadCodigo = :apadCodigo"),
    @NamedQuery(name = "ViewEventoAcao.findByApadDescricao", query = "SELECT v FROM ViewEventoAcao v WHERE v.apadDescricao = :apadDescricao"),
    @NamedQuery(name = "ViewEventoAcao.findByApadTipoAcao", query = "SELECT v FROM ViewEventoAcao v WHERE v.apadTipoAcao = :apadTipoAcao"),
    @NamedQuery(name = "ViewEventoAcao.findByAbbeFrequencia", query = "SELECT v FROM ViewEventoAcao v WHERE v.abbeFrequencia = :abbeFrequencia"),
    @NamedQuery(name = "ViewEventoAcao.findByAbeeTempoBeep", query = "SELECT v FROM ViewEventoAcao v WHERE v.abeeTempoBeep = :abeeTempoBeep"),
    @NamedQuery(name = "ViewEventoAcao.findByAbeeTempoEsperando", query = "SELECT v FROM ViewEventoAcao v WHERE v.abeeTempoEsperando = :abeeTempoEsperando"),
    @NamedQuery(name = "ViewEventoAcao.findByAbolCor", query = "SELECT v FROM ViewEventoAcao v WHERE v.abolCor = :abolCor"),
    @NamedQuery(name = "ViewEventoAcao.findByAcomCpadCodigo", query = "SELECT v FROM ViewEventoAcao v WHERE v.acomCpadCodigo = :acomCpadCodigo"),
    @NamedQuery(name = "ViewEventoAcao.findByAlinCorFundo", query = "SELECT v FROM ViewEventoAcao v WHERE v.alinCorFundo = :alinCorFundo"),
    @NamedQuery(name = "ViewEventoAcao.findByAmacMpadCodigo", query = "SELECT v FROM ViewEventoAcao v WHERE v.amacMpadCodigo = :amacMpadCodigo"),
    @NamedQuery(name = "ViewEventoAcao.findByApopAltura", query = "SELECT v FROM ViewEventoAcao v WHERE v.apopAltura = :apopAltura"),
    @NamedQuery(name = "ViewEventoAcao.findByApopCor", query = "SELECT v FROM ViewEventoAcao v WHERE v.apopCor = :apopCor"),
    @NamedQuery(name = "ViewEventoAcao.findByApopLargura", query = "SELECT v FROM ViewEventoAcao v WHERE v.apopLargura = :apopLargura"),
    @NamedQuery(name = "ViewEventoAcao.findByApopTitulo", query = "SELECT v FROM ViewEventoAcao v WHERE v.apopTitulo = :apopTitulo"),
    @NamedQuery(name = "ViewEventoAcao.findByMpadNumero", query = "SELECT v FROM ViewEventoAcao v WHERE v.mpadNumero = :mpadNumero"),
    @NamedQuery(name = "ViewEventoAcao.findByMpadDescricao", query = "SELECT v FROM ViewEventoAcao v WHERE v.mpadDescricao = :mpadDescricao"),
    @NamedQuery(name = "ViewEventoAcao.findByMpadMascara", query = "SELECT v FROM ViewEventoAcao v WHERE v.mpadMascara = :mpadMascara")})
public class ViewEventoAcao implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Column(name = "esis_data_leitura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataLeitura;
    @Column(name = "esis_descricao", length = 100)
    private String esisDescricao;
    @Column(name = "esis_espa_codigo")
    private Integer esisEspaCodigo;
    @Column(name = "esis_pgai_codigo")
    private Integer esisPgaiCodigo;
    @Column(name = "esis_term_codigo")
    private Integer esisTermCodigo;
    @Column(name = "esis_usu_codigo_leitura")
    private Integer esisUsuCodigoLeitura;
    @Column(name = "esis_valor", length = 50)
    private String esisValor;
    @Column(name = "esis_violacao_gerada_integracao")
    private Character esisViolacaoGeradaIntegracao;
    @Column(name = "esis_data_tratamento_servidor")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataTratamentoServidor;
    @Column(name = "apad_codigo")
    private Integer apadCodigo;
    @Column(name = "apad_descricao", length = 50)
    private String apadDescricao;
    @Column(name = "apad_tipo_acao", length = 10)
    private String apadTipoAcao;
    @Column(name = "abbe_frequencia")
    private Integer abbeFrequencia;
    @Column(name = "abee_tempo_beep")
    private Integer abeeTempoBeep;
    @Column(name = "abee_tempo_esperando")
    private Integer abeeTempoEsperando;
    @Column(name = "abol_cor")
    private Integer abolCor;
    @Column(name = "acom_cpad_codigo")
    private Integer acomCpadCodigo;
    @Column(name = "alin_cor_fundo")
    private Integer alinCorFundo;
    @Column(name = "amac_mpad_codigo")
    private Integer amacMpadCodigo;
    @Column(name = "apop_altura")
    private Integer apopAltura;
    @Column(name = "apop_cor")
    private Integer apopCor;
    @Column(name = "apop_largura")
    private Integer apopLargura;
    @Column(name = "apop_titulo", length = 250)
    private String apopTitulo;
    @Column(name = "mpad_numero", length = 10)
    private String mpadNumero;
    @Column(name = "mpad_descricao", length = 100)
    private String mpadDescricao;
    @Column(name = "mpad_mascara", length = 500)
    private String mpadMascara;

    public ViewEventoAcao() {
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

    public Date getEsisDataLeitura() {
        return esisDataLeitura;
    }

    public void setEsisDataLeitura(Date esisDataLeitura) {
        this.esisDataLeitura = esisDataLeitura;
    }

    public String getEsisDescricao() {
        return esisDescricao;
    }

    public void setEsisDescricao(String esisDescricao) {
        this.esisDescricao = esisDescricao;
    }

    public Integer getEsisEspaCodigo() {
        return esisEspaCodigo;
    }

    public void setEsisEspaCodigo(Integer esisEspaCodigo) {
        this.esisEspaCodigo = esisEspaCodigo;
    }

    public Integer getEsisPgaiCodigo() {
        return esisPgaiCodigo;
    }

    public void setEsisPgaiCodigo(Integer esisPgaiCodigo) {
        this.esisPgaiCodigo = esisPgaiCodigo;
    }

    public Integer getEsisTermCodigo() {
        return esisTermCodigo;
    }

    public void setEsisTermCodigo(Integer esisTermCodigo) {
        this.esisTermCodigo = esisTermCodigo;
    }

    public Integer getEsisUsuCodigoLeitura() {
        return esisUsuCodigoLeitura;
    }

    public void setEsisUsuCodigoLeitura(Integer esisUsuCodigoLeitura) {
        this.esisUsuCodigoLeitura = esisUsuCodigoLeitura;
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

    public Date getEsisDataTratamentoServidor() {
        return esisDataTratamentoServidor;
    }

    public void setEsisDataTratamentoServidor(Date esisDataTratamentoServidor) {
        this.esisDataTratamentoServidor = esisDataTratamentoServidor;
    }

    public Integer getApadCodigo() {
        return apadCodigo;
    }

    public void setApadCodigo(Integer apadCodigo) {
        this.apadCodigo = apadCodigo;
    }

    public String getApadDescricao() {
        return apadDescricao;
    }

    public void setApadDescricao(String apadDescricao) {
        this.apadDescricao = apadDescricao;
    }

    public String getApadTipoAcao() {
        return apadTipoAcao;
    }

    public void setApadTipoAcao(String apadTipoAcao) {
        this.apadTipoAcao = apadTipoAcao;
    }

    public Integer getAbbeFrequencia() {
        return abbeFrequencia;
    }

    public void setAbbeFrequencia(Integer abbeFrequencia) {
        this.abbeFrequencia = abbeFrequencia;
    }

    public Integer getAbeeTempoBeep() {
        return abeeTempoBeep;
    }

    public void setAbeeTempoBeep(Integer abeeTempoBeep) {
        this.abeeTempoBeep = abeeTempoBeep;
    }

    public Integer getAbeeTempoEsperando() {
        return abeeTempoEsperando;
    }

    public void setAbeeTempoEsperando(Integer abeeTempoEsperando) {
        this.abeeTempoEsperando = abeeTempoEsperando;
    }

    public Integer getAbolCor() {
        return abolCor;
    }

    public void setAbolCor(Integer abolCor) {
        this.abolCor = abolCor;
    }

    public Integer getAcomCpadCodigo() {
        return acomCpadCodigo;
    }

    public void setAcomCpadCodigo(Integer acomCpadCodigo) {
        this.acomCpadCodigo = acomCpadCodigo;
    }

    public Integer getAlinCorFundo() {
        return alinCorFundo;
    }

    public void setAlinCorFundo(Integer alinCorFundo) {
        this.alinCorFundo = alinCorFundo;
    }

    public Integer getAmacMpadCodigo() {
        return amacMpadCodigo;
    }

    public void setAmacMpadCodigo(Integer amacMpadCodigo) {
        this.amacMpadCodigo = amacMpadCodigo;
    }

    public Integer getApopAltura() {
        return apopAltura;
    }

    public void setApopAltura(Integer apopAltura) {
        this.apopAltura = apopAltura;
    }

    public Integer getApopCor() {
        return apopCor;
    }

    public void setApopCor(Integer apopCor) {
        this.apopCor = apopCor;
    }

    public Integer getApopLargura() {
        return apopLargura;
    }

    public void setApopLargura(Integer apopLargura) {
        this.apopLargura = apopLargura;
    }

    public String getApopTitulo() {
        return apopTitulo;
    }

    public void setApopTitulo(String apopTitulo) {
        this.apopTitulo = apopTitulo;
    }

    public String getMpadNumero() {
        return mpadNumero;
    }

    public void setMpadNumero(String mpadNumero) {
        this.mpadNumero = mpadNumero;
    }

    public String getMpadDescricao() {
        return mpadDescricao;
    }

    public void setMpadDescricao(String mpadDescricao) {
        this.mpadDescricao = mpadDescricao;
    }

    public String getMpadMascara() {
        return mpadMascara;
    }

    public void setMpadMascara(String mpadMascara) {
        this.mpadMascara = mpadMascara;
    }

}
