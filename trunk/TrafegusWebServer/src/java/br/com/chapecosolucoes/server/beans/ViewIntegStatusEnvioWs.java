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
@Table(name = "view_integ_status_envio_ws", catalog = "trafegus_transc", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ViewIntegStatusEnvioWs.findAll", query = "SELECT v FROM ViewIntegStatusEnvioWs v"),
    @NamedQuery(name = "ViewIntegStatusEnvioWs.findByPackId", query = "SELECT v FROM ViewIntegStatusEnvioWs v WHERE v.packId = :packId"),
    @NamedQuery(name = "ViewIntegStatusEnvioWs.findByStatusDateTime", query = "SELECT v FROM ViewIntegStatusEnvioWs v WHERE v.statusDateTime = :statusDateTime"),
    @NamedQuery(name = "ViewIntegStatusEnvioWs.findByStatusId", query = "SELECT v FROM ViewIntegStatusEnvioWs v WHERE v.statusId = :statusId"),
    @NamedQuery(name = "ViewIntegStatusEnvioWs.findByStatus", query = "SELECT v FROM ViewIntegStatusEnvioWs v WHERE v.status = :status")})
public class ViewIntegStatusEnvioWs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PackId")
    private Integer packId;
    @Column(name = "StatusDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusDateTime;
    @Column(name = "StatusId", length = 10)
    private String statusId;
    @Column(name = "Status", length = 2147483647)
    private String status;

    public ViewIntegStatusEnvioWs() {
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    public Date getStatusDateTime() {
        return statusDateTime;
    }

    public void setStatusDateTime(Date statusDateTime) {
        this.statusDateTime = statusDateTime;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
