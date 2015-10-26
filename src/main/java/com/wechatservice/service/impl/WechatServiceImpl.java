package com.wechatservice.service.impl;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;

import com.wechatservice.dao.WechatDao;
import com.wechatservice.service.WechatService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

@Service
public class WechatServiceImpl implements WechatService {

    private static final String NLP = "NLP";
    private static final String SA = "Standard Answer";


    @Autowired
    private WechatDao wechatDao;
    
    public JSONArray getDevelopers() {
        return wechatDao.fetchData();
    }

    @Override
    public boolean addFirstMenu(String content, int type, String answer, String sequence) {
        return wechatDao.addFirstMenu(content, type, answer, sequence);
    }

    @Override
    public boolean deleteFistMenu(int id) {
        return wechatDao.deleteFirstMenu(id);
    }

    @Override
    public boolean updateFistMenu(String content, int type, String answer, int id,  String sequence) {
        return wechatDao.updateFirstMenu(content, type, answer, id, sequence);
    }

    @Override
    public JSONArray getAllFirstMenu() {
        List<Map<String, Object>> list = wechatDao.getAllFirstMenu();
        JSONArray result = new JSONArray();
        for (Map<String, Object> map : list) {
            JSONObject object = new JSONObject();
            object.put("id", map.get("id"));
            object.put("content", map.get("content"));
            object.put("type", map.get("type"));
            object.put("answer", map.get("answer"));
            object.put("sequence", map.get("sequence"));
            result.add(object);
        }
        return result;
    }

    @Override
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
            object.put("sequence", map.get("sequence"));
            return object;
        }
    }


    @Override
    public boolean menu1ContainsSequence(String sequence) {
        return wechatDao.menu1ContainsSequence(sequence);
    }

    @Override
    public boolean addSecondMenu(int category_id, String content, int type, String answer, String sequence) {
        return wechatDao.addSecondMenu(category_id, content, type, answer, sequence);
    }

    @Override
    public boolean deleteSecondMenu(int id) {
        return wechatDao.deleteSecondMenu(id);
    }

    @Override
    public boolean updateSecondMenu(int category_id, String content, int type, String answer, int id, String sequence) {
        return wechatDao.updateSecondMenu(category_id, content, type, answer, id, sequence);
    }

    @Override
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
            object.put("sequence", map.get("sequence"));
            result.add(object);
        }
        return result;
    }

    @Override
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
            object.put("sequence", map.get("sequence"));
            return object;
        }
    }


    @Override
    public boolean menu2ContainsSequence(String sequence,  String categoryId) {
        return wechatDao.menu2ContainsSequence(sequence,  categoryId);
    }

    @Override
    public boolean addThirdMenu(int category_id, int subcategory_id, String content, String answer) {
        return wechatDao.addThirdMenu(category_id, subcategory_id, content, answer);
    }

    @Override
    public boolean deleteThirdMenu(int id) {
        return wechatDao.deleteThirdMenu(id);
    }

    @Override
    public boolean updateThirdMenu(int category_id, int subcategory_id, String content, String answer, int id) {
        return wechatDao.updateThirdMenu(category_id, subcategory_id, content, answer, id);
    }

    @Override
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

    @Override
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

    @Override
    public boolean menu3ContainsSequence(String sequence) {
        return wechatDao.menu3ContainsSequence(sequence);
    }

    @Override
    public JSONObject getCountInfo() {
        JSONObject result = new JSONObject();
        List<Map<String, Object>> list = wechatDao.getDataCountInfoList();
        if (list == null || list.size() == 0) {
            result.put(NLP, "");
            result.put(SA, "");
        } else {
            int sum = list.size();
            int countOfSA = 0;
            for (Map<String, Object> map: list) {
                int source = Integer.valueOf(map.get("answerSource").toString());
                if (source == 0) {
                    countOfSA++;
                }
            }
            DecimalFormat df = new DecimalFormat("0.00%");
            String percentOfSA = df.format(Double.valueOf(countOfSA) / Double.valueOf(sum));
            String percentOfNLP =df.format(Double.valueOf(sum - countOfSA) / Double.valueOf(sum));
            result.put(SA, percentOfSA);
            result.put(NLP, percentOfNLP);
        }
        return  result;
    }

    @Override
    public boolean addQARecords(String userName, String question, String answer, String answerSource) {
        return wechatDao.addQARecords(userName, question, answer, answerSource);
    }
}