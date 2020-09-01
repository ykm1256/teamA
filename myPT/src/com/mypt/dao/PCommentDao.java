package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mypt.connection.DBConnection;
import com.mypt.dto.PCommentDto;


public class PCommentDao {
	private DBConnection db;
	
	public PCommentDao() {
		db = DBConnection.getInstance();
	}

	public void pCommentInsert(PCommentDto pd) {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "insert into pcomment (pb_num,pb_cnick,pb_ccontent) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pd.getpb_cnum());			
			ps.setString(2, pd.getpb_cnick());			
			ps.setString(3, pd.getpb_ccontent());			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}

	}

	public PCommentDto pCommentSelect(int pb_cnum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PCommentDto pd = new PCommentDto();
		try {
			con = db.getConnection();
			String sql = "select * from pcomment where pb_cnum='" + pb_cnum + "'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				pd.setpb_cnum(pb_cnum);
				pd.setpb_num(rs.getInt(2));
				pd.setpb_cnick(rs.getString(3));
				pd.setpb_ccontent(rs.getString(4));
				pd.setpb_cdate(Timestamp.valueOf(rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		return pd;
	}
	
	public void pCommentUpdate(PCommentDto pd) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "update pcomment set pb_ccontent=?, pb_pdate=now() where pb_cnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pd.getpb_ccontent());
			ps.setString(2, String.valueOf(pd.getpb_cdate()));
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}

	public void pCommentDelete(int pb_cnum) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "delete from pcomment where pb_cnum ="+ pb_cnum;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}

	}
	public ArrayList<PCommentDto> pCommentList(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<PCommentDto> arr = new ArrayList<PCommentDto>();
		PCommentDto pd = null;
		try {
			con = db.getConnection();
			String sql = "select * from pcomment";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				pd = new PCommentDto();
				pd.setpb_cnum(rs.getInt(1));
				pd.setpb_num(rs.getInt(2));
				pd.setpb_cnick(rs.getString(3));
				pd.setpb_ccontent(rs.getString(4));
				pd.setpb_cdate(Timestamp.valueOf(rs.getString(5)));
				arr.add(pd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		return arr;
	}

	

}
