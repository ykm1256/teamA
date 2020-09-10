package com.mypt.action.board.comment;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dao.CommentDao;
import com.mypt.dto.CboardDto;
import com.mypt.dto.CommentDto;

public class CommentInsertAction implements Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		HttpSession session = request.getSession();
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String c_content= request.getParameter("c_content");
		String board = session.getAttribute("board").toString();
		
		int updateResult = 0;
		
		CommentDao cdao = CommentDao.getInstance();
		CommentDto comment = new CommentDto();
		
		
//		JsonArray jarr = new JsonArray();
		Gson gson = new Gson();
		
		if(board.equals("cboard")) 
		{		
			comment.setBoardNum(boardNum);
			comment.setC_content(c_content);
			comment.setC_nick((String)session.getAttribute("nick"));
			
			updateResult = cdao.commentInsert("ccomment", comment);
			
			if(updateResult==1)
			{
				comment = cdao.getLastComment("ccomment", boardNum);
				
			}
			
		}
		
		request.setAttribute("result", gson.toJson(comment));
		
		
		
		return "callback";
	}

}
