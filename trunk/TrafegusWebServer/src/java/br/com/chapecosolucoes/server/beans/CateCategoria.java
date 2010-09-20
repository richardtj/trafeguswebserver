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
@Table(name = "cate_categoria", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CateCategoria.findAll", query = "SELECT c FROM CateCategoria c"),
    @NamedQuery(name = "CateCategoria.findByCateCodigo", query = "SELECT c FROM CateCategoria c WHERE c.cateCodigo = :cateCodigo"),
    @NamedQuery(name = "CateCategoria.findByCateDescricao", query = "SELECT c FROM CateCategoria c WHERE c.cateDescricao = :cateDescricao")})
public class CateCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cate_codigo", nullable = false)
    private Integer cateCodigo;
    @Column(name = "cate_descricao", length = 50)
    private String cateDescricao;

    public CateCategoria() {
    }

    public CateCategoria(Integer cateCodigo) {
        this.cateCodigo = cateCodigo;
    }

    public Integer getCateCodigo() {
        return cateCodigo;
    }

    public void setCateCodigo(Integer cateCodigo) {
        this.cateCodigo = cateCodigo;
    }

    public String getCateDescricao() {
        return cateDescricao;
    }

    public void setCateDescricao(String cateDescricao) {
        this.cateDescricao = cateDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cateCodigo != null ? cateCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CateCategoria)) {
            return false;
        }
        CateCategoria other = (CateCategoria) object;
        if ((this.cateCodigo == null && other.cateCodigo != null) || (this.cateCodigo != null && !this.cateCodigo.equals(other.cateCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.CateCategoria[cateCodigo=" + cateCodigo + "]";
    }

}
