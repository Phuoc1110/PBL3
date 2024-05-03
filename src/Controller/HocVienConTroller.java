package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String namSinh = dateFormat.format(adminview.dateHV.getDate());
		boolean gt = false;
		if(adminview.rdbtMaleHV.isSelected())
			gt = true;
		else if (adminview.rdbtFemaleHV.isSelected())
			gt= false;
		String sdt = adminview.txtNhapSDTHV.getText();
		String tinhTrang = adminview.nhapTinhTrang.getSelectedItem().toString();
		String matkhau = adminview.txtMatKhauHV.getText();
		Hocvien hv = new Hocvien(maHV,name,namSinh,gt,sdt,tinhTrang, matkhau);
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
				String[] row = {hv.getMaHV(), hv.getName(), hv.getNamSinh(), gender, hv.getSdt(), hv.getTinhTrang(), hv.getMatKhau()};
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
			if(adminview.txtNhapMaHV.getText().equals("")) {
				JOptionPane.showMessageDialog(adminview, "nhap maHV");
			}
			else {
				HocvienDAO.getInstance().insert(getDataView());
				DefaultTableModel model = (DefaultTableModel) adminview.tableHV.getModel();
				model.setRowCount(0);
				adminview.btnHienThiHV.doClick();
			}
		}
		else if (e.getSource() == adminview.btnResetHV) {
			adminview.txtNhapMaHV.setText("");
			adminview.txtNhapTenHV.setText("");
			adminview.dateHV.setDate(null);
			adminview.nhapTinhTrang.setSelectedItem("active");
			adminview.txtNhapSDTHV.setText("");		
			adminview.txtMatKhauHV.setText("");
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
		
		String ngaythang = (String) model.getValueAt(i, 2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		java.util.Date date;
		try {
			date = dateFormat.parse(ngaythang);
			adminview.dateHV.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (model.getValueAt(i, 3) == "Nam")
			adminview.rdbtMaleHV.setSelected(true);
		else
			adminview.rdbtFemaleHV.setSelected(true);
		adminview.txtNhapSDTHV.setText((String) model.getValueAt(i, 4));
		adminview.nhapTinhTrang.setSelectedItem(model.getValueAt(i, 5));
		adminview.txtMatKhauHV.setText((String)model.getValueAt(i, 6));
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