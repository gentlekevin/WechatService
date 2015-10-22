package com.wechatservice.dao.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wechatservice.dao.WechatDao;
import com.wechatservice.utils.PropertyUtils;

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
    public boolean addFirstMenu(String content, int type, String answer,  String sequence) {
        String sql = "insert into t_category(content, addDate, type, answer, sequence) values('"+ content +"', '" + PropertyUtils.formateDate(new Date()) +"'," + type+", '"+ answer +"', '"+  sequence +"')";

        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

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
    public boolean updateFirstMenu(String content, int type, String answer, int id, String sequence) {
        String sql = "update  t_category set content='" + content + "', type=" + type + ",answer='" + answer +"', sequence='" + sequence +"' where id="  + id;

        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    public List<Map<String, Object>> getAllFirstMenu() {
        String sql = "select * from t_category ";
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }

    public List<Map<String, Object>> getFirstMenuById(int id) {
        String sql = "select * from t_category where id=" + id;
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }


  
    public boolean menu1ContainsSequence(String sequence) {
        String sql = "select sequence from t_category where sequence=" + sequence;
        try {
            List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql);
            if (list != null && list.size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    
    public boolean addSecondMenu(int category_id, String content, int type, String answer, String sequence) {
        String sql = "insert into t_subcategory(category_id, content, addDate, type, answer, sequence) values('" + category_id + "', '"+ content +"', '" + PropertyUtils.formateDate(new Date()) +"'," + type+", '"+ answer + "', '"+ sequence +"')";

        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

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


    public boolean updateSecondMenu(int category_id, String content, int type, String answer, int id, String sequence) {
        String sql = "update  t_subcategory set content='" + content + "', type=" + type + ",answer='" + answer +"', category_id="+category_id +", sequence='" + sequence + "' where id="  + id;

        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }

    public List<Map<String, Object>> getAllSecondMenu() {
        String sql = "select * from t_subcategory ";
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }

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
    public boolean menu2ContainsSequence(String sequence) {
        String sql = "select sequence from t_subcategory where sequence=" + sequence;
        try {
            List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql);
            if (list != null && list.size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }


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

    public List<Map<String, Object>> getAllThirdMenu() {
        String sql = "select * from t_question ";
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }

    public List<Map<String, Object>> getThirdMenuById(int id) {
        String sql = "select * from t_question where id=" + id;
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String, Object>>();
        }
    }

    @Override
    public boolean menu3ContainsSequence(String sequence) {
        String sql = "select sequence from t_question where sequence=" + sequence;
        try {
            List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql);
            if (list != null && list.size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }


    @Override
    public List<Map<String, Object>> getDataCountInfoList() {
        String sql = "select id, answerSource from t_qarecords";
        try {
            return this.jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOG.info(e);
            return new ArrayList<Map<String,Object>>();
        }
    }

    @Override
    public boolean addQARecords(String userName, String question, String answer, String answerSource) {
        String sql = "insert into t_qarecords(userName, question, answer, answerSource) values ('" + userName +"', '" + question + "', '" +  answer + "', '" +  answerSource+ "')";
        try {
            this.jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            LOG.info(e);
            return false;
        }
    }
}