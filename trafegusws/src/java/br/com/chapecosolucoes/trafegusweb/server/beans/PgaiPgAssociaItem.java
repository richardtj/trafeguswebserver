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
@Table(name = "pgai_pg_associa_item")
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
    @Column(name = "pgai_codigo")
    private Integer pgaiCodigo;
    @Column(name = "pgai_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pgaiDataCadastro;
    @Column(name = "pgai_codigo_gr")
    private Integer pgaiCodigoGr;
    @Column(name = "pgai_importado")
    private Character pgaiImportado;
    @JoinColumn(name = "pgai_pite_codigo", referencedColumnName = "pite_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PitePgItem pitePgItem;
    @JoinColumn(name = "pgai_pgpg_codigo", referencedColumnName = "pgpg_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PgpgPg pgpgPg;
    @OneToMany(mappedBy = "pgaiPgAssociaItem", fetch = FetchType.EAGER)
    private List<PaipPgAssociaItemParam> paipPgAssociaItemParamList;
    @OneToMany(mappedBy = "pgaiPgAssociaItem", fetch = FetchType.EAGER)
    private List<EsisEventoSistema> esisEventoSistemaList;
    @OneToMany(mappedBy = "pgaiPgAssociaItem", fetch = FetchType.EAGER)
    private List<PaiaPgAssociaItemAcao> paiaPgAssociaItemAcaoList;

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

    public List<PaipPgAssociaItemParam> getPaipPgAssociaItemParamList() {
        return paipPgAssociaItemParamList;
    }

    public void setPaipPgAssociaItemParamList(List<PaipPgAssociaItemParam> paipPgAssociaItemParamList) {
        this.paipPgAssociaItemParamList = paipPgAssociaItemParamList;
    }

    public List<EsisEventoSistema> getEsisEventoSistemaList() {
        return esisEventoSistemaList;
    }

    public void setEsisEventoSistemaList(List<EsisEventoSistema> esisEventoSistemaList) {
        this.esisEventoSistemaList = esisEventoSistemaList;
    }

    public List<PaiaPgAssociaItemAcao> getPaiaPgAssociaItemAcaoList() {
        return paiaPgAssociaItemAcaoList;
    }

    public void setPaiaPgAssociaItemAcaoList(List<PaiaPgAssociaItemAcao> paiaPgAssociaItemAcaoList) {
        this.paiaPgAssociaItemAcaoList = paiaPgAssociaItemAcaoList;
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
