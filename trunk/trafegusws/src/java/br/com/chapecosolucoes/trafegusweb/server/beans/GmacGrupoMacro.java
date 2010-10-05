/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
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
@Table(name = "gmac_grupo_macro")
@NamedQueries({
    @NamedQuery(name = "GmacGrupoMacro.findAll", query = "SELECT g FROM GmacGrupoMacro g")})
public class GmacGrupoMacro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "gmac_codigo")
    private Integer gmacCodigo;
    @Column(name = "gmac_descricao")
    private String gmacDescricao;
    @Column(name = "gmac_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmacDataCadastro;
    @Column(name = "gmac_codigo_gr")
    private Integer gmacCodigoGr;
    @Column(name = "gmac_importado")
    private Character gmacImportado;
    @Column(name = "gmac_tipo_grupo")
    private String gmacTipoGrupo;
    @OneToMany(mappedBy = "gmacGrupoMacro")
    private Set<TermTerminal> termTerminalSet;
    @OneToMany(mappedBy = "gmacGrupoMacro1")
    private Set<TermTerminal> termTerminalSet1;
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

    public Set<TermTerminal> getTermTerminalSet() {
        return termTerminalSet;
    }

    public void setTermTerminalSet(Set<TermTerminal> termTerminalSet) {
        this.termTerminalSet = termTerminalSet;
    }

    public Set<TermTerminal> getTermTerminalSet1() {
        return termTerminalSet1;
    }

    public void setTermTerminalSet1(Set<TermTerminal> termTerminalSet1) {
        this.termTerminalSet1 = termTerminalSet1;
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
        return "br.com.chapecosolucoes.trafegusweb.server.beans.GmacGrupoMacro[gmacCodigo=" + gmacCodigo + "]";
    }

}
