/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "csis_configuracao_sistema", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CsisConfiguracaoSistema.findAll", query = "SELECT c FROM CsisConfiguracaoSistema c"),
    @NamedQuery(name = "CsisConfiguracaoSistema.findByCsisCodigo", query = "SELECT c FROM CsisConfiguracaoSistema c WHERE c.csisCodigo = :csisCodigo"),
    @NamedQuery(name = "CsisConfiguracaoSistema.findByCsisUsarSeparacaoFilial", query = "SELECT c FROM CsisConfiguracaoSistema c WHERE c.csisUsarSeparacaoFilial = :csisUsarSeparacaoFilial"),
    @NamedQuery(name = "CsisConfiguracaoSistema.findByCsisDataCadastro", query = "SELECT c FROM CsisConfiguracaoSistema c WHERE c.csisDataCadastro = :csisDataCadastro"),
    @NamedQuery(name = "CsisConfiguracaoSistema.findByCsisImportado", query = "SELECT c FROM CsisConfiguracaoSistema c WHERE c.csisImportado = :csisImportado")})
public class CsisConfiguracaoSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "csis_codigo", nullable = false)
    private Integer csisCodigo;
    @Column(name = "csis_usar_separacao_filial")
    private Character csisUsarSeparacaoFilial;
    @Column(name = "csis_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date csisDataCadastro;
    @Column(name = "csis_importado")
    private Character csisImportado;

    public CsisConfiguracaoSistema() {
    }

    public CsisConfiguracaoSistema(Integer csisCodigo) {
        this.csisCodigo = csisCodigo;
    }

    public Integer getCsisCodigo() {
        return csisCodigo;
    }

    public void setCsisCodigo(Integer csisCodigo) {
        this.csisCodigo = csisCodigo;
    }

    public Character getCsisUsarSeparacaoFilial() {
        return csisUsarSeparacaoFilial;
    }

    public void setCsisUsarSeparacaoFilial(Character csisUsarSeparacaoFilial) {
        this.csisUsarSeparacaoFilial = csisUsarSeparacaoFilial;
    }

    public Date getCsisDataCadastro() {
        return csisDataCadastro;
    }

    public void setCsisDataCadastro(Date csisDataCadastro) {
        this.csisDataCadastro = csisDataCadastro;
    }

    public Character getCsisImportado() {
        return csisImportado;
    }

    public void setCsisImportado(Character csisImportado) {
        this.csisImportado = csisImportado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csisCodigo != null ? csisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsisConfiguracaoSistema)) {
            return false;
        }
        CsisConfiguracaoSistema other = (CsisConfiguracaoSistema) object;
        if ((this.csisCodigo == null && other.csisCodigo != null) || (this.csisCodigo != null && !this.csisCodigo.equals(other.csisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.CsisConfiguracaoSistema[csisCodigo=" + csisCodigo + "]";
    }

}
