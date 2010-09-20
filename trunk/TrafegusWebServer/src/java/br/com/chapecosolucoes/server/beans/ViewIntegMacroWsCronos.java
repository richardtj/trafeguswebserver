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
@Table(name = "view_integ_macro_ws_cronos", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewIntegMacroWsCronos.findAll", query = "SELECT v FROM ViewIntegMacroWsCronos v"),
    @NamedQuery(name = "ViewIntegMacroWsCronos.findByPackId", query = "SELECT v FROM ViewIntegMacroWsCronos v WHERE v.packId = :packId"),
    @NamedQuery(name = "ViewIntegMacroWsCronos.findByIntegrator", query = "SELECT v FROM ViewIntegMacroWsCronos v WHERE v.integrator = :integrator"),
    @NamedQuery(name = "ViewIntegMacroWsCronos.findByAccount", query = "SELECT v FROM ViewIntegMacroWsCronos v WHERE v.account = :account"),
    @NamedQuery(name = "ViewIntegMacroWsCronos.findByCodEquipamento", query = "SELECT v FROM ViewIntegMacroWsCronos v WHERE v.codEquipamento = :codEquipamento"),
    @NamedQuery(name = "ViewIntegMacroWsCronos.findByMacroNumber", query = "SELECT v FROM ViewIntegMacroWsCronos v WHERE v.macroNumber = :macroNumber"),
    @NamedQuery(name = "ViewIntegMacroWsCronos.findByTitle", query = "SELECT v FROM ViewIntegMacroWsCronos v WHERE v.title = :title"),
    @NamedQuery(name = "ViewIntegMacroWsCronos.findByLabel", query = "SELECT v FROM ViewIntegMacroWsCronos v WHERE v.label = :label"),
    @NamedQuery(name = "ViewIntegMacroWsCronos.findByEnableMsgLivre", query = "SELECT v FROM ViewIntegMacroWsCronos v WHERE v.enableMsgLivre = :enableMsgLivre"),
    @NamedQuery(name = "ViewIntegMacroWsCronos.findByEnable", query = "SELECT v FROM ViewIntegMacroWsCronos v WHERE v.enable = :enable")})
public class ViewIntegMacroWsCronos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackId")
    private Integer packId;
    @Column(name = "Integrator")
    private Integer integrator;
    @Column(name = "Account")
    private Integer account;
    @Column(name = "CodEquipamento")
    private Integer codEquipamento;
    @Column(name = "MacroNumber", length = 10)
    private String macroNumber;
    @Column(name = "Title", length = 100)
    private String title;
    @Column(name = "Label", length = 500)
    private String label;
    @Column(name = "EnableMsgLivre")
    private Character enableMsgLivre;
    @Column(name = "Enable")
    private Integer enable;

    public ViewIntegMacroWsCronos() {
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

    public Integer getCodEquipamento() {
        return codEquipamento;
    }

    public void setCodEquipamento(Integer codEquipamento) {
        this.codEquipamento = codEquipamento;
    }

    public String getMacroNumber() {
        return macroNumber;
    }

    public void setMacroNumber(String macroNumber) {
        this.macroNumber = macroNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Character getEnableMsgLivre() {
        return enableMsgLivre;
    }

    public void setEnableMsgLivre(Character enableMsgLivre) {
        this.enableMsgLivre = enableMsgLivre;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

}
