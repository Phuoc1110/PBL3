package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.google.protobuf.TextFormat.ParseException;

import DAO.DangKiDAO;
import DAO.GiaovienDAO;
import DAO.LopHocDAO;
import DAO.MonHocDAO;
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String ngayBatDau = dateFormat.format(adminview.dateNBD.getDate());
		String ngayKetThuc = dateFormat.format(adminview.dateNKT.getDate());
		String maMH = MonHocDAO.getInstance().getIdTuTenMH(adminview.cbbTenMH.getSelectedItem().toString());
		String maGV = adminview.cbbMaGVLH.getSelectedItem().toString();
		int hocphi = Integer.parseInt(adminview.txtHocPhi.getText()) ;
		Lophoc lh = new Lophoc(maLH, tenLH, siSo, thoiGianHoc, ngayBatDau, ngayKetThuc, maMH, maGV, hocphi);
		return lh;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adminview.btnHienThiLH) {
			ArrayList<Lophoc> list = LopHocDAO.getInstance().selectAll();
			DefaultTableModel model = (DefaultTableModel) adminview.tableLH.getModel();
			model.setRowCount(0);
			for(Lophoc lh : list) {	
				String tenMon = MonHocDAO.getInstance().getTenTuID(lh.getMaMH());
				String tenGV = GiaovienDAO.getInstance().getTenGV(lh.getMaGV());
				String[] row = {lh.getMaLH(), lh.getTenLH(), String.valueOf(lh.getSiSo()), lh.getThoigianHoc(), lh.getNgayBatDau(), lh.getNgayKetThuc(), tenMon, tenGV, String.valueOf(lh.getSoLuong()), String.valueOf(lh.getHocphi())};		
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
		if(e.getSource() == adminview.btnResetLH) {
			adminview.txtNhapMaLH.setText("");
			adminview.txtNhapTenLH.setText("");
			adminview.txtNhapSiSoLH.setText("");
			adminview.txtNhapThoiGianHocLH.setText("");
			adminview.dateNBD.setDate(null);
			adminview.dateNKT.setDate(null);
		}
		if(e.getSource() == adminview.cbbTenGV) {
			String tenGV = adminview.cbbTenGV.getSelectedItem().toString();
			DefaultComboBoxModel<String> modelcbb = (DefaultComboBoxModel<String>) adminview.cbbMaGVLH.getModel();
			modelcbb.removeAllElements();
			ArrayList<String> list = GiaovienDAO.getInstance().getMaGVTuTen(tenGV);
			for(String ten : list) {
				modelcbb.addElement(ten);
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
	
		
		String ngaythangBD = (String) model.getValueAt(i, 4);
		String ngaythangKT = (String) model.getValueAt(i, 5);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date dateBD, dateKT;
			try {
				dateBD = dateFormat.parse(ngaythangBD);
				adminview.dateNBD.setDate(dateBD);
				dateKT = dateFormat.parse(ngaythangKT);
				adminview.dateNKT.setDate(dateKT);
			} catch (java.text.ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		adminview.cbbTenMH.setSelectedItem((String) model.getValueAt(i, 6));
		DefaultComboBoxModel<String> modelcbb = (DefaultComboBoxModel<String>) adminview.cbbMaGVLH.getModel();
		modelcbb.removeAllElements();
		String maGV = (String) model.getValueAt(i, 7);
		modelcbb.addElement(maGV);
		
		
		adminview.cbbTenGV.setSelectedItem((String) model.getValueAt(i, 7));
		adminview.txtHocPhi.setText((String) model.getValueAt(i, 9));
		
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume();							
			TTHV tthv = new TTHV();
			tthv.setVisible(true);
			//Them tt vao dialog
			ArrayList<Hocvien> list = LopHocDAO.getInstance().tTin(adminview.txtNhapMaLH.getText());
			DefaultTableModel model2 = (DefaultTableModel) tthv.table.getModel();
			
			tthv.maLH = adminview.txtNhapMaLH.getText();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			tthv.tenLH = adminview.txtNhapTenLH.getText();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			tthv.hocPhi = Integer.parseInt(adminview.txtHocPhi.getText());//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
			System.out.println(tthv.maLH);
			for(Hocvien hv : list) {	
				String gender ;
				if(hv.getGioiTinh() == true) gender = "Nam";
				else gender = "Nu";
				
				int tToan =  DangKiDAO.getInstance().getTToan(adminview.txtNhapMaLH.getText(), hv.getMaHV());
				
				String[] row = {hv.getMaHV(), hv.getName(), hv.getNamSinh(), gender, hv.getSdt(), hv.getTinhTrang(), Integer.toString(tToan)};
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
