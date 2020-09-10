package com.mypt.action.move;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.PboardDao;
import com.mypt.dto.PboardDto;

public class MovePhotoAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		PboardDao pdao=PboardDao.getInstance();
		ArrayList<PboardDto> parr=pdao.getList();
		

		
		return "common/photoBoard";
	}

}
