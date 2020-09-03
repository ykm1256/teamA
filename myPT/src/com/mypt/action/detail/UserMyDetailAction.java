package com.mypt.action.detail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypt.controller.Action;
import com.mypt.dao.UserDao;
import com.mypt.dto.UserDto;

public class UserMyDetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String email = "hong@naver.com";
		UserDao udao = UserDao.getInstance();
		UserDto user = udao.getUserByEmail(email);		
		
		request.setAttribute("user", user);
		
		return "userUpdate";
	}
	
	

}
