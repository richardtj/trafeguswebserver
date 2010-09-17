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
@Table(name = "view_pgr_em_viagem")
@NamedQueries({
    @NamedQuery(name = "ViewPgrEmViagem.findAll", query = "SELECT v FROM ViewPgrEmViagem v")})
public class ViewPgrEmViagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "viag_codigo")
    private Integer viagCodigo;
    @Column(name = "pgpg_descricao", length = 100)
    private String pgpgDescricao;
    @Column(name = "pgpg_codigo")
    private Integer pgpgCodigo;
    @Column(name = "pipa_descricao", length = 50)
    private String pipaDescricao;
    @Column(name = "pite_descricao", length = 150)
    private String piteDescricao;

    public ViewPgrEmViagem() {
    }

    public Integer getViagCodigo() {
        return viagCodigo;
    }

    public void setViagCodigo(Integer viagCodigo) {
        this.viagCodigo = viagCodigo;
    }

    public String getPgpgDescricao() {
        return pgpgDescricao;
    }

    public void setPgpgDescricao(String pgpgDescricao) {
        this.pgpgDescricao = pgpgDescricao;
    }

    public Integer getPgpgCodigo() {
        return pgpgCodigo;
    }

    public void setPgpgCodigo(Integer pgpgCodigo) {
        this.pgpgCodigo = pgpgCodigo;
    }

    public String getPipaDescricao() {
        return pipaDescricao;
    }

    public void setPipaDescricao(String pipaDescricao) {
        this.pipaDescricao = pipaDescricao;
    }

    public String getPiteDescricao() {
        return piteDescricao;
    }

    public void setPiteDescricao(String piteDescricao) {
        this.piteDescricao = piteDescricao;
    }

}
