package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import DAO.HocvienDAO;
import Model.Hocvien;
import View.AdminView;


public class HocVienConTroller implements ActionListener, MouseListener {
	private AdminView adminview;

	public HocVienConTroller(AdminView adminview) {
		this.adminview = adminview;
	}
	
	public Hocvien getDataView() {
		
		String maHV = adminview.txtNhapMaHV.getText();
		String name = adminview.txtNhapTenHV.getText();
		String namSinh = adminview.txtNhapNamSinhHV.getText();
		boolean gt = false;
		if(adminview.rdbtMaleHV.isSelected())
			gt = true;
		else if (adminview.rdbtFemaleHV.isSelected())
			gt= false;
		String sdt = adminview.txtNhapSDTHV.getText();
		String tinhTrang = adminview.nhapTinhTrang.getSelectedItem().toString();
		Hocvien hv = new Hocvien(maHV,name,namSinh,gt,sdt,tinhTrang);
		return hv;
	}
	
	public boolean checkExist(String maHV) {
		ArrayList<Hocvien> hv = HocvienDAO.getInstance().selectAll();
		for (Hocvien i : hv) {
			if (i.getMaHV().equals(maHV))
				return true;
		}
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Hien thi HV
		if (e.getSource() == adminview.btnHienThiHV) {
			ArrayList<Hocvien> list = HocvienDAO.getInstance().selectAll();
			DefaultTableModel model = (DefaultTableModel) adminview.tableHV.getModel();
			while(model.getRowCount() > 0)
			{
			    model.removeRow(0);
			}
			for(Hocvien hv : list) {	
				String gender ;
				if(hv.getGioiTinh() == true) gender = "Nam";
				else gender = "Nu";
				String[] row = {hv.getMaHV(), hv.getName(), hv.getNamSinh(), gender, hv.getSdt(), hv.getTinhTrang()};
				model.addRow(row);
			}
		}
		//Xoa HV
		else if (e.getSource() == adminview.btnXoaHV) {
			DefaultTableModel model = (DefaultTableModel) adminview.tableHV.getModel();
			if (adminview.tableHV.getSelectedRowCount() == 1) {
				HocvienDAO.getInstance().delete(getDataView());
				model.removeRow(adminview.tableHV.getSelectedRow());
				
			}
			else if (adminview.tableHV.getRowCount() == 0) {
				JOptionPane.showMessageDialog(adminview, "Không có gì để xóa.");
			}
			//nếu không chọn hàng mà vẫn bấm delete
			else {
				JOptionPane.showMessageDialog(adminview, "Chỉ được chọn 1 dòng để xóa.");
			}
		}
		//Them HV
		else if (e.getSource() == adminview.btnThemHV) {
			HocvienDAO.getInstance().insert(getDataView());
			DefaultTableModel model = (DefaultTableModel) adminview.tableHV.getModel();
			model.setRowCount(0);
			adminview.btnHienThiHV.doClick();
		}
		else if (e.getSource() == adminview.btnResetHV) {
			adminview.txtNhapMaHV.setText("");
			adminview.txtNhapTenHV.setText("");
			adminview.txtNhapNamSinhHV.setText("");
			adminview.nhapTinhTrang.setSelectedItem("active");
			adminview.txtNhapSDTHV.setText("");			
		}
		//Sua HV
		else if (e.getSource() == adminview.btnSuaHV) {
			if(!checkExist(adminview.txtNhapMaHV.getText())) {
				JOptionPane.showMessageDialog(null, adminview.txtNhapMaHV.getText()+ " khong ton tai");
			}
			else {
				HocvienDAO.getInstance().update(getDataView());
				adminview.btnHienThiHV.doClick();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i = adminview.tableHV.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) adminview.tableHV.getModel();
		adminview.txtNhapMaHV.setText((String) model.getValueAt(i, 0));
		adminview.txtNhapTenHV.setText((String) model.getValueAt(i, 1));
		adminview.txtNhapNamSinhHV.setText((String) model.getValueAt(i, 2));
		if (model.getValueAt(i, 3) == "Nam")
			adminview.rdbtMaleHV.setSelected(true);
		else
			adminview.rdbtFemaleHV.setSelected(true);
		adminview.txtNhapSDTHV.setText((String) model.getValueAt(i, 4));
		adminview.nhapTinhTrang.setSelectedItem(model.getValueAt(i, 5));
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
