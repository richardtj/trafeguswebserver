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
@Table(name = "tmac_tipo_macro", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TmacTipoMacro.findAll", query = "SELECT t FROM TmacTipoMacro t"),
    @NamedQuery(name = "TmacTipoMacro.findByTmacCodigo", query = "SELECT t FROM TmacTipoMacro t WHERE t.tmacCodigo = :tmacCodigo"),
    @NamedQuery(name = "TmacTipoMacro.findByTmacDescricao", query = "SELECT t FROM TmacTipoMacro t WHERE t.tmacDescricao = :tmacDescricao")})
public class TmacTipoMacro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tmac_codigo", nullable = false)
    private Integer tmacCodigo;
    @Column(name = "tmac_descricao", length = 50)
    private String tmacDescricao;
    @OneToMany(mappedBy = "tmacTipoMacro")
    private Collection<MpadMacroPadrao> mpadMacroPadraoCollection;

    public TmacTipoMacro() {
    }

    public TmacTipoMacro(Integer tmacCodigo) {
        this.tmacCodigo = tmacCodigo;
    }

    public Integer getTmacCodigo() {
        return tmacCodigo;
    }

    public void setTmacCodigo(Integer tmacCodigo) {
        this.tmacCodigo = tmacCodigo;
    }

    public String getTmacDescricao() {
        return tmacDescricao;
    }

    public void setTmacDescricao(String tmacDescricao) {
        this.tmacDescricao = tmacDescricao;
    }

    public Collection<MpadMacroPadrao> getMpadMacroPadraoCollection() {
        return mpadMacroPadraoCollection;
    }

    public void setMpadMacroPadraoCollection(Collection<MpadMacroPadrao> mpadMacroPadraoCollection) {
        this.mpadMacroPadraoCollection = mpadMacroPadraoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmacCodigo != null ? tmacCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmacTipoMacro)) {
            return false;
        }
        TmacTipoMacro other = (TmacTipoMacro) object;
        if ((this.tmacCodigo == null && other.tmacCodigo != null) || (this.tmacCodigo != null && !this.tmacCodigo.equals(other.tmacCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TmacTipoMacro[tmacCodigo=" + tmacCodigo + "]";
    }

}
