package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.*;

public class DBListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DBDAO dao = DBDAO.getInstance();
		List<DBDTO> pageList = dao.getDBList();
		request.setAttribute("pageList", pageList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("db/db_list.jsp");
		return forward;
	}
}