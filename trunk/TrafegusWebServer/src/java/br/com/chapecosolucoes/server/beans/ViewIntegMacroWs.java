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
@Table(name = "view_integ_macro_ws")
@NamedQueries({
    @NamedQuery(name = "ViewIntegMacroWs.findAll", query = "SELECT v FROM ViewIntegMacroWs v")})
public class ViewIntegMacroWs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackId")
    private Integer packId;
    @Column(name = "Integrator")
    private Integer integrator;
    @Column(name = "Account")
    private Integer account;
    @Column(name = "CodEquipamento")
    private Integer codEquipamento;
    @Column(name = "MacroNumber")
    private Integer macroNumber;
    @Column(name = "Title", length = 100)
    private String title;
    @Column(name = "Lable", length = 500)
    private String lable;
    @Column(name = "EnableMsgLivre")
    private Character enableMsgLivre;
    @Column(name = "Enable")
    private Integer enable;

    public ViewIntegMacroWs() {
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

    public Integer getMacroNumber() {
        return macroNumber;
    }

    public void setMacroNumber(Integer macroNumber) {
        this.macroNumber = macroNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
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
