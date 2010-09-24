/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

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

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "assd_assistente_detalhe", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "AssdAssistenteDetalhe.findAll", query = "SELECT a FROM AssdAssistenteDetalhe a"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdCodigo", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdCodigo = :assdCodigo"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdDescricaoEtapa", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdDescricaoEtapa = :assdDescricaoEtapa"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdSequencia", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdSequencia = :assdSequencia"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdNivel", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdNivel = :assdNivel"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdCodigoTabelaFramework", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdCodigoTabelaFramework = :assdCodigoTabelaFramework"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdObrigatorio", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdObrigatorio = :assdObrigatorio"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdObservacao", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdObservacao = :assdObservacao"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdDataCadastro", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdDataCadastro = :assdDataCadastro"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdCodigoGr", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdCodigoGr = :assdCodigoGr"),
    @NamedQuery(name = "AssdAssistenteDetalhe.findByAssdImportado", query = "SELECT a FROM AssdAssistenteDetalhe a WHERE a.assdImportado = :assdImportado")})
public class AssdAssistenteDetalhe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "assd_codigo", nullable = false)
    private Integer assdCodigo;
    @Column(name = "assd_descricao_etapa", length = 50)
    private String assdDescricaoEtapa;
    @Column(name = "assd_sequencia")
    private Integer assdSequencia;
    @Column(name = "assd_nivel", length = 10)
    private String assdNivel;
    @Column(name = "assd_codigo_tabela_framework")
    private Integer assdCodigoTabelaFramework;
    @Column(name = "assd_obrigatorio")
    private Character assdObrigatorio;
    @Column(name = "assd_observacao", length = 5000)
    private String assdObservacao;
    @Column(name = "assd_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assdDataCadastro;
    @Column(name = "assd_codigo_gr")
    private Integer assdCodigoGr;
    @Column(name = "assd_importado")
    private Character assdImportado;
    @JoinColumn(name = "assd_assi_codigo", referencedColumnName = "assi_codigo")
    @ManyToOne
    private AssiAssistente assiAssistente;

    public AssdAssistenteDetalhe() {
    }

    public AssdAssistenteDetalhe(Integer assdCodigo) {
        this.assdCodigo = assdCodigo;
    }

    public Integer getAssdCodigo() {
        return assdCodigo;
    }

    public void setAssdCodigo(Integer assdCodigo) {
        this.assdCodigo = assdCodigo;
    }

    public String getAssdDescricaoEtapa() {
        return assdDescricaoEtapa;
    }

    public void setAssdDescricaoEtapa(String assdDescricaoEtapa) {
        this.assdDescricaoEtapa = assdDescricaoEtapa;
    }

    public Integer getAssdSequencia() {
        return assdSequencia;
    }

    public void setAssdSequencia(Integer assdSequencia) {
        this.assdSequencia = assdSequencia;
    }

    public String getAssdNivel() {
        return assdNivel;
    }

    public void setAssdNivel(String assdNivel) {
        this.assdNivel = assdNivel;
    }

    public Integer getAssdCodigoTabelaFramework() {
        return assdCodigoTabelaFramework;
    }

    public void setAssdCodigoTabelaFramework(Integer assdCodigoTabelaFramework) {
        this.assdCodigoTabelaFramework = assdCodigoTabelaFramework;
    }

    public Character getAssdObrigatorio() {
        return assdObrigatorio;
    }

    public void setAssdObrigatorio(Character assdObrigatorio) {
        this.assdObrigatorio = assdObrigatorio;
    }

    public String getAssdObservacao() {
        return assdObservacao;
    }

    public void setAssdObservacao(String assdObservacao) {
        this.assdObservacao = assdObservacao;
    }

    public Date getAssdDataCadastro() {
        return assdDataCadastro;
    }

    public void setAssdDataCadastro(Date assdDataCadastro) {
        this.assdDataCadastro = assdDataCadastro;
    }

    public Integer getAssdCodigoGr() {
        return assdCodigoGr;
    }

    public void setAssdCodigoGr(Integer assdCodigoGr) {
        this.assdCodigoGr = assdCodigoGr;
    }

    public Character getAssdImportado() {
        return assdImportado;
    }

    public void setAssdImportado(Character assdImportado) {
        this.assdImportado = assdImportado;
    }

    public AssiAssistente getAssiAssistente() {
        return assiAssistente;
    }

    public void setAssiAssistente(AssiAssistente assiAssistente) {
        this.assiAssistente = assiAssistente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assdCodigo != null ? assdCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssdAssistenteDetalhe)) {
            return false;
        }
        AssdAssistenteDetalhe other = (AssdAssistenteDetalhe) object;
        if ((this.assdCodigo == null && other.assdCodigo != null) || (this.assdCodigo != null && !this.assdCodigo.equals(other.assdCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.AssdAssistenteDetalhe[assdCodigo=" + assdCodigo + "]";
    }

}
