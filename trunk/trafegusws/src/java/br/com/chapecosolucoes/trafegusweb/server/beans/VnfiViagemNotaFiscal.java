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
@Table(name = "vnfi_viagem_nota_fiscal")
@NamedQueries({
    @NamedQuery(name = "VnfiViagemNotaFiscal.findAll", query = "SELECT v FROM VnfiViagemNotaFiscal v")})
public class VnfiViagemNotaFiscal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vnfi_codigo")
    private Integer vnfiCodigo;
    @Column(name = "vnfi_numero")
    private String vnfiNumero;
    @Column(name = "vnfi_valor")
    private BigDecimal vnfiValor;
    @Column(name = "vnfi_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vnfiDataCadastro;
    @Column(name = "vnfi_codigo_gr")
    private Integer vnfiCodigoGr;
    @Column(name = "vnfi_importado")
    private Character vnfiImportado;
    @OneToMany(mappedBy = "vnfiViagemNotaFiscal")
    private Set<VproViagemProduto> vproViagemProdutoSet;
    @JoinColumn(name = "vnfi_vloc_codigo", referencedColumnName = "vloc_codigo")
    @ManyToOne
    private VlocViagemLocal vlocViagemLocal;
    @JoinColumn(name = "vnfi_vcon_codigo", referencedColumnName = "vcon_codigo")
    @ManyToOne
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

    public Set<VproViagemProduto> getVproViagemProdutoSet() {
        return vproViagemProdutoSet;
    }

    public void setVproViagemProdutoSet(Set<VproViagemProduto> vproViagemProdutoSet) {
        this.vproViagemProdutoSet = vproViagemProdutoSet;
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
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VnfiViagemNotaFiscal[vnfiCodigo=" + vnfiCodigo + "]";
    }

}
