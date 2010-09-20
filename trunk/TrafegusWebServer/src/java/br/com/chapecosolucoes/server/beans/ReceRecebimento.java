/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "rece_recebimento", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ReceRecebimento.findAll", query = "SELECT r FROM ReceRecebimento r"),
    @NamedQuery(name = "ReceRecebimento.findByReceCodigo", query = "SELECT r FROM ReceRecebimento r WHERE r.receCodigo = :receCodigo"),
    @NamedQuery(name = "ReceRecebimento.findByReceTermNumeroTerminal", query = "SELECT r FROM ReceRecebimento r WHERE r.receTermNumeroTerminal = :receTermNumeroTerminal"),
    @NamedQuery(name = "ReceRecebimento.findByReceDataComputadorBordo", query = "SELECT r FROM ReceRecebimento r WHERE r.receDataComputadorBordo = :receDataComputadorBordo"),
    @NamedQuery(name = "ReceRecebimento.findByReceDataCadastro", query = "SELECT r FROM ReceRecebimento r WHERE r.receDataCadastro = :receDataCadastro"),
    @NamedQuery(name = "ReceRecebimento.findByReceCodigoGr", query = "SELECT r FROM ReceRecebimento r WHERE r.receCodigoGr = :receCodigoGr")})
public class ReceRecebimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReceRecebimentoPK receRecebimentoPK;
    @Basic(optional = false)
    @Column(name = "rece_codigo", nullable = false)
    private int receCodigo;
    @Column(name = "rece_term_numero_terminal", length = 30)
    private String receTermNumeroTerminal;
    @Column(name = "rece_data_computador_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receDataComputadorBordo;
    @Column(name = "rece_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receDataCadastro;
    @Column(name = "rece_codigo_gr")
    private Integer receCodigoGr;
    @JoinColumn(name = "rece_vtec_codigo", referencedColumnName = "vtec_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private VtecVersaoTecnologia vtecVersaoTecnologia;

    public ReceRecebimento() {
    }

    public ReceRecebimento(ReceRecebimentoPK receRecebimentoPK) {
        this.receRecebimentoPK = receRecebimentoPK;
    }

    public ReceRecebimento(ReceRecebimentoPK receRecebimentoPK, int receCodigo) {
        this.receRecebimentoPK = receRecebimentoPK;
        this.receCodigo = receCodigo;
    }

    public ReceRecebimentoPK getReceRecebimentoPK() {
        return receRecebimentoPK;
    }

    public void setReceRecebimentoPK(ReceRecebimentoPK receRecebimentoPK) {
        this.receRecebimentoPK = receRecebimentoPK;
    }

    public int getReceCodigo() {
        return receCodigo;
    }

    public void setReceCodigo(int receCodigo) {
        this.receCodigo = receCodigo;
    }

    public String getReceTermNumeroTerminal() {
        return receTermNumeroTerminal;
    }

    public void setReceTermNumeroTerminal(String receTermNumeroTerminal) {
        this.receTermNumeroTerminal = receTermNumeroTerminal;
    }

    public Date getReceDataComputadorBordo() {
        return receDataComputadorBordo;
    }

    public void setReceDataComputadorBordo(Date receDataComputadorBordo) {
        this.receDataComputadorBordo = receDataComputadorBordo;
    }

    public Date getReceDataCadastro() {
        return receDataCadastro;
    }

    public void setReceDataCadastro(Date receDataCadastro) {
        this.receDataCadastro = receDataCadastro;
    }

    public Integer getReceCodigoGr() {
        return receCodigoGr;
    }

    public void setReceCodigoGr(Integer receCodigoGr) {
        this.receCodigoGr = receCodigoGr;
    }

    public VtecVersaoTecnologia getVtecVersaoTecnologia() {
        return vtecVersaoTecnologia;
    }

    public void setVtecVersaoTecnologia(VtecVersaoTecnologia vtecVersaoTecnologia) {
        this.vtecVersaoTecnologia = vtecVersaoTecnologia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receRecebimentoPK != null ? receRecebimentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceRecebimento)) {
            return false;
        }
        ReceRecebimento other = (ReceRecebimento) object;
        if ((this.receRecebimentoPK == null && other.receRecebimentoPK != null) || (this.receRecebimentoPK != null && !this.receRecebimentoPK.equals(other.receRecebimentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.ReceRecebimento[receRecebimentoPK=" + receRecebimentoPK + "]";
    }

}
