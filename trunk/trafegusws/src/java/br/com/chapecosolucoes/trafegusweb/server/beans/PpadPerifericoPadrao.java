/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "ppad_periferico_padrao")
@NamedQueries({
    @NamedQuery(name = "PpadPerifericoPadrao.findAll", query = "SELECT p FROM PpadPerifericoPadrao p"),
    @NamedQuery(name = "PpadPerifericoPadrao.findByPpadCodigo", query = "SELECT p FROM PpadPerifericoPadrao p WHERE p.ppadCodigo = :ppadCodigo"),
    @NamedQuery(name = "PpadPerifericoPadrao.findByPpadDescricao", query = "SELECT p FROM PpadPerifericoPadrao p WHERE p.ppadDescricao = :ppadDescricao"),
    @NamedQuery(name = "PpadPerifericoPadrao.findByPpadDataCadastro", query = "SELECT p FROM PpadPerifericoPadrao p WHERE p.ppadDataCadastro = :ppadDataCadastro"),
    @NamedQuery(name = "PpadPerifericoPadrao.findByPpadCodigoGr", query = "SELECT p FROM PpadPerifericoPadrao p WHERE p.ppadCodigoGr = :ppadCodigoGr"),
    @NamedQuery(name = "PpadPerifericoPadrao.findByPpadImportado", query = "SELECT p FROM PpadPerifericoPadrao p WHERE p.ppadImportado = :ppadImportado")})
public class PpadPerifericoPadrao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ppad_codigo")
    private Integer ppadCodigo;
    @Column(name = "ppad_descricao")
    private String ppadDescricao;
    @Column(name = "ppad_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ppadDataCadastro;
    @Column(name = "ppad_codigo_gr")
    private Integer ppadCodigoGr;
    @Column(name = "ppad_importado")
    private Character ppadImportado;
    @JoinColumn(name = "ppad_tper_codigo", referencedColumnName = "tper_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private TperTipoPeriferico tperTipoPeriferico;
    @OneToMany(mappedBy = "ppadPerifericoPadrao", fetch = FetchType.EAGER)
    private List<EppaEventoPerifericoPadrao> eppaEventoPerifericoPadraoList;
    @OneToMany(mappedBy = "ppadPerifericoPadrao", fetch = FetchType.EAGER)
    private List<PpinPerifericoPadraoInstal> ppinPerifericoPadraoInstalList;
    @OneToMany(mappedBy = "ppadPerifericoPadrao", fetch = FetchType.EAGER)
    private List<PitePgItem> pitePgItemList;
    @OneToMany(mappedBy = "ppadPerifericoPadrao", fetch = FetchType.EAGER)
    private List<PvtePerifericVersaoTecnolo> pvtePerifericVersaoTecnoloList;

    public PpadPerifericoPadrao() {
    }

    public PpadPerifericoPadrao(Integer ppadCodigo) {
        this.ppadCodigo = ppadCodigo;
    }

    public Integer getPpadCodigo() {
        return ppadCodigo;
    }

    public void setPpadCodigo(Integer ppadCodigo) {
        this.ppadCodigo = ppadCodigo;
    }

    public String getPpadDescricao() {
        return ppadDescricao;
    }

    public void setPpadDescricao(String ppadDescricao) {
        this.ppadDescricao = ppadDescricao;
    }

    public Date getPpadDataCadastro() {
        return ppadDataCadastro;
    }

    public void setPpadDataCadastro(Date ppadDataCadastro) {
        this.ppadDataCadastro = ppadDataCadastro;
    }

    public Integer getPpadCodigoGr() {
        return ppadCodigoGr;
    }

    public void setPpadCodigoGr(Integer ppadCodigoGr) {
        this.ppadCodigoGr = ppadCodigoGr;
    }

    public Character getPpadImportado() {
        return ppadImportado;
    }

    public void setPpadImportado(Character ppadImportado) {
        this.ppadImportado = ppadImportado;
    }

    public TperTipoPeriferico getTperTipoPeriferico() {
        return tperTipoPeriferico;
    }

    public void setTperTipoPeriferico(TperTipoPeriferico tperTipoPeriferico) {
        this.tperTipoPeriferico = tperTipoPeriferico;
    }

    public List<EppaEventoPerifericoPadrao> getEppaEventoPerifericoPadraoList() {
        return eppaEventoPerifericoPadraoList;
    }

    public void setEppaEventoPerifericoPadraoList(List<EppaEventoPerifericoPadrao> eppaEventoPerifericoPadraoList) {
        this.eppaEventoPerifericoPadraoList = eppaEventoPerifericoPadraoList;
    }

    public List<PpinPerifericoPadraoInstal> getPpinPerifericoPadraoInstalList() {
        return ppinPerifericoPadraoInstalList;
    }

    public void setPpinPerifericoPadraoInstalList(List<PpinPerifericoPadraoInstal> ppinPerifericoPadraoInstalList) {
        this.ppinPerifericoPadraoInstalList = ppinPerifericoPadraoInstalList;
    }

    public List<PitePgItem> getPitePgItemList() {
        return pitePgItemList;
    }

    public void setPitePgItemList(List<PitePgItem> pitePgItemList) {
        this.pitePgItemList = pitePgItemList;
    }

    public List<PvtePerifericVersaoTecnolo> getPvtePerifericVersaoTecnoloList() {
        return pvtePerifericVersaoTecnoloList;
    }

    public void setPvtePerifericVersaoTecnoloList(List<PvtePerifericVersaoTecnolo> pvtePerifericVersaoTecnoloList) {
        this.pvtePerifericVersaoTecnoloList = pvtePerifericVersaoTecnoloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ppadCodigo != null ? ppadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PpadPerifericoPadrao)) {
            return false;
        }
        PpadPerifericoPadrao other = (PpadPerifericoPadrao) object;
        if ((this.ppadCodigo == null && other.ppadCodigo != null) || (this.ppadCodigo != null && !this.ppadCodigo.equals(other.ppadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PpadPerifericoPadrao[ppadCodigo=" + ppadCodigo + "]";
    }

}
