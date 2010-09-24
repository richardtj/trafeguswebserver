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
@Table(name = "mint_mensagem_integracao", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "MintMensagemIntegracao.findAll", query = "SELECT m FROM MintMensagemIntegracao m"),
    @NamedQuery(name = "MintMensagemIntegracao.findByMintCodigo", query = "SELECT m FROM MintMensagemIntegracao m WHERE m.mintCodigo = :mintCodigo"),
    @NamedQuery(name = "MintMensagemIntegracao.findByMintMensagemIntegracao", query = "SELECT m FROM MintMensagemIntegracao m WHERE m.mintMensagemIntegracao = :mintMensagemIntegracao")})
public class MintMensagemIntegracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mint_codigo", nullable = false)
    private Integer mintCodigo;
    @Column(name = "mint_mensagem_integracao", length = 500)
    private String mintMensagemIntegracao;

    public MintMensagemIntegracao() {
    }

    public MintMensagemIntegracao(Integer mintCodigo) {
        this.mintCodigo = mintCodigo;
    }

    public Integer getMintCodigo() {
        return mintCodigo;
    }

    public void setMintCodigo(Integer mintCodigo) {
        this.mintCodigo = mintCodigo;
    }

    public String getMintMensagemIntegracao() {
        return mintMensagemIntegracao;
    }

    public void setMintMensagemIntegracao(String mintMensagemIntegracao) {
        this.mintMensagemIntegracao = mintMensagemIntegracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mintCodigo != null ? mintCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MintMensagemIntegracao)) {
            return false;
        }
        MintMensagemIntegracao other = (MintMensagemIntegracao) object;
        if ((this.mintCodigo == null && other.mintCodigo != null) || (this.mintCodigo != null && !this.mintCodigo.equals(other.mintCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.MintMensagemIntegracao[mintCodigo=" + mintCodigo + "]";
    }

}
