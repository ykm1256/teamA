package com.mypt.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.CboardDao;
import com.mypt.dto.CboardDto;
import com.mypt.dto.PboardDto;
import com.mypt.dto.QboardDto;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String board = session.getAttribute("board").toString();
		if(board.equals("cboard")) {			 
			CboardDto dto = new CboardDto();
			dto = (CboardDto) session.getAttribute("dto");
			CboardDao dao = CboardDao.getInstance();
			if(dto.getNum()!=dto.getRef()) {
				dao.deletereply(dto.getNum());
			}else {
				dao.deleteBoard(dto.getRef(),dto.getDepth());
			}

		}else if(board.equals("pboard")) {
			PboardDto dto = new PboardDto();
			dto = (PboardDto) session.getAttribute("dto");
		}else{
			QboardDto dto = new QboardDto();
			dto = (QboardDto) session.getAttribute("dto");
		}
		
		return "redirect: moveCommunity.do";
	}
	

}
