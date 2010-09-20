/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "view_dados_carreta", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewDadosCarreta.findAll", query = "SELECT v FROM ViewDadosCarreta v"),
    @NamedQuery(name = "ViewDadosCarreta.findByVcavVeicOrasCodigo", query = "SELECT v FROM ViewDadosCarreta v WHERE v.vcavVeicOrasCodigo = :vcavVeicOrasCodigo"),
    @NamedQuery(name = "ViewDadosCarreta.findByVccaVcarVeicOrasCodigo", query = "SELECT v FROM ViewDadosCarreta v WHERE v.vccaVcarVeicOrasCodigo = :vccaVcarVeicOrasCodigo"),
    @NamedQuery(name = "ViewDadosCarreta.findByIdentificador", query = "SELECT v FROM ViewDadosCarreta v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewDadosCarreta.findByTermCodigo", query = "SELECT v FROM ViewDadosCarreta v WHERE v.termCodigo = :termCodigo"),
    @NamedQuery(name = "ViewDadosCarreta.findByTermNumeroTerminal", query = "SELECT v FROM ViewDadosCarreta v WHERE v.termNumeroTerminal = :termNumeroTerminal"),
    @NamedQuery(name = "ViewDadosCarreta.findByTecnDescricao", query = "SELECT v FROM ViewDadosCarreta v WHERE v.tecnDescricao = :tecnDescricao"),
    @NamedQuery(name = "ViewDadosCarreta.findByTransportador", query = "SELECT v FROM ViewDadosCarreta v WHERE v.transportador = :transportador"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicAnoFabricacao", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicAnoFabricacao = :veicAnoFabricacao"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicAnoModelo", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicAnoModelo = :veicAnoModelo"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicChassi", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicChassi = :veicChassi"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicCor", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicCor = :veicCor"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicFatorRpm", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicFatorRpm = :veicFatorRpm"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicFatorVelocidade", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicFatorVelocidade = :veicFatorVelocidade"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicObservacao", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicObservacao = :veicObservacao"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicRenavam", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicRenavam = :veicRenavam"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicSenhaProprietario", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicSenhaProprietario = :veicSenhaProprietario"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicTamanho", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicTamanho = :veicTamanho"),
    @NamedQuery(name = "ViewDadosCarreta.findByVeicTelefone", query = "SELECT v FROM ViewDadosCarreta v WHERE v.veicTelefone = :veicTelefone"),
    @NamedQuery(name = "ViewDadosCarreta.findByModelo", query = "SELECT v FROM ViewDadosCarreta v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "ViewDadosCarreta.findByMarca", query = "SELECT v FROM ViewDadosCarreta v WHERE v.marca = :marca")})
public class ViewDadosCarreta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "vcav_veic_oras_codigo")
    private Integer vcavVeicOrasCodigo;
    @Column(name = "vcca_vcar_veic_oras_codigo")
    private Integer vccaVcarVeicOrasCodigo;
    @Column(name = "identificador", length = 10)
    private String identificador;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "tecn_descricao", length = 50)
    private String tecnDescricao;
    @Column(name = "transportador", length = 50)
    private String transportador;
    @Column(name = "veic_ano_fabricacao", length = 4)
    private String veicAnoFabricacao;
    @Column(name = "veic_ano_modelo", length = 4)
    private String veicAnoModelo;
    @Column(name = "veic_chassi", length = 50)
    private String veicChassi;
    @Column(name = "veic_cor", length = 20)
    private String veicCor;
    @Column(name = "veic_fator_rpm", precision = 15, scale = 2)
    private BigDecimal veicFatorRpm;
    @Column(name = "veic_fator_velocidade", precision = 15, scale = 2)
    private BigDecimal veicFatorVelocidade;
    @Column(name = "veic_observacao", length = 5000)
    private String veicObservacao;
    @Column(name = "veic_renavam", length = 50)
    private String veicRenavam;
    @Column(name = "veic_senha_proprietario", length = 20)
    private String veicSenhaProprietario;
    @Column(name = "veic_tamanho", precision = 15, scale = 2)
    private BigDecimal veicTamanho;
    @Column(name = "veic_telefone", length = 20)
    private String veicTelefone;
    @Column(name = "modelo", length = 50)
    private String modelo;
    @Column(name = "marca", length = 50)
    private String marca;

    public ViewDadosCarreta() {
    }

    public Integer getVcavVeicOrasCodigo() {
        return vcavVeicOrasCodigo;
    }

    public void setVcavVeicOrasCodigo(Integer vcavVeicOrasCodigo) {
        this.vcavVeicOrasCodigo = vcavVeicOrasCodigo;
    }

    public Integer getVccaVcarVeicOrasCodigo() {
        return vccaVcarVeicOrasCodigo;
    }

    public void setVccaVcarVeicOrasCodigo(Integer vccaVcarVeicOrasCodigo) {
        this.vccaVcarVeicOrasCodigo = vccaVcarVeicOrasCodigo;
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

    public String getTecnDescricao() {
        return tecnDescricao;
    }

    public void setTecnDescricao(String tecnDescricao) {
        this.tecnDescricao = tecnDescricao;
    }

    public String getTransportador() {
        return transportador;
    }

    public void setTransportador(String transportador) {
        this.transportador = transportador;
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

    public BigDecimal getVeicFatorRpm() {
        return veicFatorRpm;
    }

    public void setVeicFatorRpm(BigDecimal veicFatorRpm) {
        this.veicFatorRpm = veicFatorRpm;
    }

    public BigDecimal getVeicFatorVelocidade() {
        return veicFatorVelocidade;
    }

    public void setVeicFatorVelocidade(BigDecimal veicFatorVelocidade) {
        this.veicFatorVelocidade = veicFatorVelocidade;
    }

    public String getVeicObservacao() {
        return veicObservacao;
    }

    public void setVeicObservacao(String veicObservacao) {
        this.veicObservacao = veicObservacao;
    }

    public String getVeicRenavam() {
        return veicRenavam;
    }

    public void setVeicRenavam(String veicRenavam) {
        this.veicRenavam = veicRenavam;
    }

    public String getVeicSenhaProprietario() {
        return veicSenhaProprietario;
    }

    public void setVeicSenhaProprietario(String veicSenhaProprietario) {
        this.veicSenhaProprietario = veicSenhaProprietario;
    }

    public BigDecimal getVeicTamanho() {
        return veicTamanho;
    }

    public void setVeicTamanho(BigDecimal veicTamanho) {
        this.veicTamanho = veicTamanho;
    }

    public String getVeicTelefone() {
        return veicTelefone;
    }

    public void setVeicTelefone(String veicTelefone) {
        this.veicTelefone = veicTelefone;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
