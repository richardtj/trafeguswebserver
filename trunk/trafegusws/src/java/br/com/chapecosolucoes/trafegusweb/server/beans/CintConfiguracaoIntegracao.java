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
@Table(name = "cint_configuracao_integracao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CintConfiguracaoIntegracao.findAll", query = "SELECT c FROM CintConfiguracaoIntegracao c"),
    @NamedQuery(name = "CintConfiguracaoIntegracao.findByCintCodigo", query = "SELECT c FROM CintConfiguracaoIntegracao c WHERE c.cintCodigo = :cintCodigo"),
    @NamedQuery(name = "CintConfiguracaoIntegracao.findByCintHistoricoDia", query = "SELECT c FROM CintConfiguracaoIntegracao c WHERE c.cintHistoricoDia = :cintHistoricoDia"),
    @NamedQuery(name = "CintConfiguracaoIntegracao.findByCintDataCadastro", query = "SELECT c FROM CintConfiguracaoIntegracao c WHERE c.cintDataCadastro = :cintDataCadastro"),
    @NamedQuery(name = "CintConfiguracaoIntegracao.findByCintCodigoGr", query = "SELECT c FROM CintConfiguracaoIntegracao c WHERE c.cintCodigoGr = :cintCodigoGr"),
    @NamedQuery(name = "CintConfiguracaoIntegracao.findByCintImportado", query = "SELECT c FROM CintConfiguracaoIntegracao c WHERE c.cintImportado = :cintImportado")})
public class CintConfiguracaoIntegracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cint_codigo", nullable = false)
    private Integer cintCodigo;
    @Column(name = "cint_historico_dia", length = 10)
    private String cintHistoricoDia;
    @Column(name = "cint_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cintDataCadastro;
    @Column(name = "cint_codigo_gr")
    private Integer cintCodigoGr;
    @Column(name = "cint_importado")
    private Character cintImportado;

    public CintConfiguracaoIntegracao() {
    }

    public CintConfiguracaoIntegracao(Integer cintCodigo) {
        this.cintCodigo = cintCodigo;
    }

    public Integer getCintCodigo() {
        return cintCodigo;
    }

    public void setCintCodigo(Integer cintCodigo) {
        this.cintCodigo = cintCodigo;
    }

    public String getCintHistoricoDia() {
        return cintHistoricoDia;
    }

    public void setCintHistoricoDia(String cintHistoricoDia) {
        this.cintHistoricoDia = cintHistoricoDia;
    }

    public Date getCintDataCadastro() {
        return cintDataCadastro;
    }

    public void setCintDataCadastro(Date cintDataCadastro) {
        this.cintDataCadastro = cintDataCadastro;
    }

    public Integer getCintCodigoGr() {
        return cintCodigoGr;
    }

    public void setCintCodigoGr(Integer cintCodigoGr) {
        this.cintCodigoGr = cintCodigoGr;
    }

    public Character getCintImportado() {
        return cintImportado;
    }

    public void setCintImportado(Character cintImportado) {
        this.cintImportado = cintImportado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cintCodigo != null ? cintCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CintConfiguracaoIntegracao)) {
            return false;
        }
        CintConfiguracaoIntegracao other = (CintConfiguracaoIntegracao) object;
        if ((this.cintCodigo == null && other.cintCodigo != null) || (this.cintCodigo != null && !this.cintCodigo.equals(other.cintCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CintConfiguracaoIntegracao[cintCodigo=" + cintCodigo + "]";
    }

}