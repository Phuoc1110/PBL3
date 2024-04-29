package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.Hocvien;


public class HocvienDAO implements DAOInterface<Hocvien>{
		
	public static HocvienDAO getInstance() {
		return new HocvienDAO();
	}

	@Override
	public int insert(Hocvien t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO hocvien " + 
					"VALUES ('" + t.getMaHV() + "', '" + t.getName() + "', '" + t.getNamSinh() + 
					"', " + t.getGioiTinh() + ", '" + t.getSdt() + "', '" + t.getTinhTrang() + "');"; 				
			kq = st.executeUpdate(sql);
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("Co " + kq + " dong da thay doi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(Hocvien t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE hocvien " + 
					"SET " + 
					" name = '" + t.getName() + "'," +
					" namSinh = '" + t.getNamSinh() + "'," +
					" gioiTinh = " + t.getGioiTinh() + "," +
					" SDT = '" + t.getSdt() + "'," +
					" tinhTrang = '" + t.getTinhTrang() + "' " +
					"WHERE maHV = '" + t.getMaHV() + "'";  				
			kq = st.executeUpdate(sql);
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("Co " + kq + " dong da thay doi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(Hocvien t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM hocvien " + 
					"WHERE maHV = " + t.getMaHV();
			kq = st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<Hocvien> selectAll() {
		ArrayList<Hocvien> kq = new ArrayList<Hocvien>();
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM hocvien";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String maHV = rs.getString("maHV");
				String name = rs.getString("name");
				String namSinh = rs.getString("namSinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String SDT = rs.getString("SDT");
				String tinhTrang = rs.getString("tinhTrang");
				
				Hocvien hv = new Hocvien(maHV,name,namSinh,gioiTinh,SDT,tinhTrang);
				kq.add(hv);
			}
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("Co " + kq + " dong da thay doi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public Hocvien selectById(String t) {
		Hocvien kq = null;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM hocvien WHERE maHV = '" + t + "'";
			ResultSet rs = st.executeQuery(sql	);
			while(rs.next()) {
				String maHV = rs.getString("maHV");
				String name = rs.getString("name");
				String namSinh = rs.getString("namSinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String SDT = rs.getString("SDT");
				String tinhTrang = rs.getString("tinhTrang");
				
				kq = new Hocvien(maHV,name,namSinh,gioiTinh,SDT,tinhTrang);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<Hocvien> selectByCondition(String condition) {
		ArrayList<Hocvien> kq = new ArrayList<Hocvien>();
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM hocvien WHERE " + condition;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maHV = rs.getString("maHV");
				String name = rs.getString("name");
				String namSinh = rs.getString("namSinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String SDT = rs.getString("SDT");
				String tinhTrang = rs.getString("tinhTrang");
				
				Hocvien hv = new Hocvien(maHV,name,namSinh,gioiTinh,SDT,tinhTrang);
				kq.add(hv);
				JDBCUtil.closeConnection(con);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return kq;
	}
	
}
