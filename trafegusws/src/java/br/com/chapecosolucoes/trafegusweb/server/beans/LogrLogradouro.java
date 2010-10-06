/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "logr_logradouro")
@NamedQueries({
    @NamedQuery(name = "LogrLogradouro.findAll", query = "SELECT l FROM LogrLogradouro l"),
    @NamedQuery(name = "LogrLogradouro.findByLogrCodigo", query = "SELECT l FROM LogrLogradouro l WHERE l.logrCodigo = :logrCodigo"),
    @NamedQuery(name = "LogrLogradouro.findByLogrTipoLogradouro", query = "SELECT l FROM LogrLogradouro l WHERE l.logrTipoLogradouro = :logrTipoLogradouro"),
    @NamedQuery(name = "LogrLogradouro.findByLogrDescricao", query = "SELECT l FROM LogrLogradouro l WHERE l.logrDescricao = :logrDescricao"),
    @NamedQuery(name = "LogrLogradouro.findByLogrComplemento", query = "SELECT l FROM LogrLogradouro l WHERE l.logrComplemento = :logrComplemento"),
    @NamedQuery(name = "LogrLogradouro.findByLogrCep", query = "SELECT l FROM LogrLogradouro l WHERE l.logrCep = :logrCep"),
    @NamedQuery(name = "LogrLogradouro.findByLogrCidaCodigo", query = "SELECT l FROM LogrLogradouro l WHERE l.logrCidaCodigo = :logrCidaCodigo"),
    @NamedQuery(name = "LogrLogradouro.findByLogrEstaCodigo", query = "SELECT l FROM LogrLogradouro l WHERE l.logrEstaCodigo = :logrEstaCodigo"),
    @NamedQuery(name = "LogrLogradouro.findByLogrDataCadastro", query = "SELECT l FROM LogrLogradouro l WHERE l.logrDataCadastro = :logrDataCadastro"),
    @NamedQuery(name = "LogrLogradouro.findByLogrCodigoGr", query = "SELECT l FROM LogrLogradouro l WHERE l.logrCodigoGr = :logrCodigoGr"),
    @NamedQuery(name = "LogrLogradouro.findByLogrImportado", query = "SELECT l FROM LogrLogradouro l WHERE l.logrImportado = :logrImportado")})
public class LogrLogradouro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "logr_codigo")
    private Integer logrCodigo;
    @Column(name = "logr_tipo_logradouro")
    private String logrTipoLogradouro;
    @Column(name = "logr_descricao")
    private String logrDescricao;
    @Column(name = "logr_complemento")
    private String logrComplemento;
    @Column(name = "logr_cep")
    private String logrCep;
    @Column(name = "logr_cida_codigo")
    private Integer logrCidaCodigo;
    @Column(name = "logr_esta_codigo")
    private Integer logrEstaCodigo;
    @Column(name = "logr_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logrDataCadastro;
    @Column(name = "logr_codigo_gr")
    private Integer logrCodigoGr;
    @Column(name = "logr_importado")
    private Character logrImportado;
    @OneToMany(mappedBy = "logrLogradouro", fetch = FetchType.LAZY)
    private Collection<PessPessoa> pessPessoaCollection;
    @JoinColumn(name = "logr_bair_codigo", referencedColumnName = "bair_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private BairBairro bairBairro;

    public LogrLogradouro() {
    }

    public LogrLogradouro(Integer logrCodigo) {
        this.logrCodigo = logrCodigo;
    }

    public Integer getLogrCodigo() {
        return logrCodigo;
    }

    public void setLogrCodigo(Integer logrCodigo) {
        this.logrCodigo = logrCodigo;
    }

    public String getLogrTipoLogradouro() {
        return logrTipoLogradouro;
    }

    public void setLogrTipoLogradouro(String logrTipoLogradouro) {
        this.logrTipoLogradouro = logrTipoLogradouro;
    }

    public String getLogrDescricao() {
        return logrDescricao;
    }

    public void setLogrDescricao(String logrDescricao) {
        this.logrDescricao = logrDescricao;
    }

    public String getLogrComplemento() {
        return logrComplemento;
    }

    public void setLogrComplemento(String logrComplemento) {
        this.logrComplemento = logrComplemento;
    }

    public String getLogrCep() {
        return logrCep;
    }

    public void setLogrCep(String logrCep) {
        this.logrCep = logrCep;
    }

    public Integer getLogrCidaCodigo() {
        return logrCidaCodigo;
    }

    public void setLogrCidaCodigo(Integer logrCidaCodigo) {
        this.logrCidaCodigo = logrCidaCodigo;
    }

    public Integer getLogrEstaCodigo() {
        return logrEstaCodigo;
    }

    public void setLogrEstaCodigo(Integer logrEstaCodigo) {
        this.logrEstaCodigo = logrEstaCodigo;
    }

    public Date getLogrDataCadastro() {
        return logrDataCadastro;
    }

    public void setLogrDataCadastro(Date logrDataCadastro) {
        this.logrDataCadastro = logrDataCadastro;
    }

    public Integer getLogrCodigoGr() {
        return logrCodigoGr;
    }

    public void setLogrCodigoGr(Integer logrCodigoGr) {
        this.logrCodigoGr = logrCodigoGr;
    }

    public Character getLogrImportado() {
        return logrImportado;
    }

    public void setLogrImportado(Character logrImportado) {
        this.logrImportado = logrImportado;
    }

    public Collection<PessPessoa> getPessPessoaCollection() {
        return pessPessoaCollection;
    }

    public void setPessPessoaCollection(Collection<PessPessoa> pessPessoaCollection) {
        this.pessPessoaCollection = pessPessoaCollection;
    }

    public BairBairro getBairBairro() {
        return bairBairro;
    }

    public void setBairBairro(BairBairro bairBairro) {
        this.bairBairro = bairBairro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logrCodigo != null ? logrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogrLogradouro)) {
            return false;
        }
        LogrLogradouro other = (LogrLogradouro) object;
        if ((this.logrCodigo == null && other.logrCodigo != null) || (this.logrCodigo != null && !this.logrCodigo.equals(other.logrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.LogrLogradouro[logrCodigo=" + logrCodigo + "]";
    }

}
