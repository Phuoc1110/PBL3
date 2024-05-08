package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAO.GiaovienDAO;
import DAO.LopHocDAO;
import Model.Hocvien;
import View.GiaoVienView;
import View.TTHV;

public class GiaoVienViewConTroller implements ActionListener, MouseListener{
	private GiaoVienView giaovienview;
	
	public GiaoVienViewConTroller(GiaoVienView giaovienview) {
		this.giaovienview = giaovienview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == giaovienview.btnSuattGV) {
			giaovienview.setEnable();
		}
		if(e.getSource() == giaovienview.btnLuuGV) {
//			GiaovienDAO.getInstance().update(giaovienview.getThongTinGV());
			giaovienview.setNotEnable();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume();							//tra sau
			TTHV tthv = new TTHV();
			tthv.setVisible(true);
			//Them tt vao dialog
			int selectedRow = giaovienview.tableLHGV.getSelectedRow();
			DefaultTableModel model = (DefaultTableModel) giaovienview.tableLHGV.getModel();
			String id = (String) model.getValueAt(selectedRow, 0);
			
			ArrayList<Hocvien> list = LopHocDAO.getInstance().tTin(id);
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
