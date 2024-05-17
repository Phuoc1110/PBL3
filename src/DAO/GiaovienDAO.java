package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Statement;

import Database.JDBCUtil;
import Model.Giaovien;

public class GiaovienDAO implements DAOInterface<Giaovien>{

	public static GiaovienDAO getInstance() {
		return new GiaovienDAO();
	}
	
	public int insert(Giaovien t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			String sql = "INSERT INTO giaovien (maGV, name, namSinh, gioiTinh, chuyenMon, trinhDO, SDT)"
					+ " values('" + t.getMaGV() +"' ,'" + t.getName() +"' ,'" + t.getNamSinh() + "' ," + t.getGioiTinh() + ", '" +
					 t.getChuyenMon() + "' ,'" + t.getTrinhDo() + "' ," + t.getSDT() + ")";
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
	public int update(Giaovien t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "UPDATE giaovien set "
					+ "maGV = '" + t.getMaGV() + "' ,"
					+ "name = '" + t.getName() + "' ," 
					+ "namSinh = '" + t.getNamSinh() + "' ,"
					+ "gioiTinh = " + t.getGioiTinh() + " ,"
					+ "chuyenMon = '" + t.getChuyenMon() + "' ,"
					+ "trinhDo = '" + t.getTrinhDo() + "' ,"
					+ "SDT = " + t.getSDT()
			
					+ " where maGV = '" + t.getMaGV() + "'";
			
			ketqua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ketqua;
	}

	@Override
	public int delete(Giaovien t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "DELETE FROM giaovien where maGV = '" + t.getMaGV() + "'";
			System.out.println(sql);
			
			ketqua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(cnn);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ketqua;
	}
	@Override
	public ArrayList<Giaovien> selectAll() {
		ArrayList<Giaovien> list = new ArrayList<Giaovien>();
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT * FROM giaovien order by maGV";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 String maGV = rs.getString("maGV");
				 String name = rs.getString("name");
				 String namSinh = rs.getString("namSinh");
				 Boolean gioiTinh = rs.getBoolean("gioiTinh");
				 String chuyenMon = rs.getString("chuyenMon");
				 String trinhDo = rs.getString("trinhDo");
				 int SDT = rs.getInt("SDT");
				 
				 Giaovien gv = new Giaovien(maGV, name, namSinh, gioiTinh, chuyenMon, trinhDo, SDT);
				 list.add(gv);
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}


	public Giaovien selectById(String id) {
		Giaovien gv = null;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT * FROM giaovien where maGV = '" + id + "'";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 String maGV = rs.getString("maGV");
				 String name = rs.getString("name");
				 String namSinh = rs.getString("namSinh");
				 Boolean gioiTinh = rs.getBoolean("gioiTinh");
				 String chuyenMon = rs.getString("chuyenMon");
				 String trinhDo = rs.getString("trinhDo");
				 int SDT = rs.getInt("SDT");
				 
				 gv = new Giaovien(maGV, name, namSinh, gioiTinh, chuyenMon, trinhDo, SDT);
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return gv;
	}
	
	public ArrayList<Giaovien> timKiemGV(String dk){
		ArrayList<Giaovien> list = new ArrayList<Giaovien>();
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT * FROM giaovien where name like '%" + dk + "%'";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 String maGV = rs.getString("maGV");
				 String name = rs.getString("name");
				 String namSinh = rs.getString("namSinh");
				 Boolean gioiTinh = rs.getBoolean("gioiTinh");
				 String chuyenMon = rs.getString("chuyenMon");
				 String trinhDo = rs.getString("trinhDo");
				 int SDT = rs.getInt("SDT");
				 
				 Giaovien gv = new Giaovien(maGV, name, namSinh, gioiTinh, chuyenMon, trinhDo, SDT);
				 list.add(gv);
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public String getTenGV(String maGV) {
		String tenGV = "";
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT name from giaovien where maGV = '" + maGV + "'";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 tenGV = rs.getString("name");
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tenGV;
	}
	
	public int getSLGV() {
		int SL = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT count(*) as SL from giaovien";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 SL = rs.getInt("SL");
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return SL;
	}
	public ArrayList<String> getMaGVTuTen(String tenGV) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "SELECT maGV from giaovien where name = '" + tenGV + "'";
			
			java.sql.ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				 String t = rs.getString("maGV");
				 list.add(t);
			}
			
			JDBCUtil.closeConnection(cnn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	

	public ArrayList<Giaovien> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	

}