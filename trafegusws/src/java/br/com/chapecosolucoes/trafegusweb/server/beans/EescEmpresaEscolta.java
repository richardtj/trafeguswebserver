/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "eesc_empresa_escolta")
@NamedQueries({
    @NamedQuery(name = "EescEmpresaEscolta.findAll", query = "SELECT e FROM EescEmpresaEscolta e"),
    @NamedQuery(name = "EescEmpresaEscolta.findByEescOrasPessPesjCodigo", query = "SELECT e FROM EescEmpresaEscolta e WHERE e.eescOrasPessPesjCodigo = :eescOrasPessPesjCodigo")})
public class EescEmpresaEscolta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eesc_oras_pess_pesj_codigo")
    private Integer eescOrasPessPesjCodigo;
    @OneToMany(mappedBy = "eescEmpresaEscolta", fetch = FetchType.LAZY)
    private Collection<CombComboio> combComboioCollection;
    @JoinColumn(name = "eesc_oras_pess_pesj_codigo", referencedColumnName = "pjur_pess_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private PjurPessoaJuridica pjurPessoaJuridica;

    public EescEmpresaEscolta() {
    }

    public EescEmpresaEscolta(Integer eescOrasPessPesjCodigo) {
        this.eescOrasPessPesjCodigo = eescOrasPessPesjCodigo;
    }

    public Integer getEescOrasPessPesjCodigo() {
        return eescOrasPessPesjCodigo;
    }

    public void setEescOrasPessPesjCodigo(Integer eescOrasPessPesjCodigo) {
        this.eescOrasPessPesjCodigo = eescOrasPessPesjCodigo;
    }

    public Collection<CombComboio> getCombComboioCollection() {
        return combComboioCollection;
    }

    public void setCombComboioCollection(Collection<CombComboio> combComboioCollection) {
        this.combComboioCollection = combComboioCollection;
    }

    public PjurPessoaJuridica getPjurPessoaJuridica() {
        return pjurPessoaJuridica;
    }

    public void setPjurPessoaJuridica(PjurPessoaJuridica pjurPessoaJuridica) {
        this.pjurPessoaJuridica = pjurPessoaJuridica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eescOrasPessPesjCodigo != null ? eescOrasPessPesjCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EescEmpresaEscolta)) {
            return false;
        }
        EescEmpresaEscolta other = (EescEmpresaEscolta) object;
        if ((this.eescOrasPessPesjCodigo == null && other.eescOrasPessPesjCodigo != null) || (this.eescOrasPessPesjCodigo != null && !this.eescOrasPessPesjCodigo.equals(other.eescOrasPessPesjCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EescEmpresaEscolta[eescOrasPessPesjCodigo=" + eescOrasPessPesjCodigo + "]";
    }

}
