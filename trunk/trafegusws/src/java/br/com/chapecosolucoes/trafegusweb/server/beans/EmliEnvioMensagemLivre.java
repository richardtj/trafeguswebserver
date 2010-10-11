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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "emli_envio_mensagem_livre")
@NamedQueries({
    @NamedQuery(name = "EmliEnvioMensagemLivre.findAll", query = "SELECT e FROM EmliEnvioMensagemLivre e"),
    @NamedQuery(name = "EmliEnvioMensagemLivre.findByEmliEnviCodigo", query = "SELECT e FROM EmliEnvioMensagemLivre e WHERE e.emliEnviCodigo = :emliEnviCodigo"),
    @NamedQuery(name = "EmliEnvioMensagemLivre.findByEmliTexto", query = "SELECT e FROM EmliEnvioMensagemLivre e WHERE e.emliTexto = :emliTexto")})
public class EmliEnvioMensagemLivre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emli_envi_codigo")
    private Integer emliEnviCodigo;
    @Column(name = "emli_texto")
    private String emliTexto;
    @JoinColumn(name = "emli_envi_codigo", referencedColumnName = "envi_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private EnviEnvio enviEnvio;

    public EmliEnvioMensagemLivre() {
    }

    public EmliEnvioMensagemLivre(Integer emliEnviCodigo) {
        this.emliEnviCodigo = emliEnviCodigo;
    }

    public Integer getEmliEnviCodigo() {
        return emliEnviCodigo;
    }

    public void setEmliEnviCodigo(Integer emliEnviCodigo) {
        this.emliEnviCodigo = emliEnviCodigo;
    }

    public String getEmliTexto() {
        return emliTexto;
    }

    public void setEmliTexto(String emliTexto) {
        this.emliTexto = emliTexto;
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
        hash += (emliEnviCodigo != null ? emliEnviCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmliEnvioMensagemLivre)) {
            return false;
        }
        EmliEnvioMensagemLivre other = (EmliEnvioMensagemLivre) object;
        if ((this.emliEnviCodigo == null && other.emliEnviCodigo != null) || (this.emliEnviCodigo != null && !this.emliEnviCodigo.equals(other.emliEnviCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EmliEnvioMensagemLivre[emliEnviCodigo=" + emliEnviCodigo + "]";
    }

}
