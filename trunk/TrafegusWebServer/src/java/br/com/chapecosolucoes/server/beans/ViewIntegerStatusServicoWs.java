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
@Table(name = "view_integer_status_servico_ws")
@NamedQueries({
    @NamedQuery(name = "ViewIntegerStatusServicoWs.findAll", query = "SELECT v FROM ViewIntegerStatusServicoWs v")})
public class ViewIntegerStatusServicoWs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "CodConta")
    private Integer codConta;
    @Column(name = "Servico", length = 50)
    private String servico;
    @Column(name = "DataAtualiza")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualiza;
    @Column(name = "Tolerancia")
    private Integer tolerancia;
    @Column(name = "Servidor", length = 50)
    private String servidor;
    @Column(name = "PathServico", length = 500)
    private String pathServico;
    @Column(name = "Excecao")
    private Integer excecao;

    public ViewIntegerStatusServicoWs() {
    }

    public Integer getCodConta() {
        return codConta;
    }

    public void setCodConta(Integer codConta) {
        this.codConta = codConta;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Date getDataAtualiza() {
        return dataAtualiza;
    }

    public void setDataAtualiza(Date dataAtualiza) {
        this.dataAtualiza = dataAtualiza;
    }

    public Integer getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(Integer tolerancia) {
        this.tolerancia = tolerancia;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getPathServico() {
        return pathServico;
    }

    public void setPathServico(String pathServico) {
        this.pathServico = pathServico;
    }

    public Integer getExcecao() {
        return excecao;
    }

    public void setExcecao(Integer excecao) {
        this.excecao = excecao;
    }

}
