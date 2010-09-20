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
    @OneToMany(mappedBy = "grisGerenciadoraRisco", fetch = FetchType.EAGER)
    private List<SterSinalTerminal> sterSinalTerminalList;
    @OneToMany(mappedBy = "grisGerenciadoraRisco1", fetch = FetchType.EAGER)
    private List<SterSinalTerminal> sterSinalTerminalList1;
    @JoinColumn(name = "gris_pjur_pess_oras_codigo", referencedColumnName = "pjur_pess_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PjurPessoaJuridica pjurPessoaJuridica;
    @OneToMany(mappedBy = "grisGerenciadoraRisco", fetch = FetchType.EAGER)
    private List<GrisGerenciadoraRisco> grisGerenciadoraRiscoList;
    @JoinColumn(name = "gris_pjur_pess_oras_codigo_matriz", referencedColumnName = "gris_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private GrisGerenciadoraRisco grisGerenciadoraRisco;
    @OneToMany(mappedBy = "grisGerenciadoraRisco", fetch = FetchType.EAGER)
    private List<ErasEstacaoRastreamento> erasEstacaoRastreamentoList;

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

    public List<SterSinalTerminal> getSterSinalTerminalList() {
        return sterSinalTerminalList;
    }

    public void setSterSinalTerminalList(List<SterSinalTerminal> sterSinalTerminalList) {
        this.sterSinalTerminalList = sterSinalTerminalList;
    }

    public List<SterSinalTerminal> getSterSinalTerminalList1() {
        return sterSinalTerminalList1;
    }

    public void setSterSinalTerminalList1(List<SterSinalTerminal> sterSinalTerminalList1) {
        this.sterSinalTerminalList1 = sterSinalTerminalList1;
    }

    public PjurPessoaJuridica getPjurPessoaJuridica() {
        return pjurPessoaJuridica;
    }

    public void setPjurPessoaJuridica(PjurPessoaJuridica pjurPessoaJuridica) {
        this.pjurPessoaJuridica = pjurPessoaJuridica;
    }

    public List<GrisGerenciadoraRisco> getGrisGerenciadoraRiscoList() {
        return grisGerenciadoraRiscoList;
    }

    public void setGrisGerenciadoraRiscoList(List<GrisGerenciadoraRisco> grisGerenciadoraRiscoList) {
        this.grisGerenciadoraRiscoList = grisGerenciadoraRiscoList;
    }

    public GrisGerenciadoraRisco getGrisGerenciadoraRisco() {
        return grisGerenciadoraRisco;
    }

    public void setGrisGerenciadoraRisco(GrisGerenciadoraRisco grisGerenciadoraRisco) {
        this.grisGerenciadoraRisco = grisGerenciadoraRisco;
    }

    public List<ErasEstacaoRastreamento> getErasEstacaoRastreamentoList() {
        return erasEstacaoRastreamentoList;
    }

    public void setErasEstacaoRastreamentoList(List<ErasEstacaoRastreamento> erasEstacaoRastreamentoList) {
        this.erasEstacaoRastreamentoList = erasEstacaoRastreamentoList;
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
        return "br.com.chapecosolucoes.server.beans.GrisGerenciadoraRisco[grisPjurPessOrasCodigo=" + grisPjurPessOrasCodigo + "]";
    }

}
