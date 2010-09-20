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
@Table(name = "ppin_periferico_padrao_instal", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PpinPerifericoPadraoInstal.findAll", query = "SELECT p FROM PpinPerifericoPadraoInstal p"),
    @NamedQuery(name = "PpinPerifericoPadraoInstal.findByPpinCodigo", query = "SELECT p FROM PpinPerifericoPadraoInstal p WHERE p.ppinCodigo = :ppinCodigo"),
    @NamedQuery(name = "PpinPerifericoPadraoInstal.findByPpinDataCadastro", query = "SELECT p FROM PpinPerifericoPadraoInstal p WHERE p.ppinDataCadastro = :ppinDataCadastro"),
    @NamedQuery(name = "PpinPerifericoPadraoInstal.findByPpinCodigoGr", query = "SELECT p FROM PpinPerifericoPadraoInstal p WHERE p.ppinCodigoGr = :ppinCodigoGr"),
    @NamedQuery(name = "PpinPerifericoPadraoInstal.findByPpinImportado", query = "SELECT p FROM PpinPerifericoPadraoInstal p WHERE p.ppinImportado = :ppinImportado")})
public class PpinPerifericoPadraoInstal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ppin_codigo", nullable = false)
    private Integer ppinCodigo;
    @Column(name = "ppin_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ppinDataCadastro;
    @Column(name = "ppin_codigo_gr")
    private Integer ppinCodigoGr;
    @Column(name = "ppin_importado")
    private Character ppinImportado;
    @OneToMany(mappedBy = "ppinPerifericoPadraoInstal", fetch = FetchType.EAGER)
    private List<PperProblemaPeriferico> pperProblemaPerifericoList;
    @JoinColumn(name = "ppin_term_codigo", referencedColumnName = "term_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TermTerminal termTerminal;
    @JoinColumn(name = "ppin_ppad_codigo", referencedColumnName = "ppad_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PpadPerifericoPadrao ppadPerifericoPadrao;

    public PpinPerifericoPadraoInstal() {
    }

    public PpinPerifericoPadraoInstal(Integer ppinCodigo) {
        this.ppinCodigo = ppinCodigo;
    }

    public Integer getPpinCodigo() {
        return ppinCodigo;
    }

    public void setPpinCodigo(Integer ppinCodigo) {
        this.ppinCodigo = ppinCodigo;
    }

    public Date getPpinDataCadastro() {
        return ppinDataCadastro;
    }

    public void setPpinDataCadastro(Date ppinDataCadastro) {
        this.ppinDataCadastro = ppinDataCadastro;
    }

    public Integer getPpinCodigoGr() {
        return ppinCodigoGr;
    }

    public void setPpinCodigoGr(Integer ppinCodigoGr) {
        this.ppinCodigoGr = ppinCodigoGr;
    }

    public Character getPpinImportado() {
        return ppinImportado;
    }

    public void setPpinImportado(Character ppinImportado) {
        this.ppinImportado = ppinImportado;
    }

    public List<PperProblemaPeriferico> getPperProblemaPerifericoList() {
        return pperProblemaPerifericoList;
    }

    public void setPperProblemaPerifericoList(List<PperProblemaPeriferico> pperProblemaPerifericoList) {
        this.pperProblemaPerifericoList = pperProblemaPerifericoList;
    }

    public TermTerminal getTermTerminal() {
        return termTerminal;
    }

    public void setTermTerminal(TermTerminal termTerminal) {
        this.termTerminal = termTerminal;
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
        hash += (ppinCodigo != null ? ppinCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PpinPerifericoPadraoInstal)) {
            return false;
        }
        PpinPerifericoPadraoInstal other = (PpinPerifericoPadraoInstal) object;
        if ((this.ppinCodigo == null && other.ppinCodigo != null) || (this.ppinCodigo != null && !this.ppinCodigo.equals(other.ppinCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PpinPerifericoPadraoInstal[ppinCodigo=" + ppinCodigo + "]";
    }

}
