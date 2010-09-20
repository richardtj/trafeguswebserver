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
@Table(name = "view_integ_pos_ws_v2", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewIntegPosWsV2.findAll", query = "SELECT v FROM ViewIntegPosWsV2 v"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByPackId", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.packId = :packId"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByIntegrator", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.integrator = :integrator"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByAccount", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.account = :account"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByVehiclePlate", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.vehiclePlate = :vehiclePlate"),
    @NamedQuery(name = "ViewIntegPosWsV2.findBySerialNumber", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.serialNumber = :serialNumber"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByEventDateTime", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.eventDateTime = :eventDateTime"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByOdometer", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.odometer = :odometer"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByRpm", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.rpm = :rpm"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByTemperatureSensor", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.temperatureSensor = :temperatureSensor"),
    @NamedQuery(name = "ViewIntegPosWsV2.findBySpeed", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.speed = :speed"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByGPSSpeed", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.gPSSpeed = :gPSSpeed"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByGPSLatitude", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.gPSLatitude = :gPSLatitude"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByGPSLongitude", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.gPSLongitude = :gPSLongitude"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByGPSDescTec", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.gPSDescTec = :gPSDescTec"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByGPSDescSis", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.gPSDescSis = :gPSDescSis"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByIgnition", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.ignition = :ignition"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByGPSNorthAngle", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.gPSNorthAngle = :gPSNorthAngle"),
    @NamedQuery(name = "ViewIntegPosWsV2.findBySleepMode", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.sleepMode = :sleepMode"),
    @NamedQuery(name = "ViewIntegPosWsV2.findByCodEquipamento", query = "SELECT v FROM ViewIntegPosWsV2 v WHERE v.codEquipamento = :codEquipamento")})
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
