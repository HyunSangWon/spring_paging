package com.sangwon.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sangwon.app.service.PagingService;

@Controller
public class PagingController {

	@Resource
	private PagingService pagingService;
	
	/**
	 * 페이징 화면으로 이동
	 * 
	 * @param mv,req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView page(ModelAndView mv, HttpServletRequest req) throws Exception {
		return pagingService.doBoardList(mv, req,1);
	}
	
	/**
	 * 페이지번호클릭시 해당 번호에 맞게 화면으로 이동
	 * 
	 * @param mv,req,pageNum
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{pageNum}", method = RequestMethod.GET)
	public ModelAndView doPage(ModelAndView mv, HttpServletRequest req
			,@PathVariable("pageNum") int pageNum) throws Exception {
		return pagingService.doBoardList(mv,req,pageNum);
	}
	
	
}
