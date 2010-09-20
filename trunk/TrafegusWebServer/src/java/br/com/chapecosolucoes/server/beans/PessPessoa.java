/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "pess_pessoa", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PessPessoa.findAll", query = "SELECT p FROM PessPessoa p"),
    @NamedQuery(name = "PessPessoa.findByPessOrasCodigo", query = "SELECT p FROM PessPessoa p WHERE p.pessOrasCodigo = :pessOrasCodigo"),
    @NamedQuery(name = "PessPessoa.findByPessNome", query = "SELECT p FROM PessPessoa p WHERE p.pessNome = :pessNome"),
    @NamedQuery(name = "PessPessoa.findByPessNumero", query = "SELECT p FROM PessPessoa p WHERE p.pessNumero = :pessNumero"),
    @NamedQuery(name = "PessPessoa.findByPessComplemento", query = "SELECT p FROM PessPessoa p WHERE p.pessComplemento = :pessComplemento"),
    @NamedQuery(name = "PessPessoa.findByPessTipo", query = "SELECT p FROM PessPessoa p WHERE p.pessTipo = :pessTipo")})
public class PessPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pess_oras_codigo", nullable = false)
    private Integer pessOrasCodigo;
    @Column(name = "pess_nome", length = 50)
    private String pessNome;
    @Column(name = "pess_numero", length = 10)
    private String pessNumero;
    @Column(name = "pess_complemento", length = 50)
    private String pessComplemento;
    @Column(name = "pess_tipo", length = 10)
    private String pessTipo;
    @OneToMany(mappedBy = "pessPessoa")
    private List<UsuaUsuario> usuaUsuarioList;
    @JoinColumn(name = "pess_oras_codigo", referencedColumnName = "oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrasObjetoRastreado orasObjetoRastreado;
    @JoinColumn(name = "pess_logr_codigo", referencedColumnName = "logr_codigo")
    @ManyToOne
    private LogrLogradouro logrLogradouro;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessPessoa")
    private PfisPessoaFisica pfisPessoaFisica;

    public PessPessoa() {
    }

    public PessPessoa(Integer pessOrasCodigo) {
        this.pessOrasCodigo = pessOrasCodigo;
    }

    public Integer getPessOrasCodigo() {
        return pessOrasCodigo;
    }

    public void setPessOrasCodigo(Integer pessOrasCodigo) {
        this.pessOrasCodigo = pessOrasCodigo;
    }

    public String getPessNome() {
        return pessNome;
    }

    public void setPessNome(String pessNome) {
        this.pessNome = pessNome;
    }

    public String getPessNumero() {
        return pessNumero;
    }

    public void setPessNumero(String pessNumero) {
        this.pessNumero = pessNumero;
    }

    public String getPessComplemento() {
        return pessComplemento;
    }

    public void setPessComplemento(String pessComplemento) {
        this.pessComplemento = pessComplemento;
    }

    public String getPessTipo() {
        return pessTipo;
    }

    public void setPessTipo(String pessTipo) {
        this.pessTipo = pessTipo;
    }

    public List<UsuaUsuario> getUsuaUsuarioList() {
        return usuaUsuarioList;
    }

    public void setUsuaUsuarioList(List<UsuaUsuario> usuaUsuarioList) {
        this.usuaUsuarioList = usuaUsuarioList;
    }

    public OrasObjetoRastreado getOrasObjetoRastreado() {
        return orasObjetoRastreado;
    }

    public void setOrasObjetoRastreado(OrasObjetoRastreado orasObjetoRastreado) {
        this.orasObjetoRastreado = orasObjetoRastreado;
    }

    public LogrLogradouro getLogrLogradouro() {
        return logrLogradouro;
    }

    public void setLogrLogradouro(LogrLogradouro logrLogradouro) {
        this.logrLogradouro = logrLogradouro;
    }

    public PfisPessoaFisica getPfisPessoaFisica() {
        return pfisPessoaFisica;
    }

    public void setPfisPessoaFisica(PfisPessoaFisica pfisPessoaFisica) {
        this.pfisPessoaFisica = pfisPessoaFisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessOrasCodigo != null ? pessOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessPessoa)) {
            return false;
        }
        PessPessoa other = (PessPessoa) object;
        if ((this.pessOrasCodigo == null && other.pessOrasCodigo != null) || (this.pessOrasCodigo != null && !this.pessOrasCodigo.equals(other.pessOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PessPessoa[pessOrasCodigo=" + pessOrasCodigo + "]";
    }

}
