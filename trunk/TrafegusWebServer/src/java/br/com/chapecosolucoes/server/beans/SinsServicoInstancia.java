/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "sins_servico_instancia")
@NamedQueries({
    @NamedQuery(name = "SinsServicoInstancia.findAll", query = "SELECT s FROM SinsServicoInstancia s")})
public class SinsServicoInstancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sins_codigo", nullable = false)
    private Integer sinsCodigo;
    @Column(name = "sins_ip_servico", length = 20)
    private String sinsIpServico;
    @Column(name = "sins_caminho_aplicacao", length = 500)
    private String sinsCaminhoAplicacao;
    @Column(name = "sins_monitorado_guardiao")
    private Character sinsMonitoradoGuardiao;
    @JoinColumn(name = "sins_ssis_codigo", referencedColumnName = "ssis_codigo")
    @ManyToOne
    private SsisServicoSistema ssisServicoSistema;

    public SinsServicoInstancia() {
    }

    public SinsServicoInstancia(Integer sinsCodigo) {
        this.sinsCodigo = sinsCodigo;
    }

    public Integer getSinsCodigo() {
        return sinsCodigo;
    }

    public void setSinsCodigo(Integer sinsCodigo) {
        this.sinsCodigo = sinsCodigo;
    }

    public String getSinsIpServico() {
        return sinsIpServico;
    }

    public void setSinsIpServico(String sinsIpServico) {
        this.sinsIpServico = sinsIpServico;
    }

    public String getSinsCaminhoAplicacao() {
        return sinsCaminhoAplicacao;
    }

    public void setSinsCaminhoAplicacao(String sinsCaminhoAplicacao) {
        this.sinsCaminhoAplicacao = sinsCaminhoAplicacao;
    }

    public Character getSinsMonitoradoGuardiao() {
        return sinsMonitoradoGuardiao;
    }

    public void setSinsMonitoradoGuardiao(Character sinsMonitoradoGuardiao) {
        this.sinsMonitoradoGuardiao = sinsMonitoradoGuardiao;
    }

    public SsisServicoSistema getSsisServicoSistema() {
        return ssisServicoSistema;
    }

    public void setSsisServicoSistema(SsisServicoSistema ssisServicoSistema) {
        this.ssisServicoSistema = ssisServicoSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sinsCodigo != null ? sinsCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SinsServicoInstancia)) {
            return false;
        }
        SinsServicoInstancia other = (SinsServicoInstancia) object;
        if ((this.sinsCodigo == null && other.sinsCodigo != null) || (this.sinsCodigo != null && !this.sinsCodigo.equals(other.sinsCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.SinsServicoInstancia[sinsCodigo=" + sinsCodigo + "]";
    }

}
