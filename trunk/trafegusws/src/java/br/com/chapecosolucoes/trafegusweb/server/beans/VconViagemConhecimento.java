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
@Table(name = "vcon_viagem_conhecimento")
@NamedQueries({
    @NamedQuery(name = "VconViagemConhecimento.findAll", query = "SELECT v FROM VconViagemConhecimento v")})
public class VconViagemConhecimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vcon_codigo")
    private Integer vconCodigo;
    @Column(name = "vcon_numero")
    private String vconNumero;
    @Column(name = "vcon_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vconDataCadastro;
    @Column(name = "vcon_codigo_gr")
    private Integer vconCodigoGr;
    @Column(name = "vcon_importado")
    private Character vconImportado;
    @JoinColumn(name = "vcon_vloc_codigo", referencedColumnName = "vloc_codigo")
    @ManyToOne
    private VlocViagemLocal vlocViagemLocal;
    @JoinColumn(name = "vcon_viag_codigo", referencedColumnName = "viag_codigo")
    @ManyToOne
    private ViagViagem viagViagem;
    @OneToMany(mappedBy = "vconViagemConhecimento")
    private Set<VnfiViagemNotaFiscal> vnfiViagemNotaFiscalSet;

    public VconViagemConhecimento() {
    }

    public VconViagemConhecimento(Integer vconCodigo) {
        this.vconCodigo = vconCodigo;
    }

    public Integer getVconCodigo() {
        return vconCodigo;
    }

    public void setVconCodigo(Integer vconCodigo) {
        this.vconCodigo = vconCodigo;
    }

    public String getVconNumero() {
        return vconNumero;
    }

    public void setVconNumero(String vconNumero) {
        this.vconNumero = vconNumero;
    }

    public Date getVconDataCadastro() {
        return vconDataCadastro;
    }

    public void setVconDataCadastro(Date vconDataCadastro) {
        this.vconDataCadastro = vconDataCadastro;
    }

    public Integer getVconCodigoGr() {
        return vconCodigoGr;
    }

    public void setVconCodigoGr(Integer vconCodigoGr) {
        this.vconCodigoGr = vconCodigoGr;
    }

    public Character getVconImportado() {
        return vconImportado;
    }

    public void setVconImportado(Character vconImportado) {
        this.vconImportado = vconImportado;
    }

    public VlocViagemLocal getVlocViagemLocal() {
        return vlocViagemLocal;
    }

    public void setVlocViagemLocal(VlocViagemLocal vlocViagemLocal) {
        this.vlocViagemLocal = vlocViagemLocal;
    }

    public ViagViagem getViagViagem() {
        return viagViagem;
    }

    public void setViagViagem(ViagViagem viagViagem) {
        this.viagViagem = viagViagem;
    }

    public Set<VnfiViagemNotaFiscal> getVnfiViagemNotaFiscalSet() {
        return vnfiViagemNotaFiscalSet;
    }

    public void setVnfiViagemNotaFiscalSet(Set<VnfiViagemNotaFiscal> vnfiViagemNotaFiscalSet) {
        this.vnfiViagemNotaFiscalSet = vnfiViagemNotaFiscalSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vconCodigo != null ? vconCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VconViagemConhecimento)) {
            return false;
        }
        VconViagemConhecimento other = (VconViagemConhecimento) object;
        if ((this.vconCodigo == null && other.vconCodigo != null) || (this.vconCodigo != null && !this.vconCodigo.equals(other.vconCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VconViagemConhecimento[vconCodigo=" + vconCodigo + "]";
    }

}
