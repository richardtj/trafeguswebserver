/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "mpad_macro_padrao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "MpadMacroPadrao.findAll", query = "SELECT m FROM MpadMacroPadrao m"),
    @NamedQuery(name = "MpadMacroPadrao.findByMpadCodigo", query = "SELECT m FROM MpadMacroPadrao m WHERE m.mpadCodigo = :mpadCodigo"),
    @NamedQuery(name = "MpadMacroPadrao.findByMpadNumero", query = "SELECT m FROM MpadMacroPadrao m WHERE m.mpadNumero = :mpadNumero"),
    @NamedQuery(name = "MpadMacroPadrao.findByMpadDescricao", query = "SELECT m FROM MpadMacroPadrao m WHERE m.mpadDescricao = :mpadDescricao"),
    @NamedQuery(name = "MpadMacroPadrao.findByMpadMascara", query = "SELECT m FROM MpadMacroPadrao m WHERE m.mpadMascara = :mpadMascara"),
    @NamedQuery(name = "MpadMacroPadrao.findByMpadDataCadastro", query = "SELECT m FROM MpadMacroPadrao m WHERE m.mpadDataCadastro = :mpadDataCadastro"),
    @NamedQuery(name = "MpadMacroPadrao.findByMpadCodigoGr", query = "SELECT m FROM MpadMacroPadrao m WHERE m.mpadCodigoGr = :mpadCodigoGr"),
    @NamedQuery(name = "MpadMacroPadrao.findByMpadImportado", query = "SELECT m FROM MpadMacroPadrao m WHERE m.mpadImportado = :mpadImportado")})
public class MpadMacroPadrao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mpad_codigo", nullable = false)
    private Integer mpadCodigo;
    @Column(name = "mpad_numero", length = 10)
    private String mpadNumero;
    @Column(name = "mpad_descricao", length = 100)
    private String mpadDescricao;
    @Column(name = "mpad_mascara", length = 500)
    private String mpadMascara;
    @Column(name = "mpad_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mpadDataCadastro;
    @Column(name = "mpad_codigo_gr")
    private Integer mpadCodigoGr;
    @Column(name = "mpad_importado")
    private Character mpadImportado;
    @OneToMany(mappedBy = "mpadMacroPadrao")
    private Collection<EmacEnvioMacro> emacEnvioMacroCollection;
    @JoinColumn(name = "mpad_tmac_codigo", referencedColumnName = "tmac_codigo")
    @ManyToOne
    private TmacTipoMacro tmacTipoMacro;
    @JoinColumn(name = "mpad_gmac_codigo", referencedColumnName = "gmac_codigo")
    @ManyToOne
    private GmacGrupoMacro gmacGrupoMacro;
    @OneToMany(mappedBy = "mpadMacroPadrao")
    private Collection<AmacAcaoMacro> amacAcaoMacroCollection;
    @OneToMany(mappedBy = "mpadMacroPadrao")
    private Collection<PitePgItem> pitePgItemCollection;

    public MpadMacroPadrao() {
    }

    public MpadMacroPadrao(Integer mpadCodigo) {
        this.mpadCodigo = mpadCodigo;
    }

    public Integer getMpadCodigo() {
        return mpadCodigo;
    }

    public void setMpadCodigo(Integer mpadCodigo) {
        this.mpadCodigo = mpadCodigo;
    }

    public String getMpadNumero() {
        return mpadNumero;
    }

    public void setMpadNumero(String mpadNumero) {
        this.mpadNumero = mpadNumero;
    }

    public String getMpadDescricao() {
        return mpadDescricao;
    }

    public void setMpadDescricao(String mpadDescricao) {
        this.mpadDescricao = mpadDescricao;
    }

    public String getMpadMascara() {
        return mpadMascara;
    }

    public void setMpadMascara(String mpadMascara) {
        this.mpadMascara = mpadMascara;
    }

    public Date getMpadDataCadastro() {
        return mpadDataCadastro;
    }

    public void setMpadDataCadastro(Date mpadDataCadastro) {
        this.mpadDataCadastro = mpadDataCadastro;
    }

    public Integer getMpadCodigoGr() {
        return mpadCodigoGr;
    }

    public void setMpadCodigoGr(Integer mpadCodigoGr) {
        this.mpadCodigoGr = mpadCodigoGr;
    }

    public Character getMpadImportado() {
        return mpadImportado;
    }

    public void setMpadImportado(Character mpadImportado) {
        this.mpadImportado = mpadImportado;
    }

    public Collection<EmacEnvioMacro> getEmacEnvioMacroCollection() {
        return emacEnvioMacroCollection;
    }

    public void setEmacEnvioMacroCollection(Collection<EmacEnvioMacro> emacEnvioMacroCollection) {
        this.emacEnvioMacroCollection = emacEnvioMacroCollection;
    }

    public TmacTipoMacro getTmacTipoMacro() {
        return tmacTipoMacro;
    }

    public void setTmacTipoMacro(TmacTipoMacro tmacTipoMacro) {
        this.tmacTipoMacro = tmacTipoMacro;
    }

    public GmacGrupoMacro getGmacGrupoMacro() {
        return gmacGrupoMacro;
    }

    public void setGmacGrupoMacro(GmacGrupoMacro gmacGrupoMacro) {
        this.gmacGrupoMacro = gmacGrupoMacro;
    }

    public Collection<AmacAcaoMacro> getAmacAcaoMacroCollection() {
        return amacAcaoMacroCollection;
    }

    public void setAmacAcaoMacroCollection(Collection<AmacAcaoMacro> amacAcaoMacroCollection) {
        this.amacAcaoMacroCollection = amacAcaoMacroCollection;
    }

    public Collection<PitePgItem> getPitePgItemCollection() {
        return pitePgItemCollection;
    }

    public void setPitePgItemCollection(Collection<PitePgItem> pitePgItemCollection) {
        this.pitePgItemCollection = pitePgItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mpadCodigo != null ? mpadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MpadMacroPadrao)) {
            return false;
        }
        MpadMacroPadrao other = (MpadMacroPadrao) object;
        if ((this.mpadCodigo == null && other.mpadCodigo != null) || (this.mpadCodigo != null && !this.mpadCodigo.equals(other.mpadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.MpadMacroPadrao[mpadCodigo=" + mpadCodigo + "]";
    }

}
