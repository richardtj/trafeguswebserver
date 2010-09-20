/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
@Table(name = "view_integ_viagem_ws", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewIntegViagemWs.findAll", query = "SELECT v FROM ViewIntegViagemWs v"),
    @NamedQuery(name = "ViewIntegViagemWs.findByPackId", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.packId = :packId"),
    @NamedQuery(name = "ViewIntegViagemWs.findByVehiclePlate", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.vehiclePlate = :vehiclePlate"),
    @NamedQuery(name = "ViewIntegViagemWs.findBySerialNumber", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.serialNumber = :serialNumber"),
    @NamedQuery(name = "ViewIntegViagemWs.findByCodEquipamento", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.codEquipamento = :codEquipamento"),
    @NamedQuery(name = "ViewIntegViagemWs.findByTripId", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.tripId = :tripId"),
    @NamedQuery(name = "ViewIntegViagemWs.findByDepartureLandmark", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.departureLandmark = :departureLandmark"),
    @NamedQuery(name = "ViewIntegViagemWs.findByArrivalLandmark", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.arrivalLandmark = :arrivalLandmark"),
    @NamedQuery(name = "ViewIntegViagemWs.findByDateTimeStart", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.dateTimeStart = :dateTimeStart"),
    @NamedQuery(name = "ViewIntegViagemWs.findByDateTimeEnd", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.dateTimeEnd = :dateTimeEnd"),
    @NamedQuery(name = "ViewIntegViagemWs.findByDateTimePreStart", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.dateTimePreStart = :dateTimePreStart"),
    @NamedQuery(name = "ViewIntegViagemWs.findByDateTimePreEnd", query = "SELECT v FROM ViewIntegViagemWs v WHERE v.dateTimePreEnd = :dateTimePreEnd")})
public class ViewIntegViagemWs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackId")
    private Integer packId;
    @Column(name = "VehiclePlate", length = 10)
    private String vehiclePlate;
    @Column(name = "SerialNumber", length = 30)
    private String serialNumber;
    @Column(name = "CodEquipamento")
    private Integer codEquipamento;
    @Column(name = "TripId")
    private Integer tripId;
    @Lob
    @Column(name = "Operation")
    private Object operation;
    @Column(name = "DepartureLandmark", length = 200)
    private String departureLandmark;
    @Column(name = "ArrivalLandmark", length = 200)
    private String arrivalLandmark;
    @Column(name = "DateTimeStart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeStart;
    @Column(name = "DateTimeEnd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeEnd;
    @Column(name = "DateTimePreStart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimePreStart;
    @Column(name = "DateTimePreEnd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimePreEnd;
    @Lob
    @Column(name = "Integrator")
    private Object integrator;

    public ViewIntegViagemWs() {
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

    public Integer getCodEquipamento() {
        return codEquipamento;
    }

    public void setCodEquipamento(Integer codEquipamento) {
        this.codEquipamento = codEquipamento;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public Object getOperation() {
        return operation;
    }

    public void setOperation(Object operation) {
        this.operation = operation;
    }

    public String getDepartureLandmark() {
        return departureLandmark;
    }

    public void setDepartureLandmark(String departureLandmark) {
        this.departureLandmark = departureLandmark;
    }

    public String getArrivalLandmark() {
        return arrivalLandmark;
    }

    public void setArrivalLandmark(String arrivalLandmark) {
        this.arrivalLandmark = arrivalLandmark;
    }

    public Date getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(Date dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public Date getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(Date dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public Date getDateTimePreStart() {
        return dateTimePreStart;
    }

    public void setDateTimePreStart(Date dateTimePreStart) {
        this.dateTimePreStart = dateTimePreStart;
    }

    public Date getDateTimePreEnd() {
        return dateTimePreEnd;
    }

    public void setDateTimePreEnd(Date dateTimePreEnd) {
        this.dateTimePreEnd = dateTimePreEnd;
    }

    public Object getIntegrator() {
        return integrator;
    }

    public void setIntegrator(Object integrator) {
        this.integrator = integrator;
    }

}
