/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "view_veiculo_motorista")
@NamedQueries({
    @NamedQuery(name = "ViewVeiculoMotorista.findAll", query = "SELECT v FROM ViewVeiculoMotorista v")})
public class ViewVeiculoMotorista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "veic_oras_codigo")
    private Integer veicOrasCodigo;
    @Column(name = "pess_nome", length = 50)
    private String pessNome;
    @Column(name = "pess_numero", length = 10)
    private String pessNumero;
    @Column(name = "mot_categoria_cnh", length = 10)
    private String motCategoriaCnh;
    @Column(name = "mot_numero_cnh", length = 25)
    private String motNumeroCnh;
    @Column(name = "mot_senha", length = 15)
    private String motSenha;
    @Column(name = "mot_treinado")
    private Character motTreinado;
    @Column(name = "mot_ultimo_treinamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date motUltimoTreinamento;
    @Column(name = "mot_validade_cnh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date motValidadeCnh;
    @Column(name = "mot_validade_pesquisa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date motValidadePesquisa;
    @Column(name = "pfis_cpf", length = 20)
    private String pfisCpf;
    @Column(name = "pfis_data_nascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pfisDataNascimento;
    @Column(name = "pfis_rg", length = 20)
    private String pfisRg;
    @Column(name = "pfis_sexo", length = 10)
    private String pfisSexo;
    @Column(name = "logr_cep", length = 8)
    private String logrCep;
    @Column(name = "logr_complemento", length = 100)
    private String logrComplemento;
    @Column(name = "endereco", length = 200)
    private String endereco;
    @Column(name = "bairro", length = 100)
    private String bairro;
    @Column(name = "cidade", length = 100)
    private String cidade;
    @Column(name = "estado", length = 100)
    private String estado;
    @Column(name = "esta_sigla", length = 2)
    private String estaSigla;
    @Column(name = "pais", length = 50)
    private String pais;

    public ViewVeiculoMotorista() {
    }

    public Integer getVeicOrasCodigo() {
        return veicOrasCodigo;
    }

    public void setVeicOrasCodigo(Integer veicOrasCodigo) {
        this.veicOrasCodigo = veicOrasCodigo;
    }

    public String getPessNome() {
        return pessNome;
    }

    public void setPessNome(String pessNome) {
        this.pessNome = pessNome;
    }

    public String getPessNumero() {
        return pessNumero;
    }

    public void setPessNumero(String pessNumero) {
        this.pessNumero = pessNumero;
    }

    public String getMotCategoriaCnh() {
        return motCategoriaCnh;
    }

    public void setMotCategoriaCnh(String motCategoriaCnh) {
        this.motCategoriaCnh = motCategoriaCnh;
    }

    public String getMotNumeroCnh() {
        return motNumeroCnh;
    }

    public void setMotNumeroCnh(String motNumeroCnh) {
        this.motNumeroCnh = motNumeroCnh;
    }

    public String getMotSenha() {
        return motSenha;
    }

    public void setMotSenha(String motSenha) {
        this.motSenha = motSenha;
    }

    public Character getMotTreinado() {
        return motTreinado;
    }

    public void setMotTreinado(Character motTreinado) {
        this.motTreinado = motTreinado;
    }

    public Date getMotUltimoTreinamento() {
        return motUltimoTreinamento;
    }

    public void setMotUltimoTreinamento(Date motUltimoTreinamento) {
        this.motUltimoTreinamento = motUltimoTreinamento;
    }

    public Date getMotValidadeCnh() {
        return motValidadeCnh;
    }

    public void setMotValidadeCnh(Date motValidadeCnh) {
        this.motValidadeCnh = motValidadeCnh;
    }

    public Date getMotValidadePesquisa() {
        return motValidadePesquisa;
    }

    public void setMotValidadePesquisa(Date motValidadePesquisa) {
        this.motValidadePesquisa = motValidadePesquisa;
    }

    public String getPfisCpf() {
        return pfisCpf;
    }

    public void setPfisCpf(String pfisCpf) {
        this.pfisCpf = pfisCpf;
    }

    public Date getPfisDataNascimento() {
        return pfisDataNascimento;
    }

    public void setPfisDataNascimento(Date pfisDataNascimento) {
        this.pfisDataNascimento = pfisDataNascimento;
    }

    public String getPfisRg() {
        return pfisRg;
    }

    public void setPfisRg(String pfisRg) {
        this.pfisRg = pfisRg;
    }

    public String getPfisSexo() {
        return pfisSexo;
    }

    public void setPfisSexo(String pfisSexo) {
        this.pfisSexo = pfisSexo;
    }

    public String getLogrCep() {
        return logrCep;
    }

    public void setLogrCep(String logrCep) {
        this.logrCep = logrCep;
    }

    public String getLogrComplemento() {
        return logrComplemento;
    }

    public void setLogrComplemento(String logrComplemento) {
        this.logrComplemento = logrComplemento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstaSigla() {
        return estaSigla;
    }

    public void setEstaSigla(String estaSigla) {
        this.estaSigla = estaSigla;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
