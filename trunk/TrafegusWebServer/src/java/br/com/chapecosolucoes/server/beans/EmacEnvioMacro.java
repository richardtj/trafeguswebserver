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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "emac_envio_macro", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EmacEnvioMacro.findAll", query = "SELECT e FROM EmacEnvioMacro e"),
    @NamedQuery(name = "EmacEnvioMacro.findByEmacEnviCodigo", query = "SELECT e FROM EmacEnvioMacro e WHERE e.emacEnviCodigo = :emacEnviCodigo"),
    @NamedQuery(name = "EmacEnvioMacro.findByEmacNumero", query = "SELECT e FROM EmacEnvioMacro e WHERE e.emacNumero = :emacNumero"),
    @NamedQuery(name = "EmacEnvioMacro.findByEmacTexto", query = "SELECT e FROM EmacEnvioMacro e WHERE e.emacTexto = :emacTexto"),
    @NamedQuery(name = "EmacEnvioMacro.findByEmacMascara", query = "SELECT e FROM EmacEnvioMacro e WHERE e.emacMascara = :emacMascara")})
public class EmacEnvioMacro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emac_envi_codigo", nullable = false)
    private Integer emacEnviCodigo;
    @Column(name = "emac_numero", length = 10)
    private String emacNumero;
    @Column(name = "emac_texto", length = 500)
    private String emacTexto;
    @Column(name = "emac_mascara", length = 500)
    private String emacMascara;
    @JoinColumn(name = "emac_mpad_codigo", referencedColumnName = "mpad_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private MpadMacroPadrao mpadMacroPadrao;
    @JoinColumn(name = "emac_envi_codigo", referencedColumnName = "envi_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private EnviEnvio enviEnvio;

    public EmacEnvioMacro() {
    }

    public EmacEnvioMacro(Integer emacEnviCodigo) {
        this.emacEnviCodigo = emacEnviCodigo;
    }

    public Integer getEmacEnviCodigo() {
        return emacEnviCodigo;
    }

    public void setEmacEnviCodigo(Integer emacEnviCodigo) {
        this.emacEnviCodigo = emacEnviCodigo;
    }

    public String getEmacNumero() {
        return emacNumero;
    }

    public void setEmacNumero(String emacNumero) {
        this.emacNumero = emacNumero;
    }

    public String getEmacTexto() {
        return emacTexto;
    }

    public void setEmacTexto(String emacTexto) {
        this.emacTexto = emacTexto;
    }

    public String getEmacMascara() {
        return emacMascara;
    }

    public void setEmacMascara(String emacMascara) {
        this.emacMascara = emacMascara;
    }

    public MpadMacroPadrao getMpadMacroPadrao() {
        return mpadMacroPadrao;
    }

    public void setMpadMacroPadrao(MpadMacroPadrao mpadMacroPadrao) {
        this.mpadMacroPadrao = mpadMacroPadrao;
    }

    public EnviEnvio getEnviEnvio() {
        return enviEnvio;
    }

    public void setEnviEnvio(EnviEnvio enviEnvio) {
        this.enviEnvio = enviEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emacEnviCodigo != null ? emacEnviCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmacEnvioMacro)) {
            return false;
        }
        EmacEnvioMacro other = (EmacEnvioMacro) object;
        if ((this.emacEnviCodigo == null && other.emacEnviCodigo != null) || (this.emacEnviCodigo != null && !this.emacEnviCodigo.equals(other.emacEnviCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.EmacEnvioMacro[emacEnviCodigo=" + emacEnviCodigo + "]";
    }

}
