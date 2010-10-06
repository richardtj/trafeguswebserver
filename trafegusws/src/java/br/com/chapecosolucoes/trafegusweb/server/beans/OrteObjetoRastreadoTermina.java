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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "orte_objeto_rastreado_termina")
@NamedQueries({
    @NamedQuery(name = "OrteObjetoRastreadoTermina.findAll", query = "SELECT o FROM OrteObjetoRastreadoTermina o"),
    @NamedQuery(name = "OrteObjetoRastreadoTermina.findByOrteCodigo", query = "SELECT o FROM OrteObjetoRastreadoTermina o WHERE o.orteCodigo = :orteCodigo"),
    @NamedQuery(name = "OrteObjetoRastreadoTermina.findByOrteSequencia", query = "SELECT o FROM OrteObjetoRastreadoTermina o WHERE o.orteSequencia = :orteSequencia"),
    @NamedQuery(name = "OrteObjetoRastreadoTermina.findByOrteDataCadastro", query = "SELECT o FROM OrteObjetoRastreadoTermina o WHERE o.orteDataCadastro = :orteDataCadastro"),
    @NamedQuery(name = "OrteObjetoRastreadoTermina.findByOrteCodigoGr", query = "SELECT o FROM OrteObjetoRastreadoTermina o WHERE o.orteCodigoGr = :orteCodigoGr"),
    @NamedQuery(name = "OrteObjetoRastreadoTermina.findByOrteImportado", query = "SELECT o FROM OrteObjetoRastreadoTermina o WHERE o.orteImportado = :orteImportado")})
public class OrteObjetoRastreadoTermina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "orte_codigo")
    private Integer orteCodigo;
    @Column(name = "orte_sequencia")
    private String orteSequencia;
    @Column(name = "orte_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orteDataCadastro;
    @Column(name = "orte_codigo_gr")
    private Integer orteCodigoGr;
    @Column(name = "orte_importado")
    private Character orteImportado;
    @JoinColumn(name = "orte_term_codigo", referencedColumnName = "term_codigo")
    @OneToOne(fetch = FetchType.LAZY)
    private TermTerminal termTerminal;
    @JoinColumn(name = "orte_oras_codigo", referencedColumnName = "oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrasObjetoRastreado orasObjetoRastreado;

    public OrteObjetoRastreadoTermina() {
    }

    public OrteObjetoRastreadoTermina(Integer orteCodigo) {
        this.orteCodigo = orteCodigo;
    }

    public Integer getOrteCodigo() {
        return orteCodigo;
    }

    public void setOrteCodigo(Integer orteCodigo) {
        this.orteCodigo = orteCodigo;
    }

    public String getOrteSequencia() {
        return orteSequencia;
    }

    public void setOrteSequencia(String orteSequencia) {
        this.orteSequencia = orteSequencia;
    }

    public Date getOrteDataCadastro() {
        return orteDataCadastro;
    }

    public void setOrteDataCadastro(Date orteDataCadastro) {
        this.orteDataCadastro = orteDataCadastro;
    }

    public Integer getOrteCodigoGr() {
        return orteCodigoGr;
    }

    public void setOrteCodigoGr(Integer orteCodigoGr) {
        this.orteCodigoGr = orteCodigoGr;
    }

    public Character getOrteImportado() {
        return orteImportado;
    }

    public void setOrteImportado(Character orteImportado) {
        this.orteImportado = orteImportado;
    }

    public TermTerminal getTermTerminal() {
        return termTerminal;
    }

    public void setTermTerminal(TermTerminal termTerminal) {
        this.termTerminal = termTerminal;
    }

    public OrasObjetoRastreado getOrasObjetoRastreado() {
        return orasObjetoRastreado;
    }

    public void setOrasObjetoRastreado(OrasObjetoRastreado orasObjetoRastreado) {
        this.orasObjetoRastreado = orasObjetoRastreado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orteCodigo != null ? orteCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrteObjetoRastreadoTermina)) {
            return false;
        }
        OrteObjetoRastreadoTermina other = (OrteObjetoRastreadoTermina) object;
        if ((this.orteCodigo == null && other.orteCodigo != null) || (this.orteCodigo != null && !this.orteCodigo.equals(other.orteCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.OrteObjetoRastreadoTermina[orteCodigo=" + orteCodigo + "]";
    }

}
