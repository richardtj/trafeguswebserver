/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "emba_embarcador", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EmbaEmbarcador.findAll", query = "SELECT e FROM EmbaEmbarcador e"),
    @NamedQuery(name = "EmbaEmbarcador.findByEmbaPjurPessOrasCodigo", query = "SELECT e FROM EmbaEmbarcador e WHERE e.embaPjurPessOrasCodigo = :embaPjurPessOrasCodigo")})
public class EmbaEmbarcador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emba_pjur_pess_oras_codigo", nullable = false)
    private Integer embaPjurPessOrasCodigo;
    @OneToMany(mappedBy = "embaEmbarcador")
    private List<ViagViagem> viagViagemList;
    @JoinColumn(name = "emba_test_codigo", referencedColumnName = "test_codigo")
    @ManyToOne
    private TestTipoEstabelecimento testTipoEstabelecimento;
    @JoinColumn(name = "emba_pjur_pess_oras_codigo", referencedColumnName = "pjur_pess_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PjurPessoaJuridica pjurPessoaJuridica;
    @OneToMany(mappedBy = "embaEmbarcador")
    private List<EmbaEmbarcador> embaEmbarcadorList;
    @JoinColumn(name = "emba_pjur_pess_oras_codigo_matriz", referencedColumnName = "emba_pjur_pess_oras_codigo")
    @ManyToOne
    private EmbaEmbarcador embaEmbarcador;

    public EmbaEmbarcador() {
    }

    public EmbaEmbarcador(Integer embaPjurPessOrasCodigo) {
        this.embaPjurPessOrasCodigo = embaPjurPessOrasCodigo;
    }

    public Integer getEmbaPjurPessOrasCodigo() {
        return embaPjurPessOrasCodigo;
    }

    public void setEmbaPjurPessOrasCodigo(Integer embaPjurPessOrasCodigo) {
        this.embaPjurPessOrasCodigo = embaPjurPessOrasCodigo;
    }

    public List<ViagViagem> getViagViagemList() {
        return viagViagemList;
    }

    public void setViagViagemList(List<ViagViagem> viagViagemList) {
        this.viagViagemList = viagViagemList;
    }

    public TestTipoEstabelecimento getTestTipoEstabelecimento() {
        return testTipoEstabelecimento;
    }

    public void setTestTipoEstabelecimento(TestTipoEstabelecimento testTipoEstabelecimento) {
        this.testTipoEstabelecimento = testTipoEstabelecimento;
    }

    public PjurPessoaJuridica getPjurPessoaJuridica() {
        return pjurPessoaJuridica;
    }

    public void setPjurPessoaJuridica(PjurPessoaJuridica pjurPessoaJuridica) {
        this.pjurPessoaJuridica = pjurPessoaJuridica;
    }

    public List<EmbaEmbarcador> getEmbaEmbarcadorList() {
        return embaEmbarcadorList;
    }

    public void setEmbaEmbarcadorList(List<EmbaEmbarcador> embaEmbarcadorList) {
        this.embaEmbarcadorList = embaEmbarcadorList;
    }

    public EmbaEmbarcador getEmbaEmbarcador() {
        return embaEmbarcador;
    }

    public void setEmbaEmbarcador(EmbaEmbarcador embaEmbarcador) {
        this.embaEmbarcador = embaEmbarcador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (embaPjurPessOrasCodigo != null ? embaPjurPessOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmbaEmbarcador)) {
            return false;
        }
        EmbaEmbarcador other = (EmbaEmbarcador) object;
        if ((this.embaPjurPessOrasCodigo == null && other.embaPjurPessOrasCodigo != null) || (this.embaPjurPessOrasCodigo != null && !this.embaPjurPessOrasCodigo.equals(other.embaPjurPessOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.EmbaEmbarcador[embaPjurPessOrasCodigo=" + embaPjurPessOrasCodigo + "]";
    }

}
