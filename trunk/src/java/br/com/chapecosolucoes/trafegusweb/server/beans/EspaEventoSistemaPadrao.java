/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

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
@Table(name = "espa_evento_sistema_padrao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EspaEventoSistemaPadrao.findAll", query = "SELECT e FROM EspaEventoSistemaPadrao e"),
    @NamedQuery(name = "EspaEventoSistemaPadrao.findByEspaCodigo", query = "SELECT e FROM EspaEventoSistemaPadrao e WHERE e.espaCodigo = :espaCodigo"),
    @NamedQuery(name = "EspaEventoSistemaPadrao.findByEspaDescricao", query = "SELECT e FROM EspaEventoSistemaPadrao e WHERE e.espaDescricao = :espaDescricao"),
    @NamedQuery(name = "EspaEventoSistemaPadrao.findByEspaPreenchimento", query = "SELECT e FROM EspaEventoSistemaPadrao e WHERE e.espaPreenchimento = :espaPreenchimento"),
    @NamedQuery(name = "EspaEventoSistemaPadrao.findByEspaCor", query = "SELECT e FROM EspaEventoSistemaPadrao e WHERE e.espaCor = :espaCor"),
    @NamedQuery(name = "EspaEventoSistemaPadrao.findByEspaDataCadastro", query = "SELECT e FROM EspaEventoSistemaPadrao e WHERE e.espaDataCadastro = :espaDataCadastro"),
    @NamedQuery(name = "EspaEventoSistemaPadrao.findByEspaCodigoGr", query = "SELECT e FROM EspaEventoSistemaPadrao e WHERE e.espaCodigoGr = :espaCodigoGr"),
    @NamedQuery(name = "EspaEventoSistemaPadrao.findByEspaImportado", query = "SELECT e FROM EspaEventoSistemaPadrao e WHERE e.espaImportado = :espaImportado"),
    @NamedQuery(name = "EspaEventoSistemaPadrao.findByEspaPrioridade", query = "SELECT e FROM EspaEventoSistemaPadrao e WHERE e.espaPrioridade = :espaPrioridade")})
public class EspaEventoSistemaPadrao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "espa_codigo", nullable = false)
    private Integer espaCodigo;
    @Column(name = "espa_descricao", length = 100)
    private String espaDescricao;
    @Column(name = "espa_preenchimento", length = 200)
    private String espaPreenchimento;
    @Column(name = "espa_cor", length = 10)
    private String espaCor;
    @Column(name = "espa_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date espaDataCadastro;
    @Column(name = "espa_codigo_gr")
    private Integer espaCodigoGr;
    @Column(name = "espa_importado")
    private Character espaImportado;
    @Column(name = "espa_prioridade", length = 10)
    private String espaPrioridade;
    @JoinColumn(name = "espa_tval_codigo", referencedColumnName = "tval_codigo")
    @ManyToOne
    private TvalTipoValor tvalTipoValor;
    @OneToMany(mappedBy = "espaEventoSistemaPadrao")
    private Collection<EsisEventoSistema> esisEventoSistemaCollection;
    @OneToMany(mappedBy = "espaEventoSistemaPadrao")
    private Collection<PitePgItem> pitePgItemCollection;

    public EspaEventoSistemaPadrao() {
    }

    public EspaEventoSistemaPadrao(Integer espaCodigo) {
        this.espaCodigo = espaCodigo;
    }

    public Integer getEspaCodigo() {
        return espaCodigo;
    }

    public void setEspaCodigo(Integer espaCodigo) {
        this.espaCodigo = espaCodigo;
    }

    public String getEspaDescricao() {
        return espaDescricao;
    }

    public void setEspaDescricao(String espaDescricao) {
        this.espaDescricao = espaDescricao;
    }

    public String getEspaPreenchimento() {
        return espaPreenchimento;
    }

    public void setEspaPreenchimento(String espaPreenchimento) {
        this.espaPreenchimento = espaPreenchimento;
    }

    public String getEspaCor() {
        return espaCor;
    }

    public void setEspaCor(String espaCor) {
        this.espaCor = espaCor;
    }

    public Date getEspaDataCadastro() {
        return espaDataCadastro;
    }

    public void setEspaDataCadastro(Date espaDataCadastro) {
        this.espaDataCadastro = espaDataCadastro;
    }

    public Integer getEspaCodigoGr() {
        return espaCodigoGr;
    }

    public void setEspaCodigoGr(Integer espaCodigoGr) {
        this.espaCodigoGr = espaCodigoGr;
    }

    public Character getEspaImportado() {
        return espaImportado;
    }

    public void setEspaImportado(Character espaImportado) {
        this.espaImportado = espaImportado;
    }

    public String getEspaPrioridade() {
        return espaPrioridade;
    }

    public void setEspaPrioridade(String espaPrioridade) {
        this.espaPrioridade = espaPrioridade;
    }

    public TvalTipoValor getTvalTipoValor() {
        return tvalTipoValor;
    }

    public void setTvalTipoValor(TvalTipoValor tvalTipoValor) {
        this.tvalTipoValor = tvalTipoValor;
    }

    public Collection<EsisEventoSistema> getEsisEventoSistemaCollection() {
        return esisEventoSistemaCollection;
    }

    public void setEsisEventoSistemaCollection(Collection<EsisEventoSistema> esisEventoSistemaCollection) {
        this.esisEventoSistemaCollection = esisEventoSistemaCollection;
    }

    public Collection<PitePgItem> getPitePgItemCollection() {
        return pitePgItemCollection;
    }

    public void setPitePgItemCollection(Collection<PitePgItem> pitePgItemCollection) {
        this.pitePgItemCollection = pitePgItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (espaCodigo != null ? espaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspaEventoSistemaPadrao)) {
            return false;
        }
        EspaEventoSistemaPadrao other = (EspaEventoSistemaPadrao) object;
        if ((this.espaCodigo == null && other.espaCodigo != null) || (this.espaCodigo != null && !this.espaCodigo.equals(other.espaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EspaEventoSistemaPadrao[espaCodigo=" + espaCodigo + "]";
    }

}
