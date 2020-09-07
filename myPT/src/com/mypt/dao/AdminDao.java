package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mypt.connection.DBConnection;
import com.mypt.dto.AdminDto;

public class AdminDao {
	private DBConnection db;
	private static AdminDao instance = new AdminDao();
	public static AdminDao getInstance() {
		return instance;
	}

	private AdminDao() {
		db = DBConnection.getInstance();
	}

	public void insertAdmin(AdminDto adminBean) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {
			con = db.getConnection();
			sql = "insert admin(id,pw) values(?,?) ";
			ps = con.prepareStatement(sql);
			ps.setString(1, adminBean.getId());
			ps.setString(2, adminBean.getPw());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}

	public AdminDto getAdmin(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		AdminDto adminBean = new AdminDto();

		try {
			con = db.getConnection();
			sql = "select * from admin where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				adminBean.setId(rs.getString("id"));
				adminBean.setPw(rs.getString("pw"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}

		return adminBean;
	}

	public void updateAdmin(AdminDto adminBean) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {
			con = db.getConnection();
			sql = "update admin set pwd=? where id=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, adminBean.getPw());
			ps.setString(2, adminBean.getId());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}

	}

	public void deleteAdmin(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {
			con = db.getConnection();
			sql = "delete from admin where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}
	
	//관리자 로그인 (윤)
		public int adminLogin(String id, String pw) {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			String sql=null;
			int flag = 0;			
			
			try {
				con=db.getConnection();
				sql="select * from admin where id=? and pw=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pw);
				rs=ps.executeQuery();
				if(rs.next()) {
					flag = 2;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return flag;
		}

}
