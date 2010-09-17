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
@Table(name = "pcam_permissao_campo")
@NamedQueries({
    @NamedQuery(name = "PcamPermissaoCampo.findAll", query = "SELECT p FROM PcamPermissaoCampo p")})
public class PcamPermissaoCampo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pcam_codigo", nullable = false)
    private Integer pcamCodigo;
    @Column(name = "pcam_id_obejto")
    private Integer pcamIdObejto;
    @Column(name = "pcam_permitir_alterar")
    private Character pcamPermitirAlterar;
    @Column(name = "pcam_permitir_visualizar")
    private Character pcamPermitirVisualizar;
    @Column(name = "pcam_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pcamDataCadastro;
    @Column(name = "pcam_codigo_gr")
    private Integer pcamCodigoGr;
    @Column(name = "pcam_importado")
    private Character pcamImportado;
    @JoinColumn(name = "pcam_ptel_codigo", referencedColumnName = "ptel_codigo")
    @ManyToOne
    private PtelPermissaoTela ptelPermissaoTela;

    public PcamPermissaoCampo() {
    }

    public PcamPermissaoCampo(Integer pcamCodigo) {
        this.pcamCodigo = pcamCodigo;
    }

    public Integer getPcamCodigo() {
        return pcamCodigo;
    }

    public void setPcamCodigo(Integer pcamCodigo) {
        this.pcamCodigo = pcamCodigo;
    }

    public Integer getPcamIdObejto() {
        return pcamIdObejto;
    }

    public void setPcamIdObejto(Integer pcamIdObejto) {
        this.pcamIdObejto = pcamIdObejto;
    }

    public Character getPcamPermitirAlterar() {
        return pcamPermitirAlterar;
    }

    public void setPcamPermitirAlterar(Character pcamPermitirAlterar) {
        this.pcamPermitirAlterar = pcamPermitirAlterar;
    }

    public Character getPcamPermitirVisualizar() {
        return pcamPermitirVisualizar;
    }

    public void setPcamPermitirVisualizar(Character pcamPermitirVisualizar) {
        this.pcamPermitirVisualizar = pcamPermitirVisualizar;
    }

    public Date getPcamDataCadastro() {
        return pcamDataCadastro;
    }

    public void setPcamDataCadastro(Date pcamDataCadastro) {
        this.pcamDataCadastro = pcamDataCadastro;
    }

    public Integer getPcamCodigoGr() {
        return pcamCodigoGr;
    }

    public void setPcamCodigoGr(Integer pcamCodigoGr) {
        this.pcamCodigoGr = pcamCodigoGr;
    }

    public Character getPcamImportado() {
        return pcamImportado;
    }

    public void setPcamImportado(Character pcamImportado) {
        this.pcamImportado = pcamImportado;
    }

    public PtelPermissaoTela getPtelPermissaoTela() {
        return ptelPermissaoTela;
    }

    public void setPtelPermissaoTela(PtelPermissaoTela ptelPermissaoTela) {
        this.ptelPermissaoTela = ptelPermissaoTela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcamCodigo != null ? pcamCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcamPermissaoCampo)) {
            return false;
        }
        PcamPermissaoCampo other = (PcamPermissaoCampo) object;
        if ((this.pcamCodigo == null && other.pcamCodigo != null) || (this.pcamCodigo != null && !this.pcamCodigo.equals(other.pcamCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PcamPermissaoCampo[pcamCodigo=" + pcamCodigo + "]";
    }

}
