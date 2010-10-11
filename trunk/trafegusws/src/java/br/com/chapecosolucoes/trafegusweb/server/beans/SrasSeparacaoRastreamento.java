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
@Table(name = "sras_separacao_rastreamento")
@NamedQueries({
    @NamedQuery(name = "SrasSeparacaoRastreamento.findAll", query = "SELECT s FROM SrasSeparacaoRastreamento s"),
    @NamedQuery(name = "SrasSeparacaoRastreamento.findBySrasCodigo", query = "SELECT s FROM SrasSeparacaoRastreamento s WHERE s.srasCodigo = :srasCodigo"),
    @NamedQuery(name = "SrasSeparacaoRastreamento.findBySrasDescricao", query = "SELECT s FROM SrasSeparacaoRastreamento s WHERE s.srasDescricao = :srasDescricao")})
public class SrasSeparacaoRastreamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sras_codigo")
    private Integer srasCodigo;
    @Column(name = "sras_descricao")
    private String srasDescricao;
    @OneToMany(mappedBy = "srasSeparacaoRastreamento", fetch = FetchType.EAGER)
    private List<ErasEstacaoRastreamento> erasEstacaoRastreamentoList;

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

    public List<ErasEstacaoRastreamento> getErasEstacaoRastreamentoList() {
        return erasEstacaoRastreamentoList;
    }

    public void setErasEstacaoRastreamentoList(List<ErasEstacaoRastreamento> erasEstacaoRastreamentoList) {
        this.erasEstacaoRastreamentoList = erasEstacaoRastreamentoList;
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
