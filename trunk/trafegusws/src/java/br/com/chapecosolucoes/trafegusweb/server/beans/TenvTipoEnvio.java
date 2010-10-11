/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "tenv_tipo_envio")
@NamedQueries({
    @NamedQuery(name = "TenvTipoEnvio.findAll", query = "SELECT t FROM TenvTipoEnvio t"),
    @NamedQuery(name = "TenvTipoEnvio.findByTenvCodigo", query = "SELECT t FROM TenvTipoEnvio t WHERE t.tenvCodigo = :tenvCodigo"),
    @NamedQuery(name = "TenvTipoEnvio.findByTenvDescricao", query = "SELECT t FROM TenvTipoEnvio t WHERE t.tenvDescricao = :tenvDescricao")})
public class TenvTipoEnvio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tenv_codigo")
    private Integer tenvCodigo;
    @Column(name = "tenv_descricao")
    private String tenvDescricao;
    @OneToMany(mappedBy = "tenvTipoEnvio", fetch = FetchType.EAGER)
    private List<LemcListaEnvioMsgContato> lemcListaEnvioMsgContatoList;

    public TenvTipoEnvio() {
    }

    public TenvTipoEnvio(Integer tenvCodigo) {
        this.tenvCodigo = tenvCodigo;
    }

    public Integer getTenvCodigo() {
        return tenvCodigo;
    }

    public void setTenvCodigo(Integer tenvCodigo) {
        this.tenvCodigo = tenvCodigo;
    }

    public String getTenvDescricao() {
        return tenvDescricao;
    }

    public void setTenvDescricao(String tenvDescricao) {
        this.tenvDescricao = tenvDescricao;
    }

    public List<LemcListaEnvioMsgContato> getLemcListaEnvioMsgContatoList() {
        return lemcListaEnvioMsgContatoList;
    }

    public void setLemcListaEnvioMsgContatoList(List<LemcListaEnvioMsgContato> lemcListaEnvioMsgContatoList) {
        this.lemcListaEnvioMsgContatoList = lemcListaEnvioMsgContatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tenvCodigo != null ? tenvCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TenvTipoEnvio)) {
            return false;
        }
        TenvTipoEnvio other = (TenvTipoEnvio) object;
        if ((this.tenvCodigo == null && other.tenvCodigo != null) || (this.tenvCodigo != null && !this.tenvCodigo.equals(other.tenvCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TenvTipoEnvio[tenvCodigo=" + tenvCodigo + "]";
    }

}
