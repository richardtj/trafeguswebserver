/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
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

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "ssis_servico_sistema")
@NamedQueries({
    @NamedQuery(name = "SsisServicoSistema.findAll", query = "SELECT s FROM SsisServicoSistema s"),
    @NamedQuery(name = "SsisServicoSistema.findBySsisCodigo", query = "SELECT s FROM SsisServicoSistema s WHERE s.ssisCodigo = :ssisCodigo"),
    @NamedQuery(name = "SsisServicoSistema.findBySsisDescricao", query = "SELECT s FROM SsisServicoSistema s WHERE s.ssisDescricao = :ssisDescricao"),
    @NamedQuery(name = "SsisServicoSistema.findBySsisTolerancia", query = "SELECT s FROM SsisServicoSistema s WHERE s.ssisTolerancia = :ssisTolerancia")})
public class SsisServicoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ssis_codigo")
    private Integer ssisCodigo;
    @Column(name = "ssis_descricao")
    private String ssisDescricao;
    @Column(name = "ssis_tolerancia")
    private Integer ssisTolerancia;
    @OneToMany(mappedBy = "ssisServicoSistema", fetch = FetchType.EAGER)
    private List<UlsiUltimoLogServicoInteg> ulsiUltimoLogServicoIntegList;
    @OneToMany(mappedBy = "ssisServicoSistema", fetch = FetchType.EAGER)
    private List<SinsServicoInstancia> sinsServicoInstanciaList;
    @OneToMany(mappedBy = "ssisServicoSistema", fetch = FetchType.EAGER)
    private List<SicoServicoIntegracaoConf> sicoServicoIntegracaoConfList;

    public SsisServicoSistema() {
    }

    public SsisServicoSistema(Integer ssisCodigo) {
        this.ssisCodigo = ssisCodigo;
    }

    public Integer getSsisCodigo() {
        return ssisCodigo;
    }

    public void setSsisCodigo(Integer ssisCodigo) {
        this.ssisCodigo = ssisCodigo;
    }

    public String getSsisDescricao() {
        return ssisDescricao;
    }

    public void setSsisDescricao(String ssisDescricao) {
        this.ssisDescricao = ssisDescricao;
    }

    public Integer getSsisTolerancia() {
        return ssisTolerancia;
    }

    public void setSsisTolerancia(Integer ssisTolerancia) {
        this.ssisTolerancia = ssisTolerancia;
    }

    public List<UlsiUltimoLogServicoInteg> getUlsiUltimoLogServicoIntegList() {
        return ulsiUltimoLogServicoIntegList;
    }

    public void setUlsiUltimoLogServicoIntegList(List<UlsiUltimoLogServicoInteg> ulsiUltimoLogServicoIntegList) {
        this.ulsiUltimoLogServicoIntegList = ulsiUltimoLogServicoIntegList;
    }

    public List<SinsServicoInstancia> getSinsServicoInstanciaList() {
        return sinsServicoInstanciaList;
    }

    public void setSinsServicoInstanciaList(List<SinsServicoInstancia> sinsServicoInstanciaList) {
        this.sinsServicoInstanciaList = sinsServicoInstanciaList;
    }

    public List<SicoServicoIntegracaoConf> getSicoServicoIntegracaoConfList() {
        return sicoServicoIntegracaoConfList;
    }

    public void setSicoServicoIntegracaoConfList(List<SicoServicoIntegracaoConf> sicoServicoIntegracaoConfList) {
        this.sicoServicoIntegracaoConfList = sicoServicoIntegracaoConfList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssisCodigo != null ? ssisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsisServicoSistema)) {
            return false;
        }
        SsisServicoSistema other = (SsisServicoSistema) object;
        if ((this.ssisCodigo == null && other.ssisCodigo != null) || (this.ssisCodigo != null && !this.ssisCodigo.equals(other.ssisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.SsisServicoSistema[ssisCodigo=" + ssisCodigo + "]";
    }

}
