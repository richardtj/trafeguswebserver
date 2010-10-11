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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ster_sinal_terminal")
@NamedQueries({
    @NamedQuery(name = "SterSinalTerminal.findAll", query = "SELECT s FROM SterSinalTerminal s"),
    @NamedQuery(name = "SterSinalTerminal.findBySterCodigo", query = "SELECT s FROM SterSinalTerminal s WHERE s.sterCodigo = :sterCodigo"),
    @NamedQuery(name = "SterSinalTerminal.findBySterDataInclusaoSinal", query = "SELECT s FROM SterSinalTerminal s WHERE s.sterDataInclusaoSinal = :sterDataInclusaoSinal"),
    @NamedQuery(name = "SterSinalTerminal.findBySterDataExclusaoSinal", query = "SELECT s FROM SterSinalTerminal s WHERE s.sterDataExclusaoSinal = :sterDataExclusaoSinal")})
public class SterSinalTerminal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ster_codigo")
    private Integer sterCodigo;
    @Column(name = "ster_data_inclusao_sinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sterDataInclusaoSinal;
    @Column(name = "ster_data_exclusao_sinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sterDataExclusaoSinal;
    @JoinColumn(name = "ster_term_codigo", referencedColumnName = "term_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TermTerminal termTerminal;
    @JoinColumn(name = "ster_gris_pjur_pess_oras_destino", referencedColumnName = "gris_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private GrisGerenciadoraRisco grisGerenciadoraRisco;
    @JoinColumn(name = "ster_gris_pjur_pess_oras_origem", referencedColumnName = "gris_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private GrisGerenciadoraRisco grisGerenciadoraRisco1;

    public SterSinalTerminal() {
    }

    public SterSinalTerminal(Integer sterCodigo) {
        this.sterCodigo = sterCodigo;
    }

    public Integer getSterCodigo() {
        return sterCodigo;
    }

    public void setSterCodigo(Integer sterCodigo) {
        this.sterCodigo = sterCodigo;
    }

    public Date getSterDataInclusaoSinal() {
        return sterDataInclusaoSinal;
    }

    public void setSterDataInclusaoSinal(Date sterDataInclusaoSinal) {
        this.sterDataInclusaoSinal = sterDataInclusaoSinal;
    }

    public Date getSterDataExclusaoSinal() {
        return sterDataExclusaoSinal;
    }

    public void setSterDataExclusaoSinal(Date sterDataExclusaoSinal) {
        this.sterDataExclusaoSinal = sterDataExclusaoSinal;
    }

    public TermTerminal getTermTerminal() {
        return termTerminal;
    }

    public void setTermTerminal(TermTerminal termTerminal) {
        this.termTerminal = termTerminal;
    }

    public GrisGerenciadoraRisco getGrisGerenciadoraRisco() {
        return grisGerenciadoraRisco;
    }

    public void setGrisGerenciadoraRisco(GrisGerenciadoraRisco grisGerenciadoraRisco) {
        this.grisGerenciadoraRisco = grisGerenciadoraRisco;
    }

    public GrisGerenciadoraRisco getGrisGerenciadoraRisco1() {
        return grisGerenciadoraRisco1;
    }

    public void setGrisGerenciadoraRisco1(GrisGerenciadoraRisco grisGerenciadoraRisco1) {
        this.grisGerenciadoraRisco1 = grisGerenciadoraRisco1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sterCodigo != null ? sterCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SterSinalTerminal)) {
            return false;
        }
        SterSinalTerminal other = (SterSinalTerminal) object;
        if ((this.sterCodigo == null && other.sterCodigo != null) || (this.sterCodigo != null && !this.sterCodigo.equals(other.sterCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.SterSinalTerminal[sterCodigo=" + sterCodigo + "]";
    }

}
