package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.BienLai;

public class BienLaiDAO implements DAOInterface<BienLai> {
	
	public static BienLaiDAO getInstance() {
		return new BienLaiDAO();
	}

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BienLai t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BienLai> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BienLai selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BienLai> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
