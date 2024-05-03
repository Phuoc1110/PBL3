package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAO.BienLaiDAO;
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
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adminview.cbbNhapMaLHBL) {
			adminview.cbbNhapHTTT.removeAllItems();
			adminview.txtHocPhiBL.setText("");
			String query = "SELECT hocphi, htThanhToan FROM pbl3.bienlai\r\n"
					+ "WHERE maLH = '" + adminview.cbbNhapMaLHBL.getSelectedItem().toString() + "' && maHV = '" + adminview.txtNhapMaHVBL.getText() + "';";
			try {
				Connection con = JDBCUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				System.out.println(query);
				while (rs.next()) {
					adminview.cbbNhapHTTT.addItem(rs.getString("htThanhToan"));
					adminview.txtHocPhiBL.setText(Integer.toString(rs.getInt("hocphi")));
				}	
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		if (e.getSource() == adminview.btnInBienLai) {
			//BienLai bl = new BienLai(maHD ,adminview.txtNhapMaHVBL.getText(), null, null, 0, null, null);
			//BienLaiDAO.getInstance().update(bl);
			//Thanh toan = 1
		}
		if (e.getSource() == adminview.txtNhapMaHVBL) {
			adminview.cbbNhapMaLHBL.removeAllItems();
			String query = "SELECT maLH FROM pbl3.dangki\r\n"
					+ "WHERE thanhtoan = 0 && maHV = '" + adminview.txtNhapMaHVBL.getText() + "';";
			try {
				Connection con = JDBCUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					adminview.cbbNhapMaLHBL.addItem(rs.getString("maLH"));
				}	
			} catch (Exception e2) {
				e2.getStackTrace();
			}
			
		}
		if (e.getSource() == adminview.btnTimKiemBL) {
			Date date1 = new Date(adminview.dateLocNgayBD.getDate().getTime());
			Date date2 = new Date(adminview.dateLocNgayKT.getDate().getTime());
			String query = "SELECT * FROM bienlai \r\n"
					+ "WHERE (ngayIn BETWEEN '" + date1.toString() + "' AND '" + date2 + "') && maHV = '10001';";
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
				
				
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
	}
}
