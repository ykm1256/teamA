package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mypt.connection.DBConnection;
import com.mypt.dto.HistoryDto;


public class HistoryDao {
	private DBConnection db;
	
	public HistoryDao() {
		db=DBConnection.getInstance();
	}
	
	public void insertHistory(HistoryDto historyBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=db.getConnection();
			sql= "insert history(hid,paydate,price,hcount) "
					+ "valuse(?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, historyBean.getHid());
			ps.setString(2, historyBean.getPaydate());
			ps.setInt(3, historyBean.getPrice());
			ps.setInt(4, historyBean.getHcount());
			
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
	
	public HistoryDto getHistory(String hid) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=null;
		HistoryDto historyBean=new HistoryDto();
		
		try {
			con=db.getConnection();
			sql="select * from history where hid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, hid);
			rs=ps.executeQuery();
			if(rs.next()) {
				historyBean.setHid(rs.getString("hid"));
				historyBean.setPaydate(rs.getString("paydate"));
				historyBean.setPrice(rs.getInt("price"));
				historyBean.setHcount(rs.getInt("hcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return historyBean;
	}
	
	public void updateHistory(HistoryDto historyBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=db.getConnection();
			sql= "update history set paydate=?,price=?,hcount=? where hid=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, historyBean.getPaydate());
			ps.setInt(2, historyBean.getPrice());
			ps.setInt(3, historyBean.getHcount());
			ps.setString(4, historyBean.getHid());
			
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
	
	public void deleteHistory(String hid) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=db.getConnection();
			sql= "delete from history where hid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, hid);
			
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
