/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "ecom_envio_comando")
@NamedQueries({
    @NamedQuery(name = "EcomEnvioComando.findAll", query = "SELECT e FROM EcomEnvioComando e"),
    @NamedQuery(name = "EcomEnvioComando.findByEcomEnviCodigo", query = "SELECT e FROM EcomEnvioComando e WHERE e.ecomEnviCodigo = :ecomEnviCodigo")})
public class EcomEnvioComando implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ecom_envi_codigo")
    private Integer ecomEnviCodigo;
    @OneToMany(mappedBy = "ecomEnvioComando", fetch = FetchType.LAZY)
    private Collection<PcenParametroComandoEnvio> pcenParametroComandoEnvioCollection;
    @JoinColumn(name = "ecom_envi_codigo", referencedColumnName = "envi_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private EnviEnvio enviEnvio;
    @JoinColumn(name = "ecom_cpad_codigo", referencedColumnName = "cpad_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private CpadComandoPadrao cpadComandoPadrao;

    public EcomEnvioComando() {
    }

    public EcomEnvioComando(Integer ecomEnviCodigo) {
        this.ecomEnviCodigo = ecomEnviCodigo;
    }

    public Integer getEcomEnviCodigo() {
        return ecomEnviCodigo;
    }

    public void setEcomEnviCodigo(Integer ecomEnviCodigo) {
        this.ecomEnviCodigo = ecomEnviCodigo;
    }

    public Collection<PcenParametroComandoEnvio> getPcenParametroComandoEnvioCollection() {
        return pcenParametroComandoEnvioCollection;
    }

    public void setPcenParametroComandoEnvioCollection(Collection<PcenParametroComandoEnvio> pcenParametroComandoEnvioCollection) {
        this.pcenParametroComandoEnvioCollection = pcenParametroComandoEnvioCollection;
    }

    public EnviEnvio getEnviEnvio() {
        return enviEnvio;
    }

    public void setEnviEnvio(EnviEnvio enviEnvio) {
        this.enviEnvio = enviEnvio;
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
        hash += (ecomEnviCodigo != null ? ecomEnviCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EcomEnvioComando)) {
            return false;
        }
        EcomEnvioComando other = (EcomEnvioComando) object;
        if ((this.ecomEnviCodigo == null && other.ecomEnviCodigo != null) || (this.ecomEnviCodigo != null && !this.ecomEnviCodigo.equals(other.ecomEnviCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EcomEnvioComando[ecomEnviCodigo=" + ecomEnviCodigo + "]";
    }

}
