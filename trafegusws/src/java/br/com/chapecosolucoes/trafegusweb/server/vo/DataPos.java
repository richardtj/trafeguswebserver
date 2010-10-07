/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.vo;

/**
 *
 * @author estevan
 */
public class DataPos {
    private String vehiclePlate;
    private String gpsLatitude;
    private String gpsLongitude;
    private String gpsDescSis;
    private String ignition;

    /**
     * @return the vehiclePlate
     */
    public String getVehiclePlate() {
        return vehiclePlate;
    }

    /**
     * @param vehiclePlate the vehiclePlate to set
     */
    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    /**
     * @return the gpsLatitude
     */
    public String getGpsLatitude() {
        return gpsLatitude;
    }

    /**
     * @param gpsLatitude the gpsLatitude to set
     */
    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    /**
     * @return the gpsLongitude
     */
    public String getGpsLongitude() {
        return gpsLongitude;
    }

    /**
     * @param gpsLongitude the gpsLongitude to set
     */
    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    /**
     * @return the gpsDescSis
     */
    public String getGpsDescSis() {
        return gpsDescSis;
    }

    /**
     * @param gpsDescSis the gpsDescSis to set
     */
    public void setGpsDescSis(String gpsDescSis) {
        this.gpsDescSis = gpsDescSis;
    }

    /**
     * @return the ignition
     */
    public String getIgnition() {
        return ignition;
    }

    /**
     * @param ignition the ignition to set
     */
    public void setIgnition(String ignition) {
        this.ignition = ignition;
    }
}
