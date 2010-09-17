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
@Table(name = "view_integ_msg_ws_cronos")
@NamedQueries({
    @NamedQuery(name = "ViewIntegMsgWsCronos.findAll", query = "SELECT v FROM ViewIntegMsgWsCronos v")})
public class ViewIntegMsgWsCronos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackId")
    private Integer packId;
    @Column(name = "VehiclePlate", length = 10)
    private String vehiclePlate;
    @Column(name = "SerialNumber", length = 2147483647)
    private String serialNumber;
    @Column(name = "CreatDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatDateTime;
    @Column(name = "Integrator")
    private Integer integrator;
    @Column(name = "Account")
    private Integer account;
    @Column(name = "MessageCode")
    private Integer messageCode;
    @Column(name = "MacroNumber")
    private Integer macroNumber;
    @Column(name = "Text", length = 2147483647)
    private String text;
    @Column(name = "CodEquipamento")
    private Integer codEquipamento;
    @Column(name = "TpMsg")
    private Integer tpMsg;

    public ViewIntegMsgWsCronos() {
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getCreatDateTime() {
        return creatDateTime;
    }

    public void setCreatDateTime(Date creatDateTime) {
        this.creatDateTime = creatDateTime;
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

    public Integer getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(Integer messageCode) {
        this.messageCode = messageCode;
    }

    public Integer getMacroNumber() {
        return macroNumber;
    }

    public void setMacroNumber(Integer macroNumber) {
        this.macroNumber = macroNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCodEquipamento() {
        return codEquipamento;
    }

    public void setCodEquipamento(Integer codEquipamento) {
        this.codEquipamento = codEquipamento;
    }

    public Integer getTpMsg() {
        return tpMsg;
    }

    public void setTpMsg(Integer tpMsg) {
        this.tpMsg = tpMsg;
    }

}
