package com.mypt.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dto.CboardDto;

public class ReplyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("board"));
		//커뮤니티 write
		if(request.getParameter("board").equals("'c'")) {
			CboardDto dto = new CboardDto();
			System.out.println(request.getParameter("writeHead"));
			dto.setHead(request.getParameter("writeHead"));
			
			HttpSession session = request.getSession();		
			dto.setWriter(session.getAttribute("nick").toString());
			if(dto.getWriter()==""|dto.getWriter()==null) {
				dto.setWriter("길동이");
			}
			
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			
			CboardDao dao = CboardDao.getInstance();
			dao.insertBoard(dto);
			
			
			return "common/community";
			
			// 다른 게시판 write
		}else {
			return null;
		}
	}

}
