package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.PDAO;
import com.model.PDTO;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PDAO dao = PDAO.getInstance();
		List<PDTO> list = dao.getCodeList();
		request.setAttribute("List", list);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("programming/programming_list.jsp");
		return forward;
	}

}