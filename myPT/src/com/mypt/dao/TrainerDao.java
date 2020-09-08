package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypt.connection.DBConnection;
import com.mypt.dto.TrainerDto;

public class TrainerDao {
	private DBConnection db;
	
//////////dao 싱글톤 (이)
private static TrainerDao instance = new TrainerDao();
public static TrainerDao getInstance() 
{
return instance;
}
	
	private TrainerDao() {
		db = DBConnection.getInstance();
	}

	public void trainerInsert(TrainerDto td) {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "insert into trainer values(?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, td.getT_id());
			ps.setString(2, td.getT_pw());
			ps.setString(3, td.getT_name());
			ps.setString(4, td.getT_gender());
			ps.setString(5, td.getT_email());
			ps.setString(6, td.getT_birth());
			ps.setString(7, td.getT_address());
			ps.setString(8, td.getT_nick());
			ps.setString(9, td.getT_zipcode());
			ps.setString(10, td.getT_tel());
			ps.setString(11, td.getT_addrdetail());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}

	}

	public TrainerDto trainerSelect(String t_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TrainerDto td = new TrainerDto();
		try {
			con = db.getConnection();
			String sql = "select * from trainer where t_id='" + t_id + "'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				td.setT_id(rs.getString("t_id"));
				td.setT_pw(rs.getString("t_pw"));
				td.setT_name(rs.getString("t_name"));
				td.setT_gender(rs.getString("t_gender"));
				td.setT_email(rs.getString("t_email"));
				td.setT_birth(rs.getString("t_birth"));
				td.setT_address(rs.getString("t_address"));
				td.setT_nick(rs.getString("t_nick"));
				td.setT_zipcode(rs.getString("t_zipcode"));
				td.setT_tel(rs.getString("t_tel"));
				td.setT_addrdetail(rs.getString("t_addrdetail"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		return td;
	}
	
	public void trainerUpdate(TrainerDto td) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "update trainer set t_pw=?, t_name=?, t_gender=?, t_email=?, t_birth=?, t_address=?, t_nick=?,t_zipcode=?, t_tel=?, t_addrdetail=? where t_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, td.getT_pw());
			ps.setString(2, td.getT_name());
			ps.setString(3, td.getT_gender());
			ps.setString(4, td.getT_email());
			ps.setString(5, td.getT_birth());
			ps.setString(6, td.getT_address());
			ps.setString(7, td.getT_nick());
			ps.setString(8, td.getT_zipcode());
			ps.setString(9, td.getT_tel());
			ps.setString(10, td.getT_addrdetail());
			ps.setString(11, td.getT_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}

	public void trainerDelete(String t_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "delete from trainer where t_id = '" + t_id + "'";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}

	}
	
	// 트레이너 리스트 보기
	public ArrayList<TrainerDto> trainerList(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TrainerDto> arr = new ArrayList<TrainerDto>();
		TrainerDto td = null;
		try {
			con = db.getConnection();
			String sql = "select * from trainer";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				td = new TrainerDto();
				td.setT_id(rs.getString("t_id"));
				td.setT_pw(rs.getString("t_pw"));
				td.setT_name(rs.getString("t_name"));
				td.setT_gender(rs.getString("t_gender"));
				td.setT_email(rs.getString("t_email"));
				td.setT_birth(rs.getString("t_birth"));
				td.setT_address(rs.getString("t_address"));
				td.setT_nick(rs.getString("t_nick"));
				td.setT_addrdetail(rs.getString("t_addrdetail"));
				td.setT_zipcode(rs.getString("t_zipcode"));
				arr.add(td);
			}
			
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		
		return arr;
	}
	
	//트레이너 로그인
	public int trainerLogin(String id, String pw) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=null;
		int flag = 0;
		
		
		try {
			con=db.getConnection();
			sql="select * from trainer where t_id=? and t_pw=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs=ps.executeQuery();
			if(rs.next()) {
				flag = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}
