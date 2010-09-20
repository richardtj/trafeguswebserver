/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "segu_seguradora", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SeguSeguradora.findAll", query = "SELECT s FROM SeguSeguradora s"),
    @NamedQuery(name = "SeguSeguradora.findBySeguPjurPessOrasCodigo", query = "SELECT s FROM SeguSeguradora s WHERE s.seguPjurPessOrasCodigo = :seguPjurPessOrasCodigo")})
public class SeguSeguradora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "segu_pjur_pess_oras_codigo", nullable = false)
    private Integer seguPjurPessOrasCodigo;
    @OneToMany(mappedBy = "seguSeguradora", fetch = FetchType.EAGER)
    private List<EspgEmbarcSegurPlanoGeren> espgEmbarcSegurPlanoGerenList;
    @OneToMany(mappedBy = "seguSeguradora", fetch = FetchType.EAGER)
    private List<TspgTranspSegurPlanoGeren> tspgTranspSegurPlanoGerenList;
    @OneToMany(mappedBy = "seguSeguradora", fetch = FetchType.EAGER)
    private List<SvteSeguradoraVersaoTecnol> svteSeguradoraVersaoTecnolList;
    @JoinColumn(name = "segu_pjur_pess_oras_codigo", referencedColumnName = "pjur_pess_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PjurPessoaJuridica pjurPessoaJuridica;

    public SeguSeguradora() {
    }

    public SeguSeguradora(Integer seguPjurPessOrasCodigo) {
        this.seguPjurPessOrasCodigo = seguPjurPessOrasCodigo;
    }

    public Integer getSeguPjurPessOrasCodigo() {
        return seguPjurPessOrasCodigo;
    }

    public void setSeguPjurPessOrasCodigo(Integer seguPjurPessOrasCodigo) {
        this.seguPjurPessOrasCodigo = seguPjurPessOrasCodigo;
    }

    public List<EspgEmbarcSegurPlanoGeren> getEspgEmbarcSegurPlanoGerenList() {
        return espgEmbarcSegurPlanoGerenList;
    }

    public void setEspgEmbarcSegurPlanoGerenList(List<EspgEmbarcSegurPlanoGeren> espgEmbarcSegurPlanoGerenList) {
        this.espgEmbarcSegurPlanoGerenList = espgEmbarcSegurPlanoGerenList;
    }

    public List<TspgTranspSegurPlanoGeren> getTspgTranspSegurPlanoGerenList() {
        return tspgTranspSegurPlanoGerenList;
    }

    public void setTspgTranspSegurPlanoGerenList(List<TspgTranspSegurPlanoGeren> tspgTranspSegurPlanoGerenList) {
        this.tspgTranspSegurPlanoGerenList = tspgTranspSegurPlanoGerenList;
    }

    public List<SvteSeguradoraVersaoTecnol> getSvteSeguradoraVersaoTecnolList() {
        return svteSeguradoraVersaoTecnolList;
    }

    public void setSvteSeguradoraVersaoTecnolList(List<SvteSeguradoraVersaoTecnol> svteSeguradoraVersaoTecnolList) {
        this.svteSeguradoraVersaoTecnolList = svteSeguradoraVersaoTecnolList;
    }

    public PjurPessoaJuridica getPjurPessoaJuridica() {
        return pjurPessoaJuridica;
    }

    public void setPjurPessoaJuridica(PjurPessoaJuridica pjurPessoaJuridica) {
        this.pjurPessoaJuridica = pjurPessoaJuridica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguPjurPessOrasCodigo != null ? seguPjurPessOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguSeguradora)) {
            return false;
        }
        SeguSeguradora other = (SeguSeguradora) object;
        if ((this.seguPjurPessOrasCodigo == null && other.seguPjurPessOrasCodigo != null) || (this.seguPjurPessOrasCodigo != null && !this.seguPjurPessOrasCodigo.equals(other.seguPjurPessOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.SeguSeguradora[seguPjurPessOrasCodigo=" + seguPjurPessOrasCodigo + "]";
    }

}
