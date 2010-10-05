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
@Table(name = "tpro_produto")
@NamedQueries({
    @NamedQuery(name = "TproProduto.findAll", query = "SELECT t FROM TproProduto t")})
public class TproProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tpro_codigo")
    private Integer tproCodigo;
    @Column(name = "tpro_descricao")
    private String tproDescricao;
    @Column(name = "tpro_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tproDataCadastro;
    @Column(name = "tpro_codigo_gr")
    private Integer tproCodigoGr;
    @Column(name = "tpro_importado")
    private Character tproImportado;
    @OneToMany(mappedBy = "tproProduto")
    private Set<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorSet;
    @OneToMany(mappedBy = "tproProduto")
    private Set<ProdProduto> prodProdutoSet;

    public TproProduto() {
    }

    public TproProduto(Integer tproCodigo) {
        this.tproCodigo = tproCodigo;
    }

    public Integer getTproCodigo() {
        return tproCodigo;
    }

    public void setTproCodigo(Integer tproCodigo) {
        this.tproCodigo = tproCodigo;
    }

    public String getTproDescricao() {
        return tproDescricao;
    }

    public void setTproDescricao(String tproDescricao) {
        this.tproDescricao = tproDescricao;
    }

    public Date getTproDataCadastro() {
        return tproDataCadastro;
    }

    public void setTproDataCadastro(Date tproDataCadastro) {
        this.tproDataCadastro = tproDataCadastro;
    }

    public Integer getTproCodigoGr() {
        return tproCodigoGr;
    }

    public void setTproCodigoGr(Integer tproCodigoGr) {
        this.tproCodigoGr = tproCodigoGr;
    }

    public Character getTproImportado() {
        return tproImportado;
    }

    public void setTproImportado(Character tproImportado) {
        this.tproImportado = tproImportado;
    }

    public Set<HpmoHistoricoPesquisaMotor> getHpmoHistoricoPesquisaMotorSet() {
        return hpmoHistoricoPesquisaMotorSet;
    }

    public void setHpmoHistoricoPesquisaMotorSet(Set<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorSet) {
        this.hpmoHistoricoPesquisaMotorSet = hpmoHistoricoPesquisaMotorSet;
    }

    public Set<ProdProduto> getProdProdutoSet() {
        return prodProdutoSet;
    }

    public void setProdProdutoSet(Set<ProdProduto> prodProdutoSet) {
        this.prodProdutoSet = prodProdutoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tproCodigo != null ? tproCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TproProduto)) {
            return false;
        }
        TproProduto other = (TproProduto) object;
        if ((this.tproCodigo == null && other.tproCodigo != null) || (this.tproCodigo != null && !this.tproCodigo.equals(other.tproCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TproProduto[tproCodigo=" + tproCodigo + "]";
    }

}
