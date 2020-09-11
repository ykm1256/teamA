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
import com.mypt.dto.Paging;

public class TestViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		String board = session.getAttribute("board").toString();		
		String nick = session.getAttribute("nick").toString();
		

		Paging paging= new Paging(); //		count= numPerPage = 20;	pagePerBlock = 5;	
		CommentDao cdao = CommentDao.getInstance();							
		
		if(board.equals("cboard")) 
		{		
			CboardDto dto = new CboardDto();
			CboardDao dao = CboardDao.getInstance();
	
//			LikeDao ldao = LikeDao.getInstance();			
//			int lflag = ldao.selectLike(nick, "cblike",num);
//			request.setAttribute("lflag", lflag);
			
			dto = dao.detailView(num);
					
			
			int totalRecord = cdao.commentCountforOne("ccomment", num);//totalRecord- 한 게시물에 대한 댓글 수 세팅 
			int numPerPage= paging.getNumPerPage(); // numPerPage, count;//페이지 당 레코드 개수- 기본 20
			int pagePerBlock = paging.getPagePerBlock(); // 기본 5
			
			int totalPage=0;
			int totalBlock=0;
			int nowPage=1;
			int nowBlock=1;
			int startNum=1;
			
			
			//처음 띄워줄 것은 마지막 페이지임
			
			if(totalRecord>=paging.getNumPerPage())
			{
				totalPage= (int)Math.ceil((double)totalRecord/numPerPage);//총 페이지수	
				totalBlock= (int)Math.ceil((double)totalPage/pagePerBlock); //총 블럭 수
				nowPage= (int)Math.ceil((double)totalRecord/numPerPage);
				nowBlock= (int)Math.ceil((double)nowPage/pagePerBlock);
				startNum=((nowPage*numPerPage)-numPerPage);
							
			}
			
			paging.setTotalRecord(totalRecord);
			paging.setTotalPage(totalPage);
			paging.setTotalBlock(totalBlock);
			paging.setNowPage(nowPage);
			paging.setNowBlock(nowBlock);
			paging.setStartNum(startNum);	
//			
//			CommentDto comment = new CommentDto(paging);			
			ArrayList<CommentDto> arr= cdao.getCommentsForOneCommentPage("ccomment", num, startNum, numPerPage); //	한 페이지에 해당하는 댓글 가져오기  
			
			dto.setComments(arr); 

			request.setAttribute("dto", dto);
			session.setAttribute("dto", dto);
			
			request.setAttribute("paging", paging);
			request.setAttribute("comments", arr);
		}
		
		return "common/testBoardDetail";
	}

}
