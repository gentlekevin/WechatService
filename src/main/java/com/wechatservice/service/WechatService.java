package com.wechatservice.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestParam;

public interface WechatService {
    public JSONArray getDevelopers();

    // 一级菜单业务交互
    public boolean addFirstMenu(String content, int type, String answer, String sequence);
    public boolean deleteFistMenu(int id);
    public boolean updateFistMenu(String content, int type, String answer, int id, String sequence);
    public JSONArray getAllFirstMenu();
    public JSONObject getFirstMenuById(int id);
    public boolean menu1ContainsSequence(String sequence);
        public JSONObject  getFirstMenuIdBySequen(String sequence);

    // 二级菜单业务交互
    public boolean addSecondMenu(int category_id, String content, int type, String answer, String sequence);
    public boolean deleteSecondMenu(int id);
    public boolean updateSecondMenu(int category_id,String content, int type, String answer, int id, String sequence);
    public JSONArray getAllSecondMenu();
    public JSONObject getSecondMenuById(int id);

    
    public JSONArray getMenu2ByMenu1Sequen(String menu1sequence);
    public JSONObject getMenu2AnswerByMenu1and2(String menu1sequence,String menu2sequence);
    

    public boolean menu2ContainsSequence(String sequence, String categoryId);


    // 三级菜单业务交互
    public boolean addThirdMenu(int category_id,int subcategory_id, String content, String answer);
    public boolean deleteThirdMenu(int id);
    public boolean updateThirdMenu(int category_id,int subcategory_id, String content, String answer, int id);
    public JSONArray getAllThirdMenu();
    public JSONObject getThirdMenuById(int id);
    public boolean menu3ContainsSequence(String sequence);

    // 数据统计交互
    public JSONObject getCountInfo();
    public boolean addQARecords(String userName,  String question, String answer,  String answerSource);
}