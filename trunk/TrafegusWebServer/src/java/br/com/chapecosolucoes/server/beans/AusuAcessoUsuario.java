/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ausu_acesso_usuario")
@NamedQueries({
    @NamedQuery(name = "AusuAcessoUsuario.findAll", query = "SELECT a FROM AusuAcessoUsuario a")})
public class AusuAcessoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ausu_codigo", nullable = false)
    private Integer ausuCodigo;
    @Column(name = "ausu_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ausuDataCadastro;
    @Column(name = "ausu_data_inicio_acesso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ausuDataInicioAcesso;
    @Column(name = "ausu_data_fim_acesso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ausuDataFimAcesso;
    @JoinColumn(name = "ausu_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne
    private UsuaUsuario usuaUsuario;
    @OneToMany(mappedBy = "ausuAcessoUsuario")
    private Collection<AtusAcessoTelaUsuario> atusAcessoTelaUsuarioCollection;

    public AusuAcessoUsuario() {
    }

    public AusuAcessoUsuario(Integer ausuCodigo) {
        this.ausuCodigo = ausuCodigo;
    }

    public Integer getAusuCodigo() {
        return ausuCodigo;
    }

    public void setAusuCodigo(Integer ausuCodigo) {
        this.ausuCodigo = ausuCodigo;
    }

    public Date getAusuDataCadastro() {
        return ausuDataCadastro;
    }

    public void setAusuDataCadastro(Date ausuDataCadastro) {
        this.ausuDataCadastro = ausuDataCadastro;
    }

    public Date getAusuDataInicioAcesso() {
        return ausuDataInicioAcesso;
    }

    public void setAusuDataInicioAcesso(Date ausuDataInicioAcesso) {
        this.ausuDataInicioAcesso = ausuDataInicioAcesso;
    }

    public Date getAusuDataFimAcesso() {
        return ausuDataFimAcesso;
    }

    public void setAusuDataFimAcesso(Date ausuDataFimAcesso) {
        this.ausuDataFimAcesso = ausuDataFimAcesso;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public Collection<AtusAcessoTelaUsuario> getAtusAcessoTelaUsuarioCollection() {
        return atusAcessoTelaUsuarioCollection;
    }

    public void setAtusAcessoTelaUsuarioCollection(Collection<AtusAcessoTelaUsuario> atusAcessoTelaUsuarioCollection) {
        this.atusAcessoTelaUsuarioCollection = atusAcessoTelaUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ausuCodigo != null ? ausuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AusuAcessoUsuario)) {
            return false;
        }
        AusuAcessoUsuario other = (AusuAcessoUsuario) object;
        if ((this.ausuCodigo == null && other.ausuCodigo != null) || (this.ausuCodigo != null && !this.ausuCodigo.equals(other.ausuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.AusuAcessoUsuario[ausuCodigo=" + ausuCodigo + "]";
    }

}
