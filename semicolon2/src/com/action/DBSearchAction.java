package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.*;

public class DBSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String find_name = request.getParameter("find_name").trim();
		DBDAO dao = DBDAO.getInstance();
		List<DBDTO> searchList = dao.search(find_name);
		request.setAttribute("searchList", searchList);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("db/searchDBList.jsp");
		return forward;
	}	
}