/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "view_oras_pgpg_pgai")
@NamedQueries({
    @NamedQuery(name = "ViewOrasPgpgPgai.findAll", query = "SELECT v FROM ViewOrasPgpgPgai v")})
public class ViewOrasPgpgPgai implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "oras_codigo")
    private Integer orasCodigo;
    @Column(name = "pgpg_codigo")
    private Integer pgpgCodigo;
    @Column(name = "pgai_codigo")
    private Integer pgaiCodigo;
    @Column(name = "pite_codigo")
    private Integer piteCodigo;

    public ViewOrasPgpgPgai() {
    }

    public Integer getOrasCodigo() {
        return orasCodigo;
    }

    public void setOrasCodigo(Integer orasCodigo) {
        this.orasCodigo = orasCodigo;
    }

    public Integer getPgpgCodigo() {
        return pgpgCodigo;
    }

    public void setPgpgCodigo(Integer pgpgCodigo) {
        this.pgpgCodigo = pgpgCodigo;
    }

    public Integer getPgaiCodigo() {
        return pgaiCodigo;
    }

    public void setPgaiCodigo(Integer pgaiCodigo) {
        this.pgaiCodigo = pgaiCodigo;
    }

    public Integer getPiteCodigo() {
        return piteCodigo;
    }

    public void setPiteCodigo(Integer piteCodigo) {
        this.piteCodigo = piteCodigo;
    }

}
