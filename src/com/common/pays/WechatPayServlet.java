package com.common.pays;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.common.send.CommonSendClient;
import com.common.utils.Config;
import com.common.utils.MapToXMLUtil;

@SuppressWarnings("serial")  
public class WechatPayServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request, response) ;  
  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        //设置不缓存图片  
        response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "No-cache");  
        response.setDateHeader("Expires", 0);
        System.out.println("进入了post方法....");
        Map paramsMap=request.getParameterMap();
        Iterator<Entry<String, String>> it = paramsMap.entrySet().iterator();
        Map<String,String> map = new HashMap<String,String>();
        while (it.hasNext()) {  
            Map.Entry<String, String> entry =  it.next();  
            String key = entry.getKey();  
            String value=request.getParameter(key);
            map.put(key, value);
        }
        //组装参数
        //String param=paramsMap.toString();
        String realParam=MapToXMLUtil.callMapToXML(map).toString();
        
        //获取微信支付的url
        String url =Config.getString("config.properties","wechatPay_url");
        
        realParam =Config.getString("config.properties","testParam");
        //调用支付方法
        String result =CommonSendClient.sendPost(url, realParam);
        System.out.println("微信端返回："+result);
    }  
}
