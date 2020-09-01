package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypt.connection.DBConnection;
import com.mypt.dto.TrainerDto;

public class TrainerDao {
	private DBConnection instance;
	
	public TrainerDao() {
		instance = DBConnection.getInstance();
	}

	public void trainerInsert(TrainerDto td) {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = instance.getConnection();
			String sql = "insert into trainer values(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, td.getT_id());
			ps.setString(2, td.getT_pw());
			ps.setString(3, td.getT_name());
			ps.setInt(4, td.getT_gender());
			ps.setString(5, td.getT_email());
			ps.setString(6, td.getT_birth());
			ps.setString(7, td.getT_address());
			ps.setString(8, td.getT_nick());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(null, ps, con);
		}

	}

	public TrainerDto trainerSelect(String t_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TrainerDto td = new TrainerDto();
		try {
			con = instance.getConnection();
			String sql = "select * from trainer where t_id='" + t_id + "'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				td.setT_id(rs.getString(1));
				td.setT_pw(rs.getString(2));
				td.setT_name(rs.getString(3));
				td.setT_gender(Integer.parseInt(rs.getString(4)));
				td.setT_email(rs.getString(5));
				td.setT_birth(rs.getString(6));
				td.setT_address(rs.getString(7));
				td.setT_nick(rs.getString(8));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(rs, ps, con);
		}
		return td;
	}
	
	public void trainerUpdate(TrainerDto td) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = instance.getConnection();
			String sql = "update trainer set t_pw=?, t_name=?, t_gender=?, t_email, t_birth, t_address, t_nick where t_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, td.getT_pw());
			ps.setString(2, td.getT_name());
			ps.setInt(3, td.getT_gender());
			ps.setString(4, td.getT_email());
			ps.setString(5, td.getT_birth());
			ps.setString(6, td.getT_address());
			ps.setString(7, td.getT_nick());
			ps.setString(8, td.getT_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(null, ps, con);
		}
	}

	public void trainerDelete(String t_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = instance.getConnection();
			String sql = "delete from trainer where t_id = '" + t_id + "'";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(null, ps, con);
		}

	}
	
	public ArrayList<TrainerDto> trainerList(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TrainerDto> arr = new ArrayList<TrainerDto>();
		TrainerDto td = null;
		try {
			con = instance.getConnection();
			String sql = "select * from trainer";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				td = new TrainerDto();
				td.setT_id(rs.getString(1));
				td.setT_pw(rs.getString(2));
				td.setT_name(rs.getString(3));
				td.setT_gender(rs.getInt(4));
				td.setT_email(rs.getString(5));
				td.setT_birth(rs.getString(6));
				td.setT_address(rs.getString(7));
				td.setT_nick(rs.getString(8));
				arr.add(td);
			}
			
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(rs, ps, con);
		}
		
		return arr;
	}

	

}
