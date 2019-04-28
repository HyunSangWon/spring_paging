package com.sangwon.app.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PagingDao extends AbstractDao{
	
	private String ns = "board.";
	
	public List<HashMap<String, Object>> boardList(HashMap<String, Object> params) throws Exception {
		return selectList(ns+"boardList",params);
	}
	
	public Integer totalCount (HashMap<String, Object> params)throws Exception{
		return (Integer)selectOne(ns+"totalCnt",params);
	}
}
