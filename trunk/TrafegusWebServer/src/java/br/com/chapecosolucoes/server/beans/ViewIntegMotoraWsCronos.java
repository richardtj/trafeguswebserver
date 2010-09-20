/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "view_integ_motora_ws_cronos", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findAll", query = "SELECT v FROM ViewIntegMotoraWsCronos v"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByPackId", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.packId = :packId"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByIntegrator", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.integrator = :integrator"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByAccount", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.account = :account"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByNome", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.nome = :nome"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByCnh", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.cnh = :cnh"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByValidadeCnh", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.validadeCnh = :validadeCnh"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByCpf", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.cpf = :cpf"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByRg", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.rg = :rg"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByCidade", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByUf", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.uf = :uf"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByRua", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.rua = :rua"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByNumero", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.numero = :numero"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByBairro", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.bairro = :bairro"),
    @NamedQuery(name = "ViewIntegMotoraWsCronos.findByCep", query = "SELECT v FROM ViewIntegMotoraWsCronos v WHERE v.cep = :cep")})
public class ViewIntegMotoraWsCronos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackId")
    private Integer packId;
    @Column(name = "Integrator")
    private Integer integrator;
    @Column(name = "Account")
    private Integer account;
    @Column(name = "Nome", length = 50)
    private String nome;
    @Column(name = "Cnh", length = 25)
    private String cnh;
    @Column(name = "ValidadeCnh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validadeCnh;
    @Column(name = "Cpf", length = 20)
    private String cpf;
    @Column(name = "Rg", length = 20)
    private String rg;
    @Column(name = "Cidade", length = 100)
    private String cidade;
    @Column(name = "Uf", length = 100)
    private String uf;
    @Column(name = "Rua", length = 200)
    private String rua;
    @Column(name = "Numero", length = 10)
    private String numero;
    @Column(name = "Bairro", length = 100)
    private String bairro;
    @Column(name = "Cep", length = 8)
    private String cep;
    @Lob
    @Column(name = "Titular")
    private Object titular;

    public ViewIntegMotoraWsCronos() {
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    public Integer getIntegrator() {
        return integrator;
    }

    public void setIntegrator(Integer integrator) {
        this.integrator = integrator;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Date getValidadeCnh() {
        return validadeCnh;
    }

    public void setValidadeCnh(Date validadeCnh) {
        this.validadeCnh = validadeCnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Object getTitular() {
        return titular;
    }

    public void setTitular(Object titular) {
        this.titular = titular;
    }

}
