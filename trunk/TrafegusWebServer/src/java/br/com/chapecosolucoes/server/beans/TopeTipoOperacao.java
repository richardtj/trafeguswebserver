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
import javax.persistence.Id;
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
@Table(name = "tope_tipo_operacao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TopeTipoOperacao.findAll", query = "SELECT t FROM TopeTipoOperacao t"),
    @NamedQuery(name = "TopeTipoOperacao.findByTopeCodigo", query = "SELECT t FROM TopeTipoOperacao t WHERE t.topeCodigo = :topeCodigo"),
    @NamedQuery(name = "TopeTipoOperacao.findByTopeDescricao", query = "SELECT t FROM TopeTipoOperacao t WHERE t.topeDescricao = :topeDescricao"),
    @NamedQuery(name = "TopeTipoOperacao.findByTopeDataCadastro", query = "SELECT t FROM TopeTipoOperacao t WHERE t.topeDataCadastro = :topeDataCadastro"),
    @NamedQuery(name = "TopeTipoOperacao.findByTopeCodigoGr", query = "SELECT t FROM TopeTipoOperacao t WHERE t.topeCodigoGr = :topeCodigoGr"),
    @NamedQuery(name = "TopeTipoOperacao.findByTopeImportado", query = "SELECT t FROM TopeTipoOperacao t WHERE t.topeImportado = :topeImportado")})
public class TopeTipoOperacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tope_codigo", nullable = false)
    private Integer topeCodigo;
    @Column(name = "tope_descricao", length = 50)
    private String topeDescricao;
    @Column(name = "tope_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date topeDataCadastro;
    @Column(name = "tope_codigo_gr")
    private Integer topeCodigoGr;
    @Column(name = "tope_importado")
    private Character topeImportado;
    @OneToMany(mappedBy = "topeTipoOperacao")
    private List<ViagViagem> viagViagemList;

    public TopeTipoOperacao() {
    }

    public TopeTipoOperacao(Integer topeCodigo) {
        this.topeCodigo = topeCodigo;
    }

    public Integer getTopeCodigo() {
        return topeCodigo;
    }

    public void setTopeCodigo(Integer topeCodigo) {
        this.topeCodigo = topeCodigo;
    }

    public String getTopeDescricao() {
        return topeDescricao;
    }

    public void setTopeDescricao(String topeDescricao) {
        this.topeDescricao = topeDescricao;
    }

    public Date getTopeDataCadastro() {
        return topeDataCadastro;
    }

    public void setTopeDataCadastro(Date topeDataCadastro) {
        this.topeDataCadastro = topeDataCadastro;
    }

    public Integer getTopeCodigoGr() {
        return topeCodigoGr;
    }

    public void setTopeCodigoGr(Integer topeCodigoGr) {
        this.topeCodigoGr = topeCodigoGr;
    }

    public Character getTopeImportado() {
        return topeImportado;
    }

    public void setTopeImportado(Character topeImportado) {
        this.topeImportado = topeImportado;
    }

    public List<ViagViagem> getViagViagemList() {
        return viagViagemList;
    }

    public void setViagViagemList(List<ViagViagem> viagViagemList) {
        this.viagViagemList = viagViagemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (topeCodigo != null ? topeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TopeTipoOperacao)) {
            return false;
        }
        TopeTipoOperacao other = (TopeTipoOperacao) object;
        if ((this.topeCodigo == null && other.topeCodigo != null) || (this.topeCodigo != null && !this.topeCodigo.equals(other.topeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.TopeTipoOperacao[topeCodigo=" + topeCodigo + "]";
    }

}
