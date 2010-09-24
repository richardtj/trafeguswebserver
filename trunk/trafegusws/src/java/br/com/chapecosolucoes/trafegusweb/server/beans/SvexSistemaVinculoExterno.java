/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "svex_sistema_vinculo_externo", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SvexSistemaVinculoExterno.findAll", query = "SELECT s FROM SvexSistemaVinculoExterno s"),
    @NamedQuery(name = "SvexSistemaVinculoExterno.findBySvexCodigo", query = "SELECT s FROM SvexSistemaVinculoExterno s WHERE s.svexCodigo = :svexCodigo"),
    @NamedQuery(name = "SvexSistemaVinculoExterno.findBySvexIdObjeto", query = "SELECT s FROM SvexSistemaVinculoExterno s WHERE s.svexIdObjeto = :svexIdObjeto"),
    @NamedQuery(name = "SvexSistemaVinculoExterno.findBySvexCodigoPk", query = "SELECT s FROM SvexSistemaVinculoExterno s WHERE s.svexCodigoPk = :svexCodigoPk"),
    @NamedQuery(name = "SvexSistemaVinculoExterno.findBySvexCodigoExterno", query = "SELECT s FROM SvexSistemaVinculoExterno s WHERE s.svexCodigoExterno = :svexCodigoExterno")})
public class SvexSistemaVinculoExterno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "svex_codigo", nullable = false)
    private Integer svexCodigo;
    @Column(name = "svex_id_objeto")
    private Integer svexIdObjeto;
    @Column(name = "svex_codigo_pk")
    private Integer svexCodigoPk;
    @Column(name = "svex_codigo_externo", length = 10)
    private String svexCodigoExterno;

    public SvexSistemaVinculoExterno() {
    }

    public SvexSistemaVinculoExterno(Integer svexCodigo) {
        this.svexCodigo = svexCodigo;
    }

    public Integer getSvexCodigo() {
        return svexCodigo;
    }

    public void setSvexCodigo(Integer svexCodigo) {
        this.svexCodigo = svexCodigo;
    }

    public Integer getSvexIdObjeto() {
        return svexIdObjeto;
    }

    public void setSvexIdObjeto(Integer svexIdObjeto) {
        this.svexIdObjeto = svexIdObjeto;
    }

    public Integer getSvexCodigoPk() {
        return svexCodigoPk;
    }

    public void setSvexCodigoPk(Integer svexCodigoPk) {
        this.svexCodigoPk = svexCodigoPk;
    }

    public String getSvexCodigoExterno() {
        return svexCodigoExterno;
    }

    public void setSvexCodigoExterno(String svexCodigoExterno) {
        this.svexCodigoExterno = svexCodigoExterno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svexCodigo != null ? svexCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvexSistemaVinculoExterno)) {
            return false;
        }
        SvexSistemaVinculoExterno other = (SvexSistemaVinculoExterno) object;
        if ((this.svexCodigo == null && other.svexCodigo != null) || (this.svexCodigo != null && !this.svexCodigo.equals(other.svexCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.SvexSistemaVinculoExterno[svexCodigo=" + svexCodigo + "]";
    }

}
