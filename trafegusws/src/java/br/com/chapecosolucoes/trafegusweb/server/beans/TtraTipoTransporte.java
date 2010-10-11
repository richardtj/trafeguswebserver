/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "ttra_tipo_transporte")
@NamedQueries({
    @NamedQuery(name = "TtraTipoTransporte.findAll", query = "SELECT t FROM TtraTipoTransporte t"),
    @NamedQuery(name = "TtraTipoTransporte.findByTtraCodigo", query = "SELECT t FROM TtraTipoTransporte t WHERE t.ttraCodigo = :ttraCodigo"),
    @NamedQuery(name = "TtraTipoTransporte.findByTtraDescricao", query = "SELECT t FROM TtraTipoTransporte t WHERE t.ttraDescricao = :ttraDescricao")})
public class TtraTipoTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ttra_codigo")
    private Integer ttraCodigo;
    @Column(name = "ttra_descricao")
    private String ttraDescricao;
    @OneToMany(mappedBy = "ttraTipoTransporte", fetch = FetchType.EAGER)
    private List<ViagViagem> viagViagemList;
    @OneToMany(mappedBy = "ttraTipoTransporte", fetch = FetchType.EAGER)
    private List<SvteSeguradoraVersaoTecnol> svteSeguradoraVersaoTecnolList;

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

    public List<ViagViagem> getViagViagemList() {
        return viagViagemList;
    }

    public void setViagViagemList(List<ViagViagem> viagViagemList) {
        this.viagViagemList = viagViagemList;
    }

    public List<SvteSeguradoraVersaoTecnol> getSvteSeguradoraVersaoTecnolList() {
        return svteSeguradoraVersaoTecnolList;
    }

    public void setSvteSeguradoraVersaoTecnolList(List<SvteSeguradoraVersaoTecnol> svteSeguradoraVersaoTecnolList) {
        this.svteSeguradoraVersaoTecnolList = svteSeguradoraVersaoTecnolList;
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
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TtraTipoTransporte[ttraCodigo=" + ttraCodigo + "]";
    }

}
