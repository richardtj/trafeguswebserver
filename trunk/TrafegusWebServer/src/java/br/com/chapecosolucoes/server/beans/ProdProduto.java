/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
@Table(name = "prod_produto", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ProdProduto.findAll", query = "SELECT p FROM ProdProduto p"),
    @NamedQuery(name = "ProdProduto.findByProdCodigo", query = "SELECT p FROM ProdProduto p WHERE p.prodCodigo = :prodCodigo"),
    @NamedQuery(name = "ProdProduto.findByProdDescricao", query = "SELECT p FROM ProdProduto p WHERE p.prodDescricao = :prodDescricao"),
    @NamedQuery(name = "ProdProduto.findByProdValorUnitario", query = "SELECT p FROM ProdProduto p WHERE p.prodValorUnitario = :prodValorUnitario"),
    @NamedQuery(name = "ProdProduto.findByProdDataCadastro", query = "SELECT p FROM ProdProduto p WHERE p.prodDataCadastro = :prodDataCadastro"),
    @NamedQuery(name = "ProdProduto.findByProdCodigoGr", query = "SELECT p FROM ProdProduto p WHERE p.prodCodigoGr = :prodCodigoGr"),
    @NamedQuery(name = "ProdProduto.findByProdImportado", query = "SELECT p FROM ProdProduto p WHERE p.prodImportado = :prodImportado")})
public class ProdProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prod_codigo", nullable = false)
    private Integer prodCodigo;
    @Column(name = "prod_descricao", length = 50)
    private String prodDescricao;
    @Column(name = "prod_valor_unitario", precision = 15, scale = 2)
    private BigDecimal prodValorUnitario;
    @Column(name = "prod_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prodDataCadastro;
    @Column(name = "prod_codigo_gr")
    private Integer prodCodigoGr;
    @Column(name = "prod_importado")
    private Character prodImportado;
    @JoinColumn(name = "prod_tpro_codigo", referencedColumnName = "tpro_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TproProduto tproProduto;
    @OneToMany(mappedBy = "prodProduto", fetch = FetchType.EAGER)
    private List<VproViagemProduto> vproViagemProdutoList;

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

    public TproProduto getTproProduto() {
        return tproProduto;
    }

    public void setTproProduto(TproProduto tproProduto) {
        this.tproProduto = tproProduto;
    }

    public List<VproViagemProduto> getVproViagemProdutoList() {
        return vproViagemProdutoList;
    }

    public void setVproViagemProdutoList(List<VproViagemProduto> vproViagemProdutoList) {
        this.vproViagemProdutoList = vproViagemProdutoList;
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
        return "br.com.chapecosolucoes.server.beans.ProdProduto[prodCodigo=" + prodCodigo + "]";
    }

}
