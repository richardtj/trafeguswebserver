/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.vo;

/**
 *
 * @author estevan
 */
public class ReturnDataPackPos {
    public ReturnDataPackPos()
    {
        this.dataPackPos = new DataPackPos();
    }
    private DataPackPos dataPackPos;

    /**
     * @return the dataPackPos
     */
    public DataPackPos getDataPackPos() {
        return dataPackPos;
    }

    /**
     * @param dataPackPos the dataPackPos to set
     */
    public void setDataPackPos(DataPackPos dataPackPos) {
        this.dataPackPos = dataPackPos;
    }
}
