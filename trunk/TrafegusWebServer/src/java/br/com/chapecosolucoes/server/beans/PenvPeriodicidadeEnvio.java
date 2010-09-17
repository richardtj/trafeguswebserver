/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "penv_periodicidade_envio")
@NamedQueries({
    @NamedQuery(name = "PenvPeriodicidadeEnvio.findAll", query = "SELECT p FROM PenvPeriodicidadeEnvio p")})
public class PenvPeriodicidadeEnvio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "penv_codigo", nullable = false)
    private Integer penvCodigo;
    @Column(name = "penv_descricao", length = 50)
    private String penvDescricao;
    @OneToMany(mappedBy = "penvPeriodicidadeEnvio")
    private Collection<SemeServicoEnvioMensagem> semeServicoEnvioMensagemCollection;

    public PenvPeriodicidadeEnvio() {
    }

    public PenvPeriodicidadeEnvio(Integer penvCodigo) {
        this.penvCodigo = penvCodigo;
    }

    public Integer getPenvCodigo() {
        return penvCodigo;
    }

    public void setPenvCodigo(Integer penvCodigo) {
        this.penvCodigo = penvCodigo;
    }

    public String getPenvDescricao() {
        return penvDescricao;
    }

    public void setPenvDescricao(String penvDescricao) {
        this.penvDescricao = penvDescricao;
    }

    public Collection<SemeServicoEnvioMensagem> getSemeServicoEnvioMensagemCollection() {
        return semeServicoEnvioMensagemCollection;
    }

    public void setSemeServicoEnvioMensagemCollection(Collection<SemeServicoEnvioMensagem> semeServicoEnvioMensagemCollection) {
        this.semeServicoEnvioMensagemCollection = semeServicoEnvioMensagemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (penvCodigo != null ? penvCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PenvPeriodicidadeEnvio)) {
            return false;
        }
        PenvPeriodicidadeEnvio other = (PenvPeriodicidadeEnvio) object;
        if ((this.penvCodigo == null && other.penvCodigo != null) || (this.penvCodigo != null && !this.penvCodigo.equals(other.penvCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.PenvPeriodicidadeEnvio[penvCodigo=" + penvCodigo + "]";
    }

}
