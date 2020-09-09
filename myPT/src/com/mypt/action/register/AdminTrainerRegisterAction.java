package com.mypt.action.register;


import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypt.controller.Action;
import com.mypt.dao.TrainerDao;
import com.mypt.dao.UserDao;
import com.mypt.dto.TrainerDto;
import com.mypt.dto.UserDto;

public class AdminTrainerRegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		TrainerDto dto= new TrainerDto();
		
		dto.setT_pw(request.getParameter("password"));
		dto.setT_name(request.getParameter("userName"));
		dto.setT_gender(request.getParameter("gender"));
		dto.setT_email(request.getParameter("email"));
		dto.setT_birth(request.getParameter("birthdate"));
		dto.setT_address(request.getParameter("address"));
		dto.setT_nick(request.getParameter("nickname"));
		dto.setT_tel(request.getParameter("tel"));
		dto.setT_zipcode(request.getParameter("zipcode"));		
		dto.setT_addrdetail(request.getParameter("addrdetail"));

//		dto.setT_photo(request.getParameter("photo"));
		
		TrainerDao dao= TrainerDao.getInstance();		
		dao.insertTrainer(dto, request);
		
		return "redirect:trainerList.do";
	}

}
