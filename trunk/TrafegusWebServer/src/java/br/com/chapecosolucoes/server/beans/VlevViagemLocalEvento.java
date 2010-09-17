/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

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

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "vlev_viagem_local_evento")
@NamedQueries({
    @NamedQuery(name = "VlevViagemLocalEvento.findAll", query = "SELECT v FROM VlevViagemLocalEvento v")})
public class VlevViagemLocalEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vlev_codigo", nullable = false)
    private Integer vlevCodigo;
    @Column(name = "vlev_sequencia")
    private Integer vlevSequencia;
    @Column(name = "vlev_data_previsao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vlevDataPrevisao;
    @Column(name = "vlev_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vlevData;
    @Column(name = "vlev_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vlevDataCadastro;
    @Column(name = "vlev_codigo_gr")
    private Integer vlevCodigoGr;
    @Column(name = "vlev_importado")
    private Character vlevImportado;
    @JoinColumn(name = "vlev_vloc_codigo", referencedColumnName = "vloc_codigo")
    @ManyToOne
    private VlocViagemLocal vlocViagemLocal;
    @JoinColumn(name = "vlev_tlev_codigo", referencedColumnName = "tlev_codigo")
    @ManyToOne
    private TlevTipoLocalEvento tlevTipoLocalEvento;
    @JoinColumn(name = "vlev_cpat_codigo", referencedColumnName = "cpat_codigo")
    @ManyToOne
    private CpatCelulaPatio cpatCelulaPatio;

    public VlevViagemLocalEvento() {
    }

    public VlevViagemLocalEvento(Integer vlevCodigo) {
        this.vlevCodigo = vlevCodigo;
    }

    public Integer getVlevCodigo() {
        return vlevCodigo;
    }

    public void setVlevCodigo(Integer vlevCodigo) {
        this.vlevCodigo = vlevCodigo;
    }

    public Integer getVlevSequencia() {
        return vlevSequencia;
    }

    public void setVlevSequencia(Integer vlevSequencia) {
        this.vlevSequencia = vlevSequencia;
    }

    public Date getVlevDataPrevisao() {
        return vlevDataPrevisao;
    }

    public void setVlevDataPrevisao(Date vlevDataPrevisao) {
        this.vlevDataPrevisao = vlevDataPrevisao;
    }

    public Date getVlevData() {
        return vlevData;
    }

    public void setVlevData(Date vlevData) {
        this.vlevData = vlevData;
    }

    public Date getVlevDataCadastro() {
        return vlevDataCadastro;
    }

    public void setVlevDataCadastro(Date vlevDataCadastro) {
        this.vlevDataCadastro = vlevDataCadastro;
    }

    public Integer getVlevCodigoGr() {
        return vlevCodigoGr;
    }

    public void setVlevCodigoGr(Integer vlevCodigoGr) {
        this.vlevCodigoGr = vlevCodigoGr;
    }

    public Character getVlevImportado() {
        return vlevImportado;
    }

    public void setVlevImportado(Character vlevImportado) {
        this.vlevImportado = vlevImportado;
    }

    public VlocViagemLocal getVlocViagemLocal() {
        return vlocViagemLocal;
    }

    public void setVlocViagemLocal(VlocViagemLocal vlocViagemLocal) {
        this.vlocViagemLocal = vlocViagemLocal;
    }

    public TlevTipoLocalEvento getTlevTipoLocalEvento() {
        return tlevTipoLocalEvento;
    }

    public void setTlevTipoLocalEvento(TlevTipoLocalEvento tlevTipoLocalEvento) {
        this.tlevTipoLocalEvento = tlevTipoLocalEvento;
    }

    public CpatCelulaPatio getCpatCelulaPatio() {
        return cpatCelulaPatio;
    }

    public void setCpatCelulaPatio(CpatCelulaPatio cpatCelulaPatio) {
        this.cpatCelulaPatio = cpatCelulaPatio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vlevCodigo != null ? vlevCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VlevViagemLocalEvento)) {
            return false;
        }
        VlevViagemLocalEvento other = (VlevViagemLocalEvento) object;
        if ((this.vlevCodigo == null && other.vlevCodigo != null) || (this.vlevCodigo != null && !this.vlevCodigo.equals(other.vlevCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.VlevViagemLocalEvento[vlevCodigo=" + vlevCodigo + "]";
    }

}
