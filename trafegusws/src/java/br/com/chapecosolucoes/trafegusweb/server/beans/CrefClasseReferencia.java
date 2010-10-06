/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
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
@Table(name = "cref_classe_referencia")
@NamedQueries({
    @NamedQuery(name = "CrefClasseReferencia.findAll", query = "SELECT c FROM CrefClasseReferencia c"),
    @NamedQuery(name = "CrefClasseReferencia.findByCrefCodigo", query = "SELECT c FROM CrefClasseReferencia c WHERE c.crefCodigo = :crefCodigo"),
    @NamedQuery(name = "CrefClasseReferencia.findByCrefDescricao", query = "SELECT c FROM CrefClasseReferencia c WHERE c.crefDescricao = :crefDescricao"),
    @NamedQuery(name = "CrefClasseReferencia.findByCrefClasseSistema", query = "SELECT c FROM CrefClasseReferencia c WHERE c.crefClasseSistema = :crefClasseSistema"),
    @NamedQuery(name = "CrefClasseReferencia.findByCrefDataCadastro", query = "SELECT c FROM CrefClasseReferencia c WHERE c.crefDataCadastro = :crefDataCadastro"),
    @NamedQuery(name = "CrefClasseReferencia.findByCrefCodigoGr", query = "SELECT c FROM CrefClasseReferencia c WHERE c.crefCodigoGr = :crefCodigoGr"),
    @NamedQuery(name = "CrefClasseReferencia.findByCrefImportado", query = "SELECT c FROM CrefClasseReferencia c WHERE c.crefImportado = :crefImportado")})
public class CrefClasseReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cref_codigo")
    private Integer crefCodigo;
    @Column(name = "cref_descricao")
    private String crefDescricao;
    @Column(name = "cref_classe_sistema")
    private Character crefClasseSistema;
    @Column(name = "cref_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crefDataCadastro;
    @Column(name = "cref_codigo_gr")
    private Integer crefCodigoGr;
    @Column(name = "cref_importado")
    private Character crefImportado;
    @OneToMany(mappedBy = "crefClasseReferencia", fetch = FetchType.LAZY)
    private Collection<RefeReferencia> refeReferenciaCollection;
    @JoinColumn(name = "cref_pess_oras_codigo", referencedColumnName = "pess_oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private PessPessoa pessPessoa;

    public CrefClasseReferencia() {
    }

    public CrefClasseReferencia(Integer crefCodigo) {
        this.crefCodigo = crefCodigo;
    }

    public Integer getCrefCodigo() {
        return crefCodigo;
    }

    public void setCrefCodigo(Integer crefCodigo) {
        this.crefCodigo = crefCodigo;
    }

    public String getCrefDescricao() {
        return crefDescricao;
    }

    public void setCrefDescricao(String crefDescricao) {
        this.crefDescricao = crefDescricao;
    }

    public Character getCrefClasseSistema() {
        return crefClasseSistema;
    }

    public void setCrefClasseSistema(Character crefClasseSistema) {
        this.crefClasseSistema = crefClasseSistema;
    }

    public Date getCrefDataCadastro() {
        return crefDataCadastro;
    }

    public void setCrefDataCadastro(Date crefDataCadastro) {
        this.crefDataCadastro = crefDataCadastro;
    }

    public Integer getCrefCodigoGr() {
        return crefCodigoGr;
    }

    public void setCrefCodigoGr(Integer crefCodigoGr) {
        this.crefCodigoGr = crefCodigoGr;
    }

    public Character getCrefImportado() {
        return crefImportado;
    }

    public void setCrefImportado(Character crefImportado) {
        this.crefImportado = crefImportado;
    }

    public Collection<RefeReferencia> getRefeReferenciaCollection() {
        return refeReferenciaCollection;
    }

    public void setRefeReferenciaCollection(Collection<RefeReferencia> refeReferenciaCollection) {
        this.refeReferenciaCollection = refeReferenciaCollection;
    }

    public PessPessoa getPessPessoa() {
        return pessPessoa;
    }

    public void setPessPessoa(PessPessoa pessPessoa) {
        this.pessPessoa = pessPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crefCodigo != null ? crefCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrefClasseReferencia)) {
            return false;
        }
        CrefClasseReferencia other = (CrefClasseReferencia) object;
        if ((this.crefCodigo == null && other.crefCodigo != null) || (this.crefCodigo != null && !this.crefCodigo.equals(other.crefCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CrefClasseReferencia[crefCodigo=" + crefCodigo + "]";
    }

}
