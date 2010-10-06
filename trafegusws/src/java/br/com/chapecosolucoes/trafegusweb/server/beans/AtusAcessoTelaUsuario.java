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
@Table(name = "atus_acesso_tela_usuario")
@NamedQueries({
    @NamedQuery(name = "AtusAcessoTelaUsuario.findAll", query = "SELECT a FROM AtusAcessoTelaUsuario a"),
    @NamedQuery(name = "AtusAcessoTelaUsuario.findByAtusCodigo", query = "SELECT a FROM AtusAcessoTelaUsuario a WHERE a.atusCodigo = :atusCodigo"),
    @NamedQuery(name = "AtusAcessoTelaUsuario.findByAtusNomeJanela", query = "SELECT a FROM AtusAcessoTelaUsuario a WHERE a.atusNomeJanela = :atusNomeJanela"),
    @NamedQuery(name = "AtusAcessoTelaUsuario.findByAtusNomeClasse", query = "SELECT a FROM AtusAcessoTelaUsuario a WHERE a.atusNomeClasse = :atusNomeClasse"),
    @NamedQuery(name = "AtusAcessoTelaUsuario.findByAtusDataCadastro", query = "SELECT a FROM AtusAcessoTelaUsuario a WHERE a.atusDataCadastro = :atusDataCadastro")})
public class AtusAcessoTelaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "atus_codigo")
    private Integer atusCodigo;
    @Column(name = "atus_nome_janela")
    private String atusNomeJanela;
    @Column(name = "atus_nome_classe")
    private String atusNomeClasse;
    @Column(name = "atus_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atusDataCadastro;
    @JoinColumn(name = "atus_uaus_codigo", referencedColumnName = "ausu_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private AusuAcessoUsuario ausuAcessoUsuario;

    public AtusAcessoTelaUsuario() {
    }

    public AtusAcessoTelaUsuario(Integer atusCodigo) {
        this.atusCodigo = atusCodigo;
    }

    public Integer getAtusCodigo() {
        return atusCodigo;
    }

    public void setAtusCodigo(Integer atusCodigo) {
        this.atusCodigo = atusCodigo;
    }

    public String getAtusNomeJanela() {
        return atusNomeJanela;
    }

    public void setAtusNomeJanela(String atusNomeJanela) {
        this.atusNomeJanela = atusNomeJanela;
    }

    public String getAtusNomeClasse() {
        return atusNomeClasse;
    }

    public void setAtusNomeClasse(String atusNomeClasse) {
        this.atusNomeClasse = atusNomeClasse;
    }

    public Date getAtusDataCadastro() {
        return atusDataCadastro;
    }

    public void setAtusDataCadastro(Date atusDataCadastro) {
        this.atusDataCadastro = atusDataCadastro;
    }

    public AusuAcessoUsuario getAusuAcessoUsuario() {
        return ausuAcessoUsuario;
    }

    public void setAusuAcessoUsuario(AusuAcessoUsuario ausuAcessoUsuario) {
        this.ausuAcessoUsuario = ausuAcessoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atusCodigo != null ? atusCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtusAcessoTelaUsuario)) {
            return false;
        }
        AtusAcessoTelaUsuario other = (AtusAcessoTelaUsuario) object;
        if ((this.atusCodigo == null && other.atusCodigo != null) || (this.atusCodigo != null && !this.atusCodigo.equals(other.atusCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.AtusAcessoTelaUsuario[atusCodigo=" + atusCodigo + "]";
    }

}
