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
@Table(name = "view_acao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewAcao.findAll", query = "SELECT v FROM ViewAcao v"),
    @NamedQuery(name = "ViewAcao.findByApadCodigo", query = "SELECT v FROM ViewAcao v WHERE v.apadCodigo = :apadCodigo"),
    @NamedQuery(name = "ViewAcao.findByApadDescricao", query = "SELECT v FROM ViewAcao v WHERE v.apadDescricao = :apadDescricao"),
    @NamedQuery(name = "ViewAcao.findByApadCodigoGr", query = "SELECT v FROM ViewAcao v WHERE v.apadCodigoGr = :apadCodigoGr"),
    @NamedQuery(name = "ViewAcao.findByApadTipoAcao", query = "SELECT v FROM ViewAcao v WHERE v.apadTipoAcao = :apadTipoAcao"),
    @NamedQuery(name = "ViewAcao.findByAbolCor", query = "SELECT v FROM ViewAcao v WHERE v.abolCor = :abolCor"),
    @NamedQuery(name = "ViewAcao.findByApopAltura", query = "SELECT v FROM ViewAcao v WHERE v.apopAltura = :apopAltura"),
    @NamedQuery(name = "ViewAcao.findByApopCor", query = "SELECT v FROM ViewAcao v WHERE v.apopCor = :apopCor"),
    @NamedQuery(name = "ViewAcao.findByApopLargura", query = "SELECT v FROM ViewAcao v WHERE v.apopLargura = :apopLargura"),
    @NamedQuery(name = "ViewAcao.findByApopTitulo", query = "SELECT v FROM ViewAcao v WHERE v.apopTitulo = :apopTitulo"),
    @NamedQuery(name = "ViewAcao.findByAbbeFrequencia", query = "SELECT v FROM ViewAcao v WHERE v.abbeFrequencia = :abbeFrequencia"),
    @NamedQuery(name = "ViewAcao.findByAbeeTempoBeep", query = "SELECT v FROM ViewAcao v WHERE v.abeeTempoBeep = :abeeTempoBeep"),
    @NamedQuery(name = "ViewAcao.findByAbeeTempoEsperando", query = "SELECT v FROM ViewAcao v WHERE v.abeeTempoEsperando = :abeeTempoEsperando"),
    @NamedQuery(name = "ViewAcao.findByAlinCorFundo", query = "SELECT v FROM ViewAcao v WHERE v.alinCorFundo = :alinCorFundo"),
    @NamedQuery(name = "ViewAcao.findByAmacMpadCodigo", query = "SELECT v FROM ViewAcao v WHERE v.amacMpadCodigo = :amacMpadCodigo"),
    @NamedQuery(name = "ViewAcao.findByAcomCpadCodigo", query = "SELECT v FROM ViewAcao v WHERE v.acomCpadCodigo = :acomCpadCodigo"),
    @NamedQuery(name = "ViewAcao.findByMpadNumero", query = "SELECT v FROM ViewAcao v WHERE v.mpadNumero = :mpadNumero"),
    @NamedQuery(name = "ViewAcao.findByMpadDescricao", query = "SELECT v FROM ViewAcao v WHERE v.mpadDescricao = :mpadDescricao"),
    @NamedQuery(name = "ViewAcao.findByMpadMascara", query = "SELECT v FROM ViewAcao v WHERE v.mpadMascara = :mpadMascara")})
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
