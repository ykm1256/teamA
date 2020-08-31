package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mypt.connection.DBConnection;
import com.mypt.dto.InbodyDto;


public class InbodyDao {
	private DBConnection instance;
	
	public InbodyDao(){
		instance=DBConnection.getInstance();
	}
	
	public void insertInbody(InbodyDto inbodyBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=instance.getConnection();
			sql= "insert inbody(i_id,i_date,muscle,fat,height,weight) "
					+ "values(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, inbodyBean.getI_id());
			ps.setTimestamp(2, inbodyBean.getI_date());
			ps.setFloat(3, inbodyBean.getMuscle());
			ps.setFloat(4, inbodyBean.getFat());
			ps.setFloat(4, inbodyBean.getHeight());
			ps.setFloat(4, inbodyBean.getWeight());
			
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
	
	public InbodyDto getInbody(String i_id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=null;
		InbodyDto inbodyBean=new InbodyDto();
		
		try {
			con=instance.getConnection();
			sql="select * from inbody where i_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, i_id);
			rs=ps.executeQuery();
			if(rs.next()) {
				inbodyBean.setI_id(rs.getString("i_id"));
				inbodyBean.setI_date(rs.getTimestamp("i_date"));
				inbodyBean.setMuscle(rs.getFloat("muscle"));
				inbodyBean.setFat(rs.getFloat("fat"));
				inbodyBean.setHeight(rs.getFloat("height"));
				inbodyBean.setWeight(rs.getFloat("weight"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inbodyBean;
	}
	
	public void updateInbody(InbodyDto inbodyBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=instance.getConnection();
			sql= "update inbody set i_date=?,muscle=?,fat=?,height=?,weight=?"
					+ " where i_id=?";
			ps=con.prepareStatement(sql);
			
			ps.setTimestamp(1, inbodyBean.getI_date());
			ps.setFloat(2, inbodyBean.getMuscle());
			ps.setFloat(3, inbodyBean.getFat());
			ps.setFloat(4, inbodyBean.getHeight());
			ps.setFloat(5, inbodyBean.getWeight());
			ps.setString(6, inbodyBean.getI_id());
			
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
	
	public void deleteInbody(String i_id) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=instance.getConnection();
			sql= "delete from inbody where i_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, i_id);
			
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
