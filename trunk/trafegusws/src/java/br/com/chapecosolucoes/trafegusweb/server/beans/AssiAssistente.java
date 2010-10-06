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
import javax.persistence.FetchType;
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
@Table(name = "assi_assistente")
@NamedQueries({
    @NamedQuery(name = "AssiAssistente.findAll", query = "SELECT a FROM AssiAssistente a"),
    @NamedQuery(name = "AssiAssistente.findByAssiCodigo", query = "SELECT a FROM AssiAssistente a WHERE a.assiCodigo = :assiCodigo"),
    @NamedQuery(name = "AssiAssistente.findByAssiDescricao", query = "SELECT a FROM AssiAssistente a WHERE a.assiDescricao = :assiDescricao"),
    @NamedQuery(name = "AssiAssistente.findByAssiDono", query = "SELECT a FROM AssiAssistente a WHERE a.assiDono = :assiDono"),
    @NamedQuery(name = "AssiAssistente.findByAssiDataCadastro", query = "SELECT a FROM AssiAssistente a WHERE a.assiDataCadastro = :assiDataCadastro"),
    @NamedQuery(name = "AssiAssistente.findByAssiCodigoGr", query = "SELECT a FROM AssiAssistente a WHERE a.assiCodigoGr = :assiCodigoGr"),
    @NamedQuery(name = "AssiAssistente.findByAssiImportado", query = "SELECT a FROM AssiAssistente a WHERE a.assiImportado = :assiImportado")})
public class AssiAssistente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "assi_codigo")
    private Integer assiCodigo;
    @Column(name = "assi_descricao")
    private String assiDescricao;
    @Column(name = "assi_dono")
    private String assiDono;
    @Column(name = "assi_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assiDataCadastro;
    @Column(name = "assi_codigo_gr")
    private Integer assiCodigoGr;
    @Column(name = "assi_importado")
    private Character assiImportado;
    @OneToMany(mappedBy = "assiAssistente", fetch = FetchType.LAZY)
    private Collection<AssdAssistenteDetalhe> assdAssistenteDetalheCollection;

    public AssiAssistente() {
    }

    public AssiAssistente(Integer assiCodigo) {
        this.assiCodigo = assiCodigo;
    }

    public Integer getAssiCodigo() {
        return assiCodigo;
    }

    public void setAssiCodigo(Integer assiCodigo) {
        this.assiCodigo = assiCodigo;
    }

    public String getAssiDescricao() {
        return assiDescricao;
    }

    public void setAssiDescricao(String assiDescricao) {
        this.assiDescricao = assiDescricao;
    }

    public String getAssiDono() {
        return assiDono;
    }

    public void setAssiDono(String assiDono) {
        this.assiDono = assiDono;
    }

    public Date getAssiDataCadastro() {
        return assiDataCadastro;
    }

    public void setAssiDataCadastro(Date assiDataCadastro) {
        this.assiDataCadastro = assiDataCadastro;
    }

    public Integer getAssiCodigoGr() {
        return assiCodigoGr;
    }

    public void setAssiCodigoGr(Integer assiCodigoGr) {
        this.assiCodigoGr = assiCodigoGr;
    }

    public Character getAssiImportado() {
        return assiImportado;
    }

    public void setAssiImportado(Character assiImportado) {
        this.assiImportado = assiImportado;
    }

    public Collection<AssdAssistenteDetalhe> getAssdAssistenteDetalheCollection() {
        return assdAssistenteDetalheCollection;
    }

    public void setAssdAssistenteDetalheCollection(Collection<AssdAssistenteDetalhe> assdAssistenteDetalheCollection) {
        this.assdAssistenteDetalheCollection = assdAssistenteDetalheCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assiCodigo != null ? assiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssiAssistente)) {
            return false;
        }
        AssiAssistente other = (AssiAssistente) object;
        if ((this.assiCodigo == null && other.assiCodigo != null) || (this.assiCodigo != null && !this.assiCodigo.equals(other.assiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.AssiAssistente[assiCodigo=" + assiCodigo + "]";
    }

}
