package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypt.dto.PboardDto;



public class PboardDao extends AbstractBoardDao<PboardDto>{

	private static PboardDao instance = new PboardDao();
	public static PboardDao getInstance() 
	{
		return instance;
	}
	
	private PboardDao(){}
	
	public void insert(PboardDto dto) 
	{
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into pboard(pb_title, pb_writer, pb_head, pb_content, hit, like, pb_photo) values(?,?,?,?,?,?,?)";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getWriter());
			ps.setString(3, dto.getHead());
			ps.setString(4, dto.getContent());
			ps.setInt(5, 0);
			ps.setInt(6, 0);
			ps.setString(7, dto.getPhoto());
			
			ps.executeUpdate();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			db.closeConnection(null, ps, con);
		}
	}

	@Override
	public void update(PboardDto dto) 
	{
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update pboard set pb_title=?, pb_head=?, pb_content=?, pb_photo=? where num=?";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getHead());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getPhoto());
			ps.setInt(5, dto.getNum());

			ps.executeUpdate();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			db.closeConnection(null, ps, con);
		}
	}
	


	public ArrayList<PboardDto> getList() 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<PboardDto> arr= new ArrayList<PboardDto>();

		String sql = "select * from pboard";

		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) 
			{
				PboardDto dto = new PboardDto();

				dto.setTitle(rs.getString("pb_title"));
				dto.setWriter(rs.getString("pb_writer"));
				dto.setDate(rs.getTimestamp("pb_date"));
				dto.setPhoto(rs.getString("pb_photo"));
				dto.setLike(rs.getInt("like"));
				dto.setHit(rs.getInt("hit"));	
				
				arr.add(dto);
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
	
	public PboardDto detailView(int num) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		PboardDto dto= null;
		
		String sql = "select pb_title, pb_writer, pb_date, hit, pb_content, like from pboard where num=?";
		try 
		{
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);

			rs = ps.executeQuery();
			
			if(rs.next())
			{
				dto = new PboardDto();
								
				dto.setTitle(rs.getString(1));
				dto.setWriter(rs.getString(2));
				dto.setDate(rs.getTimestamp(3));
				dto.setHit(rs.getInt(4)+1);
				dto.setContent(rs.getString(5));
				dto.setLike(rs.getInt(6));	
				
				updateHit(num, "pboard");
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
		
		return dto;
	
	}

///		좋아요 리스트 확인요함
	public ArrayList<PboardDto> myLikeList(ArrayList<Integer> nums) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<PboardDto> arr= new ArrayList<PboardDto>();


		String sql = "select * from pboard where num=?";

		try 
		  {
			con = db.getConnection();
			
			
			for(int num : nums)
			{
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);
				
				rs = ps.executeQuery();

				if(rs.next()) 
				{
					PboardDto dto = new PboardDto();
					
					dto.setTitle(rs.getString("pb_title"));
					dto.setWriter(rs.getString("pb_writer"));
					dto.setDate(rs.getTimestamp("pb_date"));
					dto.setPhoto(rs.getString("pb_photo"));
					dto.setLike(rs.getInt("like"));
					dto.setHit(rs.getInt("hit"));	
										
					arr.add(dto);
				}	
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

	

}
