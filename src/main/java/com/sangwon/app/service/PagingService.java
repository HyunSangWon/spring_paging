package com.sangwon.app.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sangwon.app.dao.PagingDao;
import com.sangwon.app.util.PageHandler;
import com.sangwon.app.util.ParamGetter;

@Service
public class PagingService {
	@Resource
	private PagingDao pagingDao;
	
	/**
	 * 페이징 처리하는 비즈니스 로직
	 * 
	 * @param mv,req,pageNum
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doBoardList(ModelAndView mv, HttpServletRequest req,int pageNum) throws Exception{
		
		HashMap<String,Object> params = ParamGetter.pGetter(req);
		
		int limitCount=((pageNum - 1 ) * 10);	
		int totalCount = pagingDao.totalCount(params);
		int contentNum =10;
		
		PageHandler pageHandler = new PageHandler();
		pageHandler.setTotalcount(totalCount);
		pageHandler.setPagenum(pageNum);
		pageHandler.setContentnum(contentNum);
		pageHandler.setCurrentblock(pageNum);
		pageHandler.setLastblock(pageHandler.getTotalcount());
		pageHandler.prevnext(pageNum);
		pageHandler.setStartPage(pageHandler.getCurrentblock());
		pageHandler.setEndPage(pageHandler.getLastblock(),pageHandler.getCurrentblock());
		
		params.put("LIMITCOUNT",limitCount);
		params.put("CONTENTNUM",contentNum);
		
		List<HashMap<String, Object>> list = pagingDao.boardList(params);
		
		mv.addObject("list",list);
		mv.addObject("pageHandler",pageHandler);	
		mv.setViewName("board");
		return mv;
	}
	
}
