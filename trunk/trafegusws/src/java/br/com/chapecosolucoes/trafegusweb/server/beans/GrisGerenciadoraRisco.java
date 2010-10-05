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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "gris_gerenciadora_risco")
@NamedQueries({
    @NamedQuery(name = "GrisGerenciadoraRisco.findAll", query = "SELECT g FROM GrisGerenciadoraRisco g")})
public class GrisGerenciadoraRisco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "gris_pjur_pess_oras_codigo")
    private Integer grisPjurPessOrasCodigo;
    @Column(name = "gris_minha_matriz")
    private Character grisMinhaMatriz;
    @JoinColumn(name = "gris_pjur_pess_oras_codigo", referencedColumnName = "pjur_pess_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PjurPessoaJuridica pjurPessoaJuridica;
    @OneToMany(mappedBy = "grisGerenciadoraRisco")
    private Set<GrisGerenciadoraRisco> grisGerenciadoraRiscoSet;
    @JoinColumn(name = "gris_pjur_pess_oras_codigo_matriz", referencedColumnName = "gris_pjur_pess_oras_codigo")
    @ManyToOne
    private GrisGerenciadoraRisco grisGerenciadoraRisco;
    @OneToMany(mappedBy = "grisGerenciadoraRisco")
    private Set<ErasEstacaoRastreamento> erasEstacaoRastreamentoSet;

    public GrisGerenciadoraRisco() {
    }

    public GrisGerenciadoraRisco(Integer grisPjurPessOrasCodigo) {
        this.grisPjurPessOrasCodigo = grisPjurPessOrasCodigo;
    }

    public Integer getGrisPjurPessOrasCodigo() {
        return grisPjurPessOrasCodigo;
    }

    public void setGrisPjurPessOrasCodigo(Integer grisPjurPessOrasCodigo) {
        this.grisPjurPessOrasCodigo = grisPjurPessOrasCodigo;
    }

    public Character getGrisMinhaMatriz() {
        return grisMinhaMatriz;
    }

    public void setGrisMinhaMatriz(Character grisMinhaMatriz) {
        this.grisMinhaMatriz = grisMinhaMatriz;
    }

    public PjurPessoaJuridica getPjurPessoaJuridica() {
        return pjurPessoaJuridica;
    }

    public void setPjurPessoaJuridica(PjurPessoaJuridica pjurPessoaJuridica) {
        this.pjurPessoaJuridica = pjurPessoaJuridica;
    }

    public Set<GrisGerenciadoraRisco> getGrisGerenciadoraRiscoSet() {
        return grisGerenciadoraRiscoSet;
    }

    public void setGrisGerenciadoraRiscoSet(Set<GrisGerenciadoraRisco> grisGerenciadoraRiscoSet) {
        this.grisGerenciadoraRiscoSet = grisGerenciadoraRiscoSet;
    }

    public GrisGerenciadoraRisco getGrisGerenciadoraRisco() {
        return grisGerenciadoraRisco;
    }

    public void setGrisGerenciadoraRisco(GrisGerenciadoraRisco grisGerenciadoraRisco) {
        this.grisGerenciadoraRisco = grisGerenciadoraRisco;
    }

    public Set<ErasEstacaoRastreamento> getErasEstacaoRastreamentoSet() {
        return erasEstacaoRastreamentoSet;
    }

    public void setErasEstacaoRastreamentoSet(Set<ErasEstacaoRastreamento> erasEstacaoRastreamentoSet) {
        this.erasEstacaoRastreamentoSet = erasEstacaoRastreamentoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grisPjurPessOrasCodigo != null ? grisPjurPessOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrisGerenciadoraRisco)) {
            return false;
        }
        GrisGerenciadoraRisco other = (GrisGerenciadoraRisco) object;
        if ((this.grisPjurPessOrasCodigo == null && other.grisPjurPessOrasCodigo != null) || (this.grisPjurPessOrasCodigo != null && !this.grisPjurPessOrasCodigo.equals(other.grisPjurPessOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.GrisGerenciadoraRisco[grisPjurPessOrasCodigo=" + grisPjurPessOrasCodigo + "]";
    }

}
