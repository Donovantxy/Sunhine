package com.example.fulviocosco.sunshine.app.rest.model;

import org.parceler.Parcel;

/**
 * Created by fulvio on 06/11/2016.
 */

@Parcel
public class RestError {

    private int code;
    private String msg;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {

        return code;
    }

    public String getMsg() {
        return msg;
    }

    public RestError(String msg){
        this.msg = msg;
    }


}
