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
import javax.persistence.Id;
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
@Table(name = "scri_script_criacao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ScriScriptCriacao.findAll", query = "SELECT s FROM ScriScriptCriacao s"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriCodigo", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriCodigo = :scriCodigo"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriDescricao", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriDescricao = :scriDescricao"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriScriptPostgres", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriScriptPostgres = :scriScriptPostgres"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriScriptOracle", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriScriptOracle = :scriScriptOracle"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriScriptSqlServer", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriScriptSqlServer = :scriScriptSqlServer"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriAutor", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriAutor = :scriAutor"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriData", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriData = :scriData"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriDataAlteracao", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriDataAlteracao = :scriDataAlteracao"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriVersaoCriacao", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriVersaoCriacao = :scriVersaoCriacao"),
    @NamedQuery(name = "ScriScriptCriacao.findByScriVersaoAtualizar", query = "SELECT s FROM ScriScriptCriacao s WHERE s.scriVersaoAtualizar = :scriVersaoAtualizar")})
public class ScriScriptCriacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "scri_codigo", nullable = false)
    private Integer scriCodigo;
    @Column(name = "scri_descricao", length = 150)
    private String scriDescricao;
    @Column(name = "scri_script_postgres", length = 5000)
    private String scriScriptPostgres;
    @Column(name = "scri_script_oracle", length = 5000)
    private String scriScriptOracle;
    @Column(name = "scri_script_sql_server", length = 5000)
    private String scriScriptSqlServer;
    @Column(name = "scri_autor", length = 50)
    private String scriAutor;
    @Column(name = "scri_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scriData;
    @Column(name = "scri_data_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scriDataAlteracao;
    @Column(name = "scri_versao_criacao")
    private Integer scriVersaoCriacao;
    @Column(name = "scri_versao_atualizar")
    private Integer scriVersaoAtualizar;

    public ScriScriptCriacao() {
    }

    public ScriScriptCriacao(Integer scriCodigo) {
        this.scriCodigo = scriCodigo;
    }

    public Integer getScriCodigo() {
        return scriCodigo;
    }

    public void setScriCodigo(Integer scriCodigo) {
        this.scriCodigo = scriCodigo;
    }

    public String getScriDescricao() {
        return scriDescricao;
    }

    public void setScriDescricao(String scriDescricao) {
        this.scriDescricao = scriDescricao;
    }

    public String getScriScriptPostgres() {
        return scriScriptPostgres;
    }

    public void setScriScriptPostgres(String scriScriptPostgres) {
        this.scriScriptPostgres = scriScriptPostgres;
    }

    public String getScriScriptOracle() {
        return scriScriptOracle;
    }

    public void setScriScriptOracle(String scriScriptOracle) {
        this.scriScriptOracle = scriScriptOracle;
    }

    public String getScriScriptSqlServer() {
        return scriScriptSqlServer;
    }

    public void setScriScriptSqlServer(String scriScriptSqlServer) {
        this.scriScriptSqlServer = scriScriptSqlServer;
    }

    public String getScriAutor() {
        return scriAutor;
    }

    public void setScriAutor(String scriAutor) {
        this.scriAutor = scriAutor;
    }

    public Date getScriData() {
        return scriData;
    }

    public void setScriData(Date scriData) {
        this.scriData = scriData;
    }

    public Date getScriDataAlteracao() {
        return scriDataAlteracao;
    }

    public void setScriDataAlteracao(Date scriDataAlteracao) {
        this.scriDataAlteracao = scriDataAlteracao;
    }

    public Integer getScriVersaoCriacao() {
        return scriVersaoCriacao;
    }

    public void setScriVersaoCriacao(Integer scriVersaoCriacao) {
        this.scriVersaoCriacao = scriVersaoCriacao;
    }

    public Integer getScriVersaoAtualizar() {
        return scriVersaoAtualizar;
    }

    public void setScriVersaoAtualizar(Integer scriVersaoAtualizar) {
        this.scriVersaoAtualizar = scriVersaoAtualizar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scriCodigo != null ? scriCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScriScriptCriacao)) {
            return false;
        }
        ScriScriptCriacao other = (ScriScriptCriacao) object;
        if ((this.scriCodigo == null && other.scriCodigo != null) || (this.scriCodigo != null && !this.scriCodigo.equals(other.scriCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.ScriScriptCriacao[scriCodigo=" + scriCodigo + "]";
    }

}
