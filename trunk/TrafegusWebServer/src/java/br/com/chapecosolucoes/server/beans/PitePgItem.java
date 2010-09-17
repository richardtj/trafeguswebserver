/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "pite_pg_item")
@NamedQueries({
    @NamedQuery(name = "PitePgItem.findAll", query = "SELECT p FROM PitePgItem p")})
public class PitePgItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pite_codigo", nullable = false)
    private Integer piteCodigo;
    @Column(name = "pite_descricao", length = 150)
    private String piteDescricao;
    @Column(name = "pite_detalhe", length = 500)
    private String piteDetalhe;
    @Column(name = "pite_parametros", length = 5000)
    private String piteParametros;
    @Column(name = "pite_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date piteDataCadastro;
    @Column(name = "pite_codigo_gr")
    private Integer piteCodigoGr;
    @Column(name = "pite_importado")
    private Character piteImportado;
    @JoinColumn(name = "pite_ptit_codigo", referencedColumnName = "ptit_codigo")
    @ManyToOne
    private PtitPgTipoItem ptitPgTipoItem;
    @JoinColumn(name = "pite_ppad_codigo", referencedColumnName = "ppad_codigo")
    @ManyToOne
    private PpadPerifericoPadrao ppadPerifericoPadrao;
    @JoinColumn(name = "pite_mpad_codigo", referencedColumnName = "mpad_codigo")
    @ManyToOne
    private MpadMacroPadrao mpadMacroPadrao;
    @JoinColumn(name = "pite_espa_codigo", referencedColumnName = "espa_codigo")
    @ManyToOne
    private EspaEventoSistemaPadrao espaEventoSistemaPadrao;
    @OneToMany(mappedBy = "pitePgItem")
    private Collection<PgaiPgAssociaItem> pgaiPgAssociaItemCollection;
    @OneToMany(mappedBy = "pitePgItem")
    private Collection<PipaPgItemParametro> pipaPgItemParametroCollection;

    public PitePgItem() {
    }

    public PitePgItem(Integer piteCodigo) {
        this.piteCodigo = piteCodigo;
    }

    public Integer getPiteCodigo() {
        return piteCodigo;
    }

    public void setPiteCodigo(Integer piteCodigo) {
        this.piteCodigo = piteCodigo;
    }

    public String getPiteDescricao() {
        return piteDescricao;
    }

    public void setPiteDescricao(String piteDescricao) {
        this.piteDescricao = piteDescricao;
    }

    public String getPiteDetalhe() {
        return piteDetalhe;
    }

    public void setPiteDetalhe(String piteDetalhe) {
        this.piteDetalhe = piteDetalhe;
    }

    public String getPiteParametros() {
        return piteParametros;
    }

    public void setPiteParametros(String piteParametros) {
        this.piteParametros = piteParametros;
    }

    public Date getPiteDataCadastro() {
        return piteDataCadastro;
    }

    public void setPiteDataCadastro(Date piteDataCadastro) {
        this.piteDataCadastro = piteDataCadastro;
    }

    public Integer getPiteCodigoGr() {
        return piteCodigoGr;
    }

    public void setPiteCodigoGr(Integer piteCodigoGr) {
        this.piteCodigoGr = piteCodigoGr;
    }

    public Character getPiteImportado() {
        return piteImportado;
    }

    public void setPiteImportado(Character piteImportado) {
        this.piteImportado = piteImportado;
    }

    public PtitPgTipoItem getPtitPgTipoItem() {
        return ptitPgTipoItem;
    }

    public void setPtitPgTipoItem(PtitPgTipoItem ptitPgTipoItem) {
        this.ptitPgTipoItem = ptitPgTipoItem;
    }

    public PpadPerifericoPadrao getPpadPerifericoPadrao() {
        return ppadPerifericoPadrao;
    }

    public void setPpadPerifericoPadrao(PpadPerifericoPadrao ppadPerifericoPadrao) {
        this.ppadPerifericoPadrao = ppadPerifericoPadrao;
    }

    public MpadMacroPadrao getMpadMacroPadrao() {
        return mpadMacroPadrao;
    }

    public void setMpadMacroPadrao(MpadMacroPadrao mpadMacroPadrao) {
        this.mpadMacroPadrao = mpadMacroPadrao;
    }

    public EspaEventoSistemaPadrao getEspaEventoSistemaPadrao() {
        return espaEventoSistemaPadrao;
    }

    public void setEspaEventoSistemaPadrao(EspaEventoSistemaPadrao espaEventoSistemaPadrao) {
        this.espaEventoSistemaPadrao = espaEventoSistemaPadrao;
    }

    public Collection<PgaiPgAssociaItem> getPgaiPgAssociaItemCollection() {
        return pgaiPgAssociaItemCollection;
    }

    public void setPgaiPgAssociaItemCollection(Collection<PgaiPgAssociaItem> pgaiPgAssociaItemCollection) {
        this.pgaiPgAssociaItemCollection = pgaiPgAssociaItemCollection;
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
        hash += (piteCodigo != null ? piteCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PitePgItem)) {
            return false;
        }
        PitePgItem other = (PitePgItem) object;
        if ((this.piteCodigo == null && other.piteCodigo != null) || (this.piteCodigo != null && !this.piteCodigo.equals(other.piteCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PitePgItem[piteCodigo=" + piteCodigo + "]";
    }

}
