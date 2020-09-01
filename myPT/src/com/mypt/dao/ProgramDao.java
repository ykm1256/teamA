package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mypt.connection.DBConnection;
import com.mypt.dto.ProgramDto;


public class ProgramDao {
	private DBConnection db;
	
	public ProgramDao(){
		db=DBConnection.getInstance();
	}
	
	public void insertProgram(ProgramDto programBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=db.getConnection();
			sql= "insert program(p_id,p_date,p_mention,p_part) "
					+ "valuse(?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, programBean.getP_id());
			ps.setDate(2, programBean.getP_date());
			ps.setString(3, programBean.getP_mention());
			ps.setString(4, programBean.getP_part());
			
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
	
	public ProgramDto getProgram(String p_id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=null;
		ProgramDto programBean=new ProgramDto();
		
		try {
			con=db.getConnection();
			sql="select * from program where p_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, p_id);
			rs=ps.executeQuery();
			if(rs.next()) {
				programBean.setP_id(rs.getString("p_id"));
				programBean.setP_date(rs.getDate("p_date"));
				programBean.setP_mention(rs.getString("p_mention"));
				programBean.setP_part(rs.getString("p_part"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return programBean;
	}
	
	public void updateProgram(ProgramDto programBean) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=db.getConnection();
			sql= "update program set p_date=?,p_mention=?,p_part=? where p_id=?";
			ps=con.prepareStatement(sql);
			
			ps.setDate(1, programBean.getP_date());
			ps.setString(2, programBean.getP_mention());
			ps.setString(3, programBean.getP_part());
			ps.setString(4, programBean.getP_id());
			
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
	
	public void deleteProgram(String p_id) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=db.getConnection();
			sql= "delete from program where p_id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, p_id);
			
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
