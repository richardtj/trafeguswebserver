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
@Table(name = "view_integ_pos_ws", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewIntegPosWs.findAll", query = "SELECT v FROM ViewIntegPosWs v"),
    @NamedQuery(name = "ViewIntegPosWs.findByPackId", query = "SELECT v FROM ViewIntegPosWs v WHERE v.packId = :packId"),
    @NamedQuery(name = "ViewIntegPosWs.findByVehiclePlate", query = "SELECT v FROM ViewIntegPosWs v WHERE v.vehiclePlate = :vehiclePlate"),
    @NamedQuery(name = "ViewIntegPosWs.findBySerialNumber", query = "SELECT v FROM ViewIntegPosWs v WHERE v.serialNumber = :serialNumber"),
    @NamedQuery(name = "ViewIntegPosWs.findByCreatDateTime", query = "SELECT v FROM ViewIntegPosWs v WHERE v.creatDateTime = :creatDateTime"),
    @NamedQuery(name = "ViewIntegPosWs.findByIntegrator", query = "SELECT v FROM ViewIntegPosWs v WHERE v.integrator = :integrator"),
    @NamedQuery(name = "ViewIntegPosWs.findByAccount", query = "SELECT v FROM ViewIntegPosWs v WHERE v.account = :account"),
    @NamedQuery(name = "ViewIntegPosWs.findByMessageCode", query = "SELECT v FROM ViewIntegPosWs v WHERE v.messageCode = :messageCode"),
    @NamedQuery(name = "ViewIntegPosWs.findByMacroNumber", query = "SELECT v FROM ViewIntegPosWs v WHERE v.macroNumber = :macroNumber"),
    @NamedQuery(name = "ViewIntegPosWs.findByText", query = "SELECT v FROM ViewIntegPosWs v WHERE v.text = :text"),
    @NamedQuery(name = "ViewIntegPosWs.findByCodEquipamento", query = "SELECT v FROM ViewIntegPosWs v WHERE v.codEquipamento = :codEquipamento"),
    @NamedQuery(name = "ViewIntegPosWs.findByTpMsg", query = "SELECT v FROM ViewIntegPosWs v WHERE v.tpMsg = :tpMsg")})
public class ViewIntegPosWs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackId")
    private Integer packId;
    @Column(name = "VehiclePlate", length = 10)
    private String vehiclePlate;
    @Column(name = "SerialNumber", length = 30)
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
    @Column(name = "MacroNumber", length = 2147483647)
    private String macroNumber;
    @Column(name = "Text", length = 2147483647)
    private String text;
    @Column(name = "CodEquipamento")
    private Integer codEquipamento;
    @Column(name = "TpMsg")
    private Integer tpMsg;

    public ViewIntegPosWs() {
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

    public String getMacroNumber() {
        return macroNumber;
    }

    public void setMacroNumber(String macroNumber) {
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
