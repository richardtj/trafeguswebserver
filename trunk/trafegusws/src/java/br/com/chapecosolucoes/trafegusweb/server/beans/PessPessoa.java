/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "pess_pessoa")
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
    @OneToMany(mappedBy = "pessPessoa", fetch = FetchType.EAGER)
    private List<VeicVeiculo> veicVeiculoList;
    @OneToMany(mappedBy = "pessPessoa", fetch = FetchType.EAGER)
    private List<RefeReferencia> refeReferenciaList;
    @JoinColumn(name = "pess_oras_codigo", referencedColumnName = "oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private OrasObjetoRastreado orasObjetoRastreado;
    @JoinColumn(name = "pess_logr_codigo", referencedColumnName = "logr_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private LogrLogradouro logrLogradouro;
    @OneToMany(mappedBy = "pessPessoa", fetch = FetchType.EAGER)
    private List<PconPessoaContato> pconPessoaContatoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessPessoa", fetch = FetchType.EAGER)
    private PfisPessoaFisica pfisPessoaFisica;
    @OneToMany(mappedBy = "pessPessoa", fetch = FetchType.EAGER)
    private List<UsuaUsuario> usuaUsuarioList;
    @OneToMany(mappedBy = "pessPessoa", fetch = FetchType.EAGER)
    private List<CrefClasseReferencia> crefClasseReferenciaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessPessoa", fetch = FetchType.EAGER)
    private TranTransportador tranTransportador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessPessoa", fetch = FetchType.EAGER)
    private PjurPessoaJuridica pjurPessoaJuridica;
    @OneToMany(mappedBy = "pessPessoa", fetch = FetchType.EAGER)
    private List<RotaRota> rotaRotaList;

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

    public List<VeicVeiculo> getVeicVeiculoList() {
        return veicVeiculoList;
    }

    public void setVeicVeiculoList(List<VeicVeiculo> veicVeiculoList) {
        this.veicVeiculoList = veicVeiculoList;
    }

    public List<RefeReferencia> getRefeReferenciaList() {
        return refeReferenciaList;
    }

    public void setRefeReferenciaList(List<RefeReferencia> refeReferenciaList) {
        this.refeReferenciaList = refeReferenciaList;
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

    public List<PconPessoaContato> getPconPessoaContatoList() {
        return pconPessoaContatoList;
    }

    public void setPconPessoaContatoList(List<PconPessoaContato> pconPessoaContatoList) {
        this.pconPessoaContatoList = pconPessoaContatoList;
    }

    public PfisPessoaFisica getPfisPessoaFisica() {
        return pfisPessoaFisica;
    }

    public void setPfisPessoaFisica(PfisPessoaFisica pfisPessoaFisica) {
        this.pfisPessoaFisica = pfisPessoaFisica;
    }

    public List<UsuaUsuario> getUsuaUsuarioList() {
        return usuaUsuarioList;
    }

    public void setUsuaUsuarioList(List<UsuaUsuario> usuaUsuarioList) {
        this.usuaUsuarioList = usuaUsuarioList;
    }

    public List<CrefClasseReferencia> getCrefClasseReferenciaList() {
        return crefClasseReferenciaList;
    }

    public void setCrefClasseReferenciaList(List<CrefClasseReferencia> crefClasseReferenciaList) {
        this.crefClasseReferenciaList = crefClasseReferenciaList;
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

    public List<RotaRota> getRotaRotaList() {
        return rotaRotaList;
    }

    public void setRotaRotaList(List<RotaRota> rotaRotaList) {
        this.rotaRotaList = rotaRotaList;
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
