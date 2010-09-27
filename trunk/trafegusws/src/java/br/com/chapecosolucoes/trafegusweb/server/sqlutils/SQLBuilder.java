package br.com.chapecosolucoes.trafegusweb.server.sqlutils;

import java.util.ArrayList;

public class SQLBuilder {

    private ArrayList<String> list = null;
    private ArrayList<Param> listParam = new ArrayList<Param>();

    public SQLBuilder() {
        list = new ArrayList<String>();
    }

    public void Add(String str) {
        list.add(str);
    }

    public Integer Count() {
        return list.size();
    }

    public void Clear() {
        list.clear();
        listParam.clear();
    }

    public String getText() {
        String result = "";
        for (int a=0; a < list.size(); a++){
            if (a < list.size())
                result += list.get(a) + "\n";
            else
                result += list.get(a);
        }
        return result;
    }

    public void setText(String strSQL){
        list.clear();
        String[] arr = strSQL.split("\n");
        for (int a=0; a < arr.length; a++)
            Add(arr[a]);
    }

    public Param param(String name) throws Exception{
      //  name = name.toUpperCase();
        if (getText().indexOf(":" + name) == -1)
            throw new Exception("Param [" + name + "] not found");
        Param result = new Param(name);
        if (listParam.indexOf(result) < 0)
            listParam.add(result);
        return listParam.get(listParam.indexOf(result));
    }
    public String format(){
        String result = getText();
        for (int a=0; a < listParam.size(); a++){
            if (result.indexOf(":" + listParam.get(a).getName()) >= 0){
                result = result.replaceFirst(":" + listParam.get(a).getName(), listParam.get(a).toString());
            }
        }
        return result;
    }

}
