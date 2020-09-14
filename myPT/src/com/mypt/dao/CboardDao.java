package com.mypt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

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

			String sql = "insert into cboard(cb_title, cb_writer, cb_head, cb_content, cb_hit, cb_like, cb_ref, cb_depth, cb_pos) values(?,?,?,?,?,?,?,?,?)";
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

			String sql = "update cboard set cb_title=?, cb_head=?, cb_content=? where cb_num=?";
			try {
				con = db.getConnection();
				ps = con.prepareStatement(sql);
				
				ps.setString(1, dto.getTitle());
				ps.setString(2, dto.getHead());
				ps.setString(3, dto.getContent());				
				ps.setInt(4, dto.getNum());

				ps.executeUpdate();
				System.out.println(sql);

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

		// 유저가 쓴글 목록
		public ArrayList<CboardDto> userList(String nick) 
		{
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ArrayList<CboardDto> arr= new ArrayList<CboardDto>();

			String sql = "select *,date_format(cb_date,'%Y-%m-%d %H:%i') from cboard where cb_writer=?";

			try {
				con = db.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, nick);
				rs = ps.executeQuery();

				while(rs.next()) 
				{
					CboardDto dto = new CboardDto();

					dto.setTitle(rs.getString("cb_title"));
					dto.setWriter(rs.getString("cb_writer"));
					dto.setHit(rs.getInt("cb_hit"));
					dto.setNum(rs.getInt("cb_num"));
					dto.setDate(rs.getString(12));					
										
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
			
			String sql = "select * from cboard where cb_num=?";
			try 
			{
				con = db.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);

				rs = ps.executeQuery();
				
				if(rs.next())
				{
					dto = new CboardDto();
					dto.setNum(num);
					dto.setTitle(rs.getString("cb_title"));
					dto.setWriter(rs.getString("cb_writer"));
					dto.setDate(rs.getTimestamp("cb_date").toString());
					dto.setHit(rs.getInt("cb_hit")+1);
					dto.setContent(rs.getString("cb_content"));
					dto.setLike(rs.getInt("cb_like"));	
					dto.setHead(rs.getString("cb_head"));	
					dto.setRef(rs.getInt("cb_ref"));	
					dto.setDepth(rs.getInt("cb_depth"));	
					dto.setPos(rs.getInt("cb_pos"));	
					
					upCount(num);
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
//		public ArrayList<CboardDto> mycb_likeList(ArrayList<Integer> nums) 
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
//						dto.setcb_date(rs.getTimestamp("cb_cb_date"));
//						dto.setcb_like(rs.getInt("cb_like"));
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
	public ArrayList<CboardDto> mylikeList(ArrayList<Integer> nums) 
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
				dto.setHit(rs.getInt("cb_hit"));
				dto.setDate(rs.getTimestamp("cb_date").toString());
				dto.setLike(rs.getInt("cb_cb_like"));
										
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
	
	
	
	//Board Insert : 파일업로드, contentType, ref의 상대적인 위치값
		public void insertBoard(CboardDto dto) {
			Connection con = null;
			PreparedStatement ps = null;
			String sql = null;
			try {
				
				///답변을 위한 ref 설정/////
				int ref = getMaxNum() + 1;
				con = db.getConnection();
				sql = "insert into cboard(cb_writer,cb_content,cb_title,cb_ref,cb_pos,cb_depth,";
				sql += "cb_hit, cb_like, cb_head)";
				sql += "values(?, ?, ?, ?, 0, 0, 0, 0,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getWriter());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getTitle());
				ps.setInt(4, ref);				
				ps.setString(5, dto.getHead());				
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(null, ps, con);
			}
		}
	
	//Board Max Num : cb_ref에 저장에 필요한 기능
		public int getMaxNum() {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = null;
			int maxNum = 0;
			try{
				con = db.getConnection();
				sql = "select max(cb_num) from cboard";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) maxNum = rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(rs,ps,con);
			}
			return maxNum;
		}
		
		//Board Total Count : 총 게시물수
		public int getTotalCount(String keyField, String keyWord,String head) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = null;
			int totalCount = 0;
			try {
				con = db.getConnection();
				//검색이 아닌경우
				if(keyWord.trim().equals("")||keyWord==null) {
					//말머리 전체보기
					if(head.equals("all")) {
						sql = "select count(*) from cboard";
					}else { // 말머리 선택됨
						sql = "select count(*) from cboard where cb_head='"+head+"'";
					}					
					ps = con.prepareStatement(sql);
				}else {
					//검색인 경우
					if(head.equals("all")) {
						sql = "select count(*) from cboard where " 
								+ keyField +" like '%"+keyWord+"%'";
					}else { // 말머리 선택됨
						sql = "select count(*) from cboard where " 
								+ keyField +" like '%"+keyWord+"%' and cb_head='"+head+"'";
					}	
										
					System.out.println(sql);
					ps = con.prepareStatement(sql);
					
				}
				rs = ps.executeQuery();
				if(rs.next()) totalCount = rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(rs,ps,con);
			}
			return totalCount;
		}
		
		//Board List : 페이지당 보여줄 갯수만 리턴, 검색 포함.
		//keyField : 선택옵션(name, subject, content)
		//keyWord : 검색어
		//start : 시작번호, cnt : 한 페이지당 가져올 게시물 개수 
		public Vector<CboardDto> getBoardList(String keyField, 
				String keyWord,int start, int cnt,String head){
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = null;
			Vector<CboardDto> vlist = new Vector<CboardDto>();
			
			try {
				con = db.getConnection();
				//검색이 아닌경우
				if(keyWord.trim().equals("")||keyWord==null) {
					// 말머리 전체보기
					if(head.equals("all")) {
					sql = "select *,date_format(cb_date,'%Y-%m-%d %H:%i') from cboard order by cb_ref desc, cb_pos "
								+ "limit ?,?";
					}else {
						sql = "select *,date_format(cb_date,'%Y-%m-%d %H:%i') from cboard where cb_head='"+head+"' order by cb_ref desc, cb_pos "
								+ "limit ?,?";
					}
					
					ps = con.prepareStatement(sql);					
					ps.setInt(1, start);
					ps.setInt(2, cnt);
				}else {//검색인 경우
					//말머리 전체보기					
					if(head.equals("all")) {
						sql = "select *,date_format(cb_date,'%Y-%m-%d %H:%i') from cboard where "+keyField+" like '%"+keyWord+"%' order by cb_ref desc, cb_pos limit ?,?";
					}else {
							sql = "select *,date_format(cb_date,'%Y-%m-%d %H:%i') from cboard where ? like '%"+keyWord+"%' and cb_head='"+head+"' order by cb_ref desc, cb_pos "
									+ "limit ?,?";
					}
//					sql = "select * from cboard where " + keyField 
//							+" like ? order by cb_ref desc, cb_pos limit ?,?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, start);
					ps.setInt(2, cnt);
				}
				
				rs = ps.executeQuery();
				while(rs.next()) {					
					CboardDto bean = new CboardDto();
					bean.setNum(rs.getInt("cb_num"));
					bean.setWriter(rs.getString("cb_writer"));
					bean.setTitle(rs.getString("cb_title"));
					bean.setPos(rs.getInt("cb_pos"));
					bean.setRef(rs.getInt("cb_ref"));
					bean.setDepth(rs.getInt("cb_depth"));
					bean.setDate(rs.getString(12));
					bean.setHit(rs.getInt("cb_hit"));				
					bean.setHead(rs.getString("cb_head"));
					bean.setLike(rs.getInt("cb_like"));	
					vlist.addElement(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(rs,ps,con);
			}
			return vlist;
		}		
		
		
		//Count Up : 조회수 증가
		public void upCount(int num) {
			Connection con = null;
			PreparedStatement ps = null;
			String sql = null;
			try {
				con = db.getConnection();
				sql = "update cboard set cb_hit = cb_hit +1 where cb_num = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(null,ps,con);
			}
		}
				
		//Board Delete 원본글
		public void deleteBoard(int ref, int depth) {
			Connection con = null;
			PreparedStatement ps = null;
			String sql = null;
			try {				
				con = db.getConnection();
				sql = "delete from cboard where cb_ref=? and cb_depth>=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, ref);
				ps.setInt(2, depth);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(null,ps,con);
			}
		}
		
		//Board Delete 답글
				public void deletereply(int num) {
					Connection con = null;
					PreparedStatement ps = null;
					String sql = null;
					try {
						
						con = db.getConnection();
						sql = "delete from cboard where cb_num=?";
						ps = con.prepareStatement(sql);
						ps.setInt(1, num);
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						db.closeConnection(null,ps,con);
					}
				}
		
		
		
		
		//Board Reply: 답변글 저장
		public void replyBoard(CboardDto bean) {
			Connection con = null;
			PreparedStatement ps = null;
			String sql = null;
			try {
				con = db.getConnection();
				sql = "insert cboard(cb_writer,cb_content,cb_title,cb_ref,cb_pos,cb_depth,"
						+ "cb_hit,cb_like)values(?, ?, ?, ?, ?, ?, 0, 0)";
				ps = con.prepareStatement(sql);
				ps.setString(1, bean.getWriter());
				ps.setString(2, bean.getContent());
				ps.setString(3, bean.getTitle());
				///////////////////////////////////
				ps.setInt(4, bean.getRef());//원글과 동일한 cb_ref
				ps.setInt(5, bean.getPos()+1);//원글의 cb_pos+1
				ps.setInt(6, bean.getDepth()+1);//원글의 cb_depth+1
				///////////////////////////////////			
				
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(null,ps,con);
			}
		}
		
		//Board Reply Up : 답변글 위치값 조정 
		//답변하고자는 게시물의 cb_pos 값보다 큰 값들을 1씩 증가
		public void replyUpBoard(int cb_ref, int cb_pos) {
			Connection con = null;
			PreparedStatement ps = null;
			String sql = null;
			try {
				con = db.getConnection();
				sql = "update cboard set cb_pos=cb_pos+1 where cb_ref=? and cb_pos>?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cb_ref);
				ps.setInt(2, cb_pos);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(null,ps,con);
			}
		}
		
		
		
		//Post 1000 : 페이징 및 블럭 처리를 위해 게시물 1000개 삽입.
		public void post1000(){
			Connection con = null;
			PreparedStatement ps = null;
			String sql = null;
			try {
				con = db.getConnection();
				sql = "insert into cboard(cb_writer,cb_content,cb_title,cb_ref,cb_pos,cb_depth,cb_hit,cb_head,cb_like)";
				sql+="values('아이유', 'hello', 'hi', 0, 0, 0, 0, '정보', 0);";
				ps = con.prepareStatement(sql);
				for (int i = 0; i < 10; i++) {
					ps.executeUpdate();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection(null, ps, con);
			}
		}

		public static void main(String[] args) {
			CboardDao dao = CboardDao.getInstance();
			dao.post1000();
			System.out.println("성공~~");
		}

		@Override
		public ArrayList<CboardDto> getList() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		//start : 시작번호, cnt : 한 페이지당 가져올 게시물 개수 
				public ArrayList<CboardDto> getBoardList2(String keyField, 
						String keyWord,int start, int cnt,String head){
					Connection con = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					String sql = null;
					ArrayList<CboardDto> arr = new ArrayList<CboardDto>();
					
					try {
						con = db.getConnection();
						//검색이 아닌경우
						if(keyWord.trim().equals("")||keyWord==null) {
							// 말머리 전체보기
							if(head.equals("all")) {
							sql = "select *,date_format(cb_date,'%Y-%m-%d %H:%i') from cboard order by cb_ref desc, cb_pos "
										+ "limit ?,?";
							}else {
								sql = "select *,date_format(cb_date,'%Y-%m-%d %H:%i') from cboard where cb_head='"+head+"' order by cb_ref desc, cb_pos "
										+ "limit ?,?";
							}
							
							ps = con.prepareStatement(sql);					
							ps.setInt(1, start);
							ps.setInt(2, cnt);
						}else {//검색인 경우
							//말머리 전체보기					
							if(head.equals("all")) {
								sql = "select *,date_format(cb_date,'%Y-%m-%d %H:%i') from cboard where "+keyField+" like '%"+keyWord+"%' order by cb_ref desc, cb_pos limit ?,?";
							}else {
									sql = "select *,date_format(cb_date,'%Y-%m-%d %H:%i') from cboard where "+keyField+" like '%"+keyWord+"%' and cb_head='"+head+"' order by cb_ref desc, cb_pos "
											+ "limit ?,?";
							}
//							sql = "select * from cboard where " + keyField 
//									+" like ? order by cb_ref desc, cb_pos limit ?,?";
							ps = con.prepareStatement(sql);
							ps.setInt(1, start);
							ps.setInt(2, cnt);
						}
						
						rs = ps.executeQuery();
						while(rs.next()) {					
							CboardDto bean = new CboardDto();
							bean.setNum(rs.getInt("cb_num"));
							bean.setWriter(rs.getString("cb_writer"));
							bean.setTitle(rs.getString("cb_title"));
							bean.setPos(rs.getInt("cb_pos"));
							bean.setRef(rs.getInt("cb_ref"));
							bean.setDepth(rs.getInt("cb_depth"));
							bean.setDate(rs.getString(12));
							bean.setHit(rs.getInt("cb_hit"));				
							bean.setHead(rs.getString("cb_head"));
							bean.setLike(rs.getInt("cb_like"));	
							arr.add(bean);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						db.closeConnection(rs,ps,con);
					}
					return arr;
				}		
		
		
	
	
} 
	
		
		


