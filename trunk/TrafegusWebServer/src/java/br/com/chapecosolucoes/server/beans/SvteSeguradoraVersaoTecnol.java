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

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "svte_seguradora_versao_tecnol", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SvteSeguradoraVersaoTecnol.findAll", query = "SELECT s FROM SvteSeguradoraVersaoTecnol s"),
    @NamedQuery(name = "SvteSeguradoraVersaoTecnol.findBySvteCodigo", query = "SELECT s FROM SvteSeguradoraVersaoTecnol s WHERE s.svteCodigo = :svteCodigo"),
    @NamedQuery(name = "SvteSeguradoraVersaoTecnol.findBySvteDataCadastro", query = "SELECT s FROM SvteSeguradoraVersaoTecnol s WHERE s.svteDataCadastro = :svteDataCadastro"),
    @NamedQuery(name = "SvteSeguradoraVersaoTecnol.findBySvteCodigoGr", query = "SELECT s FROM SvteSeguradoraVersaoTecnol s WHERE s.svteCodigoGr = :svteCodigoGr"),
    @NamedQuery(name = "SvteSeguradoraVersaoTecnol.findBySvteImportado", query = "SELECT s FROM SvteSeguradoraVersaoTecnol s WHERE s.svteImportado = :svteImportado")})
public class SvteSeguradoraVersaoTecnol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "svte_codigo", nullable = false)
    private Integer svteCodigo;
    @Column(name = "svte_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date svteDataCadastro;
    @Column(name = "svte_codigo_gr")
    private Integer svteCodigoGr;
    @Column(name = "svte_importado")
    private Character svteImportado;
    @JoinColumn(name = "svte_vtec_codigo", referencedColumnName = "vtec_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private VtecVersaoTecnologia vtecVersaoTecnologia;
    @JoinColumn(name = "svte_ttra_codigo", referencedColumnName = "ttra_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TtraTipoTransporte ttraTipoTransporte;
    @JoinColumn(name = "svte_segu_pjur_pess_oras_codigo", referencedColumnName = "segu_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private SeguSeguradora seguSeguradora;

    public SvteSeguradoraVersaoTecnol() {
    }

    public SvteSeguradoraVersaoTecnol(Integer svteCodigo) {
        this.svteCodigo = svteCodigo;
    }

    public Integer getSvteCodigo() {
        return svteCodigo;
    }

    public void setSvteCodigo(Integer svteCodigo) {
        this.svteCodigo = svteCodigo;
    }

    public Date getSvteDataCadastro() {
        return svteDataCadastro;
    }

    public void setSvteDataCadastro(Date svteDataCadastro) {
        this.svteDataCadastro = svteDataCadastro;
    }

    public Integer getSvteCodigoGr() {
        return svteCodigoGr;
    }

    public void setSvteCodigoGr(Integer svteCodigoGr) {
        this.svteCodigoGr = svteCodigoGr;
    }

    public Character getSvteImportado() {
        return svteImportado;
    }

    public void setSvteImportado(Character svteImportado) {
        this.svteImportado = svteImportado;
    }

    public VtecVersaoTecnologia getVtecVersaoTecnologia() {
        return vtecVersaoTecnologia;
    }

    public void setVtecVersaoTecnologia(VtecVersaoTecnologia vtecVersaoTecnologia) {
        this.vtecVersaoTecnologia = vtecVersaoTecnologia;
    }

    public TtraTipoTransporte getTtraTipoTransporte() {
        return ttraTipoTransporte;
    }

    public void setTtraTipoTransporte(TtraTipoTransporte ttraTipoTransporte) {
        this.ttraTipoTransporte = ttraTipoTransporte;
    }

    public SeguSeguradora getSeguSeguradora() {
        return seguSeguradora;
    }

    public void setSeguSeguradora(SeguSeguradora seguSeguradora) {
        this.seguSeguradora = seguSeguradora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svteCodigo != null ? svteCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvteSeguradoraVersaoTecnol)) {
            return false;
        }
        SvteSeguradoraVersaoTecnol other = (SvteSeguradoraVersaoTecnol) object;
        if ((this.svteCodigo == null && other.svteCodigo != null) || (this.svteCodigo != null && !this.svteCodigo.equals(other.svteCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.SvteSeguradoraVersaoTecnol[svteCodigo=" + svteCodigo + "]";
    }

}
