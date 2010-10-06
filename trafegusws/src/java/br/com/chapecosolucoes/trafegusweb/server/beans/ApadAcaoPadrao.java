/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "apad_acao_padrao")
@NamedQueries({
    @NamedQuery(name = "ApadAcaoPadrao.findAll", query = "SELECT a FROM ApadAcaoPadrao a"),
    @NamedQuery(name = "ApadAcaoPadrao.findByApadCodigo", query = "SELECT a FROM ApadAcaoPadrao a WHERE a.apadCodigo = :apadCodigo"),
    @NamedQuery(name = "ApadAcaoPadrao.findByApadDescricao", query = "SELECT a FROM ApadAcaoPadrao a WHERE a.apadDescricao = :apadDescricao"),
    @NamedQuery(name = "ApadAcaoPadrao.findByApadCodigoGr", query = "SELECT a FROM ApadAcaoPadrao a WHERE a.apadCodigoGr = :apadCodigoGr"),
    @NamedQuery(name = "ApadAcaoPadrao.findByApadTipoAcao", query = "SELECT a FROM ApadAcaoPadrao a WHERE a.apadTipoAcao = :apadTipoAcao"),
    @NamedQuery(name = "ApadAcaoPadrao.findByApadTempoEspera", query = "SELECT a FROM ApadAcaoPadrao a WHERE a.apadTempoEspera = :apadTempoEspera")})
public class ApadAcaoPadrao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "apad_codigo")
    private Integer apadCodigo;
    @Column(name = "apad_descricao")
    private String apadDescricao;
    @Column(name = "apad_codigo_gr")
    private Integer apadCodigoGr;
    @Column(name = "apad_tipo_acao")
    private String apadTipoAcao;
    @Column(name = "apad_tempo_espera")
    private Integer apadTempoEspera;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apadAcaoPadrao", fetch = FetchType.LAZY)
    private AlinAcaoLinha alinAcaoLinha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apadAcaoPadrao", fetch = FetchType.LAZY)
    private AbolAcaoBolinha abolAcaoBolinha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apadAcaoPadrao", fetch = FetchType.LAZY)
    private AbeeAcaoBeep abeeAcaoBeep;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apadAcaoPadrao", fetch = FetchType.LAZY)
    private AcomAcaoComando acomAcaoComando;
    @OneToMany(mappedBy = "apadAcaoPadrao", fetch = FetchType.LAZY)
    private Collection<PaiaPgAssociaItemAcao> paiaPgAssociaItemAcaoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apadAcaoPadrao", fetch = FetchType.LAZY)
    private ApopAcaoPopup apopAcaoPopup;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apadAcaoPadrao", fetch = FetchType.LAZY)
    private AmacAcaoMacro amacAcaoMacro;

    public ApadAcaoPadrao() {
    }

    public ApadAcaoPadrao(Integer apadCodigo) {
        this.apadCodigo = apadCodigo;
    }

    public Integer getApadCodigo() {
        return apadCodigo;
    }

    public void setApadCodigo(Integer apadCodigo) {
        this.apadCodigo = apadCodigo;
    }

    public String getApadDescricao() {
        return apadDescricao;
    }

    public void setApadDescricao(String apadDescricao) {
        this.apadDescricao = apadDescricao;
    }

    public Integer getApadCodigoGr() {
        return apadCodigoGr;
    }

    public void setApadCodigoGr(Integer apadCodigoGr) {
        this.apadCodigoGr = apadCodigoGr;
    }

    public String getApadTipoAcao() {
        return apadTipoAcao;
    }

    public void setApadTipoAcao(String apadTipoAcao) {
        this.apadTipoAcao = apadTipoAcao;
    }

    public Integer getApadTempoEspera() {
        return apadTempoEspera;
    }

    public void setApadTempoEspera(Integer apadTempoEspera) {
        this.apadTempoEspera = apadTempoEspera;
    }

    public AlinAcaoLinha getAlinAcaoLinha() {
        return alinAcaoLinha;
    }

    public void setAlinAcaoLinha(AlinAcaoLinha alinAcaoLinha) {
        this.alinAcaoLinha = alinAcaoLinha;
    }

    public AbolAcaoBolinha getAbolAcaoBolinha() {
        return abolAcaoBolinha;
    }

    public void setAbolAcaoBolinha(AbolAcaoBolinha abolAcaoBolinha) {
        this.abolAcaoBolinha = abolAcaoBolinha;
    }

    public AbeeAcaoBeep getAbeeAcaoBeep() {
        return abeeAcaoBeep;
    }

    public void setAbeeAcaoBeep(AbeeAcaoBeep abeeAcaoBeep) {
        this.abeeAcaoBeep = abeeAcaoBeep;
    }

    public AcomAcaoComando getAcomAcaoComando() {
        return acomAcaoComando;
    }

    public void setAcomAcaoComando(AcomAcaoComando acomAcaoComando) {
        this.acomAcaoComando = acomAcaoComando;
    }

    public Collection<PaiaPgAssociaItemAcao> getPaiaPgAssociaItemAcaoCollection() {
        return paiaPgAssociaItemAcaoCollection;
    }

    public void setPaiaPgAssociaItemAcaoCollection(Collection<PaiaPgAssociaItemAcao> paiaPgAssociaItemAcaoCollection) {
        this.paiaPgAssociaItemAcaoCollection = paiaPgAssociaItemAcaoCollection;
    }

    public ApopAcaoPopup getApopAcaoPopup() {
        return apopAcaoPopup;
    }

    public void setApopAcaoPopup(ApopAcaoPopup apopAcaoPopup) {
        this.apopAcaoPopup = apopAcaoPopup;
    }

    public AmacAcaoMacro getAmacAcaoMacro() {
        return amacAcaoMacro;
    }

    public void setAmacAcaoMacro(AmacAcaoMacro amacAcaoMacro) {
        this.amacAcaoMacro = amacAcaoMacro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apadCodigo != null ? apadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApadAcaoPadrao)) {
            return false;
        }
        ApadAcaoPadrao other = (ApadAcaoPadrao) object;
        if ((this.apadCodigo == null && other.apadCodigo != null) || (this.apadCodigo != null && !this.apadCodigo.equals(other.apadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.ApadAcaoPadrao[apadCodigo=" + apadCodigo + "]";
    }

}
