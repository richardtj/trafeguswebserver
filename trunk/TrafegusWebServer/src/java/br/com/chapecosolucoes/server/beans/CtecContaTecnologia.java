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
import javax.persistence.FetchType;
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
@Table(name = "ctec_conta_tecnologia", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CtecContaTecnologia.findAll", query = "SELECT c FROM CtecContaTecnologia c"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecCodigo", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecCodigo = :ctecCodigo"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecDescricao", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecDescricao = :ctecDescricao"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecTipoConta", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecTipoConta = :ctecTipoConta"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecNumero", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecNumero = :ctecNumero"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecSenha", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecSenha = :ctecSenha"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecDataCadastro", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecDataCadastro = :ctecDataCadastro"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecCodigoGr", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecCodigoGr = :ctecCodigoGr"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecImportado", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecImportado = :ctecImportado"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecIpIntegracao", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecIpIntegracao = :ctecIpIntegracao"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecCaminhoAplicacao", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecCaminhoAplicacao = :ctecCaminhoAplicacao"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecTolerancia", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecTolerancia = :ctecTolerancia"),
    @NamedQuery(name = "CtecContaTecnologia.findByCtecMonitoradoGuardiao", query = "SELECT c FROM CtecContaTecnologia c WHERE c.ctecMonitoradoGuardiao = :ctecMonitoradoGuardiao")})
public class CtecContaTecnologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ctec_codigo", nullable = false)
    private Integer ctecCodigo;
    @Column(name = "ctec_descricao", length = 50)
    private String ctecDescricao;
    @Column(name = "ctec_tipo_conta", length = 10)
    private String ctecTipoConta;
    @Column(name = "ctec_numero", length = 20)
    private String ctecNumero;
    @Column(name = "ctec_senha", length = 15)
    private String ctecSenha;
    @Column(name = "ctec_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctecDataCadastro;
    @Column(name = "ctec_codigo_gr")
    private Integer ctecCodigoGr;
    @Column(name = "ctec_importado")
    private Character ctecImportado;
    @Column(name = "ctec_ip_integracao", length = 50)
    private String ctecIpIntegracao;
    @Column(name = "ctec_caminho_aplicacao", length = 500)
    private String ctecCaminhoAplicacao;
    @Column(name = "ctec_tolerancia")
    private Integer ctecTolerancia;
    @Column(name = "ctec_monitorado_guardiao")
    private Character ctecMonitoradoGuardiao;
    @OneToMany(mappedBy = "ctecContaTecnologia", fetch = FetchType.EAGER)
    private List<UlsiUltimoLogServicoInteg> ulsiUltimoLogServicoIntegList;
    @OneToMany(mappedBy = "ctecContaTecnologia", fetch = FetchType.EAGER)
    private List<VembVeiculoEmbarcador> vembVeiculoEmbarcadorList;
    @OneToMany(mappedBy = "ctecContaTecnologia", fetch = FetchType.EAGER)
    private List<TermTerminal> termTerminalList;
    @JoinColumn(name = "ctec_tecn_codigo", referencedColumnName = "tecn_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TecnTecnologia tecnTecnologia;
    @OneToMany(mappedBy = "ctecContaTecnologia", fetch = FetchType.EAGER)
    private List<VtraVeiculoTransportador> vtraVeiculoTransportadorList;

    public CtecContaTecnologia() {
    }

    public CtecContaTecnologia(Integer ctecCodigo) {
        this.ctecCodigo = ctecCodigo;
    }

    public Integer getCtecCodigo() {
        return ctecCodigo;
    }

    public void setCtecCodigo(Integer ctecCodigo) {
        this.ctecCodigo = ctecCodigo;
    }

    public String getCtecDescricao() {
        return ctecDescricao;
    }

    public void setCtecDescricao(String ctecDescricao) {
        this.ctecDescricao = ctecDescricao;
    }

    public String getCtecTipoConta() {
        return ctecTipoConta;
    }

    public void setCtecTipoConta(String ctecTipoConta) {
        this.ctecTipoConta = ctecTipoConta;
    }

    public String getCtecNumero() {
        return ctecNumero;
    }

    public void setCtecNumero(String ctecNumero) {
        this.ctecNumero = ctecNumero;
    }

    public String getCtecSenha() {
        return ctecSenha;
    }

    public void setCtecSenha(String ctecSenha) {
        this.ctecSenha = ctecSenha;
    }

    public Date getCtecDataCadastro() {
        return ctecDataCadastro;
    }

    public void setCtecDataCadastro(Date ctecDataCadastro) {
        this.ctecDataCadastro = ctecDataCadastro;
    }

    public Integer getCtecCodigoGr() {
        return ctecCodigoGr;
    }

    public void setCtecCodigoGr(Integer ctecCodigoGr) {
        this.ctecCodigoGr = ctecCodigoGr;
    }

    public Character getCtecImportado() {
        return ctecImportado;
    }

    public void setCtecImportado(Character ctecImportado) {
        this.ctecImportado = ctecImportado;
    }

    public String getCtecIpIntegracao() {
        return ctecIpIntegracao;
    }

    public void setCtecIpIntegracao(String ctecIpIntegracao) {
        this.ctecIpIntegracao = ctecIpIntegracao;
    }

    public String getCtecCaminhoAplicacao() {
        return ctecCaminhoAplicacao;
    }

    public void setCtecCaminhoAplicacao(String ctecCaminhoAplicacao) {
        this.ctecCaminhoAplicacao = ctecCaminhoAplicacao;
    }

    public Integer getCtecTolerancia() {
        return ctecTolerancia;
    }

    public void setCtecTolerancia(Integer ctecTolerancia) {
        this.ctecTolerancia = ctecTolerancia;
    }

    public Character getCtecMonitoradoGuardiao() {
        return ctecMonitoradoGuardiao;
    }

    public void setCtecMonitoradoGuardiao(Character ctecMonitoradoGuardiao) {
        this.ctecMonitoradoGuardiao = ctecMonitoradoGuardiao;
    }

    public List<UlsiUltimoLogServicoInteg> getUlsiUltimoLogServicoIntegList() {
        return ulsiUltimoLogServicoIntegList;
    }

    public void setUlsiUltimoLogServicoIntegList(List<UlsiUltimoLogServicoInteg> ulsiUltimoLogServicoIntegList) {
        this.ulsiUltimoLogServicoIntegList = ulsiUltimoLogServicoIntegList;
    }

    public List<VembVeiculoEmbarcador> getVembVeiculoEmbarcadorList() {
        return vembVeiculoEmbarcadorList;
    }

    public void setVembVeiculoEmbarcadorList(List<VembVeiculoEmbarcador> vembVeiculoEmbarcadorList) {
        this.vembVeiculoEmbarcadorList = vembVeiculoEmbarcadorList;
    }

    public List<TermTerminal> getTermTerminalList() {
        return termTerminalList;
    }

    public void setTermTerminalList(List<TermTerminal> termTerminalList) {
        this.termTerminalList = termTerminalList;
    }

    public TecnTecnologia getTecnTecnologia() {
        return tecnTecnologia;
    }

    public void setTecnTecnologia(TecnTecnologia tecnTecnologia) {
        this.tecnTecnologia = tecnTecnologia;
    }

    public List<VtraVeiculoTransportador> getVtraVeiculoTransportadorList() {
        return vtraVeiculoTransportadorList;
    }

    public void setVtraVeiculoTransportadorList(List<VtraVeiculoTransportador> vtraVeiculoTransportadorList) {
        this.vtraVeiculoTransportadorList = vtraVeiculoTransportadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctecCodigo != null ? ctecCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtecContaTecnologia)) {
            return false;
        }
        CtecContaTecnologia other = (CtecContaTecnologia) object;
        if ((this.ctecCodigo == null && other.ctecCodigo != null) || (this.ctecCodigo != null && !this.ctecCodigo.equals(other.ctecCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.CtecContaTecnologia[ctecCodigo=" + ctecCodigo + "]";
    }

}
