/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "upos_ultima_posicao", catalog = "trafegus_transc", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"upos_vtec_codigo", "upos_term_numero_terminal"})})
@NamedQueries({
    @NamedQuery(name = "UposUltimaPosicao.findAll", query = "SELECT u FROM UposUltimaPosicao u"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposCodigo", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposCodigo = :uposCodigo"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposReceCodigo", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposReceCodigo = :uposReceCodigo"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposVtecCodigo", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposUltimaPosicaoPK.uposVtecCodigo = :uposVtecCodigo"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposTermNumeroTerminal", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposUltimaPosicaoPK.uposTermNumeroTerminal = :uposTermNumeroTerminal"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposDescricaoIntegracao", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposDescricaoIntegracao = :uposDescricaoIntegracao"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposDescricaoSistema", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposDescricaoSistema = :uposDescricaoSistema"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposLatitude", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposLatitude = :uposLatitude"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposDataCadastro", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposDataCadastro = :uposDataCadastro"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposLongitude", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposLongitude = :uposLongitude"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposCodigoGr", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposCodigoGr = :uposCodigoGr"),
    @NamedQuery(name = "UposUltimaPosicao.findByUposDataCompBordo", query = "SELECT u FROM UposUltimaPosicao u WHERE u.uposDataCompBordo = :uposDataCompBordo")})
public class UposUltimaPosicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UposUltimaPosicaoPK uposUltimaPosicaoPK;
    @Basic(optional = false)
    @Column(name = "upos_codigo", nullable = false)
    private int uposCodigo;
    @Column(name = "upos_rece_codigo")
    private Integer uposReceCodigo;
    @Column(name = "upos_descricao_integracao", length = 200)
    private String uposDescricaoIntegracao;
    @Column(name = "upos_descricao_sistema", length = 200)
    private String uposDescricaoSistema;
    @Column(name = "upos_latitude", precision = 15, scale = 10)
    private BigDecimal uposLatitude;
    @Column(name = "upos_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uposDataCadastro;
    @Column(name = "upos_longitude", precision = 15, scale = 10)
    private BigDecimal uposLongitude;
    @Column(name = "upos_codigo_gr")
    private Integer uposCodigoGr;
    @Column(name = "upos_data_comp_bordo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uposDataCompBordo;
    @JoinColumn(name = "upos_vtec_codigo", referencedColumnName = "vtec_codigo", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private VtecVersaoTecnologia vtecVersaoTecnologia;

    public UposUltimaPosicao() {
    }

    public UposUltimaPosicao(UposUltimaPosicaoPK uposUltimaPosicaoPK) {
        this.uposUltimaPosicaoPK = uposUltimaPosicaoPK;
    }

    public UposUltimaPosicao(UposUltimaPosicaoPK uposUltimaPosicaoPK, int uposCodigo) {
        this.uposUltimaPosicaoPK = uposUltimaPosicaoPK;
        this.uposCodigo = uposCodigo;
    }

    public UposUltimaPosicao(Integer uposVtecCodigo, String uposTermNumeroTerminal) {
        this.uposUltimaPosicaoPK = new UposUltimaPosicaoPK(uposVtecCodigo, uposTermNumeroTerminal);
    }

    public UposUltimaPosicaoPK getUposUltimaPosicaoPK() {
        return uposUltimaPosicaoPK;
    }

    public void setUposUltimaPosicaoPK(UposUltimaPosicaoPK uposUltimaPosicaoPK) {
        this.uposUltimaPosicaoPK = uposUltimaPosicaoPK;
    }

    public int getUposCodigo() {
        return uposCodigo;
    }

    public void setUposCodigo(int uposCodigo) {
        this.uposCodigo = uposCodigo;
    }

    public Integer getUposReceCodigo() {
        return uposReceCodigo;
    }

    public void setUposReceCodigo(Integer uposReceCodigo) {
        this.uposReceCodigo = uposReceCodigo;
    }

    public String getUposDescricaoIntegracao() {
        return uposDescricaoIntegracao;
    }

    public void setUposDescricaoIntegracao(String uposDescricaoIntegracao) {
        this.uposDescricaoIntegracao = uposDescricaoIntegracao;
    }

    public String getUposDescricaoSistema() {
        return uposDescricaoSistema;
    }

    public void setUposDescricaoSistema(String uposDescricaoSistema) {
        this.uposDescricaoSistema = uposDescricaoSistema;
    }

    public BigDecimal getUposLatitude() {
        return uposLatitude;
    }

    public void setUposLatitude(BigDecimal uposLatitude) {
        this.uposLatitude = uposLatitude;
    }

    public Date getUposDataCadastro() {
        return uposDataCadastro;
    }

    public void setUposDataCadastro(Date uposDataCadastro) {
        this.uposDataCadastro = uposDataCadastro;
    }

    public BigDecimal getUposLongitude() {
        return uposLongitude;
    }

    public void setUposLongitude(BigDecimal uposLongitude) {
        this.uposLongitude = uposLongitude;
    }

    public Integer getUposCodigoGr() {
        return uposCodigoGr;
    }

    public void setUposCodigoGr(Integer uposCodigoGr) {
        this.uposCodigoGr = uposCodigoGr;
    }

    public Date getUposDataCompBordo() {
        return uposDataCompBordo;
    }

    public void setUposDataCompBordo(Date uposDataCompBordo) {
        this.uposDataCompBordo = uposDataCompBordo;
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
        hash += (uposUltimaPosicaoPK != null ? uposUltimaPosicaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UposUltimaPosicao)) {
            return false;
        }
        UposUltimaPosicao other = (UposUltimaPosicao) object;
        if ((this.uposUltimaPosicaoPK == null && other.uposUltimaPosicaoPK != null) || (this.uposUltimaPosicaoPK != null && !this.uposUltimaPosicaoPK.equals(other.uposUltimaPosicaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.UposUltimaPosicao[uposUltimaPosicaoPK=" + uposUltimaPosicaoPK + "]";
    }

}
