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
 * @author emerson
 */
@Entity
@Table(name = "pgpg_pg")
@NamedQueries({
    @NamedQuery(name = "PgpgPg.findAll", query = "SELECT p FROM PgpgPg p")})
public class PgpgPg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pgpg_codigo")
    private Integer pgpgCodigo;
    @Column(name = "pgpg_descricao")
    private String pgpgDescricao;
    @Column(name = "pgpg_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pgpgDataCadastro;
    @Column(name = "pgpg_codigo_gr")
    private Integer pgpgCodigoGr;
    @Column(name = "pgpg_importado")
    private Character pgpgImportado;
    @Column(name = "pgpg_validacao_operacao")
    private String pgpgValidacaoOperacao;
    @OneToMany(mappedBy = "pgpgPg")
    private Set<OrasObjetoRastreado> orasObjetoRastreadoSet;
    @OneToMany(mappedBy = "pgpgPg")
    private Set<ViagViagem> viagViagemSet;
    @JoinColumn(name = "pgpg_pfva_codigo", referencedColumnName = "pfva_codigo")
    @ManyToOne
    private PfvaPgFaixaValor pfvaPgFaixaValor;

    public PgpgPg() {
    }

    public PgpgPg(Integer pgpgCodigo) {
        this.pgpgCodigo = pgpgCodigo;
    }

    public Integer getPgpgCodigo() {
        return pgpgCodigo;
    }

    public void setPgpgCodigo(Integer pgpgCodigo) {
        this.pgpgCodigo = pgpgCodigo;
    }

    public String getPgpgDescricao() {
        return pgpgDescricao;
    }

    public void setPgpgDescricao(String pgpgDescricao) {
        this.pgpgDescricao = pgpgDescricao;
    }

    public Date getPgpgDataCadastro() {
        return pgpgDataCadastro;
    }

    public void setPgpgDataCadastro(Date pgpgDataCadastro) {
        this.pgpgDataCadastro = pgpgDataCadastro;
    }

    public Integer getPgpgCodigoGr() {
        return pgpgCodigoGr;
    }

    public void setPgpgCodigoGr(Integer pgpgCodigoGr) {
        this.pgpgCodigoGr = pgpgCodigoGr;
    }

    public Character getPgpgImportado() {
        return pgpgImportado;
    }

    public void setPgpgImportado(Character pgpgImportado) {
        this.pgpgImportado = pgpgImportado;
    }

    public String getPgpgValidacaoOperacao() {
        return pgpgValidacaoOperacao;
    }

    public void setPgpgValidacaoOperacao(String pgpgValidacaoOperacao) {
        this.pgpgValidacaoOperacao = pgpgValidacaoOperacao;
    }

    public Set<OrasObjetoRastreado> getOrasObjetoRastreadoSet() {
        return orasObjetoRastreadoSet;
    }

    public void setOrasObjetoRastreadoSet(Set<OrasObjetoRastreado> orasObjetoRastreadoSet) {
        this.orasObjetoRastreadoSet = orasObjetoRastreadoSet;
    }

    public Set<ViagViagem> getViagViagemSet() {
        return viagViagemSet;
    }

    public void setViagViagemSet(Set<ViagViagem> viagViagemSet) {
        this.viagViagemSet = viagViagemSet;
    }

    public PfvaPgFaixaValor getPfvaPgFaixaValor() {
        return pfvaPgFaixaValor;
    }

    public void setPfvaPgFaixaValor(PfvaPgFaixaValor pfvaPgFaixaValor) {
        this.pfvaPgFaixaValor = pfvaPgFaixaValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgpgCodigo != null ? pgpgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgpgPg)) {
            return false;
        }
        PgpgPg other = (PgpgPg) object;
        if ((this.pgpgCodigo == null && other.pgpgCodigo != null) || (this.pgpgCodigo != null && !this.pgpgCodigo.equals(other.pgpgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PgpgPg[pgpgCodigo=" + pgpgCodigo + "]";
    }

}
