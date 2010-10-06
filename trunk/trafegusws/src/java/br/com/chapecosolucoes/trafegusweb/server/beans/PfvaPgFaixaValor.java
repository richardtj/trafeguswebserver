/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "PfvaPgFaixaValor.findAll", query = "SELECT p FROM PfvaPgFaixaValor p"),
    @NamedQuery(name = "PfvaPgFaixaValor.findByPfvaCodigo", query = "SELECT p FROM PfvaPgFaixaValor p WHERE p.pfvaCodigo = :pfvaCodigo"),
    @NamedQuery(name = "PfvaPgFaixaValor.findByPfvaDescricao", query = "SELECT p FROM PfvaPgFaixaValor p WHERE p.pfvaDescricao = :pfvaDescricao"),
    @NamedQuery(name = "PfvaPgFaixaValor.findByPfvaValorMinimo", query = "SELECT p FROM PfvaPgFaixaValor p WHERE p.pfvaValorMinimo = :pfvaValorMinimo"),
    @NamedQuery(name = "PfvaPgFaixaValor.findByPfvaValorMaximo", query = "SELECT p FROM PfvaPgFaixaValor p WHERE p.pfvaValorMaximo = :pfvaValorMaximo"),
    @NamedQuery(name = "PfvaPgFaixaValor.findByPfvaDataCadastro", query = "SELECT p FROM PfvaPgFaixaValor p WHERE p.pfvaDataCadastro = :pfvaDataCadastro"),
    @NamedQuery(name = "PfvaPgFaixaValor.findByPfvaCodigoGr", query = "SELECT p FROM PfvaPgFaixaValor p WHERE p.pfvaCodigoGr = :pfvaCodigoGr"),
    @NamedQuery(name = "PfvaPgFaixaValor.findByPfvaImportado", query = "SELECT p FROM PfvaPgFaixaValor p WHERE p.pfvaImportado = :pfvaImportado")})
public class PfvaPgFaixaValor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pfva_codigo")
    private Integer pfvaCodigo;
    @Column(name = "pfva_descricao")
    private String pfvaDescricao;
    @Column(name = "pfva_valor_minimo")
    private BigDecimal pfvaValorMinimo;
    @Column(name = "pfva_valor_maximo")
    private BigDecimal pfvaValorMaximo;
    @Column(name = "pfva_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pfvaDataCadastro;
    @Column(name = "pfva_codigo_gr")
    private Integer pfvaCodigoGr;
    @Column(name = "pfva_importado")
    private Character pfvaImportado;
    @OneToMany(mappedBy = "pfvaPgFaixaValor", fetch = FetchType.LAZY)
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
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PfvaPgFaixaValor[pfvaCodigo=" + pfvaCodigo + "]";
    }

}
