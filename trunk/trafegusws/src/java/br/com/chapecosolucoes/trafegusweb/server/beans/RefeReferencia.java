/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "refe_referencia", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RefeReferencia.findAll", query = "SELECT r FROM RefeReferencia r"),
    @NamedQuery(name = "RefeReferencia.findByRefeCodigo", query = "SELECT r FROM RefeReferencia r WHERE r.refeCodigo = :refeCodigo"),
    @NamedQuery(name = "RefeReferencia.findByRefeDescricao", query = "SELECT r FROM RefeReferencia r WHERE r.refeDescricao = :refeDescricao"),
    @NamedQuery(name = "RefeReferencia.findByRefeLatitude", query = "SELECT r FROM RefeReferencia r WHERE r.refeLatitude = :refeLatitude"),
    @NamedQuery(name = "RefeReferencia.findByRefeLongitude", query = "SELECT r FROM RefeReferencia r WHERE r.refeLongitude = :refeLongitude"),
    @NamedQuery(name = "RefeReferencia.findByRefeRaio", query = "SELECT r FROM RefeReferencia r WHERE r.refeRaio = :refeRaio"),
    @NamedQuery(name = "RefeReferencia.findByRefeKm", query = "SELECT r FROM RefeReferencia r WHERE r.refeKm = :refeKm"),
    @NamedQuery(name = "RefeReferencia.findByRefeBandeira", query = "SELECT r FROM RefeReferencia r WHERE r.refeBandeira = :refeBandeira"),
    @NamedQuery(name = "RefeReferencia.findByRefeUtilizadoSistema", query = "SELECT r FROM RefeReferencia r WHERE r.refeUtilizadoSistema = :refeUtilizadoSistema"),
    @NamedQuery(name = "RefeReferencia.findByRefeDataCadastro", query = "SELECT r FROM RefeReferencia r WHERE r.refeDataCadastro = :refeDataCadastro"),
    @NamedQuery(name = "RefeReferencia.findByRefeCodigoGr", query = "SELECT r FROM RefeReferencia r WHERE r.refeCodigoGr = :refeCodigoGr"),
    @NamedQuery(name = "RefeReferencia.findByRefeImportado", query = "SELECT r FROM RefeReferencia r WHERE r.refeImportado = :refeImportado"),
    @NamedQuery(name = "RefeReferencia.findByRefePessOrasCodigoDono", query = "SELECT r FROM RefeReferencia r WHERE r.refePessOrasCodigoDono = :refePessOrasCodigoDono")})
public class RefeReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "refe_codigo", nullable = false)
    private Integer refeCodigo;
    @Column(name = "refe_descricao", length = 200)
    private String refeDescricao;
    @Column(name = "refe_latitude", precision = 15, scale = 10)
    private BigDecimal refeLatitude;
    @Column(name = "refe_longitude", precision = 15, scale = 10)
    private BigDecimal refeLongitude;
    @Column(name = "refe_raio", precision = 5, scale = 2)
    private BigDecimal refeRaio;
    @Column(name = "refe_km", length = 10)
    private String refeKm;
    @Column(name = "refe_bandeira", length = 15)
    private String refeBandeira;
    @Column(name = "refe_utilizado_sistema")
    private Character refeUtilizadoSistema;
    @Column(name = "refe_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date refeDataCadastro;
    @Column(name = "refe_codigo_gr")
    private Integer refeCodigoGr;
    @Column(name = "refe_importado")
    private Character refeImportado;
    @Column(name = "refe_pess_oras_codigo_dono")
    private Integer refePessOrasCodigoDono;
    @OneToMany(mappedBy = "refeReferencia")
    private Collection<RconReferenciaContato> rconReferenciaContatoCollection;
    @OneToMany(mappedBy = "refeReferencia")
    private Collection<TlocTransportadorLocal> tlocTransportadorLocalCollection;
    @JoinColumn(name = "refe_pess_oras_codigo_local", referencedColumnName = "pess_oras_codigo")
    @ManyToOne
    private PessPessoa pessPessoa;
    @JoinColumn(name = "refe_cref_codigo", referencedColumnName = "cref_codigo")
    @ManyToOne
    private CrefClasseReferencia crefClasseReferencia;
    @JoinColumn(name = "refe_cida_codigo", referencedColumnName = "cida_codigo")
    @ManyToOne
    private CidaCidade cidaCidade;
    @OneToMany(mappedBy = "refeReferencia")
    private Collection<RponRotaPonto> rponRotaPontoCollection;
    @OneToMany(mappedBy = "refeReferencia")
    private Collection<ElocEmbarcadorLocal> elocEmbarcadorLocalCollection;
    @OneToMany(mappedBy = "refeReferencia")
    private Collection<VlocViagemLocal> vlocViagemLocalCollection;

    public RefeReferencia() {
    }

    public RefeReferencia(Integer refeCodigo) {
        this.refeCodigo = refeCodigo;
    }

    public Integer getRefeCodigo() {
        return refeCodigo;
    }

    public void setRefeCodigo(Integer refeCodigo) {
        this.refeCodigo = refeCodigo;
    }

    public String getRefeDescricao() {
        return refeDescricao;
    }

    public void setRefeDescricao(String refeDescricao) {
        this.refeDescricao = refeDescricao;
    }

    public BigDecimal getRefeLatitude() {
        return refeLatitude;
    }

    public void setRefeLatitude(BigDecimal refeLatitude) {
        this.refeLatitude = refeLatitude;
    }

    public BigDecimal getRefeLongitude() {
        return refeLongitude;
    }

    public void setRefeLongitude(BigDecimal refeLongitude) {
        this.refeLongitude = refeLongitude;
    }

    public BigDecimal getRefeRaio() {
        return refeRaio;
    }

    public void setRefeRaio(BigDecimal refeRaio) {
        this.refeRaio = refeRaio;
    }

    public String getRefeKm() {
        return refeKm;
    }

    public void setRefeKm(String refeKm) {
        this.refeKm = refeKm;
    }

    public String getRefeBandeira() {
        return refeBandeira;
    }

    public void setRefeBandeira(String refeBandeira) {
        this.refeBandeira = refeBandeira;
    }

    public Character getRefeUtilizadoSistema() {
        return refeUtilizadoSistema;
    }

    public void setRefeUtilizadoSistema(Character refeUtilizadoSistema) {
        this.refeUtilizadoSistema = refeUtilizadoSistema;
    }

    public Date getRefeDataCadastro() {
        return refeDataCadastro;
    }

    public void setRefeDataCadastro(Date refeDataCadastro) {
        this.refeDataCadastro = refeDataCadastro;
    }

    public Integer getRefeCodigoGr() {
        return refeCodigoGr;
    }

    public void setRefeCodigoGr(Integer refeCodigoGr) {
        this.refeCodigoGr = refeCodigoGr;
    }

    public Character getRefeImportado() {
        return refeImportado;
    }

    public void setRefeImportado(Character refeImportado) {
        this.refeImportado = refeImportado;
    }

    public Integer getRefePessOrasCodigoDono() {
        return refePessOrasCodigoDono;
    }

    public void setRefePessOrasCodigoDono(Integer refePessOrasCodigoDono) {
        this.refePessOrasCodigoDono = refePessOrasCodigoDono;
    }

    public Collection<RconReferenciaContato> getRconReferenciaContatoCollection() {
        return rconReferenciaContatoCollection;
    }

    public void setRconReferenciaContatoCollection(Collection<RconReferenciaContato> rconReferenciaContatoCollection) {
        this.rconReferenciaContatoCollection = rconReferenciaContatoCollection;
    }

    public Collection<TlocTransportadorLocal> getTlocTransportadorLocalCollection() {
        return tlocTransportadorLocalCollection;
    }

    public void setTlocTransportadorLocalCollection(Collection<TlocTransportadorLocal> tlocTransportadorLocalCollection) {
        this.tlocTransportadorLocalCollection = tlocTransportadorLocalCollection;
    }

    public PessPessoa getPessPessoa() {
        return pessPessoa;
    }

    public void setPessPessoa(PessPessoa pessPessoa) {
        this.pessPessoa = pessPessoa;
    }

    public CrefClasseReferencia getCrefClasseReferencia() {
        return crefClasseReferencia;
    }

    public void setCrefClasseReferencia(CrefClasseReferencia crefClasseReferencia) {
        this.crefClasseReferencia = crefClasseReferencia;
    }

    public CidaCidade getCidaCidade() {
        return cidaCidade;
    }

    public void setCidaCidade(CidaCidade cidaCidade) {
        this.cidaCidade = cidaCidade;
    }

    public Collection<RponRotaPonto> getRponRotaPontoCollection() {
        return rponRotaPontoCollection;
    }

    public void setRponRotaPontoCollection(Collection<RponRotaPonto> rponRotaPontoCollection) {
        this.rponRotaPontoCollection = rponRotaPontoCollection;
    }

    public Collection<ElocEmbarcadorLocal> getElocEmbarcadorLocalCollection() {
        return elocEmbarcadorLocalCollection;
    }

    public void setElocEmbarcadorLocalCollection(Collection<ElocEmbarcadorLocal> elocEmbarcadorLocalCollection) {
        this.elocEmbarcadorLocalCollection = elocEmbarcadorLocalCollection;
    }

    public Collection<VlocViagemLocal> getVlocViagemLocalCollection() {
        return vlocViagemLocalCollection;
    }

    public void setVlocViagemLocalCollection(Collection<VlocViagemLocal> vlocViagemLocalCollection) {
        this.vlocViagemLocalCollection = vlocViagemLocalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refeCodigo != null ? refeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefeReferencia)) {
            return false;
        }
        RefeReferencia other = (RefeReferencia) object;
        if ((this.refeCodigo == null && other.refeCodigo != null) || (this.refeCodigo != null && !this.refeCodigo.equals(other.refeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.RefeReferencia[refeCodigo=" + refeCodigo + "]";
    }

}
