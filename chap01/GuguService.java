package com.tjoeun.svc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuguService {
	
	private HttpServletRequest request;
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	@Autowired   // spring 이 호출 이것이 먼저 돌아가야 문제가 없음.
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String getGugu() {
		
		String sDan = request.getParameter("dan");
		int dan = 0;
		if(sDan==null || sDan.equals("")) {
			sDan = "2";
		}
		
		dan = Integer.parseInt(sDan);
		/*
		 * String gStr = "";
		 * 
		 * for(int i=1; i<=9; i++) { gStr += String.format("%d * %d = %d <br>", dan, i,
		 * dan*i); }
		 * 
		 * return gStr;
		 */
		return getGugu();
	
	}
	
	public String getGugu(int dan) {
		
		String gStr = "";
		
		for(int i=1; i<=9; i++) {
			gStr += String.format("%d * %d = %d <br>", dan, i, dan*i);
		}
		
		return gStr;
	}
	
	
	
}
