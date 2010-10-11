/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "moto_motorista")
@NamedQueries({
    @NamedQuery(name = "MotoMotorista.findAll", query = "SELECT m FROM MotoMotorista m"),
    @NamedQuery(name = "MotoMotorista.findByMotoPfisPessOrasCodigo", query = "SELECT m FROM MotoMotorista m WHERE m.motoPfisPessOrasCodigo = :motoPfisPessOrasCodigo"),
    @NamedQuery(name = "MotoMotorista.findByMotoNumeroCnh", query = "SELECT m FROM MotoMotorista m WHERE m.motoNumeroCnh = :motoNumeroCnh"),
    @NamedQuery(name = "MotoMotorista.findByMotoCategoriaCnh", query = "SELECT m FROM MotoMotorista m WHERE m.motoCategoriaCnh = :motoCategoriaCnh"),
    @NamedQuery(name = "MotoMotorista.findByMotoValidadeCnh", query = "SELECT m FROM MotoMotorista m WHERE m.motoValidadeCnh = :motoValidadeCnh"),
    @NamedQuery(name = "MotoMotorista.findByMotoSenha", query = "SELECT m FROM MotoMotorista m WHERE m.motoSenha = :motoSenha"),
    @NamedQuery(name = "MotoMotorista.findByMotoTreinado", query = "SELECT m FROM MotoMotorista m WHERE m.motoTreinado = :motoTreinado"),
    @NamedQuery(name = "MotoMotorista.findByMotoUltimoTreinamento", query = "SELECT m FROM MotoMotorista m WHERE m.motoUltimoTreinamento = :motoUltimoTreinamento"),
    @NamedQuery(name = "MotoMotorista.findByMotoValidadePesquisa", query = "SELECT m FROM MotoMotorista m WHERE m.motoValidadePesquisa = :motoValidadePesquisa")})
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
    @OneToMany(mappedBy = "motoMotorista", fetch = FetchType.EAGER)
    private List<VeicVeiculo> veicVeiculoList;
    @OneToMany(mappedBy = "motoMotorista", fetch = FetchType.EAGER)
    private List<MtraMotoristaTransportador> mtraMotoristaTransportadorList;
    @JoinColumn(name = "moto_pfis_pess_oras_codigo", referencedColumnName = "pfis_pess_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PfisPessoaFisica pfisPessoaFisica;
    @JoinColumn(name = "moto_epmo_codigo", referencedColumnName = "epmo_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private EpmoEstatusPesquisaMotoris epmoEstatusPesquisaMotoris;
    @OneToMany(mappedBy = "motoMotorista", fetch = FetchType.EAGER)
    private List<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorList;
    @OneToMany(mappedBy = "motoMotorista", fetch = FetchType.EAGER)
    private List<VveiViagemVeiculo> vveiViagemVeiculoList;

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

    public List<VeicVeiculo> getVeicVeiculoList() {
        return veicVeiculoList;
    }

    public void setVeicVeiculoList(List<VeicVeiculo> veicVeiculoList) {
        this.veicVeiculoList = veicVeiculoList;
    }

    public List<MtraMotoristaTransportador> getMtraMotoristaTransportadorList() {
        return mtraMotoristaTransportadorList;
    }

    public void setMtraMotoristaTransportadorList(List<MtraMotoristaTransportador> mtraMotoristaTransportadorList) {
        this.mtraMotoristaTransportadorList = mtraMotoristaTransportadorList;
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

    public List<HpmoHistoricoPesquisaMotor> getHpmoHistoricoPesquisaMotorList() {
        return hpmoHistoricoPesquisaMotorList;
    }

    public void setHpmoHistoricoPesquisaMotorList(List<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorList) {
        this.hpmoHistoricoPesquisaMotorList = hpmoHistoricoPesquisaMotorList;
    }

    public List<VveiViagemVeiculo> getVveiViagemVeiculoList() {
        return vveiViagemVeiculoList;
    }

    public void setVveiViagemVeiculoList(List<VveiViagemVeiculo> vveiViagemVeiculoList) {
        this.vveiViagemVeiculoList = vveiViagemVeiculoList;
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
