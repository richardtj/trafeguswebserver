/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "tecn_tecnologia")
@NamedQueries({
    @NamedQuery(name = "TecnTecnologia.findAll", query = "SELECT t FROM TecnTecnologia t")})
public class TecnTecnologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tecn_codigo", nullable = false)
    private Integer tecnCodigo;
    @Column(name = "tecn_descricao", length = 50)
    private String tecnDescricao;
    @Column(name = "tecn_endereco_ip", length = 15)
    private String tecnEnderecoIp;
    @Column(name = "tecn_endereco_ip_alternativo", length = 15)
    private String tecnEnderecoIpAlternativo;
    @Column(name = "tecn_porta_entrada")
    private Integer tecnPortaEntrada;
    @Column(name = "tecn_porta_saida")
    private Integer tecnPortaSaida;
    @Column(name = "tecn_servidor", length = 20)
    private String tecnServidor;
    @Column(name = "tecn_codigo_central", length = 15)
    private String tecnCodigoCentral;
    @Column(name = "tecn_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tecnDataCadastro;
    @Column(name = "tecn_codigo_gr")
    private Integer tecnCodigoGr;
    @Column(name = "tecn_importado")
    private Character tecnImportado;
    @Column(name = "tecn_tolerancia")
    private Integer tecnTolerancia;
    @OneToMany(mappedBy = "tecnTecnologia")
    private Collection<VtecVersaoTecnologia> vtecVersaoTecnologiaCollection;
    @OneToMany(mappedBy = "tecnTecnologia")
    private Collection<SicoServicoIntegracaoConf> sicoServicoIntegracaoConfCollection;
    @OneToMany(mappedBy = "tecnTecnologia")
    private Collection<CtecContaTecnologia> ctecContaTecnologiaCollection;

    public TecnTecnologia() {
    }

    public TecnTecnologia(Integer tecnCodigo) {
        this.tecnCodigo = tecnCodigo;
    }

    public Integer getTecnCodigo() {
        return tecnCodigo;
    }

    public void setTecnCodigo(Integer tecnCodigo) {
        this.tecnCodigo = tecnCodigo;
    }

    public String getTecnDescricao() {
        return tecnDescricao;
    }

    public void setTecnDescricao(String tecnDescricao) {
        this.tecnDescricao = tecnDescricao;
    }

    public String getTecnEnderecoIp() {
        return tecnEnderecoIp;
    }

    public void setTecnEnderecoIp(String tecnEnderecoIp) {
        this.tecnEnderecoIp = tecnEnderecoIp;
    }

    public String getTecnEnderecoIpAlternativo() {
        return tecnEnderecoIpAlternativo;
    }

    public void setTecnEnderecoIpAlternativo(String tecnEnderecoIpAlternativo) {
        this.tecnEnderecoIpAlternativo = tecnEnderecoIpAlternativo;
    }

    public Integer getTecnPortaEntrada() {
        return tecnPortaEntrada;
    }

    public void setTecnPortaEntrada(Integer tecnPortaEntrada) {
        this.tecnPortaEntrada = tecnPortaEntrada;
    }

    public Integer getTecnPortaSaida() {
        return tecnPortaSaida;
    }

    public void setTecnPortaSaida(Integer tecnPortaSaida) {
        this.tecnPortaSaida = tecnPortaSaida;
    }

    public String getTecnServidor() {
        return tecnServidor;
    }

    public void setTecnServidor(String tecnServidor) {
        this.tecnServidor = tecnServidor;
    }

    public String getTecnCodigoCentral() {
        return tecnCodigoCentral;
    }

    public void setTecnCodigoCentral(String tecnCodigoCentral) {
        this.tecnCodigoCentral = tecnCodigoCentral;
    }

    public Date getTecnDataCadastro() {
        return tecnDataCadastro;
    }

    public void setTecnDataCadastro(Date tecnDataCadastro) {
        this.tecnDataCadastro = tecnDataCadastro;
    }

    public Integer getTecnCodigoGr() {
        return tecnCodigoGr;
    }

    public void setTecnCodigoGr(Integer tecnCodigoGr) {
        this.tecnCodigoGr = tecnCodigoGr;
    }

    public Character getTecnImportado() {
        return tecnImportado;
    }

    public void setTecnImportado(Character tecnImportado) {
        this.tecnImportado = tecnImportado;
    }

    public Integer getTecnTolerancia() {
        return tecnTolerancia;
    }

    public void setTecnTolerancia(Integer tecnTolerancia) {
        this.tecnTolerancia = tecnTolerancia;
    }

    public Collection<VtecVersaoTecnologia> getVtecVersaoTecnologiaCollection() {
        return vtecVersaoTecnologiaCollection;
    }

    public void setVtecVersaoTecnologiaCollection(Collection<VtecVersaoTecnologia> vtecVersaoTecnologiaCollection) {
        this.vtecVersaoTecnologiaCollection = vtecVersaoTecnologiaCollection;
    }

    public Collection<SicoServicoIntegracaoConf> getSicoServicoIntegracaoConfCollection() {
        return sicoServicoIntegracaoConfCollection;
    }

    public void setSicoServicoIntegracaoConfCollection(Collection<SicoServicoIntegracaoConf> sicoServicoIntegracaoConfCollection) {
        this.sicoServicoIntegracaoConfCollection = sicoServicoIntegracaoConfCollection;
    }

    public Collection<CtecContaTecnologia> getCtecContaTecnologiaCollection() {
        return ctecContaTecnologiaCollection;
    }

    public void setCtecContaTecnologiaCollection(Collection<CtecContaTecnologia> ctecContaTecnologiaCollection) {
        this.ctecContaTecnologiaCollection = ctecContaTecnologiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tecnCodigo != null ? tecnCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnTecnologia)) {
            return false;
        }
        TecnTecnologia other = (TecnTecnologia) object;
        if ((this.tecnCodigo == null && other.tecnCodigo != null) || (this.tecnCodigo != null && !this.tecnCodigo.equals(other.tecnCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.server.beans.TecnTecnologia[tecnCodigo=" + tecnCodigo + "]";
    }

}
