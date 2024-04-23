package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.DangKi;

public class DangKiDAO {

	public int insert(DangKi t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			String sql = "INSERT INTO dangki (maHV, maLH)"
					+ " values('" + t.getMaHV() + "', '" + t.getMaLH() + "'";
			ketqua = st.executeUpdate(sql);
			JDBCUtil.closeConnection(cnn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return ketqua;
	}

	public int delete(DangKi t) {
		int ketqua = 0;
		try {
			Connection cnn = JDBCUtil.getConnection();
			
			java.sql.Statement st = cnn.createStatement();
			
			String sql = "DELETE FROM giaovien where maHV = '" + t.getMaHV() + "'";
			System.out.println(sql);
			
			ketqua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(cnn);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ketqua;

	}


	
}
