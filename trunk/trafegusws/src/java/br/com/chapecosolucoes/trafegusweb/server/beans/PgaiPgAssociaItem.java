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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "pgai_pg_associa_item", catalog = "trafegus_transc", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pgai_pgpg_codigo", "pgai_pite_codigo"})})
@NamedQueries({
    @NamedQuery(name = "PgaiPgAssociaItem.findAll", query = "SELECT p FROM PgaiPgAssociaItem p"),
    @NamedQuery(name = "PgaiPgAssociaItem.findByPgaiCodigo", query = "SELECT p FROM PgaiPgAssociaItem p WHERE p.pgaiCodigo = :pgaiCodigo"),
    @NamedQuery(name = "PgaiPgAssociaItem.findByPgaiDataCadastro", query = "SELECT p FROM PgaiPgAssociaItem p WHERE p.pgaiDataCadastro = :pgaiDataCadastro"),
    @NamedQuery(name = "PgaiPgAssociaItem.findByPgaiCodigoGr", query = "SELECT p FROM PgaiPgAssociaItem p WHERE p.pgaiCodigoGr = :pgaiCodigoGr"),
    @NamedQuery(name = "PgaiPgAssociaItem.findByPgaiImportado", query = "SELECT p FROM PgaiPgAssociaItem p WHERE p.pgaiImportado = :pgaiImportado")})
public class PgaiPgAssociaItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pgai_codigo", nullable = false)
    private Integer pgaiCodigo;
    @Column(name = "pgai_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pgaiDataCadastro;
    @Column(name = "pgai_codigo_gr")
    private Integer pgaiCodigoGr;
    @Column(name = "pgai_importado")
    private Character pgaiImportado;
    @JoinColumn(name = "pgai_pite_codigo", referencedColumnName = "pite_codigo")
    @ManyToOne
    private PitePgItem pitePgItem;
    @JoinColumn(name = "pgai_pgpg_codigo", referencedColumnName = "pgpg_codigo")
    @ManyToOne
    private PgpgPg pgpgPg;
    @OneToMany(mappedBy = "pgaiPgAssociaItem")
    private Collection<PaipPgAssociaItemParam> paipPgAssociaItemParamCollection;
    @OneToMany(mappedBy = "pgaiPgAssociaItem")
    private Collection<EsisEventoSistema> esisEventoSistemaCollection;
    @OneToMany(mappedBy = "pgaiPgAssociaItem")
    private Collection<PaiaPgAssociaItemAcao> paiaPgAssociaItemAcaoCollection;

    public PgaiPgAssociaItem() {
    }

    public PgaiPgAssociaItem(Integer pgaiCodigo) {
        this.pgaiCodigo = pgaiCodigo;
    }

    public Integer getPgaiCodigo() {
        return pgaiCodigo;
    }

    public void setPgaiCodigo(Integer pgaiCodigo) {
        this.pgaiCodigo = pgaiCodigo;
    }

    public Date getPgaiDataCadastro() {
        return pgaiDataCadastro;
    }

    public void setPgaiDataCadastro(Date pgaiDataCadastro) {
        this.pgaiDataCadastro = pgaiDataCadastro;
    }

    public Integer getPgaiCodigoGr() {
        return pgaiCodigoGr;
    }

    public void setPgaiCodigoGr(Integer pgaiCodigoGr) {
        this.pgaiCodigoGr = pgaiCodigoGr;
    }

    public Character getPgaiImportado() {
        return pgaiImportado;
    }

    public void setPgaiImportado(Character pgaiImportado) {
        this.pgaiImportado = pgaiImportado;
    }

    public PitePgItem getPitePgItem() {
        return pitePgItem;
    }

    public void setPitePgItem(PitePgItem pitePgItem) {
        this.pitePgItem = pitePgItem;
    }

    public PgpgPg getPgpgPg() {
        return pgpgPg;
    }

    public void setPgpgPg(PgpgPg pgpgPg) {
        this.pgpgPg = pgpgPg;
    }

    public Collection<PaipPgAssociaItemParam> getPaipPgAssociaItemParamCollection() {
        return paipPgAssociaItemParamCollection;
    }

    public void setPaipPgAssociaItemParamCollection(Collection<PaipPgAssociaItemParam> paipPgAssociaItemParamCollection) {
        this.paipPgAssociaItemParamCollection = paipPgAssociaItemParamCollection;
    }

    public Collection<EsisEventoSistema> getEsisEventoSistemaCollection() {
        return esisEventoSistemaCollection;
    }

    public void setEsisEventoSistemaCollection(Collection<EsisEventoSistema> esisEventoSistemaCollection) {
        this.esisEventoSistemaCollection = esisEventoSistemaCollection;
    }

    public Collection<PaiaPgAssociaItemAcao> getPaiaPgAssociaItemAcaoCollection() {
        return paiaPgAssociaItemAcaoCollection;
    }

    public void setPaiaPgAssociaItemAcaoCollection(Collection<PaiaPgAssociaItemAcao> paiaPgAssociaItemAcaoCollection) {
        this.paiaPgAssociaItemAcaoCollection = paiaPgAssociaItemAcaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgaiCodigo != null ? pgaiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PgaiPgAssociaItem)) {
            return false;
        }
        PgaiPgAssociaItem other = (PgaiPgAssociaItem) object;
        if ((this.pgaiCodigo == null && other.pgaiCodigo != null) || (this.pgaiCodigo != null && !this.pgaiCodigo.equals(other.pgaiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PgaiPgAssociaItem[pgaiCodigo=" + pgaiCodigo + "]";
    }

}
