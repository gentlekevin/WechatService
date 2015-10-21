/**
 * Copyright (C) 2014 Baidu, Inc. All Rights Reserved.
 */
package com.wechatservice.web;

import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wechatservice.service.WechatService;

import net.sf.json.JSONArray;

/**
 * Created by liuchao on 2015/9/27.
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {
    private static final Log LOG = LogFactory.getLog(WebController.class);

    private static final String SUCCESS = "success";
    private static final String DATA = "data";

    @Autowired
    private WechatService wechatService;
    
    @RequestMapping(value = "/getDevelopers", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray getDevelopers() {
        LOG.info("trigger demo method");
        JSONArray result = wechatService.getDevelopers();
        return result;
    }

    @RequestMapping(value = "/updateFirstMenu", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject updateFirstMenu (@RequestParam("content") String content,
                                    @RequestParam("type") int type, @RequestParam("answer") String answer,
                                    @RequestParam(value = "id") int id) {
        JSONObject result = new JSONObject();
        boolean isSuccess = true;
        if (id != -1) {
            isSuccess = wechatService.updateFistMenu(content, type, answer, id);
        } else {
            isSuccess = wechatService.addFirstMenu(content, type, answer);
        }
        result.put(SUCCESS, isSuccess);
        return result;
    }

    @RequestMapping(value = "/getAllFirstMenu", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllFirstMenu () {
        JSONObject result = new JSONObject();
        JSONArray datas = wechatService.getAllFirstMenu();
        result.put(SUCCESS, true);
        result.put(DATA, datas);
        return result;
    }

    @RequestMapping(value = "/getFirstMenuById", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getFirstMenuById (@RequestParam("id") int id) {
        JSONObject result = new JSONObject();
        JSONObject data = wechatService.getFirstMenuById(id);
        result.put(SUCCESS, true);
        result.put(DATA, data);
        return result;
    }

    @RequestMapping(value = "/deleteFirstMenuById", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject deleteFirstMenuById (@RequestParam("id") int id) {
        JSONObject result = new JSONObject();
        boolean isSuccess = wechatService.deleteFistMenu(id);
        result.put(SUCCESS, isSuccess);
        return result;
    }


    @RequestMapping(value = "/getAllSecondMenu", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllSecondMenu () {
        JSONObject result = new JSONObject();
        JSONArray datas = wechatService.getAllSecondMenu();
        result.put(SUCCESS, true);
        result.put(DATA, datas);
        return result;
    }


    @RequestMapping(value = "/updateSecondMenu", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject updateSecondMenu (@RequestParam("category_id") int category_id, @RequestParam("content") String content,
                                       @RequestParam("type") int type, @RequestParam("answer") String answer,
                                       @RequestParam(value = "id") int id) {
        JSONObject result = new JSONObject();
        boolean isSuccess = true;
        if (id != -1) {
            isSuccess = wechatService.updateSecondMenu(category_id, content, type, answer, id);
        } else {
            isSuccess = wechatService.addSecondMenu(category_id, content, type, answer);
        }
        result.put(SUCCESS, isSuccess);
        return result;
    }


    @RequestMapping(value = "/getSecondMenuById", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getSecondMenuById (@RequestParam("id") int id) {
        JSONObject result = new JSONObject();
        JSONObject data = wechatService.getSecondMenuById(id);
        result.put(SUCCESS, true);
        result.put(DATA, data);
        return result;
    }

    @RequestMapping(value = "/deleteSecondMenuById", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject deleteSecondMenuById (@RequestParam("id") int id) {
        JSONObject result = new JSONObject();
        boolean isSuccess = wechatService.deleteSecondMenu(id);
        result.put(SUCCESS, isSuccess);
        return result;
    }

    @RequestMapping(value = "/getAllThirdMenu", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllThirdMenu () {
        JSONObject result = new JSONObject();
        JSONArray datas = wechatService.getAllThirdMenu();
        result.put(SUCCESS, true);
        result.put(DATA, datas);
        return result;
    }


    @RequestMapping(value = "/updateThirdMenu", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject updateThirdMenu (@RequestParam("category_id") int category_id,  @RequestParam("subcategory_id") int subcategory_id,
                                       @RequestParam("content") String content, @RequestParam("answer") String answer,
                                       @RequestParam(value = "id") int id) {
        JSONObject result = new JSONObject();
        boolean isSuccess = true;
        if (id != -1) {
            isSuccess = wechatService.updateThirdMenu(category_id, subcategory_id, content, answer, id);
        } else {
            isSuccess = wechatService.addThirdMenu(category_id, subcategory_id, content, answer);
        }
        result.put(SUCCESS, isSuccess);
        return result;
    }


    @RequestMapping(value = "/getThirdMenuById", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getThirdMenuById (@RequestParam("id") int id) {
        JSONObject result = new JSONObject();
        JSONObject data = wechatService.getThirdMenuById(id);
        result.put(SUCCESS, true);
        result.put(DATA, data);
        return result;
    }

    @RequestMapping(value = "/deleteThirdMenuById", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject deleteThirdMenuById (@RequestParam("id") int id) {
        JSONObject result = new JSONObject();
        boolean isSuccess = wechatService.deleteThirdMenu(id);
        result.put(SUCCESS, isSuccess);
        return result;
    }

}

