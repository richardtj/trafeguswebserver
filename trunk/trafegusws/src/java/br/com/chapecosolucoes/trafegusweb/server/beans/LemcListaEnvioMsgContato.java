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
@Table(name = "lemc_lista_envio_msg_contato")
@NamedQueries({
    @NamedQuery(name = "LemcListaEnvioMsgContato.findAll", query = "SELECT l FROM LemcListaEnvioMsgContato l"),
    @NamedQuery(name = "LemcListaEnvioMsgContato.findByLemcCodigo", query = "SELECT l FROM LemcListaEnvioMsgContato l WHERE l.lemcCodigo = :lemcCodigo"),
    @NamedQuery(name = "LemcListaEnvioMsgContato.findByLemcDescricaoContato", query = "SELECT l FROM LemcListaEnvioMsgContato l WHERE l.lemcDescricaoContato = :lemcDescricaoContato"),
    @NamedQuery(name = "LemcListaEnvioMsgContato.findByLemcDestinatario", query = "SELECT l FROM LemcListaEnvioMsgContato l WHERE l.lemcDestinatario = :lemcDestinatario")})
public class LemcListaEnvioMsgContato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lemc_codigo")
    private Integer lemcCodigo;
    @Column(name = "lemc_descricao_contato")
    private String lemcDescricaoContato;
    @Column(name = "lemc_destinatario")
    private String lemcDestinatario;
    @JoinColumn(name = "lemc_tenv_codigo", referencedColumnName = "tenv_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private TenvTipoEnvio tenvTipoEnvio;
    @JoinColumn(name = "leme_codigo", referencedColumnName = "leme_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private LemeListaEnvioMensagem lemeListaEnvioMensagem;

    public LemcListaEnvioMsgContato() {
    }

    public LemcListaEnvioMsgContato(Integer lemcCodigo) {
        this.lemcCodigo = lemcCodigo;
    }

    public Integer getLemcCodigo() {
        return lemcCodigo;
    }

    public void setLemcCodigo(Integer lemcCodigo) {
        this.lemcCodigo = lemcCodigo;
    }

    public String getLemcDescricaoContato() {
        return lemcDescricaoContato;
    }

    public void setLemcDescricaoContato(String lemcDescricaoContato) {
        this.lemcDescricaoContato = lemcDescricaoContato;
    }

    public String getLemcDestinatario() {
        return lemcDestinatario;
    }

    public void setLemcDestinatario(String lemcDestinatario) {
        this.lemcDestinatario = lemcDestinatario;
    }

    public TenvTipoEnvio getTenvTipoEnvio() {
        return tenvTipoEnvio;
    }

    public void setTenvTipoEnvio(TenvTipoEnvio tenvTipoEnvio) {
        this.tenvTipoEnvio = tenvTipoEnvio;
    }

    public LemeListaEnvioMensagem getLemeListaEnvioMensagem() {
        return lemeListaEnvioMensagem;
    }

    public void setLemeListaEnvioMensagem(LemeListaEnvioMensagem lemeListaEnvioMensagem) {
        this.lemeListaEnvioMensagem = lemeListaEnvioMensagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lemcCodigo != null ? lemcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LemcListaEnvioMsgContato)) {
            return false;
        }
        LemcListaEnvioMsgContato other = (LemcListaEnvioMsgContato) object;
        if ((this.lemcCodigo == null && other.lemcCodigo != null) || (this.lemcCodigo != null && !this.lemcCodigo.equals(other.lemcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.LemcListaEnvioMsgContato[lemcCodigo=" + lemcCodigo + "]";
    }

}
