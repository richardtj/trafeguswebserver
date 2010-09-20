/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ccob_configuracao_cobranca", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CcobConfiguracaoCobranca.findAll", query = "SELECT c FROM CcobConfiguracaoCobranca c"),
    @NamedQuery(name = "CcobConfiguracaoCobranca.findByCcobCodigo", query = "SELECT c FROM CcobConfiguracaoCobranca c WHERE c.ccobCodigo = :ccobCodigo"),
    @NamedQuery(name = "CcobConfiguracaoCobranca.findByCcobQuantidadeMinimaObjetoRastreado", query = "SELECT c FROM CcobConfiguracaoCobranca c WHERE c.ccobQuantidadeMinimaObjetoRastreado = :ccobQuantidadeMinimaObjetoRastreado"),
    @NamedQuery(name = "CcobConfiguracaoCobranca.findByCcobQuantidadeMaximaObjetoRastreado", query = "SELECT c FROM CcobConfiguracaoCobranca c WHERE c.ccobQuantidadeMaximaObjetoRastreado = :ccobQuantidadeMaximaObjetoRastreado"),
    @NamedQuery(name = "CcobConfiguracaoCobranca.findByCcobValorDia", query = "SELECT c FROM CcobConfiguracaoCobranca c WHERE c.ccobValorDia = :ccobValorDia"),
    @NamedQuery(name = "CcobConfiguracaoCobranca.findByCcobQuantidadeMinimaDias", query = "SELECT c FROM CcobConfiguracaoCobranca c WHERE c.ccobQuantidadeMinimaDias = :ccobQuantidadeMinimaDias"),
    @NamedQuery(name = "CcobConfiguracaoCobranca.findByCcobDataCadastro", query = "SELECT c FROM CcobConfiguracaoCobranca c WHERE c.ccobDataCadastro = :ccobDataCadastro"),
    @NamedQuery(name = "CcobConfiguracaoCobranca.findByCcobCodigoGr", query = "SELECT c FROM CcobConfiguracaoCobranca c WHERE c.ccobCodigoGr = :ccobCodigoGr"),
    @NamedQuery(name = "CcobConfiguracaoCobranca.findByCcobImportado", query = "SELECT c FROM CcobConfiguracaoCobranca c WHERE c.ccobImportado = :ccobImportado")})
public class CcobConfiguracaoCobranca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ccob_codigo", nullable = false)
    private Integer ccobCodigo;
    @Column(name = "ccob_quantidade_minima_objeto_rastreado")
    private Integer ccobQuantidadeMinimaObjetoRastreado;
    @Column(name = "ccob_quantidade_maxima_objeto_rastreado")
    private Integer ccobQuantidadeMaximaObjetoRastreado;
    @Column(name = "ccob_valor_dia", precision = 15, scale = 2)
    private BigDecimal ccobValorDia;
    @Column(name = "ccob_quantidade_minima_dias")
    private Integer ccobQuantidadeMinimaDias;
    @Column(name = "ccob_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccobDataCadastro;
    @Column(name = "ccob_codigo_gr")
    private Integer ccobCodigoGr;
    @Column(name = "ccob_importado")
    private Character ccobImportado;

    public CcobConfiguracaoCobranca() {
    }

    public CcobConfiguracaoCobranca(Integer ccobCodigo) {
        this.ccobCodigo = ccobCodigo;
    }

    public Integer getCcobCodigo() {
        return ccobCodigo;
    }

    public void setCcobCodigo(Integer ccobCodigo) {
        this.ccobCodigo = ccobCodigo;
    }

    public Integer getCcobQuantidadeMinimaObjetoRastreado() {
        return ccobQuantidadeMinimaObjetoRastreado;
    }

    public void setCcobQuantidadeMinimaObjetoRastreado(Integer ccobQuantidadeMinimaObjetoRastreado) {
        this.ccobQuantidadeMinimaObjetoRastreado = ccobQuantidadeMinimaObjetoRastreado;
    }

    public Integer getCcobQuantidadeMaximaObjetoRastreado() {
        return ccobQuantidadeMaximaObjetoRastreado;
    }

    public void setCcobQuantidadeMaximaObjetoRastreado(Integer ccobQuantidadeMaximaObjetoRastreado) {
        this.ccobQuantidadeMaximaObjetoRastreado = ccobQuantidadeMaximaObjetoRastreado;
    }

    public BigDecimal getCcobValorDia() {
        return ccobValorDia;
    }

    public void setCcobValorDia(BigDecimal ccobValorDia) {
        this.ccobValorDia = ccobValorDia;
    }

    public Integer getCcobQuantidadeMinimaDias() {
        return ccobQuantidadeMinimaDias;
    }

    public void setCcobQuantidadeMinimaDias(Integer ccobQuantidadeMinimaDias) {
        this.ccobQuantidadeMinimaDias = ccobQuantidadeMinimaDias;
    }

    public Date getCcobDataCadastro() {
        return ccobDataCadastro;
    }

    public void setCcobDataCadastro(Date ccobDataCadastro) {
        this.ccobDataCadastro = ccobDataCadastro;
    }

    public Integer getCcobCodigoGr() {
        return ccobCodigoGr;
    }

    public void setCcobCodigoGr(Integer ccobCodigoGr) {
        this.ccobCodigoGr = ccobCodigoGr;
    }

    public Character getCcobImportado() {
        return ccobImportado;
    }

    public void setCcobImportado(Character ccobImportado) {
        this.ccobImportado = ccobImportado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccobCodigo != null ? ccobCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CcobConfiguracaoCobranca)) {
            return false;
        }
        CcobConfiguracaoCobranca other = (CcobConfiguracaoCobranca) object;
        if ((this.ccobCodigo == null && other.ccobCodigo != null) || (this.ccobCodigo != null && !this.ccobCodigo.equals(other.ccobCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.CcobConfiguracaoCobranca[ccobCodigo=" + ccobCodigo + "]";
    }

}
