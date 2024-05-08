package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import com.toedter.calendar.JDateChooser;

import Database.JDBCUtil;
import Model.BienLai;
import Model.Hocvien;

public class BienLaiDAO implements DAOInterface<BienLai> {
	
	public static BienLaiDAO getInstance() {
		return new BienLaiDAO();
	}

//	public ArrayList<BienLai> inBL(String maHV, JDateChooser start, JDateChooser end) {
//		ArrayList<BienLai> list = new ArrayList<BienLai>();
//		String query = "SELECT bienlai.maHV,bienlai.maLH,hocphi,htThanhToan, ngayIn\r\n"
//				+ "FROM pbl3.dangki JOIN pbl3.bienlai ON (dangki.maHV = bienlai.maHV && dangki.maLH = bienlai.maLH)\r\n"
//				+ "WHERE \r\n"
//				+ "	bienlai.maHV = " + maHV + " && \r\n"
//				+ "	thanhtoan = 0 && \r\n"
//				+ "	ngayIn BETWEEN '" + start + "' AND '" + end + "';";
//		try {
//			Connection con = JDBCUtil.getConnection();
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				String maHD = rs.getString("maHD");
//				String maLH = rs.getString("maLH");
//				String hocPhi = rs.getString("hocPhi");
//				Date date = rs.getDate("ngayIn");
//				String httt = rs.getString("htThanhToan");
//				BienLai bl = new BienLai(maHD, maHV, maLH, 0, date, httt);
//				list.add(bl);
//			}
//			System.out.println(query);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
	
	@Override
	public int insert(BienLai t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement stmt = con.createStatement();
			String query = "INSERT INTO pbl3.bienlai\r\n"
					+ "VALUES ('" + t.getMaHD() +"', '" + t.getMaHV() + "', '" + t.getMaLH() + "', "+ t.getHocPhi() + ", '" + t.getNgayIn().toString() + "', '" + t.getHtThanhToan() + "');";
			System.out.println(query);
			kq = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(BienLai t) {
		int kq = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE bienlai \r\n"
					+ "SET maHD = '" + t.getMaHD() +"', maHV = '" + t.getMaHV() + "', maLH = " + t.getMaLH() + ", hocphi = " + t.getHocPhi() + ", ngayIn = '" + t.getNgayIn() + "', htThanhToan = 'ck'\r\n"
					+ "WHERE maHD = '" + t.getMaHD() + "';'";  				
			kq = st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(BienLai t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BienLai> selectAll() {
		ArrayList<BienLai> list = new ArrayList<BienLai>();
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM bienlai";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				String maHV = rs.getString("maHV");
				String maLH = rs.getString("maLH");
				int hocPhi = rs.getInt("hocphi");
				Date ngayIn = rs.getDate("ngayIn");
				String httt = rs.getString("htThanhToan");

				BienLai bl = new BienLai(maHD, maHV, maLH, hocPhi, ngayIn, httt);
				list.add(bl);
			}
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("Co " + kq + " dong da thay doi");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<BienLai> setBienLaiforHV(String id){
		ArrayList<BienLai> list = new ArrayList<BienLai>();
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM bienlai where maHV = '" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				String maHV = rs.getString("maHV");
				String maLH = rs.getString("maLH");
				int hocPhi = rs.getInt("hocphi");
				Date ngayIn = rs.getDate("ngayIn");
				String httt = rs.getString("htThanhToan");

				BienLai bl = new BienLai(maHD, maHV, maLH, hocPhi, ngayIn, httt);
				list.add(bl);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BienLai selectById(String id) {
		
		return null;
	}

	@Override
	public ArrayList<BienLai> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}