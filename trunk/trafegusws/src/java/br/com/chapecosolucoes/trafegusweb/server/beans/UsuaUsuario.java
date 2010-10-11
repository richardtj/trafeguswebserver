/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "UsuaUsuario.findAll", query = "SELECT u FROM UsuaUsuario u"),
    @NamedQuery(name = "UsuaUsuario.findByUsuaPfisPessOrasCodigo", query = "SELECT u FROM UsuaUsuario u WHERE u.usuaPfisPessOrasCodigo = :usuaPfisPessOrasCodigo"),
    @NamedQuery(name = "UsuaUsuario.findByUsuaLogin", query = "SELECT u FROM UsuaUsuario u WHERE u.usuaLogin = :usuaLogin"),
    @NamedQuery(name = "UsuaUsuario.findByUsuaSenha", query = "SELECT u FROM UsuaUsuario u WHERE u.usuaSenha = :usuaSenha")})
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
    @OneToMany(mappedBy = "usuaUsuario", fetch = FetchType.EAGER)
    private List<ErusEstacaoRastreamentoUsu> erusEstacaoRastreamentoUsuList;
    @OneToMany(mappedBy = "usuaUsuario", fetch = FetchType.EAGER)
    private List<RmliRecebimentoMensagLivre> rmliRecebimentoMensagLivreList;
    @OneToMany(mappedBy = "usuaUsuario", fetch = FetchType.EAGER)
    private List<VestViagemEstatus> vestViagemEstatusList;
    @OneToMany(mappedBy = "usuaUsuario", fetch = FetchType.EAGER)
    private List<PperProblemaPeriferico> pperProblemaPerifericoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuaUsuario", fetch = FetchType.EAGER)
    private List<HtpgHistoricoTrocaPg> htpgHistoricoTrocaPgList;
    @OneToMany(mappedBy = "usuaUsuario", fetch = FetchType.EAGER)
    private List<VterViagemTerminal> vterViagemTerminalList;
    @OneToMany(mappedBy = "usuaUsuario", fetch = FetchType.EAGER)
    private List<OrobObjetoRastreadoObs> orobObjetoRastreadoObsList;
    @JoinColumn(name = "usua_seto_codigo", referencedColumnName = "seto_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private SetoSetor setoSetor;
    @JoinColumn(name = "usua_pfis_pess_oras_codigo", referencedColumnName = "pfis_pess_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PfisPessoaFisica pfisPessoaFisica;
    @JoinColumn(name = "usua_pess_oras_codigo", referencedColumnName = "pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PessPessoa pessPessoa;
    @JoinColumn(name = "usua_perf_codigo", referencedColumnName = "perf_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PerfPerfil perfPerfil;
    @OneToMany(mappedBy = "usuaUsuario", fetch = FetchType.EAGER)
    private List<AusuAcessoUsuario> ausuAcessoUsuarioList;
    @OneToMany(mappedBy = "usuaUsuario", fetch = FetchType.EAGER)
    private List<EnviEnvio> enviEnvioList;

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

    public List<ErusEstacaoRastreamentoUsu> getErusEstacaoRastreamentoUsuList() {
        return erusEstacaoRastreamentoUsuList;
    }

    public void setErusEstacaoRastreamentoUsuList(List<ErusEstacaoRastreamentoUsu> erusEstacaoRastreamentoUsuList) {
        this.erusEstacaoRastreamentoUsuList = erusEstacaoRastreamentoUsuList;
    }

    public List<RmliRecebimentoMensagLivre> getRmliRecebimentoMensagLivreList() {
        return rmliRecebimentoMensagLivreList;
    }

    public void setRmliRecebimentoMensagLivreList(List<RmliRecebimentoMensagLivre> rmliRecebimentoMensagLivreList) {
        this.rmliRecebimentoMensagLivreList = rmliRecebimentoMensagLivreList;
    }

    public List<VestViagemEstatus> getVestViagemEstatusList() {
        return vestViagemEstatusList;
    }

    public void setVestViagemEstatusList(List<VestViagemEstatus> vestViagemEstatusList) {
        this.vestViagemEstatusList = vestViagemEstatusList;
    }

    public List<PperProblemaPeriferico> getPperProblemaPerifericoList() {
        return pperProblemaPerifericoList;
    }

    public void setPperProblemaPerifericoList(List<PperProblemaPeriferico> pperProblemaPerifericoList) {
        this.pperProblemaPerifericoList = pperProblemaPerifericoList;
    }

    public List<HtpgHistoricoTrocaPg> getHtpgHistoricoTrocaPgList() {
        return htpgHistoricoTrocaPgList;
    }

    public void setHtpgHistoricoTrocaPgList(List<HtpgHistoricoTrocaPg> htpgHistoricoTrocaPgList) {
        this.htpgHistoricoTrocaPgList = htpgHistoricoTrocaPgList;
    }

    public List<VterViagemTerminal> getVterViagemTerminalList() {
        return vterViagemTerminalList;
    }

    public void setVterViagemTerminalList(List<VterViagemTerminal> vterViagemTerminalList) {
        this.vterViagemTerminalList = vterViagemTerminalList;
    }

    public List<OrobObjetoRastreadoObs> getOrobObjetoRastreadoObsList() {
        return orobObjetoRastreadoObsList;
    }

    public void setOrobObjetoRastreadoObsList(List<OrobObjetoRastreadoObs> orobObjetoRastreadoObsList) {
        this.orobObjetoRastreadoObsList = orobObjetoRastreadoObsList;
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

    public List<AusuAcessoUsuario> getAusuAcessoUsuarioList() {
        return ausuAcessoUsuarioList;
    }

    public void setAusuAcessoUsuarioList(List<AusuAcessoUsuario> ausuAcessoUsuarioList) {
        this.ausuAcessoUsuarioList = ausuAcessoUsuarioList;
    }

    public List<EnviEnvio> getEnviEnvioList() {
        return enviEnvioList;
    }

    public void setEnviEnvioList(List<EnviEnvio> enviEnvioList) {
        this.enviEnvioList = enviEnvioList;
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
