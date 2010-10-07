/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estevan
 */
public class DataPackPos {
    public DataPackPos()
    {
        this.records = 0;
        this.dataPos = new ArrayList<DataPos>();
    }
    private int records;
    private List<DataPos> dataPos;

    /**
     * @return the records
     */
    public int getRecords()
    {
        return records;
    }

    /**
     * @return the dataPos
     */
    public List<DataPos> getDataPos()
    {
        return dataPos;
    }

    /**
     * @param dataPos the dataPos to set
     */
    public void setDataPos(List<DataPos> dataPos)
    {
        this.dataPos = dataPos;
        this.records = this.dataPos.size();
    }

    public void addDataPos(DataPos dataPos)
    {
        this.dataPos.add(dataPos);
        this.records = this.dataPos.size();
    }
    
    public void clearDataPos()
    {
        this.dataPos.clear();
        this.records = 0;
    }
}
