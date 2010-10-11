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
@Table(name = "rcon_referencia_contato")
@NamedQueries({
    @NamedQuery(name = "RconReferenciaContato.findAll", query = "SELECT r FROM RconReferenciaContato r"),
    @NamedQuery(name = "RconReferenciaContato.findByRconCodigo", query = "SELECT r FROM RconReferenciaContato r WHERE r.rconCodigo = :rconCodigo"),
    @NamedQuery(name = "RconReferenciaContato.findByRconDataCadastro", query = "SELECT r FROM RconReferenciaContato r WHERE r.rconDataCadastro = :rconDataCadastro"),
    @NamedQuery(name = "RconReferenciaContato.findByRconCodigoGr", query = "SELECT r FROM RconReferenciaContato r WHERE r.rconCodigoGr = :rconCodigoGr"),
    @NamedQuery(name = "RconReferenciaContato.findByRconImportado", query = "SELECT r FROM RconReferenciaContato r WHERE r.rconImportado = :rconImportado")})
public class RconReferenciaContato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rcon_codigo")
    private Integer rconCodigo;
    @Column(name = "rcon_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rconDataCadastro;
    @Column(name = "rcon_codigo_gr")
    private Integer rconCodigoGr;
    @Column(name = "rcon_importado")
    private Character rconImportado;
    @JoinColumn(name = "rcon_refe_codigo", referencedColumnName = "refe_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private RefeReferencia refeReferencia;
    @JoinColumn(name = "rcon_cona_codigo", referencedColumnName = "cona_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private ConaContato conaContato;

    public RconReferenciaContato() {
    }

    public RconReferenciaContato(Integer rconCodigo) {
        this.rconCodigo = rconCodigo;
    }

    public Integer getRconCodigo() {
        return rconCodigo;
    }

    public void setRconCodigo(Integer rconCodigo) {
        this.rconCodigo = rconCodigo;
    }

    public Date getRconDataCadastro() {
        return rconDataCadastro;
    }

    public void setRconDataCadastro(Date rconDataCadastro) {
        this.rconDataCadastro = rconDataCadastro;
    }

    public Integer getRconCodigoGr() {
        return rconCodigoGr;
    }

    public void setRconCodigoGr(Integer rconCodigoGr) {
        this.rconCodigoGr = rconCodigoGr;
    }

    public Character getRconImportado() {
        return rconImportado;
    }

    public void setRconImportado(Character rconImportado) {
        this.rconImportado = rconImportado;
    }

    public RefeReferencia getRefeReferencia() {
        return refeReferencia;
    }

    public void setRefeReferencia(RefeReferencia refeReferencia) {
        this.refeReferencia = refeReferencia;
    }

    public ConaContato getConaContato() {
        return conaContato;
    }

    public void setConaContato(ConaContato conaContato) {
        this.conaContato = conaContato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rconCodigo != null ? rconCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RconReferenciaContato)) {
            return false;
        }
        RconReferenciaContato other = (RconReferenciaContato) object;
        if ((this.rconCodigo == null && other.rconCodigo != null) || (this.rconCodigo != null && !this.rconCodigo.equals(other.rconCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.RconReferenciaContato[rconCodigo=" + rconCodigo + "]";
    }

}
