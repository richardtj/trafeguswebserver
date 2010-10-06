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
@Table(name = "ptit_pg_tipo_item")
@NamedQueries({
    @NamedQuery(name = "PtitPgTipoItem.findAll", query = "SELECT p FROM PtitPgTipoItem p"),
    @NamedQuery(name = "PtitPgTipoItem.findByPtitCodigo", query = "SELECT p FROM PtitPgTipoItem p WHERE p.ptitCodigo = :ptitCodigo"),
    @NamedQuery(name = "PtitPgTipoItem.findByPtitDescricao", query = "SELECT p FROM PtitPgTipoItem p WHERE p.ptitDescricao = :ptitDescricao")})
public class PtitPgTipoItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ptit_codigo")
    private Integer ptitCodigo;
    @Column(name = "ptit_descricao")
    private String ptitDescricao;
    @OneToMany(mappedBy = "ptitPgTipoItem", fetch = FetchType.LAZY)
    private Collection<PitePgItem> pitePgItemCollection;

    public PtitPgTipoItem() {
    }

    public PtitPgTipoItem(Integer ptitCodigo) {
        this.ptitCodigo = ptitCodigo;
    }

    public Integer getPtitCodigo() {
        return ptitCodigo;
    }

    public void setPtitCodigo(Integer ptitCodigo) {
        this.ptitCodigo = ptitCodigo;
    }

    public String getPtitDescricao() {
        return ptitDescricao;
    }

    public void setPtitDescricao(String ptitDescricao) {
        this.ptitDescricao = ptitDescricao;
    }

    public Collection<PitePgItem> getPitePgItemCollection() {
        return pitePgItemCollection;
    }

    public void setPitePgItemCollection(Collection<PitePgItem> pitePgItemCollection) {
        this.pitePgItemCollection = pitePgItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ptitCodigo != null ? ptitCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtitPgTipoItem)) {
            return false;
        }
        PtitPgTipoItem other = (PtitPgTipoItem) object;
        if ((this.ptitCodigo == null && other.ptitCodigo != null) || (this.ptitCodigo != null && !this.ptitCodigo.equals(other.ptitCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PtitPgTipoItem[ptitCodigo=" + ptitCodigo + "]";
    }

}
