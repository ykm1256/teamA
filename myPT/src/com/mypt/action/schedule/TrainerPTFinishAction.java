package com.mypt.action.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypt.controller.Action;
import com.mypt.dao.UserDao;

public class TrainerPTFinishAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserDao dao = UserDao.getInstance();
		String[] arr = request.getParameterValues("id");
		System.out.println("길이"+arr.length);
		
		for(int i=0; i<arr.length;i++) {
			dao.ptFinish(arr[i]);			
			System.out.println("확인"+arr[i]);
		}
		
		return "redirect:trainerMain.do";
	}

}
