/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "paia_pg_associa_item_acao", catalog = "trafegus_transc", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"paia_pgai_codigo", "paia_apad_codigo"})})
@NamedQueries({
    @NamedQuery(name = "PaiaPgAssociaItemAcao.findAll", query = "SELECT p FROM PaiaPgAssociaItemAcao p"),
    @NamedQuery(name = "PaiaPgAssociaItemAcao.findByPaiaCodigo", query = "SELECT p FROM PaiaPgAssociaItemAcao p WHERE p.paiaCodigo = :paiaCodigo"),
    @NamedQuery(name = "PaiaPgAssociaItemAcao.findByPaiaSequencia", query = "SELECT p FROM PaiaPgAssociaItemAcao p WHERE p.paiaSequencia = :paiaSequencia"),
    @NamedQuery(name = "PaiaPgAssociaItemAcao.findByPaiaDataCadastro", query = "SELECT p FROM PaiaPgAssociaItemAcao p WHERE p.paiaDataCadastro = :paiaDataCadastro"),
    @NamedQuery(name = "PaiaPgAssociaItemAcao.findByPaiaImportado", query = "SELECT p FROM PaiaPgAssociaItemAcao p WHERE p.paiaImportado = :paiaImportado"),
    @NamedQuery(name = "PaiaPgAssociaItemAcao.findByPaiaTempoEspera", query = "SELECT p FROM PaiaPgAssociaItemAcao p WHERE p.paiaTempoEspera = :paiaTempoEspera")})
public class PaiaPgAssociaItemAcao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "paia_codigo", nullable = false)
    private Integer paiaCodigo;
    @Column(name = "paia_sequencia")
    private Integer paiaSequencia;
    @Column(name = "paia_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiaDataCadastro;
    @Column(name = "paia_importado")
    private Character paiaImportado;
    @Column(name = "paia_tempo_espera")
    private Integer paiaTempoEspera;
    @JoinColumn(name = "paia_pgai_codigo", referencedColumnName = "pgai_codigo")
    @ManyToOne
    private PgaiPgAssociaItem pgaiPgAssociaItem;
    @JoinColumn(name = "paia_apad_codigo", referencedColumnName = "apad_codigo")
    @ManyToOne
    private ApadAcaoPadrao apadAcaoPadrao;

    public PaiaPgAssociaItemAcao() {
    }

    public PaiaPgAssociaItemAcao(Integer paiaCodigo) {
        this.paiaCodigo = paiaCodigo;
    }

    public Integer getPaiaCodigo() {
        return paiaCodigo;
    }

    public void setPaiaCodigo(Integer paiaCodigo) {
        this.paiaCodigo = paiaCodigo;
    }

    public Integer getPaiaSequencia() {
        return paiaSequencia;
    }

    public void setPaiaSequencia(Integer paiaSequencia) {
        this.paiaSequencia = paiaSequencia;
    }

    public Date getPaiaDataCadastro() {
        return paiaDataCadastro;
    }

    public void setPaiaDataCadastro(Date paiaDataCadastro) {
        this.paiaDataCadastro = paiaDataCadastro;
    }

    public Character getPaiaImportado() {
        return paiaImportado;
    }

    public void setPaiaImportado(Character paiaImportado) {
        this.paiaImportado = paiaImportado;
    }

    public Integer getPaiaTempoEspera() {
        return paiaTempoEspera;
    }

    public void setPaiaTempoEspera(Integer paiaTempoEspera) {
        this.paiaTempoEspera = paiaTempoEspera;
    }

    public PgaiPgAssociaItem getPgaiPgAssociaItem() {
        return pgaiPgAssociaItem;
    }

    public void setPgaiPgAssociaItem(PgaiPgAssociaItem pgaiPgAssociaItem) {
        this.pgaiPgAssociaItem = pgaiPgAssociaItem;
    }

    public ApadAcaoPadrao getApadAcaoPadrao() {
        return apadAcaoPadrao;
    }

    public void setApadAcaoPadrao(ApadAcaoPadrao apadAcaoPadrao) {
        this.apadAcaoPadrao = apadAcaoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paiaCodigo != null ? paiaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaiaPgAssociaItemAcao)) {
            return false;
        }
        PaiaPgAssociaItemAcao other = (PaiaPgAssociaItemAcao) object;
        if ((this.paiaCodigo == null && other.paiaCodigo != null) || (this.paiaCodigo != null && !this.paiaCodigo.equals(other.paiaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PaiaPgAssociaItemAcao[paiaCodigo=" + paiaCodigo + "]";
    }

}
