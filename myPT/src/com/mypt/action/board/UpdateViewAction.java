package com.mypt.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dao.LikeDao;
import com.mypt.dto.CboardDto;

public class UpdateViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		String board = session.getAttribute("board").toString();		
		
		
		if(board.equals("cboard")) {		
		CboardDto dto = new CboardDto();
		CboardDao dao = CboardDao.getInstance();
		LikeDao ldao = LikeDao.getInstance();
		dto = dao.detailView(num);
		
		JSONObject obj = new JSONObject();
		obj.put("content", dto.getContent());
		
		request.setAttribute("result", obj);
		}
		
		return "callback";
	}

}
