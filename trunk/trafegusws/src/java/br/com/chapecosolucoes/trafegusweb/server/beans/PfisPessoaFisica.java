/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "pfis_pessoa_fisica")
@NamedQueries({
    @NamedQuery(name = "PfisPessoaFisica.findAll", query = "SELECT p FROM PfisPessoaFisica p")})
public class PfisPessoaFisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pfis_pess_oras_codigo")
    private Integer pfisPessOrasCodigo;
    @Column(name = "pfis_rg")
    private String pfisRg;
    @Column(name = "pfis_cpf")
    private String pfisCpf;
    @Column(name = "pfis_data_nascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pfisDataNascimento;
    @Column(name = "pfis_sexo")
    private String pfisSexo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pfisPessoaFisica")
    private UsuaUsuario usuaUsuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pfisPessoaFisica")
    private MotoMotorista motoMotorista;
    @JoinColumn(name = "pfis_pess_oras_codigo", referencedColumnName = "pess_oras_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PessPessoa pessPessoa;

    public PfisPessoaFisica() {
    }

    public PfisPessoaFisica(Integer pfisPessOrasCodigo) {
        this.pfisPessOrasCodigo = pfisPessOrasCodigo;
    }

    public Integer getPfisPessOrasCodigo() {
        return pfisPessOrasCodigo;
    }

    public void setPfisPessOrasCodigo(Integer pfisPessOrasCodigo) {
        this.pfisPessOrasCodigo = pfisPessOrasCodigo;
    }

    public String getPfisRg() {
        return pfisRg;
    }

    public void setPfisRg(String pfisRg) {
        this.pfisRg = pfisRg;
    }

    public String getPfisCpf() {
        return pfisCpf;
    }

    public void setPfisCpf(String pfisCpf) {
        this.pfisCpf = pfisCpf;
    }

    public Date getPfisDataNascimento() {
        return pfisDataNascimento;
    }

    public void setPfisDataNascimento(Date pfisDataNascimento) {
        this.pfisDataNascimento = pfisDataNascimento;
    }

    public String getPfisSexo() {
        return pfisSexo;
    }

    public void setPfisSexo(String pfisSexo) {
        this.pfisSexo = pfisSexo;
    }

    public UsuaUsuario getUsuaUsuario() {
        return usuaUsuario;
    }

    public void setUsuaUsuario(UsuaUsuario usuaUsuario) {
        this.usuaUsuario = usuaUsuario;
    }

    public MotoMotorista getMotoMotorista() {
        return motoMotorista;
    }

    public void setMotoMotorista(MotoMotorista motoMotorista) {
        this.motoMotorista = motoMotorista;
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
        hash += (pfisPessOrasCodigo != null ? pfisPessOrasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PfisPessoaFisica)) {
            return false;
        }
        PfisPessoaFisica other = (PfisPessoaFisica) object;
        if ((this.pfisPessOrasCodigo == null && other.pfisPessOrasCodigo != null) || (this.pfisPessOrasCodigo != null && !this.pfisPessOrasCodigo.equals(other.pfisPessOrasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.PfisPessoaFisica[pfisPessOrasCodigo=" + pfisPessOrasCodigo + "]";
    }

}
