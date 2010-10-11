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
@Table(name = "pgpg_pg")
@NamedQueries({
    @NamedQuery(name = "PgpgPg.findAll", query = "SELECT p FROM PgpgPg p"),
    @NamedQuery(name = "PgpgPg.findByPgpgCodigo", query = "SELECT p FROM PgpgPg p WHERE p.pgpgCodigo = :pgpgCodigo"),
    @NamedQuery(name = "PgpgPg.findByPgpgDescricao", query = "SELECT p FROM PgpgPg p WHERE p.pgpgDescricao = :pgpgDescricao"),
    @NamedQuery(name = "PgpgPg.findByPgpgDataCadastro", query = "SELECT p FROM PgpgPg p WHERE p.pgpgDataCadastro = :pgpgDataCadastro"),
    @NamedQuery(name = "PgpgPg.findByPgpgCodigoGr", query = "SELECT p FROM PgpgPg p WHERE p.pgpgCodigoGr = :pgpgCodigoGr"),
    @NamedQuery(name = "PgpgPg.findByPgpgImportado", query = "SELECT p FROM PgpgPg p WHERE p.pgpgImportado = :pgpgImportado"),
    @NamedQuery(name = "PgpgPg.findByPgpgValidacaoOperacao", query = "SELECT p FROM PgpgPg p WHERE p.pgpgValidacaoOperacao = :pgpgValidacaoOperacao")})
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
    @OneToMany(mappedBy = "pgpgPg", fetch = FetchType.EAGER)
    private List<TspgTranspSegurPlanoGeren> tspgTranspSegurPlanoGerenList;
    @OneToMany(mappedBy = "pgpgPg", fetch = FetchType.EAGER)
    private List<ViagViagem> viagViagemList;
    @OneToMany(mappedBy = "pgpgPg", fetch = FetchType.EAGER)
    private List<PgaiPgAssociaItem> pgaiPgAssociaItemList;
    @JoinColumn(name = "pgpg_pfva_codigo", referencedColumnName = "pfva_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PfvaPgFaixaValor pfvaPgFaixaValor;
    @OneToMany(mappedBy = "pgpgPg", fetch = FetchType.EAGER)
    private List<OrasObjetoRastreado> orasObjetoRastreadoList;
    @OneToMany(mappedBy = "pgpgPg", fetch = FetchType.EAGER)
    private List<EspgEmbarcSegurPlanoGeren> espgEmbarcSegurPlanoGerenList;

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

    public List<TspgTranspSegurPlanoGeren> getTspgTranspSegurPlanoGerenList() {
        return tspgTranspSegurPlanoGerenList;
    }

    public void setTspgTranspSegurPlanoGerenList(List<TspgTranspSegurPlanoGeren> tspgTranspSegurPlanoGerenList) {
        this.tspgTranspSegurPlanoGerenList = tspgTranspSegurPlanoGerenList;
    }

    public List<ViagViagem> getViagViagemList() {
        return viagViagemList;
    }

    public void setViagViagemList(List<ViagViagem> viagViagemList) {
        this.viagViagemList = viagViagemList;
    }

    public List<PgaiPgAssociaItem> getPgaiPgAssociaItemList() {
        return pgaiPgAssociaItemList;
    }

    public void setPgaiPgAssociaItemList(List<PgaiPgAssociaItem> pgaiPgAssociaItemList) {
        this.pgaiPgAssociaItemList = pgaiPgAssociaItemList;
    }

    public PfvaPgFaixaValor getPfvaPgFaixaValor() {
        return pfvaPgFaixaValor;
    }

    public void setPfvaPgFaixaValor(PfvaPgFaixaValor pfvaPgFaixaValor) {
        this.pfvaPgFaixaValor = pfvaPgFaixaValor;
    }

    public List<OrasObjetoRastreado> getOrasObjetoRastreadoList() {
        return orasObjetoRastreadoList;
    }

    public void setOrasObjetoRastreadoList(List<OrasObjetoRastreado> orasObjetoRastreadoList) {
        this.orasObjetoRastreadoList = orasObjetoRastreadoList;
    }

    public List<EspgEmbarcSegurPlanoGeren> getEspgEmbarcSegurPlanoGerenList() {
        return espgEmbarcSegurPlanoGerenList;
    }

    public void setEspgEmbarcSegurPlanoGerenList(List<EspgEmbarcSegurPlanoGeren> espgEmbarcSegurPlanoGerenList) {
        this.espgEmbarcSegurPlanoGerenList = espgEmbarcSegurPlanoGerenList;
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
