/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "SsisServicoSistema.findAll", query = "SELECT s FROM SsisServicoSistema s")})
public class SsisServicoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ssis_codigo", nullable = false)
    private Integer ssisCodigo;
    @Column(name = "ssis_descricao", length = 50)
    private String ssisDescricao;
    @Column(name = "ssis_tolerancia")
    private Integer ssisTolerancia;
    @OneToMany(mappedBy = "ssisServicoSistema")
    private Collection<UlsiUltimoLogServicoInteg> ulsiUltimoLogServicoIntegCollection;
    @OneToMany(mappedBy = "ssisServicoSistema")
    private Collection<SinsServicoInstancia> sinsServicoInstanciaCollection;
    @OneToMany(mappedBy = "ssisServicoSistema")
    private Collection<SicoServicoIntegracaoConf> sicoServicoIntegracaoConfCollection;

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

    public Collection<UlsiUltimoLogServicoInteg> getUlsiUltimoLogServicoIntegCollection() {
        return ulsiUltimoLogServicoIntegCollection;
    }

    public void setUlsiUltimoLogServicoIntegCollection(Collection<UlsiUltimoLogServicoInteg> ulsiUltimoLogServicoIntegCollection) {
        this.ulsiUltimoLogServicoIntegCollection = ulsiUltimoLogServicoIntegCollection;
    }

    public Collection<SinsServicoInstancia> getSinsServicoInstanciaCollection() {
        return sinsServicoInstanciaCollection;
    }

    public void setSinsServicoInstanciaCollection(Collection<SinsServicoInstancia> sinsServicoInstanciaCollection) {
        this.sinsServicoInstanciaCollection = sinsServicoInstanciaCollection;
    }

    public Collection<SicoServicoIntegracaoConf> getSicoServicoIntegracaoConfCollection() {
        return sicoServicoIntegracaoConfCollection;
    }

    public void setSicoServicoIntegracaoConfCollection(Collection<SicoServicoIntegracaoConf> sicoServicoIntegracaoConfCollection) {
        this.sicoServicoIntegracaoConfCollection = sicoServicoIntegracaoConfCollection;
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
        return "br.com.chapecosolucoes.server.beans.SsisServicoSistema[ssisCodigo=" + ssisCodigo + "]";
    }

}
