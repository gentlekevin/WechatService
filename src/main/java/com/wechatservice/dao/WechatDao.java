package com.wechatservice.dao;

import net.sf.json.JSONArray;

import java.util.List;
import java.util.Map;

public interface WechatDao {
    public JSONArray fetchData();

    // 一级菜单 数据交互
    public boolean addFirstMenu(String content, int type, String answer, String sequence);
    public boolean deleteFirstMenu(int id);
    public boolean updateFirstMenu(String content, int type, String answer, int id, String sequence);
    public List<Map<String, Object>> getAllFirstMenu();
    public List<Map<String, Object>> getFirstMenuById(int id);
    public List<Map<String, Object>>  getFirstMenuIdBySequen(String sequence);
    public boolean menu1ContainsSequence(String sequence);

    // 二级菜单 数据交互
    public boolean addSecondMenu(int category_id, String content, int type, String answer, String sequence);
    public boolean deleteSecondMenu(int id);
    public boolean updateSecondMenu(int category_id,String content, int type, String answer, int id, String sequence);
    public List<Map<String, Object>> getAllSecondMenu();
    public List<Map<String, Object>> getSecondMenuById(int id);

    public List<Map<String, Object>> getMenu2ByMenu1Sequen(String menu1sequence);
    public List<Map<String, Object>> getMenu2AnswerByMenu1and2(String menu1sequence,String menu2sequence);
  

    public boolean menu2ContainsSequence(String sequence,  String categoryId);


    // 三级菜单 数据交互
    public boolean addThirdMenu(int category_id, int subcategory_id, String content, String answer);
    public boolean deleteThirdMenu(int id);
    public boolean updateThirdMenu(int category_id,int subcategory_id, String content, String answer, int id);
    public List<Map<String, Object>> getAllThirdMenu();
    public List<Map<String, Object>> getThirdMenuById(int id);
    public boolean menu3ContainsSequence(String sequence);

    public List<Map<String, Object>> getDataCountInfoList();
    public boolean addQARecords(String userName,  String question, String answer,  String answerSource);

}