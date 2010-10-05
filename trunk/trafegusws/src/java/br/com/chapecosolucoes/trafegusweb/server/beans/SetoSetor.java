/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
 * @author emerson
 */
@Entity
@Table(name = "seto_setor")
@NamedQueries({
    @NamedQuery(name = "SetoSetor.findAll", query = "SELECT s FROM SetoSetor s")})
public class SetoSetor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "seto_codigo")
    private Integer setoCodigo;
    @Column(name = "seto_descricao")
    private String setoDescricao;
    @Column(name = "seto_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date setoDataCadastro;
    @Column(name = "seto_codigo_gr")
    private Integer setoCodigoGr;
    @Column(name = "seto_importado")
    private Character setoImportado;
    @OneToMany(mappedBy = "setoSetor")
    private Set<UsuaUsuario> usuaUsuarioSet;

    public SetoSetor() {
    }

    public SetoSetor(Integer setoCodigo) {
        this.setoCodigo = setoCodigo;
    }

    public Integer getSetoCodigo() {
        return setoCodigo;
    }

    public void setSetoCodigo(Integer setoCodigo) {
        this.setoCodigo = setoCodigo;
    }

    public String getSetoDescricao() {
        return setoDescricao;
    }

    public void setSetoDescricao(String setoDescricao) {
        this.setoDescricao = setoDescricao;
    }

    public Date getSetoDataCadastro() {
        return setoDataCadastro;
    }

    public void setSetoDataCadastro(Date setoDataCadastro) {
        this.setoDataCadastro = setoDataCadastro;
    }

    public Integer getSetoCodigoGr() {
        return setoCodigoGr;
    }

    public void setSetoCodigoGr(Integer setoCodigoGr) {
        this.setoCodigoGr = setoCodigoGr;
    }

    public Character getSetoImportado() {
        return setoImportado;
    }

    public void setSetoImportado(Character setoImportado) {
        this.setoImportado = setoImportado;
    }

    public Set<UsuaUsuario> getUsuaUsuarioSet() {
        return usuaUsuarioSet;
    }

    public void setUsuaUsuarioSet(Set<UsuaUsuario> usuaUsuarioSet) {
        this.usuaUsuarioSet = usuaUsuarioSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (setoCodigo != null ? setoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SetoSetor)) {
            return false;
        }
        SetoSetor other = (SetoSetor) object;
        if ((this.setoCodigo == null && other.setoCodigo != null) || (this.setoCodigo != null && !this.setoCodigo.equals(other.setoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.SetoSetor[setoCodigo=" + setoCodigo + "]";
    }

}
