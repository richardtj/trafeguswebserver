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
@Table(name = "cpad_comando_padrao", catalog = "trafegus_transc", schema = "public")
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
    @Column(name = "cpad_codigo", nullable = false)
    private Integer cpadCodigo;
    @Column(name = "cpad_descricao", length = 100)
    private String cpadDescricao;
    @Column(name = "cpad_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpadDataCadastro;
    @Column(name = "cpad_codigo_gr")
    private Integer cpadCodigoGr;
    @Column(name = "cpad_importado")
    private Character cpadImportado;
    @OneToMany(mappedBy = "cpadComandoPadrao", fetch = FetchType.EAGER)
    private List<CvteComandoVersaoTecnologi> cvteComandoVersaoTecnologiList;
    @OneToMany(mappedBy = "cpadComandoPadrao", fetch = FetchType.EAGER)
    private List<PcpaParametroComandoPadrao> pcpaParametroComandoPadraoList;
    @OneToMany(mappedBy = "cpadComandoPadrao", fetch = FetchType.EAGER)
    private List<AcomAcaoComando> acomAcaoComandoList;
    @OneToMany(mappedBy = "cpadComandoPadrao", fetch = FetchType.EAGER)
    private List<EcomEnvioComando> ecomEnvioComandoList;

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

    public List<CvteComandoVersaoTecnologi> getCvteComandoVersaoTecnologiList() {
        return cvteComandoVersaoTecnologiList;
    }

    public void setCvteComandoVersaoTecnologiList(List<CvteComandoVersaoTecnologi> cvteComandoVersaoTecnologiList) {
        this.cvteComandoVersaoTecnologiList = cvteComandoVersaoTecnologiList;
    }

    public List<PcpaParametroComandoPadrao> getPcpaParametroComandoPadraoList() {
        return pcpaParametroComandoPadraoList;
    }

    public void setPcpaParametroComandoPadraoList(List<PcpaParametroComandoPadrao> pcpaParametroComandoPadraoList) {
        this.pcpaParametroComandoPadraoList = pcpaParametroComandoPadraoList;
    }

    public List<AcomAcaoComando> getAcomAcaoComandoList() {
        return acomAcaoComandoList;
    }

    public void setAcomAcaoComandoList(List<AcomAcaoComando> acomAcaoComandoList) {
        this.acomAcaoComandoList = acomAcaoComandoList;
    }

    public List<EcomEnvioComando> getEcomEnvioComandoList() {
        return ecomEnvioComandoList;
    }

    public void setEcomEnvioComandoList(List<EcomEnvioComando> ecomEnvioComandoList) {
        this.ecomEnvioComandoList = ecomEnvioComandoList;
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
        return "br.com.chapecosolucoes.server.beans.CpadComandoPadrao[cpadCodigo=" + cpadCodigo + "]";
    }

}
