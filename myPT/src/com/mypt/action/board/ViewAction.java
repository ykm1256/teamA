package com.mypt.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dao.LikeDao;
import com.mypt.dto.CboardDto;

public class ViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		String board = session.getAttribute("board").toString();
		
		
//		session.setAttribute("nick", "길동이");
		String nick = session.getAttribute("nick").toString();
		
		if(board.equals("cboard")) {		
		CboardDto dto = new CboardDto();
		CboardDao dao = CboardDao.getInstance();
		LikeDao ldao = LikeDao.getInstance();
		int lflag = ldao.selectLike(nick, "cblike",num);
		dto = dao.detailView(num);
		request.setAttribute("dto", dto);
		request.setAttribute("lflag", lflag);
		session.setAttribute("dto", dto);
		}
		
		return "common/boardDetail";
	}

}
