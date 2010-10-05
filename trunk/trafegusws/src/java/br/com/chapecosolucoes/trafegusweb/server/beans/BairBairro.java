/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "bair_bairro")
@NamedQueries({
    @NamedQuery(name = "BairBairro.findAll", query = "SELECT b FROM BairBairro b")})
public class BairBairro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bair_codigo")
    private Integer bairCodigo;
    @Column(name = "bair_descricao")
    private String bairDescricao;
    @Column(name = "bair_abreviacao")
    private String bairAbreviacao;
    @Column(name = "bair_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bairDataCadastro;
    @Column(name = "bair_codigo_gr")
    private Integer bairCodigoGr;
    @Column(name = "bair_importado")
    private Character bairImportado;
    @Column(name = "bair_esta_codigo")
    private Integer bairEstaCodigo;
    @JoinColumn(name = "bair_cida_codigo", referencedColumnName = "cida_codigo")
    @ManyToOne
    private CidaCidade cidaCidade;
    @OneToMany(mappedBy = "bairBairro")
    private Set<LogrLogradouro> logrLogradouroSet;

    public BairBairro() {
    }

    public BairBairro(Integer bairCodigo) {
        this.bairCodigo = bairCodigo;
    }

    public Integer getBairCodigo() {
        return bairCodigo;
    }

    public void setBairCodigo(Integer bairCodigo) {
        this.bairCodigo = bairCodigo;
    }

    public String getBairDescricao() {
        return bairDescricao;
    }

    public void setBairDescricao(String bairDescricao) {
        this.bairDescricao = bairDescricao;
    }

    public String getBairAbreviacao() {
        return bairAbreviacao;
    }

    public void setBairAbreviacao(String bairAbreviacao) {
        this.bairAbreviacao = bairAbreviacao;
    }

    public Date getBairDataCadastro() {
        return bairDataCadastro;
    }

    public void setBairDataCadastro(Date bairDataCadastro) {
        this.bairDataCadastro = bairDataCadastro;
    }

    public Integer getBairCodigoGr() {
        return bairCodigoGr;
    }

    public void setBairCodigoGr(Integer bairCodigoGr) {
        this.bairCodigoGr = bairCodigoGr;
    }

    public Character getBairImportado() {
        return bairImportado;
    }

    public void setBairImportado(Character bairImportado) {
        this.bairImportado = bairImportado;
    }

    public Integer getBairEstaCodigo() {
        return bairEstaCodigo;
    }

    public void setBairEstaCodigo(Integer bairEstaCodigo) {
        this.bairEstaCodigo = bairEstaCodigo;
    }

    public CidaCidade getCidaCidade() {
        return cidaCidade;
    }

    public void setCidaCidade(CidaCidade cidaCidade) {
        this.cidaCidade = cidaCidade;
    }

    public Set<LogrLogradouro> getLogrLogradouroSet() {
        return logrLogradouroSet;
    }

    public void setLogrLogradouroSet(Set<LogrLogradouro> logrLogradouroSet) {
        this.logrLogradouroSet = logrLogradouroSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bairCodigo != null ? bairCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BairBairro)) {
            return false;
        }
        BairBairro other = (BairBairro) object;
        if ((this.bairCodigo == null && other.bairCodigo != null) || (this.bairCodigo != null && !this.bairCodigo.equals(other.bairCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.BairBairro[bairCodigo=" + bairCodigo + "]";
    }

}
