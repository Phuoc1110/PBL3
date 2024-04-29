package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.DangKi;
import Model.Hocvien;

public class DangKiDAO {
	
	public static DangKiDAO getInstance() {
		return new DangKiDAO();
	}

	public int insert(DangKi t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			String sql = "INSERT INTO dangki (maHV, maLH)"
					+ " values('" + t.getMaHV() + "', '" + t.getMaLH() + "')";
			ketqua = st.executeUpdate(sql);
			JDBCUtil.closeConnection(cnn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return ketqua;
	}

	public int delete(String idhv, String idlh) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "DELETE FROM giaovien where maHV = '" + idhv + "' and maLH = '" + idlh + "'";
			System.out.println(sql);
			
			ketqua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(cnn);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ketqua;
	}
	
	public ArrayList<String> getAllLopTheoTungHV(String id){
		ArrayList<String> list = new ArrayList<String>();
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "select maLH from dangki where maHV = '" + id + "'";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String maLH = rs.getString("maLH");
				list.add(maLH);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public ArrayList<String> getLopKhongDK(String id){
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT DISTINCT lophoc.maLH\r\n"
				+ "FROM lophoc\r\n"
				+ "WHERE lophoc.maLH NOT IN (\r\n"
				+ "    SELECT lophoc.maLH\r\n"
				+ "    FROM hocvien\r\n"
				+ "    JOIN dangki ON hocvien.maHV = dangki.maHV\r\n"
				+ "    JOIN lophoc ON dangki.maLH = lophoc.maLH\r\n"
				+ "    WHERE dangki.maHV = '" + id +  "'\r\n"
				+ ");";
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String maLH = rs.getString("maLH");
				list.add(maLH);
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return list;
		
	}

	public int soHV(String maLH) {
		String querry = "SELECT COUNT(*) FROM dangki\r\n"
				+ "WHERE maLH = '" + maLH + "';";
		Connection con = JDBCUtil.getConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querry);
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
