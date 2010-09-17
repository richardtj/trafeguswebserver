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
@Table(name = "test_tipo_estabelecimento")
@NamedQueries({
    @NamedQuery(name = "TestTipoEstabelecimento.findAll", query = "SELECT t FROM TestTipoEstabelecimento t")})
public class TestTipoEstabelecimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "test_codigo", nullable = false)
    private Integer testCodigo;
    @Column(name = "test_descricao", length = 50)
    private String testDescricao;
    @OneToMany(mappedBy = "testTipoEstabelecimento")
    private Collection<TranTransportador> tranTransportadorCollection;
    @OneToMany(mappedBy = "testTipoEstabelecimento")
    private Collection<EmbaEmbarcador> embaEmbarcadorCollection;

    public TestTipoEstabelecimento() {
    }

    public TestTipoEstabelecimento(Integer testCodigo) {
        this.testCodigo = testCodigo;
    }

    public Integer getTestCodigo() {
        return testCodigo;
    }

    public void setTestCodigo(Integer testCodigo) {
        this.testCodigo = testCodigo;
    }

    public String getTestDescricao() {
        return testDescricao;
    }

    public void setTestDescricao(String testDescricao) {
        this.testDescricao = testDescricao;
    }

    public Collection<TranTransportador> getTranTransportadorCollection() {
        return tranTransportadorCollection;
    }

    public void setTranTransportadorCollection(Collection<TranTransportador> tranTransportadorCollection) {
        this.tranTransportadorCollection = tranTransportadorCollection;
    }

    public Collection<EmbaEmbarcador> getEmbaEmbarcadorCollection() {
        return embaEmbarcadorCollection;
    }

    public void setEmbaEmbarcadorCollection(Collection<EmbaEmbarcador> embaEmbarcadorCollection) {
        this.embaEmbarcadorCollection = embaEmbarcadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testCodigo != null ? testCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestTipoEstabelecimento)) {
            return false;
        }
        TestTipoEstabelecimento other = (TestTipoEstabelecimento) object;
        if ((this.testCodigo == null && other.testCodigo != null) || (this.testCodigo != null && !this.testCodigo.equals(other.testCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.TestTipoEstabelecimento[testCodigo=" + testCodigo + "]";
    }

}
