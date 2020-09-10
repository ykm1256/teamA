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
		int num = 20;
		String board = "cboard";
		
		HttpSession session = request.getSession();
		session.setAttribute("nick", "길동이");
		String nick = session.getAttribute("nick").toString();
		
		if(board.equals("cboard")) {		
		CboardDto dto = new CboardDto();
		CboardDao dao = CboardDao.getInstance();
		LikeDao ldao = LikeDao.getInstance();
		int lflag = ldao.selectLike(nick, "cblike",num);
		dto = dao.detailView(num);
		request.setAttribute("dto", dto);
		request.setAttribute("lflag", lflag);
		}
		
//		return "common/boardDetail";
		return "common/boardDetail2";
	}

}
