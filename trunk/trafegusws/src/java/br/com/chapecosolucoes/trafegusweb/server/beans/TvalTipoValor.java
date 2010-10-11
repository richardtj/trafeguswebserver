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
@Table(name = "tval_tipo_valor")
@NamedQueries({
    @NamedQuery(name = "TvalTipoValor.findAll", query = "SELECT t FROM TvalTipoValor t"),
    @NamedQuery(name = "TvalTipoValor.findByTvalCodigo", query = "SELECT t FROM TvalTipoValor t WHERE t.tvalCodigo = :tvalCodigo"),
    @NamedQuery(name = "TvalTipoValor.findByTvalDescricao", query = "SELECT t FROM TvalTipoValor t WHERE t.tvalDescricao = :tvalDescricao")})
public class TvalTipoValor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tval_codigo")
    private Integer tvalCodigo;
    @Column(name = "tval_descricao")
    private String tvalDescricao;
    @OneToMany(mappedBy = "tvalTipoValor", fetch = FetchType.EAGER)
    private List<PcpaParametroComandoPadrao> pcpaParametroComandoPadraoList;
    @OneToMany(mappedBy = "tvalTipoValor", fetch = FetchType.EAGER)
    private List<EppaEventoPerifericoPadrao> eppaEventoPerifericoPadraoList;
    @OneToMany(mappedBy = "tvalTipoValor", fetch = FetchType.EAGER)
    private List<PaipPgAssociaItemParam> paipPgAssociaItemParamList;
    @OneToMany(mappedBy = "tvalTipoValor", fetch = FetchType.EAGER)
    private List<EspaEventoSistemaPadrao> espaEventoSistemaPadraoList;
    @OneToMany(mappedBy = "tvalTipoValor", fetch = FetchType.EAGER)
    private List<PipaPgItemParametro> pipaPgItemParametroList;

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

    public List<PcpaParametroComandoPadrao> getPcpaParametroComandoPadraoList() {
        return pcpaParametroComandoPadraoList;
    }

    public void setPcpaParametroComandoPadraoList(List<PcpaParametroComandoPadrao> pcpaParametroComandoPadraoList) {
        this.pcpaParametroComandoPadraoList = pcpaParametroComandoPadraoList;
    }

    public List<EppaEventoPerifericoPadrao> getEppaEventoPerifericoPadraoList() {
        return eppaEventoPerifericoPadraoList;
    }

    public void setEppaEventoPerifericoPadraoList(List<EppaEventoPerifericoPadrao> eppaEventoPerifericoPadraoList) {
        this.eppaEventoPerifericoPadraoList = eppaEventoPerifericoPadraoList;
    }

    public List<PaipPgAssociaItemParam> getPaipPgAssociaItemParamList() {
        return paipPgAssociaItemParamList;
    }

    public void setPaipPgAssociaItemParamList(List<PaipPgAssociaItemParam> paipPgAssociaItemParamList) {
        this.paipPgAssociaItemParamList = paipPgAssociaItemParamList;
    }

    public List<EspaEventoSistemaPadrao> getEspaEventoSistemaPadraoList() {
        return espaEventoSistemaPadraoList;
    }

    public void setEspaEventoSistemaPadraoList(List<EspaEventoSistemaPadrao> espaEventoSistemaPadraoList) {
        this.espaEventoSistemaPadraoList = espaEventoSistemaPadraoList;
    }

    public List<PipaPgItemParametro> getPipaPgItemParametroList() {
        return pipaPgItemParametroList;
    }

    public void setPipaPgItemParametroList(List<PipaPgItemParametro> pipaPgItemParametroList) {
        this.pipaPgItemParametroList = pipaPgItemParametroList;
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
