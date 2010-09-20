/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "eter_estatus_terminal", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EterEstatusTerminal.findAll", query = "SELECT e FROM EterEstatusTerminal e"),
    @NamedQuery(name = "EterEstatusTerminal.findByEterCodigo", query = "SELECT e FROM EterEstatusTerminal e WHERE e.eterCodigo = :eterCodigo"),
    @NamedQuery(name = "EterEstatusTerminal.findByEterDescricao", query = "SELECT e FROM EterEstatusTerminal e WHERE e.eterDescricao = :eterDescricao")})
public class EterEstatusTerminal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eter_codigo", nullable = false)
    private Integer eterCodigo;
    @Column(name = "eter_descricao", length = 50)
    private String eterDescricao;
    @OneToMany(mappedBy = "eterEstatusTerminal", fetch = FetchType.EAGER)
    private List<TermTerminal> termTerminalList;

    public EterEstatusTerminal() {
    }

    public EterEstatusTerminal(Integer eterCodigo) {
        this.eterCodigo = eterCodigo;
    }

    public Integer getEterCodigo() {
        return eterCodigo;
    }

    public void setEterCodigo(Integer eterCodigo) {
        this.eterCodigo = eterCodigo;
    }

    public String getEterDescricao() {
        return eterDescricao;
    }

    public void setEterDescricao(String eterDescricao) {
        this.eterDescricao = eterDescricao;
    }

    public List<TermTerminal> getTermTerminalList() {
        return termTerminalList;
    }

    public void setTermTerminalList(List<TermTerminal> termTerminalList) {
        this.termTerminalList = termTerminalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eterCodigo != null ? eterCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EterEstatusTerminal)) {
            return false;
        }
        EterEstatusTerminal other = (EterEstatusTerminal) object;
        if ((this.eterCodigo == null && other.eterCodigo != null) || (this.eterCodigo != null && !this.eterCodigo.equals(other.eterCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.EterEstatusTerminal[eterCodigo=" + eterCodigo + "]";
    }

}
