/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "hppr_historico_pesquisa_prod")
@NamedQueries({
    @NamedQuery(name = "HpprHistoricoPesquisaProd.findAll", query = "SELECT h FROM HpprHistoricoPesquisaProd h"),
    @NamedQuery(name = "HpprHistoricoPesquisaProd.findByHpprCodigo", query = "SELECT h FROM HpprHistoricoPesquisaProd h WHERE h.hpprCodigo = :hpprCodigo"),
    @NamedQuery(name = "HpprHistoricoPesquisaProd.findByHpprValorMaximo", query = "SELECT h FROM HpprHistoricoPesquisaProd h WHERE h.hpprValorMaximo = :hpprValorMaximo"),
    @NamedQuery(name = "HpprHistoricoPesquisaProd.findByHpprDataCadastro", query = "SELECT h FROM HpprHistoricoPesquisaProd h WHERE h.hpprDataCadastro = :hpprDataCadastro"),
    @NamedQuery(name = "HpprHistoricoPesquisaProd.findByHpprCodigoGr", query = "SELECT h FROM HpprHistoricoPesquisaProd h WHERE h.hpprCodigoGr = :hpprCodigoGr"),
    @NamedQuery(name = "HpprHistoricoPesquisaProd.findByHpprImportado", query = "SELECT h FROM HpprHistoricoPesquisaProd h WHERE h.hpprImportado = :hpprImportado")})
public class HpprHistoricoPesquisaProd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hppr_codigo")
    private Integer hpprCodigo;
    @Column(name = "hppr_valor_maximo")
    private BigDecimal hpprValorMaximo;
    @Column(name = "hppr_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hpprDataCadastro;
    @Column(name = "hppr_codigo_gr")
    private Integer hpprCodigoGr;
    @Column(name = "hppr_importado")
    private Character hpprImportado;
    @JoinColumn(name = "hppr_tpro_codigo", referencedColumnName = "tpro_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TproProduto tproProduto;
    @JoinColumn(name = "hppr_hpmo_codigo", referencedColumnName = "hpmo_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private HpmoHistoricoPesquisaMotor hpmoHistoricoPesquisaMotor;

    public HpprHistoricoPesquisaProd() {
    }

    public HpprHistoricoPesquisaProd(Integer hpprCodigo) {
        this.hpprCodigo = hpprCodigo;
    }

    public Integer getHpprCodigo() {
        return hpprCodigo;
    }

    public void setHpprCodigo(Integer hpprCodigo) {
        this.hpprCodigo = hpprCodigo;
    }

    public BigDecimal getHpprValorMaximo() {
        return hpprValorMaximo;
    }

    public void setHpprValorMaximo(BigDecimal hpprValorMaximo) {
        this.hpprValorMaximo = hpprValorMaximo;
    }

    public Date getHpprDataCadastro() {
        return hpprDataCadastro;
    }

    public void setHpprDataCadastro(Date hpprDataCadastro) {
        this.hpprDataCadastro = hpprDataCadastro;
    }

    public Integer getHpprCodigoGr() {
        return hpprCodigoGr;
    }

    public void setHpprCodigoGr(Integer hpprCodigoGr) {
        this.hpprCodigoGr = hpprCodigoGr;
    }

    public Character getHpprImportado() {
        return hpprImportado;
    }

    public void setHpprImportado(Character hpprImportado) {
        this.hpprImportado = hpprImportado;
    }

    public TproProduto getTproProduto() {
        return tproProduto;
    }

    public void setTproProduto(TproProduto tproProduto) {
        this.tproProduto = tproProduto;
    }

    public HpmoHistoricoPesquisaMotor getHpmoHistoricoPesquisaMotor() {
        return hpmoHistoricoPesquisaMotor;
    }

    public void setHpmoHistoricoPesquisaMotor(HpmoHistoricoPesquisaMotor hpmoHistoricoPesquisaMotor) {
        this.hpmoHistoricoPesquisaMotor = hpmoHistoricoPesquisaMotor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hpprCodigo != null ? hpprCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HpprHistoricoPesquisaProd)) {
            return false;
        }
        HpprHistoricoPesquisaProd other = (HpprHistoricoPesquisaProd) object;
        if ((this.hpprCodigo == null && other.hpprCodigo != null) || (this.hpprCodigo != null && !this.hpprCodigo.equals(other.hpprCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.HpprHistoricoPesquisaProd[hpprCodigo=" + hpprCodigo + "]";
    }

}
