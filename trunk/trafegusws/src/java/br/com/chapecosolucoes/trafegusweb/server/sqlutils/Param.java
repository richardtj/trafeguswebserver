package br.com.chapecosolucoes.trafegusweb.server.sqlutils;

import java.util.Date;

public class Param {

    private String name;
    private Object value;

    public Param() {
    }

    public Param(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Param(String name) {
        this.name = name;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public FieldType getType(){
       FieldType result = FieldType.OBJECT;
        if (value != null){
            if (this.value instanceof String) result = FieldType.STRING;
            else if (this.value instanceof Integer) result = FieldType.INTEGER;
            else if ((this.value instanceof java.sql.Date) || (this.value instanceof java.util.Date)) result = FieldType.DATE;
            else if (this.value instanceof Double) result = FieldType.FLOAT;
        }
       return result;
    }

    @Override
    public String toString() {
        String result = getValue().toString();
        if ((getType() == FieldType.FLOAT) || (getType() == FieldType.STRING))
            result = "'" + result + "'";
        else if (getType() == FieldType.DATE){
            java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            result = "'" + df.format((Date)getValue()) + "'";
        }

        return result;
    }


}
