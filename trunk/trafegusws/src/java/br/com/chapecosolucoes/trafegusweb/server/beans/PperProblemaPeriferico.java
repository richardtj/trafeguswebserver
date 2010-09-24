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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "pper_problema_periferico", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PperProblemaPeriferico.findAll", query = "SELECT p FROM PperProblemaPeriferico p"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperCodigo", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperCodigo = :pperCodigo"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperDataCadastro", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperDataCadastro = :pperDataCadastro"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperDataInicioProblema", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperDataInicioProblema = :pperDataInicioProblema"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperDataFimProblema", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperDataFimProblema = :pperDataFimProblema"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperDescricao", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperDescricao = :pperDescricao"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperDataHoraNotificacao", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperDataHoraNotificacao = :pperDataHoraNotificacao"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperTipoNotificacao", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperTipoNotificacao = :pperTipoNotificacao"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperContatoNotificado", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperContatoNotificado = :pperContatoNotificado"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperObservacao", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperObservacao = :pperObservacao"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperCodigoGr", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperCodigoGr = :pperCodigoGr"),
    @NamedQuery(name = "PperProblemaPeriferico.findByPperImportado", query = "SELECT p FROM PperProblemaPeriferico p WHERE p.pperImportado = :pperImportado")})
public class PperProblemaPeriferico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pper_codigo", nullable = false)
    private Integer pperCodigo;
    @Column(name = "pper_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pperDataCadastro;
    @Column(name = "pper_data_inicio_problema")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pperDataInicioProblema;
    @Column(name = "pper_data_fim_problema")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pperDataFimProblema;
    @Column(name = "pper_descricao", length = 200)
    private String pperDescricao;
    @Column(name = "pper_data_hora_notificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pperDataHoraNotificacao;
    @Column(name = "pper_tipo_notificacao", length = 10)
    private String pperTipoNotificacao;
    @Column(name = "pper_contato_notificado", length = 100)
    private String pperContatoNotificado;
    @Column(name = "pper_observacao", length = 300)
    private String pperObservacao;
    @Column(name = "pper_codigo_gr")
    private Integer pperCodigoGr;
    @Column(name = "pper_importado")
    private Character pperImportado;
    @JoinColumn(name = "pper_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne
    private UsuaUsuario usuaUsuario;
    @JoinColumn(name = "pper_ppin_codigo", referencedColumnName = "ppin_codigo")
    @ManyToOne
    private PpinPerifericoPadraoInstal ppinPerifericoPadraoInstal;

    public PperProblemaPeriferico() {
    }

    public PperProblemaPeriferico(Integer pperCodigo) {
        this.pperCodigo = pperCodigo;
    }

    public Integer getPperCodigo() {
        return pperCodigo;
    }

    public void setPperCodigo(Integer pperCodigo) {
        this.pperCodigo = pperCodigo;
    }

    public Date getPperDataCadastro() {
        return pperDataCadastro;
    }

    public void setPperDataCadastro(Date pperDataCadastro) {
        this.pperDataCadastro = pperDataCadastro;
    }

    public Date getPperDataInicioProblema() {
        return pperDataInicioProblema;
    }

    public void setPperDataInicioProblema(Date pperDataInicioProblema) {
        this.pperDataInicioProblema = pperDataInicioProblema;
    }

    public Date getPperDataFimProblema() {
        return pperDataFimProblema;
    }

    public void setPperDataFimProblema(Date pperDataFimProblema) {
        this.pperDataFimProblema = pperDataFimProblema;
    }

    public String getPperDescricao() {
        return pperDescricao;
    }

    public void setPperDescricao(String pperDescricao) {
        this.pperDescricao = pperDescricao;
    }

    public Date getPperDataHoraNotificacao() {
        return pperDataHoraNotificacao;
    }

    public void setPperDataHoraNotificacao(Date pperDataHoraNotificacao) {
        this.pperDataHoraNotificacao = pperDataHoraNotificacao;
    }

    public String getPperTipoNotificacao() {
        return pperTipoNotificacao;
    }

    public void setPperTipoNotificacao(String pperTipoNotificacao) {
        this.pperTipoNotificacao = pperTipoNotificacao;
    }

    public String getPperContatoNotificado() {
        return pperContatoNotificado;
    }

    public void setPperContatoNotificado(String pperContatoNotificado) {
        this.pperContatoNotificado = pperContatoNotificado;
    }

    public String getPperObservacao() {
        return pperObservacao;
    }

    public void setPperObservacao(String pperObservacao) {
        this.pperObservacao = pperObservacao;
    }

    public Integer getPperCodigoGr() {
        return pperCodigoGr;
    }

    public void setPperCodigoGr(Integer pperCodigoGr) {
        this.pperCodigoGr = pperCodigoGr;
    }

    public Character getPperImportado() {
        return pperImportado;
    }

    public void setPperImportado(Character pperImportado) {
        this.pperImportado = pperImportado;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public PpinPerifericoPadraoInstal getPpinPerifericoPadraoInstal() {
        return ppinPerifericoPadraoInstal;
    }

    public void setPpinPerifericoPadraoInstal(PpinPerifericoPadraoInstal ppinPerifericoPadraoInstal) {
        this.ppinPerifericoPadraoInstal = ppinPerifericoPadraoInstal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pperCodigo != null ? pperCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PperProblemaPeriferico)) {
            return false;
        }
        PperProblemaPeriferico other = (PperProblemaPeriferico) object;
        if ((this.pperCodigo == null && other.pperCodigo != null) || (this.pperCodigo != null && !this.pperCodigo.equals(other.pperCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PperProblemaPeriferico[pperCodigo=" + pperCodigo + "]";
    }

}
