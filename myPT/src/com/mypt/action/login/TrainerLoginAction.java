package com.mypt.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.AdminDao;
import com.mypt.dao.TrainerDao;
import com.mypt.dto.AdminDto;
import com.mypt.dto.TrainerDto;


public class TrainerLoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int flag = 0;
		
		if(id.equals("admin")) {
			AdminDao dao = AdminDao.getInstance();
			flag = dao.adminLogin(id, pw);
			if(flag==2) {
				 AdminDto dto = dao.getAdmin(id);	
				 
				 session.setAttribute("nick", "관리자");
				 session.setAttribute("grade", 0);
				}			
			
		}else {
			TrainerDao dao = TrainerDao.getInstance();
			flag = dao.trainerLogin(id, pw);
			System.out.println(flag);
			if(flag==1) {
			 TrainerDto trainer = dao.trainerSelect(id);			 
			 session.setAttribute("name", trainer.getT_name());
			 session.setAttribute("nick", trainer.getT_nick());
			 session.setAttribute("id", trainer.getT_id());
			 session.setAttribute("grade", 0);
			 
			}
			
		}
		
		
		
		
		
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("result", flag);
		
		
		return "callback";
	}

}
