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
 * @author Emerson
 */
@Entity
@Table(name = "gris_gerenciadora_risco", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "GrisGerenciadoraRisco.findAll", query = "SELECT g FROM GrisGerenciadoraRisco g"),
    @NamedQuery(name = "GrisGerenciadoraRisco.findByGrisPjurPessOrasCodigo", query = "SELECT g FROM GrisGerenciadoraRisco g WHERE g.grisPjurPessOrasCodigo = :grisPjurPessOrasCodigo"),
    @NamedQuery(name = "GrisGerenciadoraRisco.findByGrisMinhaMatriz", query = "SELECT g FROM GrisGerenciadoraRisco g WHERE g.grisMinhaMatriz = :grisMinhaMatriz")})
public class GrisGerenciadoraRisco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "gris_pjur_pess_oras_codigo", nullable = false)
    private Integer grisPjurPessOrasCodigo;
    @Column(name = "gris_minha_matriz")
    private Character grisMinhaMatriz;
    @OneToMany(mappedBy = "grisGerenciadoraRisco")
    private Collection<SterSinalTerminal> sterSinalTerminalCollection;
    @OneToMany(mappedBy = "grisGerenciadoraRisco1")
    private Collection<SterSinalTerminal> sterSinalTerminalCollection1;
    @JoinColumn(name = "gris_pjur_pess_oras_codigo", referencedColumnName = "pjur_pess_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PjurPessoaJuridica pjurPessoaJuridica;
    @OneToMany(mappedBy = "grisGerenciadoraRisco")
    private Collection<GrisGerenciadoraRisco> grisGerenciadoraRiscoCollection;
    @JoinColumn(name = "gris_pjur_pess_oras_codigo_matriz", referencedColumnName = "gris_pjur_pess_oras_codigo")
    @ManyToOne
    private GrisGerenciadoraRisco grisGerenciadoraRisco;
    @OneToMany(mappedBy = "grisGerenciadoraRisco")
    private Collection<ErasEstacaoRastreamento> erasEstacaoRastreamentoCollection;

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

    public Collection<SterSinalTerminal> getSterSinalTerminalCollection() {
        return sterSinalTerminalCollection;
    }

    public void setSterSinalTerminalCollection(Collection<SterSinalTerminal> sterSinalTerminalCollection) {
        this.sterSinalTerminalCollection = sterSinalTerminalCollection;
    }

    public Collection<SterSinalTerminal> getSterSinalTerminalCollection1() {
        return sterSinalTerminalCollection1;
    }

    public void setSterSinalTerminalCollection1(Collection<SterSinalTerminal> sterSinalTerminalCollection1) {
        this.sterSinalTerminalCollection1 = sterSinalTerminalCollection1;
    }

    public PjurPessoaJuridica getPjurPessoaJuridica() {
        return pjurPessoaJuridica;
    }

    public void setPjurPessoaJuridica(PjurPessoaJuridica pjurPessoaJuridica) {
        this.pjurPessoaJuridica = pjurPessoaJuridica;
    }

    public Collection<GrisGerenciadoraRisco> getGrisGerenciadoraRiscoCollection() {
        return grisGerenciadoraRiscoCollection;
    }

    public void setGrisGerenciadoraRiscoCollection(Collection<GrisGerenciadoraRisco> grisGerenciadoraRiscoCollection) {
        this.grisGerenciadoraRiscoCollection = grisGerenciadoraRiscoCollection;
    }

    public GrisGerenciadoraRisco getGrisGerenciadoraRisco() {
        return grisGerenciadoraRisco;
    }

    public void setGrisGerenciadoraRisco(GrisGerenciadoraRisco grisGerenciadoraRisco) {
        this.grisGerenciadoraRisco = grisGerenciadoraRisco;
    }

    public Collection<ErasEstacaoRastreamento> getErasEstacaoRastreamentoCollection() {
        return erasEstacaoRastreamentoCollection;
    }

    public void setErasEstacaoRastreamentoCollection(Collection<ErasEstacaoRastreamento> erasEstacaoRastreamentoCollection) {
        this.erasEstacaoRastreamentoCollection = erasEstacaoRastreamentoCollection;
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
