/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "gmac_grupo_macro", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "GmacGrupoMacro.findAll", query = "SELECT g FROM GmacGrupoMacro g"),
    @NamedQuery(name = "GmacGrupoMacro.findByGmacCodigo", query = "SELECT g FROM GmacGrupoMacro g WHERE g.gmacCodigo = :gmacCodigo"),
    @NamedQuery(name = "GmacGrupoMacro.findByGmacDescricao", query = "SELECT g FROM GmacGrupoMacro g WHERE g.gmacDescricao = :gmacDescricao"),
    @NamedQuery(name = "GmacGrupoMacro.findByGmacDataCadastro", query = "SELECT g FROM GmacGrupoMacro g WHERE g.gmacDataCadastro = :gmacDataCadastro"),
    @NamedQuery(name = "GmacGrupoMacro.findByGmacCodigoGr", query = "SELECT g FROM GmacGrupoMacro g WHERE g.gmacCodigoGr = :gmacCodigoGr"),
    @NamedQuery(name = "GmacGrupoMacro.findByGmacImportado", query = "SELECT g FROM GmacGrupoMacro g WHERE g.gmacImportado = :gmacImportado"),
    @NamedQuery(name = "GmacGrupoMacro.findByGmacTipoGrupo", query = "SELECT g FROM GmacGrupoMacro g WHERE g.gmacTipoGrupo = :gmacTipoGrupo")})
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
    @OneToMany(mappedBy = "gmacGrupoMacro", fetch = FetchType.EAGER)
    private List<TermTerminal> termTerminalList;
    @OneToMany(mappedBy = "gmacGrupoMacro1", fetch = FetchType.EAGER)
    private List<TermTerminal> termTerminalList1;
    @OneToMany(mappedBy = "gmacGrupoMacro", fetch = FetchType.EAGER)
    private List<MpadMacroPadrao> mpadMacroPadraoList;
    @JoinColumn(name = "gmac_vtec_codigo", referencedColumnName = "vtec_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
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

    public List<TermTerminal> getTermTerminalList() {
        return termTerminalList;
    }

    public void setTermTerminalList(List<TermTerminal> termTerminalList) {
        this.termTerminalList = termTerminalList;
    }

    public List<TermTerminal> getTermTerminalList1() {
        return termTerminalList1;
    }

    public void setTermTerminalList1(List<TermTerminal> termTerminalList1) {
        this.termTerminalList1 = termTerminalList1;
    }

    public List<MpadMacroPadrao> getMpadMacroPadraoList() {
        return mpadMacroPadraoList;
    }

    public void setMpadMacroPadraoList(List<MpadMacroPadrao> mpadMacroPadraoList) {
        this.mpadMacroPadraoList = mpadMacroPadraoList;
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
