package com.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.SurveyDAO;
import com.model.SurveyDTO;

public class SurveyContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String no = request.getParameter("no").trim();
		SurveyDAO dao = SurveyDAO.getInstance();
		
		SurveyDTO content = dao.SContent(no);
		request.setAttribute("Cont", content);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("survey/survey_content.jsp");
		return forward;
	}
}