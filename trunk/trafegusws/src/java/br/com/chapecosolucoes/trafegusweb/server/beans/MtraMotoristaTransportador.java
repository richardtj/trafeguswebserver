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
@Table(name = "mtra_motorista_transportador")
@NamedQueries({
    @NamedQuery(name = "MtraMotoristaTransportador.findAll", query = "SELECT m FROM MtraMotoristaTransportador m"),
    @NamedQuery(name = "MtraMotoristaTransportador.findByMtraCodigo", query = "SELECT m FROM MtraMotoristaTransportador m WHERE m.mtraCodigo = :mtraCodigo"),
    @NamedQuery(name = "MtraMotoristaTransportador.findByMtraDataCadastro", query = "SELECT m FROM MtraMotoristaTransportador m WHERE m.mtraDataCadastro = :mtraDataCadastro"),
    @NamedQuery(name = "MtraMotoristaTransportador.findByMtraCodigoGr", query = "SELECT m FROM MtraMotoristaTransportador m WHERE m.mtraCodigoGr = :mtraCodigoGr"),
    @NamedQuery(name = "MtraMotoristaTransportador.findByMtraImportado", query = "SELECT m FROM MtraMotoristaTransportador m WHERE m.mtraImportado = :mtraImportado")})
public class MtraMotoristaTransportador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mtra_codigo")
    private Integer mtraCodigo;
    @Column(name = "mtra_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mtraDataCadastro;
    @Column(name = "mtra_codigo_gr")
    private Integer mtraCodigoGr;
    @Column(name = "mtra_importado")
    private Character mtraImportado;
    @JoinColumn(name = "mtra_tran_pess_oras_codigo", referencedColumnName = "tran_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private TranTransportador tranTransportador;
    @JoinColumn(name = "mtra_moto_pfis_pess_oras_codigo", referencedColumnName = "moto_pfis_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private MotoMotorista motoMotorista;

    public MtraMotoristaTransportador() {
    }

    public MtraMotoristaTransportador(Integer mtraCodigo) {
        this.mtraCodigo = mtraCodigo;
    }

    public Integer getMtraCodigo() {
        return mtraCodigo;
    }

    public void setMtraCodigo(Integer mtraCodigo) {
        this.mtraCodigo = mtraCodigo;
    }

    public Date getMtraDataCadastro() {
        return mtraDataCadastro;
    }

    public void setMtraDataCadastro(Date mtraDataCadastro) {
        this.mtraDataCadastro = mtraDataCadastro;
    }

    public Integer getMtraCodigoGr() {
        return mtraCodigoGr;
    }

    public void setMtraCodigoGr(Integer mtraCodigoGr) {
        this.mtraCodigoGr = mtraCodigoGr;
    }

    public Character getMtraImportado() {
        return mtraImportado;
    }

    public void setMtraImportado(Character mtraImportado) {
        this.mtraImportado = mtraImportado;
    }

    public TranTransportador getTranTransportador() {
        return tranTransportador;
    }

    public void setTranTransportador(TranTransportador tranTransportador) {
        this.tranTransportador = tranTransportador;
    }

    public MotoMotorista getMotoMotorista() {
        return motoMotorista;
    }

    public void setMotoMotorista(MotoMotorista motoMotorista) {
        this.motoMotorista = motoMotorista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mtraCodigo != null ? mtraCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MtraMotoristaTransportador)) {
            return false;
        }
        MtraMotoristaTransportador other = (MtraMotoristaTransportador) object;
        if ((this.mtraCodigo == null && other.mtraCodigo != null) || (this.mtraCodigo != null && !this.mtraCodigo.equals(other.mtraCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.MtraMotoristaTransportador[mtraCodigo=" + mtraCodigo + "]";
    }

}
