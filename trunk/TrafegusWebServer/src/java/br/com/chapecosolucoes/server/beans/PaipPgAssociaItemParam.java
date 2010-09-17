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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "paip_pg_associa_item_param", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"paip_pgai_codigo", "paip_sequencia"})})
@NamedQueries({
    @NamedQuery(name = "PaipPgAssociaItemParam.findAll", query = "SELECT p FROM PaipPgAssociaItemParam p")})
public class PaipPgAssociaItemParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "paip_codigo", nullable = false)
    private Integer paipCodigo;
    @Column(name = "paip_sequencia")
    private Integer paipSequencia;
    @Column(name = "paip_valor", length = 100)
    private String paipValor;
    @Column(name = "paip_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paipDataCadastro;
    @Column(name = "paip_codigo_gr")
    private Integer paipCodigoGr;
    @Column(name = "paip_importado")
    private Character paipImportado;
    @Column(name = "paip_descricao", length = 50)
    private String paipDescricao;
    @JoinColumn(name = "paip_tval_codigo", referencedColumnName = "tval_codigo")
    @ManyToOne
    private TvalTipoValor tvalTipoValor;
    @JoinColumn(name = "paip_tpar_codigo", referencedColumnName = "tpar_codigo")
    @ManyToOne
    private TparTipoParametro tparTipoParametro;
    @JoinColumn(name = "paip_pgai_codigo", referencedColumnName = "pgai_codigo")
    @ManyToOne
    private PgaiPgAssociaItem pgaiPgAssociaItem;

    public PaipPgAssociaItemParam() {
    }

    public PaipPgAssociaItemParam(Integer paipCodigo) {
        this.paipCodigo = paipCodigo;
    }

    public Integer getPaipCodigo() {
        return paipCodigo;
    }

    public void setPaipCodigo(Integer paipCodigo) {
        this.paipCodigo = paipCodigo;
    }

    public Integer getPaipSequencia() {
        return paipSequencia;
    }

    public void setPaipSequencia(Integer paipSequencia) {
        this.paipSequencia = paipSequencia;
    }

    public String getPaipValor() {
        return paipValor;
    }

    public void setPaipValor(String paipValor) {
        this.paipValor = paipValor;
    }

    public Date getPaipDataCadastro() {
        return paipDataCadastro;
    }

    public void setPaipDataCadastro(Date paipDataCadastro) {
        this.paipDataCadastro = paipDataCadastro;
    }

    public Integer getPaipCodigoGr() {
        return paipCodigoGr;
    }

    public void setPaipCodigoGr(Integer paipCodigoGr) {
        this.paipCodigoGr = paipCodigoGr;
    }

    public Character getPaipImportado() {
        return paipImportado;
    }

    public void setPaipImportado(Character paipImportado) {
        this.paipImportado = paipImportado;
    }

    public String getPaipDescricao() {
        return paipDescricao;
    }

    public void setPaipDescricao(String paipDescricao) {
        this.paipDescricao = paipDescricao;
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

    public PgaiPgAssociaItem getPgaiPgAssociaItem() {
        return pgaiPgAssociaItem;
    }

    public void setPgaiPgAssociaItem(PgaiPgAssociaItem pgaiPgAssociaItem) {
        this.pgaiPgAssociaItem = pgaiPgAssociaItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paipCodigo != null ? paipCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaipPgAssociaItemParam)) {
            return false;
        }
        PaipPgAssociaItemParam other = (PaipPgAssociaItemParam) object;
        if ((this.paipCodigo == null && other.paipCodigo != null) || (this.paipCodigo != null && !this.paipCodigo.equals(other.paipCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PaipPgAssociaItemParam[paipCodigo=" + paipCodigo + "]";
    }

}
