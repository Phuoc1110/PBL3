package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.MonHoc;

public class MonHocDAO implements DAOInterface<MonHoc>{
	
	public static MonHocDAO getInstance() {
		return new MonHocDAO();
	}
	
	public int insert(MonHoc t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO monhoc " + 
					"VALUES ('" + t.getMaMH() + "', '" + t.getTenMon() + "');"; 				
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("Co " + kq + " dong da thay doi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(MonHoc t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE monhoc " + 
					"SET " + 
					" maMH = '" + t.getMaMH() + "'," +
					" tenMon = '" + t.getTenMon() + "'" +
					"WHERE maMH = '" + t.getMaMH() + "'";  				
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("Co " + kq + " dong da thay doi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(MonHoc t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM monhoc " + 
					"WHERE maMH = '" + t.getMaMH() + "'";
			kq = st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<MonHoc> selectAll() {
		ArrayList<MonHoc> list = new ArrayList<MonHoc>();
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM monhoc";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String maMH = rs.getString("maMH");
				String tenMon = rs.getString("tenMon");
				MonHoc mh = new MonHoc(maMH,tenMon);
				list.add(mh);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
	}

	@Override
	public MonHoc selectById(String id) {
		MonHoc kq = null;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM monhoc WHERE maMH = '" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String maMH = rs.getString("maMH");
				String tenMon = rs.getString("tenMon");
				kq = new MonHoc(maMH,tenMon);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public String getIdTuTenMH(String tenMH) {
		String maMH = "";
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT maMH FROM monhoc WHERE tenMon = '" + tenMH + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				maMH = rs.getString("maMH");
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maMH;
	}
	
	public String getTenTuID(String id) {
		String tenMH = "";
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT tenMon FROM monhoc WHERE maMH = '" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				tenMH = rs.getString("tenMon");
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenMH;
	}
	
	

	@Override
	public ArrayList<MonHoc> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
}
