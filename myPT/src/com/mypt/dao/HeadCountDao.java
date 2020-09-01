package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mypt.connection.DBConnection;
import com.mypt.dto.HeadCountDto;

public class HeadCountDao {
	private DBConnection instance;
	
	public HeadCountDao() {
		instance = DBConnection.getInstance();
	}
	
	public void headcountInsert(HeadCountDto hd) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = instance.getConnection();
			String sql = "insert into headcount values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, hd.getH_id());
			ps.setString(2, String.valueOf(hd.getH_date()));
			ps.executeUpdate();			
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(null, ps, con);
		}
	}
	
	
	public int headcountSelect(String h_date, String intime) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = instance.getConnection();
			String sql = "select count(*) from headcount where h_date=? and intime=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, h_date);
			ps.setString(2, intime);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(rs, ps, con);
		}
		return count;
		
	}
	
	public void headcountUpdate(String h_id, String h_date) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = instance.getConnection();
			String sql = "update headcount set outtime=now() where h_id=? and h_date=?";
			ps = con.prepareStatement(sql);			
			ps.setString(1, h_id);
			ps.setString(2, h_date);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(null, ps, con);
		}				
	}
	
	public void headcountDelete(String h_id, String h_date) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = instance.getConnection();
			String sql = "delete from headcount where h_id=? and h_date=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, h_id);
			ps.setString(2, h_date);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(null, ps, con);
		}
	}


}
