/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "eter_estatus_terminal")
@NamedQueries({
    @NamedQuery(name = "EterEstatusTerminal.findAll", query = "SELECT e FROM EterEstatusTerminal e")})
public class EterEstatusTerminal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eter_codigo")
    private Integer eterCodigo;
    @Column(name = "eter_descricao")
    private String eterDescricao;
    @OneToMany(mappedBy = "eterEstatusTerminal")
    private Set<TermTerminal> termTerminalSet;

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

    public Set<TermTerminal> getTermTerminalSet() {
        return termTerminalSet;
    }

    public void setTermTerminalSet(Set<TermTerminal> termTerminalSet) {
        this.termTerminalSet = termTerminalSet;
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
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EterEstatusTerminal[eterCodigo=" + eterCodigo + "]";
    }

}
