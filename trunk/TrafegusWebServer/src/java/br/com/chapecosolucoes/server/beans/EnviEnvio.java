/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "envi_envio", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EnviEnvio.findAll", query = "SELECT e FROM EnviEnvio e"),
    @NamedQuery(name = "EnviEnvio.findByEnviCodigo", query = "SELECT e FROM EnviEnvio e WHERE e.enviCodigo = :enviCodigo"),
    @NamedQuery(name = "EnviEnvio.findByEnviDataEnviado", query = "SELECT e FROM EnviEnvio e WHERE e.enviDataEnviado = :enviDataEnviado"),
    @NamedQuery(name = "EnviEnvio.findByEnviDataCadastro", query = "SELECT e FROM EnviEnvio e WHERE e.enviDataCadastro = :enviDataCadastro"),
    @NamedQuery(name = "EnviEnvio.findByEnviEstatus", query = "SELECT e FROM EnviEnvio e WHERE e.enviEstatus = :enviEstatus"),
    @NamedQuery(name = "EnviEnvio.findByEnviCodigoGr", query = "SELECT e FROM EnviEnvio e WHERE e.enviCodigoGr = :enviCodigoGr"),
    @NamedQuery(name = "EnviEnvio.findByEnviDescricaoEstatus", query = "SELECT e FROM EnviEnvio e WHERE e.enviDescricaoEstatus = :enviDescricaoEstatus"),
    @NamedQuery(name = "EnviEnvio.findByEnviEstatusIgnicao", query = "SELECT e FROM EnviEnvio e WHERE e.enviEstatusIgnicao = :enviEstatusIgnicao"),
    @NamedQuery(name = "EnviEnvio.findByEnviVinculoExterno", query = "SELECT e FROM EnviEnvio e WHERE e.enviVinculoExterno = :enviVinculoExterno")})
public class EnviEnvio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "envi_codigo", nullable = false)
    private Integer enviCodigo;
    @Column(name = "envi_data_enviado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enviDataEnviado;
    @Column(name = "envi_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enviDataCadastro;
    @Column(name = "envi_estatus", length = 10)
    private String enviEstatus;
    @Column(name = "envi_codigo_gr")
    private Integer enviCodigoGr;
    @Column(name = "envi_descricao_estatus", length = 250)
    private String enviDescricaoEstatus;
    @Column(name = "envi_estatus_ignicao", length = 10)
    private String enviEstatusIgnicao;
    @Column(name = "envi_vinculo_externo", length = 50)
    private String enviVinculoExterno;
    @JoinColumn(name = "envi_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private UsuaUsuario usuaUsuario;
    @JoinColumn(name = "envi_term_codigo", referencedColumnName = "term_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TermTerminal termTerminal;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "enviEnvio", fetch = FetchType.EAGER)
    private EmacEnvioMacro emacEnvioMacro;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "enviEnvio", fetch = FetchType.EAGER)
    private EcomEnvioComando ecomEnvioComando;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "enviEnvio", fetch = FetchType.EAGER)
    private EmliEnvioMensagemLivre emliEnvioMensagemLivre;

    public EnviEnvio() {
    }

    public EnviEnvio(Integer enviCodigo) {
        this.enviCodigo = enviCodigo;
    }

    public Integer getEnviCodigo() {
        return enviCodigo;
    }

    public void setEnviCodigo(Integer enviCodigo) {
        this.enviCodigo = enviCodigo;
    }

    public Date getEnviDataEnviado() {
        return enviDataEnviado;
    }

    public void setEnviDataEnviado(Date enviDataEnviado) {
        this.enviDataEnviado = enviDataEnviado;
    }

    public Date getEnviDataCadastro() {
        return enviDataCadastro;
    }

    public void setEnviDataCadastro(Date enviDataCadastro) {
        this.enviDataCadastro = enviDataCadastro;
    }

    public String getEnviEstatus() {
        return enviEstatus;
    }

    public void setEnviEstatus(String enviEstatus) {
        this.enviEstatus = enviEstatus;
    }

    public Integer getEnviCodigoGr() {
        return enviCodigoGr;
    }

    public void setEnviCodigoGr(Integer enviCodigoGr) {
        this.enviCodigoGr = enviCodigoGr;
    }

    public String getEnviDescricaoEstatus() {
        return enviDescricaoEstatus;
    }

    public void setEnviDescricaoEstatus(String enviDescricaoEstatus) {
        this.enviDescricaoEstatus = enviDescricaoEstatus;
    }

    public String getEnviEstatusIgnicao() {
        return enviEstatusIgnicao;
    }

    public void setEnviEstatusIgnicao(String enviEstatusIgnicao) {
        this.enviEstatusIgnicao = enviEstatusIgnicao;
    }

    public String getEnviVinculoExterno() {
        return enviVinculoExterno;
    }

    public void setEnviVinculoExterno(String enviVinculoExterno) {
        this.enviVinculoExterno = enviVinculoExterno;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public TermTerminal getTermTerminal() {
        return termTerminal;
    }

    public void setTermTerminal(TermTerminal termTerminal) {
        this.termTerminal = termTerminal;
    }

    public EmacEnvioMacro getEmacEnvioMacro() {
        return emacEnvioMacro;
    }

    public void setEmacEnvioMacro(EmacEnvioMacro emacEnvioMacro) {
        this.emacEnvioMacro = emacEnvioMacro;
    }

    public EcomEnvioComando getEcomEnvioComando() {
        return ecomEnvioComando;
    }

    public void setEcomEnvioComando(EcomEnvioComando ecomEnvioComando) {
        this.ecomEnvioComando = ecomEnvioComando;
    }

    public EmliEnvioMensagemLivre getEmliEnvioMensagemLivre() {
        return emliEnvioMensagemLivre;
    }

    public void setEmliEnvioMensagemLivre(EmliEnvioMensagemLivre emliEnvioMensagemLivre) {
        this.emliEnvioMensagemLivre = emliEnvioMensagemLivre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enviCodigo != null ? enviCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnviEnvio)) {
            return false;
        }
        EnviEnvio other = (EnviEnvio) object;
        if ((this.enviCodigo == null && other.enviCodigo != null) || (this.enviCodigo != null && !this.enviCodigo.equals(other.enviCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.EnviEnvio[enviCodigo=" + enviCodigo + "]";
    }

}
