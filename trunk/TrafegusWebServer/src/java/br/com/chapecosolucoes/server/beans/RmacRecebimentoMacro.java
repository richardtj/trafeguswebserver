/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "rmac_recebimento_macro", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RmacRecebimentoMacro.findAll", query = "SELECT r FROM RmacRecebimentoMacro r"),
    @NamedQuery(name = "RmacRecebimentoMacro.findByRmacReceCodigo", query = "SELECT r FROM RmacRecebimentoMacro r WHERE r.rmacReceCodigo = :rmacReceCodigo"),
    @NamedQuery(name = "RmacRecebimentoMacro.findByRmacNumero", query = "SELECT r FROM RmacRecebimentoMacro r WHERE r.rmacNumero = :rmacNumero"),
    @NamedQuery(name = "RmacRecebimentoMacro.findByRmacTexto", query = "SELECT r FROM RmacRecebimentoMacro r WHERE r.rmacTexto = :rmacTexto"),
    @NamedQuery(name = "RmacRecebimentoMacro.findByRmacMascara", query = "SELECT r FROM RmacRecebimentoMacro r WHERE r.rmacMascara = :rmacMascara"),
    @NamedQuery(name = "RmacRecebimentoMacro.findByRmacEsisCodigo", query = "SELECT r FROM RmacRecebimentoMacro r WHERE r.rmacEsisCodigo = :rmacEsisCodigo"),
    @NamedQuery(name = "RmacRecebimentoMacro.findByRmacDataLeitura", query = "SELECT r FROM RmacRecebimentoMacro r WHERE r.rmacDataLeitura = :rmacDataLeitura"),
    @NamedQuery(name = "RmacRecebimentoMacro.findByRmacEstatusGe", query = "SELECT r FROM RmacRecebimentoMacro r WHERE r.rmacEstatusGe = :rmacEstatusGe"),
    @NamedQuery(name = "RmacRecebimentoMacro.findByRmacDataComputadorBordo", query = "SELECT r FROM RmacRecebimentoMacro r WHERE r.rmacDataComputadorBordo = :rmacDataComputadorBordo")})
public class RmacRecebimentoMacro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RmacRecebimentoMacroPK rmacRecebimentoMacroPK;
    @Basic(optional = false)
    @Column(name = "rmac_rece_codigo", nullable = false)
    private int rmacReceCodigo;
    @Column(name = "rmac_numero", length = 10)
    private String rmacNumero;
    @Column(name = "rmac_texto", length = 500)
    private String rmacTexto;
    @Column(name = "rmac_mascara", length = 500)
    private String rmacMascara;
    @Column(name = "rmac_esis_codigo")
    private Integer rmacEsisCodigo;
    @Column(name = "rmac_data_leitura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rmacDataLeitura;
    @Column(name = "rmac_estatus_ge", length = 100)
    private String rmacEstatusGe;
    @Column(name = "rmac_data_computador_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rmacDataComputadorBordo;
    @JoinColumn(name = "rmac_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne
    private UsuaUsuario usuaUsuario;

    public RmacRecebimentoMacro() {
    }

    public RmacRecebimentoMacro(RmacRecebimentoMacroPK rmacRecebimentoMacroPK) {
        this.rmacRecebimentoMacroPK = rmacRecebimentoMacroPK;
    }

    public RmacRecebimentoMacro(RmacRecebimentoMacroPK rmacRecebimentoMacroPK, int rmacReceCodigo) {
        this.rmacRecebimentoMacroPK = rmacRecebimentoMacroPK;
        this.rmacReceCodigo = rmacReceCodigo;
    }

    public RmacRecebimentoMacroPK getRmacRecebimentoMacroPK() {
        return rmacRecebimentoMacroPK;
    }

    public void setRmacRecebimentoMacroPK(RmacRecebimentoMacroPK rmacRecebimentoMacroPK) {
        this.rmacRecebimentoMacroPK = rmacRecebimentoMacroPK;
    }

    public int getRmacReceCodigo() {
        return rmacReceCodigo;
    }

    public void setRmacReceCodigo(int rmacReceCodigo) {
        this.rmacReceCodigo = rmacReceCodigo;
    }

    public String getRmacNumero() {
        return rmacNumero;
    }

    public void setRmacNumero(String rmacNumero) {
        this.rmacNumero = rmacNumero;
    }

    public String getRmacTexto() {
        return rmacTexto;
    }

    public void setRmacTexto(String rmacTexto) {
        this.rmacTexto = rmacTexto;
    }

    public String getRmacMascara() {
        return rmacMascara;
    }

    public void setRmacMascara(String rmacMascara) {
        this.rmacMascara = rmacMascara;
    }

    public Integer getRmacEsisCodigo() {
        return rmacEsisCodigo;
    }

    public void setRmacEsisCodigo(Integer rmacEsisCodigo) {
        this.rmacEsisCodigo = rmacEsisCodigo;
    }

    public Date getRmacDataLeitura() {
        return rmacDataLeitura;
    }

    public void setRmacDataLeitura(Date rmacDataLeitura) {
        this.rmacDataLeitura = rmacDataLeitura;
    }

    public String getRmacEstatusGe() {
        return rmacEstatusGe;
    }

    public void setRmacEstatusGe(String rmacEstatusGe) {
        this.rmacEstatusGe = rmacEstatusGe;
    }

    public Date getRmacDataComputadorBordo() {
        return rmacDataComputadorBordo;
    }

    public void setRmacDataComputadorBordo(Date rmacDataComputadorBordo) {
        this.rmacDataComputadorBordo = rmacDataComputadorBordo;
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
        hash += (rmacRecebimentoMacroPK != null ? rmacRecebimentoMacroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmacRecebimentoMacro)) {
            return false;
        }
        RmacRecebimentoMacro other = (RmacRecebimentoMacro) object;
        if ((this.rmacRecebimentoMacroPK == null && other.rmacRecebimentoMacroPK != null) || (this.rmacRecebimentoMacroPK != null && !this.rmacRecebimentoMacroPK.equals(other.rmacRecebimentoMacroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.RmacRecebimentoMacro[rmacRecebimentoMacroPK=" + rmacRecebimentoMacroPK + "]";
    }

}
