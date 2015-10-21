package com.wechatservice.service.impl;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;

import com.wechatservice.dao.WechatDao;
import com.wechatservice.service.WechatService;

import java.util.List;
import java.util.Map;

@Service
public class WechatServiceImpl implements WechatService {

    @Autowired
    private WechatDao wechatDao;
    
    public JSONArray getDevelopers() {
        return wechatDao.fetchData();
    }

    public boolean addFirstMenu(String content, int type, String answer) {
        return wechatDao.addFirstMenu(content, type, answer);
    }

    public boolean deleteFistMenu(int id) {
        return wechatDao.deleteFirstMenu(id);
    }

    public boolean updateFistMenu(String content, int type, String answer, int id) {
        return wechatDao.updateFirstMenu(content, type, answer, id);
    }

    public JSONArray getAllFirstMenu() {
        List<Map<String, Object>> list = wechatDao.getAllFirstMenu();
        JSONArray result = new JSONArray();
        for (Map<String, Object> map : list) {
            JSONObject object = new JSONObject();
            object.put("id", map.get("id"));
            object.put("content", map.get("content"));
            object.put("type", map.get("type"));
            object.put("answer", map.get("answer"));
            result.add(object);
        }
        return result;
    }

    public JSONObject getFirstMenuById(int id) {
        JSONObject object = new JSONObject();
        List<Map<String, Object>> list = wechatDao.getFirstMenuById(id);
        if (list == null || list.size() != 1) {
            return object;
        } else {
            Map<String, Object> map = list.get(0);
            object.put("id", map.get("id"));
            object.put("content", map.get("content"));
            object.put("type", map.get("type"));
            object.put("answer", map.get("answer"));
            return object;
        }
    }

    public boolean addSecondMenu(int category_id, String content, int type, String answer) {
        return wechatDao.addSecondMenu(category_id, content, type, answer);
    }

  
    public boolean deleteSecondMenu(int id) {
        return wechatDao.deleteSecondMenu(id);
    }

  
    public boolean updateSecondMenu(int category_id, String content, int type, String answer, int id) {
        return wechatDao.updateSecondMenu(category_id, content, type, answer, id);
    }

    
    public JSONArray getAllSecondMenu() {
        List<Map<String, Object>> list = wechatDao.getAllSecondMenu();
        JSONArray result = new JSONArray();
        for (Map<String, Object> map : list) {
            JSONObject object = new JSONObject();
            object.put("id", map.get("id"));
            object.put("content", map.get("content"));
            object.put("category_id", map.get("category_id"));
            object.put("type", map.get("type"));
            object.put("answer", map.get("answer"));
            result.add(object);
        }
        return result;
    }

   
    public JSONObject getSecondMenuById(int id) {
        JSONObject object = new JSONObject();
        List<Map<String, Object>> list = wechatDao.getSecondMenuById(id);
        if (list == null || list.size() != 1) {
            return object;
        } else {
            Map<String, Object> map = list.get(0);
            object.put("id", map.get("id"));
            object.put("category_id", map.get("category_id"));
            object.put("content", map.get("content"));
            object.put("type", map.get("type"));
            object.put("answer", map.get("answer"));
            return object;
        }
    }



    public boolean addThirdMenu(int category_id, int subcategory_id, String content, String answer) {
        return wechatDao.addThirdMenu(category_id, subcategory_id, content, answer);
    }

   
    public boolean deleteThirdMenu(int id) {
        return wechatDao.deleteThirdMenu(id);
    }

 
    public boolean updateThirdMenu(int category_id, int subcategory_id, String content, String answer, int id) {
        return wechatDao.updateThirdMenu(category_id, subcategory_id, content, answer, id);
    }

   
    public JSONArray getAllThirdMenu() {
        List<Map<String, Object>> list = wechatDao.getAllThirdMenu();
        JSONArray result = new JSONArray();
        for (Map<String, Object> map : list) {
            JSONObject object = new JSONObject();
            object.put("id", map.get("id"));
            object.put("category_id", map.get("category_id"));
            object.put("subcategory_id", map.get("subcategory_id"));
            object.put("content", map.get("content"));
            object.put("answer", map.get("answer"));
            result.add(object);
        }
        return result;
    }

    
    public JSONObject getThirdMenuById(int id) {
        JSONObject object = new JSONObject();
        List<Map<String, Object>> list = wechatDao.getThirdMenuById(id);
        if (list == null || list.size() != 1) {
            return object;
        } else {
            Map<String, Object> map = list.get(0);
            object.put("id", map.get("id"));
            object.put("category_id", map.get("category_id"));
            object.put("subcategory_id", map.get("subcategory_id"));
            object.put("content", map.get("content"));
            object.put("answer", map.get("answer"));
            return object;
        }
    }
}