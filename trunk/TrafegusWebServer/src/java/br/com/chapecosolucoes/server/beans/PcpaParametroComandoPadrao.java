/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
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

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "pcpa_parametro_comando_padrao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PcpaParametroComandoPadrao.findAll", query = "SELECT p FROM PcpaParametroComandoPadrao p"),
    @NamedQuery(name = "PcpaParametroComandoPadrao.findByPcpaCodigo", query = "SELECT p FROM PcpaParametroComandoPadrao p WHERE p.pcpaCodigo = :pcpaCodigo"),
    @NamedQuery(name = "PcpaParametroComandoPadrao.findByPcpaSequencia", query = "SELECT p FROM PcpaParametroComandoPadrao p WHERE p.pcpaSequencia = :pcpaSequencia"),
    @NamedQuery(name = "PcpaParametroComandoPadrao.findByPcpaValor", query = "SELECT p FROM PcpaParametroComandoPadrao p WHERE p.pcpaValor = :pcpaValor")})
public class PcpaParametroComandoPadrao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pcpa_codigo", nullable = false)
    private Integer pcpaCodigo;
    @Column(name = "pcpa_sequencia")
    private Integer pcpaSequencia;
    @Column(name = "pcpa_valor", length = 50)
    private String pcpaValor;
    @JoinColumn(name = "pcpa_tval_codigo", referencedColumnName = "tval_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TvalTipoValor tvalTipoValor;
    @JoinColumn(name = "pcpa_cpad_codigo", referencedColumnName = "cpad_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private CpadComandoPadrao cpadComandoPadrao;

    public PcpaParametroComandoPadrao() {
    }

    public PcpaParametroComandoPadrao(Integer pcpaCodigo) {
        this.pcpaCodigo = pcpaCodigo;
    }

    public Integer getPcpaCodigo() {
        return pcpaCodigo;
    }

    public void setPcpaCodigo(Integer pcpaCodigo) {
        this.pcpaCodigo = pcpaCodigo;
    }

    public Integer getPcpaSequencia() {
        return pcpaSequencia;
    }

    public void setPcpaSequencia(Integer pcpaSequencia) {
        this.pcpaSequencia = pcpaSequencia;
    }

    public String getPcpaValor() {
        return pcpaValor;
    }

    public void setPcpaValor(String pcpaValor) {
        this.pcpaValor = pcpaValor;
    }

    public TvalTipoValor getTvalTipoValor() {
        return tvalTipoValor;
    }

    public void setTvalTipoValor(TvalTipoValor tvalTipoValor) {
        this.tvalTipoValor = tvalTipoValor;
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
        hash += (pcpaCodigo != null ? pcpaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcpaParametroComandoPadrao)) {
            return false;
        }
        PcpaParametroComandoPadrao other = (PcpaParametroComandoPadrao) object;
        if ((this.pcpaCodigo == null && other.pcpaCodigo != null) || (this.pcpaCodigo != null && !this.pcpaCodigo.equals(other.pcpaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PcpaParametroComandoPadrao[pcpaCodigo=" + pcpaCodigo + "]";
    }

}
