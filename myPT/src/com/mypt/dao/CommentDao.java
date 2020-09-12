package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mypt.connection.DBConnection;
import com.mypt.dto.CCommentDto;
import com.mypt.dto.CommentDto;

public class CommentDao {
	private DBConnection db;

	private static CommentDao instance = new CommentDao();
	public static CommentDao getInstance() 
	{
		return instance;
	}
	
	private CommentDao() 
	{
		db = DBConnection.getInstance();
	}
	

	public int commentInsert(String commenttblName, CommentDto comment) {

		Connection con = null;
		PreparedStatement ps = null;
		
		int result= 0;
		
		try 
		{
			con = db.getConnection();
			
			String sql = "insert into "+ commenttblName+"(boardNum, c_nick, c_content) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, comment.getBoardNum());			
			ps.setString(2, comment.getC_nick());			
			ps.setString(3, comment.getC_content());	
			
			result= ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			db.closeConnection(null, ps, con);
		}
		
		return result;

	}
	
	//최근에 입력된 댓글
	public CommentDto getLastComment(String commenttblName, int boardNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CommentDto cd = new CommentDto();
		
		try {
			con = db.getConnection();
			String sql = "SELECT * FROM "+ commenttblName+ " WHERE boardnum=? ORDER BY c_num DESC LIMIT 1";
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			
			if (rs.next()) 
			{
				cd.setC_num(rs.getInt(1));
				cd.setBoardNum(boardNum);
				cd.setC_nick(rs.getString(3));
				cd.setC_content(rs.getString(4));
				cd.setC_date(rs.getTimestamp(5));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			db.closeConnection(rs, ps, con);
		}
		return cd;
	}
	
	//detailview에서의 댓글리스트
	public ArrayList<CommentDto> commentList(String commenttblName, int boardNum){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<CommentDto> arr = new ArrayList<CommentDto>();	
		CommentDto cd = null;	

		
		try {
			con = db.getConnection();
			String sql = "select * from "+commenttblName +" where boardNum=?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				cd = new CommentDto();
				cd.setC_num(rs.getInt(1));
				cd.setBoardNum(boardNum);
				cd.setC_nick(rs.getString(3));
				cd.setC_content(rs.getString(4));
				cd.setC_date(rs.getTimestamp(5));
				
				arr.add(cd);			
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			db.closeConnection(rs, ps, con);
		}
		
		return arr;
	}
		
//	public JsonArray commentList(String commenttblName, int boardNum)
//	{
//			Connection con = null;
//			PreparedStatement ps = null;
//			ResultSet rs = null;
//			
//			CommentDto cd = null;			
//			Gson gson = new Gson();
//			JsonArray arr = new JsonArray();
//			JsonObject obj = null;
//			
//			try {
//				con = db.getConnection();
//				String sql = "select * from "+commenttblName +" where boardNum=?";
//				ps = con.prepareStatement(sql);
//				ps.setInt(1, boardNum);
//				rs = ps.executeQuery();
//				
//				while(rs.next()) 
//				{
//					cd = new CommentDto();
//					cd.setC_num(rs.getInt(1));
//					cd.setBoardNum(boardNum);
//					cd.setC_nick(rs.getString(3));
//					cd.setC_content(rs.getString(4));
//					cd.setC_date(rs.getTimestamp(5));
//				
//					String aa = gson.toJson(cd);
//					obj = gson.fromJson(aa, JsonObject.class);
//					arr.add(obj);		
//				}
//			} 
//			catch (Exception e) 
//			{
//				e.printStackTrace();
//			} 
//			finally 
//			{
//				db.closeConnection(rs, ps, con);
//			}
//			
//			return arr;
//		}
	
	
	public int commentDelete(String commenttblName, int cnum) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		int result =0;
		
		try {
			con = db.getConnection();
			String sql = "delete from "+ commenttblName+ " where c_num=?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, cnum);
			
			result= ps.executeUpdate();			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			db.closeConnection(null, ps, con);
		}
		
		return result;

	}
	
	public void commentUpdate(CCommentDto cd) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			String sql = "update ccomment set cb_ccontent=?, cb_cdate=now() where cb_cnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cd.getcb_ccontent());
			ps.setString(2, String.valueOf(cd.getcb_cdate()));
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection(null, ps, con);
		}
	}


	

		
	
		
//	public int commentCountforOne(String commenttblName, int boardNum) {
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		int count= 0;
//		
//		try {
//			con = db.getConnection();
//			String sql = "select count(c_num) from "+ commenttblName+ " where boardnum=?";
//			ps = con.prepareStatement(sql);
//			
//			ps.setInt(1, boardNum);
//			
//			rs = ps.executeQuery();
//			
//			
//			if (rs.next()) 
//			{
//				count = rs.getInt(1);
//			}
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		} 
//		finally 
//		{
//			db.closeConnection(rs, ps, con);
//		}
//		return count;
//	}
	
	//해당 글 댓글 수 가져오기
	public int countComment(String commenttblName, int boardNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			con = db.getConnection();
			String sql = "SELECT count(*) FROM "+ commenttblName+ " WHERE boardnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNum);		
			rs = ps.executeQuery();
			System.out.println(sql);
			
			if (rs.next()) 
			{
				cnt = rs.getInt(1);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			db.closeConnection(rs, ps, con);
		}
		return cnt;
	}
	
	//해당 글 댓글 수 가져오기
		public int countUserComment(String commenttblName, int boardNum,String nick) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int cnt = 0;
			
			try {
				con = db.getConnection();
				String sql = "SELECT count(*) FROM "+ commenttblName+ " WHERE boardnum=? and c_nick=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, boardNum);		
				ps.setString(2, nick);		
				rs = ps.executeQuery();
				System.out.println(sql);
				
				if (rs.next()) 
				{
					cnt = rs.getInt(1);
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				db.closeConnection(rs, ps, con);
			}
			return cnt;
		}
	
	


}
