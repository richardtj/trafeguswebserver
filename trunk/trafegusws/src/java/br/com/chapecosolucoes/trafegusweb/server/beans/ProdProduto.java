/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "prod_produto")
@NamedQueries({
    @NamedQuery(name = "ProdProduto.findAll", query = "SELECT p FROM ProdProduto p")})
public class ProdProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prod_codigo")
    private Integer prodCodigo;
    @Column(name = "prod_descricao")
    private String prodDescricao;
    @Column(name = "prod_valor_unitario")
    private BigDecimal prodValorUnitario;
    @Column(name = "prod_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prodDataCadastro;
    @Column(name = "prod_codigo_gr")
    private Integer prodCodigoGr;
    @Column(name = "prod_importado")
    private Character prodImportado;
    @OneToMany(mappedBy = "prodProduto")
    private Set<VproViagemProduto> vproViagemProdutoSet;
    @JoinColumn(name = "prod_tpro_codigo", referencedColumnName = "tpro_codigo")
    @ManyToOne
    private TproProduto tproProduto;

    public ProdProduto() {
    }

    public ProdProduto(Integer prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public Integer getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(Integer prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public String getProdDescricao() {
        return prodDescricao;
    }

    public void setProdDescricao(String prodDescricao) {
        this.prodDescricao = prodDescricao;
    }

    public BigDecimal getProdValorUnitario() {
        return prodValorUnitario;
    }

    public void setProdValorUnitario(BigDecimal prodValorUnitario) {
        this.prodValorUnitario = prodValorUnitario;
    }

    public Date getProdDataCadastro() {
        return prodDataCadastro;
    }

    public void setProdDataCadastro(Date prodDataCadastro) {
        this.prodDataCadastro = prodDataCadastro;
    }

    public Integer getProdCodigoGr() {
        return prodCodigoGr;
    }

    public void setProdCodigoGr(Integer prodCodigoGr) {
        this.prodCodigoGr = prodCodigoGr;
    }

    public Character getProdImportado() {
        return prodImportado;
    }

    public void setProdImportado(Character prodImportado) {
        this.prodImportado = prodImportado;
    }

    public Set<VproViagemProduto> getVproViagemProdutoSet() {
        return vproViagemProdutoSet;
    }

    public void setVproViagemProdutoSet(Set<VproViagemProduto> vproViagemProdutoSet) {
        this.vproViagemProdutoSet = vproViagemProdutoSet;
    }

    public TproProduto getTproProduto() {
        return tproProduto;
    }

    public void setTproProduto(TproProduto tproProduto) {
        this.tproProduto = tproProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodCodigo != null ? prodCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdProduto)) {
            return false;
        }
        ProdProduto other = (ProdProduto) object;
        if ((this.prodCodigo == null && other.prodCodigo != null) || (this.prodCodigo != null && !this.prodCodigo.equals(other.prodCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.ProdProduto[prodCodigo=" + prodCodigo + "]";
    }

}
