/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "oras_objeto_rastreado")
@NamedQueries({
    @NamedQuery(name = "OrasObjetoRastreado.findAll", query = "SELECT o FROM OrasObjetoRastreado o")})
public class OrasObjetoRastreado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "oras_codigo")
    private Integer orasCodigo;
    @Column(name = "oras_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orasDataCadastro;
    @Column(name = "oras_codigo_gr")
    private Integer orasCodigoGr;
    @Column(name = "oras_importado")
    private Character orasImportado;
    @OneToMany(mappedBy = "orasObjetoRastreado")
    private Set<TermTerminal> termTerminalSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orasObjetoRastreado")
    private VeicVeiculo veicVeiculo;
    @JoinColumn(name = "oras_pgpg_codigo", referencedColumnName = "pgpg_codigo")
    @ManyToOne
    private PgpgPg pgpgPg;
    @JoinColumn(name = "oras_eobj_codigo", referencedColumnName = "eobj_codigo")
    @ManyToOne
    private EobjEstatusObjeto eobjEstatusObjeto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orasObjetoRastreado")
    private PessPessoa pessPessoa;

    public OrasObjetoRastreado() {
    }

    public OrasObjetoRastreado(Integer orasCodigo) {
        this.orasCodigo = orasCodigo;
    }

    public Integer getOrasCodigo() {
        return orasCodigo;
    }

    public void setOrasCodigo(Integer orasCodigo) {
        this.orasCodigo = orasCodigo;
    }

    public Date getOrasDataCadastro() {
        return orasDataCadastro;
    }

    public void setOrasDataCadastro(Date orasDataCadastro) {
        this.orasDataCadastro = orasDataCadastro;
    }

    public Integer getOrasCodigoGr() {
        return orasCodigoGr;
    }

    public void setOrasCodigoGr(Integer orasCodigoGr) {
        this.orasCodigoGr = orasCodigoGr;
    }

    public Character getOrasImportado() {
        return orasImportado;
    }

    public void setOrasImportado(Character orasImportado) {
        this.orasImportado = orasImportado;
    }

    public Set<TermTerminal> getTermTerminalSet() {
        return termTerminalSet;
    }

    public void setTermTerminalSet(Set<TermTerminal> termTerminalSet) {
        this.termTerminalSet = termTerminalSet;
    }

    public VeicVeiculo getVeicVeiculo() {
        return veicVeiculo;
    }

    public void setVeicVeiculo(VeicVeiculo veicVeiculo) {
        this.veicVeiculo = veicVeiculo;
    }

    public PgpgPg getPgpgPg() {
        return pgpgPg;
    }

    public void setPgpgPg(PgpgPg pgpgPg) {
        this.pgpgPg = pgpgPg;
    }

    public EobjEstatusObjeto getEobjEstatusObjeto() {
        return eobjEstatusObjeto;
    }

    public void setEobjEstatusObjeto(EobjEstatusObjeto eobjEstatusObjeto) {
        this.eobjEstatusObjeto = eobjEstatusObjeto;
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
        hash += (orasCodigo != null ? orasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrasObjetoRastreado)) {
            return false;
        }
        OrasObjetoRastreado other = (OrasObjetoRastreado) object;
        if ((this.orasCodigo == null && other.orasCodigo != null) || (this.orasCodigo != null && !this.orasCodigo.equals(other.orasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.OrasObjetoRastreado[orasCodigo=" + orasCodigo + "]";
    }

}
