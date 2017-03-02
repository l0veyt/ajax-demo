package com.xinlee.demo;

import com.thoughtworks.xstream.XStream;
import com.xinlee.demo.pojo.City;
import com.xinlee.demo.pojo.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xin.lee on 2017/3/2.
 * 响应XML数据
 */
public class ResponseXmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseXmlServlet已经执行");
        // 构建XML数据
        List<City> cityList = new ArrayList<City>();
        cityList.add(new City("001", "杭州"));
        cityList.add(new City("002", "宁波"));
        cityList.add(new City("003", "温州"));
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        String xml = xStream.toXML(new Province("ZJ", "浙江", cityList));
        // 响应XML数据
        response.setContentType("text/xml; charset=utf-8");
        response.getWriter().write(xml);
    }
}
