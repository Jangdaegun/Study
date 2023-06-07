package com.javalec.ex;

// import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MemberDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	private DataSource ds = null;

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int memberInsert(MemberDTO m) {
		int result = 0;
		conn = null;
		pstmt = null;
		try {
			conn = ds.getConnection();
			String sql = "insert into memberDTO values(" + "?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			// 단순 평문인 경우
			// pstmt.setNString(2, m.getPw());

			// password 암호화
			PasswordEncoder p = new BCryptPasswordEncoder();
			m.setPw(p.encode(m.getPw()));
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}

	public ArrayList<MemberDTO> AllmemberSelect() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		conn = null;
		stmt = null;
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from memberdto");
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public int memberUpdate(MemberDTO m) {
		int result = 0;
		conn = null;
		pstmt = null;
		
		try {
			conn = ds.getConnection();
			String sql = "update memberdto set name = ? where id = ? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getId());
			pstmt.setString(3, m.getPw());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}

	public int memberDelete(MemberDTO m) {
		int result = 0;
		conn = null;
		pstmt = null;
		try {
			conn = ds.getConnection();
			String sql = "delete from memberdto where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}

}














