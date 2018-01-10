package com.common.send;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;


public class CommonSendClient {
	
	/**
	 * 
	 * @return
	 */
	public String sendGet(){
		String result=null;
		
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String sendPost(String url,String param){
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl= new URL(url);
			//打开和url之间的连接
			URLConnection conn= realUrl.openConnection();
			//设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			//发送post请求必须设置如下2行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//获取url对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			//发送请求参数
			out.print(param);
			System.out.println("将要发送到微信端的参数："+param);
			//flush出流的缓存
			out.flush();
			//对应BufferedReader输入流来读取url相应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line=in.readLine())!=null){
				result+=line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！"+e);
			e.printStackTrace();
		}finally{
			try {
				if(in !=null)
					in.close();
				if(out !=null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
