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
@Table(name = "esta_estado", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EstaEstado.findAll", query = "SELECT e FROM EstaEstado e"),
    @NamedQuery(name = "EstaEstado.findByEstaCodigo", query = "SELECT e FROM EstaEstado e WHERE e.estaCodigo = :estaCodigo"),
    @NamedQuery(name = "EstaEstado.findByEstaSigla", query = "SELECT e FROM EstaEstado e WHERE e.estaSigla = :estaSigla"),
    @NamedQuery(name = "EstaEstado.findByEstaDescricao", query = "SELECT e FROM EstaEstado e WHERE e.estaDescricao = :estaDescricao"),
    @NamedQuery(name = "EstaEstado.findByEstaDataCadastro", query = "SELECT e FROM EstaEstado e WHERE e.estaDataCadastro = :estaDataCadastro"),
    @NamedQuery(name = "EstaEstado.findByEstaCodigoGr", query = "SELECT e FROM EstaEstado e WHERE e.estaCodigoGr = :estaCodigoGr"),
    @NamedQuery(name = "EstaEstado.findByEstaImportado", query = "SELECT e FROM EstaEstado e WHERE e.estaImportado = :estaImportado")})
public class EstaEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "esta_codigo", nullable = false)
    private Integer estaCodigo;
    @Column(name = "esta_sigla", length = 2)
    private String estaSigla;
    @Column(name = "esta_descricao", length = 100)
    private String estaDescricao;
    @Column(name = "esta_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estaDataCadastro;
    @Column(name = "esta_codigo_gr")
    private Integer estaCodigoGr;
    @Column(name = "esta_importado")
    private Character estaImportado;
    @OneToMany(mappedBy = "estaEstado")
    private Collection<CidaCidade> cidaCidadeCollection;
    @JoinColumn(name = "esta_pais_codigo", referencedColumnName = "pais_codigo")
    @ManyToOne
    private PaisPais paisPais;

    public EstaEstado() {
    }

    public EstaEstado(Integer estaCodigo) {
        this.estaCodigo = estaCodigo;
    }

    public Integer getEstaCodigo() {
        return estaCodigo;
    }

    public void setEstaCodigo(Integer estaCodigo) {
        this.estaCodigo = estaCodigo;
    }

    public String getEstaSigla() {
        return estaSigla;
    }

    public void setEstaSigla(String estaSigla) {
        this.estaSigla = estaSigla;
    }

    public String getEstaDescricao() {
        return estaDescricao;
    }

    public void setEstaDescricao(String estaDescricao) {
        this.estaDescricao = estaDescricao;
    }

    public Date getEstaDataCadastro() {
        return estaDataCadastro;
    }

    public void setEstaDataCadastro(Date estaDataCadastro) {
        this.estaDataCadastro = estaDataCadastro;
    }

    public Integer getEstaCodigoGr() {
        return estaCodigoGr;
    }

    public void setEstaCodigoGr(Integer estaCodigoGr) {
        this.estaCodigoGr = estaCodigoGr;
    }

    public Character getEstaImportado() {
        return estaImportado;
    }

    public void setEstaImportado(Character estaImportado) {
        this.estaImportado = estaImportado;
    }

    public Collection<CidaCidade> getCidaCidadeCollection() {
        return cidaCidadeCollection;
    }

    public void setCidaCidadeCollection(Collection<CidaCidade> cidaCidadeCollection) {
        this.cidaCidadeCollection = cidaCidadeCollection;
    }

    public PaisPais getPaisPais() {
        return paisPais;
    }

    public void setPaisPais(PaisPais paisPais) {
        this.paisPais = paisPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estaCodigo != null ? estaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstaEstado)) {
            return false;
        }
        EstaEstado other = (EstaEstado) object;
        if ((this.estaCodigo == null && other.estaCodigo != null) || (this.estaCodigo != null && !this.estaCodigo.equals(other.estaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EstaEstado[estaCodigo=" + estaCodigo + "]";
    }

}
