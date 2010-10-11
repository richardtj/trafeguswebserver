/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "vvei_viagem_veiculo")
@NamedQueries({
    @NamedQuery(name = "VveiViagemVeiculo.findAll", query = "SELECT v FROM VveiViagemVeiculo v"),
    @NamedQuery(name = "VveiViagemVeiculo.findByVveiCodigo", query = "SELECT v FROM VveiViagemVeiculo v WHERE v.vveiCodigo = :vveiCodigo"),
    @NamedQuery(name = "VveiViagemVeiculo.findByVveiPrecedencia", query = "SELECT v FROM VveiViagemVeiculo v WHERE v.vveiPrecedencia = :vveiPrecedencia"),
    @NamedQuery(name = "VveiViagemVeiculo.findByVveiDataInicioComboio", query = "SELECT v FROM VveiViagemVeiculo v WHERE v.vveiDataInicioComboio = :vveiDataInicioComboio"),
    @NamedQuery(name = "VveiViagemVeiculo.findByVveiDataFimComboio", query = "SELECT v FROM VveiViagemVeiculo v WHERE v.vveiDataFimComboio = :vveiDataFimComboio"),
    @NamedQuery(name = "VveiViagemVeiculo.findByVveiAtivo", query = "SELECT v FROM VveiViagemVeiculo v WHERE v.vveiAtivo = :vveiAtivo"),
    @NamedQuery(name = "VveiViagemVeiculo.findByVveiSequencia", query = "SELECT v FROM VveiViagemVeiculo v WHERE v.vveiSequencia = :vveiSequencia"),
    @NamedQuery(name = "VveiViagemVeiculo.findByVveiDataCadastro", query = "SELECT v FROM VveiViagemVeiculo v WHERE v.vveiDataCadastro = :vveiDataCadastro"),
    @NamedQuery(name = "VveiViagemVeiculo.findByVveiCodigoGr", query = "SELECT v FROM VveiViagemVeiculo v WHERE v.vveiCodigoGr = :vveiCodigoGr"),
    @NamedQuery(name = "VveiViagemVeiculo.findByVveiImportado", query = "SELECT v FROM VveiViagemVeiculo v WHERE v.vveiImportado = :vveiImportado")})
public class VveiViagemVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vvei_codigo")
    private Integer vveiCodigo;
    @Column(name = "vvei_precedencia")
    private String vveiPrecedencia;
    @Column(name = "vvei_data_inicio_comboio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vveiDataInicioComboio;
    @Column(name = "vvei_data_fim_comboio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vveiDataFimComboio;
    @Column(name = "vvei_ativo")
    private String vveiAtivo;
    @Column(name = "vvei_sequencia")
    private Integer vveiSequencia;
    @Column(name = "vvei_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vveiDataCadastro;
    @Column(name = "vvei_codigo_gr")
    private Integer vveiCodigoGr;
    @Column(name = "vvei_importado")
    private Character vveiImportado;
    @JoinColumn(name = "vvei_viag_codigo", referencedColumnName = "viag_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private ViagViagem viagViagem;
    @JoinColumn(name = "vvei_veic_oras_codigo", referencedColumnName = "veic_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "vvei_moto_pfis_pess_oras_codigo", referencedColumnName = "moto_pfis_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private MotoMotorista motoMotorista;
    @JoinColumn(name = "vvei_evca_codigo", referencedColumnName = "evca_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private EvcaEstatusVeiculoCarga evcaEstatusVeiculoCarga;
    @JoinColumn(name = "vvei_comb_codigo", referencedColumnName = "comb_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private CombComboio combComboio;

    public VveiViagemVeiculo() {
    }

    public VveiViagemVeiculo(Integer vveiCodigo) {
        this.vveiCodigo = vveiCodigo;
    }

    public Integer getVveiCodigo() {
        return vveiCodigo;
    }

    public void setVveiCodigo(Integer vveiCodigo) {
        this.vveiCodigo = vveiCodigo;
    }

    public String getVveiPrecedencia() {
        return vveiPrecedencia;
    }

    public void setVveiPrecedencia(String vveiPrecedencia) {
        this.vveiPrecedencia = vveiPrecedencia;
    }

    public Date getVveiDataInicioComboio() {
        return vveiDataInicioComboio;
    }

    public void setVveiDataInicioComboio(Date vveiDataInicioComboio) {
        this.vveiDataInicioComboio = vveiDataInicioComboio;
    }

    public Date getVveiDataFimComboio() {
        return vveiDataFimComboio;
    }

    public void setVveiDataFimComboio(Date vveiDataFimComboio) {
        this.vveiDataFimComboio = vveiDataFimComboio;
    }

    public String getVveiAtivo() {
        return vveiAtivo;
    }

    public void setVveiAtivo(String vveiAtivo) {
        this.vveiAtivo = vveiAtivo;
    }

    public Integer getVveiSequencia() {
        return vveiSequencia;
    }

    public void setVveiSequencia(Integer vveiSequencia) {
        this.vveiSequencia = vveiSequencia;
    }

    public Date getVveiDataCadastro() {
        return vveiDataCadastro;
    }

    public void setVveiDataCadastro(Date vveiDataCadastro) {
        this.vveiDataCadastro = vveiDataCadastro;
    }

    public Integer getVveiCodigoGr() {
        return vveiCodigoGr;
    }

    public void setVveiCodigoGr(Integer vveiCodigoGr) {
        this.vveiCodigoGr = vveiCodigoGr;
    }

    public Character getVveiImportado() {
        return vveiImportado;
    }

    public void setVveiImportado(Character vveiImportado) {
        this.vveiImportado = vveiImportado;
    }

    public ViagViagem getViagViagem() {
        return viagViagem;
    }

    public void setViagViagem(ViagViagem viagViagem) {
        this.viagViagem = viagViagem;
    }

    public VeicVeiculo getVeicVeiculo() {
        return veicVeiculo;
    }

    public void setVeicVeiculo(VeicVeiculo veicVeiculo) {
        this.veicVeiculo = veicVeiculo;
    }

    public MotoMotorista getMotoMotorista() {
        return motoMotorista;
    }

    public void setMotoMotorista(MotoMotorista motoMotorista) {
        this.motoMotorista = motoMotorista;
    }

    public EvcaEstatusVeiculoCarga getEvcaEstatusVeiculoCarga() {
        return evcaEstatusVeiculoCarga;
    }

    public void setEvcaEstatusVeiculoCarga(EvcaEstatusVeiculoCarga evcaEstatusVeiculoCarga) {
        this.evcaEstatusVeiculoCarga = evcaEstatusVeiculoCarga;
    }

    public CombComboio getCombComboio() {
        return combComboio;
    }

    public void setCombComboio(CombComboio combComboio) {
        this.combComboio = combComboio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vveiCodigo != null ? vveiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VveiViagemVeiculo)) {
            return false;
        }
        VveiViagemVeiculo other = (VveiViagemVeiculo) object;
        if ((this.vveiCodigo == null && other.vveiCodigo != null) || (this.vveiCodigo != null && !this.vveiCodigo.equals(other.vveiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VveiViagemVeiculo[vveiCodigo=" + vveiCodigo + "]";
    }

}
