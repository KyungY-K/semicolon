package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.*;

public class SurveyListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SurveyDAO dao = SurveyDAO.getInstance();
		List<SurveyDTO> pageList = dao.getSContent();
		request.setAttribute("pageList", pageList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("survey/survey_list.jsp");
		return forward;
	}
}