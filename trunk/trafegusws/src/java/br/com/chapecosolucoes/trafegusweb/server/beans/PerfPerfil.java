/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
 * @author emerson
 */
@Entity
@Table(name = "perf_perfil")
@NamedQueries({
    @NamedQuery(name = "PerfPerfil.findAll", query = "SELECT p FROM PerfPerfil p")})
public class PerfPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "perf_codigo")
    private Integer perfCodigo;
    @Column(name = "perf_descricao")
    private String perfDescricao;
    @Column(name = "perf_administrador")
    private Character perfAdministrador;
    @Column(name = "perf_permitir_criar_usuario")
    private Character perfPermitirCriarUsuario;
    @Column(name = "perf_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perfDataCadastro;
    @Column(name = "perf_codigo_gr")
    private Integer perfCodigoGr;
    @Column(name = "perf_importado")
    private Character perfImportado;
    @OneToMany(mappedBy = "perfPerfil")
    private Set<UsuaUsuario> usuaUsuarioSet;

    public PerfPerfil() {
    }

    public PerfPerfil(Integer perfCodigo) {
        this.perfCodigo = perfCodigo;
    }

    public Integer getPerfCodigo() {
        return perfCodigo;
    }

    public void setPerfCodigo(Integer perfCodigo) {
        this.perfCodigo = perfCodigo;
    }

    public String getPerfDescricao() {
        return perfDescricao;
    }

    public void setPerfDescricao(String perfDescricao) {
        this.perfDescricao = perfDescricao;
    }

    public Character getPerfAdministrador() {
        return perfAdministrador;
    }

    public void setPerfAdministrador(Character perfAdministrador) {
        this.perfAdministrador = perfAdministrador;
    }

    public Character getPerfPermitirCriarUsuario() {
        return perfPermitirCriarUsuario;
    }

    public void setPerfPermitirCriarUsuario(Character perfPermitirCriarUsuario) {
        this.perfPermitirCriarUsuario = perfPermitirCriarUsuario;
    }

    public Date getPerfDataCadastro() {
        return perfDataCadastro;
    }

    public void setPerfDataCadastro(Date perfDataCadastro) {
        this.perfDataCadastro = perfDataCadastro;
    }

    public Integer getPerfCodigoGr() {
        return perfCodigoGr;
    }

    public void setPerfCodigoGr(Integer perfCodigoGr) {
        this.perfCodigoGr = perfCodigoGr;
    }

    public Character getPerfImportado() {
        return perfImportado;
    }

    public void setPerfImportado(Character perfImportado) {
        this.perfImportado = perfImportado;
    }

    public Set<UsuaUsuario> getUsuaUsuarioSet() {
        return usuaUsuarioSet;
    }

    public void setUsuaUsuarioSet(Set<UsuaUsuario> usuaUsuarioSet) {
        this.usuaUsuarioSet = usuaUsuarioSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfCodigo != null ? perfCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfPerfil)) {
            return false;
        }
        PerfPerfil other = (PerfPerfil) object;
        if ((this.perfCodigo == null && other.perfCodigo != null) || (this.perfCodigo != null && !this.perfCodigo.equals(other.perfCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PerfPerfil[perfCodigo=" + perfCodigo + "]";
    }

}
