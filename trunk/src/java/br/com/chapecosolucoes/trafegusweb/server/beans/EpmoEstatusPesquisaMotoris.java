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
@Table(name = "epmo_estatus_pesquisa_motoris", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EpmoEstatusPesquisaMotoris.findAll", query = "SELECT e FROM EpmoEstatusPesquisaMotoris e"),
    @NamedQuery(name = "EpmoEstatusPesquisaMotoris.findByEpmoCodigo", query = "SELECT e FROM EpmoEstatusPesquisaMotoris e WHERE e.epmoCodigo = :epmoCodigo"),
    @NamedQuery(name = "EpmoEstatusPesquisaMotoris.findByEpmoDescricao", query = "SELECT e FROM EpmoEstatusPesquisaMotoris e WHERE e.epmoDescricao = :epmoDescricao"),
    @NamedQuery(name = "EpmoEstatusPesquisaMotoris.findByEpmoCodigoGr", query = "SELECT e FROM EpmoEstatusPesquisaMotoris e WHERE e.epmoCodigoGr = :epmoCodigoGr")})
public class EpmoEstatusPesquisaMotoris implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "epmo_codigo", nullable = false)
    private Integer epmoCodigo;
    @Column(name = "epmo_descricao", length = 50)
    private String epmoDescricao;
    @Column(name = "epmo_codigo_gr")
    private Integer epmoCodigoGr;
    @OneToMany(mappedBy = "epmoEstatusPesquisaMotoris")
    private Collection<MotoMotorista> motoMotoristaCollection;
    @OneToMany(mappedBy = "epmoEstatusPesquisaMotoris")
    private Collection<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorCollection;

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

    public Collection<MotoMotorista> getMotoMotoristaCollection() {
        return motoMotoristaCollection;
    }

    public void setMotoMotoristaCollection(Collection<MotoMotorista> motoMotoristaCollection) {
        this.motoMotoristaCollection = motoMotoristaCollection;
    }

    public Collection<HpmoHistoricoPesquisaMotor> getHpmoHistoricoPesquisaMotorCollection() {
        return hpmoHistoricoPesquisaMotorCollection;
    }

    public void setHpmoHistoricoPesquisaMotorCollection(Collection<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorCollection) {
        this.hpmoHistoricoPesquisaMotorCollection = hpmoHistoricoPesquisaMotorCollection;
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
