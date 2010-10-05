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
 * @author emerson
 */
@Entity
@Table(name = "vtec_versao_tecnologia")
@NamedQueries({
    @NamedQuery(name = "VtecVersaoTecnologia.findAll", query = "SELECT v FROM VtecVersaoTecnologia v")})
public class VtecVersaoTecnologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vtec_codigo")
    private Integer vtecCodigo;
    @Column(name = "vtec_descricao")
    private String vtecDescricao;
    @Column(name = "vtec_versao")
    private String vtecVersao;
    @Column(name = "vtec_tipo_comunicacao")
    private String vtecTipoComunicacao;
    @Column(name = "vtec_tempo_satelital_padrao")
    private Integer vtecTempoSatelitalPadrao;
    @Column(name = "vtec_tempo_gprs_padrao")
    private Integer vtecTempoGprsPadrao;
    @Column(name = "vtec_homologado_risco")
    private Character vtecHomologadoRisco;
    @Column(name = "vtec_homologado_logistica")
    private Character vtecHomologadoLogistica;
    @Column(name = "vtec_permite_mensagem_livre")
    private Character vtecPermiteMensagemLivre;
    @Column(name = "vtec_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vtecDataCadastro;
    @Column(name = "vtec_codigo_gr")
    private Integer vtecCodigoGr;
    @Column(name = "vtec_importado")
    private Character vtecImportado;
    @OneToMany(mappedBy = "vtecVersaoTecnologia")
    private Set<TermTerminal> termTerminalSet;
    @JoinColumn(name = "vtec_tecn_codigo", referencedColumnName = "tecn_codigo")
    @ManyToOne
    private TecnTecnologia tecnTecnologia;
    @JoinColumn(name = "vtec_tcom_codigo", referencedColumnName = "tcom_codigo")
    @ManyToOne
    private TcomTipoComunicacao tcomTipoComunicacao;
    @OneToMany(mappedBy = "vtecVersaoTecnologia")
    private Set<GmacGrupoMacro> gmacGrupoMacroSet;

    public VtecVersaoTecnologia() {
    }

    public VtecVersaoTecnologia(Integer vtecCodigo) {
        this.vtecCodigo = vtecCodigo;
    }

    public Integer getVtecCodigo() {
        return vtecCodigo;
    }

    public void setVtecCodigo(Integer vtecCodigo) {
        this.vtecCodigo = vtecCodigo;
    }

    public String getVtecDescricao() {
        return vtecDescricao;
    }

    public void setVtecDescricao(String vtecDescricao) {
        this.vtecDescricao = vtecDescricao;
    }

    public String getVtecVersao() {
        return vtecVersao;
    }

    public void setVtecVersao(String vtecVersao) {
        this.vtecVersao = vtecVersao;
    }

    public String getVtecTipoComunicacao() {
        return vtecTipoComunicacao;
    }

    public void setVtecTipoComunicacao(String vtecTipoComunicacao) {
        this.vtecTipoComunicacao = vtecTipoComunicacao;
    }

    public Integer getVtecTempoSatelitalPadrao() {
        return vtecTempoSatelitalPadrao;
    }

    public void setVtecTempoSatelitalPadrao(Integer vtecTempoSatelitalPadrao) {
        this.vtecTempoSatelitalPadrao = vtecTempoSatelitalPadrao;
    }

    public Integer getVtecTempoGprsPadrao() {
        return vtecTempoGprsPadrao;
    }

    public void setVtecTempoGprsPadrao(Integer vtecTempoGprsPadrao) {
        this.vtecTempoGprsPadrao = vtecTempoGprsPadrao;
    }

    public Character getVtecHomologadoRisco() {
        return vtecHomologadoRisco;
    }

    public void setVtecHomologadoRisco(Character vtecHomologadoRisco) {
        this.vtecHomologadoRisco = vtecHomologadoRisco;
    }

    public Character getVtecHomologadoLogistica() {
        return vtecHomologadoLogistica;
    }

    public void setVtecHomologadoLogistica(Character vtecHomologadoLogistica) {
        this.vtecHomologadoLogistica = vtecHomologadoLogistica;
    }

    public Character getVtecPermiteMensagemLivre() {
        return vtecPermiteMensagemLivre;
    }

    public void setVtecPermiteMensagemLivre(Character vtecPermiteMensagemLivre) {
        this.vtecPermiteMensagemLivre = vtecPermiteMensagemLivre;
    }

    public Date getVtecDataCadastro() {
        return vtecDataCadastro;
    }

    public void setVtecDataCadastro(Date vtecDataCadastro) {
        this.vtecDataCadastro = vtecDataCadastro;
    }

    public Integer getVtecCodigoGr() {
        return vtecCodigoGr;
    }

    public void setVtecCodigoGr(Integer vtecCodigoGr) {
        this.vtecCodigoGr = vtecCodigoGr;
    }

    public Character getVtecImportado() {
        return vtecImportado;
    }

    public void setVtecImportado(Character vtecImportado) {
        this.vtecImportado = vtecImportado;
    }

    public Set<TermTerminal> getTermTerminalSet() {
        return termTerminalSet;
    }

    public void setTermTerminalSet(Set<TermTerminal> termTerminalSet) {
        this.termTerminalSet = termTerminalSet;
    }

    public TecnTecnologia getTecnTecnologia() {
        return tecnTecnologia;
    }

    public void setTecnTecnologia(TecnTecnologia tecnTecnologia) {
        this.tecnTecnologia = tecnTecnologia;
    }

    public TcomTipoComunicacao getTcomTipoComunicacao() {
        return tcomTipoComunicacao;
    }

    public void setTcomTipoComunicacao(TcomTipoComunicacao tcomTipoComunicacao) {
        this.tcomTipoComunicacao = tcomTipoComunicacao;
    }

    public Set<GmacGrupoMacro> getGmacGrupoMacroSet() {
        return gmacGrupoMacroSet;
    }

    public void setGmacGrupoMacroSet(Set<GmacGrupoMacro> gmacGrupoMacroSet) {
        this.gmacGrupoMacroSet = gmacGrupoMacroSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vtecCodigo != null ? vtecCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtecVersaoTecnologia)) {
            return false;
        }
        VtecVersaoTecnologia other = (VtecVersaoTecnologia) object;
        if ((this.vtecCodigo == null && other.vtecCodigo != null) || (this.vtecCodigo != null && !this.vtecCodigo.equals(other.vtecCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VtecVersaoTecnologia[vtecCodigo=" + vtecCodigo + "]";
    }

}
