/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
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
    private Collection<ViagViagem> viagViagemCollection;
    @OneToMany(mappedBy = "embaEmbarcador")
    private Collection<TembTransportadorEmbarcador> tembTransportadorEmbarcadorCollection;
    @OneToMany(mappedBy = "embaEmbarcador")
    private Collection<VembVeiculoEmbarcador> vembVeiculoEmbarcadorCollection;
    @OneToMany(mappedBy = "embaEmbarcador")
    private Collection<EspgEmbarcSegurPlanoGeren> espgEmbarcSegurPlanoGerenCollection;
    @OneToMany(mappedBy = "embaEmbarcador")
    private Collection<ElocEmbarcadorLocal> elocEmbarcadorLocalCollection;
    @JoinColumn(name = "emba_test_codigo", referencedColumnName = "test_codigo")
    @ManyToOne
    private TestTipoEstabelecimento testTipoEstabelecimento;
    @JoinColumn(name = "emba_pjur_pess_oras_codigo", referencedColumnName = "pjur_pess_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PjurPessoaJuridica pjurPessoaJuridica;
    @OneToMany(mappedBy = "embaEmbarcador")
    private Collection<EmbaEmbarcador> embaEmbarcadorCollection;
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

    public Collection<ViagViagem> getViagViagemCollection() {
        return viagViagemCollection;
    }

    public void setViagViagemCollection(Collection<ViagViagem> viagViagemCollection) {
        this.viagViagemCollection = viagViagemCollection;
    }

    public Collection<TembTransportadorEmbarcador> getTembTransportadorEmbarcadorCollection() {
        return tembTransportadorEmbarcadorCollection;
    }

    public void setTembTransportadorEmbarcadorCollection(Collection<TembTransportadorEmbarcador> tembTransportadorEmbarcadorCollection) {
        this.tembTransportadorEmbarcadorCollection = tembTransportadorEmbarcadorCollection;
    }

    public Collection<VembVeiculoEmbarcador> getVembVeiculoEmbarcadorCollection() {
        return vembVeiculoEmbarcadorCollection;
    }

    public void setVembVeiculoEmbarcadorCollection(Collection<VembVeiculoEmbarcador> vembVeiculoEmbarcadorCollection) {
        this.vembVeiculoEmbarcadorCollection = vembVeiculoEmbarcadorCollection;
    }

    public Collection<EspgEmbarcSegurPlanoGeren> getEspgEmbarcSegurPlanoGerenCollection() {
        return espgEmbarcSegurPlanoGerenCollection;
    }

    public void setEspgEmbarcSegurPlanoGerenCollection(Collection<EspgEmbarcSegurPlanoGeren> espgEmbarcSegurPlanoGerenCollection) {
        this.espgEmbarcSegurPlanoGerenCollection = espgEmbarcSegurPlanoGerenCollection;
    }

    public Collection<ElocEmbarcadorLocal> getElocEmbarcadorLocalCollection() {
        return elocEmbarcadorLocalCollection;
    }

    public void setElocEmbarcadorLocalCollection(Collection<ElocEmbarcadorLocal> elocEmbarcadorLocalCollection) {
        this.elocEmbarcadorLocalCollection = elocEmbarcadorLocalCollection;
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

    public Collection<EmbaEmbarcador> getEmbaEmbarcadorCollection() {
        return embaEmbarcadorCollection;
    }

    public void setEmbaEmbarcadorCollection(Collection<EmbaEmbarcador> embaEmbarcadorCollection) {
        this.embaEmbarcadorCollection = embaEmbarcadorCollection;
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
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EmbaEmbarcador[embaPjurPessOrasCodigo=" + embaPjurPessOrasCodigo + "]";
    }

}
