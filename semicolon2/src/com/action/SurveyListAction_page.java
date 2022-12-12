package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.SurveyDAO;
import com.model.SurveyDTO;

public class SurveyListAction_page implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int rowsize = 10;
		int block = 5;
		int totalRecord = 0;
		int allPage = 0;
		int page = 0;	
				
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page").trim());
		} else {
			page = 1;
		}
			int startNo = (page*rowsize) - (rowsize - 1);
			int endNo = (page * rowsize);
			int startBlock = (((page -1)/block) * block) + 1; 
			int endBlock = (((page -1)/block) * block) + block; 
			
			SurveyDAO dao = SurveyDAO.getInstance();
			
			totalRecord = dao.getSurveyCount();
				
			allPage = (int)Math.ceil(totalRecord / (double)rowsize);
				
				if(endBlock > allPage) {
					endBlock = allPage;
				}
		
		List<SurveyDTO> pageList = dao.getSList(page, rowsize);
		
		request.setAttribute("pageList", pageList);
		
		request.setAttribute("page", page);
		request.setAttribute("rowsize", rowsize);
		request.setAttribute("block", block);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);

	ActionForward forward = new ActionForward();
	forward.setRedirect(false);
	forward.setPath("survey/survey_content.jsp");
	return forward;
	}
}