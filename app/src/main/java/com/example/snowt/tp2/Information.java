package com.example.snowt.tp2;

/**
 * Created by nictamere on 2016-11-05.
 */

public class Information  {

    public Information(){ }
    public Information(String i){
        info=i;
    }

    protected String info;

    public void setInfo(String i){
        info = i;
    }
    public String getInfo(){
        return info;
    }

    @Override
    public boolean equals(Object info) {
        if(this.getInfo()==((Information)info).getInfo())
            return true;
        else {
            return false;
        }
    }
}
