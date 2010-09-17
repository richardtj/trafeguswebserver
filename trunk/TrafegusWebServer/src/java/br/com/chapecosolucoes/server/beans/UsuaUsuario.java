/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Emerson
 */
@Entity
@Table(name = "usua_usuario")
@NamedQueries({
    @NamedQuery(name = "UsuaUsuario.findAll", query = "SELECT u FROM UsuaUsuario u")})
public class UsuaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usua_pfis_pess_oras_codigo", nullable = false)
    private Integer usuaPfisPessOrasCodigo;
    @Column(name = "usua_login", length = 20)
    private String usuaLogin;
    @Column(name = "usua_senha", length = 20)
    private String usuaSenha;
    @OneToMany(mappedBy = "usuaUsuario")
    private Collection<PperProblemaPeriferico> pperProblemaPerifericoCollection;
    @OneToMany(mappedBy = "usuaUsuario")
    private Collection<VterViagemTerminal> vterViagemTerminalCollection;
    @OneToMany(mappedBy = "usuaUsuario")
    private Collection<OrobObjetoRastreadoObs> orobObjetoRastreadoObsCollection;
    @JoinColumn(name = "usua_seto_codigo", referencedColumnName = "seto_codigo")
    @ManyToOne
    private SetoSetor setoSetor;
    @JoinColumn(name = "usua_pfis_pess_oras_codigo", referencedColumnName = "pfis_pess_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PfisPessoaFisica pfisPessoaFisica;
    @JoinColumn(name = "usua_pess_oras_codigo", referencedColumnName = "pess_oras_codigo")
    @ManyToOne
    private PessPessoa pessPessoa;
    @JoinColumn(name = "usua_perf_codigo", referencedColumnName = "perf_codigo")
    @ManyToOne
    private PerfPerfil perfPerfil;
    @OneToMany(mappedBy = "usuaUsuario")
    private Collection<AusuAcessoUsuario> ausuAcessoUsuarioCollection;
    @OneToMany(mappedBy = "usuaUsuario")
    private Collection<EnviEnvio> enviEnvioCollection;
    @OneToMany(mappedBy = "usuaUsuario")
    private Collection<ErusEstacaoRastreamentoUsu> erusEstacaoRastreamentoUsuCollection;
    @OneToMany(mappedBy = "usuaUsuario")
    private Collection<RmliRecebimentoMensagLivre> rmliRecebimentoMensagLivreCollection;
    @OneToMany(mappedBy = "usuaUsuario")
    private Collection<VestViagemEstatus> vestViagemEstatusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuaUsuario")
    private Collection<HtpgHistoricoTrocaPg> htpgHistoricoTrocaPgCollection;

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

    public Collection<PperProblemaPeriferico> getPperProblemaPerifericoCollection() {
        return pperProblemaPerifericoCollection;
    }

    public void setPperProblemaPerifericoCollection(Collection<PperProblemaPeriferico> pperProblemaPerifericoCollection) {
        this.pperProblemaPerifericoCollection = pperProblemaPerifericoCollection;
    }

    public Collection<VterViagemTerminal> getVterViagemTerminalCollection() {
        return vterViagemTerminalCollection;
    }

    public void setVterViagemTerminalCollection(Collection<VterViagemTerminal> vterViagemTerminalCollection) {
        this.vterViagemTerminalCollection = vterViagemTerminalCollection;
    }

    public Collection<OrobObjetoRastreadoObs> getOrobObjetoRastreadoObsCollection() {
        return orobObjetoRastreadoObsCollection;
    }

    public void setOrobObjetoRastreadoObsCollection(Collection<OrobObjetoRastreadoObs> orobObjetoRastreadoObsCollection) {
        this.orobObjetoRastreadoObsCollection = orobObjetoRastreadoObsCollection;
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

    public Collection<AusuAcessoUsuario> getAusuAcessoUsuarioCollection() {
        return ausuAcessoUsuarioCollection;
    }

    public void setAusuAcessoUsuarioCollection(Collection<AusuAcessoUsuario> ausuAcessoUsuarioCollection) {
        this.ausuAcessoUsuarioCollection = ausuAcessoUsuarioCollection;
    }

    public Collection<EnviEnvio> getEnviEnvioCollection() {
        return enviEnvioCollection;
    }

    public void setEnviEnvioCollection(Collection<EnviEnvio> enviEnvioCollection) {
        this.enviEnvioCollection = enviEnvioCollection;
    }

    public Collection<ErusEstacaoRastreamentoUsu> getErusEstacaoRastreamentoUsuCollection() {
        return erusEstacaoRastreamentoUsuCollection;
    }

    public void setErusEstacaoRastreamentoUsuCollection(Collection<ErusEstacaoRastreamentoUsu> erusEstacaoRastreamentoUsuCollection) {
        this.erusEstacaoRastreamentoUsuCollection = erusEstacaoRastreamentoUsuCollection;
    }

    public Collection<RmliRecebimentoMensagLivre> getRmliRecebimentoMensagLivreCollection() {
        return rmliRecebimentoMensagLivreCollection;
    }

    public void setRmliRecebimentoMensagLivreCollection(Collection<RmliRecebimentoMensagLivre> rmliRecebimentoMensagLivreCollection) {
        this.rmliRecebimentoMensagLivreCollection = rmliRecebimentoMensagLivreCollection;
    }

    public Collection<VestViagemEstatus> getVestViagemEstatusCollection() {
        return vestViagemEstatusCollection;
    }

    public void setVestViagemEstatusCollection(Collection<VestViagemEstatus> vestViagemEstatusCollection) {
        this.vestViagemEstatusCollection = vestViagemEstatusCollection;
    }

    public Collection<HtpgHistoricoTrocaPg> getHtpgHistoricoTrocaPgCollection() {
        return htpgHistoricoTrocaPgCollection;
    }

    public void setHtpgHistoricoTrocaPgCollection(Collection<HtpgHistoricoTrocaPg> htpgHistoricoTrocaPgCollection) {
        this.htpgHistoricoTrocaPgCollection = htpgHistoricoTrocaPgCollection;
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
        return "br.com.chapecosolucoes.server.beans.UsuaUsuario[usuaPfisPessOrasCodigo=" + usuaPfisPessOrasCodigo + "]";
    }

}
