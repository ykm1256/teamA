package com.mypt.controller.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.TrainerDao;
import com.mypt.dto.TrainerDto;


public class TrainerLoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		TrainerDao dao = new TrainerDao();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int flag = dao.trainerLogin(id, pw);
		System.out.println(flag);
		if(flag==1) {
		 TrainerDto trainer = dao.trainerSelect(id);	
		 HttpSession session = request.getSession();
		 session.setAttribute("name", trainer.getT_name());
		 session.setAttribute("nick", trainer.getT_nick());
		 session.setAttribute("id", trainer.getT_id());
		}
		
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("flag", flag);
		
		
		return "callback";
	}

}
