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
@Table(name = "urpe_ultimo_rec_periferico", catalog = "trafegus_transc", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"urpe_vtec_codigo", "urpe_term_numero_terminal", "urpe_eppa_codigo"})})
@NamedQueries({
    @NamedQuery(name = "UrpeUltimoRecPeriferico.findAll", query = "SELECT u FROM UrpeUltimoRecPeriferico u"),
    @NamedQuery(name = "UrpeUltimoRecPeriferico.findByUrpeCodigo", query = "SELECT u FROM UrpeUltimoRecPeriferico u WHERE u.urpeCodigo = :urpeCodigo"),
    @NamedQuery(name = "UrpeUltimoRecPeriferico.findByUrpeTermNumeroTerminal", query = "SELECT u FROM UrpeUltimoRecPeriferico u WHERE u.urpeTermNumeroTerminal = :urpeTermNumeroTerminal"),
    @NamedQuery(name = "UrpeUltimoRecPeriferico.findByUrpeValor", query = "SELECT u FROM UrpeUltimoRecPeriferico u WHERE u.urpeValor = :urpeValor"),
    @NamedQuery(name = "UrpeUltimoRecPeriferico.findByUrpeDataCadastro", query = "SELECT u FROM UrpeUltimoRecPeriferico u WHERE u.urpeDataCadastro = :urpeDataCadastro"),
    @NamedQuery(name = "UrpeUltimoRecPeriferico.findByUrpeCodigoGr", query = "SELECT u FROM UrpeUltimoRecPeriferico u WHERE u.urpeCodigoGr = :urpeCodigoGr"),
    @NamedQuery(name = "UrpeUltimoRecPeriferico.findByUrpeImportado", query = "SELECT u FROM UrpeUltimoRecPeriferico u WHERE u.urpeImportado = :urpeImportado")})
public class UrpeUltimoRecPeriferico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "urpe_codigo", nullable = false)
    private Integer urpeCodigo;
    @Column(name = "urpe_term_numero_terminal", length = 30)
    private String urpeTermNumeroTerminal;
    @Column(name = "urpe_valor", length = 50)
    private String urpeValor;
    @Column(name = "urpe_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date urpeDataCadastro;
    @Column(name = "urpe_codigo_gr")
    private Integer urpeCodigoGr;
    @Column(name = "urpe_importado")
    private Character urpeImportado;
    @JoinColumn(name = "urpe_vtec_codigo", referencedColumnName = "vtec_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private VtecVersaoTecnologia vtecVersaoTecnologia;
    @JoinColumn(name = "urpe_eppa_codigo", referencedColumnName = "eppa_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private EppaEventoPerifericoPadrao eppaEventoPerifericoPadrao;

    public UrpeUltimoRecPeriferico() {
    }

    public UrpeUltimoRecPeriferico(Integer urpeCodigo) {
        this.urpeCodigo = urpeCodigo;
    }

    public Integer getUrpeCodigo() {
        return urpeCodigo;
    }

    public void setUrpeCodigo(Integer urpeCodigo) {
        this.urpeCodigo = urpeCodigo;
    }

    public String getUrpeTermNumeroTerminal() {
        return urpeTermNumeroTerminal;
    }

    public void setUrpeTermNumeroTerminal(String urpeTermNumeroTerminal) {
        this.urpeTermNumeroTerminal = urpeTermNumeroTerminal;
    }

    public String getUrpeValor() {
        return urpeValor;
    }

    public void setUrpeValor(String urpeValor) {
        this.urpeValor = urpeValor;
    }

    public Date getUrpeDataCadastro() {
        return urpeDataCadastro;
    }

    public void setUrpeDataCadastro(Date urpeDataCadastro) {
        this.urpeDataCadastro = urpeDataCadastro;
    }

    public Integer getUrpeCodigoGr() {
        return urpeCodigoGr;
    }

    public void setUrpeCodigoGr(Integer urpeCodigoGr) {
        this.urpeCodigoGr = urpeCodigoGr;
    }

    public Character getUrpeImportado() {
        return urpeImportado;
    }

    public void setUrpeImportado(Character urpeImportado) {
        this.urpeImportado = urpeImportado;
    }

    public VtecVersaoTecnologia getVtecVersaoTecnologia() {
        return vtecVersaoTecnologia;
    }

    public void setVtecVersaoTecnologia(VtecVersaoTecnologia vtecVersaoTecnologia) {
        this.vtecVersaoTecnologia = vtecVersaoTecnologia;
    }

    public EppaEventoPerifericoPadrao getEppaEventoPerifericoPadrao() {
        return eppaEventoPerifericoPadrao;
    }

    public void setEppaEventoPerifericoPadrao(EppaEventoPerifericoPadrao eppaEventoPerifericoPadrao) {
        this.eppaEventoPerifericoPadrao = eppaEventoPerifericoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (urpeCodigo != null ? urpeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UrpeUltimoRecPeriferico)) {
            return false;
        }
        UrpeUltimoRecPeriferico other = (UrpeUltimoRecPeriferico) object;
        if ((this.urpeCodigo == null && other.urpeCodigo != null) || (this.urpeCodigo != null && !this.urpeCodigo.equals(other.urpeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.UrpeUltimoRecPeriferico[urpeCodigo=" + urpeCodigo + "]";
    }

}
