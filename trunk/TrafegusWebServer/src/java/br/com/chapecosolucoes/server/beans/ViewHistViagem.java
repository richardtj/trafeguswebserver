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
@Table(name = "view_hist_viagem")
@NamedQueries({
    @NamedQuery(name = "ViewHistViagem.findAll", query = "SELECT v FROM ViewHistViagem v")})
public class ViewHistViagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "viag_codigo")
    private Integer viagCodigo;
    @Column(name = "identificador", length = 2147483647)
    private String identificador;
    @Column(name = "term_numero_terminal", length = 30)
    private String termNumeroTerminal;
    @Column(name = "viag_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagDataInicio;
    @Column(name = "viag_data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viagDataFim;
    @Column(name = "transportador", length = 50)
    private String transportador;
    @Column(name = "embarcador", length = 50)
    private String embarcador;
    @Column(name = "viag_emba_pjur_pess_oras_codigo")
    private Integer viagEmbaPjurPessOrasCodigo;
    @Column(name = "viag_tran_pess_oras_codigo")
    private Integer viagTranPessOrasCodigo;
    @Column(name = "term_codigo")
    private Integer termCodigo;

    public ViewHistViagem() {
    }

    public Integer getViagCodigo() {
        return viagCodigo;
    }

    public void setViagCodigo(Integer viagCodigo) {
        this.viagCodigo = viagCodigo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTermNumeroTerminal() {
        return termNumeroTerminal;
    }

    public void setTermNumeroTerminal(String termNumeroTerminal) {
        this.termNumeroTerminal = termNumeroTerminal;
    }

    public Date getViagDataInicio() {
        return viagDataInicio;
    }

    public void setViagDataInicio(Date viagDataInicio) {
        this.viagDataInicio = viagDataInicio;
    }

    public Date getViagDataFim() {
        return viagDataFim;
    }

    public void setViagDataFim(Date viagDataFim) {
        this.viagDataFim = viagDataFim;
    }

    public String getTransportador() {
        return transportador;
    }

    public void setTransportador(String transportador) {
        this.transportador = transportador;
    }

    public String getEmbarcador() {
        return embarcador;
    }

    public void setEmbarcador(String embarcador) {
        this.embarcador = embarcador;
    }

    public Integer getViagEmbaPjurPessOrasCodigo() {
        return viagEmbaPjurPessOrasCodigo;
    }

    public void setViagEmbaPjurPessOrasCodigo(Integer viagEmbaPjurPessOrasCodigo) {
        this.viagEmbaPjurPessOrasCodigo = viagEmbaPjurPessOrasCodigo;
    }

    public Integer getViagTranPessOrasCodigo() {
        return viagTranPessOrasCodigo;
    }

    public void setViagTranPessOrasCodigo(Integer viagTranPessOrasCodigo) {
        this.viagTranPessOrasCodigo = viagTranPessOrasCodigo;
    }

    public Integer getTermCodigo() {
        return termCodigo;
    }

    public void setTermCodigo(Integer termCodigo) {
        this.termCodigo = termCodigo;
    }

}
