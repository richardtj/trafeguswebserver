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
@Table(name = "cfg_chave_estrangeira")
@NamedQueries({
    @NamedQuery(name = "CfgChaveEstrangeira.findAll", query = "SELECT c FROM CfgChaveEstrangeira c"),
    @NamedQuery(name = "CfgChaveEstrangeira.findByCceChaveFrameworkId", query = "SELECT c FROM CfgChaveEstrangeira c WHERE c.cceChaveFrameworkId = :cceChaveFrameworkId"),
    @NamedQuery(name = "CfgChaveEstrangeira.findByCceDicionario", query = "SELECT c FROM CfgChaveEstrangeira c WHERE c.cceDicionario = :cceDicionario"),
    @NamedQuery(name = "CfgChaveEstrangeira.findByCceDescricaoChaveEstrangeira", query = "SELECT c FROM CfgChaveEstrangeira c WHERE c.cceDescricaoChaveEstrangeira = :cceDescricaoChaveEstrangeira"),
    @NamedQuery(name = "CfgChaveEstrangeira.findByCceTabelaReferenciada", query = "SELECT c FROM CfgChaveEstrangeira c WHERE c.cceTabelaReferenciada = :cceTabelaReferenciada"),
    @NamedQuery(name = "CfgChaveEstrangeira.findByCceCamposPk", query = "SELECT c FROM CfgChaveEstrangeira c WHERE c.cceCamposPk = :cceCamposPk"),
    @NamedQuery(name = "CfgChaveEstrangeira.findByCceCamposReferencia", query = "SELECT c FROM CfgChaveEstrangeira c WHERE c.cceCamposReferencia = :cceCamposReferencia")})
public class CfgChaveEstrangeira implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cce_chave_framework_id")
    private Integer cceChaveFrameworkId;
    @Column(name = "cce_dicionario")
    private String cceDicionario;
    @Column(name = "cce_descricao_chave_estrangeira")
    private String cceDescricaoChaveEstrangeira;
    @Column(name = "cce_tabela_referenciada")
    private String cceTabelaReferenciada;
    @Column(name = "cce_campos_pk")
    private String cceCamposPk;
    @Column(name = "cce_campos_referencia")
    private String cceCamposReferencia;

    public CfgChaveEstrangeira() {
    }

    public CfgChaveEstrangeira(Integer cceChaveFrameworkId) {
        this.cceChaveFrameworkId = cceChaveFrameworkId;
    }

    public Integer getCceChaveFrameworkId() {
        return cceChaveFrameworkId;
    }

    public void setCceChaveFrameworkId(Integer cceChaveFrameworkId) {
        this.cceChaveFrameworkId = cceChaveFrameworkId;
    }

    public String getCceDicionario() {
        return cceDicionario;
    }

    public void setCceDicionario(String cceDicionario) {
        this.cceDicionario = cceDicionario;
    }

    public String getCceDescricaoChaveEstrangeira() {
        return cceDescricaoChaveEstrangeira;
    }

    public void setCceDescricaoChaveEstrangeira(String cceDescricaoChaveEstrangeira) {
        this.cceDescricaoChaveEstrangeira = cceDescricaoChaveEstrangeira;
    }

    public String getCceTabelaReferenciada() {
        return cceTabelaReferenciada;
    }

    public void setCceTabelaReferenciada(String cceTabelaReferenciada) {
        this.cceTabelaReferenciada = cceTabelaReferenciada;
    }

    public String getCceCamposPk() {
        return cceCamposPk;
    }

    public void setCceCamposPk(String cceCamposPk) {
        this.cceCamposPk = cceCamposPk;
    }

    public String getCceCamposReferencia() {
        return cceCamposReferencia;
    }

    public void setCceCamposReferencia(String cceCamposReferencia) {
        this.cceCamposReferencia = cceCamposReferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cceChaveFrameworkId != null ? cceChaveFrameworkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgChaveEstrangeira)) {
            return false;
        }
        CfgChaveEstrangeira other = (CfgChaveEstrangeira) object;
        if ((this.cceChaveFrameworkId == null && other.cceChaveFrameworkId != null) || (this.cceChaveFrameworkId != null && !this.cceChaveFrameworkId.equals(other.cceChaveFrameworkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CfgChaveEstrangeira[cceChaveFrameworkId=" + cceChaveFrameworkId + "]";
    }

}
