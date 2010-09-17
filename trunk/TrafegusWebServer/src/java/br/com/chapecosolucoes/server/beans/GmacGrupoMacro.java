/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
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
@Table(name = "gmac_grupo_macro")
@NamedQueries({
    @NamedQuery(name = "GmacGrupoMacro.findAll", query = "SELECT g FROM GmacGrupoMacro g")})
public class GmacGrupoMacro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "gmac_codigo", nullable = false)
    private Integer gmacCodigo;
    @Column(name = "gmac_descricao", length = 50)
    private String gmacDescricao;
    @Column(name = "gmac_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmacDataCadastro;
    @Column(name = "gmac_codigo_gr")
    private Integer gmacCodigoGr;
    @Column(name = "gmac_importado")
    private Character gmacImportado;
    @Column(name = "gmac_tipo_grupo", length = 10)
    private String gmacTipoGrupo;
    @OneToMany(mappedBy = "gmacGrupoMacro")
    private Collection<TermTerminal> termTerminalCollection;
    @OneToMany(mappedBy = "gmacGrupoMacro1")
    private Collection<TermTerminal> termTerminalCollection1;
    @OneToMany(mappedBy = "gmacGrupoMacro")
    private Collection<MpadMacroPadrao> mpadMacroPadraoCollection;
    @JoinColumn(name = "gmac_vtec_codigo", referencedColumnName = "vtec_codigo")
    @ManyToOne
    private VtecVersaoTecnologia vtecVersaoTecnologia;

    public GmacGrupoMacro() {
    }

    public GmacGrupoMacro(Integer gmacCodigo) {
        this.gmacCodigo = gmacCodigo;
    }

    public Integer getGmacCodigo() {
        return gmacCodigo;
    }

    public void setGmacCodigo(Integer gmacCodigo) {
        this.gmacCodigo = gmacCodigo;
    }

    public String getGmacDescricao() {
        return gmacDescricao;
    }

    public void setGmacDescricao(String gmacDescricao) {
        this.gmacDescricao = gmacDescricao;
    }

    public Date getGmacDataCadastro() {
        return gmacDataCadastro;
    }

    public void setGmacDataCadastro(Date gmacDataCadastro) {
        this.gmacDataCadastro = gmacDataCadastro;
    }

    public Integer getGmacCodigoGr() {
        return gmacCodigoGr;
    }

    public void setGmacCodigoGr(Integer gmacCodigoGr) {
        this.gmacCodigoGr = gmacCodigoGr;
    }

    public Character getGmacImportado() {
        return gmacImportado;
    }

    public void setGmacImportado(Character gmacImportado) {
        this.gmacImportado = gmacImportado;
    }

    public String getGmacTipoGrupo() {
        return gmacTipoGrupo;
    }

    public void setGmacTipoGrupo(String gmacTipoGrupo) {
        this.gmacTipoGrupo = gmacTipoGrupo;
    }

    public Collection<TermTerminal> getTermTerminalCollection() {
        return termTerminalCollection;
    }

    public void setTermTerminalCollection(Collection<TermTerminal> termTerminalCollection) {
        this.termTerminalCollection = termTerminalCollection;
    }

    public Collection<TermTerminal> getTermTerminalCollection1() {
        return termTerminalCollection1;
    }

    public void setTermTerminalCollection1(Collection<TermTerminal> termTerminalCollection1) {
        this.termTerminalCollection1 = termTerminalCollection1;
    }

    public Collection<MpadMacroPadrao> getMpadMacroPadraoCollection() {
        return mpadMacroPadraoCollection;
    }

    public void setMpadMacroPadraoCollection(Collection<MpadMacroPadrao> mpadMacroPadraoCollection) {
        this.mpadMacroPadraoCollection = mpadMacroPadraoCollection;
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
        hash += (gmacCodigo != null ? gmacCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GmacGrupoMacro)) {
            return false;
        }
        GmacGrupoMacro other = (GmacGrupoMacro) object;
        if ((this.gmacCodigo == null && other.gmacCodigo != null) || (this.gmacCodigo != null && !this.gmacCodigo.equals(other.gmacCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.GmacGrupoMacro[gmacCodigo=" + gmacCodigo + "]";
    }

}
