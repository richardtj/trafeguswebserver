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
@Table(name = "tspg_transp_segur_plano_geren")
@NamedQueries({
    @NamedQuery(name = "TspgTranspSegurPlanoGeren.findAll", query = "SELECT t FROM TspgTranspSegurPlanoGeren t"),
    @NamedQuery(name = "TspgTranspSegurPlanoGeren.findByTspgCodigo", query = "SELECT t FROM TspgTranspSegurPlanoGeren t WHERE t.tspgCodigo = :tspgCodigo"),
    @NamedQuery(name = "TspgTranspSegurPlanoGeren.findByTspgDataCadastro", query = "SELECT t FROM TspgTranspSegurPlanoGeren t WHERE t.tspgDataCadastro = :tspgDataCadastro"),
    @NamedQuery(name = "TspgTranspSegurPlanoGeren.findByTspgCodigoGr", query = "SELECT t FROM TspgTranspSegurPlanoGeren t WHERE t.tspgCodigoGr = :tspgCodigoGr"),
    @NamedQuery(name = "TspgTranspSegurPlanoGeren.findByTspgImportado", query = "SELECT t FROM TspgTranspSegurPlanoGeren t WHERE t.tspgImportado = :tspgImportado")})
public class TspgTranspSegurPlanoGeren implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tspg_codigo")
    private Integer tspgCodigo;
    @Column(name = "tspg_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tspgDataCadastro;
    @Column(name = "tspg_codigo_gr")
    private Integer tspgCodigoGr;
    @Column(name = "tspg_importado")
    private Character tspgImportado;
    @JoinColumn(name = "tspg_pess_oras_codigo", referencedColumnName = "tran_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TranTransportador tranTransportador;
    @JoinColumn(name = "tspg_segu_pjur_pess_oras_codigo", referencedColumnName = "segu_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private SeguSeguradora seguSeguradora;
    @JoinColumn(name = "tspg_pgpg_codigo", referencedColumnName = "pgpg_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PgpgPg pgpgPg;

    public TspgTranspSegurPlanoGeren() {
    }

    public TspgTranspSegurPlanoGeren(Integer tspgCodigo) {
        this.tspgCodigo = tspgCodigo;
    }

    public Integer getTspgCodigo() {
        return tspgCodigo;
    }

    public void setTspgCodigo(Integer tspgCodigo) {
        this.tspgCodigo = tspgCodigo;
    }

    public Date getTspgDataCadastro() {
        return tspgDataCadastro;
    }

    public void setTspgDataCadastro(Date tspgDataCadastro) {
        this.tspgDataCadastro = tspgDataCadastro;
    }

    public Integer getTspgCodigoGr() {
        return tspgCodigoGr;
    }

    public void setTspgCodigoGr(Integer tspgCodigoGr) {
        this.tspgCodigoGr = tspgCodigoGr;
    }

    public Character getTspgImportado() {
        return tspgImportado;
    }

    public void setTspgImportado(Character tspgImportado) {
        this.tspgImportado = tspgImportado;
    }

    public TranTransportador getTranTransportador() {
        return tranTransportador;
    }

    public void setTranTransportador(TranTransportador tranTransportador) {
        this.tranTransportador = tranTransportador;
    }

    public SeguSeguradora getSeguSeguradora() {
        return seguSeguradora;
    }

    public void setSeguSeguradora(SeguSeguradora seguSeguradora) {
        this.seguSeguradora = seguSeguradora;
    }

    public PgpgPg getPgpgPg() {
        return pgpgPg;
    }

    public void setPgpgPg(PgpgPg pgpgPg) {
        this.pgpgPg = pgpgPg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tspgCodigo != null ? tspgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TspgTranspSegurPlanoGeren)) {
            return false;
        }
        TspgTranspSegurPlanoGeren other = (TspgTranspSegurPlanoGeren) object;
        if ((this.tspgCodigo == null && other.tspgCodigo != null) || (this.tspgCodigo != null && !this.tspgCodigo.equals(other.tspgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TspgTranspSegurPlanoGeren[tspgCodigo=" + tspgCodigo + "]";
    }

}
