/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

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
@Table(name = "itri_imp_trafegus_risco", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ItriImpTrafegusRisco.findAll", query = "SELECT i FROM ItriImpTrafegusRisco i"),
    @NamedQuery(name = "ItriImpTrafegusRisco.findByItriCodigo", query = "SELECT i FROM ItriImpTrafegusRisco i WHERE i.itriCodigo = :itriCodigo"),
    @NamedQuery(name = "ItriImpTrafegusRisco.findByItriIdImportacao", query = "SELECT i FROM ItriImpTrafegusRisco i WHERE i.itriIdImportacao = :itriIdImportacao"),
    @NamedQuery(name = "ItriImpTrafegusRisco.findByItriIdCliente", query = "SELECT i FROM ItriImpTrafegusRisco i WHERE i.itriIdCliente = :itriIdCliente"),
    @NamedQuery(name = "ItriImpTrafegusRisco.findByItriInformacaoImportar", query = "SELECT i FROM ItriImpTrafegusRisco i WHERE i.itriInformacaoImportar = :itriInformacaoImportar"),
    @NamedQuery(name = "ItriImpTrafegusRisco.findByItriImportado", query = "SELECT i FROM ItriImpTrafegusRisco i WHERE i.itriImportado = :itriImportado"),
    @NamedQuery(name = "ItriImpTrafegusRisco.findByItriUltimoErro", query = "SELECT i FROM ItriImpTrafegusRisco i WHERE i.itriUltimoErro = :itriUltimoErro")})
public class ItriImpTrafegusRisco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "itri_codigo", nullable = false)
    private Integer itriCodigo;
    @Basic(optional = false)
    @Column(name = "itri_id_importacao", nullable = false, length = 4)
    private String itriIdImportacao;
    @Basic(optional = false)
    @Column(name = "itri_id_cliente", nullable = false, length = 10)
    private String itriIdCliente;
    @Basic(optional = false)
    @Column(name = "itri_informacao_importar", nullable = false, length = 2000)
    private String itriInformacaoImportar;
    @Column(name = "itri_importado")
    private Character itriImportado;
    @Column(name = "itri_ultimo_erro", length = 500)
    private String itriUltimoErro;

    public ItriImpTrafegusRisco() {
    }

    public ItriImpTrafegusRisco(Integer itriCodigo) {
        this.itriCodigo = itriCodigo;
    }

    public ItriImpTrafegusRisco(Integer itriCodigo, String itriIdImportacao, String itriIdCliente, String itriInformacaoImportar) {
        this.itriCodigo = itriCodigo;
        this.itriIdImportacao = itriIdImportacao;
        this.itriIdCliente = itriIdCliente;
        this.itriInformacaoImportar = itriInformacaoImportar;
    }

    public Integer getItriCodigo() {
        return itriCodigo;
    }

    public void setItriCodigo(Integer itriCodigo) {
        this.itriCodigo = itriCodigo;
    }

    public String getItriIdImportacao() {
        return itriIdImportacao;
    }

    public void setItriIdImportacao(String itriIdImportacao) {
        this.itriIdImportacao = itriIdImportacao;
    }

    public String getItriIdCliente() {
        return itriIdCliente;
    }

    public void setItriIdCliente(String itriIdCliente) {
        this.itriIdCliente = itriIdCliente;
    }

    public String getItriInformacaoImportar() {
        return itriInformacaoImportar;
    }

    public void setItriInformacaoImportar(String itriInformacaoImportar) {
        this.itriInformacaoImportar = itriInformacaoImportar;
    }

    public Character getItriImportado() {
        return itriImportado;
    }

    public void setItriImportado(Character itriImportado) {
        this.itriImportado = itriImportado;
    }

    public String getItriUltimoErro() {
        return itriUltimoErro;
    }

    public void setItriUltimoErro(String itriUltimoErro) {
        this.itriUltimoErro = itriUltimoErro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itriCodigo != null ? itriCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItriImpTrafegusRisco)) {
            return false;
        }
        ItriImpTrafegusRisco other = (ItriImpTrafegusRisco) object;
        if ((this.itriCodigo == null && other.itriCodigo != null) || (this.itriCodigo != null && !this.itriCodigo.equals(other.itriCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.ItriImpTrafegusRisco[itriCodigo=" + itriCodigo + "]";
    }

}
