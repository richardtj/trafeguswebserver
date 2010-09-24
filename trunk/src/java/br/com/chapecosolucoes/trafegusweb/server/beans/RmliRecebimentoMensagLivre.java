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
@Table(name = "rmli_recebimento_mensag_livre", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RmliRecebimentoMensagLivre.findAll", query = "SELECT r FROM RmliRecebimentoMensagLivre r"),
    @NamedQuery(name = "RmliRecebimentoMensagLivre.findByRmliReceCodigo", query = "SELECT r FROM RmliRecebimentoMensagLivre r WHERE r.rmliReceCodigo = :rmliReceCodigo"),
    @NamedQuery(name = "RmliRecebimentoMensagLivre.findByRmliTexto", query = "SELECT r FROM RmliRecebimentoMensagLivre r WHERE r.rmliTexto = :rmliTexto"),
    @NamedQuery(name = "RmliRecebimentoMensagLivre.findByRmliDataLeitura", query = "SELECT r FROM RmliRecebimentoMensagLivre r WHERE r.rmliDataLeitura = :rmliDataLeitura"),
    @NamedQuery(name = "RmliRecebimentoMensagLivre.findByRmliDataComputadorBordo", query = "SELECT r FROM RmliRecebimentoMensagLivre r WHERE r.rmliDataComputadorBordo = :rmliDataComputadorBordo")})
public class RmliRecebimentoMensagLivre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rmli_rece_codigo", nullable = false)
    private Integer rmliReceCodigo;
    @Column(name = "rmli_texto", length = 5000)
    private String rmliTexto;
    @Column(name = "rmli_data_leitura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rmliDataLeitura;
    @Column(name = "rmli_data_computador_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rmliDataComputadorBordo;
    @JoinColumn(name = "rmli_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne
    private UsuaUsuario usuaUsuario;

    public RmliRecebimentoMensagLivre() {
    }

    public RmliRecebimentoMensagLivre(Integer rmliReceCodigo) {
        this.rmliReceCodigo = rmliReceCodigo;
    }

    public Integer getRmliReceCodigo() {
        return rmliReceCodigo;
    }

    public void setRmliReceCodigo(Integer rmliReceCodigo) {
        this.rmliReceCodigo = rmliReceCodigo;
    }

    public String getRmliTexto() {
        return rmliTexto;
    }

    public void setRmliTexto(String rmliTexto) {
        this.rmliTexto = rmliTexto;
    }

    public Date getRmliDataLeitura() {
        return rmliDataLeitura;
    }

    public void setRmliDataLeitura(Date rmliDataLeitura) {
        this.rmliDataLeitura = rmliDataLeitura;
    }

    public Date getRmliDataComputadorBordo() {
        return rmliDataComputadorBordo;
    }

    public void setRmliDataComputadorBordo(Date rmliDataComputadorBordo) {
        this.rmliDataComputadorBordo = rmliDataComputadorBordo;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmliReceCodigo != null ? rmliReceCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmliRecebimentoMensagLivre)) {
            return false;
        }
        RmliRecebimentoMensagLivre other = (RmliRecebimentoMensagLivre) object;
        if ((this.rmliReceCodigo == null && other.rmliReceCodigo != null) || (this.rmliReceCodigo != null && !this.rmliReceCodigo.equals(other.rmliReceCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.RmliRecebimentoMensagLivre[rmliReceCodigo=" + rmliReceCodigo + "]";
    }

}
