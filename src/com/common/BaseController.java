package com.common;

import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 此类作为一个所有请求的总格式类
 * @author 11019113
 *
 */

public class BaseController extends HttpServlet{
	
	/**
	 * 此方法主要是实现判断session是否存在
	 */
	public Object getSessionFromRedis(HttpServletRequest request){
		Object obj =null;
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		//从redis获取对应sessionId的session对象
		if(){
			//设置session到redis中
			
		}else{
			
		}
	}
	
}
