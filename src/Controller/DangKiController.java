package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.DangKiDAO;
import DAO.GiaovienDAO;
import DAO.LopHocDAO;
import DAO.MonHocDAO;
import Model.DangKi;
import Model.Hocvien;
import Model.Lophoc;
import View.AdminView;
import View.TTHV;

public class DangKiController implements ActionListener, MouseListener{
	private AdminView adminview;
	public DangKiController() {
		super();
	}
	public DangKiController(AdminView adminview) {
		this.adminview = adminview;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adminview.btnHienThiDK) {
			ArrayList<Lophoc> list = new ArrayList<Lophoc>();
			String tm = adminview.cbbMonDK.getSelectedItem().toString();
			if(tm.equals("All")) {
				for (String s : DangKiDAO.getInstance().getLopKhongDK(adminview.txtMaHVDK.getText())) {
					list.add(LopHocDAO.getInstance().selectById(s));
				}
			}
			else {
				String id = MonHocDAO.getInstance().getIdTuTenMH(adminview.cbbMonDK.getSelectedItem().toString());
				for(Lophoc lh : LopHocDAO.getInstance().selectByMaMH(id)) {
					list.add(lh);
				}
			}
			
			
			DefaultTableModel model = (DefaultTableModel) adminview.tableDK.getModel();
			model.setRowCount(0);
			for(Lophoc lh : list) {	
				String tenMon = MonHocDAO.getInstance().getTenTuID(lh.getMaMH());
				String tenGV = GiaovienDAO.getInstance().getTenGV(lh.getMaGV());
				String[] row = {lh.getMaLH(), lh.getTenLH(), String.valueOf(lh.getSiSo()), lh.getThoigianHoc(), lh.getNgayBatDau(), lh.getNgayKetThuc(), tenMon, tenGV, String.valueOf(lh.getSoLuong()), String.valueOf(lh.getHocphi())};		
				model.addRow(row);
			}
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2 && !e.isConsumed()) {
					int choice = JOptionPane.showConfirmDialog(adminview, "bạn muon dang ki lop hoc" );
					if(choice == JOptionPane.YES_OPTION) {
						String idHV = adminview.txtMaHVDK.getText();
						int i = adminview.tableDK.getSelectedRow();
						DefaultTableModel model = (DefaultTableModel) adminview.tableDK.getModel();
						String maLH = ((String) model.getValueAt(i, 0));
						DangKi dk = new DangKi(idHV, maLH, false);
						DangKiDAO.getInstance().insert(dk);	
						adminview.btnHienThiDK.doClick();
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
