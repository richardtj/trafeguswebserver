/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "cvte_comando_versao_tecnologi", catalog = "trafegus_transc", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cvte_vtec_codigo", "cvte_cpad_codigo"})})
@NamedQueries({
    @NamedQuery(name = "CvteComandoVersaoTecnologi.findAll", query = "SELECT c FROM CvteComandoVersaoTecnologi c"),
    @NamedQuery(name = "CvteComandoVersaoTecnologi.findByCvteCodigo", query = "SELECT c FROM CvteComandoVersaoTecnologi c WHERE c.cvteCodigo = :cvteCodigo"),
    @NamedQuery(name = "CvteComandoVersaoTecnologi.findByCvteDataCadastro", query = "SELECT c FROM CvteComandoVersaoTecnologi c WHERE c.cvteDataCadastro = :cvteDataCadastro"),
    @NamedQuery(name = "CvteComandoVersaoTecnologi.findByCvteCodigoGr", query = "SELECT c FROM CvteComandoVersaoTecnologi c WHERE c.cvteCodigoGr = :cvteCodigoGr"),
    @NamedQuery(name = "CvteComandoVersaoTecnologi.findByCvteImportado", query = "SELECT c FROM CvteComandoVersaoTecnologi c WHERE c.cvteImportado = :cvteImportado")})
public class CvteComandoVersaoTecnologi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cvte_codigo", nullable = false)
    private Integer cvteCodigo;
    @Column(name = "cvte_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cvteDataCadastro;
    @Column(name = "cvte_codigo_gr")
    private Integer cvteCodigoGr;
    @Column(name = "cvte_importado")
    private Character cvteImportado;
    @JoinColumn(name = "cvte_vtec_codigo", referencedColumnName = "vtec_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private VtecVersaoTecnologia vtecVersaoTecnologia;
    @JoinColumn(name = "cvte_cpad_codigo", referencedColumnName = "cpad_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private CpadComandoPadrao cpadComandoPadrao;

    public CvteComandoVersaoTecnologi() {
    }

    public CvteComandoVersaoTecnologi(Integer cvteCodigo) {
        this.cvteCodigo = cvteCodigo;
    }

    public Integer getCvteCodigo() {
        return cvteCodigo;
    }

    public void setCvteCodigo(Integer cvteCodigo) {
        this.cvteCodigo = cvteCodigo;
    }

    public Date getCvteDataCadastro() {
        return cvteDataCadastro;
    }

    public void setCvteDataCadastro(Date cvteDataCadastro) {
        this.cvteDataCadastro = cvteDataCadastro;
    }

    public Integer getCvteCodigoGr() {
        return cvteCodigoGr;
    }

    public void setCvteCodigoGr(Integer cvteCodigoGr) {
        this.cvteCodigoGr = cvteCodigoGr;
    }

    public Character getCvteImportado() {
        return cvteImportado;
    }

    public void setCvteImportado(Character cvteImportado) {
        this.cvteImportado = cvteImportado;
    }

    public VtecVersaoTecnologia getVtecVersaoTecnologia() {
        return vtecVersaoTecnologia;
    }

    public void setVtecVersaoTecnologia(VtecVersaoTecnologia vtecVersaoTecnologia) {
        this.vtecVersaoTecnologia = vtecVersaoTecnologia;
    }

    public CpadComandoPadrao getCpadComandoPadrao() {
        return cpadComandoPadrao;
    }

    public void setCpadComandoPadrao(CpadComandoPadrao cpadComandoPadrao) {
        this.cpadComandoPadrao = cpadComandoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cvteCodigo != null ? cvteCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CvteComandoVersaoTecnologi)) {
            return false;
        }
        CvteComandoVersaoTecnologi other = (CvteComandoVersaoTecnologi) object;
        if ((this.cvteCodigo == null && other.cvteCodigo != null) || (this.cvteCodigo != null && !this.cvteCodigo.equals(other.cvteCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.CvteComandoVersaoTecnologi[cvteCodigo=" + cvteCodigo + "]";
    }

}
