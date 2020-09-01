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
import com.mypt.dto.PCommentDto;
import com.mypt.dto.QCommentDto;
import com.mypt.dto.TrainerDto;

public class QCommentDao {
	private DBConnection db;
	
	public QCommentDao() {
		db = DBConnection.getInstance();
	}

	public void qCommentInsert(QCommentDto qd) {

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "insert into qcomment (qb_num,qb_cnick,qb_ccontent) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, qd.getQb_cnum());			
			ps.setString(2, qd.getQb_cnick());			
			ps.setString(3, qd.getQb_ccontent());			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}

	}

	public QCommentDto qCommentSelect(int qb_cnum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		QCommentDto qd = new QCommentDto();
		try {
			con = db.getConnection();
			String sql = "select * from qcomment where qb_cnum='" + qb_cnum + "'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				qd.setQb_cnum(qb_cnum);
				qd.setQb_num(rs.getInt(2));
				qd.setQb_cnick(rs.getString(3));
				qd.setQb_ccontent(rs.getString(4));
				qd.setQb_cdate(Timestamp.valueOf(rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(rs, ps, con);
		}
		return qd;
	}
	
	public void qCommentUpdate(QCommentDto qd) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "update qcomment set qb_ccontent=?, qb_cdate=now() where qb_cnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, qd.getQb_ccontent());
			ps.setString(2, String.valueOf(qd.getQb_cdate()));
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}

	public void qCommentDelete(int qb_cnum) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "delete from qcomment where qb_cnum ="+ qb_cnum;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}

	}
	
	public ArrayList<QCommentDto> qCommentList(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<QCommentDto> arr = new ArrayList<QCommentDto>();
		QCommentDto qd = null;
		try {
			con = db.getConnection();
			String sql = "select * from qcomment";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				qd = new QCommentDto();
				qd.setQb_cnum(rs.getInt(1));
				qd.setQb_num(rs.getInt(2));
				qd.setQb_cnick(rs.getString(3));
				qd.setQb_ccontent(rs.getString(4));
				qd.setQb_cdate(Timestamp.valueOf(rs.getString(5)));
				arr.add(qd);
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
