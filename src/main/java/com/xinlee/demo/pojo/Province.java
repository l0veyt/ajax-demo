package com.xinlee.demo.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xin.lee on 2017/3/2.
 *
 */
@XStreamAlias("province")
public class Province implements Serializable {
    @XStreamAsAttribute
    private String code;
    @XStreamAsAttribute
    private String name;
    @XStreamImplicit(itemFieldName = "")
    private List<City> cityList = new ArrayList<City>();

    public Province(String code, String name, List<City> cityList) {
        this.code = code;
        this.name = name;
        this.cityList = cityList;
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

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
