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
@Table(name = "view_integ_cad_veiculo_ws_v2_cronos", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewIntegCadVeiculoWsV2Cronos.findAll", query = "SELECT v FROM ViewIntegCadVeiculoWsV2Cronos v"),
    @NamedQuery(name = "ViewIntegCadVeiculoWsV2Cronos.findByPackID", query = "SELECT v FROM ViewIntegCadVeiculoWsV2Cronos v WHERE v.packID = :packID"),
    @NamedQuery(name = "ViewIntegCadVeiculoWsV2Cronos.findByVehiclePlate", query = "SELECT v FROM ViewIntegCadVeiculoWsV2Cronos v WHERE v.vehiclePlate = :vehiclePlate"),
    @NamedQuery(name = "ViewIntegCadVeiculoWsV2Cronos.findBySerialNumber", query = "SELECT v FROM ViewIntegCadVeiculoWsV2Cronos v WHERE v.serialNumber = :serialNumber"),
    @NamedQuery(name = "ViewIntegCadVeiculoWsV2Cronos.findByCodEquipamento", query = "SELECT v FROM ViewIntegCadVeiculoWsV2Cronos v WHERE v.codEquipamento = :codEquipamento"),
    @NamedQuery(name = "ViewIntegCadVeiculoWsV2Cronos.findByAccount", query = "SELECT v FROM ViewIntegCadVeiculoWsV2Cronos v WHERE v.account = :account"),
    @NamedQuery(name = "ViewIntegCadVeiculoWsV2Cronos.findByIntegrator", query = "SELECT v FROM ViewIntegCadVeiculoWsV2Cronos v WHERE v.integrator = :integrator")})
public class ViewIntegCadVeiculoWsV2Cronos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackID")
    private Integer packID;
    @Column(name = "VehiclePlate", length = 10)
    private String vehiclePlate;
    @Column(name = "SerialNumber", length = 2147483647)
    private String serialNumber;
    @Column(name = "CodEquipamento")
    private Integer codEquipamento;
    @Column(name = "Account")
    private Integer account;
    @Column(name = "Integrator")
    private Integer integrator;

    public ViewIntegCadVeiculoWsV2Cronos() {
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

    public Integer getIntegrator() {
        return integrator;
    }

    public void setIntegrator(Integer integrator) {
        this.integrator = integrator;
    }

}
