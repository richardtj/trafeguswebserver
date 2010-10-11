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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ppro_permissao_produto")
@NamedQueries({
    @NamedQuery(name = "PproPermissaoProduto.findAll", query = "SELECT p FROM PproPermissaoProduto p"),
    @NamedQuery(name = "PproPermissaoProduto.findByPproCodigo", query = "SELECT p FROM PproPermissaoProduto p WHERE p.pproCodigo = :pproCodigo"),
    @NamedQuery(name = "PproPermissaoProduto.findByPproIdObjetoProduto", query = "SELECT p FROM PproPermissaoProduto p WHERE p.pproIdObjetoProduto = :pproIdObjetoProduto"),
    @NamedQuery(name = "PproPermissaoProduto.findByPproDataCadastro", query = "SELECT p FROM PproPermissaoProduto p WHERE p.pproDataCadastro = :pproDataCadastro"),
    @NamedQuery(name = "PproPermissaoProduto.findByPproCodigoGr", query = "SELECT p FROM PproPermissaoProduto p WHERE p.pproCodigoGr = :pproCodigoGr"),
    @NamedQuery(name = "PproPermissaoProduto.findByPproImportado", query = "SELECT p FROM PproPermissaoProduto p WHERE p.pproImportado = :pproImportado")})
public class PproPermissaoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ppro_codigo")
    private Integer pproCodigo;
    @Basic(optional = false)
    @Column(name = "ppro_id_objeto_produto")
    private int pproIdObjetoProduto;
    @Column(name = "ppro_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pproDataCadastro;
    @Column(name = "ppro_codigo_gr")
    private Integer pproCodigoGr;
    @Column(name = "ppro_importado")
    private Character pproImportado;
    @JoinColumn(name = "ppro_perf_codigo", referencedColumnName = "perf_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PerfPerfil perfPerfil;

    public PproPermissaoProduto() {
    }

    public PproPermissaoProduto(Integer pproCodigo) {
        this.pproCodigo = pproCodigo;
    }

    public PproPermissaoProduto(Integer pproCodigo, int pproIdObjetoProduto) {
        this.pproCodigo = pproCodigo;
        this.pproIdObjetoProduto = pproIdObjetoProduto;
    }

    public Integer getPproCodigo() {
        return pproCodigo;
    }

    public void setPproCodigo(Integer pproCodigo) {
        this.pproCodigo = pproCodigo;
    }

    public int getPproIdObjetoProduto() {
        return pproIdObjetoProduto;
    }

    public void setPproIdObjetoProduto(int pproIdObjetoProduto) {
        this.pproIdObjetoProduto = pproIdObjetoProduto;
    }

    public Date getPproDataCadastro() {
        return pproDataCadastro;
    }

    public void setPproDataCadastro(Date pproDataCadastro) {
        this.pproDataCadastro = pproDataCadastro;
    }

    public Integer getPproCodigoGr() {
        return pproCodigoGr;
    }

    public void setPproCodigoGr(Integer pproCodigoGr) {
        this.pproCodigoGr = pproCodigoGr;
    }

    public Character getPproImportado() {
        return pproImportado;
    }

    public void setPproImportado(Character pproImportado) {
        this.pproImportado = pproImportado;
    }

    public PerfPerfil getPerfPerfil() {
        return perfPerfil;
    }

    public void setPerfPerfil(PerfPerfil perfPerfil) {
        this.perfPerfil = perfPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pproCodigo != null ? pproCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproPermissaoProduto)) {
            return false;
        }
        PproPermissaoProduto other = (PproPermissaoProduto) object;
        if ((this.pproCodigo == null && other.pproCodigo != null) || (this.pproCodigo != null && !this.pproCodigo.equals(other.pproCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PproPermissaoProduto[pproCodigo=" + pproCodigo + "]";
    }

}
