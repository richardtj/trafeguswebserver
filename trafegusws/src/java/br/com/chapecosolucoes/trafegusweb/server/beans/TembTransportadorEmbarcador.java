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
@Table(name = "temb_transportador_embarcador")
@NamedQueries({
    @NamedQuery(name = "TembTransportadorEmbarcador.findAll", query = "SELECT t FROM TembTransportadorEmbarcador t"),
    @NamedQuery(name = "TembTransportadorEmbarcador.findByTembCodigo", query = "SELECT t FROM TembTransportadorEmbarcador t WHERE t.tembCodigo = :tembCodigo"),
    @NamedQuery(name = "TembTransportadorEmbarcador.findByTembDataCadastro", query = "SELECT t FROM TembTransportadorEmbarcador t WHERE t.tembDataCadastro = :tembDataCadastro"),
    @NamedQuery(name = "TembTransportadorEmbarcador.findByTembCodigoGr", query = "SELECT t FROM TembTransportadorEmbarcador t WHERE t.tembCodigoGr = :tembCodigoGr"),
    @NamedQuery(name = "TembTransportadorEmbarcador.findByTembImportado", query = "SELECT t FROM TembTransportadorEmbarcador t WHERE t.tembImportado = :tembImportado")})
public class TembTransportadorEmbarcador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "temb_codigo")
    private Integer tembCodigo;
    @Column(name = "temb_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tembDataCadastro;
    @Column(name = "temb_codigo_gr")
    private Integer tembCodigoGr;
    @Column(name = "temb_importado")
    private Character tembImportado;
    @JoinColumn(name = "tvco_codigo", referencedColumnName = "tvco_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private TvcoTipoVinculoContratual tvcoTipoVinculoContratual;
    @JoinColumn(name = "temb_tran_pess_oras_codigo", referencedColumnName = "tran_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private TranTransportador tranTransportador;
    @JoinColumn(name = "temb_emb_pjur_pess_oras_codigo", referencedColumnName = "emba_pjur_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmbaEmbarcador embaEmbarcador;

    public TembTransportadorEmbarcador() {
    }

    public TembTransportadorEmbarcador(Integer tembCodigo) {
        this.tembCodigo = tembCodigo;
    }

    public Integer getTembCodigo() {
        return tembCodigo;
    }

    public void setTembCodigo(Integer tembCodigo) {
        this.tembCodigo = tembCodigo;
    }

    public Date getTembDataCadastro() {
        return tembDataCadastro;
    }

    public void setTembDataCadastro(Date tembDataCadastro) {
        this.tembDataCadastro = tembDataCadastro;
    }

    public Integer getTembCodigoGr() {
        return tembCodigoGr;
    }

    public void setTembCodigoGr(Integer tembCodigoGr) {
        this.tembCodigoGr = tembCodigoGr;
    }

    public Character getTembImportado() {
        return tembImportado;
    }

    public void setTembImportado(Character tembImportado) {
        this.tembImportado = tembImportado;
    }

    public TvcoTipoVinculoContratual getTvcoTipoVinculoContratual() {
        return tvcoTipoVinculoContratual;
    }

    public void setTvcoTipoVinculoContratual(TvcoTipoVinculoContratual tvcoTipoVinculoContratual) {
        this.tvcoTipoVinculoContratual = tvcoTipoVinculoContratual;
    }

    public TranTransportador getTranTransportador() {
        return tranTransportador;
    }

    public void setTranTransportador(TranTransportador tranTransportador) {
        this.tranTransportador = tranTransportador;
    }

    public EmbaEmbarcador getEmbaEmbarcador() {
        return embaEmbarcador;
    }

    public void setEmbaEmbarcador(EmbaEmbarcador embaEmbarcador) {
        this.embaEmbarcador = embaEmbarcador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tembCodigo != null ? tembCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TembTransportadorEmbarcador)) {
            return false;
        }
        TembTransportadorEmbarcador other = (TembTransportadorEmbarcador) object;
        if ((this.tembCodigo == null && other.tembCodigo != null) || (this.tembCodigo != null && !this.tembCodigo.equals(other.tembCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TembTransportadorEmbarcador[tembCodigo=" + tembCodigo + "]";
    }

}
