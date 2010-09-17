/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "erus_estacao_rastreamento_usu", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"erus_eras_codigo", "erus_usua_pfis_pess_oras_codigo"})})
@NamedQueries({
    @NamedQuery(name = "ErusEstacaoRastreamentoUsu.findAll", query = "SELECT e FROM ErusEstacaoRastreamentoUsu e")})
public class ErusEstacaoRastreamentoUsu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "erus_codigo", nullable = false)
    private Integer erusCodigo;
    @Column(name = "erus_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date erusDataCadastro;
    @Column(name = "erus_codigo_gr")
    private Integer erusCodigoGr;
    @Column(name = "erus_importado")
    private Character erusImportado;
    @JoinColumn(name = "erus_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne
    private UsuaUsuario usuaUsuario;
    @JoinColumn(name = "erus_eras_codigo", referencedColumnName = "eras_codigo")
    @ManyToOne
    private ErasEstacaoRastreamento erasEstacaoRastreamento;

    public ErusEstacaoRastreamentoUsu() {
    }

    public ErusEstacaoRastreamentoUsu(Integer erusCodigo) {
        this.erusCodigo = erusCodigo;
    }

    public Integer getErusCodigo() {
        return erusCodigo;
    }

    public void setErusCodigo(Integer erusCodigo) {
        this.erusCodigo = erusCodigo;
    }

    public Date getErusDataCadastro() {
        return erusDataCadastro;
    }

    public void setErusDataCadastro(Date erusDataCadastro) {
        this.erusDataCadastro = erusDataCadastro;
    }

    public Integer getErusCodigoGr() {
        return erusCodigoGr;
    }

    public void setErusCodigoGr(Integer erusCodigoGr) {
        this.erusCodigoGr = erusCodigoGr;
    }

    public Character getErusImportado() {
        return erusImportado;
    }

    public void setErusImportado(Character erusImportado) {
        this.erusImportado = erusImportado;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public ErasEstacaoRastreamento getErasEstacaoRastreamento() {
        return erasEstacaoRastreamento;
    }

    public void setErasEstacaoRastreamento(ErasEstacaoRastreamento erasEstacaoRastreamento) {
        this.erasEstacaoRastreamento = erasEstacaoRastreamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erusCodigo != null ? erusCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErusEstacaoRastreamentoUsu)) {
            return false;
        }
        ErusEstacaoRastreamentoUsu other = (ErusEstacaoRastreamentoUsu) object;
        if ((this.erusCodigo == null && other.erusCodigo != null) || (this.erusCodigo != null && !this.erusCodigo.equals(other.erusCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.ErusEstacaoRastreamentoUsu[erusCodigo=" + erusCodigo + "]";
    }

}
