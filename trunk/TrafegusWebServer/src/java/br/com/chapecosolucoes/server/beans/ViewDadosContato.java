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
@Table(name = "view_dados_contato", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewDadosContato.findAll", query = "SELECT v FROM ViewDadosContato v"),
    @NamedQuery(name = "ViewDadosContato.findByPconPessOrasCodigo", query = "SELECT v FROM ViewDadosContato v WHERE v.pconPessOrasCodigo = :pconPessOrasCodigo"),
    @NamedQuery(name = "ViewDadosContato.findByConaTexto", query = "SELECT v FROM ViewDadosContato v WHERE v.conaTexto = :conaTexto"),
    @NamedQuery(name = "ViewDadosContato.findByConaEmail", query = "SELECT v FROM ViewDadosContato v WHERE v.conaEmail = :conaEmail"),
    @NamedQuery(name = "ViewDadosContato.findByConaTelefone1", query = "SELECT v FROM ViewDadosContato v WHERE v.conaTelefone1 = :conaTelefone1"),
    @NamedQuery(name = "ViewDadosContato.findByConaTelefone2", query = "SELECT v FROM ViewDadosContato v WHERE v.conaTelefone2 = :conaTelefone2"),
    @NamedQuery(name = "ViewDadosContato.findByConaTelefone3", query = "SELECT v FROM ViewDadosContato v WHERE v.conaTelefone3 = :conaTelefone3"),
    @NamedQuery(name = "ViewDadosContato.findByConaObservacao", query = "SELECT v FROM ViewDadosContato v WHERE v.conaObservacao = :conaObservacao")})
public class ViewDadosContato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "pcon_pess_oras_codigo")
    private Integer pconPessOrasCodigo;
    @Column(name = "cona_texto", length = 100)
    private String conaTexto;
    @Column(name = "cona_email", length = 100)
    private String conaEmail;
    @Column(name = "cona_telefone_1", length = 30)
    private String conaTelefone1;
    @Column(name = "cona_telefone_2", length = 30)
    private String conaTelefone2;
    @Column(name = "cona_telefone_3", length = 30)
    private String conaTelefone3;
    @Column(name = "cona_observacao", length = 5000)
    private String conaObservacao;

    public ViewDadosContato() {
    }

    public Integer getPconPessOrasCodigo() {
        return pconPessOrasCodigo;
    }

    public void setPconPessOrasCodigo(Integer pconPessOrasCodigo) {
        this.pconPessOrasCodigo = pconPessOrasCodigo;
    }

    public String getConaTexto() {
        return conaTexto;
    }

    public void setConaTexto(String conaTexto) {
        this.conaTexto = conaTexto;
    }

    public String getConaEmail() {
        return conaEmail;
    }

    public void setConaEmail(String conaEmail) {
        this.conaEmail = conaEmail;
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

    public String getConaObservacao() {
        return conaObservacao;
    }

    public void setConaObservacao(String conaObservacao) {
        this.conaObservacao = conaObservacao;
    }

}
