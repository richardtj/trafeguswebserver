/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * @author Emerson
 */
@Entity
@Table(name = "tpro_produto", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TproProduto.findAll", query = "SELECT t FROM TproProduto t"),
    @NamedQuery(name = "TproProduto.findByTproCodigo", query = "SELECT t FROM TproProduto t WHERE t.tproCodigo = :tproCodigo"),
    @NamedQuery(name = "TproProduto.findByTproDescricao", query = "SELECT t FROM TproProduto t WHERE t.tproDescricao = :tproDescricao"),
    @NamedQuery(name = "TproProduto.findByTproDataCadastro", query = "SELECT t FROM TproProduto t WHERE t.tproDataCadastro = :tproDataCadastro"),
    @NamedQuery(name = "TproProduto.findByTproCodigoGr", query = "SELECT t FROM TproProduto t WHERE t.tproCodigoGr = :tproCodigoGr"),
    @NamedQuery(name = "TproProduto.findByTproImportado", query = "SELECT t FROM TproProduto t WHERE t.tproImportado = :tproImportado")})
public class TproProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tpro_codigo", nullable = false)
    private Integer tproCodigo;
    @Column(name = "tpro_descricao", length = 50)
    private String tproDescricao;
    @Column(name = "tpro_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tproDataCadastro;
    @Column(name = "tpro_codigo_gr")
    private Integer tproCodigoGr;
    @Column(name = "tpro_importado")
    private Character tproImportado;
    @OneToMany(mappedBy = "tproProduto")
    private Collection<HpprHistoricoPesquisaProd> hpprHistoricoPesquisaProdCollection;
    @OneToMany(mappedBy = "tproProduto")
    private Collection<ProdProduto> prodProdutoCollection;
    @OneToMany(mappedBy = "tproProduto")
    private Collection<HpmoHistoricoPesquisaMotor> hpmoHistoricoPesquisaMotorCollection;

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

    public Collection<HpprHistoricoPesquisaProd> getHpprHistoricoPesquisaProdCollection() {
        return hpprHistoricoPesquisaProdCollection;
    }

    public void setHpprHistoricoPesquisaProdCollection(Collection<HpprHistoricoPesquisaProd> hpprHistoricoPesquisaProdCollection) {
        this.hpprHistoricoPesquisaProdCollection = hpprHistoricoPesquisaProdCollection;
    }

    public Collection<ProdProduto> getProdProdutoCollection() {
        return prodProdutoCollection;
    }

    public void setProdProdutoCollection(Collection<ProdProduto> prodProdutoCollection) {
        this.prodProdutoCollection = prodProdutoCollection;
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
