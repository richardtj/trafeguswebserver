/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "cfg_campo_framework", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CfgCampoFramework.findAll", query = "SELECT c FROM CfgCampoFramework c"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcCampoFramework", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcCampoFramework = :cfcCampoFramework"),
    @NamedQuery(name = "CfgCampoFramework.findByCtfTabelaFrameworkId", query = "SELECT c FROM CfgCampoFramework c WHERE c.ctfTabelaFrameworkId = :ctfTabelaFrameworkId"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcCampoDescricao", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcCampoDescricao = :cfcCampoDescricao"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcTamanho", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcTamanho = :cfcTamanho"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcTipo", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcTipo = :cfcTipo"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcNotnull", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcNotnull = :cfcNotnull"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcSequence", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcSequence = :cfcSequence"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcChavePrimaria", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcChavePrimaria = :cfcChavePrimaria"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcChaveEstrangeira", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcChaveEstrangeira = :cfcChaveEstrangeira"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcChaveEstTabela", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcChaveEstTabela = :cfcChaveEstTabela"),
    @NamedQuery(name = "CfgCampoFramework.findByCfcCampoTela", query = "SELECT c FROM CfgCampoFramework c WHERE c.cfcCampoTela = :cfcCampoTela")})
public class CfgCampoFramework implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cfc_campo_framework", nullable = false)
    private Integer cfcCampoFramework;
    @Column(name = "ctf_tabela_framework_id")
    private Integer ctfTabelaFrameworkId;
    @Column(name = "cfc_campo_descricao", length = 50)
    private String cfcCampoDescricao;
    @Column(name = "cfc_tamanho", length = 50)
    private String cfcTamanho;
    @Column(name = "cfc_tipo", length = 50)
    private String cfcTipo;
    @Column(name = "cfc_notnull")
    private Character cfcNotnull;
    @Column(name = "cfc_sequence")
    private Character cfcSequence;
    @Column(name = "cfc_chave_primaria")
    private Character cfcChavePrimaria;
    @Column(name = "cfc_chave_estrangeira")
    private Character cfcChaveEstrangeira;
    @Column(name = "cfc_chave_est_tabela", length = 50)
    private String cfcChaveEstTabela;
    @Column(name = "cfc_campo_tela", length = 100)
    private String cfcCampoTela;

    public CfgCampoFramework() {
    }

    public CfgCampoFramework(Integer cfcCampoFramework) {
        this.cfcCampoFramework = cfcCampoFramework;
    }

    public Integer getCfcCampoFramework() {
        return cfcCampoFramework;
    }

    public void setCfcCampoFramework(Integer cfcCampoFramework) {
        this.cfcCampoFramework = cfcCampoFramework;
    }

    public Integer getCtfTabelaFrameworkId() {
        return ctfTabelaFrameworkId;
    }

    public void setCtfTabelaFrameworkId(Integer ctfTabelaFrameworkId) {
        this.ctfTabelaFrameworkId = ctfTabelaFrameworkId;
    }

    public String getCfcCampoDescricao() {
        return cfcCampoDescricao;
    }

    public void setCfcCampoDescricao(String cfcCampoDescricao) {
        this.cfcCampoDescricao = cfcCampoDescricao;
    }

    public String getCfcTamanho() {
        return cfcTamanho;
    }

    public void setCfcTamanho(String cfcTamanho) {
        this.cfcTamanho = cfcTamanho;
    }

    public String getCfcTipo() {
        return cfcTipo;
    }

    public void setCfcTipo(String cfcTipo) {
        this.cfcTipo = cfcTipo;
    }

    public Character getCfcNotnull() {
        return cfcNotnull;
    }

    public void setCfcNotnull(Character cfcNotnull) {
        this.cfcNotnull = cfcNotnull;
    }

    public Character getCfcSequence() {
        return cfcSequence;
    }

    public void setCfcSequence(Character cfcSequence) {
        this.cfcSequence = cfcSequence;
    }

    public Character getCfcChavePrimaria() {
        return cfcChavePrimaria;
    }

    public void setCfcChavePrimaria(Character cfcChavePrimaria) {
        this.cfcChavePrimaria = cfcChavePrimaria;
    }

    public Character getCfcChaveEstrangeira() {
        return cfcChaveEstrangeira;
    }

    public void setCfcChaveEstrangeira(Character cfcChaveEstrangeira) {
        this.cfcChaveEstrangeira = cfcChaveEstrangeira;
    }

    public String getCfcChaveEstTabela() {
        return cfcChaveEstTabela;
    }

    public void setCfcChaveEstTabela(String cfcChaveEstTabela) {
        this.cfcChaveEstTabela = cfcChaveEstTabela;
    }

    public String getCfcCampoTela() {
        return cfcCampoTela;
    }

    public void setCfcCampoTela(String cfcCampoTela) {
        this.cfcCampoTela = cfcCampoTela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cfcCampoFramework != null ? cfcCampoFramework.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgCampoFramework)) {
            return false;
        }
        CfgCampoFramework other = (CfgCampoFramework) object;
        if ((this.cfcCampoFramework == null && other.cfcCampoFramework != null) || (this.cfcCampoFramework != null && !this.cfcCampoFramework.equals(other.cfcCampoFramework))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CfgCampoFramework[cfcCampoFramework=" + cfcCampoFramework + "]";
    }

}
