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
@Table(name = "vest_viagem_estatus", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "VestViagemEstatus.findAll", query = "SELECT v FROM VestViagemEstatus v"),
    @NamedQuery(name = "VestViagemEstatus.findByVestCodigo", query = "SELECT v FROM VestViagemEstatus v WHERE v.vestCodigo = :vestCodigo"),
    @NamedQuery(name = "VestViagemEstatus.findByVestEstatus", query = "SELECT v FROM VestViagemEstatus v WHERE v.vestEstatus = :vestEstatus"),
    @NamedQuery(name = "VestViagemEstatus.findByVestDataCadastro", query = "SELECT v FROM VestViagemEstatus v WHERE v.vestDataCadastro = :vestDataCadastro"),
    @NamedQuery(name = "VestViagemEstatus.findByVestObservacao", query = "SELECT v FROM VestViagemEstatus v WHERE v.vestObservacao = :vestObservacao")})
public class VestViagemEstatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vest_codigo", nullable = false)
    private Integer vestCodigo;
    @Column(name = "vest_estatus", length = 10)
    private String vestEstatus;
    @Column(name = "vest_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vestDataCadastro;
    @Column(name = "vest_observacao", length = 200)
    private String vestObservacao;
    @JoinColumn(name = "vest_viag_codigo", referencedColumnName = "viag_codigo")
    @ManyToOne
    private ViagViagem viagViagem;
    @JoinColumn(name = "vest_usua_pfis_pess_oras_codigo", referencedColumnName = "usua_pfis_pess_oras_codigo")
    @ManyToOne
    private UsuaUsuario usuaUsuario;
    @JoinColumn(name = "vest_moti_codigo", referencedColumnName = "moti_codigo")
    @ManyToOne
    private MotiMotivo motiMotivo;

    public VestViagemEstatus() {
    }

    public VestViagemEstatus(Integer vestCodigo) {
        this.vestCodigo = vestCodigo;
    }

    public Integer getVestCodigo() {
        return vestCodigo;
    }

    public void setVestCodigo(Integer vestCodigo) {
        this.vestCodigo = vestCodigo;
    }

    public String getVestEstatus() {
        return vestEstatus;
    }

    public void setVestEstatus(String vestEstatus) {
        this.vestEstatus = vestEstatus;
    }

    public Date getVestDataCadastro() {
        return vestDataCadastro;
    }

    public void setVestDataCadastro(Date vestDataCadastro) {
        this.vestDataCadastro = vestDataCadastro;
    }

    public String getVestObservacao() {
        return vestObservacao;
    }

    public void setVestObservacao(String vestObservacao) {
        this.vestObservacao = vestObservacao;
    }

    public ViagViagem getViagViagem() {
        return viagViagem;
    }

    public void setViagViagem(ViagViagem viagViagem) {
        this.viagViagem = viagViagem;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public MotiMotivo getMotiMotivo() {
        return motiMotivo;
    }

    public void setMotiMotivo(MotiMotivo motiMotivo) {
        this.motiMotivo = motiMotivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vestCodigo != null ? vestCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VestViagemEstatus)) {
            return false;
        }
        VestViagemEstatus other = (VestViagemEstatus) object;
        if ((this.vestCodigo == null && other.vestCodigo != null) || (this.vestCodigo != null && !this.vestCodigo.equals(other.vestCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VestViagemEstatus[vestCodigo=" + vestCodigo + "]";
    }

}
