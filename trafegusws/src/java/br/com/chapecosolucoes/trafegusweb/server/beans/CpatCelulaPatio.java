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
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "cpat_celula_patio")
@NamedQueries({
    @NamedQuery(name = "CpatCelulaPatio.findAll", query = "SELECT c FROM CpatCelulaPatio c"),
    @NamedQuery(name = "CpatCelulaPatio.findByCpatCodigo", query = "SELECT c FROM CpatCelulaPatio c WHERE c.cpatCodigo = :cpatCodigo"),
    @NamedQuery(name = "CpatCelulaPatio.findByCpatDescricao", query = "SELECT c FROM CpatCelulaPatio c WHERE c.cpatDescricao = :cpatDescricao"),
    @NamedQuery(name = "CpatCelulaPatio.findByCpatDataCadastro", query = "SELECT c FROM CpatCelulaPatio c WHERE c.cpatDataCadastro = :cpatDataCadastro"),
    @NamedQuery(name = "CpatCelulaPatio.findByCpatCodigoGr", query = "SELECT c FROM CpatCelulaPatio c WHERE c.cpatCodigoGr = :cpatCodigoGr"),
    @NamedQuery(name = "CpatCelulaPatio.findByCpatImportado", query = "SELECT c FROM CpatCelulaPatio c WHERE c.cpatImportado = :cpatImportado")})
public class CpatCelulaPatio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpat_codigo")
    private Integer cpatCodigo;
    @Column(name = "cpat_descricao")
    private String cpatDescricao;
    @Column(name = "cpat_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpatDataCadastro;
    @Column(name = "cpat_codigo_gr")
    private Integer cpatCodigoGr;
    @Column(name = "cpat_importado")
    private Character cpatImportado;
    @OneToMany(mappedBy = "cpatCelulaPatio", fetch = FetchType.LAZY)
    private Collection<VlevViagemLocalEvento> vlevViagemLocalEventoCollection;

    public CpatCelulaPatio() {
    }

    public CpatCelulaPatio(Integer cpatCodigo) {
        this.cpatCodigo = cpatCodigo;
    }

    public Integer getCpatCodigo() {
        return cpatCodigo;
    }

    public void setCpatCodigo(Integer cpatCodigo) {
        this.cpatCodigo = cpatCodigo;
    }

    public String getCpatDescricao() {
        return cpatDescricao;
    }

    public void setCpatDescricao(String cpatDescricao) {
        this.cpatDescricao = cpatDescricao;
    }

    public Date getCpatDataCadastro() {
        return cpatDataCadastro;
    }

    public void setCpatDataCadastro(Date cpatDataCadastro) {
        this.cpatDataCadastro = cpatDataCadastro;
    }

    public Integer getCpatCodigoGr() {
        return cpatCodigoGr;
    }

    public void setCpatCodigoGr(Integer cpatCodigoGr) {
        this.cpatCodigoGr = cpatCodigoGr;
    }

    public Character getCpatImportado() {
        return cpatImportado;
    }

    public void setCpatImportado(Character cpatImportado) {
        this.cpatImportado = cpatImportado;
    }

    public Collection<VlevViagemLocalEvento> getVlevViagemLocalEventoCollection() {
        return vlevViagemLocalEventoCollection;
    }

    public void setVlevViagemLocalEventoCollection(Collection<VlevViagemLocalEvento> vlevViagemLocalEventoCollection) {
        this.vlevViagemLocalEventoCollection = vlevViagemLocalEventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpatCodigo != null ? cpatCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CpatCelulaPatio)) {
            return false;
        }
        CpatCelulaPatio other = (CpatCelulaPatio) object;
        if ((this.cpatCodigo == null && other.cpatCodigo != null) || (this.cpatCodigo != null && !this.cpatCodigo.equals(other.cpatCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CpatCelulaPatio[cpatCodigo=" + cpatCodigo + "]";
    }

}
