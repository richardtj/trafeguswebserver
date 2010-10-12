/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.vo;

/**
 *
 * @author Emerson
 */
public class SolicitaAcessoVO {

    private Integer codigo;
    private String nome;
    private String login;
    private Integer codPessoa;

    public SolicitaAcessoVO() {
    }

    public SolicitaAcessoVO(Integer codigo, String nome, String login, Integer codPessoa) {
        this.codigo = codigo;
        this.nome = nome;
        this.login = login;
        this.codPessoa = codPessoa;
    }

    public Integer getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Integer codPessoa) {
        this.codPessoa = codPessoa;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
