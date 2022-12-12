package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.*;

public class PSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String find_name = request.getParameter("find_name").trim();
		PDAO dao = PDAO.getInstance();
		List<PDTO> searchList = dao.search(find_name);
		request.setAttribute("searchList", searchList);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("programming/searchPList.jsp");
		return forward;
	}	
}