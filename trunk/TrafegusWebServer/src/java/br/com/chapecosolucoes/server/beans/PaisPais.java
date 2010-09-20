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
@Table(name = "pais_pais", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "PaisPais.findAll", query = "SELECT p FROM PaisPais p"),
    @NamedQuery(name = "PaisPais.findByPaisCodigo", query = "SELECT p FROM PaisPais p WHERE p.paisCodigo = :paisCodigo"),
    @NamedQuery(name = "PaisPais.findByPaisDescricao", query = "SELECT p FROM PaisPais p WHERE p.paisDescricao = :paisDescricao"),
    @NamedQuery(name = "PaisPais.findByPaisDataCadastro", query = "SELECT p FROM PaisPais p WHERE p.paisDataCadastro = :paisDataCadastro"),
    @NamedQuery(name = "PaisPais.findByPaisCodigoGr", query = "SELECT p FROM PaisPais p WHERE p.paisCodigoGr = :paisCodigoGr"),
    @NamedQuery(name = "PaisPais.findByPaisImportado", query = "SELECT p FROM PaisPais p WHERE p.paisImportado = :paisImportado")})
public class PaisPais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pais_codigo", nullable = false)
    private Integer paisCodigo;
    @Column(name = "pais_descricao", length = 50)
    private String paisDescricao;
    @Column(name = "pais_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paisDataCadastro;
    @Column(name = "pais_codigo_gr")
    private Integer paisCodigoGr;
    @Column(name = "pais_importado")
    private Character paisImportado;
    @OneToMany(mappedBy = "paisPais")
    private List<EstaEstado> estaEstadoList;

    public PaisPais() {
    }

    public PaisPais(Integer paisCodigo) {
        this.paisCodigo = paisCodigo;
    }

    public Integer getPaisCodigo() {
        return paisCodigo;
    }

    public void setPaisCodigo(Integer paisCodigo) {
        this.paisCodigo = paisCodigo;
    }

    public String getPaisDescricao() {
        return paisDescricao;
    }

    public void setPaisDescricao(String paisDescricao) {
        this.paisDescricao = paisDescricao;
    }

    public Date getPaisDataCadastro() {
        return paisDataCadastro;
    }

    public void setPaisDataCadastro(Date paisDataCadastro) {
        this.paisDataCadastro = paisDataCadastro;
    }

    public Integer getPaisCodigoGr() {
        return paisCodigoGr;
    }

    public void setPaisCodigoGr(Integer paisCodigoGr) {
        this.paisCodigoGr = paisCodigoGr;
    }

    public Character getPaisImportado() {
        return paisImportado;
    }

    public void setPaisImportado(Character paisImportado) {
        this.paisImportado = paisImportado;
    }

    public List<EstaEstado> getEstaEstadoList() {
        return estaEstadoList;
    }

    public void setEstaEstadoList(List<EstaEstado> estaEstadoList) {
        this.estaEstadoList = estaEstadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisCodigo != null ? paisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaisPais)) {
            return false;
        }
        PaisPais other = (PaisPais) object;
        if ((this.paisCodigo == null && other.paisCodigo != null) || (this.paisCodigo != null && !this.paisCodigo.equals(other.paisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PaisPais[paisCodigo=" + paisCodigo + "]";
    }

}
