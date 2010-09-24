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
@Table(name = "sras_separacao_rastreamento", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SrasSeparacaoRastreamento.findAll", query = "SELECT s FROM SrasSeparacaoRastreamento s"),
    @NamedQuery(name = "SrasSeparacaoRastreamento.findBySrasCodigo", query = "SELECT s FROM SrasSeparacaoRastreamento s WHERE s.srasCodigo = :srasCodigo"),
    @NamedQuery(name = "SrasSeparacaoRastreamento.findBySrasDescricao", query = "SELECT s FROM SrasSeparacaoRastreamento s WHERE s.srasDescricao = :srasDescricao")})
public class SrasSeparacaoRastreamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sras_codigo", nullable = false)
    private Integer srasCodigo;
    @Column(name = "sras_descricao", length = 50)
    private String srasDescricao;
    @OneToMany(mappedBy = "srasSeparacaoRastreamento")
    private Collection<ErasEstacaoRastreamento> erasEstacaoRastreamentoCollection;

    public SrasSeparacaoRastreamento() {
    }

    public SrasSeparacaoRastreamento(Integer srasCodigo) {
        this.srasCodigo = srasCodigo;
    }

    public Integer getSrasCodigo() {
        return srasCodigo;
    }

    public void setSrasCodigo(Integer srasCodigo) {
        this.srasCodigo = srasCodigo;
    }

    public String getSrasDescricao() {
        return srasDescricao;
    }

    public void setSrasDescricao(String srasDescricao) {
        this.srasDescricao = srasDescricao;
    }

    public Collection<ErasEstacaoRastreamento> getErasEstacaoRastreamentoCollection() {
        return erasEstacaoRastreamentoCollection;
    }

    public void setErasEstacaoRastreamentoCollection(Collection<ErasEstacaoRastreamento> erasEstacaoRastreamentoCollection) {
        this.erasEstacaoRastreamentoCollection = erasEstacaoRastreamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srasCodigo != null ? srasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrasSeparacaoRastreamento)) {
            return false;
        }
        SrasSeparacaoRastreamento other = (SrasSeparacaoRastreamento) object;
        if ((this.srasCodigo == null && other.srasCodigo != null) || (this.srasCodigo != null && !this.srasCodigo.equals(other.srasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.SrasSeparacaoRastreamento[srasCodigo=" + srasCodigo + "]";
    }

}
