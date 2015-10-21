package com.wechatservice.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface WechatService {
    public JSONArray getDevelopers();

    // 一级菜单业务交互
    public boolean addFirstMenu(String content, int type, String answer);
    public boolean deleteFistMenu(int id);
    public boolean updateFistMenu(String content, int type, String answer, int id);
    public JSONArray getAllFirstMenu();
    public JSONObject getFirstMenuById(int id);

    // 二级菜单业务交互
    public boolean addSecondMenu(int category_id, String content, int type, String answer);
    public boolean deleteSecondMenu(int id);
    public boolean updateSecondMenu(int category_id,String content, int type, String answer, int id);
    public JSONArray getAllSecondMenu();
    public JSONObject getSecondMenuById(int id);

    // 三级菜单业务交互
    public boolean addThirdMenu(int category_id,int subcategory_id, String content, String answer);
    public boolean deleteThirdMenu(int id);
    public boolean updateThirdMenu(int category_id,int subcategory_id, String content, String answer, int id);
    public JSONArray getAllThirdMenu();
    public JSONObject getThirdMenuById(int id);
}