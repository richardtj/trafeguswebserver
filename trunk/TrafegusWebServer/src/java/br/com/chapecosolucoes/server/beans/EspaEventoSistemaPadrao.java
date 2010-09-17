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
@Table(name = "espa_evento_sistema_padrao")
@NamedQueries({
    @NamedQuery(name = "EspaEventoSistemaPadrao.findAll", query = "SELECT e FROM EspaEventoSistemaPadrao e")})
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
    @OneToMany(mappedBy = "espaEventoSistemaPadrao")
    private Collection<EsisEventoSistema> esisEventoSistemaCollection;
    @OneToMany(mappedBy = "espaEventoSistemaPadrao")
    private Collection<PitePgItem> pitePgItemCollection;
    @JoinColumn(name = "espa_tval_codigo", referencedColumnName = "tval_codigo")
    @ManyToOne
    private TvalTipoValor tvalTipoValor;

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

    public TvalTipoValor getTvalTipoValor() {
        return tvalTipoValor;
    }

    public void setTvalTipoValor(TvalTipoValor tvalTipoValor) {
        this.tvalTipoValor = tvalTipoValor;
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
        return "br.com.chapecosolucoes.server.beans.EspaEventoSistemaPadrao[espaCodigo=" + espaCodigo + "]";
    }

}
