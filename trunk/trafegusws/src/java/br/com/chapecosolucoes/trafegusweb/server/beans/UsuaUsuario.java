/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "usua_usuario")
@NamedQueries({
    @NamedQuery(name = "UsuaUsuario.findAll", query = "SELECT u FROM UsuaUsuario u")})
public class UsuaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usua_pfis_pess_oras_codigo")
    private Integer usuaPfisPessOrasCodigo;
    @Column(name = "usua_login")
    private String usuaLogin;
    @Column(name = "usua_senha")
    private String usuaSenha;
    @JoinColumn(name = "usua_seto_codigo", referencedColumnName = "seto_codigo")
    @ManyToOne
    private SetoSetor setoSetor;
    @JoinColumn(name = "usua_pfis_pess_oras_codigo", referencedColumnName = "pfis_pess_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PfisPessoaFisica pfisPessoaFisica;
    @JoinColumn(name = "usua_pess_oras_codigo", referencedColumnName = "pess_oras_codigo")
    @ManyToOne
    private PessPessoa pessPessoa;
    @JoinColumn(name = "usua_perf_codigo", referencedColumnName = "perf_codigo")
    @ManyToOne
    private PerfPerfil perfPerfil;
    @OneToMany(mappedBy = "usuaUsuario")
    private Set<VterViagemTerminal> vterViagemTerminalSet;

    public UsuaUsuario() {
    }

    public UsuaUsuario(Integer usuaPfisPessOrasCodigo) {
        this.usuaPfisPessOrasCodigo = usuaPfisPessOrasCodigo;
    }

    public Integer getUsuaPfisPessOrasCodigo() {
        return usuaPfisPessOrasCodigo;
    }

    public void setUsuaPfisPessOrasCodigo(Integer usuaPfisPessOrasCodigo) {
        this.usuaPfisPessOrasCodigo = usuaPfisPessOrasCodigo;
    }

    public String getUsuaLogin() {
        return usuaLogin;
    }

    public void setUsuaLogin(String usuaLogin) {
        this.usuaLogin = usuaLogin;
    }

    public String getUsuaSenha() {
        return usuaSenha;
    }

    public void setUsuaSenha(String usuaSenha) {
        this.usuaSenha = usuaSenha;
    }

    public SetoSetor getSetoSetor() {
        return setoSetor;
    }

    public void setSetoSetor(SetoSetor setoSetor) {
        this.setoSetor = setoSetor;
    }

    public PfisPessoaFisica getPfisPessoaFisica() {
        return pfisPessoaFisica;
    }

    public void setPfisPessoaFisica(PfisPessoaFisica pfisPessoaFisica) {
        this.pfisPessoaFisica = pfisPessoaFisica;
    }

    public PessPessoa getPessPessoa() {
        return pessPessoa;
    }

    public void setPessPessoa(PessPessoa pessPessoa) {
        this.pessPessoa = pessPessoa;
    }

    public PerfPerfil getPerfPerfil() {
        return perfPerfil;
    }

    public void setPerfPerfil(PerfPerfil perfPerfil) {
        this.perfPerfil = perfPerfil;
    }

    public Set<VterViagemTerminal> getVterViagemTerminalSet() {
        return vterViagemTerminalSet;
    }

    public void setVterViagemTerminalSet(Set<VterViagemTerminal> vterViagemTerminalSet) {
        this.vterViagemTerminalSet = vterViagemTerminalSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuaPfisPessOrasCodigo != null ? usuaPfisPessOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuaUsuario)) {
            return false;
        }
        UsuaUsuario other = (UsuaUsuario) object;
        if ((this.usuaPfisPessOrasCodigo == null && other.usuaPfisPessOrasCodigo != null) || (this.usuaPfisPessOrasCodigo != null && !this.usuaPfisPessOrasCodigo.equals(other.usuaPfisPessOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.UsuaUsuario[usuaPfisPessOrasCodigo=" + usuaPfisPessOrasCodigo + "]";
    }

}
