package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mypt.connection.DBConnection;
import com.mypt.dto.AdminDto;

public class AdminDao {
private DBConnection instance;
	
	public AdminDao() {
		instance=DBConnection.getInstance();
	}
	
	public void insertAdmin(AdminDto adminBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=instance.getConnection();
			sql= "insert admin(id,pw) values(?,?) ";
			ps=con.prepareStatement(sql);
			ps.setString(1, adminBean.getId());
			ps.setString(2, adminBean.getPw());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public AdminDto getAdmin(String id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=null;
		AdminDto adminBean=new AdminDto();
		
		try {
			con=instance.getConnection();
			sql="select * from admin where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				adminBean.setId(rs.getString("id"));
				adminBean.setPw(rs.getString("pw"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return adminBean;
	}
	
	public void updateAdmin(AdminDto adminBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=instance.getConnection();
			sql= "update admin set pwd=? where id=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, adminBean.getPw());
			ps.setString(2, adminBean.getId());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void deleteAdmin(String id) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=instance.getConnection();
			sql= "delete from admin where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
		

}
