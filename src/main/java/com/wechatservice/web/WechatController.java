/**
 * Copyright (C) 2014 Baidu, Inc. All Rights Reserved.
 */
package com.wechatservice.web;

import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.wechatservice.service.WechatService;

import net.sf.json.JSONArray;

/**
 * Created by liuchao on 2015/9/27.
 */
@Controller
@RequestMapping(value = "/wechat")
public class WechatController {
   
    private static final String SUCCESS = "success";
    private static final String DATA = "data";
    private static Logger logger = LoggerFactory.getLogger(WechatController.class);
	private final RestTemplate restTemplate = new RestTemplate();
	private static String NlpApi = "http://localhost:8080/TalkMachineService/yjtNLP";
    @Autowired
    private WechatService wechatService;
    
   
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	public String wechat() {
		return "/wechat";
	}  
 
    @RequestMapping(value = "/getReplay", method ={ RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JSONObject getReplay (@RequestParam("info") String info) {
    	    	
    	logger.info("question------------"+info);
        StringBuffer replay = new StringBuffer();
        if("r".equals(info)){
			//回到智能处理 
			 replay.append("现在加儿为您服务哦~~~~<\b>");
			 return encapsulateResult (replay.toString());
	   }
        Pattern digpattern = Pattern.compile("[0-9]"); 
		Pattern nvipattern = Pattern.compile("[0-9]-[0-9]"); 
		if("s".equals(info)){
        	//一级菜单，返回所有的一级菜单
			getAllFirstMenu1s(replay);
			 
			///********************************    	
        }else if(digpattern.matcher(info).matches()){
        	//二级菜单，返回二级菜单（包含答案的可能）
        	
        	
        	JSONObject data = wechatService.getFirstMenuIdBySequen(info);
            if("1".equals(data.get("type"))){
         	  //此时是问题 
            	JSONObject jsonObject2 = data.getJSONObject("data");
				replay.append(jsonObject2.getString("answer"));
				///********************************
            } else {
            	//此时是菜单
            	JSONArray menu2s = wechatService.getMenu2ByMenu1Sequen(info);
	            for (int i = 0; i < menu2s.size(); i++) {
					
					JSONObject jo = (JSONObject) menu2s.get(i);
					
					//如果是菜单则列出
					replay.append("【");
					replay.append(info+"-");
					replay.append(jo.getString("sequence"));
					replay.append("】 ");
					replay.append(jo.getString("content"));
					replay.append("\n");
				}
          //********************************
            }       	
        }else if(nvipattern.matcher(info).matches()){
        	//二级菜单具体问题,返回答案
        	 String[] questions = info.split("-");
        	 JSONObject datas = wechatService.getMenu2AnswerByMenu1and2(questions[0], questions[1]);
		     replay.append(datas.getString("answer"));
		  
		     
        }else{
        	//走FAQ流程------------------
        
        	
        	String r = restTemplate.getForObject(NlpApi+"?question="+info, String.class);
        	if(!"没有答案".equals(r)){
        		replay.append(r);	
        	}else{
        		replay.append("您难道我了，试试发送以下指令~");
        		getAllFirstMenu1s(replay);
        	}
        }    		
		return encapsulateResult (replay.toString());
             
    }
    public JSONObject encapsulateResult (String replay) {
    	logger.info("answer------------"+replay);
        JSONObject result = new JSONObject();
        result.put(SUCCESS, true);
        result.put(DATA, replay);
        return result;
    }
 
    public void  getAllFirstMenu1s(StringBuffer replay){
    	 replay.append("您可以回复下列指令进行查询~~~~\n");
    	 JSONArray menu1s = wechatService.getAllFirstMenu();
    	   	for (int i = 0; i < menu1s.size(); i++) {
    	           JSONObject jo = (JSONObject) menu1s.get(i);
    	           
    	           replay.append("【");
    	           replay.append(jo.getString("sequence"));
    	           replay.append("】 ");
    	           replay.append(jo.getString("content"));
    	           replay.append("\n");
    	   	}
    	   	
    }
    
	
    
}

