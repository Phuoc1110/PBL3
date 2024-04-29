package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.GiaovienDAO;
import DAO.LopHocDAO;
import Model.Giaovien;
import Model.Hocvien;
import Model.Lophoc;
import View.AdminView;
import View.TTHV;

public class LopHocConTroller implements ActionListener, MouseListener{
	private AdminView adminview;
	
	public LopHocConTroller(AdminView adminview) {
		this.adminview = adminview;
	}
	public boolean checkExistLH(String maLH) {
		ArrayList<Lophoc> list = LopHocDAO.getInstance().selectAll();
		for(Lophoc lh : list) {
			if(lh.getMaLH().equals(maLH)) return true;
		}
		return false;
	}
	
	public Lophoc getDataViewLH() {
		String maLH = adminview.txtNhapMaLH.getText();
		String tenLH = adminview.txtNhapTenLH.getText();
		int siSo =  Integer.parseInt(adminview.txtNhapSiSoLH.getText());
		String thoiGianHoc = adminview.txtNhapThoiGianHocLH.getText();
		String ngayBatDau = adminview.cbbNgayBD.getSelectedItem().toString()
				+ "/" + adminview.cbbThangBD.getSelectedItem().toString()
				+ "/" + adminview.txtNamBDLH.getText();
		String ngayKetThuc = adminview.cbbNgayKT.getSelectedItem().toString()
				+ "/" + adminview.cbbThangKT.getSelectedItem().toString()
				+ "/" + adminview.txtNamKTLH.getText().toString();
		String maMH = adminview.choiceNhapMaMH.getSelectedItem();
		String maGV = adminview.choiceNhapMaGV.getSelectedItem();
		
		Lophoc lh = new Lophoc(maLH, tenLH, siSo, thoiGianHoc, ngayBatDau, ngayKetThuc, maMH, maGV);
		return lh;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adminview.btnHienThiLH) {
			ArrayList<Lophoc> list = LopHocDAO.getInstance().selectAll();
			DefaultTableModel model = (DefaultTableModel) adminview.tableLH.getModel();
			model.setRowCount(0);
			for(Lophoc lh : list) {		
				String[] row = {lh.getMaLH(), lh.getTenLH(), String.valueOf(lh.getSiSo()), lh.getThoigianHoc(), lh.getNgayBatDau(), lh.getNgayKetThuc(), lh.getMaMH(), lh.getMaGV()};
				model.addRow(row);
			}
			
			
		}
		
		if (e.getSource() == adminview.btnThemLH) {
			LopHocDAO.getInstance().insert(getDataViewLH());
			adminview.btnHienThiLH.doClick();
		}
		
		if(e.getSource() == adminview.btnSuaLH) {
			if(!checkExistLH(adminview.txtNhapMaLH.getText())) {
				JOptionPane.showMessageDialog(null, adminview.txtNhapMaLH.getText()+ " khong ton tai");
			}
			else {
				LopHocDAO.getInstance().update(getDataViewLH());
				adminview.btnHienThiLH.doClick();
			}
			
		}
		if(e.getSource() == adminview.btnXoaLH) {
			LopHocDAO.getInstance().delete(getDataViewLH());
			adminview.btnHienThiLH.doClick();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int i = adminview.tableLH.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) adminview.tableLH.getModel();
		adminview.txtNhapMaLH.setText((String) model.getValueAt(i, 0));
		adminview.txtNhapTenLH.setText((String) model.getValueAt(i, 1));
		adminview.txtNhapSiSoLH.setText((String) model.getValueAt(i, 2));
		adminview.txtNhapThoiGianHocLH.setText((String) model.getValueAt(i, 3));
		String ngayThangBD = (String) model.getValueAt(i, 4);
		
		String ngayBD = "", thangBD = "", namBD = "";
		for (int j = 0 ;j < 2 ; j++) {
			ngayBD += ngayThangBD.charAt(j);
		}
		adminview.cbbNgayBD.setSelectedItem(ngayBD);
		for (int j = 3 ; j < 5 ; j++) {
			thangBD += ngayThangBD.charAt(j);
		}
		adminview.cbbThangBD.setSelectedItem(thangBD);
		for (int j = 6 ; j < ngayThangBD.length(); j++) {
			namBD += ngayThangBD.charAt(j);
		}
		adminview.txtNamBDLH.setText(namBD);
		
		String ngayThangKT = ((String) model.getValueAt(i, 5));
		
		String ngayKT = "", thangKT = "", namKT = "";
		for (int j = 0 ;j < 2 ; j++) {
			ngayKT += ngayThangKT.charAt(j);
		}
		adminview.cbbNgayKT.setSelectedItem(ngayKT);
		for (int j = 3 ; j < 5 ; j++) {
			thangKT += ngayThangKT.charAt(j);
		}
		adminview.cbbThangKT.setSelectedItem(thangKT);
		for (int j = 6 ; j < ngayThangKT.length(); j++) {
			namKT += ngayThangKT.charAt(j);
		}
		adminview.txtNamKTLH.setText(namKT);
		
		adminview.choiceNhapMaMH.select((String) model.getValueAt(i, 6));
		adminview.choiceNhapMaGV.select((String) model.getValueAt(i, 7));
		
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume();							//tra sau
			TTHV tthv = new TTHV();
			tthv.setVisible(true);
			//Them tt vao dialog
			ArrayList<Hocvien> list = LopHocDAO.getInstance().tTin(adminview.txtNhapMaLH.getText());
			DefaultTableModel model2 = (DefaultTableModel) tthv.table.getModel();
			for(Hocvien hv : list) {	
				String gender ;
				if(hv.getGioiTinh() == true) gender = "Nam";
				else gender = "Nu";
				String[] row = {hv.getMaHV(), hv.getName(), hv.getNamSinh(), gender, hv.getSdt(), hv.getTinhTrang()};
				model2.addRow(row);
			}	
	}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
