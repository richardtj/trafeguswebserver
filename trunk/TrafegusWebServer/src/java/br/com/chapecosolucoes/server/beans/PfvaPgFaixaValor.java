/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pfva_pg_faixa_valor")
@NamedQueries({
    @NamedQuery(name = "PfvaPgFaixaValor.findAll", query = "SELECT p FROM PfvaPgFaixaValor p")})
public class PfvaPgFaixaValor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pfva_codigo", nullable = false)
    private Integer pfvaCodigo;
    @Column(name = "pfva_descricao", length = 50)
    private String pfvaDescricao;
    @Column(name = "pfva_valor_minimo", precision = 15, scale = 2)
    private BigDecimal pfvaValorMinimo;
    @Column(name = "pfva_valor_maximo", precision = 15, scale = 2)
    private BigDecimal pfvaValorMaximo;
    @Column(name = "pfva_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pfvaDataCadastro;
    @Column(name = "pfva_codigo_gr")
    private Integer pfvaCodigoGr;
    @Column(name = "pfva_importado")
    private Character pfvaImportado;
    @OneToMany(mappedBy = "pfvaPgFaixaValor")
    private Collection<PgpgPg> pgpgPgCollection;

    public PfvaPgFaixaValor() {
    }

    public PfvaPgFaixaValor(Integer pfvaCodigo) {
        this.pfvaCodigo = pfvaCodigo;
    }

    public Integer getPfvaCodigo() {
        return pfvaCodigo;
    }

    public void setPfvaCodigo(Integer pfvaCodigo) {
        this.pfvaCodigo = pfvaCodigo;
    }

    public String getPfvaDescricao() {
        return pfvaDescricao;
    }

    public void setPfvaDescricao(String pfvaDescricao) {
        this.pfvaDescricao = pfvaDescricao;
    }

    public BigDecimal getPfvaValorMinimo() {
        return pfvaValorMinimo;
    }

    public void setPfvaValorMinimo(BigDecimal pfvaValorMinimo) {
        this.pfvaValorMinimo = pfvaValorMinimo;
    }

    public BigDecimal getPfvaValorMaximo() {
        return pfvaValorMaximo;
    }

    public void setPfvaValorMaximo(BigDecimal pfvaValorMaximo) {
        this.pfvaValorMaximo = pfvaValorMaximo;
    }

    public Date getPfvaDataCadastro() {
        return pfvaDataCadastro;
    }

    public void setPfvaDataCadastro(Date pfvaDataCadastro) {
        this.pfvaDataCadastro = pfvaDataCadastro;
    }

    public Integer getPfvaCodigoGr() {
        return pfvaCodigoGr;
    }

    public void setPfvaCodigoGr(Integer pfvaCodigoGr) {
        this.pfvaCodigoGr = pfvaCodigoGr;
    }

    public Character getPfvaImportado() {
        return pfvaImportado;
    }

    public void setPfvaImportado(Character pfvaImportado) {
        this.pfvaImportado = pfvaImportado;
    }

    public Collection<PgpgPg> getPgpgPgCollection() {
        return pgpgPgCollection;
    }

    public void setPgpgPgCollection(Collection<PgpgPg> pgpgPgCollection) {
        this.pgpgPgCollection = pgpgPgCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pfvaCodigo != null ? pfvaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PfvaPgFaixaValor)) {
            return false;
        }
        PfvaPgFaixaValor other = (PfvaPgFaixaValor) object;
        if ((this.pfvaCodigo == null && other.pfvaCodigo != null) || (this.pfvaCodigo != null && !this.pfvaCodigo.equals(other.pfvaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PfvaPgFaixaValor[pfvaCodigo=" + pfvaCodigo + "]";
    }

}
