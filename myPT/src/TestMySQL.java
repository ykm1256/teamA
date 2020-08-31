import java.sql.Connection;
import java.sql.DriverManager;

public class TestMySQL {

	public static void main(String[] args) {
		Connection con;
		
		try {
			String url="jdbc:mysql://localhost:3306/mypt?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
			con=DriverManager.getConnection(url,"root","1234");
			
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println("실패"+e);
		}

	}

}
