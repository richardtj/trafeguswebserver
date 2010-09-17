/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "cona_contato")
@NamedQueries({
    @NamedQuery(name = "ConaContato.findAll", query = "SELECT c FROM ConaContato c")})
public class ConaContato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cona_codigo", nullable = false)
    private Integer conaCodigo;
    @Column(name = "cona_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conaDataCadastro;
    @Column(name = "cona_codigo_gr")
    private Integer conaCodigoGr;
    @Column(name = "cona_importado")
    private Character conaImportado;
    @Column(name = "cona_telefone_1", length = 30)
    private String conaTelefone1;
    @Column(name = "cona_telefone_2", length = 30)
    private String conaTelefone2;
    @Column(name = "cona_telefone_3", length = 30)
    private String conaTelefone3;
    @Column(name = "cona_email", length = 100)
    private String conaEmail;
    @Column(name = "cona_observacao", length = 5000)
    private String conaObservacao;
    @Column(name = "cona_radio", length = 50)
    private String conaRadio;
    @Column(name = "cona_texto", length = 100)
    private String conaTexto;
    @OneToMany(mappedBy = "conaContato")
    private Collection<RconReferenciaContato> rconReferenciaContatoCollection;
    @OneToMany(mappedBy = "conaContato")
    private Collection<PconPessoaContato> pconPessoaContatoCollection;

    public ConaContato() {
    }

    public ConaContato(Integer conaCodigo) {
        this.conaCodigo = conaCodigo;
    }

    public Integer getConaCodigo() {
        return conaCodigo;
    }

    public void setConaCodigo(Integer conaCodigo) {
        this.conaCodigo = conaCodigo;
    }

    public Date getConaDataCadastro() {
        return conaDataCadastro;
    }

    public void setConaDataCadastro(Date conaDataCadastro) {
        this.conaDataCadastro = conaDataCadastro;
    }

    public Integer getConaCodigoGr() {
        return conaCodigoGr;
    }

    public void setConaCodigoGr(Integer conaCodigoGr) {
        this.conaCodigoGr = conaCodigoGr;
    }

    public Character getConaImportado() {
        return conaImportado;
    }

    public void setConaImportado(Character conaImportado) {
        this.conaImportado = conaImportado;
    }

    public String getConaTelefone1() {
        return conaTelefone1;
    }

    public void setConaTelefone1(String conaTelefone1) {
        this.conaTelefone1 = conaTelefone1;
    }

    public String getConaTelefone2() {
        return conaTelefone2;
    }

    public void setConaTelefone2(String conaTelefone2) {
        this.conaTelefone2 = conaTelefone2;
    }

    public String getConaTelefone3() {
        return conaTelefone3;
    }

    public void setConaTelefone3(String conaTelefone3) {
        this.conaTelefone3 = conaTelefone3;
    }

    public String getConaEmail() {
        return conaEmail;
    }

    public void setConaEmail(String conaEmail) {
        this.conaEmail = conaEmail;
    }

    public String getConaObservacao() {
        return conaObservacao;
    }

    public void setConaObservacao(String conaObservacao) {
        this.conaObservacao = conaObservacao;
    }

    public String getConaRadio() {
        return conaRadio;
    }

    public void setConaRadio(String conaRadio) {
        this.conaRadio = conaRadio;
    }

    public String getConaTexto() {
        return conaTexto;
    }

    public void setConaTexto(String conaTexto) {
        this.conaTexto = conaTexto;
    }

    public Collection<RconReferenciaContato> getRconReferenciaContatoCollection() {
        return rconReferenciaContatoCollection;
    }

    public void setRconReferenciaContatoCollection(Collection<RconReferenciaContato> rconReferenciaContatoCollection) {
        this.rconReferenciaContatoCollection = rconReferenciaContatoCollection;
    }

    public Collection<PconPessoaContato> getPconPessoaContatoCollection() {
        return pconPessoaContatoCollection;
    }

    public void setPconPessoaContatoCollection(Collection<PconPessoaContato> pconPessoaContatoCollection) {
        this.pconPessoaContatoCollection = pconPessoaContatoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conaCodigo != null ? conaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConaContato)) {
            return false;
        }
        ConaContato other = (ConaContato) object;
        if ((this.conaCodigo == null && other.conaCodigo != null) || (this.conaCodigo != null && !this.conaCodigo.equals(other.conaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.ConaContato[conaCodigo=" + conaCodigo + "]";
    }

}
