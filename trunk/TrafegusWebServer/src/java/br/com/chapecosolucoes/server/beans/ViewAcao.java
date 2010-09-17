/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "view_acao")
@NamedQueries({
    @NamedQuery(name = "ViewAcao.findAll", query = "SELECT v FROM ViewAcao v")})
public class ViewAcao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "apad_codigo")
    private Integer apadCodigo;
    @Column(name = "apad_descricao", length = 50)
    private String apadDescricao;
    @Column(name = "apad_codigo_gr")
    private Integer apadCodigoGr;
    @Column(name = "apad_tipo_acao", length = 10)
    private String apadTipoAcao;
    @Column(name = "abol_cor")
    private Integer abolCor;
    @Column(name = "apop_altura")
    private Integer apopAltura;
    @Column(name = "apop_cor")
    private Integer apopCor;
    @Column(name = "apop_largura")
    private Integer apopLargura;
    @Column(name = "apop_titulo", length = 250)
    private String apopTitulo;
    @Column(name = "abbe_frequencia")
    private Integer abbeFrequencia;
    @Column(name = "abee_tempo_beep")
    private Integer abeeTempoBeep;
    @Column(name = "abee_tempo_esperando")
    private Integer abeeTempoEsperando;
    @Column(name = "alin_cor_fundo")
    private Integer alinCorFundo;
    @Column(name = "amac_mpad_codigo")
    private Integer amacMpadCodigo;
    @Column(name = "acom_cpad_codigo")
    private Integer acomCpadCodigo;
    @Column(name = "mpad_numero", length = 10)
    private String mpadNumero;
    @Column(name = "mpad_descricao", length = 100)
    private String mpadDescricao;
    @Column(name = "mpad_mascara", length = 500)
    private String mpadMascara;

    public ViewAcao() {
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

    public Integer getApadCodigoGr() {
        return apadCodigoGr;
    }

    public void setApadCodigoGr(Integer apadCodigoGr) {
        this.apadCodigoGr = apadCodigoGr;
    }

    public String getApadTipoAcao() {
        return apadTipoAcao;
    }

    public void setApadTipoAcao(String apadTipoAcao) {
        this.apadTipoAcao = apadTipoAcao;
    }

    public Integer getAbolCor() {
        return abolCor;
    }

    public void setAbolCor(Integer abolCor) {
        this.abolCor = abolCor;
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

    public Integer getAcomCpadCodigo() {
        return acomCpadCodigo;
    }

    public void setAcomCpadCodigo(Integer acomCpadCodigo) {
        this.acomCpadCodigo = acomCpadCodigo;
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
