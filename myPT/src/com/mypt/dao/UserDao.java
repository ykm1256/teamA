package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mypt.connection.DBConnection;
import com.mypt.dto.UserDto;

public class UserDao {
	private DBConnection instance;
	
	public UserDao() {
		instance=DBConnection.getInstance();
	}
	
	public void insertUser(UserDto userBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=instance.getConnection();
			sql= "insert user(id,pw,name,gender,email,birth,"
					+ "address,qr,signdate,nick,startdate,enddate,"
					+ "ptcount,tid) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, userBean.getId());
			ps.setString(2, userBean.getPw());
			ps.setString(3, userBean.getName());
			ps.setInt(4, userBean.getGender());
			ps.setString(5, userBean.getEmail());
			ps.setString(6, userBean.getBirth());
			ps.setString(7, userBean.getAddress());
			ps.setString(8, userBean.getQr());
			ps.setTimestamp(9, userBean.getSigndate());
			ps.setString(10, userBean.getNick());
			ps.setDate(11, userBean.getStartdate());
			ps.setDate(12, userBean.getEnddate());
			ps.setInt(13, userBean.getPtcount());
			ps.setString(14, userBean.getTid());
			
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
	
	public UserDto getUser(String id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=null;
		UserDto userBean=new UserDto();
		
		try {
			con=instance.getConnection();
			sql="select * from user where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				userBean.setId(rs.getString("id"));
				userBean.setPw(rs.getString("pw"));
				userBean.setName(rs.getString("name"));
				userBean.setGender(rs.getInt("gender"));
				userBean.setEmail(rs.getString("email"));
				userBean.setBirth(rs.getString("birth"));
				userBean.setAddress(rs.getString("address"));
				userBean.setQr(rs.getString("qr"));
				userBean.setSigndate(rs.getTimestamp("signdate"));
				userBean.setNick(rs.getString("nick"));
				userBean.setStartdate(rs.getDate("startdate"));
				userBean.setEnddate(rs.getDate("enddate"));
				userBean.setTid(rs.getString("tid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userBean;
	}
	
	public void updateUser(UserDto userBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=instance.getConnection();
			sql= "update user set pwd=?,name=?,gender=?,email=?,"
					+ "birth=?,address=?,qr=?,signdate=?,nick=?,"
					+ "startdate=?,enddate=?,ptcount=?,tid=? "
					+ "where id=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, userBean.getPw());
			ps.setString(2, userBean.getName());
			ps.setInt(3, userBean.getGender());
			ps.setString(4, userBean.getEmail());
			ps.setString(5, userBean.getBirth());
			ps.setString(6, userBean.getAddress());
			ps.setString(7, userBean.getQr());
			ps.setTimestamp(8, userBean.getSigndate());
			ps.setString(9, userBean.getNick());
			ps.setDate(10, userBean.getStartdate());
			ps.setDate(11, userBean.getEnddate());
			ps.setInt(12, userBean.getPtcount());
			ps.setString(13, userBean.getTid());
			ps.setString(14, userBean.getId());
			
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
	
	public void deleteUser(String id) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=instance.getConnection();
			sql= "delete from user where id=?";
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
