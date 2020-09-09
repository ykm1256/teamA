package com.mypt.action.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.ScheduleDao;
import com.mypt.dao.UserDao;
import com.mypt.dto.ScheduleDto;
import com.mypt.dto.UserDto;

public class UserScheduleViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		
		//오늘 날짜 및 해당 월 주차, 오늘 요일
		String today=request.getParameter("today");
		int week=Integer.parseInt(request.getParameter("week"));
		int day=Integer.parseInt(request.getParameter("day"));
		int dayDif=day-1;
		String[] weekDates=request.getParameterValues("weekDates[]");
		
		UserDao dao=UserDao.getInstance();
		UserDto dto=dao.getUserById(id);
		
		
		
		//pt
		ScheduleDao sdao=ScheduleDao.getInstance();
		//프로그램
		
		return "callback";
	}

}
