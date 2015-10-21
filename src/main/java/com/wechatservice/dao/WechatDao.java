package com.wechatservice.dao;

import net.sf.json.JSONArray;

import java.util.List;
import java.util.Map;

public interface WechatDao {
    public JSONArray fetchData();

    // 一级菜单 数据交互
    public boolean addFirstMenu(String content, int type, String answer);
    public boolean deleteFirstMenu(int id);
    public boolean updateFirstMenu(String content, int type, String answer, int id);
    public List<Map<String, Object>> getAllFirstMenu();
    public List<Map<String, Object>> getFirstMenuById(int id);

    // 二级菜单 数据交互
    public boolean addSecondMenu(int category_id, String content, int type, String answer);
    public boolean deleteSecondMenu(int id);
    public boolean updateSecondMenu(int category_id,String content, int type, String answer, int id);
    public List<Map<String, Object>> getAllSecondMenu();
    public List<Map<String, Object>> getSecondMenuById(int id);

    // 三级菜单 数据交互
    public boolean addThirdMenu(int category_id, int subcategory_id, String content, String answer);
    public boolean deleteThirdMenu(int id);
    public boolean updateThirdMenu(int category_id,int subcategory_id, String content, String answer, int id);
    public List<Map<String, Object>> getAllThirdMenu();
    public List<Map<String, Object>> getThirdMenuById(int id);


}