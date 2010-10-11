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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "mvec_modelo_veiculo")
@NamedQueries({
    @NamedQuery(name = "MvecModeloVeiculo.findAll", query = "SELECT m FROM MvecModeloVeiculo m"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecCodigo", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecCodigo = :mvecCodigo"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecDescricao", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecDescricao = :mvecDescricao"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecDataCadastro", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecDataCadastro = :mvecDataCadastro"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecCodigoGr", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecCodigoGr = :mvecCodigoGr"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecImportado", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecImportado = :mvecImportado")})
public class MvecModeloVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mvec_codigo")
    private Integer mvecCodigo;
    @Column(name = "mvec_descricao")
    private String mvecDescricao;
    @Column(name = "mvec_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mvecDataCadastro;
    @Column(name = "mvec_codigo_gr")
    private Integer mvecCodigoGr;
    @Column(name = "mvec_importado")
    private Character mvecImportado;
    @OneToMany(mappedBy = "mvecModeloVeiculo", fetch = FetchType.EAGER)
    private List<VeicVeiculo> veicVeiculoList;
    @JoinColumn(name = "mvec_mvei_codigo", referencedColumnName = "mvei_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private MveiMarcaVeiculo mveiMarcaVeiculo;

    public MvecModeloVeiculo() {
    }

    public MvecModeloVeiculo(Integer mvecCodigo) {
        this.mvecCodigo = mvecCodigo;
    }

    public Integer getMvecCodigo() {
        return mvecCodigo;
    }

    public void setMvecCodigo(Integer mvecCodigo) {
        this.mvecCodigo = mvecCodigo;
    }

    public String getMvecDescricao() {
        return mvecDescricao;
    }

    public void setMvecDescricao(String mvecDescricao) {
        this.mvecDescricao = mvecDescricao;
    }

    public Date getMvecDataCadastro() {
        return mvecDataCadastro;
    }

    public void setMvecDataCadastro(Date mvecDataCadastro) {
        this.mvecDataCadastro = mvecDataCadastro;
    }

    public Integer getMvecCodigoGr() {
        return mvecCodigoGr;
    }

    public void setMvecCodigoGr(Integer mvecCodigoGr) {
        this.mvecCodigoGr = mvecCodigoGr;
    }

    public Character getMvecImportado() {
        return mvecImportado;
    }

    public void setMvecImportado(Character mvecImportado) {
        this.mvecImportado = mvecImportado;
    }

    public List<VeicVeiculo> getVeicVeiculoList() {
        return veicVeiculoList;
    }

    public void setVeicVeiculoList(List<VeicVeiculo> veicVeiculoList) {
        this.veicVeiculoList = veicVeiculoList;
    }

    public MveiMarcaVeiculo getMveiMarcaVeiculo() {
        return mveiMarcaVeiculo;
    }

    public void setMveiMarcaVeiculo(MveiMarcaVeiculo mveiMarcaVeiculo) {
        this.mveiMarcaVeiculo = mveiMarcaVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mvecCodigo != null ? mvecCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MvecModeloVeiculo)) {
            return false;
        }
        MvecModeloVeiculo other = (MvecModeloVeiculo) object;
        if ((this.mvecCodigo == null && other.mvecCodigo != null) || (this.mvecCodigo != null && !this.mvecCodigo.equals(other.mvecCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.MvecModeloVeiculo[mvecCodigo=" + mvecCodigo + "]";
    }

}
