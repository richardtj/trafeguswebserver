/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "comb_comboio")
@NamedQueries({
    @NamedQuery(name = "CombComboio.findAll", query = "SELECT c FROM CombComboio c")})
public class CombComboio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "comb_codigo")
    private Integer combCodigo;
    @Column(name = "comb_descricao")
    private String combDescricao;
    @Column(name = "comb_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date combDataCadastro;
    @Column(name = "comb_codigo_gr")
    private Integer combCodigoGr;
    @Column(name = "comb_importado")
    private Character combImportado;
    @JoinColumn(name = "comb_eesc_pesj_pess_oras_codigo", referencedColumnName = "eesc_oras_pess_pesj_codigo")
    @ManyToOne
    private EescEmpresaEscolta eescEmpresaEscolta;
    @OneToMany(mappedBy = "combComboio")
    private Set<VveiViagemVeiculo> vveiViagemVeiculoSet;

    public CombComboio() {
    }

    public CombComboio(Integer combCodigo) {
        this.combCodigo = combCodigo;
    }

    public Integer getCombCodigo() {
        return combCodigo;
    }

    public void setCombCodigo(Integer combCodigo) {
        this.combCodigo = combCodigo;
    }

    public String getCombDescricao() {
        return combDescricao;
    }

    public void setCombDescricao(String combDescricao) {
        this.combDescricao = combDescricao;
    }

    public Date getCombDataCadastro() {
        return combDataCadastro;
    }

    public void setCombDataCadastro(Date combDataCadastro) {
        this.combDataCadastro = combDataCadastro;
    }

    public Integer getCombCodigoGr() {
        return combCodigoGr;
    }

    public void setCombCodigoGr(Integer combCodigoGr) {
        this.combCodigoGr = combCodigoGr;
    }

    public Character getCombImportado() {
        return combImportado;
    }

    public void setCombImportado(Character combImportado) {
        this.combImportado = combImportado;
    }

    public EescEmpresaEscolta getEescEmpresaEscolta() {
        return eescEmpresaEscolta;
    }

    public void setEescEmpresaEscolta(EescEmpresaEscolta eescEmpresaEscolta) {
        this.eescEmpresaEscolta = eescEmpresaEscolta;
    }

    public Set<VveiViagemVeiculo> getVveiViagemVeiculoSet() {
        return vveiViagemVeiculoSet;
    }

    public void setVveiViagemVeiculoSet(Set<VveiViagemVeiculo> vveiViagemVeiculoSet) {
        this.vveiViagemVeiculoSet = vveiViagemVeiculoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (combCodigo != null ? combCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CombComboio)) {
            return false;
        }
        CombComboio other = (CombComboio) object;
        if ((this.combCodigo == null && other.combCodigo != null) || (this.combCodigo != null && !this.combCodigo.equals(other.combCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CombComboio[combCodigo=" + combCodigo + "]";
    }

}
