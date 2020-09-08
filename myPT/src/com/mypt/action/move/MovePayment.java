package com.mypt.action.move;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.TrainerDao;
import com.mypt.dao.UserDao;
import com.mypt.dto.TrainerDto;
import com.mypt.dto.UserDto;

public class MovePayment implements Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		HttpSession session= request.getSession();
		
		UserDao dao = UserDao.getInstance();
		UserDto user = dao.getUserById((String)session.getAttribute("id"));
		
		TrainerDao tdao = TrainerDao.getInstance();
		ArrayList<TrainerDto> trainer = tdao.trainerList();
		
		request.setAttribute("user", user);
		request.setAttribute("trainer", trainer);
		
		return "user/payment";
	}

}
