/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Set;
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
 * @author emerson
 */
@Entity
@Table(name = "pess_pessoa")
@NamedQueries({
    @NamedQuery(name = "PessPessoa.findAll", query = "SELECT p FROM PessPessoa p")})
public class PessPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pess_oras_codigo")
    private Integer pessOrasCodigo;
    @Column(name = "pess_nome")
    private String pessNome;
    @Column(name = "pess_numero")
    private String pessNumero;
    @Column(name = "pess_complemento")
    private String pessComplemento;
    @Column(name = "pess_tipo")
    private String pessTipo;
    @OneToMany(mappedBy = "pessPessoa")
    private Set<VeicVeiculo> veicVeiculoSet;
    @OneToMany(mappedBy = "pessPessoa")
    private Set<UsuaUsuario> usuaUsuarioSet;
    @OneToMany(mappedBy = "pessPessoa")
    private Set<RefeReferencia> refeReferenciaSet;
    @OneToMany(mappedBy = "pessPessoa")
    private Set<CrefClasseReferencia> crefClasseReferenciaSet;
    @JoinColumn(name = "pess_oras_codigo", referencedColumnName = "oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrasObjetoRastreado orasObjetoRastreado;
    @JoinColumn(name = "pess_logr_codigo", referencedColumnName = "logr_codigo")
    @ManyToOne
    private LogrLogradouro logrLogradouro;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessPessoa")
    private TranTransportador tranTransportador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessPessoa")
    private PjurPessoaJuridica pjurPessoaJuridica;
    @OneToMany(mappedBy = "pessPessoa")
    private Set<RotaRota> rotaRotaSet;
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

    public Set<VeicVeiculo> getVeicVeiculoSet() {
        return veicVeiculoSet;
    }

    public void setVeicVeiculoSet(Set<VeicVeiculo> veicVeiculoSet) {
        this.veicVeiculoSet = veicVeiculoSet;
    }

    public Set<UsuaUsuario> getUsuaUsuarioSet() {
        return usuaUsuarioSet;
    }

    public void setUsuaUsuarioSet(Set<UsuaUsuario> usuaUsuarioSet) {
        this.usuaUsuarioSet = usuaUsuarioSet;
    }

    public Set<RefeReferencia> getRefeReferenciaSet() {
        return refeReferenciaSet;
    }

    public void setRefeReferenciaSet(Set<RefeReferencia> refeReferenciaSet) {
        this.refeReferenciaSet = refeReferenciaSet;
    }

    public Set<CrefClasseReferencia> getCrefClasseReferenciaSet() {
        return crefClasseReferenciaSet;
    }

    public void setCrefClasseReferenciaSet(Set<CrefClasseReferencia> crefClasseReferenciaSet) {
        this.crefClasseReferenciaSet = crefClasseReferenciaSet;
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

    public TranTransportador getTranTransportador() {
        return tranTransportador;
    }

    public void setTranTransportador(TranTransportador tranTransportador) {
        this.tranTransportador = tranTransportador;
    }

    public PjurPessoaJuridica getPjurPessoaJuridica() {
        return pjurPessoaJuridica;
    }

    public void setPjurPessoaJuridica(PjurPessoaJuridica pjurPessoaJuridica) {
        this.pjurPessoaJuridica = pjurPessoaJuridica;
    }

    public Set<RotaRota> getRotaRotaSet() {
        return rotaRotaSet;
    }

    public void setRotaRotaSet(Set<RotaRota> rotaRotaSet) {
        this.rotaRotaSet = rotaRotaSet;
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
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PessPessoa[pessOrasCodigo=" + pessOrasCodigo + "]";
    }

}
