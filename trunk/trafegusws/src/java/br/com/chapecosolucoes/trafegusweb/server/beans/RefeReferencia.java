/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
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
 * @author emerson
 */
@Entity
@Table(name = "refe_referencia")
@NamedQueries({
    @NamedQuery(name = "RefeReferencia.findAll", query = "SELECT r FROM RefeReferencia r")})
public class RefeReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "refe_codigo")
    private Integer refeCodigo;
    @Column(name = "refe_descricao")
    private String refeDescricao;
    @Column(name = "refe_latitude")
    private BigDecimal refeLatitude;
    @Column(name = "refe_longitude")
    private BigDecimal refeLongitude;
    @Column(name = "refe_raio")
    private BigDecimal refeRaio;
    @Column(name = "refe_km")
    private String refeKm;
    @Column(name = "refe_bandeira")
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
    private Set<VlocViagemLocal> vlocViagemLocalSet;

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

    public Set<VlocViagemLocal> getVlocViagemLocalSet() {
        return vlocViagemLocalSet;
    }

    public void setVlocViagemLocalSet(Set<VlocViagemLocal> vlocViagemLocalSet) {
        this.vlocViagemLocalSet = vlocViagemLocalSet;
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
