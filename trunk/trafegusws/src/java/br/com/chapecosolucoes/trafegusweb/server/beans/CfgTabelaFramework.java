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
@Table(name = "cfg_tabela_framework", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CfgTabelaFramework.findAll", query = "SELECT c FROM CfgTabelaFramework c"),
    @NamedQuery(name = "CfgTabelaFramework.findByCtfTabelaFrameworkId", query = "SELECT c FROM CfgTabelaFramework c WHERE c.ctfTabelaFrameworkId = :ctfTabelaFrameworkId"),
    @NamedQuery(name = "CfgTabelaFramework.findByCtfTabelaDescricao", query = "SELECT c FROM CfgTabelaFramework c WHERE c.ctfTabelaDescricao = :ctfTabelaDescricao")})
public class CfgTabelaFramework implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ctf_tabela_framework_id", nullable = false)
    private Integer ctfTabelaFrameworkId;
    @Column(name = "ctf_tabela_descricao", length = 50)
    private String ctfTabelaDescricao;

    public CfgTabelaFramework() {
    }

    public CfgTabelaFramework(Integer ctfTabelaFrameworkId) {
        this.ctfTabelaFrameworkId = ctfTabelaFrameworkId;
    }

    public Integer getCtfTabelaFrameworkId() {
        return ctfTabelaFrameworkId;
    }

    public void setCtfTabelaFrameworkId(Integer ctfTabelaFrameworkId) {
        this.ctfTabelaFrameworkId = ctfTabelaFrameworkId;
    }

    public String getCtfTabelaDescricao() {
        return ctfTabelaDescricao;
    }

    public void setCtfTabelaDescricao(String ctfTabelaDescricao) {
        this.ctfTabelaDescricao = ctfTabelaDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctfTabelaFrameworkId != null ? ctfTabelaFrameworkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgTabelaFramework)) {
            return false;
        }
        CfgTabelaFramework other = (CfgTabelaFramework) object;
        if ((this.ctfTabelaFrameworkId == null && other.ctfTabelaFrameworkId != null) || (this.ctfTabelaFrameworkId != null && !this.ctfTabelaFrameworkId.equals(other.ctfTabelaFrameworkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CfgTabelaFramework[ctfTabelaFrameworkId=" + ctfTabelaFrameworkId + "]";
    }

}
