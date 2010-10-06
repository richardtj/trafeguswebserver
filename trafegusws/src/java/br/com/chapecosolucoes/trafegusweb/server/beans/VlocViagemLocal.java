/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "vloc_viagem_local")
@NamedQueries({
    @NamedQuery(name = "VlocViagemLocal.findAll", query = "SELECT v FROM VlocViagemLocal v"),
    @NamedQuery(name = "VlocViagemLocal.findByVlocCodigo", query = "SELECT v FROM VlocViagemLocal v WHERE v.vlocCodigo = :vlocCodigo"),
    @NamedQuery(name = "VlocViagemLocal.findByVlocSequencia", query = "SELECT v FROM VlocViagemLocal v WHERE v.vlocSequencia = :vlocSequencia"),
    @NamedQuery(name = "VlocViagemLocal.findByVlocRaio", query = "SELECT v FROM VlocViagemLocal v WHERE v.vlocRaio = :vlocRaio"),
    @NamedQuery(name = "VlocViagemLocal.findByVlocDataCadastro", query = "SELECT v FROM VlocViagemLocal v WHERE v.vlocDataCadastro = :vlocDataCadastro"),
    @NamedQuery(name = "VlocViagemLocal.findByVlocCodigoGr", query = "SELECT v FROM VlocViagemLocal v WHERE v.vlocCodigoGr = :vlocCodigoGr"),
    @NamedQuery(name = "VlocViagemLocal.findByVlocImportado", query = "SELECT v FROM VlocViagemLocal v WHERE v.vlocImportado = :vlocImportado"),
    @NamedQuery(name = "VlocViagemLocal.findByVlocDescricao", query = "SELECT v FROM VlocViagemLocal v WHERE v.vlocDescricao = :vlocDescricao")})
public class VlocViagemLocal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vloc_codigo")
    private Integer vlocCodigo;
    @Column(name = "vloc_sequencia")
    private Integer vlocSequencia;
    @Column(name = "vloc_raio")
    private BigDecimal vlocRaio;
    @Column(name = "vloc_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vlocDataCadastro;
    @Column(name = "vloc_codigo_gr")
    private Integer vlocCodigoGr;
    @Column(name = "vloc_importado")
    private Character vlocImportado;
    @Column(name = "vloc_descricao")
    private String vlocDescricao;
    @OneToMany(mappedBy = "vlocViagemLocal", fetch = FetchType.LAZY)
    private Collection<VnfiViagemNotaFiscal> vnfiViagemNotaFiscalCollection;
    @OneToMany(mappedBy = "vlocViagemLocal", fetch = FetchType.LAZY)
    private Collection<VlevViagemLocalEvento> vlevViagemLocalEventoCollection;
    @OneToMany(mappedBy = "vlocViagemLocal", fetch = FetchType.LAZY)
    private Collection<VconViagemConhecimento> vconViagemConhecimentoCollection;
    @JoinColumn(name = "vloc_viag_codigo", referencedColumnName = "viag_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private ViagViagem viagViagem;
    @JoinColumn(name = "vloc_tpar_codigo", referencedColumnName = "tpar_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private TparTipoParada tparTipoParada;
    @JoinColumn(name = "vloc_refe_codigo", referencedColumnName = "refe_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private RefeReferencia refeReferencia;

    public VlocViagemLocal() {
    }

    public VlocViagemLocal(Integer vlocCodigo) {
        this.vlocCodigo = vlocCodigo;
    }

    public Integer getVlocCodigo() {
        return vlocCodigo;
    }

    public void setVlocCodigo(Integer vlocCodigo) {
        this.vlocCodigo = vlocCodigo;
    }

    public Integer getVlocSequencia() {
        return vlocSequencia;
    }

    public void setVlocSequencia(Integer vlocSequencia) {
        this.vlocSequencia = vlocSequencia;
    }

    public BigDecimal getVlocRaio() {
        return vlocRaio;
    }

    public void setVlocRaio(BigDecimal vlocRaio) {
        this.vlocRaio = vlocRaio;
    }

    public Date getVlocDataCadastro() {
        return vlocDataCadastro;
    }

    public void setVlocDataCadastro(Date vlocDataCadastro) {
        this.vlocDataCadastro = vlocDataCadastro;
    }

    public Integer getVlocCodigoGr() {
        return vlocCodigoGr;
    }

    public void setVlocCodigoGr(Integer vlocCodigoGr) {
        this.vlocCodigoGr = vlocCodigoGr;
    }

    public Character getVlocImportado() {
        return vlocImportado;
    }

    public void setVlocImportado(Character vlocImportado) {
        this.vlocImportado = vlocImportado;
    }

    public String getVlocDescricao() {
        return vlocDescricao;
    }

    public void setVlocDescricao(String vlocDescricao) {
        this.vlocDescricao = vlocDescricao;
    }

    public Collection<VnfiViagemNotaFiscal> getVnfiViagemNotaFiscalCollection() {
        return vnfiViagemNotaFiscalCollection;
    }

    public void setVnfiViagemNotaFiscalCollection(Collection<VnfiViagemNotaFiscal> vnfiViagemNotaFiscalCollection) {
        this.vnfiViagemNotaFiscalCollection = vnfiViagemNotaFiscalCollection;
    }

    public Collection<VlevViagemLocalEvento> getVlevViagemLocalEventoCollection() {
        return vlevViagemLocalEventoCollection;
    }

    public void setVlevViagemLocalEventoCollection(Collection<VlevViagemLocalEvento> vlevViagemLocalEventoCollection) {
        this.vlevViagemLocalEventoCollection = vlevViagemLocalEventoCollection;
    }

    public Collection<VconViagemConhecimento> getVconViagemConhecimentoCollection() {
        return vconViagemConhecimentoCollection;
    }

    public void setVconViagemConhecimentoCollection(Collection<VconViagemConhecimento> vconViagemConhecimentoCollection) {
        this.vconViagemConhecimentoCollection = vconViagemConhecimentoCollection;
    }

    public ViagViagem getViagViagem() {
        return viagViagem;
    }

    public void setViagViagem(ViagViagem viagViagem) {
        this.viagViagem = viagViagem;
    }

    public TparTipoParada getTparTipoParada() {
        return tparTipoParada;
    }

    public void setTparTipoParada(TparTipoParada tparTipoParada) {
        this.tparTipoParada = tparTipoParada;
    }

    public RefeReferencia getRefeReferencia() {
        return refeReferencia;
    }

    public void setRefeReferencia(RefeReferencia refeReferencia) {
        this.refeReferencia = refeReferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vlocCodigo != null ? vlocCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VlocViagemLocal)) {
            return false;
        }
        VlocViagemLocal other = (VlocViagemLocal) object;
        if ((this.vlocCodigo == null && other.vlocCodigo != null) || (this.vlocCodigo != null && !this.vlocCodigo.equals(other.vlocCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VlocViagemLocal[vlocCodigo=" + vlocCodigo + "]";
    }

}
