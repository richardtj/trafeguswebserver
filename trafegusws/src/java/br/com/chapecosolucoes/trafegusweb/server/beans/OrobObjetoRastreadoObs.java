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
import javax.persistence.FetchType;
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
@Table(name = "orob_objeto_rastreado_obs")
@NamedQueries({
    @NamedQuery(name = "OrobObjetoRastreadoObs.findAll", query = "SELECT o FROM OrobObjetoRastreadoObs o"),
    @NamedQuery(name = "OrobObjetoRastreadoObs.findByOrobCodigo", query = "SELECT o FROM OrobObjetoRastreadoObs o WHERE o.orobCodigo = :orobCodigo"),
    @NamedQuery(name = "OrobObjetoRastreadoObs.findByOrobObservacao", query = "SELECT o FROM OrobObjetoRastreadoObs o WHERE o.orobObservacao = :orobObservacao"),
    @NamedQuery(name = "OrobObjetoRastreadoObs.findByOrobDataCadastro", query = "SELECT o FROM OrobObjetoRastreadoObs o WHERE o.orobDataCadastro = :orobDataCadastro"),
    @NamedQuery(name = "OrobObjetoRastreadoObs.findByOrobCodigoGr", query = "SELECT o FROM OrobObjetoRastreadoObs o WHERE o.orobCodigoGr = :orobCodigoGr"),
    @NamedQuery(name = "OrobObjetoRastreadoObs.findByOrobImportado", query = "SELECT o FROM OrobObjetoRastreadoObs o WHERE o.orobImportado = :orobImportado")})
public class OrobObjetoRastreadoObs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "orob_codigo")
    private Integer orobCodigo;
    @Column(name = "orob_observacao")
    private String orobObservacao;
    @Column(name = "orob_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orobDataCadastro;
    @Column(name = "orob_codigo_gr")
    private Integer orobCodigoGr;
    @Column(name = "orob_importado")
    private Character orobImportado;
    @JoinColumn(name = "orob_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private UsuaUsuario usuaUsuario;
    @JoinColumn(name = "orob_oras_codigo", referencedColumnName = "oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private OrasObjetoRastreado orasObjetoRastreado;

    public OrobObjetoRastreadoObs() {
    }

    public OrobObjetoRastreadoObs(Integer orobCodigo) {
        this.orobCodigo = orobCodigo;
    }

    public Integer getOrobCodigo() {
        return orobCodigo;
    }

    public void setOrobCodigo(Integer orobCodigo) {
        this.orobCodigo = orobCodigo;
    }

    public String getOrobObservacao() {
        return orobObservacao;
    }

    public void setOrobObservacao(String orobObservacao) {
        this.orobObservacao = orobObservacao;
    }

    public Date getOrobDataCadastro() {
        return orobDataCadastro;
    }

    public void setOrobDataCadastro(Date orobDataCadastro) {
        this.orobDataCadastro = orobDataCadastro;
    }

    public Integer getOrobCodigoGr() {
        return orobCodigoGr;
    }

    public void setOrobCodigoGr(Integer orobCodigoGr) {
        this.orobCodigoGr = orobCodigoGr;
    }

    public Character getOrobImportado() {
        return orobImportado;
    }

    public void setOrobImportado(Character orobImportado) {
        this.orobImportado = orobImportado;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public OrasObjetoRastreado getOrasObjetoRastreado() {
        return orasObjetoRastreado;
    }

    public void setOrasObjetoRastreado(OrasObjetoRastreado orasObjetoRastreado) {
        this.orasObjetoRastreado = orasObjetoRastreado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orobCodigo != null ? orobCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrobObjetoRastreadoObs)) {
            return false;
        }
        OrobObjetoRastreadoObs other = (OrobObjetoRastreadoObs) object;
        if ((this.orobCodigo == null && other.orobCodigo != null) || (this.orobCodigo != null && !this.orobCodigo.equals(other.orobCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.OrobObjetoRastreadoObs[orobCodigo=" + orobCodigo + "]";
    }

}
