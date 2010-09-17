/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

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
@Table(name = "ttra_tipo_transporte")
@NamedQueries({
    @NamedQuery(name = "TtraTipoTransporte.findAll", query = "SELECT t FROM TtraTipoTransporte t")})
public class TtraTipoTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ttra_codigo", nullable = false)
    private Integer ttraCodigo;
    @Column(name = "ttra_descricao", length = 50)
    private String ttraDescricao;
    @OneToMany(mappedBy = "ttraTipoTransporte")
    private Collection<ViagViagem> viagViagemCollection;
    @OneToMany(mappedBy = "ttraTipoTransporte")
    private Collection<SvteSeguradoraVersaoTecnol> svteSeguradoraVersaoTecnolCollection;

    public TtraTipoTransporte() {
    }

    public TtraTipoTransporte(Integer ttraCodigo) {
        this.ttraCodigo = ttraCodigo;
    }

    public Integer getTtraCodigo() {
        return ttraCodigo;
    }

    public void setTtraCodigo(Integer ttraCodigo) {
        this.ttraCodigo = ttraCodigo;
    }

    public String getTtraDescricao() {
        return ttraDescricao;
    }

    public void setTtraDescricao(String ttraDescricao) {
        this.ttraDescricao = ttraDescricao;
    }

    public Collection<ViagViagem> getViagViagemCollection() {
        return viagViagemCollection;
    }

    public void setViagViagemCollection(Collection<ViagViagem> viagViagemCollection) {
        this.viagViagemCollection = viagViagemCollection;
    }

    public Collection<SvteSeguradoraVersaoTecnol> getSvteSeguradoraVersaoTecnolCollection() {
        return svteSeguradoraVersaoTecnolCollection;
    }

    public void setSvteSeguradoraVersaoTecnolCollection(Collection<SvteSeguradoraVersaoTecnol> svteSeguradoraVersaoTecnolCollection) {
        this.svteSeguradoraVersaoTecnolCollection = svteSeguradoraVersaoTecnolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttraCodigo != null ? ttraCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtraTipoTransporte)) {
            return false;
        }
        TtraTipoTransporte other = (TtraTipoTransporte) object;
        if ((this.ttraCodigo == null && other.ttraCodigo != null) || (this.ttraCodigo != null && !this.ttraCodigo.equals(other.ttraCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.TtraTipoTransporte[ttraCodigo=" + ttraCodigo + "]";
    }

}
