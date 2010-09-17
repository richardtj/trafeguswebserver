/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
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
@Table(name = "pipa_pg_item_parametro")
@NamedQueries({
    @NamedQuery(name = "PipaPgItemParametro.findAll", query = "SELECT p FROM PipaPgItemParametro p")})
public class PipaPgItemParametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pipa_codigo", nullable = false)
    private Integer pipaCodigo;
    @Column(name = "pipa_sequencia")
    private Integer pipaSequencia;
    @Column(name = "pipa_descricao", length = 50)
    private String pipaDescricao;
    @Column(name = "pipa_valor", length = 100)
    private String pipaValor;
    @Column(name = "pipa_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pipaDataCadastro;
    @Column(name = "pipa_codigo_gr")
    private Integer pipaCodigoGr;
    @Column(name = "pipa_importado")
    private Character pipaImportado;
    @JoinColumn(name = "pipa_tval_codigo", referencedColumnName = "tval_codigo")
    @ManyToOne
    private TvalTipoValor tvalTipoValor;
    @JoinColumn(name = "pipa_tpar_codigo", referencedColumnName = "tpar_codigo")
    @ManyToOne
    private TparTipoParametro tparTipoParametro;
    @JoinColumn(name = "pipa_pite_codigo", referencedColumnName = "pite_codigo")
    @ManyToOne
    private PitePgItem pitePgItem;

    public PipaPgItemParametro() {
    }

    public PipaPgItemParametro(Integer pipaCodigo) {
        this.pipaCodigo = pipaCodigo;
    }

    public Integer getPipaCodigo() {
        return pipaCodigo;
    }

    public void setPipaCodigo(Integer pipaCodigo) {
        this.pipaCodigo = pipaCodigo;
    }

    public Integer getPipaSequencia() {
        return pipaSequencia;
    }

    public void setPipaSequencia(Integer pipaSequencia) {
        this.pipaSequencia = pipaSequencia;
    }

    public String getPipaDescricao() {
        return pipaDescricao;
    }

    public void setPipaDescricao(String pipaDescricao) {
        this.pipaDescricao = pipaDescricao;
    }

    public String getPipaValor() {
        return pipaValor;
    }

    public void setPipaValor(String pipaValor) {
        this.pipaValor = pipaValor;
    }

    public Date getPipaDataCadastro() {
        return pipaDataCadastro;
    }

    public void setPipaDataCadastro(Date pipaDataCadastro) {
        this.pipaDataCadastro = pipaDataCadastro;
    }

    public Integer getPipaCodigoGr() {
        return pipaCodigoGr;
    }

    public void setPipaCodigoGr(Integer pipaCodigoGr) {
        this.pipaCodigoGr = pipaCodigoGr;
    }

    public Character getPipaImportado() {
        return pipaImportado;
    }

    public void setPipaImportado(Character pipaImportado) {
        this.pipaImportado = pipaImportado;
    }

    public TvalTipoValor getTvalTipoValor() {
        return tvalTipoValor;
    }

    public void setTvalTipoValor(TvalTipoValor tvalTipoValor) {
        this.tvalTipoValor = tvalTipoValor;
    }

    public TparTipoParametro getTparTipoParametro() {
        return tparTipoParametro;
    }

    public void setTparTipoParametro(TparTipoParametro tparTipoParametro) {
        this.tparTipoParametro = tparTipoParametro;
    }

    public PitePgItem getPitePgItem() {
        return pitePgItem;
    }

    public void setPitePgItem(PitePgItem pitePgItem) {
        this.pitePgItem = pitePgItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pipaCodigo != null ? pipaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PipaPgItemParametro)) {
            return false;
        }
        PipaPgItemParametro other = (PipaPgItemParametro) object;
        if ((this.pipaCodigo == null && other.pipaCodigo != null) || (this.pipaCodigo != null && !this.pipaCodigo.equals(other.pipaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PipaPgItemParametro[pipaCodigo=" + pipaCodigo + "]";
    }

}
