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
import Model.Lophoc;
import View.AdminView;

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
		String ngayBatDau = adminview.txtNhapNgayBatDauLH.getText();
		String ngayKetThuc = adminview.txtNhapNgayKetThucLH.getText();
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
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int i = adminview.tableLH.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) adminview.tableLH.getModel();
		adminview.txtNhapMaLH.setText((String) model.getValueAt(i, 0));
		adminview.txtNhapTenLH.setText((String) model.getValueAt(i, 1));
		adminview.txtNhapSiSoLH.setText((String) model.getValueAt(i, 2));
		adminview.txtNhapThoiGianHocLH.setText((String) model.getValueAt(i, 3));
		adminview.txtNhapNgayBatDauLH.setText((String) model.getValueAt(i, 4));
		adminview.txtNhapNgayKetThucLH.setText((String) model.getValueAt(i, 5));
		adminview.choiceNhapMaMH.select((String) model.getValueAt(i, 6));
		adminview.choiceNhapMaGV.select((String) model.getValueAt(i, 7));
		
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
