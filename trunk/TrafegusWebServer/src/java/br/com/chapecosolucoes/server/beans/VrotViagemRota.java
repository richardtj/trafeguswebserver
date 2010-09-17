/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "vrot_viagem_rota")
@NamedQueries({
    @NamedQuery(name = "VrotViagemRota.findAll", query = "SELECT v FROM VrotViagemRota v")})
public class VrotViagemRota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vrot_codigo", nullable = false)
    private Integer vrotCodigo;
    @Column(name = "vrot_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vrotDataCadastro;
    @Column(name = "vrot_codigo_gr")
    private Integer vrotCodigoGr;
    @Column(name = "vrot_importado")
    private Character vrotImportado;
    @Column(name = "vrot_ativo")
    private Character vrotAtivo;
    @JoinColumn(name = "vrot_viag_codigo", referencedColumnName = "viag_codigo")
    @ManyToOne
    private ViagViagem viagViagem;
    @JoinColumn(name = "vrot_rota_codigo", referencedColumnName = "rota_codigo")
    @ManyToOne
    private RotaRota rotaRota;

    public VrotViagemRota() {
    }

    public VrotViagemRota(Integer vrotCodigo) {
        this.vrotCodigo = vrotCodigo;
    }

    public Integer getVrotCodigo() {
        return vrotCodigo;
    }

    public void setVrotCodigo(Integer vrotCodigo) {
        this.vrotCodigo = vrotCodigo;
    }

    public Date getVrotDataCadastro() {
        return vrotDataCadastro;
    }

    public void setVrotDataCadastro(Date vrotDataCadastro) {
        this.vrotDataCadastro = vrotDataCadastro;
    }

    public Integer getVrotCodigoGr() {
        return vrotCodigoGr;
    }

    public void setVrotCodigoGr(Integer vrotCodigoGr) {
        this.vrotCodigoGr = vrotCodigoGr;
    }

    public Character getVrotImportado() {
        return vrotImportado;
    }

    public void setVrotImportado(Character vrotImportado) {
        this.vrotImportado = vrotImportado;
    }

    public Character getVrotAtivo() {
        return vrotAtivo;
    }

    public void setVrotAtivo(Character vrotAtivo) {
        this.vrotAtivo = vrotAtivo;
    }

    public ViagViagem getViagViagem() {
        return viagViagem;
    }

    public void setViagViagem(ViagViagem viagViagem) {
        this.viagViagem = viagViagem;
    }

    public RotaRota getRotaRota() {
        return rotaRota;
    }

    public void setRotaRota(RotaRota rotaRota) {
        this.rotaRota = rotaRota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vrotCodigo != null ? vrotCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VrotViagemRota)) {
            return false;
        }
        VrotViagemRota other = (VrotViagemRota) object;
        if ((this.vrotCodigo == null && other.vrotCodigo != null) || (this.vrotCodigo != null && !this.vrotCodigo.equals(other.vrotCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.VrotViagemRota[vrotCodigo=" + vrotCodigo + "]";
    }

}
