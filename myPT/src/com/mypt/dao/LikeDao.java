package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypt.connection.DBConnection;
import com.mypt.dto.LikeDto;


public class LikeDao 
{
	
	DBConnection db;
	
	private static LikeDao instance = new LikeDao();
	public static LikeDao getInstance() 
	{
		return instance;
	}
	
	private LikeDao()
	{
		db= DBConnection.getInstance();
	};
	

	//insert
	public int insert(LikeDto dto, String likeTblName, String boardName)
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		int result= 0;

		String sql = "insert into ? values(?,?)";
		try 
		{
			con = db.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, likeTblName);
			ps.setString(2, dto.getNick());
			ps.setInt(3, dto.getNum() );
			
			result= ps.executeUpdate();
			
			if(result==1)
			{
				PboardDao.getInstance().updateLike(dto.getNum(), boardName, 1);
			}

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
	
	
	//select //닉네임- 좋아요 게시글 번호
	public ArrayList<Integer> likeNum(String nickName, String likeTblName)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<Integer> arr = new ArrayList<Integer>();

		String sql="select num from ? where nick=?";
		
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, likeTblName);
			ps.setString(2, nickName);
			
			rs = ps.executeQuery();

			while(rs.next()) 
			{
				arr.add(rs.getInt(1));
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
	
	
	//update 불필요
	
	//delete
	public int delete(LikeDto dto, String likeTblName, String boardName)
	{
		Connection con = null;
		PreparedStatement ps = null;

		int result= 0;
		
		String sql = "delete from ? where num=? and nick=?";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, likeTblName);
			ps.setInt(2,dto.getNum());
			ps.setString(3,dto.getNick());
			
			result= ps.executeUpdate();
			
			if(result==1)
			{
				QboardDao.getInstance().updateLike(dto.getNum(), boardName, -1);
			}

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
}
