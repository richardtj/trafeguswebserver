/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tran_transportador")
@NamedQueries({
    @NamedQuery(name = "TranTransportador.findAll", query = "SELECT t FROM TranTransportador t")})
public class TranTransportador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tran_pess_oras_codigo", nullable = false)
    private Integer tranPessOrasCodigo;
    @OneToMany(mappedBy = "tranTransportador")
    private Collection<TlocTransportadorLocal> tlocTransportadorLocalCollection;
    @OneToMany(mappedBy = "tranTransportador")
    private Collection<TembTransportadorEmbarcador> tembTransportadorEmbarcadorCollection;
    @OneToMany(mappedBy = "tranTransportador")
    private Collection<TspgTranspSegurPlanoGeren> tspgTranspSegurPlanoGerenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tranTransportador")
    private Collection<ViagViagem> viagViagemCollection;
    @OneToMany(mappedBy = "tranTransportador")
    private Collection<MtraMotoristaTransportador> mtraMotoristaTransportadorCollection;
    @OneToMany(mappedBy = "tranTransportador")
    private Collection<VtraVeiculoTransportador> vtraVeiculoTransportadorCollection;
    @OneToMany(mappedBy = "tranTransportador")
    private Collection<TranTransportador> tranTransportadorCollection;
    @JoinColumn(name = "tran_pess_oras_codigo_matriz", referencedColumnName = "tran_pess_oras_codigo")
    @ManyToOne
    private TranTransportador tranTransportador;
    @JoinColumn(name = "tran_test_codigo", referencedColumnName = "test_codigo")
    @ManyToOne
    private TestTipoEstabelecimento testTipoEstabelecimento;
    @JoinColumn(name = "tran_pess_oras_codigo", referencedColumnName = "pess_oras_codigo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PessPessoa pessPessoa;

    public TranTransportador() {
    }

    public TranTransportador(Integer tranPessOrasCodigo) {
        this.tranPessOrasCodigo = tranPessOrasCodigo;
    }

    public Integer getTranPessOrasCodigo() {
        return tranPessOrasCodigo;
    }

    public void setTranPessOrasCodigo(Integer tranPessOrasCodigo) {
        this.tranPessOrasCodigo = tranPessOrasCodigo;
    }

    public Collection<TlocTransportadorLocal> getTlocTransportadorLocalCollection() {
        return tlocTransportadorLocalCollection;
    }

    public void setTlocTransportadorLocalCollection(Collection<TlocTransportadorLocal> tlocTransportadorLocalCollection) {
        this.tlocTransportadorLocalCollection = tlocTransportadorLocalCollection;
    }

    public Collection<TembTransportadorEmbarcador> getTembTransportadorEmbarcadorCollection() {
        return tembTransportadorEmbarcadorCollection;
    }

    public void setTembTransportadorEmbarcadorCollection(Collection<TembTransportadorEmbarcador> tembTransportadorEmbarcadorCollection) {
        this.tembTransportadorEmbarcadorCollection = tembTransportadorEmbarcadorCollection;
    }

    public Collection<TspgTranspSegurPlanoGeren> getTspgTranspSegurPlanoGerenCollection() {
        return tspgTranspSegurPlanoGerenCollection;
    }

    public void setTspgTranspSegurPlanoGerenCollection(Collection<TspgTranspSegurPlanoGeren> tspgTranspSegurPlanoGerenCollection) {
        this.tspgTranspSegurPlanoGerenCollection = tspgTranspSegurPlanoGerenCollection;
    }

    public Collection<ViagViagem> getViagViagemCollection() {
        return viagViagemCollection;
    }

    public void setViagViagemCollection(Collection<ViagViagem> viagViagemCollection) {
        this.viagViagemCollection = viagViagemCollection;
    }

    public Collection<MtraMotoristaTransportador> getMtraMotoristaTransportadorCollection() {
        return mtraMotoristaTransportadorCollection;
    }

    public void setMtraMotoristaTransportadorCollection(Collection<MtraMotoristaTransportador> mtraMotoristaTransportadorCollection) {
        this.mtraMotoristaTransportadorCollection = mtraMotoristaTransportadorCollection;
    }

    public Collection<VtraVeiculoTransportador> getVtraVeiculoTransportadorCollection() {
        return vtraVeiculoTransportadorCollection;
    }

    public void setVtraVeiculoTransportadorCollection(Collection<VtraVeiculoTransportador> vtraVeiculoTransportadorCollection) {
        this.vtraVeiculoTransportadorCollection = vtraVeiculoTransportadorCollection;
    }

    public Collection<TranTransportador> getTranTransportadorCollection() {
        return tranTransportadorCollection;
    }

    public void setTranTransportadorCollection(Collection<TranTransportador> tranTransportadorCollection) {
        this.tranTransportadorCollection = tranTransportadorCollection;
    }

    public TranTransportador getTranTransportador() {
        return tranTransportador;
    }

    public void setTranTransportador(TranTransportador tranTransportador) {
        this.tranTransportador = tranTransportador;
    }

    public TestTipoEstabelecimento getTestTipoEstabelecimento() {
        return testTipoEstabelecimento;
    }

    public void setTestTipoEstabelecimento(TestTipoEstabelecimento testTipoEstabelecimento) {
        this.testTipoEstabelecimento = testTipoEstabelecimento;
    }

    public PessPessoa getPessPessoa() {
        return pessPessoa;
    }

    public void setPessPessoa(PessPessoa pessPessoa) {
        this.pessPessoa = pessPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tranPessOrasCodigo != null ? tranPessOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TranTransportador)) {
            return false;
        }
        TranTransportador other = (TranTransportador) object;
        if ((this.tranPessOrasCodigo == null && other.tranPessOrasCodigo != null) || (this.tranPessOrasCodigo != null && !this.tranPessOrasCodigo.equals(other.tranPessOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.TranTransportador[tranPessOrasCodigo=" + tranPessOrasCodigo + "]";
    }

}
