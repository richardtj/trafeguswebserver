/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "tper_tipo_periferico")
@NamedQueries({
    @NamedQuery(name = "TperTipoPeriferico.findAll", query = "SELECT t FROM TperTipoPeriferico t"),
    @NamedQuery(name = "TperTipoPeriferico.findByTperCodigo", query = "SELECT t FROM TperTipoPeriferico t WHERE t.tperCodigo = :tperCodigo"),
    @NamedQuery(name = "TperTipoPeriferico.findByTperDescricao", query = "SELECT t FROM TperTipoPeriferico t WHERE t.tperDescricao = :tperDescricao")})
public class TperTipoPeriferico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tper_codigo")
    private Integer tperCodigo;
    @Column(name = "tper_descricao")
    private String tperDescricao;
    @OneToMany(mappedBy = "tperTipoPeriferico", fetch = FetchType.LAZY)
    private Collection<PpadPerifericoPadrao> ppadPerifericoPadraoCollection;

    public TperTipoPeriferico() {
    }

    public TperTipoPeriferico(Integer tperCodigo) {
        this.tperCodigo = tperCodigo;
    }

    public Integer getTperCodigo() {
        return tperCodigo;
    }

    public void setTperCodigo(Integer tperCodigo) {
        this.tperCodigo = tperCodigo;
    }

    public String getTperDescricao() {
        return tperDescricao;
    }

    public void setTperDescricao(String tperDescricao) {
        this.tperDescricao = tperDescricao;
    }

    public Collection<PpadPerifericoPadrao> getPpadPerifericoPadraoCollection() {
        return ppadPerifericoPadraoCollection;
    }

    public void setPpadPerifericoPadraoCollection(Collection<PpadPerifericoPadrao> ppadPerifericoPadraoCollection) {
        this.ppadPerifericoPadraoCollection = ppadPerifericoPadraoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tperCodigo != null ? tperCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TperTipoPeriferico)) {
            return false;
        }
        TperTipoPeriferico other = (TperTipoPeriferico) object;
        if ((this.tperCodigo == null && other.tperCodigo != null) || (this.tperCodigo != null && !this.tperCodigo.equals(other.tperCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TperTipoPeriferico[tperCodigo=" + tperCodigo + "]";
    }

}
