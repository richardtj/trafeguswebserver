/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "esta_estatus")
@NamedQueries({
    @NamedQuery(name = "EstaEstatus.findAll", query = "SELECT e FROM EstaEstatus e")})
public class EstaEstatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "esta_codigo", nullable = false)
    private Integer estaCodigo;
    @Column(name = "esta_descricao", length = 50)
    private String estaDescricao;

    public EstaEstatus() {
    }

    public EstaEstatus(Integer estaCodigo) {
        this.estaCodigo = estaCodigo;
    }

    public Integer getEstaCodigo() {
        return estaCodigo;
    }

    public void setEstaCodigo(Integer estaCodigo) {
        this.estaCodigo = estaCodigo;
    }

    public String getEstaDescricao() {
        return estaDescricao;
    }

    public void setEstaDescricao(String estaDescricao) {
        this.estaDescricao = estaDescricao;
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
        if (!(object instanceof EstaEstatus)) {
            return false;
        }
        EstaEstatus other = (EstaEstatus) object;
        if ((this.estaCodigo == null && other.estaCodigo != null) || (this.estaCodigo != null && !this.estaCodigo.equals(other.estaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.EstaEstatus[estaCodigo=" + estaCodigo + "]";
    }

}
