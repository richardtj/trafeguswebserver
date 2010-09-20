/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "pite_pg_item", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PitePgItem.findAll", query = "SELECT p FROM PitePgItem p"),
    @NamedQuery(name = "PitePgItem.findByPiteCodigo", query = "SELECT p FROM PitePgItem p WHERE p.piteCodigo = :piteCodigo"),
    @NamedQuery(name = "PitePgItem.findByPiteDescricao", query = "SELECT p FROM PitePgItem p WHERE p.piteDescricao = :piteDescricao"),
    @NamedQuery(name = "PitePgItem.findByPiteDetalhe", query = "SELECT p FROM PitePgItem p WHERE p.piteDetalhe = :piteDetalhe"),
    @NamedQuery(name = "PitePgItem.findByPiteParametros", query = "SELECT p FROM PitePgItem p WHERE p.piteParametros = :piteParametros"),
    @NamedQuery(name = "PitePgItem.findByPiteDataCadastro", query = "SELECT p FROM PitePgItem p WHERE p.piteDataCadastro = :piteDataCadastro"),
    @NamedQuery(name = "PitePgItem.findByPiteCodigoGr", query = "SELECT p FROM PitePgItem p WHERE p.piteCodigoGr = :piteCodigoGr"),
    @NamedQuery(name = "PitePgItem.findByPiteImportado", query = "SELECT p FROM PitePgItem p WHERE p.piteImportado = :piteImportado")})
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
    @ManyToOne(fetch = FetchType.EAGER)
    private PtitPgTipoItem ptitPgTipoItem;
    @JoinColumn(name = "pite_ppad_codigo", referencedColumnName = "ppad_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PpadPerifericoPadrao ppadPerifericoPadrao;
    @JoinColumn(name = "pite_mpad_codigo", referencedColumnName = "mpad_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private MpadMacroPadrao mpadMacroPadrao;
    @JoinColumn(name = "pite_espa_codigo", referencedColumnName = "espa_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private EspaEventoSistemaPadrao espaEventoSistemaPadrao;
    @OneToMany(mappedBy = "pitePgItem", fetch = FetchType.EAGER)
    private List<PgaiPgAssociaItem> pgaiPgAssociaItemList;
    @OneToMany(mappedBy = "pitePgItem", fetch = FetchType.EAGER)
    private List<PipaPgItemParametro> pipaPgItemParametroList;

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

    public List<PgaiPgAssociaItem> getPgaiPgAssociaItemList() {
        return pgaiPgAssociaItemList;
    }

    public void setPgaiPgAssociaItemList(List<PgaiPgAssociaItem> pgaiPgAssociaItemList) {
        this.pgaiPgAssociaItemList = pgaiPgAssociaItemList;
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
