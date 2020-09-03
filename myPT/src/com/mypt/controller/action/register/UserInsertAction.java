package com.mypt.controller.action.register;


import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypt.controller.Action;
import com.mypt.dao.UserDao;
import com.mypt.dto.UserDto;

public class UserInsertAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		UserDto dto= new UserDto();
		dto.setName(request.getParameter("userName"));
//		dto.setGender(Integer.parseInt(request.getParameter("gender")));
		dto.setGender(request.getParameter("gender"));

		dto.setBirth(request.getParameter("birthdate"));
		dto.setNick(request.getParameter("nickname"));
		dto.setEmail(request.getParameter("email"));
		dto.setPw(request.getParameter("password"));
		dto.setAddress(request.getParameter("zipcode")+" "+request.getParameter("address"));
		dto.setStartdate(Date.valueOf(request.getParameter("startdate")));
		dto.setTid(request.getParameter("trainer"));
		dto.setTel(request.getParameter("tel"));
		
//수정 요함. 데이터가 없을 때의 request.getParameter("startdate")의 값 확인 필요
//		dto.setStartdate(Date.valueOf(request.getParameter("startdate")));
		
//		dao들 싱글톤 하는게 나을듯
		UserDao dao= UserDao.getInstance();
		
		dao.insertUser(dto);
		
		return "redirect:moveUserList.do";
	}

}
