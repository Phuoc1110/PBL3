//package Controller;
//
//import java.awt.Panel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import DAO.HocvienDAO;
//import View.HocVienView;
//
//public class HocVienViewConTroller implements ActionListener{
//	private HocVienView hocvienview;
//	
//	public HocVienViewConTroller() {
//		super();
//	}
//	
//	public HocVienViewConTroller(HocVienView hocvienview) {
//		this.hocvienview = hocvienview;
//	}
//	
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == hocvienview.btnSuattHV) {
//			hocvienview.setEnable();
//		}
//		if(e.getSource() == hocvienview.btnLuuHV) {
//			HocvienDAO.getInstance().update(hocvienview.getThongTinHV());
//			hocvienview.setNotEnable();
//		}
//		
//	}
//	
//	
//}
