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
@Table(name = "espg_embarc_segur_plano_geren")
@NamedQueries({
    @NamedQuery(name = "EspgEmbarcSegurPlanoGeren.findAll", query = "SELECT e FROM EspgEmbarcSegurPlanoGeren e"),
    @NamedQuery(name = "EspgEmbarcSegurPlanoGeren.findByEspgCodigo", query = "SELECT e FROM EspgEmbarcSegurPlanoGeren e WHERE e.espgCodigo = :espgCodigo"),
    @NamedQuery(name = "EspgEmbarcSegurPlanoGeren.findByEspgDataCadastro", query = "SELECT e FROM EspgEmbarcSegurPlanoGeren e WHERE e.espgDataCadastro = :espgDataCadastro"),
    @NamedQuery(name = "EspgEmbarcSegurPlanoGeren.findByEspgCodigoGr", query = "SELECT e FROM EspgEmbarcSegurPlanoGeren e WHERE e.espgCodigoGr = :espgCodigoGr"),
    @NamedQuery(name = "EspgEmbarcSegurPlanoGeren.findByEspgImportado", query = "SELECT e FROM EspgEmbarcSegurPlanoGeren e WHERE e.espgImportado = :espgImportado")})
public class EspgEmbarcSegurPlanoGeren implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "espg_codigo")
    private Integer espgCodigo;
    @Column(name = "espg_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date espgDataCadastro;
    @Column(name = "espg_codigo_gr")
    private Integer espgCodigoGr;
    @Column(name = "espg_importado")
    private Character espgImportado;
    @JoinColumn(name = "espg_segu_pjur_pess_oras_codigo", referencedColumnName = "segu_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private SeguSeguradora seguSeguradora;
    @JoinColumn(name = "espg_pgpg_codigo", referencedColumnName = "pgpg_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PgpgPg pgpgPg;
    @JoinColumn(name = "espg_emba_pjur_pess_oras_codigo", referencedColumnName = "emba_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private EmbaEmbarcador embaEmbarcador;

    public EspgEmbarcSegurPlanoGeren() {
    }

    public EspgEmbarcSegurPlanoGeren(Integer espgCodigo) {
        this.espgCodigo = espgCodigo;
    }

    public Integer getEspgCodigo() {
        return espgCodigo;
    }

    public void setEspgCodigo(Integer espgCodigo) {
        this.espgCodigo = espgCodigo;
    }

    public Date getEspgDataCadastro() {
        return espgDataCadastro;
    }

    public void setEspgDataCadastro(Date espgDataCadastro) {
        this.espgDataCadastro = espgDataCadastro;
    }

    public Integer getEspgCodigoGr() {
        return espgCodigoGr;
    }

    public void setEspgCodigoGr(Integer espgCodigoGr) {
        this.espgCodigoGr = espgCodigoGr;
    }

    public Character getEspgImportado() {
        return espgImportado;
    }

    public void setEspgImportado(Character espgImportado) {
        this.espgImportado = espgImportado;
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

    public EmbaEmbarcador getEmbaEmbarcador() {
        return embaEmbarcador;
    }

    public void setEmbaEmbarcador(EmbaEmbarcador embaEmbarcador) {
        this.embaEmbarcador = embaEmbarcador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (espgCodigo != null ? espgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspgEmbarcSegurPlanoGeren)) {
            return false;
        }
        EspgEmbarcSegurPlanoGeren other = (EspgEmbarcSegurPlanoGeren) object;
        if ((this.espgCodigo == null && other.espgCodigo != null) || (this.espgCodigo != null && !this.espgCodigo.equals(other.espgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EspgEmbarcSegurPlanoGeren[espgCodigo=" + espgCodigo + "]";
    }

}
