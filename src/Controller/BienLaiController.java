package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.BienLaiDAO;
import DAO.DangKiDAO;
import Database.JDBCUtil;
import Model.BienLai;
import View.AdminView;

public class BienLaiController implements ActionListener {
	private AdminView adminview;
	public BienLaiController(){
		super();
	}
	
	public BienLaiController(AdminView adminview) {
		this.adminview = adminview;
	}
//	public BienLai getDataBL() {
//		ArrayList<BienLai> list = BienLaiDAO.getInstance().selectAll();
//		ArrayList<Integer> listMaHD = new ArrayList<Integer>();
//		for(BienLai c : list) {
//			listMaHD.add(Integer.parseInt(c.getMaHD()));
//		}
//		Random random = new Random();
//		int min = 1000;
//		int max = 9999;
//		int ok = 0;
//		int rdnb = 0;
//		while(ok == 0) {
//			rdnb = random.nextInt(max - min + 1) + min;
//			for(int a : listMaHD) {
//				if(a == rdnb)
//					continue;
//			}
//			ok = 1;
//		}
//		String maBL = Integer.toString(rdnb);
//		String maHV = adminview.txtNhapMaHVBL.getText();
//		String maLH = (String) adminview.cbbNhapMaLHBL.getSelectedItem();
//		Date ngayIn = java.sql.Date.valueOf(LocalDate.now());
//		int hocphi = Integer.parseInt(adminview.txtHocPhiBL.getText());
//		String httt = (String) adminview.cbbNhapHTTT.getSelectedItem();
//		BienLai bl = new BienLai(maBL, maHV, maLH, hocphi, ngayIn, httt);
//		bl.toString();
//		System.out.println(bl.toString());
//		return bl;
//		
//	}
	
	
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == adminview.cbbNhapMaLHBL) {
//			
//			
//			String nhap	= (String) adminview.cbbNhapMaLHBL.getSelectedItem();
//
//			String query = "select hocphi from lophoc where maLH ='" + nhap + "'";
//			System.out.println(query);
//			try {
//				Connection con = JDBCUtil.getConnection();
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(query);
//				System.out.println(query);
//				while (rs.next()) {
//					adminview.txtHocPhiBL.setText(Integer.toString(rs.getInt("hocphi")));
//				}	
//			} catch (Exception e2) {
//				e2.getStackTrace();
//			}
//		}
//		if (e.getSource() == adminview.btnInBienLai) {
//			DangKiDAO.getInstance().setDaThanhToan((String) adminview.cbbNhapMaLHBL.getSelectedItem(), adminview.txtNhapMaHVBL.getText());
//			BienLaiDAO.getInstance().insert(getDataBL());
//			JOptionPane.showMessageDialog(adminview, "In thanh cong");
//		}
//		if (e.getSource() == adminview.txtNhapMaHVBL) {
//			adminview.cbbNhapMaLHBL.removeAllItems();
//			String query = "SELECT maLH FROM pbl3.dangki\r\n"
//					+ "WHERE thanhtoan = 0 && maHV = '" + adminview.txtNhapMaHVBL.getText() + "';";
//			try {
//				Connection con = JDBCUtil.getConnection();
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(query);
//				while (rs.next()) {
//					adminview.cbbNhapMaLHBL.addItem(rs.getString("maLH"));
//				}	
//			} catch (Exception e2) {
//				e2.getStackTrace();
//			}
//			
//		}
			if (e.getSource() == adminview.btnTimKiemBL) {
			
			Date date1 = new Date(adminview.dateLocNgayBD.getDate().getTime());
			Date date2 = new Date(adminview.dateLocNgayKT.getDate().getTime());
			
//			String str = adminview.txtTimKiemHVBL.getText();
			
//			if (!str.equals("")) {
//				query = "SELECT * FROM bienlai \r\n"
//						+ "WHERE (ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2 + "') && maHV = '" + str + "';";
//			}
//			else {
//				query = "SELECT * FROM bienlai \r\n"
//						+ "WHERE (ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2 + "');";
//			}
			String query;
			query = "SELECT * FROM bienlai \r\n"
					+ "WHERE (ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2 + "');";
			System.out.println(query);
			ArrayList<BienLai> list = new ArrayList<BienLai>();
			try {
				Connection con = JDBCUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String maHD = rs.getString("maHD");
					String maHV = rs.getString("maHV");
					String maLH = rs.getString("maLH");
					int hp = rs.getInt("hocphi");
					Date d = rs.getDate("ngayIn");
					String ht = rs.getString("htThanhToan");
					BienLai bl = new BienLai(maHD, maHV, maLH, hp, d, ht);
					
					list.add(bl);
				}
				DefaultTableModel model = (DefaultTableModel) adminview.tableBL.getModel();
				while(model.getRowCount() > 0)
				{
				    model.removeRow(0);
				}
				for (BienLai b : list) {
					String[] s = {b.getMaHD(), b.getMaHV(), b.getMaLH(), Integer.toString(b.getHocPhi()), b.getNgayIn().toString(), b.getHtThanhToan()};
					model.addRow(s);
				}
				
				//Thong ke
				
//				if (!str.equals(""))
//					query = "SELECT COUNT(*) AS row_count\r\n"
//						+ "FROM (\r\n"
//						+ "    SELECT *\r\n"
//						+ "    FROM bienlai \r\n"
//						+ "    WHERE maHV = '" + str + "' AND ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2.toString() + "'\r\n"
//						+ ") AS subquery;\r\n"
//						+ "";
//				else
					query = "SELECT COUNT(*) AS row_count\r\n"
							+ "FROM (\r\n"
							+ "    SELECT *\r\n"
							+ "    FROM bienlai \r\n"
							+ "    WHERE ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2.toString() + "'\r\n"
							+ ") AS subquery;\r\n"
							+ "";
				int i = 0;
				con = JDBCUtil.getConnection();
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(query);
					while (rs.next()) {
						i = rs.getInt(1);
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
//				if (!str.equals(""))
//					query = "SELECT SUM(hocphi) AS total_hocphi\r\n"
//						+ "FROM bienlai \r\n"
//						+ "WHERE maHV = '" + str + "' AND ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2.toString() + "';\r\n"
//						+ "";
//				else
					query = "SELECT SUM(hocphi) AS total_hocphi\r\n"
							+ "FROM bienlai \r\n"
							+ "WHERE ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2.toString() + "';\r\n"
							+ "";
				con = JDBCUtil.getConnection();
				int j = 0;
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(query);
					while (rs.next()) {
						j = rs.getInt(1);
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				
				
				adminview.lblTONGTIEN.setText(Integer.toString(j));
				adminview.lblSOLUONGHD.setText(Integer.toString(i));
				} catch (Exception e1) {
					e1.getStackTrace();
				}
		}
//		if (e.getSource() == adminview.btnTimKiemBL) {
//			Date date1 = new Date(adminview.dateLocNgayBD.getDate().getTime());
//			Date date2 = new Date(adminview.dateLocNgayKT.getDate().getTime());
//			
//			String str = adminview.txtTimKiemHVBL.getText();
//			String query = "";
//			if (!str.equals("")) {
//				query = "SELECT * FROM bienlai \r\n"
//						+ "WHERE (ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2 + "') && maHV = '" + str + "';";
//			}
//			else {
//				query = "SELECT * FROM bienlai \r\n"
//						+ "WHERE (ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2 + "');";
//			}
//			System.out.println(query);
//			ArrayList<BienLai> list = new ArrayList<BienLai>();
//			try {
//				Connection con = JDBCUtil.getConnection();
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(query);
//				while (rs.next()) {
//					String maHD = rs.getString("maHD");
//					String maHV = rs.getString("maHV");
//					String maLH = rs.getString("maLH");
//					int hp = rs.getInt("hocphi");
//					Date d = rs.getDate("ngayIn");
//					String ht = rs.getString("htThanhToan");
//					BienLai bl = new BienLai(maHD, maHV, maLH, hp, d, ht);
//					
//					list.add(bl);
//				}
//				DefaultTableModel model = (DefaultTableModel) adminview.tableBL.getModel();
//				while(model.getRowCount() > 0)
//				{
//				    model.removeRow(0);
//				}
//				for (BienLai b : list) {
//					String[] s = {b.getMaHD(), b.getMaHV(), b.getMaLH(), Integer.toString(b.getHocPhi()), b.getNgayIn().toString(), b.getHtThanhToan()};
//					model.addRow(s);
//				}
//				
//				//Thong ke
//				query = "SELECT COUNT(*) AS row_count\r\n"
//						+ "FROM (\r\n"
//						+ "    SELECT *\r\n"
//						+ "    FROM bienlai \r\n"
//						+ "    WHERE ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2.toString() + "'\r\n"
//						+ ") AS subquery;\r\n"
//						+ "";
//				int i = 0;
//				con = JDBCUtil.getConnection();
//				try {
//					stmt = con.createStatement();
//					rs = stmt.executeQuery(query);
//					while (rs.next()) {
//						i = rs.getInt(1);
//					}
//				} catch (SQLException e2) {
//					e2.printStackTrace();
//				}
//				query = "SELECT SUM(hocphi) AS total_hocphi\r\n"
//						+ "FROM bienlai \r\n"
//						+ "WHERE ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2.toString() + "';\r\n"
//						+ "";
//				con = JDBCUtil.getConnection();
//				int j = 0;
//				try {
//					stmt = con.createStatement();
//					rs = stmt.executeQuery(query);
//					while (rs.next()) {
//						j = rs.getInt(1);
//					}
//				} catch (SQLException e2) {
//					e2.printStackTrace();
//				}
//				
//				
//				
//				adminview.lblTONGTIEN.setText(Integer.toString(j));
//				adminview.lblSOLUONGHD.setText(Integer.toString(i));
//				
//				
//			} catch (Exception e1) {
//				e1.getStackTrace();
//			}
//		}
	}
	
}