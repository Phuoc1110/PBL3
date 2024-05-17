package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import DAO.GiaovienDAO;
import DAO.LopHocDAO;
import DAO.MonHocDAO;
import Model.Giaovien;
import Model.Lophoc;
import View.AdminView;
import View.DSLHGV;


public class GiaoVienConTroler implements ActionListener, MouseListener{
	private AdminView adminview;
	
	public GiaoVienConTroler() {
		super();
	}
	public GiaoVienConTroler(AdminView adminview) {
		this.adminview = adminview;
	}
	
	public Giaovien getDataViewGV() {
		String maGV = adminview.txtNhapMaGV.getText();
		String nameGV = adminview.txtNhapTenGV.getText();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String namSinh = dateFormat.format(adminview.dateGV.getDate());
		
	
		Boolean gioiTinh;
		if(adminview.rdbtnMaleGV.isSelected()) {
			gioiTinh = true;
		}
		else
		gioiTinh = false;
		String chuyenMon = adminview.txtNhapChuyenMonGV.getText();
		String trinhDo = adminview.txtNhapTrinhDoGV.getText();
		int SDT = Integer.parseInt(adminview.txtNhapSDTGV.getText()) ;
		Giaovien gv = new Giaovien(maGV, nameGV, namSinh, gioiTinh, chuyenMon, trinhDo, SDT);
		
		return gv;
	}
	
	public boolean checkExistGV(String maGV) {
		ArrayList<Giaovien> list = GiaovienDAO.getInstance().selectAll();
		for(Giaovien gv : list) {
			if(gv.getMaGV().equals(maGV)) return true;
		}
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == adminview.btnHienThiGV) {
			
			ArrayList<Giaovien> list = GiaovienDAO.getInstance().selectAll();
			DefaultTableModel model = (DefaultTableModel) adminview.tableGV.getModel();
			model.setRowCount(0);
			for(Giaovien gv : list) {		
				String gender ;
				if(gv.getGioiTinh() == true) gender = "Nam";
				else gender = "Nu";
				String[] row = {gv.getMaGV(), gv.getName(), gv.getNamSinh(), gender, gv.getChuyenMon(), gv.getTrinhDo(), String.valueOf(gv.getSDT())};
				model.addRow(row);
			}
		}
		
		if(e.getSource() == adminview.btnThemGV) {
			int choice = JOptionPane.showConfirmDialog(adminview, "bạn muốn thêm giáo viên có mã là :" + adminview.txtNhapMaGV.getText() );
			if(choice == JOptionPane.YES_OPTION) {
				GiaovienDAO.getInstance().insert(getDataViewGV());
				DefaultTableModel model = (DefaultTableModel) adminview.tableGV.getModel();
				model.setRowCount(0);
				adminview.btnHienThiGV.doClick();
			}
			
		}
		if(e.getSource() == adminview.btnSuaGV) {
			int choice = JOptionPane.showConfirmDialog(adminview, "bạn muốn sửa giáo viên có mã là :" + adminview.txtNhapMaGV.getText());
			if(choice == JOptionPane.YES_OPTION) {
				if(!checkExistGV(adminview.txtNhapMaGV.getText())) {
					JOptionPane.showMessageDialog(null, adminview.txtNhapMaGV.getText()+ " khong ton tai");
				}
				else {
					GiaovienDAO.getInstance().update(getDataViewGV());
					adminview.btnHienThiGV.doClick();
				}
			}
		}
		if(e.getSource() == adminview.btnXoaGV) {
			int choice = JOptionPane.showConfirmDialog(adminview, "bạn muốn xóa giáo viên có mã là :" + adminview.txtNhapMaGV.getText());
			if(choice == JOptionPane.YES_OPTION) {
				GiaovienDAO.getInstance().delete(getDataViewGV());
				adminview.btnHienThiGV.doClick();
			}
			
		}
		if(e.getSource() == adminview.btnTimKiemGV) {
			ArrayList<Giaovien> list =  GiaovienDAO.getInstance().timKiemGV((String)adminview.txtNameGV.getText());
			DefaultTableModel model = (DefaultTableModel) adminview.tableGV.getModel();
			model.setRowCount(0);
			for(Giaovien gv : list) {		
				String gender ;
				if(gv.getGioiTinh() == true) gender = "Nam";
				else gender = "Nu";
				String[] row = {gv.getMaGV(), gv.getName(), gv.getNamSinh(), gender, gv.getChuyenMon(), gv.getTrinhDo(), String.valueOf(gv.getSDT())};
				model.addRow(row);	
		}
		}
		if(e.getSource() == adminview.btnResetGV) {
			adminview.txtNhapMaGV.setText("");
			adminview.txtNhapTenGV.setText("");
			adminview.dateGV.setDate(null);
			adminview.txtNhapTrinhDoGV.setText("");
			adminview.txtNhapChuyenMonGV.setText("");
			adminview.txtNhapSDTGV.setText("");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i = adminview.tableGV.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) adminview.tableGV.getModel();
		adminview.txtNhapMaGV.setText((String) model.getValueAt(i, 0));
		adminview.txtNhapTenGV.setText((String) model.getValueAt(i, 1));
		String ngaythang = (String) model.getValueAt(i, 2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		java.util.Date date;
		try {
			date = dateFormat.parse(ngaythang);
			adminview.dateGV.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if((String) model.getValueAt(i, 3) == "Nam") {
			adminview.rdbtnMaleGV.setSelected(true);
		}
		else {
			adminview.rdbtnFemaleGV.setSelected(true);
		}
		adminview.txtNhapChuyenMonGV.setText((String) model.getValueAt(i, 4));
		adminview.txtNhapTrinhDoGV.setText((String) model.getValueAt(i, 5));
		adminview.txtNhapSDTGV.setText((String) model.getValueAt(i, 6));
		
		if(e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume();
			DSLHGV dslh = new DSLHGV();
			dslh.setVisible(true);
			ArrayList<Lophoc> list = LopHocDAO.getInstance().selectByMaGV(adminview.txtNhapMaGV.getText());
			DefaultTableModel model2 = (DefaultTableModel) dslh.table.getModel();
			for(Lophoc lh : list) {
				String tenMon = MonHocDAO.getInstance().getTenTuID(lh.getMaMH());
				String tenGV = GiaovienDAO.getInstance().getTenGV(lh.getMaGV());
				String[] row = {lh.getMaLH(), lh.getTenLH(), String.valueOf(lh.getSiSo()), lh.getThoigianHoc(), lh.getNgayBatDau(), lh.getNgayKetThuc(), tenMon, tenGV, String.valueOf(lh.getSoLuong()), String.valueOf(lh.getHocphi())};		
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

