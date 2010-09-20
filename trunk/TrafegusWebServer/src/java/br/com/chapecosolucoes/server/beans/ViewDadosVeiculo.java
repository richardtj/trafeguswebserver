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
@Table(name = "view_dados_veiculo", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewDadosVeiculo.findAll", query = "SELECT v FROM ViewDadosVeiculo v"),
    @NamedQuery(name = "ViewDadosVeiculo.findByOrasCodigo", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.orasCodigo = :orasCodigo"),
    @NamedQuery(name = "ViewDadosVeiculo.findByIdentificador", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewDadosVeiculo.findByTermCodigo", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.termCodigo = :termCodigo"),
    @NamedQuery(name = "ViewDadosVeiculo.findByTermNumeroTerminal", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.termNumeroTerminal = :termNumeroTerminal"),
    @NamedQuery(name = "ViewDadosVeiculo.findByErasCodigo", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.erasCodigo = :erasCodigo"),
    @NamedQuery(name = "ViewDadosVeiculo.findByTecnDescricao", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.tecnDescricao = :tecnDescricao"),
    @NamedQuery(name = "ViewDadosVeiculo.findByVtecVersao", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.vtecVersao = :vtecVersao"),
    @NamedQuery(name = "ViewDadosVeiculo.findByMvecDescricao", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.mvecDescricao = :mvecDescricao"),
    @NamedQuery(name = "ViewDadosVeiculo.findByMveiDescricao", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.mveiDescricao = :mveiDescricao"),
    @NamedQuery(name = "ViewDadosVeiculo.findByVeicAnoFabricacao", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.veicAnoFabricacao = :veicAnoFabricacao"),
    @NamedQuery(name = "ViewDadosVeiculo.findByVeicAnoModelo", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.veicAnoModelo = :veicAnoModelo"),
    @NamedQuery(name = "ViewDadosVeiculo.findByVeicCor", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.veicCor = :veicCor"),
    @NamedQuery(name = "ViewDadosVeiculo.findByVeicOrasCodigo", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.veicOrasCodigo = :veicOrasCodigo"),
    @NamedQuery(name = "ViewDadosVeiculo.findByVeicTelefone", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.veicTelefone = :veicTelefone"),
    @NamedQuery(name = "ViewDadosVeiculo.findByVeicPessOrasCodigoPropri", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.veicPessOrasCodigoPropri = :veicPessOrasCodigoPropri"),
    @NamedQuery(name = "ViewDadosVeiculo.findByTermAtivo", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.termAtivo = :termAtivo"),
    @NamedQuery(name = "ViewDadosVeiculo.findByOperacao", query = "SELECT v FROM ViewDadosVeiculo v WHERE v.operacao = :operacao")})
public class ViewDadosVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "oras_codigo")
    private Integer orasCodigo;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "tecn_descricao", length = 50)
    private String tecnDescricao;
    @Column(name = "vtec_versao", length = 30)
    private String vtecVersao;
    @Column(name = "mvec_descricao", length = 50)
    private String mvecDescricao;
    @Column(name = "mvei_descricao", length = 50)
    private String mveiDescricao;
    @Column(name = "veic_ano_fabricacao", length = 4)
    private String veicAnoFabricacao;
    @Column(name = "veic_ano_modelo", length = 4)
    private String veicAnoModelo;
    @Column(name = "veic_cor", length = 20)
    private String veicCor;
    @Column(name = "veic_oras_codigo")
    private Integer veicOrasCodigo;
    @Column(name = "veic_telefone", length = 20)
    private String veicTelefone;
    @Column(name = "veic_pess_oras_codigo_propri")
    private Integer veicPessOrasCodigoPropri;
    @Column(name = "term_ativo")
    private Character termAtivo;
    @Column(name = "operacao", length = 2147483647)
    private String operacao;

    public ViewDadosVeiculo() {
    }

    public Integer getOrasCodigo() {
        return orasCodigo;
    }

    public void setOrasCodigo(Integer orasCodigo) {
        this.orasCodigo = orasCodigo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getTermCodigo() {
        return termCodigo;
    }

    public void setTermCodigo(Integer termCodigo) {
        this.termCodigo = termCodigo;
    }

    public String getTermNumeroTerminal() {
        return termNumeroTerminal;
    }

    public void setTermNumeroTerminal(String termNumeroTerminal) {
        this.termNumeroTerminal = termNumeroTerminal;
    }

    public Integer getErasCodigo() {
        return erasCodigo;
    }

    public void setErasCodigo(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

    public String getTecnDescricao() {
        return tecnDescricao;
    }

    public void setTecnDescricao(String tecnDescricao) {
        this.tecnDescricao = tecnDescricao;
    }

    public String getVtecVersao() {
        return vtecVersao;
    }

    public void setVtecVersao(String vtecVersao) {
        this.vtecVersao = vtecVersao;
    }

    public String getMvecDescricao() {
        return mvecDescricao;
    }

    public void setMvecDescricao(String mvecDescricao) {
        this.mvecDescricao = mvecDescricao;
    }

    public String getMveiDescricao() {
        return mveiDescricao;
    }

    public void setMveiDescricao(String mveiDescricao) {
        this.mveiDescricao = mveiDescricao;
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

    public String getVeicCor() {
        return veicCor;
    }

    public void setVeicCor(String veicCor) {
        this.veicCor = veicCor;
    }

    public Integer getVeicOrasCodigo() {
        return veicOrasCodigo;
    }

    public void setVeicOrasCodigo(Integer veicOrasCodigo) {
        this.veicOrasCodigo = veicOrasCodigo;
    }

    public String getVeicTelefone() {
        return veicTelefone;
    }

    public void setVeicTelefone(String veicTelefone) {
        this.veicTelefone = veicTelefone;
    }

    public Integer getVeicPessOrasCodigoPropri() {
        return veicPessOrasCodigoPropri;
    }

    public void setVeicPessOrasCodigoPropri(Integer veicPessOrasCodigoPropri) {
        this.veicPessOrasCodigoPropri = veicPessOrasCodigoPropri;
    }

    public Character getTermAtivo() {
        return termAtivo;
    }

    public void setTermAtivo(Character termAtivo) {
        this.termAtivo = termAtivo;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

}
