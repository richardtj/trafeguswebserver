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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "vtra_veiculo_transportador", catalog = "trafegus_transc", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"vtra_tran_pess_oras_codigo", "vtra_veic_oras_codigo"})})
@NamedQueries({
    @NamedQuery(name = "VtraVeiculoTransportador.findAll", query = "SELECT v FROM VtraVeiculoTransportador v"),
    @NamedQuery(name = "VtraVeiculoTransportador.findByVtraCodigo", query = "SELECT v FROM VtraVeiculoTransportador v WHERE v.vtraCodigo = :vtraCodigo"),
    @NamedQuery(name = "VtraVeiculoTransportador.findByVtraDataCadastro", query = "SELECT v FROM VtraVeiculoTransportador v WHERE v.vtraDataCadastro = :vtraDataCadastro"),
    @NamedQuery(name = "VtraVeiculoTransportador.findByVtraImportado", query = "SELECT v FROM VtraVeiculoTransportador v WHERE v.vtraImportado = :vtraImportado"),
    @NamedQuery(name = "VtraVeiculoTransportador.findByVtraCodigoGr", query = "SELECT v FROM VtraVeiculoTransportador v WHERE v.vtraCodigoGr = :vtraCodigoGr")})
public class VtraVeiculoTransportador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vtra_codigo", nullable = false)
    private Integer vtraCodigo;
    @Column(name = "vtra_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vtraDataCadastro;
    @Column(name = "vtra_importado")
    private Character vtraImportado;
    @Column(name = "vtra_codigo_gr")
    private Integer vtraCodigoGr;
    @JoinColumn(name = "vtra_veic_oras_codigo", referencedColumnName = "veic_oras_codigo")
    @ManyToOne
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "vtra_tvco_codigo", referencedColumnName = "tvco_codigo")
    @ManyToOne
    private TvcoTipoVinculoContratual tvcoTipoVinculoContratual;
    @JoinColumn(name = "vtra_tran_pess_oras_codigo", referencedColumnName = "tran_pess_oras_codigo")
    @ManyToOne
    private TranTransportador tranTransportador;
    @JoinColumn(name = "vtra_eobj_codigo", referencedColumnName = "eobj_codigo")
    @ManyToOne
    private EobjEstatusObjeto eobjEstatusObjeto;
    @JoinColumn(name = "vtra_ctec_codigo", referencedColumnName = "ctec_codigo")
    @ManyToOne
    private CtecContaTecnologia ctecContaTecnologia;

    public VtraVeiculoTransportador() {
    }

    public VtraVeiculoTransportador(Integer vtraCodigo) {
        this.vtraCodigo = vtraCodigo;
    }

    public Integer getVtraCodigo() {
        return vtraCodigo;
    }

    public void setVtraCodigo(Integer vtraCodigo) {
        this.vtraCodigo = vtraCodigo;
    }

    public Date getVtraDataCadastro() {
        return vtraDataCadastro;
    }

    public void setVtraDataCadastro(Date vtraDataCadastro) {
        this.vtraDataCadastro = vtraDataCadastro;
    }

    public Character getVtraImportado() {
        return vtraImportado;
    }

    public void setVtraImportado(Character vtraImportado) {
        this.vtraImportado = vtraImportado;
    }

    public Integer getVtraCodigoGr() {
        return vtraCodigoGr;
    }

    public void setVtraCodigoGr(Integer vtraCodigoGr) {
        this.vtraCodigoGr = vtraCodigoGr;
    }

    public VeicVeiculo getVeicVeiculo() {
        return veicVeiculo;
    }

    public void setVeicVeiculo(VeicVeiculo veicVeiculo) {
        this.veicVeiculo = veicVeiculo;
    }

    public TvcoTipoVinculoContratual getTvcoTipoVinculoContratual() {
        return tvcoTipoVinculoContratual;
    }

    public void setTvcoTipoVinculoContratual(TvcoTipoVinculoContratual tvcoTipoVinculoContratual) {
        this.tvcoTipoVinculoContratual = tvcoTipoVinculoContratual;
    }

    public TranTransportador getTranTransportador() {
        return tranTransportador;
    }

    public void setTranTransportador(TranTransportador tranTransportador) {
        this.tranTransportador = tranTransportador;
    }

    public EobjEstatusObjeto getEobjEstatusObjeto() {
        return eobjEstatusObjeto;
    }

    public void setEobjEstatusObjeto(EobjEstatusObjeto eobjEstatusObjeto) {
        this.eobjEstatusObjeto = eobjEstatusObjeto;
    }

    public CtecContaTecnologia getCtecContaTecnologia() {
        return ctecContaTecnologia;
    }

    public void setCtecContaTecnologia(CtecContaTecnologia ctecContaTecnologia) {
        this.ctecContaTecnologia = ctecContaTecnologia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vtraCodigo != null ? vtraCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtraVeiculoTransportador)) {
            return false;
        }
        VtraVeiculoTransportador other = (VtraVeiculoTransportador) object;
        if ((this.vtraCodigo == null && other.vtraCodigo != null) || (this.vtraCodigo != null && !this.vtraCodigo.equals(other.vtraCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VtraVeiculoTransportador[vtraCodigo=" + vtraCodigo + "]";
    }

}
