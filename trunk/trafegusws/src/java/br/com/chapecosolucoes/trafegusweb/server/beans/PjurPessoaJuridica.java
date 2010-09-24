/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "pjur_pessoa_juridica", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PjurPessoaJuridica.findAll", query = "SELECT p FROM PjurPessoaJuridica p"),
    @NamedQuery(name = "PjurPessoaJuridica.findByPjurPessOrasCodigo", query = "SELECT p FROM PjurPessoaJuridica p WHERE p.pjurPessOrasCodigo = :pjurPessOrasCodigo"),
    @NamedQuery(name = "PjurPessoaJuridica.findByPjurCnpj", query = "SELECT p FROM PjurPessoaJuridica p WHERE p.pjurCnpj = :pjurCnpj"),
    @NamedQuery(name = "PjurPessoaJuridica.findByPjurRazaoSocial", query = "SELECT p FROM PjurPessoaJuridica p WHERE p.pjurRazaoSocial = :pjurRazaoSocial"),
    @NamedQuery(name = "PjurPessoaJuridica.findByPjurInscricaoEstadual", query = "SELECT p FROM PjurPessoaJuridica p WHERE p.pjurInscricaoEstadual = :pjurInscricaoEstadual"),
    @NamedQuery(name = "PjurPessoaJuridica.findByPjurSite", query = "SELECT p FROM PjurPessoaJuridica p WHERE p.pjurSite = :pjurSite")})
public class PjurPessoaJuridica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pjur_pess_oras_codigo", nullable = false)
    private Integer pjurPessOrasCodigo;
    @Column(name = "pjur_cnpj", length = 30)
    private String pjurCnpj;
    @Column(name = "pjur_razao_social", length = 50)
    private String pjurRazaoSocial;
    @Column(name = "pjur_inscricao_estadual", length = 30)
    private String pjurInscricaoEstadual;
    @Column(name = "pjur_site", length = 50)
    private String pjurSite;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pjurPessoaJuridica")
    private GrisGerenciadoraRisco grisGerenciadoraRisco;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pjurPessoaJuridica")
    private EescEmpresaEscolta eescEmpresaEscolta;
    @JoinColumn(name = "pjur_pess_oras_codigo", referencedColumnName = "pess_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PessPessoa pessPessoa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pjurPessoaJuridica")
    private SeguSeguradora seguSeguradora;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pjurPessoaJuridica")
    private EmbaEmbarcador embaEmbarcador;

    public PjurPessoaJuridica() {
    }

    public PjurPessoaJuridica(Integer pjurPessOrasCodigo) {
        this.pjurPessOrasCodigo = pjurPessOrasCodigo;
    }

    public Integer getPjurPessOrasCodigo() {
        return pjurPessOrasCodigo;
    }

    public void setPjurPessOrasCodigo(Integer pjurPessOrasCodigo) {
        this.pjurPessOrasCodigo = pjurPessOrasCodigo;
    }

    public String getPjurCnpj() {
        return pjurCnpj;
    }

    public void setPjurCnpj(String pjurCnpj) {
        this.pjurCnpj = pjurCnpj;
    }

    public String getPjurRazaoSocial() {
        return pjurRazaoSocial;
    }

    public void setPjurRazaoSocial(String pjurRazaoSocial) {
        this.pjurRazaoSocial = pjurRazaoSocial;
    }

    public String getPjurInscricaoEstadual() {
        return pjurInscricaoEstadual;
    }

    public void setPjurInscricaoEstadual(String pjurInscricaoEstadual) {
        this.pjurInscricaoEstadual = pjurInscricaoEstadual;
    }

    public String getPjurSite() {
        return pjurSite;
    }

    public void setPjurSite(String pjurSite) {
        this.pjurSite = pjurSite;
    }

    public GrisGerenciadoraRisco getGrisGerenciadoraRisco() {
        return grisGerenciadoraRisco;
    }

    public void setGrisGerenciadoraRisco(GrisGerenciadoraRisco grisGerenciadoraRisco) {
        this.grisGerenciadoraRisco = grisGerenciadoraRisco;
    }

    public EescEmpresaEscolta getEescEmpresaEscolta() {
        return eescEmpresaEscolta;
    }

    public void setEescEmpresaEscolta(EescEmpresaEscolta eescEmpresaEscolta) {
        this.eescEmpresaEscolta = eescEmpresaEscolta;
    }

    public PessPessoa getPessPessoa() {
        return pessPessoa;
    }

    public void setPessPessoa(PessPessoa pessPessoa) {
        this.pessPessoa = pessPessoa;
    }

    public SeguSeguradora getSeguSeguradora() {
        return seguSeguradora;
    }

    public void setSeguSeguradora(SeguSeguradora seguSeguradora) {
        this.seguSeguradora = seguSeguradora;
    }

    public EmbaEmbarcador getEmbaEmbarcador() {
        return embaEmbarcador;
    }

    public void setEmbaEmbarcador(EmbaEmbarcador embaEmbarcador) {
        this.embaEmbarcador = embaEmbarcador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pjurPessOrasCodigo != null ? pjurPessOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PjurPessoaJuridica)) {
            return false;
        }
        PjurPessoaJuridica other = (PjurPessoaJuridica) object;
        if ((this.pjurPessOrasCodigo == null && other.pjurPessOrasCodigo != null) || (this.pjurPessOrasCodigo != null && !this.pjurPessOrasCodigo.equals(other.pjurPessOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PjurPessoaJuridica[pjurPessOrasCodigo=" + pjurPessOrasCodigo + "]";
    }

}
