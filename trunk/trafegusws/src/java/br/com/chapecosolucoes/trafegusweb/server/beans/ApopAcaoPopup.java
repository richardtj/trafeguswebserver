/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "apop_acao_popup")
@NamedQueries({
    @NamedQuery(name = "ApopAcaoPopup.findAll", query = "SELECT a FROM ApopAcaoPopup a"),
    @NamedQuery(name = "ApopAcaoPopup.findByApopApadCodigo", query = "SELECT a FROM ApopAcaoPopup a WHERE a.apopApadCodigo = :apopApadCodigo"),
    @NamedQuery(name = "ApopAcaoPopup.findByApopCor", query = "SELECT a FROM ApopAcaoPopup a WHERE a.apopCor = :apopCor"),
    @NamedQuery(name = "ApopAcaoPopup.findByApopTitulo", query = "SELECT a FROM ApopAcaoPopup a WHERE a.apopTitulo = :apopTitulo"),
    @NamedQuery(name = "ApopAcaoPopup.findByApopAltura", query = "SELECT a FROM ApopAcaoPopup a WHERE a.apopAltura = :apopAltura"),
    @NamedQuery(name = "ApopAcaoPopup.findByApopLargura", query = "SELECT a FROM ApopAcaoPopup a WHERE a.apopLargura = :apopLargura")})
public class ApopAcaoPopup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "apop_apad_codigo")
    private Integer apopApadCodigo;
    @Column(name = "apop_cor")
    private Integer apopCor;
    @Column(name = "apop_titulo")
    private String apopTitulo;
    @Column(name = "apop_altura")
    private Integer apopAltura;
    @Column(name = "apop_largura")
    private Integer apopLargura;
    @JoinColumn(name = "apop_apad_codigo", referencedColumnName = "apad_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ApadAcaoPadrao apadAcaoPadrao;

    public ApopAcaoPopup() {
    }

    public ApopAcaoPopup(Integer apopApadCodigo) {
        this.apopApadCodigo = apopApadCodigo;
    }

    public Integer getApopApadCodigo() {
        return apopApadCodigo;
    }

    public void setApopApadCodigo(Integer apopApadCodigo) {
        this.apopApadCodigo = apopApadCodigo;
    }

    public Integer getApopCor() {
        return apopCor;
    }

    public void setApopCor(Integer apopCor) {
        this.apopCor = apopCor;
    }

    public String getApopTitulo() {
        return apopTitulo;
    }

    public void setApopTitulo(String apopTitulo) {
        this.apopTitulo = apopTitulo;
    }

    public Integer getApopAltura() {
        return apopAltura;
    }

    public void setApopAltura(Integer apopAltura) {
        this.apopAltura = apopAltura;
    }

    public Integer getApopLargura() {
        return apopLargura;
    }

    public void setApopLargura(Integer apopLargura) {
        this.apopLargura = apopLargura;
    }

    public ApadAcaoPadrao getApadAcaoPadrao() {
        return apadAcaoPadrao;
    }

    public void setApadAcaoPadrao(ApadAcaoPadrao apadAcaoPadrao) {
        this.apadAcaoPadrao = apadAcaoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apopApadCodigo != null ? apopApadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApopAcaoPopup)) {
            return false;
        }
        ApopAcaoPopup other = (ApopAcaoPopup) object;
        if ((this.apopApadCodigo == null && other.apopApadCodigo != null) || (this.apopApadCodigo != null && !this.apopApadCodigo.equals(other.apopApadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.ApopAcaoPopup[apopApadCodigo=" + apopApadCodigo + "]";
    }

}
