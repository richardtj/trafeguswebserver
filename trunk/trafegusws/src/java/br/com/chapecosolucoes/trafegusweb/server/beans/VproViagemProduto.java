/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "vpro_viagem_produto", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VproViagemProduto.findAll", query = "SELECT v FROM VproViagemProduto v"),
    @NamedQuery(name = "VproViagemProduto.findByVproCodigo", query = "SELECT v FROM VproViagemProduto v WHERE v.vproCodigo = :vproCodigo"),
    @NamedQuery(name = "VproViagemProduto.findByVproQuantidade", query = "SELECT v FROM VproViagemProduto v WHERE v.vproQuantidade = :vproQuantidade"),
    @NamedQuery(name = "VproViagemProduto.findByVproValorUnitario", query = "SELECT v FROM VproViagemProduto v WHERE v.vproValorUnitario = :vproValorUnitario"),
    @NamedQuery(name = "VproViagemProduto.findByVproDataCadastro", query = "SELECT v FROM VproViagemProduto v WHERE v.vproDataCadastro = :vproDataCadastro"),
    @NamedQuery(name = "VproViagemProduto.findByVproCodigoGr", query = "SELECT v FROM VproViagemProduto v WHERE v.vproCodigoGr = :vproCodigoGr"),
    @NamedQuery(name = "VproViagemProduto.findByVproImportado", query = "SELECT v FROM VproViagemProduto v WHERE v.vproImportado = :vproImportado")})
public class VproViagemProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vpro_codigo", nullable = false)
    private Integer vproCodigo;
    @Column(name = "vpro_quantidade")
    private Integer vproQuantidade;
    @Column(name = "vpro_valor_unitario", precision = 15, scale = 2)
    private BigDecimal vproValorUnitario;
    @Column(name = "vpro_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vproDataCadastro;
    @Column(name = "vpro_codigo_gr")
    private Integer vproCodigoGr;
    @Column(name = "vpro_importado")
    private Character vproImportado;
    @JoinColumn(name = "vpro_vnfi_codigo", referencedColumnName = "vnfi_codigo")
    @ManyToOne
    private VnfiViagemNotaFiscal vnfiViagemNotaFiscal;
    @JoinColumn(name = "vpro_prod_codigo", referencedColumnName = "prod_codigo")
    @ManyToOne
    private ProdProduto prodProduto;

    public VproViagemProduto() {
    }

    public VproViagemProduto(Integer vproCodigo) {
        this.vproCodigo = vproCodigo;
    }

    public Integer getVproCodigo() {
        return vproCodigo;
    }

    public void setVproCodigo(Integer vproCodigo) {
        this.vproCodigo = vproCodigo;
    }

    public Integer getVproQuantidade() {
        return vproQuantidade;
    }

    public void setVproQuantidade(Integer vproQuantidade) {
        this.vproQuantidade = vproQuantidade;
    }

    public BigDecimal getVproValorUnitario() {
        return vproValorUnitario;
    }

    public void setVproValorUnitario(BigDecimal vproValorUnitario) {
        this.vproValorUnitario = vproValorUnitario;
    }

    public Date getVproDataCadastro() {
        return vproDataCadastro;
    }

    public void setVproDataCadastro(Date vproDataCadastro) {
        this.vproDataCadastro = vproDataCadastro;
    }

    public Integer getVproCodigoGr() {
        return vproCodigoGr;
    }

    public void setVproCodigoGr(Integer vproCodigoGr) {
        this.vproCodigoGr = vproCodigoGr;
    }

    public Character getVproImportado() {
        return vproImportado;
    }

    public void setVproImportado(Character vproImportado) {
        this.vproImportado = vproImportado;
    }

    public VnfiViagemNotaFiscal getVnfiViagemNotaFiscal() {
        return vnfiViagemNotaFiscal;
    }

    public void setVnfiViagemNotaFiscal(VnfiViagemNotaFiscal vnfiViagemNotaFiscal) {
        this.vnfiViagemNotaFiscal = vnfiViagemNotaFiscal;
    }

    public ProdProduto getProdProduto() {
        return prodProduto;
    }

    public void setProdProduto(ProdProduto prodProduto) {
        this.prodProduto = prodProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vproCodigo != null ? vproCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VproViagemProduto)) {
            return false;
        }
        VproViagemProduto other = (VproViagemProduto) object;
        if ((this.vproCodigo == null && other.vproCodigo != null) || (this.vproCodigo != null && !this.vproCodigo.equals(other.vproCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VproViagemProduto[vproCodigo=" + vproCodigo + "]";
    }

}
