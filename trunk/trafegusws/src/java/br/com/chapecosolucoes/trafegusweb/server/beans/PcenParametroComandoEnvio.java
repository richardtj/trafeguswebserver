/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

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
@Table(name = "pcen_parametro_comando_envio")
@NamedQueries({
    @NamedQuery(name = "PcenParametroComandoEnvio.findAll", query = "SELECT p FROM PcenParametroComandoEnvio p"),
    @NamedQuery(name = "PcenParametroComandoEnvio.findByPcenCodigo", query = "SELECT p FROM PcenParametroComandoEnvio p WHERE p.pcenCodigo = :pcenCodigo"),
    @NamedQuery(name = "PcenParametroComandoEnvio.findByPcenSequencia", query = "SELECT p FROM PcenParametroComandoEnvio p WHERE p.pcenSequencia = :pcenSequencia"),
    @NamedQuery(name = "PcenParametroComandoEnvio.findByPcenValor", query = "SELECT p FROM PcenParametroComandoEnvio p WHERE p.pcenValor = :pcenValor")})
public class PcenParametroComandoEnvio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pcen_codigo")
    private Integer pcenCodigo;
    @Column(name = "pcen_sequencia")
    private Integer pcenSequencia;
    @Column(name = "pcen_valor")
    private String pcenValor;
    @JoinColumn(name = "pcen_envi_codigo", referencedColumnName = "ecom_envi_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private EcomEnvioComando ecomEnvioComando;

    public PcenParametroComandoEnvio() {
    }

    public PcenParametroComandoEnvio(Integer pcenCodigo) {
        this.pcenCodigo = pcenCodigo;
    }

    public Integer getPcenCodigo() {
        return pcenCodigo;
    }

    public void setPcenCodigo(Integer pcenCodigo) {
        this.pcenCodigo = pcenCodigo;
    }

    public Integer getPcenSequencia() {
        return pcenSequencia;
    }

    public void setPcenSequencia(Integer pcenSequencia) {
        this.pcenSequencia = pcenSequencia;
    }

    public String getPcenValor() {
        return pcenValor;
    }

    public void setPcenValor(String pcenValor) {
        this.pcenValor = pcenValor;
    }

    public EcomEnvioComando getEcomEnvioComando() {
        return ecomEnvioComando;
    }

    public void setEcomEnvioComando(EcomEnvioComando ecomEnvioComando) {
        this.ecomEnvioComando = ecomEnvioComando;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcenCodigo != null ? pcenCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcenParametroComandoEnvio)) {
            return false;
        }
        PcenParametroComandoEnvio other = (PcenParametroComandoEnvio) object;
        if ((this.pcenCodigo == null && other.pcenCodigo != null) || (this.pcenCodigo != null && !this.pcenCodigo.equals(other.pcenCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PcenParametroComandoEnvio[pcenCodigo=" + pcenCodigo + "]";
    }

}
