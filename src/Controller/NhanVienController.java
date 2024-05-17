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

import DAO.GiaovienDAO;
import DAO.NhanVienDAO;
import Model.Giaovien;
import Model.NhanVien;
import View.AdminView;

public class NhanVienController implements ActionListener, MouseListener{
	private AdminView adminview;
	
	public NhanVienController() {
		super();
	}
	public NhanVienController(AdminView adminview) {
		this.adminview = adminview;
	}
	
	public NhanVien getDataView() {
		String maNV = adminview.txtMaNV.getText();	
		String ten = adminview.txtTenNV.getText();
		String matKhau = adminview.txtMKNV.getText();
		int SDT = Integer.parseInt(adminview.txtSDTNV.getText());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String namSinh = dateFormat.format(adminview.dateNV.getDate());
		Boolean gioiTinh;
		if(adminview.rdbtnMaleNV.isSelected()) {
			gioiTinh = true;
		}
		else
		gioiTinh = false;
		NhanVien nv = new NhanVien(maNV, ten, matKhau, SDT, namSinh,gioiTinh);
		return nv;
	}
	public boolean checkExistNV(String maNV) {
		ArrayList<NhanVien> list = NhanVienDAO.getInstance().selectAll();
		for(NhanVien nv : list) {
			if(nv.getId().equals(maNV)) return true;
		}
		return false;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adminview.btnNhanVien) {
			adminview.tabbedPane.setSelectedIndex(5);
			ArrayList<NhanVien> list = NhanVienDAO.getInstance().selectAll();
			DefaultTableModel model = (DefaultTableModel) adminview.tableNV.getModel();
			model.setRowCount(0);
			for(NhanVien nv : list) {		
				String gender ;
				if(nv.GetGioitinh() == true) gender = "Nam";
				else gender = "Nu";
				String[] row = {nv.getId(), nv.getTen(), nv.getNgaysinh(), gender, String.valueOf(nv.getSDT()),nv.getMatkhau()};
				model.addRow(row);
			}
		}
		if(e.getSource() == adminview.btnThemNV) {
			int choice = JOptionPane.showConfirmDialog(adminview, "bạn muốn thêm nhân viên có mã là :" + adminview.txtMaNV.getText() );
			if(choice == JOptionPane.YES_OPTION) {
				NhanVienDAO.getInstance().insert(getDataView());
				DefaultTableModel model = (DefaultTableModel) adminview.tableNV.getModel();
				model.setRowCount(0);
				adminview.btnNhanVien.doClick();
			}
		}
		if(e.getSource() == adminview.btnSuaNV) {
			int choice = JOptionPane.showConfirmDialog(adminview, "bạn muốn sửa nhân viên có mã là :" + adminview.txtMaNV.getText());
			if(choice == JOptionPane.YES_OPTION) {
				if(!checkExistNV(adminview.txtMaNV.getText())) {
					JOptionPane.showMessageDialog(null, adminview.txtMaNV.getText()+ " khong ton tai");
				}
				else {
					NhanVienDAO.getInstance().update(getDataView());
					adminview.btnNhanVien.doClick();
				}
			}
		}
		if(e.getSource() == adminview.btnXoaNV) {
			int choice = JOptionPane.showConfirmDialog(adminview, "bạn muốn xóa nhân viên có mã là :" + adminview.txtMaNV.getText());
			if(choice == JOptionPane.YES_OPTION) {
				NhanVienDAO.getInstance().delete(getDataView());
				adminview.btnNhanVien.doClick();
			}
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int i = adminview.tableNV.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) adminview.tableNV.getModel();
		adminview.txtMaNV.setText((String) model.getValueAt(i, 0));
		adminview.txtTenNV.setText((String) model.getValueAt(i, 1));
		String ngaythang = (String) model.getValueAt(i, 2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		java.util.Date date;
		try {
			date = dateFormat.parse(ngaythang);
			adminview.dateNV.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if((String) model.getValueAt(i, 3) == "Nam") {
			adminview.rdbtnMaleNV.setSelected(true);
		}
		else {
			adminview.rdbtnFemaleNV.setSelected(true);
		}
		adminview.txtSDTNV.setText((String) model.getValueAt(i, 4));
		adminview.txtMKNV.setText((String)model.getValueAt(i, 5));
		
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
