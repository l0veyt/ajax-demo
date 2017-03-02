package com.xinlee.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by xin.lee on 2017/3/2.
 * 响应Json数据
 */
public class ResponseJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseJsonServlet已经执行");
        // 构建JSON数据
        JSONObject city1 = new JSONObject();
        city1.put("code", "001");
        city1.put("name", "杭州");
        JSONObject city2 = new JSONObject();
        city2.put("code", "002");
        city2.put("name", "宁波");
        JSONArray cities = new JSONArray();
        cities.add(city1);
        cities.add(city2);

        JSONObject province = new JSONObject();
        province.put("code", "ZJ");
        province.put("name", "浙江");
        province.put("cities", cities);
        String json = province.toJSONString();
        // 响应JSON数据
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(json);
    }
}
