package com.mypt.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dto.CboardDto;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// 커뮤니티 게시판
		if(session.getAttribute("board").equals("cboard")) {
			CboardDto dto = new CboardDto();
			dto.setNum(Integer.parseInt(request.getParameter("num")));
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			dto.setHead(request.getParameter("writeHead"));
			CboardDao dao = CboardDao.getInstance();
			dao.update(dto);			
			return "redirect: moveCommunity.do";			
			//다른 게시판
		}else{
			
			return null;
		}
		
	}

}
