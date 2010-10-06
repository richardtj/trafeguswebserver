/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cont_container")
@NamedQueries({
    @NamedQuery(name = "ContContainer.findAll", query = "SELECT c FROM ContContainer c"),
    @NamedQuery(name = "ContContainer.findByContOrasCodigo", query = "SELECT c FROM ContContainer c WHERE c.contOrasCodigo = :contOrasCodigo"),
    @NamedQuery(name = "ContContainer.findByContIdentificador", query = "SELECT c FROM ContContainer c WHERE c.contIdentificador = :contIdentificador")})
public class ContContainer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cont_oras_codigo")
    private Integer contOrasCodigo;
    @Column(name = "cont_identificador")
    private String contIdentificador;
    @JoinColumn(name = "cont_oras_codigo", referencedColumnName = "oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private OrasObjetoRastreado orasObjetoRastreado;
    @JoinColumn(name = "cont_eras_codigo", referencedColumnName = "eras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private ErasEstacaoRastreamento erasEstacaoRastreamento;
    @OneToMany(mappedBy = "contContainer", fetch = FetchType.LAZY)
    private Collection<VccaVeiculoCavaloCarreta> vccaVeiculoCavaloCarretaCollection;

    public ContContainer() {
    }

    public ContContainer(Integer contOrasCodigo) {
        this.contOrasCodigo = contOrasCodigo;
    }

    public Integer getContOrasCodigo() {
        return contOrasCodigo;
    }

    public void setContOrasCodigo(Integer contOrasCodigo) {
        this.contOrasCodigo = contOrasCodigo;
    }

    public String getContIdentificador() {
        return contIdentificador;
    }

    public void setContIdentificador(String contIdentificador) {
        this.contIdentificador = contIdentificador;
    }

    public OrasObjetoRastreado getOrasObjetoRastreado() {
        return orasObjetoRastreado;
    }

    public void setOrasObjetoRastreado(OrasObjetoRastreado orasObjetoRastreado) {
        this.orasObjetoRastreado = orasObjetoRastreado;
    }

    public ErasEstacaoRastreamento getErasEstacaoRastreamento() {
        return erasEstacaoRastreamento;
    }

    public void setErasEstacaoRastreamento(ErasEstacaoRastreamento erasEstacaoRastreamento) {
        this.erasEstacaoRastreamento = erasEstacaoRastreamento;
    }

    public Collection<VccaVeiculoCavaloCarreta> getVccaVeiculoCavaloCarretaCollection() {
        return vccaVeiculoCavaloCarretaCollection;
    }

    public void setVccaVeiculoCavaloCarretaCollection(Collection<VccaVeiculoCavaloCarreta> vccaVeiculoCavaloCarretaCollection) {
        this.vccaVeiculoCavaloCarretaCollection = vccaVeiculoCavaloCarretaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contOrasCodigo != null ? contOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContContainer)) {
            return false;
        }
        ContContainer other = (ContContainer) object;
        if ((this.contOrasCodigo == null && other.contOrasCodigo != null) || (this.contOrasCodigo != null && !this.contOrasCodigo.equals(other.contOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.ContContainer[contOrasCodigo=" + contOrasCodigo + "]";
    }

}
