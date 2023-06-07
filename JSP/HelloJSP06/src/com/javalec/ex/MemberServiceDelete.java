package com.javalec.ex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServiceDelete implements MemberService {

	@Override
	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO m = MemberDAO.getInstance();
		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		
		m.memberDelete(dto);
		return null;
	}

}
