package com.wechatservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;

import com.wechatservice.dao.DemoDao;
import com.wechatservice.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoDao demoDao;
    
    public JSONArray getDevelopers() {
        return demoDao.fetchData();
    }
    
}