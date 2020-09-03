package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypt.dto.CboardDto;


public class CboardDao extends AbstractBoardDao<CboardDto>
{
	private static CboardDao instance = new CboardDao();
	public static CboardDao getInstance() 
	{
		return instance;
	}
	
	private CboardDao(){}
	

		public void insert(CboardDto dto) 
		{
			Connection con = null;
			PreparedStatement ps = null;

			String sql = "insert into cboard(cb_title, cb_writer, cb_head, cb_content, hit, like, cb_ref, cb_depth, cb_pos) values(?,?,?,?,?,?,?,?,?)";
			try {
				con = db.getConnection();
				ps = con.prepareStatement(sql);

				ps.setString(1, dto.getTitle());
				ps.setString(2, dto.getWriter());
				ps.setString(3, dto.getHead());
				ps.setString(4, dto.getContent());
				ps.setInt(5, 0);
				ps.setInt(6, 0);
				ps.setInt(7, dto.getRef());
				ps.setInt(8, dto.getDepth());
				ps.setInt(9, dto.getPos());
				
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


		public void update(CboardDto dto) 
		{
			Connection con = null;
			PreparedStatement ps = null;

			String sql = "update cboard set cb_title=?, cb_head=?, cb_content=? where num=?";
			try {
				con = db.getConnection();
				ps = con.prepareStatement(sql);
				
				ps.setString(1, dto.getTitle());
				ps.setString(2, dto.getHead());
				ps.setString(3, dto.getContent());
				
				ps.setInt(4, dto.getNum());

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

		
		public ArrayList<CboardDto> getList() 
		{
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ArrayList<CboardDto> arr= new ArrayList<CboardDto>();

			String sql = "select * from cboard";

			try {
				con = db.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()) 
				{
					CboardDto dto = new CboardDto();

					dto.setTitle(rs.getString("cb_title"));
					dto.setWriter(rs.getString("cb_writer"));					
					dto.setHead(rs.getString("cb_head"));
					dto.setHit(rs.getInt("hit"));
					dto.setDate(rs.getTimestamp("cb_date"));
					dto.setLike(rs.getInt("like"));
										
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
			
		
		public CboardDto detailView(int num) 
		{
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			CboardDto dto= null;
			
			String sql = "select cb_title, cb_writer, cb_date, hit, cb_content, like from cboard where num=?";
			try 
			{
				con = db.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);

				rs = ps.executeQuery();
				
				if(rs.next())
				{
					dto = new CboardDto();
									
					dto.setTitle(rs.getString(1));
					dto.setWriter(rs.getString(2));
					dto.setDate(rs.getTimestamp(3));
					dto.setHit(rs.getInt(4)+1);
					dto.setContent(rs.getString(5));
					dto.setLike(rs.getInt(6));	
					
					updateHit(num, "cboard");
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
//		public ArrayList<CboardDto> myLikeList(ArrayList<Integer> nums) 
//		{
//			Connection con = null;
//			PreparedStatement ps = null;
//			ResultSet rs = null;
//			
//			ArrayList<CboardDto> arr= new ArrayList<CboardDto>();
//
//			String sql = "select * from cboard where num=?";
//
//			try 
//			  {
//				con = db.getConnection();
//				
//				
//				for(int num : nums)
//				{
//					ps = con.prepareStatement(sql);
//					ps.setInt(1, num);
//					
//					rs = ps.executeQuery();
//
//					if(rs.next()) 
//					{
//						CboardDto dto = new CboardDto();
//
//						dto.setTitle(rs.getString("cb_title"));
//						dto.setWriter(rs.getString("cb_writer"));					
//						dto.setHead(rs.getString("cb_head"));
//						dto.setHit(rs.getInt("hit"));
//						dto.setDate(rs.getTimestamp("cb_date"));
//						dto.setLike(rs.getInt("like"));
//											
//						arr.add(dto);
//					}	
//				}
//				
//				
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
		
///		좋아요 리스트 확인요함
	public ArrayList<CboardDto> myLikeList(ArrayList<Integer> nums) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<CboardDto> arr= new ArrayList<CboardDto>();
	
		StringBuffer sb = new StringBuffer(300);
		
		for(int num : nums)
		{
			sb.append(",");
			sb.append(num);
		}
		sb.deleteCharAt(0);
		
		String numbers= sb.toString();
		
		String sql = "select * from cboard where num in ("+numbers+")";
	
	try 
	  {
		con = db.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
	
			while(rs.next()) 
			{
				CboardDto dto = new CboardDto();
	
				dto.setTitle(rs.getString("cb_title"));
				dto.setWriter(rs.getString("cb_writer"));					
				dto.setHead(rs.getString("cb_head"));
				dto.setHit(rs.getInt("hit"));
				dto.setDate(rs.getTimestamp("cb_date"));
				dto.setLike(rs.getInt("like"));
										
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
		
	
	
} 
	
		
		


