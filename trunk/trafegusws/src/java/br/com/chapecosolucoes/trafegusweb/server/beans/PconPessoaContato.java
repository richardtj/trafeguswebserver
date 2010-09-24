/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

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
@Table(name = "pcon_pessoa_contato", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PconPessoaContato.findAll", query = "SELECT p FROM PconPessoaContato p"),
    @NamedQuery(name = "PconPessoaContato.findByPconCodigo", query = "SELECT p FROM PconPessoaContato p WHERE p.pconCodigo = :pconCodigo"),
    @NamedQuery(name = "PconPessoaContato.findByPconDataCadastro", query = "SELECT p FROM PconPessoaContato p WHERE p.pconDataCadastro = :pconDataCadastro"),
    @NamedQuery(name = "PconPessoaContato.findByPconCodigoGr", query = "SELECT p FROM PconPessoaContato p WHERE p.pconCodigoGr = :pconCodigoGr"),
    @NamedQuery(name = "PconPessoaContato.findByPconImportado", query = "SELECT p FROM PconPessoaContato p WHERE p.pconImportado = :pconImportado")})
public class PconPessoaContato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pcon_codigo", nullable = false)
    private Integer pconCodigo;
    @Column(name = "pcon_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pconDataCadastro;
    @Column(name = "pcon_codigo_gr")
    private Integer pconCodigoGr;
    @Column(name = "pcon_importado")
    private Character pconImportado;
    @JoinColumn(name = "pcon_pess_oras_codigo", referencedColumnName = "pess_oras_codigo")
    @ManyToOne
    private PessPessoa pessPessoa;
    @JoinColumn(name = "pcon_cona_codigo", referencedColumnName = "cona_codigo")
    @ManyToOne
    private ConaContato conaContato;

    public PconPessoaContato() {
    }

    public PconPessoaContato(Integer pconCodigo) {
        this.pconCodigo = pconCodigo;
    }

    public Integer getPconCodigo() {
        return pconCodigo;
    }

    public void setPconCodigo(Integer pconCodigo) {
        this.pconCodigo = pconCodigo;
    }

    public Date getPconDataCadastro() {
        return pconDataCadastro;
    }

    public void setPconDataCadastro(Date pconDataCadastro) {
        this.pconDataCadastro = pconDataCadastro;
    }

    public Integer getPconCodigoGr() {
        return pconCodigoGr;
    }

    public void setPconCodigoGr(Integer pconCodigoGr) {
        this.pconCodigoGr = pconCodigoGr;
    }

    public Character getPconImportado() {
        return pconImportado;
    }

    public void setPconImportado(Character pconImportado) {
        this.pconImportado = pconImportado;
    }

    public PessPessoa getPessPessoa() {
        return pessPessoa;
    }

    public void setPessPessoa(PessPessoa pessPessoa) {
        this.pessPessoa = pessPessoa;
    }

    public ConaContato getConaContato() {
        return conaContato;
    }

    public void setConaContato(ConaContato conaContato) {
        this.conaContato = conaContato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pconCodigo != null ? pconCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PconPessoaContato)) {
            return false;
        }
        PconPessoaContato other = (PconPessoaContato) object;
        if ((this.pconCodigo == null && other.pconCodigo != null) || (this.pconCodigo != null && !this.pconCodigo.equals(other.pconCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PconPessoaContato[pconCodigo=" + pconCodigo + "]";
    }

}
