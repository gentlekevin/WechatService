/**
 * Copyright (C) 2014 Baidu, Inc. All Rights Reserved.
 */
package com.wechatservice.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechatservice.service.DemoService;

import net.sf.json.JSONArray;

/**
 * Created by liuchao on 2015/9/27.
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {
    private static final Log LOG = LogFactory.getLog(WebController.class);

    @Autowired
    private DemoService demoService;
    
    @RequestMapping(value = "/getDevelopers", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray getDevelopers() {
        LOG.info("trigger demo method");
        JSONArray result = demoService.getDevelopers();
        return result;
    }

}

