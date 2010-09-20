/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.server.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "view_integ_cad_veiculo", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewIntegCadVeiculo.findAll", query = "SELECT v FROM ViewIntegCadVeiculo v"),
    @NamedQuery(name = "ViewIntegCadVeiculo.findByPackID", query = "SELECT v FROM ViewIntegCadVeiculo v WHERE v.packID = :packID"),
    @NamedQuery(name = "ViewIntegCadVeiculo.findByVehiclePlate", query = "SELECT v FROM ViewIntegCadVeiculo v WHERE v.vehiclePlate = :vehiclePlate"),
    @NamedQuery(name = "ViewIntegCadVeiculo.findBySerialNumber", query = "SELECT v FROM ViewIntegCadVeiculo v WHERE v.serialNumber = :serialNumber"),
    @NamedQuery(name = "ViewIntegCadVeiculo.findByCodEquipamento", query = "SELECT v FROM ViewIntegCadVeiculo v WHERE v.codEquipamento = :codEquipamento"),
    @NamedQuery(name = "ViewIntegCadVeiculo.findByAccount", query = "SELECT v FROM ViewIntegCadVeiculo v WHERE v.account = :account")})
public class ViewIntegCadVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackID")
    private Integer packID;
    @Column(name = "VehiclePlate", length = 2147483647)
    private String vehiclePlate;
    @Column(name = "SerialNumber", length = 30)
    private String serialNumber;
    @Column(name = "CodEquipamento")
    private Integer codEquipamento;
    @Column(name = "Account", length = 50)
    private String account;
    @Lob
    @Column(name = "Integrator")
    private Object integrator;

    public ViewIntegCadVeiculo() {
    }

    public Integer getPackID() {
        return packID;
    }

    public void setPackID(Integer packID) {
        this.packID = packID;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Object getIntegrator() {
        return integrator;
    }

    public void setIntegrator(Object integrator) {
        this.integrator = integrator;
    }

}
