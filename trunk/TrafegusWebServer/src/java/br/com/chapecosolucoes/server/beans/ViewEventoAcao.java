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
@Table(name = "view_evento_acao")
@NamedQueries({
    @NamedQuery(name = "ViewEventoAcao.findAll", query = "SELECT v FROM ViewEventoAcao v")})
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
