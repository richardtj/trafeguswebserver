/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "perf_perfil", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PerfPerfil.findAll", query = "SELECT p FROM PerfPerfil p"),
    @NamedQuery(name = "PerfPerfil.findByPerfCodigo", query = "SELECT p FROM PerfPerfil p WHERE p.perfCodigo = :perfCodigo"),
    @NamedQuery(name = "PerfPerfil.findByPerfDescricao", query = "SELECT p FROM PerfPerfil p WHERE p.perfDescricao = :perfDescricao"),
    @NamedQuery(name = "PerfPerfil.findByPerfAdministrador", query = "SELECT p FROM PerfPerfil p WHERE p.perfAdministrador = :perfAdministrador"),
    @NamedQuery(name = "PerfPerfil.findByPerfPermitirCriarUsuario", query = "SELECT p FROM PerfPerfil p WHERE p.perfPermitirCriarUsuario = :perfPermitirCriarUsuario"),
    @NamedQuery(name = "PerfPerfil.findByPerfDataCadastro", query = "SELECT p FROM PerfPerfil p WHERE p.perfDataCadastro = :perfDataCadastro"),
    @NamedQuery(name = "PerfPerfil.findByPerfCodigoGr", query = "SELECT p FROM PerfPerfil p WHERE p.perfCodigoGr = :perfCodigoGr"),
    @NamedQuery(name = "PerfPerfil.findByPerfImportado", query = "SELECT p FROM PerfPerfil p WHERE p.perfImportado = :perfImportado")})
public class PerfPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "perf_codigo", nullable = false)
    private Integer perfCodigo;
    @Column(name = "perf_descricao", length = 50)
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
    private List<UsuaUsuario> usuaUsuarioList;

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

    public List<UsuaUsuario> getUsuaUsuarioList() {
        return usuaUsuarioList;
    }

    public void setUsuaUsuarioList(List<UsuaUsuario> usuaUsuarioList) {
        this.usuaUsuarioList = usuaUsuarioList;
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
        return "br.com.chapecosolucoes.server.beans.PerfPerfil[perfCodigo=" + perfCodigo + "]";
    }

}
