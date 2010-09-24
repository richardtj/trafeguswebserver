/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "leme_lista_envio_mensagem", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "LemeListaEnvioMensagem.findAll", query = "SELECT l FROM LemeListaEnvioMensagem l"),
    @NamedQuery(name = "LemeListaEnvioMensagem.findByLemeCodigo", query = "SELECT l FROM LemeListaEnvioMensagem l WHERE l.lemeCodigo = :lemeCodigo"),
    @NamedQuery(name = "LemeListaEnvioMensagem.findByLemeDescricao", query = "SELECT l FROM LemeListaEnvioMensagem l WHERE l.lemeDescricao = :lemeDescricao"),
    @NamedQuery(name = "LemeListaEnvioMensagem.findByLemeAssuntoEmail", query = "SELECT l FROM LemeListaEnvioMensagem l WHERE l.lemeAssuntoEmail = :lemeAssuntoEmail"),
    @NamedQuery(name = "LemeListaEnvioMensagem.findByLemeTextoEmail", query = "SELECT l FROM LemeListaEnvioMensagem l WHERE l.lemeTextoEmail = :lemeTextoEmail"),
    @NamedQuery(name = "LemeListaEnvioMensagem.findByLemeTextoSms", query = "SELECT l FROM LemeListaEnvioMensagem l WHERE l.lemeTextoSms = :lemeTextoSms"),
    @NamedQuery(name = "LemeListaEnvioMensagem.findByLemeDataCadastro", query = "SELECT l FROM LemeListaEnvioMensagem l WHERE l.lemeDataCadastro = :lemeDataCadastro")})
public class LemeListaEnvioMensagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "leme_codigo", nullable = false)
    private Integer lemeCodigo;
    @Column(name = "leme_descricao", length = 50)
    private String lemeDescricao;
    @Column(name = "leme_assunto_email", length = 50)
    private String lemeAssuntoEmail;
    @Column(name = "leme_texto_email", length = 500)
    private String lemeTextoEmail;
    @Column(name = "leme_texto_sms", length = 300)
    private String lemeTextoSms;
    @Column(name = "leme_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lemeDataCadastro;
    @OneToMany(mappedBy = "lemeListaEnvioMensagem")
    private Collection<SemeServicoEnvioMensagem> semeServicoEnvioMensagemCollection;
    @OneToMany(mappedBy = "lemeListaEnvioMensagem")
    private Collection<LemcListaEnvioMsgContato> lemcListaEnvioMsgContatoCollection;

    public LemeListaEnvioMensagem() {
    }

    public LemeListaEnvioMensagem(Integer lemeCodigo) {
        this.lemeCodigo = lemeCodigo;
    }

    public Integer getLemeCodigo() {
        return lemeCodigo;
    }

    public void setLemeCodigo(Integer lemeCodigo) {
        this.lemeCodigo = lemeCodigo;
    }

    public String getLemeDescricao() {
        return lemeDescricao;
    }

    public void setLemeDescricao(String lemeDescricao) {
        this.lemeDescricao = lemeDescricao;
    }

    public String getLemeAssuntoEmail() {
        return lemeAssuntoEmail;
    }

    public void setLemeAssuntoEmail(String lemeAssuntoEmail) {
        this.lemeAssuntoEmail = lemeAssuntoEmail;
    }

    public String getLemeTextoEmail() {
        return lemeTextoEmail;
    }

    public void setLemeTextoEmail(String lemeTextoEmail) {
        this.lemeTextoEmail = lemeTextoEmail;
    }

    public String getLemeTextoSms() {
        return lemeTextoSms;
    }

    public void setLemeTextoSms(String lemeTextoSms) {
        this.lemeTextoSms = lemeTextoSms;
    }

    public Date getLemeDataCadastro() {
        return lemeDataCadastro;
    }

    public void setLemeDataCadastro(Date lemeDataCadastro) {
        this.lemeDataCadastro = lemeDataCadastro;
    }

    public Collection<SemeServicoEnvioMensagem> getSemeServicoEnvioMensagemCollection() {
        return semeServicoEnvioMensagemCollection;
    }

    public void setSemeServicoEnvioMensagemCollection(Collection<SemeServicoEnvioMensagem> semeServicoEnvioMensagemCollection) {
        this.semeServicoEnvioMensagemCollection = semeServicoEnvioMensagemCollection;
    }

    public Collection<LemcListaEnvioMsgContato> getLemcListaEnvioMsgContatoCollection() {
        return lemcListaEnvioMsgContatoCollection;
    }

    public void setLemcListaEnvioMsgContatoCollection(Collection<LemcListaEnvioMsgContato> lemcListaEnvioMsgContatoCollection) {
        this.lemcListaEnvioMsgContatoCollection = lemcListaEnvioMsgContatoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lemeCodigo != null ? lemeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LemeListaEnvioMensagem)) {
            return false;
        }
        LemeListaEnvioMensagem other = (LemeListaEnvioMensagem) object;
        if ((this.lemeCodigo == null && other.lemeCodigo != null) || (this.lemeCodigo != null && !this.lemeCodigo.equals(other.lemeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.LemeListaEnvioMensagem[lemeCodigo=" + lemeCodigo + "]";
    }

}
