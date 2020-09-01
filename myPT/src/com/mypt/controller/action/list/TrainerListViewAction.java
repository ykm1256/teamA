package com.mypt.controller.action.list;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypt.controller.Action;
import com.mypt.dao.TrainerDao;
import com.mypt.dto.TrainerDto;

public class TrainerListViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TrainerDao dao=new TrainerDao();
		
		ArrayList<TrainerDto> arr=dao.trainerList();
		request.setAttribute("trainerList", arr);
		return "list/trainerList";
	}

}
