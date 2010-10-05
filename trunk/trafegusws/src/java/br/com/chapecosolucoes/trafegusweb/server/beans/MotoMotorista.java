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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "moto_motorista")
@NamedQueries({
    @NamedQuery(name = "MotoMotorista.findAll", query = "SELECT m FROM MotoMotorista m")})
public class MotoMotorista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "moto_pfis_pess_oras_codigo")
    private Integer motoPfisPessOrasCodigo;
    @Column(name = "moto_numero_cnh")
    private String motoNumeroCnh;
    @Column(name = "moto_categoria_cnh")
    private String motoCategoriaCnh;
    @Column(name = "moto_validade_cnh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date motoValidadeCnh;
    @Column(name = "moto_senha")
    private String motoSenha;
    @Column(name = "moto_treinado")
    private Character motoTreinado;
    @Column(name = "moto_ultimo_treinamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date motoUltimoTreinamento;
    @Column(name = "moto_validade_pesquisa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date motoValidadePesquisa;
    @OneToMany(mappedBy = "motoMotorista")
    private Set<VeicVeiculo> veicVeiculoSet;
    @JoinColumn(name = "moto_pfis_pess_oras_codigo", referencedColumnName = "pfis_pess_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PfisPessoaFisica pfisPessoaFisica;
    @JoinColumn(name = "moto_epmo_codigo", referencedColumnName = "epmo_codigo")
    @ManyToOne
    private EpmoEstatusPesquisaMotoris epmoEstatusPesquisaMotoris;
    @OneToMany(mappedBy = "motoMotorista")
    private Set<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorSet;
    @OneToMany(mappedBy = "motoMotorista")
    private Set<VveiViagemVeiculo> vveiViagemVeiculoSet;

    public MotoMotorista() {
    }

    public MotoMotorista(Integer motoPfisPessOrasCodigo) {
        this.motoPfisPessOrasCodigo = motoPfisPessOrasCodigo;
    }

    public Integer getMotoPfisPessOrasCodigo() {
        return motoPfisPessOrasCodigo;
    }

    public void setMotoPfisPessOrasCodigo(Integer motoPfisPessOrasCodigo) {
        this.motoPfisPessOrasCodigo = motoPfisPessOrasCodigo;
    }

    public String getMotoNumeroCnh() {
        return motoNumeroCnh;
    }

    public void setMotoNumeroCnh(String motoNumeroCnh) {
        this.motoNumeroCnh = motoNumeroCnh;
    }

    public String getMotoCategoriaCnh() {
        return motoCategoriaCnh;
    }

    public void setMotoCategoriaCnh(String motoCategoriaCnh) {
        this.motoCategoriaCnh = motoCategoriaCnh;
    }

    public Date getMotoValidadeCnh() {
        return motoValidadeCnh;
    }

    public void setMotoValidadeCnh(Date motoValidadeCnh) {
        this.motoValidadeCnh = motoValidadeCnh;
    }

    public String getMotoSenha() {
        return motoSenha;
    }

    public void setMotoSenha(String motoSenha) {
        this.motoSenha = motoSenha;
    }

    public Character getMotoTreinado() {
        return motoTreinado;
    }

    public void setMotoTreinado(Character motoTreinado) {
        this.motoTreinado = motoTreinado;
    }

    public Date getMotoUltimoTreinamento() {
        return motoUltimoTreinamento;
    }

    public void setMotoUltimoTreinamento(Date motoUltimoTreinamento) {
        this.motoUltimoTreinamento = motoUltimoTreinamento;
    }

    public Date getMotoValidadePesquisa() {
        return motoValidadePesquisa;
    }

    public void setMotoValidadePesquisa(Date motoValidadePesquisa) {
        this.motoValidadePesquisa = motoValidadePesquisa;
    }

    public Set<VeicVeiculo> getVeicVeiculoSet() {
        return veicVeiculoSet;
    }

    public void setVeicVeiculoSet(Set<VeicVeiculo> veicVeiculoSet) {
        this.veicVeiculoSet = veicVeiculoSet;
    }

    public PfisPessoaFisica getPfisPessoaFisica() {
        return pfisPessoaFisica;
    }

    public void setPfisPessoaFisica(PfisPessoaFisica pfisPessoaFisica) {
        this.pfisPessoaFisica = pfisPessoaFisica;
    }

    public EpmoEstatusPesquisaMotoris getEpmoEstatusPesquisaMotoris() {
        return epmoEstatusPesquisaMotoris;
    }

    public void setEpmoEstatusPesquisaMotoris(EpmoEstatusPesquisaMotoris epmoEstatusPesquisaMotoris) {
        this.epmoEstatusPesquisaMotoris = epmoEstatusPesquisaMotoris;
    }

    public Set<HpmoHistoricoPesquisaMotor> getHpmoHistoricoPesquisaMotorSet() {
        return hpmoHistoricoPesquisaMotorSet;
    }

    public void setHpmoHistoricoPesquisaMotorSet(Set<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorSet) {
        this.hpmoHistoricoPesquisaMotorSet = hpmoHistoricoPesquisaMotorSet;
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
        hash += (motoPfisPessOrasCodigo != null ? motoPfisPessOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotoMotorista)) {
            return false;
        }
        MotoMotorista other = (MotoMotorista) object;
        if ((this.motoPfisPessOrasCodigo == null && other.motoPfisPessOrasCodigo != null) || (this.motoPfisPessOrasCodigo != null && !this.motoPfisPessOrasCodigo.equals(other.motoPfisPessOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.MotoMotorista[motoPfisPessOrasCodigo=" + motoPfisPessOrasCodigo + "]";
    }

}
