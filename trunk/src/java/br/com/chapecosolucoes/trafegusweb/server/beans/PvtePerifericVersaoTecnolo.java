/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "pvte_periferic_versao_tecnolo", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PvtePerifericVersaoTecnolo.findAll", query = "SELECT p FROM PvtePerifericVersaoTecnolo p"),
    @NamedQuery(name = "PvtePerifericVersaoTecnolo.findByPvteCodigo", query = "SELECT p FROM PvtePerifericVersaoTecnolo p WHERE p.pvteCodigo = :pvteCodigo"),
    @NamedQuery(name = "PvtePerifericVersaoTecnolo.findByPvteDataCadastro", query = "SELECT p FROM PvtePerifericVersaoTecnolo p WHERE p.pvteDataCadastro = :pvteDataCadastro"),
    @NamedQuery(name = "PvtePerifericVersaoTecnolo.findByPvteCodigoGr", query = "SELECT p FROM PvtePerifericVersaoTecnolo p WHERE p.pvteCodigoGr = :pvteCodigoGr"),
    @NamedQuery(name = "PvtePerifericVersaoTecnolo.findByPvteImportado", query = "SELECT p FROM PvtePerifericVersaoTecnolo p WHERE p.pvteImportado = :pvteImportado")})
public class PvtePerifericVersaoTecnolo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pvte_codigo", nullable = false)
    private Integer pvteCodigo;
    @Column(name = "pvte_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pvteDataCadastro;
    @Column(name = "pvte_codigo_gr")
    private Integer pvteCodigoGr;
    @Column(name = "pvte_importado")
    private Character pvteImportado;
    @JoinColumn(name = "pvte_vtec_codigo", referencedColumnName = "vtec_codigo")
    @ManyToOne
    private VtecVersaoTecnologia vtecVersaoTecnologia;
    @JoinColumn(name = "pvte_ppad_codigo", referencedColumnName = "ppad_codigo")
    @ManyToOne
    private PpadPerifericoPadrao ppadPerifericoPadrao;

    public PvtePerifericVersaoTecnolo() {
    }

    public PvtePerifericVersaoTecnolo(Integer pvteCodigo) {
        this.pvteCodigo = pvteCodigo;
    }

    public Integer getPvteCodigo() {
        return pvteCodigo;
    }

    public void setPvteCodigo(Integer pvteCodigo) {
        this.pvteCodigo = pvteCodigo;
    }

    public Date getPvteDataCadastro() {
        return pvteDataCadastro;
    }

    public void setPvteDataCadastro(Date pvteDataCadastro) {
        this.pvteDataCadastro = pvteDataCadastro;
    }

    public Integer getPvteCodigoGr() {
        return pvteCodigoGr;
    }

    public void setPvteCodigoGr(Integer pvteCodigoGr) {
        this.pvteCodigoGr = pvteCodigoGr;
    }

    public Character getPvteImportado() {
        return pvteImportado;
    }

    public void setPvteImportado(Character pvteImportado) {
        this.pvteImportado = pvteImportado;
    }

    public VtecVersaoTecnologia getVtecVersaoTecnologia() {
        return vtecVersaoTecnologia;
    }

    public void setVtecVersaoTecnologia(VtecVersaoTecnologia vtecVersaoTecnologia) {
        this.vtecVersaoTecnologia = vtecVersaoTecnologia;
    }

    public PpadPerifericoPadrao getPpadPerifericoPadrao() {
        return ppadPerifericoPadrao;
    }

    public void setPpadPerifericoPadrao(PpadPerifericoPadrao ppadPerifericoPadrao) {
        this.ppadPerifericoPadrao = ppadPerifericoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pvteCodigo != null ? pvteCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtePerifericVersaoTecnolo)) {
            return false;
        }
        PvtePerifericVersaoTecnolo other = (PvtePerifericVersaoTecnolo) object;
        if ((this.pvteCodigo == null && other.pvteCodigo != null) || (this.pvteCodigo != null && !this.pvteCodigo.equals(other.pvteCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PvtePerifericVersaoTecnolo[pvteCodigo=" + pvteCodigo + "]";
    }

}
