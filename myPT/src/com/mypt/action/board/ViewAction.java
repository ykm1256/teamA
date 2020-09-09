package com.mypt.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dto.CboardDto;

public class ViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CboardDto dto = new CboardDto();
		int num = 20;
		CboardDao dao = CboardDao.getInstance();
		dto = dao.detailView(num);
		request.setAttribute("dto", dto);
		
		return "common/boardDetail";
	}

}
