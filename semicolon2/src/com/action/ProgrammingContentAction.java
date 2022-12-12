package com.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.*;

public class ProgrammingContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String no = request.getParameter("no").trim();
		PDAO dao = PDAO.getInstance();
		
		PDTO content = dao.PContent(no);
		request.setAttribute("Cont", content);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("programming/programming_detail.jsp");
		return forward;
	}
}