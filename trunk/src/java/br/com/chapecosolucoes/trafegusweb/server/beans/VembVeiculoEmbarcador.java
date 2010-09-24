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
@Table(name = "vemb_veiculo_embarcador", catalog = "trafegus_transc", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"vemb_emba_pjur_pess_oras_codigo", "vemb_veic_oras_codigo"})})
@NamedQueries({
    @NamedQuery(name = "VembVeiculoEmbarcador.findAll", query = "SELECT v FROM VembVeiculoEmbarcador v"),
    @NamedQuery(name = "VembVeiculoEmbarcador.findByVembCodigo", query = "SELECT v FROM VembVeiculoEmbarcador v WHERE v.vembCodigo = :vembCodigo"),
    @NamedQuery(name = "VembVeiculoEmbarcador.findByVembDataCadastro", query = "SELECT v FROM VembVeiculoEmbarcador v WHERE v.vembDataCadastro = :vembDataCadastro"),
    @NamedQuery(name = "VembVeiculoEmbarcador.findByVembCodigoGr", query = "SELECT v FROM VembVeiculoEmbarcador v WHERE v.vembCodigoGr = :vembCodigoGr"),
    @NamedQuery(name = "VembVeiculoEmbarcador.findByVembImportado", query = "SELECT v FROM VembVeiculoEmbarcador v WHERE v.vembImportado = :vembImportado")})
public class VembVeiculoEmbarcador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vemb_codigo", nullable = false)
    private Integer vembCodigo;
    @Column(name = "vemb_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vembDataCadastro;
    @Column(name = "vemb_codigo_gr")
    private Integer vembCodigoGr;
    @Column(name = "vemb_importado")
    private Character vembImportado;
    @JoinColumn(name = "vemb_veic_oras_codigo", referencedColumnName = "veic_oras_codigo")
    @ManyToOne
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "vemb_tvco_codigo", referencedColumnName = "tvco_codigo")
    @ManyToOne
    private TvcoTipoVinculoContratual tvcoTipoVinculoContratual;
    @JoinColumn(name = "vemb_eobj_codigo", referencedColumnName = "eobj_codigo")
    @ManyToOne
    private EobjEstatusObjeto eobjEstatusObjeto;
    @JoinColumn(name = "vemb_emba_pjur_pess_oras_codigo", referencedColumnName = "emba_pjur_pess_oras_codigo")
    @ManyToOne
    private EmbaEmbarcador embaEmbarcador;
    @JoinColumn(name = "vemb_ctec_codigo", referencedColumnName = "ctec_codigo")
    @ManyToOne
    private CtecContaTecnologia ctecContaTecnologia;

    public VembVeiculoEmbarcador() {
    }

    public VembVeiculoEmbarcador(Integer vembCodigo) {
        this.vembCodigo = vembCodigo;
    }

    public Integer getVembCodigo() {
        return vembCodigo;
    }

    public void setVembCodigo(Integer vembCodigo) {
        this.vembCodigo = vembCodigo;
    }

    public Date getVembDataCadastro() {
        return vembDataCadastro;
    }

    public void setVembDataCadastro(Date vembDataCadastro) {
        this.vembDataCadastro = vembDataCadastro;
    }

    public Integer getVembCodigoGr() {
        return vembCodigoGr;
    }

    public void setVembCodigoGr(Integer vembCodigoGr) {
        this.vembCodigoGr = vembCodigoGr;
    }

    public Character getVembImportado() {
        return vembImportado;
    }

    public void setVembImportado(Character vembImportado) {
        this.vembImportado = vembImportado;
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

    public EobjEstatusObjeto getEobjEstatusObjeto() {
        return eobjEstatusObjeto;
    }

    public void setEobjEstatusObjeto(EobjEstatusObjeto eobjEstatusObjeto) {
        this.eobjEstatusObjeto = eobjEstatusObjeto;
    }

    public EmbaEmbarcador getEmbaEmbarcador() {
        return embaEmbarcador;
    }

    public void setEmbaEmbarcador(EmbaEmbarcador embaEmbarcador) {
        this.embaEmbarcador = embaEmbarcador;
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
        hash += (vembCodigo != null ? vembCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VembVeiculoEmbarcador)) {
            return false;
        }
        VembVeiculoEmbarcador other = (VembVeiculoEmbarcador) object;
        if ((this.vembCodigo == null && other.vembCodigo != null) || (this.vembCodigo != null && !this.vembCodigo.equals(other.vembCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VembVeiculoEmbarcador[vembCodigo=" + vembCodigo + "]";
    }

}
