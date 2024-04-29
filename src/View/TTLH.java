package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.GiaovienDAO;
import DAO.LopHocDAO;
import DAO.MonHocDAO;
import Model.Giaovien;
import Model.Lophoc;
import Model.MonHoc;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class TTLH extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Lophoc lh;
	private MonHoc mh;
	private Giaovien gv;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TTLH dialog = new TTLH("100");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TTLH(String idLH) {
		
		lh = LopHocDAO.getInstance().selectById(idLH);
		mh = MonHocDAO.getInstance().selectById(lh.getMaMH());
		gv = GiaovienDAO.getInstance().selectById(lh.getMaGV());
		
		setBounds(100, 100, 760, 535);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.CYAN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN LỚP HỌC");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(296, 25, 266, 33);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MaLH");
		lblNewLabel_1.setBounds(61, 90, 77, 25);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Môn học");
		lblNewLabel_2.setBounds(61, 141, 77, 25);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thời gian học");
		lblNewLabel_1_1.setBounds(420, 90, 114, 25);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày bắt đầu");
		lblNewLabel_1_2.setBounds(420, 141, 77, 25);
		contentPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Sỉ số");
		lblNewLabel_1_3.setBounds(61, 193, 77, 25);
		contentPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày kết thúc");
		lblNewLabel_1_4.setBounds(420, 193, 77, 25);
		contentPanel.add(lblNewLabel_1_4);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.CYAN);
		separator.setForeground(Color.CYAN);
		separator.setBounds(68, 284, 537, 2);
		contentPanel.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TTLH.class.getResource("/icon/icons8-teacher-100.png")));
		lblNewLabel_3.setBounds(45, 311, 132, 99);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Tên GV");
		lblNewLabel_1_3_1.setBounds(204, 311, 77, 25);
		contentPanel.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Chuyên môn");
		lblNewLabel_1_3_2.setBounds(457, 311, 77, 25);
		contentPanel.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Năm sinh");
		lblNewLabel_1_3_3.setBounds(204, 371, 77, 25);
		contentPanel.add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("Trình độ");
		lblNewLabel_1_3_4.setBounds(457, 371, 77, 25);
		contentPanel.add(lblNewLabel_1_3_4);
		
		JLabel lblNewLabel_1_3_5 = new JLabel("Giới tính");
		lblNewLabel_1_3_5.setBounds(204, 433, 77, 25);
		contentPanel.add(lblNewLabel_1_3_5);
		
		JLabel lblNewLabel_1_3_6 = new JLabel("SDT");
		lblNewLabel_1_3_6.setBounds(457, 433, 77, 25);
		contentPanel.add(lblNewLabel_1_3_6);
		
		JLabel lblNewLabel_4 = new JLabel("Số lượng");
		lblNewLabel_4.setBounds(61, 250, 77, 24);
		contentPanel.add(lblNewLabel_4);
		
		
		
		JLabel lblmaLH = new JLabel(lh.getMaLH());
		lblmaLH.setBounds(182, 90, 77, 25);
		contentPanel.add(lblmaLH);
		
		JLabel lblTenMH = new JLabel(mh.getTenMon());
		lblTenMH.setBounds(182, 141, 77, 25);
		contentPanel.add(lblTenMH);
		
		JLabel lblSiSo = new JLabel(Integer.toString(lh.getSiSo()));
		lblSiSo.setBounds(182, 199, 77, 25);
		contentPanel.add(lblSiSo);
		
		JLabel lblSoLuong = new JLabel("MaLH");
		lblSoLuong.setBounds(182, 250, 77, 25);
		contentPanel.add(lblSoLuong);
		
		JLabel lblTGH = new JLabel(lh.getThoigianHoc());
		lblTGH.setBounds(544, 90, 77, 25);
		contentPanel.add(lblTGH);
		
		JLabel lblNBD = new JLabel(lh.getNgayBatDau());
		lblNBD.setBounds(544, 141, 77, 25);
		contentPanel.add(lblNBD);
		
		JLabel lblNKT = new JLabel(lh.getNgayKetThuc());
		lblNKT.setBounds(544, 193, 77, 25);
		contentPanel.add(lblNKT);
		
		
		
		JLabel lblTenGV = new JLabel(gv.getName());
		lblTenGV.setBounds(291, 311, 77, 25);
		contentPanel.add(lblTenGV);
		
		JLabel lblNamSinhGV = new JLabel(gv.getNamSinh());
		lblNamSinhGV.setBounds(291, 371, 77, 25);
		contentPanel.add(lblNamSinhGV);
		
		if(gv.getGioiTinh() == true) {
			JLabel lblGioiTinhGV = new JLabel("Nam");
			lblGioiTinhGV.setBounds(291, 433, 77, 25);
			contentPanel.add(lblGioiTinhGV);
		}
		else {
		JLabel lblGioiTinhGV = new JLabel("Nu");
		lblGioiTinhGV.setBounds(291, 433, 77, 25);
		contentPanel.add(lblGioiTinhGV);
		}
		
		JLabel lblCM = new JLabel(gv.getChuyenMon());
		lblCM.setBounds(558, 311, 77, 25);
		contentPanel.add(lblCM);
		
		JLabel lblTD = new JLabel(gv.getTrinhDo());
		lblTD.setBounds(558, 371, 77, 25);
		contentPanel.add(lblTD);
		
		JLabel lblSDT = new JLabel(Integer.toString(gv.getSDT()));
		lblSDT.setBounds(558, 433, 77, 25);
		contentPanel.add(lblSDT);
		
		this.setVisible(true);
	}
}
