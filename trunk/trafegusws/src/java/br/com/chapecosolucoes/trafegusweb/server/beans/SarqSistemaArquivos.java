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
@Table(name = "sarq_sistema_arquivos", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SarqSistemaArquivos.findAll", query = "SELECT s FROM SarqSistemaArquivos s"),
    @NamedQuery(name = "SarqSistemaArquivos.findBySarqCodigo", query = "SELECT s FROM SarqSistemaArquivos s WHERE s.sarqCodigo = :sarqCodigo"),
    @NamedQuery(name = "SarqSistemaArquivos.findBySarqPath", query = "SELECT s FROM SarqSistemaArquivos s WHERE s.sarqPath = :sarqPath")})
public class SarqSistemaArquivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sarq_codigo", nullable = false)
    private Integer sarqCodigo;
    @Column(name = "sarq_path", length = 500)
    private String sarqPath;

    public SarqSistemaArquivos() {
    }

    public SarqSistemaArquivos(Integer sarqCodigo) {
        this.sarqCodigo = sarqCodigo;
    }

    public Integer getSarqCodigo() {
        return sarqCodigo;
    }

    public void setSarqCodigo(Integer sarqCodigo) {
        this.sarqCodigo = sarqCodigo;
    }

    public String getSarqPath() {
        return sarqPath;
    }

    public void setSarqPath(String sarqPath) {
        this.sarqPath = sarqPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sarqCodigo != null ? sarqCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SarqSistemaArquivos)) {
            return false;
        }
        SarqSistemaArquivos other = (SarqSistemaArquivos) object;
        if ((this.sarqCodigo == null && other.sarqCodigo != null) || (this.sarqCodigo != null && !this.sarqCodigo.equals(other.sarqCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.SarqSistemaArquivos[sarqCodigo=" + sarqCodigo + "]";
    }

}
