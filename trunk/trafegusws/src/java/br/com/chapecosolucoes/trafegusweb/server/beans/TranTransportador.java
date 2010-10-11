/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "TranTransportador.findAll", query = "SELECT t FROM TranTransportador t"),
    @NamedQuery(name = "TranTransportador.findByTranPessOrasCodigo", query = "SELECT t FROM TranTransportador t WHERE t.tranPessOrasCodigo = :tranPessOrasCodigo")})
public class TranTransportador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tran_pess_oras_codigo")
    private Integer tranPessOrasCodigo;
    @OneToMany(mappedBy = "tranTransportador", fetch = FetchType.EAGER)
    private List<TlocTransportadorLocal> tlocTransportadorLocalList;
    @OneToMany(mappedBy = "tranTransportador", fetch = FetchType.EAGER)
    private List<TspgTranspSegurPlanoGeren> tspgTranspSegurPlanoGerenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tranTransportador", fetch = FetchType.EAGER)
    private List<ViagViagem> viagViagemList;
    @OneToMany(mappedBy = "tranTransportador", fetch = FetchType.EAGER)
    private List<MtraMotoristaTransportador> mtraMotoristaTransportadorList;
    @OneToMany(mappedBy = "tranTransportador", fetch = FetchType.EAGER)
    private List<TembTransportadorEmbarcador> tembTransportadorEmbarcadorList;
    @OneToMany(mappedBy = "tranTransportador", fetch = FetchType.EAGER)
    private List<VtraVeiculoTransportador> vtraVeiculoTransportadorList;
    @OneToMany(mappedBy = "tranTransportador", fetch = FetchType.EAGER)
    private List<TranTransportador> tranTransportadorList;
    @JoinColumn(name = "tran_pess_oras_codigo_matriz", referencedColumnName = "tran_pess_oras_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TranTransportador tranTransportador;
    @JoinColumn(name = "tran_test_codigo", referencedColumnName = "test_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TestTipoEstabelecimento testTipoEstabelecimento;
    @JoinColumn(name = "tran_pess_oras_codigo", referencedColumnName = "pess_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
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

    public List<TlocTransportadorLocal> getTlocTransportadorLocalList() {
        return tlocTransportadorLocalList;
    }

    public void setTlocTransportadorLocalList(List<TlocTransportadorLocal> tlocTransportadorLocalList) {
        this.tlocTransportadorLocalList = tlocTransportadorLocalList;
    }

    public List<TspgTranspSegurPlanoGeren> getTspgTranspSegurPlanoGerenList() {
        return tspgTranspSegurPlanoGerenList;
    }

    public void setTspgTranspSegurPlanoGerenList(List<TspgTranspSegurPlanoGeren> tspgTranspSegurPlanoGerenList) {
        this.tspgTranspSegurPlanoGerenList = tspgTranspSegurPlanoGerenList;
    }

    public List<ViagViagem> getViagViagemList() {
        return viagViagemList;
    }

    public void setViagViagemList(List<ViagViagem> viagViagemList) {
        this.viagViagemList = viagViagemList;
    }

    public List<MtraMotoristaTransportador> getMtraMotoristaTransportadorList() {
        return mtraMotoristaTransportadorList;
    }

    public void setMtraMotoristaTransportadorList(List<MtraMotoristaTransportador> mtraMotoristaTransportadorList) {
        this.mtraMotoristaTransportadorList = mtraMotoristaTransportadorList;
    }

    public List<TembTransportadorEmbarcador> getTembTransportadorEmbarcadorList() {
        return tembTransportadorEmbarcadorList;
    }

    public void setTembTransportadorEmbarcadorList(List<TembTransportadorEmbarcador> tembTransportadorEmbarcadorList) {
        this.tembTransportadorEmbarcadorList = tembTransportadorEmbarcadorList;
    }

    public List<VtraVeiculoTransportador> getVtraVeiculoTransportadorList() {
        return vtraVeiculoTransportadorList;
    }

    public void setVtraVeiculoTransportadorList(List<VtraVeiculoTransportador> vtraVeiculoTransportadorList) {
        this.vtraVeiculoTransportadorList = vtraVeiculoTransportadorList;
    }

    public List<TranTransportador> getTranTransportadorList() {
        return tranTransportadorList;
    }

    public void setTranTransportadorList(List<TranTransportador> tranTransportadorList) {
        this.tranTransportadorList = tranTransportadorList;
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
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TranTransportador[tranPessOrasCodigo=" + tranPessOrasCodigo + "]";
    }

}
