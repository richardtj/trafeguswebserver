/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Set;
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
 * @author emerson
 */
@Entity
@Table(name = "epmo_estatus_pesquisa_motoris")
@NamedQueries({
    @NamedQuery(name = "EpmoEstatusPesquisaMotoris.findAll", query = "SELECT e FROM EpmoEstatusPesquisaMotoris e")})
public class EpmoEstatusPesquisaMotoris implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "epmo_codigo")
    private Integer epmoCodigo;
    @Column(name = "epmo_descricao")
    private String epmoDescricao;
    @Column(name = "epmo_codigo_gr")
    private Integer epmoCodigoGr;
    @OneToMany(mappedBy = "epmoEstatusPesquisaMotoris")
    private Set<MotoMotorista> motoMotoristaSet;
    @OneToMany(mappedBy = "epmoEstatusPesquisaMotoris")
    private Set<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorSet;

    public EpmoEstatusPesquisaMotoris() {
    }

    public EpmoEstatusPesquisaMotoris(Integer epmoCodigo) {
        this.epmoCodigo = epmoCodigo;
    }

    public Integer getEpmoCodigo() {
        return epmoCodigo;
    }

    public void setEpmoCodigo(Integer epmoCodigo) {
        this.epmoCodigo = epmoCodigo;
    }

    public String getEpmoDescricao() {
        return epmoDescricao;
    }

    public void setEpmoDescricao(String epmoDescricao) {
        this.epmoDescricao = epmoDescricao;
    }

    public Integer getEpmoCodigoGr() {
        return epmoCodigoGr;
    }

    public void setEpmoCodigoGr(Integer epmoCodigoGr) {
        this.epmoCodigoGr = epmoCodigoGr;
    }

    public Set<MotoMotorista> getMotoMotoristaSet() {
        return motoMotoristaSet;
    }

    public void setMotoMotoristaSet(Set<MotoMotorista> motoMotoristaSet) {
        this.motoMotoristaSet = motoMotoristaSet;
    }

    public Set<HpmoHistoricoPesquisaMotor> getHpmoHistoricoPesquisaMotorSet() {
        return hpmoHistoricoPesquisaMotorSet;
    }

    public void setHpmoHistoricoPesquisaMotorSet(Set<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorSet) {
        this.hpmoHistoricoPesquisaMotorSet = hpmoHistoricoPesquisaMotorSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epmoCodigo != null ? epmoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EpmoEstatusPesquisaMotoris)) {
            return false;
        }
        EpmoEstatusPesquisaMotoris other = (EpmoEstatusPesquisaMotoris) object;
        if ((this.epmoCodigo == null && other.epmoCodigo != null) || (this.epmoCodigo != null && !this.epmoCodigo.equals(other.epmoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EpmoEstatusPesquisaMotoris[epmoCodigo=" + epmoCodigo + "]";
    }

}
