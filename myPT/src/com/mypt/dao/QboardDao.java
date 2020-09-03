package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mypt.dto.QboardDto;



public class QboardDao extends AbstractBoardDao<QboardDto>
{

	private static QboardDao instance = new QboardDao();
	public static QboardDao getInstance() 
	{
		return instance;
	}
	
	private QboardDao(){}
	
	@Override
	public void insert(QboardDto dto) 
	{
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into qboard(qb_title, qb_writer, qb_head, qb_content, hit, qb_ref, qb_depth, qb_pos) values(?,?,?,?,?,?,?,?)";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getWriter());
			ps.setString(3, dto.getHead());
			ps.setString(4, dto.getContent());
			ps.setInt(5, 0);
			ps.setInt(6, dto.getRef());
			ps.setInt(7, dto.getDepth());
			ps.setInt(8, dto.getPos());
			
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
	public void update(QboardDto dto) 
	{
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update qboard set qb_title=?, qb_head=?, qb_content=? where num=?";
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

	@Override
	public ArrayList<QboardDto> getList() 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<QboardDto> arr = new ArrayList<QboardDto>();

		String sql = "select qb_title, qb_writer, qb_date, hit from qboard";

		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				QboardDto dto = new QboardDto();

				dto.setTitle(rs.getString("qb_title"));
				dto.setWriter(rs.getString("qb_writer"));
				dto.setDate(rs.getTimestamp("qb_date"));
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

	@Override
	public QboardDto detailView(int num) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		QboardDto dto = null;

		String sql = "select qb_title, qb_writer, qb_date, hit, qb_content from qboard where num=?";

		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, num);
			
			rs = ps.executeQuery();

			if (rs.next()) 
			{
				dto = new QboardDto();

				dto.setTitle(rs.getString(1));
				dto.setWriter(rs.getString(2));
				dto.setDate(rs.getTimestamp(3));
				dto.setHit(rs.getInt(4)+1);
				dto.setContent(rs.getString(5));
				
				updateHit(num, "qboard");
				
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

}
