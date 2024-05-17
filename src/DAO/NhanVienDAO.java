package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.Giaovien;
import Model.NhanVien;

public class NhanVienDAO implements DAOInterface<NhanVien>{

	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}
	@Override
	public int insert(NhanVien t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			String sql = "INSERT INTO nhanvien (ID, matKhau, Ten, NgaySinh, SDT, GioiTinh)"
					+ " values('" + t.getId() +"' ,'" + t.getMatkhau() +"' ,'" + t.getTen() + "' ,'" + t.getNgaysinh() + "', " +
					 t.getSDT() + " ," + t.GetGioitinh() + ")";
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
	public int update(NhanVien t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "UPDATE nhanvien set "
					+ "ID = '" + t.getId() + "' ,"
					+ "matKhau = '" + t.getMatkhau() + "' ," 
					+ "Ten = '" + t.getTen() + "' ,"
					+ "gioiTinh = " + t.GetGioitinh() + " ,"
					+ "NgaySinh = '" + t.getNgaysinh() + "' ,"
					+ "SDT = " + t.getSDT() + " "
					
			
					+ " where ID = '" + t.getId() + "'";
			
			ketqua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ketqua;
	}

	@Override
	public int delete(NhanVien t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "DELETE FROM nhanvien where ID = '" + t.getId() + "'";
			System.out.println(sql);
			
			ketqua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(cnn);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ketqua;
	}

	@Override
	public ArrayList<NhanVien> selectAll() {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT * FROM nhanvien order by ID";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 String id = rs.getString("ID");
				 String matKhau = rs.getString("matKhau");
				 String ngaySinh = rs.getString("NgaySinh");
				 String Ten = rs.getString("Ten");
				 Boolean gioiTinh = rs.getBoolean("GioiTinh");
				 int SDT = rs.getInt("SDT");
				 
				 NhanVien nv = new NhanVien(id, Ten, matKhau, SDT, ngaySinh, gioiTinh);
				 list.add(nv);
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public NhanVien selectById(String ID) {
		NhanVien nv = null;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT * FROM nhanvien where ID = '" + ID + "'";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 String id = rs.getString("ID");
				 String matKhau = rs.getString("matKhau");
				 String ngaySinh = rs.getString("NgaySinh");
				 String Ten = rs.getString("Ten");
				 Boolean gioiTinh = rs.getBoolean("GioiTinh");
				 int SDT = rs.getInt("SDT");
				 
				 nv = new NhanVien(id, Ten, matKhau, SDT, ngaySinh, gioiTinh);
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}

	@Override
	public ArrayList<NhanVien> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
