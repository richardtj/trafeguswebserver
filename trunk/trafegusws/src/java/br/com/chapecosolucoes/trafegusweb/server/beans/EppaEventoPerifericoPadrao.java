/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

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
@Table(name = "eppa_evento_periferico_padrao")
@NamedQueries({
    @NamedQuery(name = "EppaEventoPerifericoPadrao.findAll", query = "SELECT e FROM EppaEventoPerifericoPadrao e"),
    @NamedQuery(name = "EppaEventoPerifericoPadrao.findByEppaCodigo", query = "SELECT e FROM EppaEventoPerifericoPadrao e WHERE e.eppaCodigo = :eppaCodigo"),
    @NamedQuery(name = "EppaEventoPerifericoPadrao.findByEppaDescricao", query = "SELECT e FROM EppaEventoPerifericoPadrao e WHERE e.eppaDescricao = :eppaDescricao"),
    @NamedQuery(name = "EppaEventoPerifericoPadrao.findByEppaPreenchimento", query = "SELECT e FROM EppaEventoPerifericoPadrao e WHERE e.eppaPreenchimento = :eppaPreenchimento"),
    @NamedQuery(name = "EppaEventoPerifericoPadrao.findByEppaDataCadastro", query = "SELECT e FROM EppaEventoPerifericoPadrao e WHERE e.eppaDataCadastro = :eppaDataCadastro"),
    @NamedQuery(name = "EppaEventoPerifericoPadrao.findByEppaCodigoGr", query = "SELECT e FROM EppaEventoPerifericoPadrao e WHERE e.eppaCodigoGr = :eppaCodigoGr"),
    @NamedQuery(name = "EppaEventoPerifericoPadrao.findByEppaImportado", query = "SELECT e FROM EppaEventoPerifericoPadrao e WHERE e.eppaImportado = :eppaImportado")})
public class EppaEventoPerifericoPadrao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eppa_codigo")
    private Integer eppaCodigo;
    @Column(name = "eppa_descricao")
    private String eppaDescricao;
    @Column(name = "eppa_preenchimento")
    private String eppaPreenchimento;
    @Column(name = "eppa_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eppaDataCadastro;
    @Column(name = "eppa_codigo_gr")
    private Integer eppaCodigoGr;
    @Column(name = "eppa_importado")
    private Character eppaImportado;
    @OneToMany(mappedBy = "eppaEventoPerifericoPadrao", fetch = FetchType.EAGER)
    private List<UrpeUltimoRecPeriferico> urpeUltimoRecPerifericoList;
    @JoinColumn(name = "eppa_tval_codigo", referencedColumnName = "tval_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TvalTipoValor tvalTipoValor;
    @JoinColumn(name = "eppa_ppad_codigo", referencedColumnName = "ppad_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PpadPerifericoPadrao ppadPerifericoPadrao;

    public EppaEventoPerifericoPadrao() {
    }

    public EppaEventoPerifericoPadrao(Integer eppaCodigo) {
        this.eppaCodigo = eppaCodigo;
    }

    public Integer getEppaCodigo() {
        return eppaCodigo;
    }

    public void setEppaCodigo(Integer eppaCodigo) {
        this.eppaCodigo = eppaCodigo;
    }

    public String getEppaDescricao() {
        return eppaDescricao;
    }

    public void setEppaDescricao(String eppaDescricao) {
        this.eppaDescricao = eppaDescricao;
    }

    public String getEppaPreenchimento() {
        return eppaPreenchimento;
    }

    public void setEppaPreenchimento(String eppaPreenchimento) {
        this.eppaPreenchimento = eppaPreenchimento;
    }

    public Date getEppaDataCadastro() {
        return eppaDataCadastro;
    }

    public void setEppaDataCadastro(Date eppaDataCadastro) {
        this.eppaDataCadastro = eppaDataCadastro;
    }

    public Integer getEppaCodigoGr() {
        return eppaCodigoGr;
    }

    public void setEppaCodigoGr(Integer eppaCodigoGr) {
        this.eppaCodigoGr = eppaCodigoGr;
    }

    public Character getEppaImportado() {
        return eppaImportado;
    }

    public void setEppaImportado(Character eppaImportado) {
        this.eppaImportado = eppaImportado;
    }

    public List<UrpeUltimoRecPeriferico> getUrpeUltimoRecPerifericoList() {
        return urpeUltimoRecPerifericoList;
    }

    public void setUrpeUltimoRecPerifericoList(List<UrpeUltimoRecPeriferico> urpeUltimoRecPerifericoList) {
        this.urpeUltimoRecPerifericoList = urpeUltimoRecPerifericoList;
    }

    public TvalTipoValor getTvalTipoValor() {
        return tvalTipoValor;
    }

    public void setTvalTipoValor(TvalTipoValor tvalTipoValor) {
        this.tvalTipoValor = tvalTipoValor;
    }

    public PpadPerifericoPadrao getPpadPerifericoPadrao() {
        return ppadPerifericoPadrao;
    }

    public void setPpadPerifericoPadrao(PpadPerifericoPadrao ppadPerifericoPadrao) {
        this.ppadPerifericoPadrao = ppadPerifericoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eppaCodigo != null ? eppaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EppaEventoPerifericoPadrao)) {
            return false;
        }
        EppaEventoPerifericoPadrao other = (EppaEventoPerifericoPadrao) object;
        if ((this.eppaCodigo == null && other.eppaCodigo != null) || (this.eppaCodigo != null && !this.eppaCodigo.equals(other.eppaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EppaEventoPerifericoPadrao[eppaCodigo=" + eppaCodigo + "]";
    }

}
