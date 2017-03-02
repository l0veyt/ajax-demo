package com.xinlee.demo.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;

/**
 * Created by xin.lee on 2017/3/2.
 *
 */
@XStreamAlias("city")
public class City implements Serializable {
    @XStreamAsAttribute
    private String code;
    @XStreamAsAttribute
    private String name;

    public City(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
