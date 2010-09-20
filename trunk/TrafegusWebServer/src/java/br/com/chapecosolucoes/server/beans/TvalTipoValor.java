/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "tval_tipo_valor", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TvalTipoValor.findAll", query = "SELECT t FROM TvalTipoValor t"),
    @NamedQuery(name = "TvalTipoValor.findByTvalCodigo", query = "SELECT t FROM TvalTipoValor t WHERE t.tvalCodigo = :tvalCodigo"),
    @NamedQuery(name = "TvalTipoValor.findByTvalDescricao", query = "SELECT t FROM TvalTipoValor t WHERE t.tvalDescricao = :tvalDescricao")})
public class TvalTipoValor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tval_codigo", nullable = false)
    private Integer tvalCodigo;
    @Column(name = "tval_descricao", length = 50)
    private String tvalDescricao;
    @OneToMany(mappedBy = "tvalTipoValor")
    private List<EppaEventoPerifericoPadrao> eppaEventoPerifericoPadraoList;

    public TvalTipoValor() {
    }

    public TvalTipoValor(Integer tvalCodigo) {
        this.tvalCodigo = tvalCodigo;
    }

    public Integer getTvalCodigo() {
        return tvalCodigo;
    }

    public void setTvalCodigo(Integer tvalCodigo) {
        this.tvalCodigo = tvalCodigo;
    }

    public String getTvalDescricao() {
        return tvalDescricao;
    }

    public void setTvalDescricao(String tvalDescricao) {
        this.tvalDescricao = tvalDescricao;
    }

    public List<EppaEventoPerifericoPadrao> getEppaEventoPerifericoPadraoList() {
        return eppaEventoPerifericoPadraoList;
    }

    public void setEppaEventoPerifericoPadraoList(List<EppaEventoPerifericoPadrao> eppaEventoPerifericoPadraoList) {
        this.eppaEventoPerifericoPadraoList = eppaEventoPerifericoPadraoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tvalCodigo != null ? tvalCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TvalTipoValor)) {
            return false;
        }
        TvalTipoValor other = (TvalTipoValor) object;
        if ((this.tvalCodigo == null && other.tvalCodigo != null) || (this.tvalCodigo != null && !this.tvalCodigo.equals(other.tvalCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.TvalTipoValor[tvalCodigo=" + tvalCodigo + "]";
    }

}
