package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mypt.connection.DBConnection;
import com.mypt.dto.CCommentDto;
import com.mypt.dto.TrainerDto;

public class CCommentDao {
	private DBConnection instance;
	
	public CCommentDao() {
		instance = DBConnection.getInstance();
	}
	

	public void cCommentInsert(CCommentDto cd) {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = instance.getConnection();
			String sql = "insert into ccomment (cb_num,cb_cnick,cb_ccontent) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cd.getcb_cnum());			
			ps.setString(2, cd.getcb_cnick());			
			ps.setString(3, cd.getcb_ccontent());			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(null, ps, con);
		}

	}

	public CCommentDto cCommentSelect(int cb_cnum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CCommentDto cd = new CCommentDto();
		try {
			con = instance.getConnection();
			String sql = "select * from ccomment where cb_cnum='" + cb_cnum + "'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				cd.setcb_cnum(cb_cnum);
				cd.setcb_num(rs.getInt(2));
				cd.setcb_cnick(rs.getString(3));
				cd.setcb_ccontent(rs.getString(4));
				cd.setcb_cdate(Timestamp.valueOf(rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(rs, ps, con);
		}
		return cd;
	}
	
	public void cCommentUpdate(CCommentDto cd) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = instance.getConnection();
			String sql = "update ccomment set cb_ccontent=?, cb_cdate=now() where cb_cnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cd.getcb_ccontent());
			ps.setString(2, String.valueOf(cd.getcb_cdate()));
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(null, ps, con);
		}
	}

	public void cCommentDelete(int cb_cnum) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = instance.getConnection();
			String sql = "delete from ccomment where cb_cnum ="+ cb_cnum;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			instance.closeConnection(null, ps, con);
		}

	}
	
	public ArrayList<CCommentDto> cCommentList(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CCommentDto> arr = new ArrayList<CCommentDto>();
		CCommentDto cd = null;
		try {
			con = instance.getConnection();
			String sql = "select * from ccomment";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				cd = new CCommentDto();
				cd.setcb_cnum(rs.getInt(1));
				cd.setcb_num(rs.getInt(2));
				cd.setcb_cnick(rs.getString(3));
				cd.setcb_ccontent(rs.getString(4));
				cd.setcb_cdate(Timestamp.valueOf(rs.getString(5)));
				arr.add(cd);
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
