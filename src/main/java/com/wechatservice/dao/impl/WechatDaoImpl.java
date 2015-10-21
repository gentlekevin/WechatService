package com.wechatservice.dao.impl;

import com.wechatservice.utils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wechatservice.dao.WechatDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class WechatDaoImpl implements WechatDao {

    private static final Log LOG = LogFactory.getLog(WechatDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JSONArray fetchData() {
        JSONArray developers = new JSONArray();
        JSONObject developer1 = new JSONObject();
        developer1.put("userName", "YangKaiWen");
        developer1.put("position", "SoftwareDevelper");
        JSONObject developer2 = new JSONObject();
        developer2.put("userName", "LiuChao");
        developer2.put("position", "SoftwareDevelper");
        developers.add(developer1);
        developers.add(developer2);
        return developers;
    }

    @Override
    public boolean addFirstMenu(String content, int type, String answer) {
        String sql = "insert into t_category(content, addDate, type, answer) values('"+ content +"', '" + PropertyUtils.formateDate(new Date()) +"'," + type+", '"+ answer +"')";
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    @Override
    public boolean deleteFirstMenu(int id) {
        String sql = "delete from t_category where id=" + id;
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }


    @Override
    public boolean updateFirstMenu(String content, int type, String answer, int id) {
        String sql = "update  t_category set content='" + content + "', type=" + type + ",answer='" + answer +"'"  + " where id="  + id;
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> getAllFirstMenu() {
        String sql = "select * from t_category ";
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }

    @Override
    public List<Map<String, Object>> getFirstMenuById(int id) {
        String sql = "select * from t_category where id=" + id;
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }

    @Override
    public boolean addSecondMenu(int category_id, String content, int type, String answer) {
        String sql = "insert into t_subcategory(category_id, content, addDate, type, answer) values('" + category_id + "', '"+ content +"', '" + PropertyUtils.formateDate(new Date()) +"'," + type+", '"+ answer +"')";
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    @Override
    public boolean deleteSecondMenu(int id) {
        String sql = "delete from t_subcategory where id=" + id;
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    @Override
    public boolean updateSecondMenu(int category_id, String content, int type, String answer, int id) {
        String sql = "update  t_subcategory set content='" + content + "', type=" + type + ",answer='" + answer +"', category_id="+category_id  + " where id="  + id;
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> getAllSecondMenu() {
        String sql = "select * from t_subcategory ";
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }

    @Override
    public List<Map<String, Object>> getSecondMenuById(int id) {
        String sql = "select * from t_subcategory where id=" + id;
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }

    @Override
    public boolean addThirdMenu(int category_id, int subcategory_id, String content, String answer) {
        String sql = "insert into t_question(category_id, subcategory_id, content, answer) values(" + category_id + ", "+ subcategory_id +", '" + content+"','" + answer + "')";
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    @Override
    public boolean deleteThirdMenu(int id) {
        String sql = "delete from t_question where id=" + id;
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    @Override
    public boolean updateThirdMenu(int category_id, int subcategory_id, String content, String answer, int id) {
        String sql = "update  t_question set content='" + content + "' ,answer='" + answer +"',category_id="+ category_id + ",subcategory_id=" + subcategory_id + " where id="  + id;
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> getAllThirdMenu() {
        String sql = "select * from t_question ";
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }

    @Override
    public List<Map<String, Object>> getThirdMenuById(int id) {
        String sql = "select * from t_question where id=" + id;
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }
}