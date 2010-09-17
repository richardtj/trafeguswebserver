/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * @author Emerson
 */
@Entity
@Table(name = "ptel_permissao_tela")
@NamedQueries({
    @NamedQuery(name = "PtelPermissaoTela.findAll", query = "SELECT p FROM PtelPermissaoTela p")})
public class PtelPermissaoTela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ptel_codigo", nullable = false)
    private Integer ptelCodigo;
    @Column(name = "ptel_id_objeto")
    private Integer ptelIdObjeto;
    @Column(name = "ptel_permitir_alterar")
    private Character ptelPermitirAlterar;
    @Column(name = "ptel_permitir_inserir")
    private Character ptelPermitirInserir;
    @Column(name = "ptel_permitir_excluir")
    private Character ptelPermitirExcluir;
    @Column(name = "ptel_permitir_visualizar")
    private Character ptelPermitirVisualizar;
    @Column(name = "ptel_permitir_imprimir")
    private Character ptelPermitirImprimir;
    @Column(name = "ptel_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ptelDataCadastro;
    @Column(name = "ptel_codigo_gr")
    private Integer ptelCodigoGr;
    @Column(name = "ptel_importado")
    private Character ptelImportado;
    @JoinColumn(name = "ptel_perf_codigo", referencedColumnName = "perf_codigo")
    @ManyToOne
    private PerfPerfil perfPerfil;
    @OneToMany(mappedBy = "ptelPermissaoTela")
    private Collection<PcamPermissaoCampo> pcamPermissaoCampoCollection;

    public PtelPermissaoTela() {
    }

    public PtelPermissaoTela(Integer ptelCodigo) {
        this.ptelCodigo = ptelCodigo;
    }

    public Integer getPtelCodigo() {
        return ptelCodigo;
    }

    public void setPtelCodigo(Integer ptelCodigo) {
        this.ptelCodigo = ptelCodigo;
    }

    public Integer getPtelIdObjeto() {
        return ptelIdObjeto;
    }

    public void setPtelIdObjeto(Integer ptelIdObjeto) {
        this.ptelIdObjeto = ptelIdObjeto;
    }

    public Character getPtelPermitirAlterar() {
        return ptelPermitirAlterar;
    }

    public void setPtelPermitirAlterar(Character ptelPermitirAlterar) {
        this.ptelPermitirAlterar = ptelPermitirAlterar;
    }

    public Character getPtelPermitirInserir() {
        return ptelPermitirInserir;
    }

    public void setPtelPermitirInserir(Character ptelPermitirInserir) {
        this.ptelPermitirInserir = ptelPermitirInserir;
    }

    public Character getPtelPermitirExcluir() {
        return ptelPermitirExcluir;
    }

    public void setPtelPermitirExcluir(Character ptelPermitirExcluir) {
        this.ptelPermitirExcluir = ptelPermitirExcluir;
    }

    public Character getPtelPermitirVisualizar() {
        return ptelPermitirVisualizar;
    }

    public void setPtelPermitirVisualizar(Character ptelPermitirVisualizar) {
        this.ptelPermitirVisualizar = ptelPermitirVisualizar;
    }

    public Character getPtelPermitirImprimir() {
        return ptelPermitirImprimir;
    }

    public void setPtelPermitirImprimir(Character ptelPermitirImprimir) {
        this.ptelPermitirImprimir = ptelPermitirImprimir;
    }

    public Date getPtelDataCadastro() {
        return ptelDataCadastro;
    }

    public void setPtelDataCadastro(Date ptelDataCadastro) {
        this.ptelDataCadastro = ptelDataCadastro;
    }

    public Integer getPtelCodigoGr() {
        return ptelCodigoGr;
    }

    public void setPtelCodigoGr(Integer ptelCodigoGr) {
        this.ptelCodigoGr = ptelCodigoGr;
    }

    public Character getPtelImportado() {
        return ptelImportado;
    }

    public void setPtelImportado(Character ptelImportado) {
        this.ptelImportado = ptelImportado;
    }

    public PerfPerfil getPerfPerfil() {
        return perfPerfil;
    }

    public void setPerfPerfil(PerfPerfil perfPerfil) {
        this.perfPerfil = perfPerfil;
    }

    public Collection<PcamPermissaoCampo> getPcamPermissaoCampoCollection() {
        return pcamPermissaoCampoCollection;
    }

    public void setPcamPermissaoCampoCollection(Collection<PcamPermissaoCampo> pcamPermissaoCampoCollection) {
        this.pcamPermissaoCampoCollection = pcamPermissaoCampoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ptelCodigo != null ? ptelCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtelPermissaoTela)) {
            return false;
        }
        PtelPermissaoTela other = (PtelPermissaoTela) object;
        if ((this.ptelCodigo == null && other.ptelCodigo != null) || (this.ptelCodigo != null && !this.ptelCodigo.equals(other.ptelCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PtelPermissaoTela[ptelCodigo=" + ptelCodigo + "]";
    }

}
