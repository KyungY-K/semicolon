package com.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.*;

public class DBContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String no = request.getParameter("no").trim();
		DBDAO dao = DBDAO.getInstance();
		
		DBDTO content = dao.DBContent(no);
		request.setAttribute("Cont", content);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("db/db_detail.jsp");
		return forward;
	}
}