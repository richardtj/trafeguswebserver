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
@Table(name = "ulsi_ultimo_log_servico_integ")
@NamedQueries({
    @NamedQuery(name = "UlsiUltimoLogServicoInteg.findAll", query = "SELECT u FROM UlsiUltimoLogServicoInteg u"),
    @NamedQuery(name = "UlsiUltimoLogServicoInteg.findByUlsiLsinCodigo", query = "SELECT u FROM UlsiUltimoLogServicoInteg u WHERE u.ulsiLsinCodigo = :ulsiLsinCodigo"),
    @NamedQuery(name = "UlsiUltimoLogServicoInteg.findByUlsiMintDescricao", query = "SELECT u FROM UlsiUltimoLogServicoInteg u WHERE u.ulsiMintDescricao = :ulsiMintDescricao"),
    @NamedQuery(name = "UlsiUltimoLogServicoInteg.findByUlsiDataInicio", query = "SELECT u FROM UlsiUltimoLogServicoInteg u WHERE u.ulsiDataInicio = :ulsiDataInicio"),
    @NamedQuery(name = "UlsiUltimoLogServicoInteg.findByUlsiDataFim", query = "SELECT u FROM UlsiUltimoLogServicoInteg u WHERE u.ulsiDataFim = :ulsiDataFim"),
    @NamedQuery(name = "UlsiUltimoLogServicoInteg.findByUlsiEstatus", query = "SELECT u FROM UlsiUltimoLogServicoInteg u WHERE u.ulsiEstatus = :ulsiEstatus")})
public class UlsiUltimoLogServicoInteg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ulsi_lsin_codigo")
    private Integer ulsiLsinCodigo;
    @Column(name = "ulsi_mint_descricao")
    private String ulsiMintDescricao;
    @Basic(optional = false)
    @Column(name = "ulsi_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ulsiDataInicio;
    @Column(name = "ulsi_data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ulsiDataFim;
    @Column(name = "ulsi_estatus")
    private String ulsiEstatus;
    @JoinColumn(name = "ulsi_ssis_codigo", referencedColumnName = "ssis_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private SsisServicoSistema ssisServicoSistema;
    @JoinColumn(name = "ulsi_ctec_codigo", referencedColumnName = "ctec_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private CtecContaTecnologia ctecContaTecnologia;

    public UlsiUltimoLogServicoInteg() {
    }

    public UlsiUltimoLogServicoInteg(Integer ulsiLsinCodigo) {
        this.ulsiLsinCodigo = ulsiLsinCodigo;
    }

    public UlsiUltimoLogServicoInteg(Integer ulsiLsinCodigo, Date ulsiDataInicio) {
        this.ulsiLsinCodigo = ulsiLsinCodigo;
        this.ulsiDataInicio = ulsiDataInicio;
    }

    public Integer getUlsiLsinCodigo() {
        return ulsiLsinCodigo;
    }

    public void setUlsiLsinCodigo(Integer ulsiLsinCodigo) {
        this.ulsiLsinCodigo = ulsiLsinCodigo;
    }

    public String getUlsiMintDescricao() {
        return ulsiMintDescricao;
    }

    public void setUlsiMintDescricao(String ulsiMintDescricao) {
        this.ulsiMintDescricao = ulsiMintDescricao;
    }

    public Date getUlsiDataInicio() {
        return ulsiDataInicio;
    }

    public void setUlsiDataInicio(Date ulsiDataInicio) {
        this.ulsiDataInicio = ulsiDataInicio;
    }

    public Date getUlsiDataFim() {
        return ulsiDataFim;
    }

    public void setUlsiDataFim(Date ulsiDataFim) {
        this.ulsiDataFim = ulsiDataFim;
    }

    public String getUlsiEstatus() {
        return ulsiEstatus;
    }

    public void setUlsiEstatus(String ulsiEstatus) {
        this.ulsiEstatus = ulsiEstatus;
    }

    public SsisServicoSistema getSsisServicoSistema() {
        return ssisServicoSistema;
    }

    public void setSsisServicoSistema(SsisServicoSistema ssisServicoSistema) {
        this.ssisServicoSistema = ssisServicoSistema;
    }

    public CtecContaTecnologia getCtecContaTecnologia() {
        return ctecContaTecnologia;
    }

    public void setCtecContaTecnologia(CtecContaTecnologia ctecContaTecnologia) {
        this.ctecContaTecnologia = ctecContaTecnologia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ulsiLsinCodigo != null ? ulsiLsinCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UlsiUltimoLogServicoInteg)) {
            return false;
        }
        UlsiUltimoLogServicoInteg other = (UlsiUltimoLogServicoInteg) object;
        if ((this.ulsiLsinCodigo == null && other.ulsiLsinCodigo != null) || (this.ulsiLsinCodigo != null && !this.ulsiLsinCodigo.equals(other.ulsiLsinCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.UlsiUltimoLogServicoInteg[ulsiLsinCodigo=" + ulsiLsinCodigo + "]";
    }

}
