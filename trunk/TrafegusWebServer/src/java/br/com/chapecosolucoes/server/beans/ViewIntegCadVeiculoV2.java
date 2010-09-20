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
@Table(name = "view_integ_cad_veiculo_v2", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewIntegCadVeiculoV2.findAll", query = "SELECT v FROM ViewIntegCadVeiculoV2 v"),
    @NamedQuery(name = "ViewIntegCadVeiculoV2.findByPackID", query = "SELECT v FROM ViewIntegCadVeiculoV2 v WHERE v.packID = :packID"),
    @NamedQuery(name = "ViewIntegCadVeiculoV2.findByVehiclePlate", query = "SELECT v FROM ViewIntegCadVeiculoV2 v WHERE v.vehiclePlate = :vehiclePlate"),
    @NamedQuery(name = "ViewIntegCadVeiculoV2.findBySerialNumber", query = "SELECT v FROM ViewIntegCadVeiculoV2 v WHERE v.serialNumber = :serialNumber"),
    @NamedQuery(name = "ViewIntegCadVeiculoV2.findByCodEquipamento", query = "SELECT v FROM ViewIntegCadVeiculoV2 v WHERE v.codEquipamento = :codEquipamento"),
    @NamedQuery(name = "ViewIntegCadVeiculoV2.findByAccount", query = "SELECT v FROM ViewIntegCadVeiculoV2 v WHERE v.account = :account")})
public class ViewIntegCadVeiculoV2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackID")
    private Integer packID;
    @Column(name = "VehiclePlate", length = 10)
    private String vehiclePlate;
    @Column(name = "SerialNumber", length = 30)
    private String serialNumber;
    @Column(name = "CodEquipamento")
    private Integer codEquipamento;
    @Column(name = "Account")
    private Integer account;
    @Lob
    @Column(name = "Integrator")
    private Object integrator;

    public ViewIntegCadVeiculoV2() {
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

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Object getIntegrator() {
        return integrator;
    }

    public void setIntegrator(Object integrator) {
        this.integrator = integrator;
    }

}
