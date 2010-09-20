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
@Table(name = "vter_viagem_terminal", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VterViagemTerminal.findAll", query = "SELECT v FROM VterViagemTerminal v"),
    @NamedQuery(name = "VterViagemTerminal.findByVterCodigo", query = "SELECT v FROM VterViagemTerminal v WHERE v.vterCodigo = :vterCodigo"),
    @NamedQuery(name = "VterViagemTerminal.findByVterPrecedencia", query = "SELECT v FROM VterViagemTerminal v WHERE v.vterPrecedencia = :vterPrecedencia"),
    @NamedQuery(name = "VterViagemTerminal.findByVterTempoSatelital", query = "SELECT v FROM VterViagemTerminal v WHERE v.vterTempoSatelital = :vterTempoSatelital"),
    @NamedQuery(name = "VterViagemTerminal.findByVterTempoGprs", query = "SELECT v FROM VterViagemTerminal v WHERE v.vterTempoGprs = :vterTempoGprs"),
    @NamedQuery(name = "VterViagemTerminal.findByVterDataCadastro", query = "SELECT v FROM VterViagemTerminal v WHERE v.vterDataCadastro = :vterDataCadastro"),
    @NamedQuery(name = "VterViagemTerminal.findByVterCodigoGr", query = "SELECT v FROM VterViagemTerminal v WHERE v.vterCodigoGr = :vterCodigoGr"),
    @NamedQuery(name = "VterViagemTerminal.findByVterImportado", query = "SELECT v FROM VterViagemTerminal v WHERE v.vterImportado = :vterImportado"),
    @NamedQuery(name = "VterViagemTerminal.findByVterAtivo", query = "SELECT v FROM VterViagemTerminal v WHERE v.vterAtivo = :vterAtivo")})
public class VterViagemTerminal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vter_codigo", nullable = false)
    private Integer vterCodigo;
    @Column(name = "vter_precedencia", length = 10)
    private String vterPrecedencia;
    @Column(name = "vter_tempo_satelital")
    private Integer vterTempoSatelital;
    @Column(name = "vter_tempo_gprs")
    private Integer vterTempoGprs;
    @Column(name = "vter_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vterDataCadastro;
    @Column(name = "vter_codigo_gr")
    private Integer vterCodigoGr;
    @Column(name = "vter_importado")
    private Character vterImportado;
    @Column(name = "vter_ativo")
    private Character vterAtivo;
    @JoinColumn(name = "vter_viag_codigo", referencedColumnName = "viag_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private ViagViagem viagViagem;
    @JoinColumn(name = "vter_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private UsuaUsuario usuaUsuario;
    @JoinColumn(name = "vter_term_codigo", referencedColumnName = "term_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TermTerminal termTerminal;

    public VterViagemTerminal() {
    }

    public VterViagemTerminal(Integer vterCodigo) {
        this.vterCodigo = vterCodigo;
    }

    public Integer getVterCodigo() {
        return vterCodigo;
    }

    public void setVterCodigo(Integer vterCodigo) {
        this.vterCodigo = vterCodigo;
    }

    public String getVterPrecedencia() {
        return vterPrecedencia;
    }

    public void setVterPrecedencia(String vterPrecedencia) {
        this.vterPrecedencia = vterPrecedencia;
    }

    public Integer getVterTempoSatelital() {
        return vterTempoSatelital;
    }

    public void setVterTempoSatelital(Integer vterTempoSatelital) {
        this.vterTempoSatelital = vterTempoSatelital;
    }

    public Integer getVterTempoGprs() {
        return vterTempoGprs;
    }

    public void setVterTempoGprs(Integer vterTempoGprs) {
        this.vterTempoGprs = vterTempoGprs;
    }

    public Date getVterDataCadastro() {
        return vterDataCadastro;
    }

    public void setVterDataCadastro(Date vterDataCadastro) {
        this.vterDataCadastro = vterDataCadastro;
    }

    public Integer getVterCodigoGr() {
        return vterCodigoGr;
    }

    public void setVterCodigoGr(Integer vterCodigoGr) {
        this.vterCodigoGr = vterCodigoGr;
    }

    public Character getVterImportado() {
        return vterImportado;
    }

    public void setVterImportado(Character vterImportado) {
        this.vterImportado = vterImportado;
    }

    public Character getVterAtivo() {
        return vterAtivo;
    }

    public void setVterAtivo(Character vterAtivo) {
        this.vterAtivo = vterAtivo;
    }

    public ViagViagem getViagViagem() {
        return viagViagem;
    }

    public void setViagViagem(ViagViagem viagViagem) {
        this.viagViagem = viagViagem;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public TermTerminal getTermTerminal() {
        return termTerminal;
    }

    public void setTermTerminal(TermTerminal termTerminal) {
        this.termTerminal = termTerminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vterCodigo != null ? vterCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VterViagemTerminal)) {
            return false;
        }
        VterViagemTerminal other = (VterViagemTerminal) object;
        if ((this.vterCodigo == null && other.vterCodigo != null) || (this.vterCodigo != null && !this.vterCodigo.equals(other.vterCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.VterViagemTerminal[vterCodigo=" + vterCodigo + "]";
    }

}
