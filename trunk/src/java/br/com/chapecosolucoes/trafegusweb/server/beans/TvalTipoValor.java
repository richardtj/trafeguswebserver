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
    private Collection<PcpaParametroComandoPadrao> pcpaParametroComandoPadraoCollection;
    @OneToMany(mappedBy = "tvalTipoValor")
    private Collection<EppaEventoPerifericoPadrao> eppaEventoPerifericoPadraoCollection;
    @OneToMany(mappedBy = "tvalTipoValor")
    private Collection<PaipPgAssociaItemParam> paipPgAssociaItemParamCollection;
    @OneToMany(mappedBy = "tvalTipoValor")
    private Collection<EspaEventoSistemaPadrao> espaEventoSistemaPadraoCollection;
    @OneToMany(mappedBy = "tvalTipoValor")
    private Collection<PipaPgItemParametro> pipaPgItemParametroCollection;

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

    public Collection<PcpaParametroComandoPadrao> getPcpaParametroComandoPadraoCollection() {
        return pcpaParametroComandoPadraoCollection;
    }

    public void setPcpaParametroComandoPadraoCollection(Collection<PcpaParametroComandoPadrao> pcpaParametroComandoPadraoCollection) {
        this.pcpaParametroComandoPadraoCollection = pcpaParametroComandoPadraoCollection;
    }

    public Collection<EppaEventoPerifericoPadrao> getEppaEventoPerifericoPadraoCollection() {
        return eppaEventoPerifericoPadraoCollection;
    }

    public void setEppaEventoPerifericoPadraoCollection(Collection<EppaEventoPerifericoPadrao> eppaEventoPerifericoPadraoCollection) {
        this.eppaEventoPerifericoPadraoCollection = eppaEventoPerifericoPadraoCollection;
    }

    public Collection<PaipPgAssociaItemParam> getPaipPgAssociaItemParamCollection() {
        return paipPgAssociaItemParamCollection;
    }

    public void setPaipPgAssociaItemParamCollection(Collection<PaipPgAssociaItemParam> paipPgAssociaItemParamCollection) {
        this.paipPgAssociaItemParamCollection = paipPgAssociaItemParamCollection;
    }

    public Collection<EspaEventoSistemaPadrao> getEspaEventoSistemaPadraoCollection() {
        return espaEventoSistemaPadraoCollection;
    }

    public void setEspaEventoSistemaPadraoCollection(Collection<EspaEventoSistemaPadrao> espaEventoSistemaPadraoCollection) {
        this.espaEventoSistemaPadraoCollection = espaEventoSistemaPadraoCollection;
    }

    public Collection<PipaPgItemParametro> getPipaPgItemParametroCollection() {
        return pipaPgItemParametroCollection;
    }

    public void setPipaPgItemParametroCollection(Collection<PipaPgItemParametro> pipaPgItemParametroCollection) {
        this.pipaPgItemParametroCollection = pipaPgItemParametroCollection;
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
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TvalTipoValor[tvalCodigo=" + tvalCodigo + "]";
    }

}
