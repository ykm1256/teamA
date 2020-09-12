package com.mypt.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dao.CommentDao;
import com.mypt.dao.LikeDao;
import com.mypt.dao.QboardDao;
import com.mypt.dto.CboardDto;
import com.mypt.dto.QboardDto;

public class ViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		
		if(request.getParameter("b")!=null) {
			if(request.getParameter("b").toString().equals("c")) {
				session.setAttribute("board", "cboard");
			}else if(request.getParameter("b").toString().equals("q")){
				session.setAttribute("board", "qboard");
			}else if(request.getParameter("b").toString().equals("p")) {
				session.setAttribute("board", "pboard");
			}
		}
		String board = session.getAttribute("board").toString();
		
		
		session.setAttribute("nick", "길동이");
		String nick = session.getAttribute("nick").toString();
		
		if(board.equals("cboard")) {		
			CboardDto dto = new CboardDto();
			CboardDao dao = CboardDao.getInstance();
			LikeDao ldao = LikeDao.getInstance();
			int lflag = ldao.selectLike(nick, "cblike",num);
			dto = dao.detailView(num);
			
			CommentDao cdao = CommentDao.getInstance();
			int comment = 0;			
			request.setAttribute("comment", comment);			
			request.setAttribute("dto", dto);
			request.setAttribute("lflag", lflag);			
			session.setAttribute("dto", dto);			
		}
		
		else if(board.equals("qboard")) {
			QboardDto dto = new QboardDto();
			QboardDao dao = QboardDao.getInstance();			
			dto = dao.detailView(num);
			CommentDao cdao = CommentDao.getInstance();
			int comment = cdao.countComment("qcomment", num);			
			request.setAttribute("comcnt", comment);
			request.setAttribute("dto", dto);			
			session.setAttribute("dto", dto);
		}
		
		return "common/boardDetail";
	}

}
