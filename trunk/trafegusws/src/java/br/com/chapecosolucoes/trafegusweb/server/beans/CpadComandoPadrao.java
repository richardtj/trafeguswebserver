/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cpad_comando_padrao")
@NamedQueries({
    @NamedQuery(name = "CpadComandoPadrao.findAll", query = "SELECT c FROM CpadComandoPadrao c"),
    @NamedQuery(name = "CpadComandoPadrao.findByCpadCodigo", query = "SELECT c FROM CpadComandoPadrao c WHERE c.cpadCodigo = :cpadCodigo"),
    @NamedQuery(name = "CpadComandoPadrao.findByCpadDescricao", query = "SELECT c FROM CpadComandoPadrao c WHERE c.cpadDescricao = :cpadDescricao"),
    @NamedQuery(name = "CpadComandoPadrao.findByCpadDataCadastro", query = "SELECT c FROM CpadComandoPadrao c WHERE c.cpadDataCadastro = :cpadDataCadastro"),
    @NamedQuery(name = "CpadComandoPadrao.findByCpadCodigoGr", query = "SELECT c FROM CpadComandoPadrao c WHERE c.cpadCodigoGr = :cpadCodigoGr"),
    @NamedQuery(name = "CpadComandoPadrao.findByCpadImportado", query = "SELECT c FROM CpadComandoPadrao c WHERE c.cpadImportado = :cpadImportado")})
public class CpadComandoPadrao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpad_codigo")
    private Integer cpadCodigo;
    @Column(name = "cpad_descricao")
    private String cpadDescricao;
    @Column(name = "cpad_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpadDataCadastro;
    @Column(name = "cpad_codigo_gr")
    private Integer cpadCodigoGr;
    @Column(name = "cpad_importado")
    private Character cpadImportado;
    @OneToMany(mappedBy = "cpadComandoPadrao", fetch = FetchType.LAZY)
    private Collection<PcpaParametroComandoPadrao> pcpaParametroComandoPadraoCollection;
    @OneToMany(mappedBy = "cpadComandoPadrao", fetch = FetchType.LAZY)
    private Collection<CvteComandoVersaoTecnologi> cvteComandoVersaoTecnologiCollection;
    @OneToMany(mappedBy = "cpadComandoPadrao", fetch = FetchType.LAZY)
    private Collection<AcomAcaoComando> acomAcaoComandoCollection;
    @OneToMany(mappedBy = "cpadComandoPadrao", fetch = FetchType.LAZY)
    private Collection<EcomEnvioComando> ecomEnvioComandoCollection;

    public CpadComandoPadrao() {
    }

    public CpadComandoPadrao(Integer cpadCodigo) {
        this.cpadCodigo = cpadCodigo;
    }

    public Integer getCpadCodigo() {
        return cpadCodigo;
    }

    public void setCpadCodigo(Integer cpadCodigo) {
        this.cpadCodigo = cpadCodigo;
    }

    public String getCpadDescricao() {
        return cpadDescricao;
    }

    public void setCpadDescricao(String cpadDescricao) {
        this.cpadDescricao = cpadDescricao;
    }

    public Date getCpadDataCadastro() {
        return cpadDataCadastro;
    }

    public void setCpadDataCadastro(Date cpadDataCadastro) {
        this.cpadDataCadastro = cpadDataCadastro;
    }

    public Integer getCpadCodigoGr() {
        return cpadCodigoGr;
    }

    public void setCpadCodigoGr(Integer cpadCodigoGr) {
        this.cpadCodigoGr = cpadCodigoGr;
    }

    public Character getCpadImportado() {
        return cpadImportado;
    }

    public void setCpadImportado(Character cpadImportado) {
        this.cpadImportado = cpadImportado;
    }

    public Collection<PcpaParametroComandoPadrao> getPcpaParametroComandoPadraoCollection() {
        return pcpaParametroComandoPadraoCollection;
    }

    public void setPcpaParametroComandoPadraoCollection(Collection<PcpaParametroComandoPadrao> pcpaParametroComandoPadraoCollection) {
        this.pcpaParametroComandoPadraoCollection = pcpaParametroComandoPadraoCollection;
    }

    public Collection<CvteComandoVersaoTecnologi> getCvteComandoVersaoTecnologiCollection() {
        return cvteComandoVersaoTecnologiCollection;
    }

    public void setCvteComandoVersaoTecnologiCollection(Collection<CvteComandoVersaoTecnologi> cvteComandoVersaoTecnologiCollection) {
        this.cvteComandoVersaoTecnologiCollection = cvteComandoVersaoTecnologiCollection;
    }

    public Collection<AcomAcaoComando> getAcomAcaoComandoCollection() {
        return acomAcaoComandoCollection;
    }

    public void setAcomAcaoComandoCollection(Collection<AcomAcaoComando> acomAcaoComandoCollection) {
        this.acomAcaoComandoCollection = acomAcaoComandoCollection;
    }

    public Collection<EcomEnvioComando> getEcomEnvioComandoCollection() {
        return ecomEnvioComandoCollection;
    }

    public void setEcomEnvioComandoCollection(Collection<EcomEnvioComando> ecomEnvioComandoCollection) {
        this.ecomEnvioComandoCollection = ecomEnvioComandoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpadCodigo != null ? cpadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CpadComandoPadrao)) {
            return false;
        }
        CpadComandoPadrao other = (CpadComandoPadrao) object;
        if ((this.cpadCodigo == null && other.cpadCodigo != null) || (this.cpadCodigo != null && !this.cpadCodigo.equals(other.cpadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CpadComandoPadrao[cpadCodigo=" + cpadCodigo + "]";
    }

}
