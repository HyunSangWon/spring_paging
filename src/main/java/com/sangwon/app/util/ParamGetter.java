package com.sangwon.app.util;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class ParamGetter {
	/**
	 * HashMap형태로 넘어오는 파라미터 설정
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static HashMap<String,Object> pGetter(HttpServletRequest req) throws Exception{
		HashMap<String,Object> hm = new HashMap<String,Object>();
		Enumeration e = req.getParameterNames();//파라미터 이름들이 Enumeration클래스로 등록
		String tmp = "";
		while(e.hasMoreElements()){ //파라미터 이름이 있을때 까지!!
			tmp = (String) e.nextElement();
			hm.put(tmp.toUpperCase(), req.getParameter(tmp));
		}
		return hm;
	}
}
