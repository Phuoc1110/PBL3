package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import Database.JDBCUtil;
import Model.Giaovien;
import Model.Hocvien;
import Model.Lophoc;

public class LopHocDAO implements DAOInterface<Lophoc>{

	public static LopHocDAO getInstance() {
		return new LopHocDAO();
	}
	@Override
	public int insert(Lophoc t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			String sql = "INSERT INTO lophoc (maLH, tenLop, siSo, thoiGianHoc, ngayBatDau, ngayKetThuc, maMH, maGV)"
					+ " values('" + t.getMaLH() +"' ,'" + t.getTenLH() +"' ," + t.getSiSo() + " ,'" + t.getThoigianHoc() + "', '" +
					 t.getNgayBatDau() + "' ,'" + t.getNgayKetThuc() + "' ,'" + t.getMaMH() + "', '" + t.getMaGV() + "')";
			System.out.println(sql);
			ketqua = st.executeUpdate(sql);
			
			
			JDBCUtil.closeConnection(cnn);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return ketqua;
	}

	@Override
	public int update(Lophoc t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "UPDATE lophoc set "
					+ "maLH = '" + t.getMaLH() + "' ,"
					+ "tenLop = '" + t.getTenLH() + "' ," 
					+ "siSo = " + t.getSiSo() + " ,"
					+ "thoiGianHoc = '" + t.getThoigianHoc() + "' ,"
					+ "ngayBatDau = '" + t.getNgayBatDau() + "' ,"
					+ "ngayKetThuc = '" + t.getNgayKetThuc() + "' ,"
					+ "maMH = '" + t.getMaMH() + "' ,"
					+ "maGV = '" + t.getMaGV() + "' where maLH = '" + t.getMaLH() + "'";
			
			System.out.println(sql);
			ketqua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ketqua;
	}

	@Override
	public int delete(Lophoc t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "DELETE FROM lophoc where maLH = '" + t.getMaLH() + "'";
			System.out.println(sql);
			
			ketqua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(cnn);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ketqua;
	}

	@Override
	public ArrayList<Lophoc> selectAll() {
		ArrayList<Lophoc> list = new ArrayList<Lophoc>();
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT * FROM lophoc";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 String maLH = rs.getString("maLH");
				 String tenlop = rs.getString("tenLop");
				 int siSo = rs.getInt("siSo");
				 String thoiGianHoc = rs.getString("thoiGianHoc");
				 String ngayBatDau = rs.getString("ngayBatDau");
				 String ngayKetThuc = rs.getString("ngayKetThuc");
				 String maMH = rs.getString("maMH");
				 String maGV = rs.getString("maGV");				 
				 Lophoc lh = new Lophoc(maLH, tenlop, siSo, thoiGianHoc, ngayBatDau, ngayKetThuc, maMH, maGV);
				 list.add(lh);
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public String getNameLH(String id) {
		String s = "";
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT tenLop FROM lophoc where maLH = '" + id  + "'";
			
			System.out.println(sql);
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				s = rs.getString("tenLop");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}

	@Override
	public Lophoc selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Lophoc> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Hocvien> tTin(String maLH) {
		ArrayList<Hocvien> kq =  new ArrayList<Hocvien>();
		String sql = "select hocvien.maHV, hocvien.name, hocvien.gioiTinh, hocvien.namSinh, hocvien.SDT, hocvien.tinhTrang\r\n"
				+ "from hocvien\r\n"
				+ "join dangki\r\n"
				+ "	using(maHV)\r\n"
				+ "where maLH = '" + maLH + "'";
		Connection con = JDBCUtil.getConnection();
		try {
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maHV = rs.getString("maHV");
				String name = rs.getString("name");
				String namSinh = rs.getString("namSinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String SDT = rs.getString("SDT");
				String tinhTrang = rs.getString("tinhTrang");
				
				Hocvien hv = new Hocvien(maHV,name,namSinh,gioiTinh,SDT,tinhTrang);
				kq.add(hv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	
	

}
