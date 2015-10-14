package com.wechatservice.dao.impl;

import org.springframework.stereotype.Repository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wechatservice.dao.DemoDao;

@Repository
public class DemoDaoImpl implements DemoDao{

    public JSONArray fetchData() {
        JSONArray developers = new JSONArray();
        JSONObject developer1 = new JSONObject();
        developer1.put("userName", "YangKaiWen");
        developer1.put("position", "SoftwareDevelper");
        JSONObject developer2 = new JSONObject();
        developer2.put("userName", "LiuChao");
        developer2.put("position", "SoftwareDevelper");
        developers.add(developer1);
        developers.add(developer2);StringBuilder
        return developers;
    }
    
}