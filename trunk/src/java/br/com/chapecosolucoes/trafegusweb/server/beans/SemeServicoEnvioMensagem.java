/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "seme_servico_envio_mensagem", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SemeServicoEnvioMensagem.findAll", query = "SELECT s FROM SemeServicoEnvioMensagem s"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeCodigo", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeCodigo = :semeCodigo"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeDescricao", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeDescricao = :semeDescricao"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeDataHora", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeDataHora = :semeDataHora"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeDomingo", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeDomingo = :semeDomingo"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeSegunda", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeSegunda = :semeSegunda"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeTerca", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeTerca = :semeTerca"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeQuarta", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeQuarta = :semeQuarta"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeQuinta", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeQuinta = :semeQuinta"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeSexta", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeSexta = :semeSexta"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeSabado", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeSabado = :semeSabado"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeDataCadastro", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeDataCadastro = :semeDataCadastro"),
    @NamedQuery(name = "SemeServicoEnvioMensagem.findBySemeDataEnvio", query = "SELECT s FROM SemeServicoEnvioMensagem s WHERE s.semeDataEnvio = :semeDataEnvio")})
public class SemeServicoEnvioMensagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "seme_codigo", nullable = false)
    private Integer semeCodigo;
    @Column(name = "seme_descricao", length = 50)
    private String semeDescricao;
    @Column(name = "seme_data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date semeDataHora;
    @Column(name = "seme_domingo")
    private Character semeDomingo;
    @Column(name = "seme_segunda")
    private Character semeSegunda;
    @Column(name = "seme_terca")
    private Character semeTerca;
    @Column(name = "seme_quarta")
    private Character semeQuarta;
    @Column(name = "seme_quinta")
    private Character semeQuinta;
    @Column(name = "seme_sexta")
    private Character semeSexta;
    @Column(name = "seme_sabado")
    private Character semeSabado;
    @Column(name = "seme_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date semeDataCadastro;
    @Column(name = "seme_data_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date semeDataEnvio;
    @JoinColumn(name = "seme_penv_codigo", referencedColumnName = "penv_codigo")
    @ManyToOne
    private PenvPeriodicidadeEnvio penvPeriodicidadeEnvio;
    @JoinColumn(name = "seme_leme_codigo", referencedColumnName = "leme_codigo")
    @ManyToOne
    private LemeListaEnvioMensagem lemeListaEnvioMensagem;

    public SemeServicoEnvioMensagem() {
    }

    public SemeServicoEnvioMensagem(Integer semeCodigo) {
        this.semeCodigo = semeCodigo;
    }

    public Integer getSemeCodigo() {
        return semeCodigo;
    }

    public void setSemeCodigo(Integer semeCodigo) {
        this.semeCodigo = semeCodigo;
    }

    public String getSemeDescricao() {
        return semeDescricao;
    }

    public void setSemeDescricao(String semeDescricao) {
        this.semeDescricao = semeDescricao;
    }

    public Date getSemeDataHora() {
        return semeDataHora;
    }

    public void setSemeDataHora(Date semeDataHora) {
        this.semeDataHora = semeDataHora;
    }

    public Character getSemeDomingo() {
        return semeDomingo;
    }

    public void setSemeDomingo(Character semeDomingo) {
        this.semeDomingo = semeDomingo;
    }

    public Character getSemeSegunda() {
        return semeSegunda;
    }

    public void setSemeSegunda(Character semeSegunda) {
        this.semeSegunda = semeSegunda;
    }

    public Character getSemeTerca() {
        return semeTerca;
    }

    public void setSemeTerca(Character semeTerca) {
        this.semeTerca = semeTerca;
    }

    public Character getSemeQuarta() {
        return semeQuarta;
    }

    public void setSemeQuarta(Character semeQuarta) {
        this.semeQuarta = semeQuarta;
    }

    public Character getSemeQuinta() {
        return semeQuinta;
    }

    public void setSemeQuinta(Character semeQuinta) {
        this.semeQuinta = semeQuinta;
    }

    public Character getSemeSexta() {
        return semeSexta;
    }

    public void setSemeSexta(Character semeSexta) {
        this.semeSexta = semeSexta;
    }

    public Character getSemeSabado() {
        return semeSabado;
    }

    public void setSemeSabado(Character semeSabado) {
        this.semeSabado = semeSabado;
    }

    public Date getSemeDataCadastro() {
        return semeDataCadastro;
    }

    public void setSemeDataCadastro(Date semeDataCadastro) {
        this.semeDataCadastro = semeDataCadastro;
    }

    public Date getSemeDataEnvio() {
        return semeDataEnvio;
    }

    public void setSemeDataEnvio(Date semeDataEnvio) {
        this.semeDataEnvio = semeDataEnvio;
    }

    public PenvPeriodicidadeEnvio getPenvPeriodicidadeEnvio() {
        return penvPeriodicidadeEnvio;
    }

    public void setPenvPeriodicidadeEnvio(PenvPeriodicidadeEnvio penvPeriodicidadeEnvio) {
        this.penvPeriodicidadeEnvio = penvPeriodicidadeEnvio;
    }

    public LemeListaEnvioMensagem getLemeListaEnvioMensagem() {
        return lemeListaEnvioMensagem;
    }

    public void setLemeListaEnvioMensagem(LemeListaEnvioMensagem lemeListaEnvioMensagem) {
        this.lemeListaEnvioMensagem = lemeListaEnvioMensagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semeCodigo != null ? semeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemeServicoEnvioMensagem)) {
            return false;
        }
        SemeServicoEnvioMensagem other = (SemeServicoEnvioMensagem) object;
        if ((this.semeCodigo == null && other.semeCodigo != null) || (this.semeCodigo != null && !this.semeCodigo.equals(other.semeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.SemeServicoEnvioMensagem[semeCodigo=" + semeCodigo + "]";
    }

}
