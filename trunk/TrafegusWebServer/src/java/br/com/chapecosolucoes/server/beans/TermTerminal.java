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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "term_terminal", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"term_vtec_codigo", "term_numero_terminal"})})
@NamedQueries({
    @NamedQuery(name = "TermTerminal.findAll", query = "SELECT t FROM TermTerminal t")})
public class TermTerminal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "term_codigo", nullable = false)
    private Integer termCodigo;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "term_tempo_satelital_padrao")
    private Integer termTempoSatelitalPadrao;
    @Column(name = "term_tempo_gprs_padrao")
    private Integer termTempoGprsPadrao;
    @Column(name = "term_ativo")
    private Character termAtivo;
    @Column(name = "term_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termDataCadastro;
    @Column(name = "term_codigo_gr")
    private Integer termCodigoGr;
    @Column(name = "term_importado")
    private Character termImportado;
    @Column(name = "term_ativo_ws")
    private Character termAtivoWs;
    @OneToMany(mappedBy = "termTerminal")
    private Collection<EsisEventoSistema> esisEventoSistemaCollection;
    @OneToMany(mappedBy = "termTerminal")
    private Collection<VterViagemTerminal> vterViagemTerminalCollection;
    @OneToMany(mappedBy = "termTerminal")
    private Collection<EnviEnvio> enviEnvioCollection;
    @JoinColumn(name = "term_vtec_codigo", referencedColumnName = "vtec_codigo")
    @ManyToOne
    private VtecVersaoTecnologia vtecVersaoTecnologia;
    @JoinColumn(name = "term_oras_codigo", referencedColumnName = "oras_codigo")
    @ManyToOne
    private OrasObjetoRastreado orasObjetoRastreado;
    @JoinColumn(name = "term_gmac_central_veiculo", referencedColumnName = "gmac_codigo")
    @ManyToOne
    private GmacGrupoMacro gmacGrupoMacro;
    @JoinColumn(name = "term_gmac_veiculo_central", referencedColumnName = "gmac_codigo")
    @ManyToOne
    private GmacGrupoMacro gmacGrupoMacro1;
    @JoinColumn(name = "term_eter_codigo", referencedColumnName = "eter_codigo")
    @ManyToOne
    private EterEstatusTerminal eterEstatusTerminal;
    @JoinColumn(name = "term_ctec_codigo", referencedColumnName = "ctec_codigo")
    @ManyToOne
    private CtecContaTecnologia ctecContaTecnologia;
    @OneToMany(mappedBy = "termTerminal")
    private Collection<SterSinalTerminal> sterSinalTerminalCollection;
    @OneToMany(mappedBy = "termTerminal")
    private Collection<PpinPerifericoPadraoInstal> ppinPerifericoPadraoInstalCollection;
    @OneToOne(mappedBy = "termTerminal")
    private OrteObjetoRastreadoTermina orteObjetoRastreadoTermina;

    public TermTerminal() {
    }

    public TermTerminal(Integer termCodigo) {
        this.termCodigo = termCodigo;
    }

    public Integer getTermCodigo() {
        return termCodigo;
    }

    public void setTermCodigo(Integer termCodigo) {
        this.termCodigo = termCodigo;
    }

    public String getTermNumeroTerminal() {
        return termNumeroTerminal;
    }

    public void setTermNumeroTerminal(String termNumeroTerminal) {
        this.termNumeroTerminal = termNumeroTerminal;
    }

    public Integer getTermTempoSatelitalPadrao() {
        return termTempoSatelitalPadrao;
    }

    public void setTermTempoSatelitalPadrao(Integer termTempoSatelitalPadrao) {
        this.termTempoSatelitalPadrao = termTempoSatelitalPadrao;
    }

    public Integer getTermTempoGprsPadrao() {
        return termTempoGprsPadrao;
    }

    public void setTermTempoGprsPadrao(Integer termTempoGprsPadrao) {
        this.termTempoGprsPadrao = termTempoGprsPadrao;
    }

    public Character getTermAtivo() {
        return termAtivo;
    }

    public void setTermAtivo(Character termAtivo) {
        this.termAtivo = termAtivo;
    }

    public Date getTermDataCadastro() {
        return termDataCadastro;
    }

    public void setTermDataCadastro(Date termDataCadastro) {
        this.termDataCadastro = termDataCadastro;
    }

    public Integer getTermCodigoGr() {
        return termCodigoGr;
    }

    public void setTermCodigoGr(Integer termCodigoGr) {
        this.termCodigoGr = termCodigoGr;
    }

    public Character getTermImportado() {
        return termImportado;
    }

    public void setTermImportado(Character termImportado) {
        this.termImportado = termImportado;
    }

    public Character getTermAtivoWs() {
        return termAtivoWs;
    }

    public void setTermAtivoWs(Character termAtivoWs) {
        this.termAtivoWs = termAtivoWs;
    }

    public Collection<EsisEventoSistema> getEsisEventoSistemaCollection() {
        return esisEventoSistemaCollection;
    }

    public void setEsisEventoSistemaCollection(Collection<EsisEventoSistema> esisEventoSistemaCollection) {
        this.esisEventoSistemaCollection = esisEventoSistemaCollection;
    }

    public Collection<VterViagemTerminal> getVterViagemTerminalCollection() {
        return vterViagemTerminalCollection;
    }

    public void setVterViagemTerminalCollection(Collection<VterViagemTerminal> vterViagemTerminalCollection) {
        this.vterViagemTerminalCollection = vterViagemTerminalCollection;
    }

    public Collection<EnviEnvio> getEnviEnvioCollection() {
        return enviEnvioCollection;
    }

    public void setEnviEnvioCollection(Collection<EnviEnvio> enviEnvioCollection) {
        this.enviEnvioCollection = enviEnvioCollection;
    }

    public VtecVersaoTecnologia getVtecVersaoTecnologia() {
        return vtecVersaoTecnologia;
    }

    public void setVtecVersaoTecnologia(VtecVersaoTecnologia vtecVersaoTecnologia) {
        this.vtecVersaoTecnologia = vtecVersaoTecnologia;
    }

    public OrasObjetoRastreado getOrasObjetoRastreado() {
        return orasObjetoRastreado;
    }

    public void setOrasObjetoRastreado(OrasObjetoRastreado orasObjetoRastreado) {
        this.orasObjetoRastreado = orasObjetoRastreado;
    }

    public GmacGrupoMacro getGmacGrupoMacro() {
        return gmacGrupoMacro;
    }

    public void setGmacGrupoMacro(GmacGrupoMacro gmacGrupoMacro) {
        this.gmacGrupoMacro = gmacGrupoMacro;
    }

    public GmacGrupoMacro getGmacGrupoMacro1() {
        return gmacGrupoMacro1;
    }

    public void setGmacGrupoMacro1(GmacGrupoMacro gmacGrupoMacro1) {
        this.gmacGrupoMacro1 = gmacGrupoMacro1;
    }

    public EterEstatusTerminal getEterEstatusTerminal() {
        return eterEstatusTerminal;
    }

    public void setEterEstatusTerminal(EterEstatusTerminal eterEstatusTerminal) {
        this.eterEstatusTerminal = eterEstatusTerminal;
    }

    public CtecContaTecnologia getCtecContaTecnologia() {
        return ctecContaTecnologia;
    }

    public void setCtecContaTecnologia(CtecContaTecnologia ctecContaTecnologia) {
        this.ctecContaTecnologia = ctecContaTecnologia;
    }

    public Collection<SterSinalTerminal> getSterSinalTerminalCollection() {
        return sterSinalTerminalCollection;
    }

    public void setSterSinalTerminalCollection(Collection<SterSinalTerminal> sterSinalTerminalCollection) {
        this.sterSinalTerminalCollection = sterSinalTerminalCollection;
    }

    public Collection<PpinPerifericoPadraoInstal> getPpinPerifericoPadraoInstalCollection() {
        return ppinPerifericoPadraoInstalCollection;
    }

    public void setPpinPerifericoPadraoInstalCollection(Collection<PpinPerifericoPadraoInstal> ppinPerifericoPadraoInstalCollection) {
        this.ppinPerifericoPadraoInstalCollection = ppinPerifericoPadraoInstalCollection;
    }

    public OrteObjetoRastreadoTermina getOrteObjetoRastreadoTermina() {
        return orteObjetoRastreadoTermina;
    }

    public void setOrteObjetoRastreadoTermina(OrteObjetoRastreadoTermina orteObjetoRastreadoTermina) {
        this.orteObjetoRastreadoTermina = orteObjetoRastreadoTermina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (termCodigo != null ? termCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TermTerminal)) {
            return false;
        }
        TermTerminal other = (TermTerminal) object;
        if ((this.termCodigo == null && other.termCodigo != null) || (this.termCodigo != null && !this.termCodigo.equals(other.termCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.TermTerminal[termCodigo=" + termCodigo + "]";
    }

}
