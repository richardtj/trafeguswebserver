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
@Table(name = "cida_cidade")
@NamedQueries({
    @NamedQuery(name = "CidaCidade.findAll", query = "SELECT c FROM CidaCidade c"),
    @NamedQuery(name = "CidaCidade.findByCidaCodigo", query = "SELECT c FROM CidaCidade c WHERE c.cidaCodigo = :cidaCodigo"),
    @NamedQuery(name = "CidaCidade.findByCidaDescricao", query = "SELECT c FROM CidaCidade c WHERE c.cidaDescricao = :cidaDescricao"),
    @NamedQuery(name = "CidaCidade.findByCidaCepGenerico", query = "SELECT c FROM CidaCidade c WHERE c.cidaCepGenerico = :cidaCepGenerico"),
    @NamedQuery(name = "CidaCidade.findByCidaDataCadastro", query = "SELECT c FROM CidaCidade c WHERE c.cidaDataCadastro = :cidaDataCadastro"),
    @NamedQuery(name = "CidaCidade.findByCidaCodigoGr", query = "SELECT c FROM CidaCidade c WHERE c.cidaCodigoGr = :cidaCodigoGr"),
    @NamedQuery(name = "CidaCidade.findByCidaImportado", query = "SELECT c FROM CidaCidade c WHERE c.cidaImportado = :cidaImportado")})
public class CidaCidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cida_codigo")
    private Integer cidaCodigo;
    @Column(name = "cida_descricao")
    private String cidaDescricao;
    @Column(name = "cida_cep_generico")
    private String cidaCepGenerico;
    @Column(name = "cida_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cidaDataCadastro;
    @Column(name = "cida_codigo_gr")
    private Integer cidaCodigoGr;
    @Column(name = "cida_importado")
    private Character cidaImportado;
    @OneToMany(mappedBy = "cidaCidade", fetch = FetchType.LAZY)
    private Collection<VeicVeiculo> veicVeiculoCollection;
    @JoinColumn(name = "cida_esta_codigo", referencedColumnName = "esta_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstaEstado estaEstado;
    @OneToMany(mappedBy = "cidaCidade", fetch = FetchType.LAZY)
    private Collection<RefeReferencia> refeReferenciaCollection;
    @OneToMany(mappedBy = "cidaCidade", fetch = FetchType.LAZY)
    private Collection<BairBairro> bairBairroCollection;

    public CidaCidade() {
    }

    public CidaCidade(Integer cidaCodigo) {
        this.cidaCodigo = cidaCodigo;
    }

    public Integer getCidaCodigo() {
        return cidaCodigo;
    }

    public void setCidaCodigo(Integer cidaCodigo) {
        this.cidaCodigo = cidaCodigo;
    }

    public String getCidaDescricao() {
        return cidaDescricao;
    }

    public void setCidaDescricao(String cidaDescricao) {
        this.cidaDescricao = cidaDescricao;
    }

    public String getCidaCepGenerico() {
        return cidaCepGenerico;
    }

    public void setCidaCepGenerico(String cidaCepGenerico) {
        this.cidaCepGenerico = cidaCepGenerico;
    }

    public Date getCidaDataCadastro() {
        return cidaDataCadastro;
    }

    public void setCidaDataCadastro(Date cidaDataCadastro) {
        this.cidaDataCadastro = cidaDataCadastro;
    }

    public Integer getCidaCodigoGr() {
        return cidaCodigoGr;
    }

    public void setCidaCodigoGr(Integer cidaCodigoGr) {
        this.cidaCodigoGr = cidaCodigoGr;
    }

    public Character getCidaImportado() {
        return cidaImportado;
    }

    public void setCidaImportado(Character cidaImportado) {
        this.cidaImportado = cidaImportado;
    }

    public Collection<VeicVeiculo> getVeicVeiculoCollection() {
        return veicVeiculoCollection;
    }

    public void setVeicVeiculoCollection(Collection<VeicVeiculo> veicVeiculoCollection) {
        this.veicVeiculoCollection = veicVeiculoCollection;
    }

    public EstaEstado getEstaEstado() {
        return estaEstado;
    }

    public void setEstaEstado(EstaEstado estaEstado) {
        this.estaEstado = estaEstado;
    }

    public Collection<RefeReferencia> getRefeReferenciaCollection() {
        return refeReferenciaCollection;
    }

    public void setRefeReferenciaCollection(Collection<RefeReferencia> refeReferenciaCollection) {
        this.refeReferenciaCollection = refeReferenciaCollection;
    }

    public Collection<BairBairro> getBairBairroCollection() {
        return bairBairroCollection;
    }

    public void setBairBairroCollection(Collection<BairBairro> bairBairroCollection) {
        this.bairBairroCollection = bairBairroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidaCodigo != null ? cidaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CidaCidade)) {
            return false;
        }
        CidaCidade other = (CidaCidade) object;
        if ((this.cidaCodigo == null && other.cidaCodigo != null) || (this.cidaCodigo != null && !this.cidaCodigo.equals(other.cidaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CidaCidade[cidaCodigo=" + cidaCodigo + "]";
    }

}
