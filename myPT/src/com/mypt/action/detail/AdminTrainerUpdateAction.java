package com.mypt.action.detail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypt.controller.Action;
import com.mypt.dao.TrainerDao;
import com.mypt.dto.TrainerDto;

public class AdminTrainerUpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TrainerDto dto = new TrainerDto();
		dto.setT_name(request.getParameter("trainerName"));
		dto.setT_id(request.getParameter("hiddentrainerID"));
		dto.setT_gender(request.getParameter("gender"));
		dto.setT_birth(request.getParameter("birthdate"));
		dto.setT_nick(request.getParameter("nickname"));
		dto.setT_email(request.getParameter("email"));
		dto.setT_tel(request.getParameter("tel"));
		dto.setT_pw(request.getParameter("password"));
		dto.setT_zipcode(request.getParameter("zipcode"));
		dto.setT_address(request.getParameter("address"));
		
		TrainerDao dao = TrainerDao.getInstance();
		dao.trainerUpdate(dto);
		
		return "redirect:moveTrainerList.do";
	}

}
