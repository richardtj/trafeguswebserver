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
@Table(name = "vnfi_viagem_nota_fiscal", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VnfiViagemNotaFiscal.findAll", query = "SELECT v FROM VnfiViagemNotaFiscal v"),
    @NamedQuery(name = "VnfiViagemNotaFiscal.findByVnfiCodigo", query = "SELECT v FROM VnfiViagemNotaFiscal v WHERE v.vnfiCodigo = :vnfiCodigo"),
    @NamedQuery(name = "VnfiViagemNotaFiscal.findByVnfiNumero", query = "SELECT v FROM VnfiViagemNotaFiscal v WHERE v.vnfiNumero = :vnfiNumero"),
    @NamedQuery(name = "VnfiViagemNotaFiscal.findByVnfiValor", query = "SELECT v FROM VnfiViagemNotaFiscal v WHERE v.vnfiValor = :vnfiValor"),
    @NamedQuery(name = "VnfiViagemNotaFiscal.findByVnfiDataCadastro", query = "SELECT v FROM VnfiViagemNotaFiscal v WHERE v.vnfiDataCadastro = :vnfiDataCadastro"),
    @NamedQuery(name = "VnfiViagemNotaFiscal.findByVnfiCodigoGr", query = "SELECT v FROM VnfiViagemNotaFiscal v WHERE v.vnfiCodigoGr = :vnfiCodigoGr"),
    @NamedQuery(name = "VnfiViagemNotaFiscal.findByVnfiImportado", query = "SELECT v FROM VnfiViagemNotaFiscal v WHERE v.vnfiImportado = :vnfiImportado")})
public class VnfiViagemNotaFiscal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vnfi_codigo", nullable = false)
    private Integer vnfiCodigo;
    @Column(name = "vnfi_numero", length = 20)
    private String vnfiNumero;
    @Column(name = "vnfi_valor", precision = 15, scale = 2)
    private BigDecimal vnfiValor;
    @Column(name = "vnfi_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vnfiDataCadastro;
    @Column(name = "vnfi_codigo_gr")
    private Integer vnfiCodigoGr;
    @Column(name = "vnfi_importado")
    private Character vnfiImportado;
    @OneToMany(mappedBy = "vnfiViagemNotaFiscal", fetch = FetchType.EAGER)
    private List<VproViagemProduto> vproViagemProdutoList;
    @JoinColumn(name = "vnfi_vloc_codigo", referencedColumnName = "vloc_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private VlocViagemLocal vlocViagemLocal;
    @JoinColumn(name = "vnfi_vcon_codigo", referencedColumnName = "vcon_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private VconViagemConhecimento vconViagemConhecimento;

    public VnfiViagemNotaFiscal() {
    }

    public VnfiViagemNotaFiscal(Integer vnfiCodigo) {
        this.vnfiCodigo = vnfiCodigo;
    }

    public Integer getVnfiCodigo() {
        return vnfiCodigo;
    }

    public void setVnfiCodigo(Integer vnfiCodigo) {
        this.vnfiCodigo = vnfiCodigo;
    }

    public String getVnfiNumero() {
        return vnfiNumero;
    }

    public void setVnfiNumero(String vnfiNumero) {
        this.vnfiNumero = vnfiNumero;
    }

    public BigDecimal getVnfiValor() {
        return vnfiValor;
    }

    public void setVnfiValor(BigDecimal vnfiValor) {
        this.vnfiValor = vnfiValor;
    }

    public Date getVnfiDataCadastro() {
        return vnfiDataCadastro;
    }

    public void setVnfiDataCadastro(Date vnfiDataCadastro) {
        this.vnfiDataCadastro = vnfiDataCadastro;
    }

    public Integer getVnfiCodigoGr() {
        return vnfiCodigoGr;
    }

    public void setVnfiCodigoGr(Integer vnfiCodigoGr) {
        this.vnfiCodigoGr = vnfiCodigoGr;
    }

    public Character getVnfiImportado() {
        return vnfiImportado;
    }

    public void setVnfiImportado(Character vnfiImportado) {
        this.vnfiImportado = vnfiImportado;
    }

    public List<VproViagemProduto> getVproViagemProdutoList() {
        return vproViagemProdutoList;
    }

    public void setVproViagemProdutoList(List<VproViagemProduto> vproViagemProdutoList) {
        this.vproViagemProdutoList = vproViagemProdutoList;
    }

    public VlocViagemLocal getVlocViagemLocal() {
        return vlocViagemLocal;
    }

    public void setVlocViagemLocal(VlocViagemLocal vlocViagemLocal) {
        this.vlocViagemLocal = vlocViagemLocal;
    }

    public VconViagemConhecimento getVconViagemConhecimento() {
        return vconViagemConhecimento;
    }

    public void setVconViagemConhecimento(VconViagemConhecimento vconViagemConhecimento) {
        this.vconViagemConhecimento = vconViagemConhecimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vnfiCodigo != null ? vnfiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VnfiViagemNotaFiscal)) {
            return false;
        }
        VnfiViagemNotaFiscal other = (VnfiViagemNotaFiscal) object;
        if ((this.vnfiCodigo == null && other.vnfiCodigo != null) || (this.vnfiCodigo != null && !this.vnfiCodigo.equals(other.vnfiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.VnfiViagemNotaFiscal[vnfiCodigo=" + vnfiCodigo + "]";
    }

}
