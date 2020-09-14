package com.mypt.action.board.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mypt.controller.Action;
import com.mypt.dao.CommentDao;
import com.mypt.dto.TestPagingDto;

public class CommentDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		HttpSession session = request.getSession();
		String board = session.getAttribute("board").toString();
		
		int num= Integer.parseInt(request.getParameter("num"));		
		int c_num= Integer.parseInt(request.getParameter("c_num"));
		CommentDao cdao = CommentDao.getInstance();
		
		TestPagingDto paging= (TestPagingDto)session.getAttribute("paging");
		int result = 0;
		
		if(board.equals("cboard")) 
		{		
			result= cdao.commentDelete("ccomment", c_num);
			
		}
		else if(board.equals("pboard"))
		{
			result= cdao.commentDelete("pcomment", c_num);
		}
		
		paging.setTotalRecord(paging.getTotalRecord()-1);
		session.setAttribute("paging", paging);
		
		
		Gson gson = new Gson();
		JsonArray jsonArray= new JsonArray();
		jsonArray.add(gson.fromJson(gson.toJson(paging, TestPagingDto.class), JsonObject.class));
		jsonArray.add(result);
	
		
		//jsonArray에 원시 타입을 이름을 줘서 넣고 싶긴 함.
				
		
		
		request.setAttribute("result", jsonArray);
		return "callback";
	}

}
