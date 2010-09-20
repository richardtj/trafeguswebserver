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
@Table(name = "view_veiculo_evento_sistema", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewVeiculoEventoSistema.findAll", query = "SELECT v FROM ViewVeiculoEventoSistema v"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByIdentificador", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByTermCodigo", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.termCodigo = :termCodigo"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByTermNumeroTerminal", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.termNumeroTerminal = :termNumeroTerminal"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByEspaCodigo", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.espaCodigo = :espaCodigo"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByEspaDescricao", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.espaDescricao = :espaDescricao"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByEsisCodigo", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.esisCodigo = :esisCodigo"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByEsisDescricao", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.esisDescricao = :esisDescricao"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByEsisDataInicio", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.esisDataInicio = :esisDataInicio"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByEsisValor", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.esisValor = :esisValor"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByErasCodigo", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.erasCodigo = :erasCodigo"),
    @NamedQuery(name = "ViewVeiculoEventoSistema.findByEsisDataCadastro", query = "SELECT v FROM ViewVeiculoEventoSistema v WHERE v.esisDataCadastro = :esisDataCadastro")})
public class ViewVeiculoEventoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "term_codigo")
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "espa_codigo")
    private Integer espaCodigo;
    @Column(name = "espa_descricao", length = 100)
    private String espaDescricao;
    @Column(name = "esis_codigo")
    private Integer esisCodigo;
    @Column(name = "esis_descricao", length = 100)
    private String esisDescricao;
    @Column(name = "esis_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataInicio;
    @Column(name = "esis_valor", length = 50)
    private String esisValor;
    @Column(name = "eras_codigo")
    private Integer erasCodigo;
    @Column(name = "esis_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date esisDataCadastro;

    public ViewVeiculoEventoSistema() {
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

    public Integer getEspaCodigo() {
        return espaCodigo;
    }

    public void setEspaCodigo(Integer espaCodigo) {
        this.espaCodigo = espaCodigo;
    }

    public String getEspaDescricao() {
        return espaDescricao;
    }

    public void setEspaDescricao(String espaDescricao) {
        this.espaDescricao = espaDescricao;
    }

    public Integer getEsisCodigo() {
        return esisCodigo;
    }

    public void setEsisCodigo(Integer esisCodigo) {
        this.esisCodigo = esisCodigo;
    }

    public String getEsisDescricao() {
        return esisDescricao;
    }

    public void setEsisDescricao(String esisDescricao) {
        this.esisDescricao = esisDescricao;
    }

    public Date getEsisDataInicio() {
        return esisDataInicio;
    }

    public void setEsisDataInicio(Date esisDataInicio) {
        this.esisDataInicio = esisDataInicio;
    }

    public String getEsisValor() {
        return esisValor;
    }

    public void setEsisValor(String esisValor) {
        this.esisValor = esisValor;
    }

    public Integer getErasCodigo() {
        return erasCodigo;
    }

    public void setErasCodigo(Integer erasCodigo) {
        this.erasCodigo = erasCodigo;
    }

    public Date getEsisDataCadastro() {
        return esisDataCadastro;
    }

    public void setEsisDataCadastro(Date esisDataCadastro) {
        this.esisDataCadastro = esisDataCadastro;
    }

}
