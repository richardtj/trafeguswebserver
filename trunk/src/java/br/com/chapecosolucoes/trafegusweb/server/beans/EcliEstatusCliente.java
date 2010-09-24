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
@Table(name = "ecli_estatus_cliente", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EcliEstatusCliente.findAll", query = "SELECT e FROM EcliEstatusCliente e"),
    @NamedQuery(name = "EcliEstatusCliente.findByEcliCodigo", query = "SELECT e FROM EcliEstatusCliente e WHERE e.ecliCodigo = :ecliCodigo"),
    @NamedQuery(name = "EcliEstatusCliente.findByEcliScriCodigo", query = "SELECT e FROM EcliEstatusCliente e WHERE e.ecliScriCodigo = :ecliScriCodigo"),
    @NamedQuery(name = "EcliEstatusCliente.findByEcliScriVersaoAtualizada", query = "SELECT e FROM EcliEstatusCliente e WHERE e.ecliScriVersaoAtualizada = :ecliScriVersaoAtualizada"),
    @NamedQuery(name = "EcliEstatusCliente.findByEcliErros", query = "SELECT e FROM EcliEstatusCliente e WHERE e.ecliErros = :ecliErros"),
    @NamedQuery(name = "EcliEstatusCliente.findByEcliEstatus", query = "SELECT e FROM EcliEstatusCliente e WHERE e.ecliEstatus = :ecliEstatus"),
    @NamedQuery(name = "EcliEstatusCliente.findByEcliEstaCodigo", query = "SELECT e FROM EcliEstatusCliente e WHERE e.ecliEstaCodigo = :ecliEstaCodigo"),
    @NamedQuery(name = "EcliEstatusCliente.findByEcliEstaEstatus", query = "SELECT e FROM EcliEstatusCliente e WHERE e.ecliEstaEstatus = :ecliEstaEstatus")})
public class EcliEstatusCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ecli_codigo", nullable = false)
    private Integer ecliCodigo;
    @Column(name = "ecli_scri_codigo")
    private Integer ecliScriCodigo;
    @Column(name = "ecli_scri_versao_atualizada")
    private Integer ecliScriVersaoAtualizada;
    @Column(name = "ecli_erros", length = 5000)
    private String ecliErros;
    @Column(name = "ecli_estatus", length = 10)
    private String ecliEstatus;
    @Column(name = "ecli_esta_codigo")
    private Integer ecliEstaCodigo;
    @Column(name = "ecli_esta_estatus")
    private Integer ecliEstaEstatus;

    public EcliEstatusCliente() {
    }

    public EcliEstatusCliente(Integer ecliCodigo) {
        this.ecliCodigo = ecliCodigo;
    }

    public Integer getEcliCodigo() {
        return ecliCodigo;
    }

    public void setEcliCodigo(Integer ecliCodigo) {
        this.ecliCodigo = ecliCodigo;
    }

    public Integer getEcliScriCodigo() {
        return ecliScriCodigo;
    }

    public void setEcliScriCodigo(Integer ecliScriCodigo) {
        this.ecliScriCodigo = ecliScriCodigo;
    }

    public Integer getEcliScriVersaoAtualizada() {
        return ecliScriVersaoAtualizada;
    }

    public void setEcliScriVersaoAtualizada(Integer ecliScriVersaoAtualizada) {
        this.ecliScriVersaoAtualizada = ecliScriVersaoAtualizada;
    }

    public String getEcliErros() {
        return ecliErros;
    }

    public void setEcliErros(String ecliErros) {
        this.ecliErros = ecliErros;
    }

    public String getEcliEstatus() {
        return ecliEstatus;
    }

    public void setEcliEstatus(String ecliEstatus) {
        this.ecliEstatus = ecliEstatus;
    }

    public Integer getEcliEstaCodigo() {
        return ecliEstaCodigo;
    }

    public void setEcliEstaCodigo(Integer ecliEstaCodigo) {
        this.ecliEstaCodigo = ecliEstaCodigo;
    }

    public Integer getEcliEstaEstatus() {
        return ecliEstaEstatus;
    }

    public void setEcliEstaEstatus(Integer ecliEstaEstatus) {
        this.ecliEstaEstatus = ecliEstaEstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecliCodigo != null ? ecliCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EcliEstatusCliente)) {
            return false;
        }
        EcliEstatusCliente other = (EcliEstatusCliente) object;
        if ((this.ecliCodigo == null && other.ecliCodigo != null) || (this.ecliCodigo != null && !this.ecliCodigo.equals(other.ecliCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.EcliEstatusCliente[ecliCodigo=" + ecliCodigo + "]";
    }

}
