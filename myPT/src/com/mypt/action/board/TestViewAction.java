package com.mypt.action.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dao.CommentDao;
import com.mypt.dto.CboardDto;
import com.mypt.dto.CommentDto;

public class TestViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		String board = session.getAttribute("board").toString();		
		String nick = session.getAttribute("nick").toString();
		
		CommentDto comment = new CommentDto();
		CommentDao cdao = CommentDao.getInstance();
		
		if(board.equals("cboard")) 
		{		
			CboardDto dto = new CboardDto();
			CboardDao dao = CboardDao.getInstance();
	
//			LikeDao ldao = LikeDao.getInstance();			
//			int lflag = ldao.selectLike(nick, "cblike",num);
//			request.setAttribute("lflag", lflag);
			
			dto = dao.detailView(num);
			 
			ArrayList<CommentDto> arr = cdao.commentList("ccomment", num);
//			JsonArray arr= cdao.commentList("ccomment", num);
			
			request.setAttribute("dto", dto);
			session.setAttribute("dto", dto);
			
			request.setAttribute("comments", arr);
		}
		
		return "common/testBoardDetail";
	}

}
