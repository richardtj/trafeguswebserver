/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "view_integ_pos_ws_v2")
@NamedQueries({
    @NamedQuery(name = "ViewIntegPosWsV2.findAll", query = "SELECT v FROM ViewIntegPosWsV2 v")})
public class ViewIntegPosWsV2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackId")
    private Integer packId;
    @Column(name = "Integrator", length = 2147483647)
    private String integrator;
    @Column(name = "Account")
    private Integer account;
    @Column(name = "VehiclePlate", length = 10)
    private String vehiclePlate;
    @Column(name = "SerialNumber", length = 30)
    private String serialNumber;
    @Column(name = "EventDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDateTime;
    @Column(name = "Odometer", length = 2147483647)
    private String odometer;
    @Column(name = "Rpm", length = 2147483647)
    private String rpm;
    @Column(name = "TemperatureSensor", length = 2147483647)
    private String temperatureSensor;
    @Column(name = "Speed", length = 2147483647)
    private String speed;
    @Column(name = "GPSSpeed", length = 2147483647)
    private String gPSSpeed;
    @Column(name = "GPSLatitude", precision = 15, scale = 10)
    private BigDecimal gPSLatitude;
    @Column(name = "GPSLongitude", precision = 15, scale = 10)
    private BigDecimal gPSLongitude;
    @Column(name = "GPSDescTec", length = 2147483647)
    private String gPSDescTec;
    @Column(name = "GPSDescSis", length = 2147483647)
    private String gPSDescSis;
    @Column(name = "Ignition", length = 50)
    private String ignition;
    @Column(name = "GPSNorthAngle", length = 2147483647)
    private String gPSNorthAngle;
    @Column(name = "SleepMode", length = 2147483647)
    private String sleepMode;
    @Column(name = "CodEquipamento")
    private Integer codEquipamento;

    public ViewIntegPosWsV2() {
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    public String getIntegrator() {
        return integrator;
    }

    public void setIntegrator(String integrator) {
        this.integrator = integrator;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
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

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getRpm() {
        return rpm;
    }

    public void setRpm(String rpm) {
        this.rpm = rpm;
    }

    public String getTemperatureSensor() {
        return temperatureSensor;
    }

    public void setTemperatureSensor(String temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getGPSSpeed() {
        return gPSSpeed;
    }

    public void setGPSSpeed(String gPSSpeed) {
        this.gPSSpeed = gPSSpeed;
    }

    public BigDecimal getGPSLatitude() {
        return gPSLatitude;
    }

    public void setGPSLatitude(BigDecimal gPSLatitude) {
        this.gPSLatitude = gPSLatitude;
    }

    public BigDecimal getGPSLongitude() {
        return gPSLongitude;
    }

    public void setGPSLongitude(BigDecimal gPSLongitude) {
        this.gPSLongitude = gPSLongitude;
    }

    public String getGPSDescTec() {
        return gPSDescTec;
    }

    public void setGPSDescTec(String gPSDescTec) {
        this.gPSDescTec = gPSDescTec;
    }

    public String getGPSDescSis() {
        return gPSDescSis;
    }

    public void setGPSDescSis(String gPSDescSis) {
        this.gPSDescSis = gPSDescSis;
    }

    public String getIgnition() {
        return ignition;
    }

    public void setIgnition(String ignition) {
        this.ignition = ignition;
    }

    public String getGPSNorthAngle() {
        return gPSNorthAngle;
    }

    public void setGPSNorthAngle(String gPSNorthAngle) {
        this.gPSNorthAngle = gPSNorthAngle;
    }

    public String getSleepMode() {
        return sleepMode;
    }

    public void setSleepMode(String sleepMode) {
        this.sleepMode = sleepMode;
    }

    public Integer getCodEquipamento() {
        return codEquipamento;
    }

    public void setCodEquipamento(Integer codEquipamento) {
        this.codEquipamento = codEquipamento;
    }

}
