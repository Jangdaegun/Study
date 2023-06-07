package studyjava03.helloDB;

import java.sql.*;

public class WelcomeDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "C:\\jdg\\DB\\Student.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from TempTable");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("Field2"));
				System.out.println(rs.getString("Field3"));
			}
			
			String sql = String.format("insert into TempTable values(%d,%d,%d)", 10,20,30);
			stat.execute(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (Exception e2) {

			}
		}
	}

}
