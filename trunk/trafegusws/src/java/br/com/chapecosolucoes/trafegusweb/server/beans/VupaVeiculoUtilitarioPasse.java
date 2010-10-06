/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "vupa_veiculo_utilitario_passe")
@NamedQueries({
    @NamedQuery(name = "VupaVeiculoUtilitarioPasse.findAll", query = "SELECT v FROM VupaVeiculoUtilitarioPasse v"),
    @NamedQuery(name = "VupaVeiculoUtilitarioPasse.findByVupaVeicOrasCodigo", query = "SELECT v FROM VupaVeiculoUtilitarioPasse v WHERE v.vupaVeicOrasCodigo = :vupaVeicOrasCodigo")})
public class VupaVeiculoUtilitarioPasse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vupa_veic_oras_codigo")
    private Integer vupaVeicOrasCodigo;
    @JoinColumn(name = "vupa_veic_oras_codigo", referencedColumnName = "veic_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "vupa_tope_codigo", referencedColumnName = "tope_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private TopeTipoOperacao topeTipoOperacao;
    @JoinColumn(name = "vupa_eras_codigo", referencedColumnName = "eras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private ErasEstacaoRastreamento erasEstacaoRastreamento;

    public VupaVeiculoUtilitarioPasse() {
    }

    public VupaVeiculoUtilitarioPasse(Integer vupaVeicOrasCodigo) {
        this.vupaVeicOrasCodigo = vupaVeicOrasCodigo;
    }

    public Integer getVupaVeicOrasCodigo() {
        return vupaVeicOrasCodigo;
    }

    public void setVupaVeicOrasCodigo(Integer vupaVeicOrasCodigo) {
        this.vupaVeicOrasCodigo = vupaVeicOrasCodigo;
    }

    public VeicVeiculo getVeicVeiculo() {
        return veicVeiculo;
    }

    public void setVeicVeiculo(VeicVeiculo veicVeiculo) {
        this.veicVeiculo = veicVeiculo;
    }

    public TopeTipoOperacao getTopeTipoOperacao() {
        return topeTipoOperacao;
    }

    public void setTopeTipoOperacao(TopeTipoOperacao topeTipoOperacao) {
        this.topeTipoOperacao = topeTipoOperacao;
    }

    public ErasEstacaoRastreamento getErasEstacaoRastreamento() {
        return erasEstacaoRastreamento;
    }

    public void setErasEstacaoRastreamento(ErasEstacaoRastreamento erasEstacaoRastreamento) {
        this.erasEstacaoRastreamento = erasEstacaoRastreamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vupaVeicOrasCodigo != null ? vupaVeicOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VupaVeiculoUtilitarioPasse)) {
            return false;
        }
        VupaVeiculoUtilitarioPasse other = (VupaVeiculoUtilitarioPasse) object;
        if ((this.vupaVeicOrasCodigo == null && other.vupaVeicOrasCodigo != null) || (this.vupaVeicOrasCodigo != null && !this.vupaVeicOrasCodigo.equals(other.vupaVeicOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VupaVeiculoUtilitarioPasse[vupaVeicOrasCodigo=" + vupaVeicOrasCodigo + "]";
    }

}
