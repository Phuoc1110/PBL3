package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.BienLaiController;
import Controller.DangKiController;
import Controller.GiaoVienConTroler;
import Controller.HocVienConTroller;
import Controller.HocVienConTroller;
import Controller.LopHocConTroller;
import Controller.NhanVienController;
import DAO.GiaovienDAO;
import DAO.HocvienDAO;
import DAO.LopHocDAO;
import DAO.MonHocDAO;
import Model.Giaovien;
import Model.MonHoc;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;

public class AdminView extends JFrame {
	
	
	public static final long serialVersionUID = 1L;
	public JPanel contentPane, Menu, panel_1_1 ;
	public JTabbedPane tabbedPane;
	public JTable tableGV,tableHV;
	public JLabel lblNewLabel,lblNewLabel_1;
	public JButton btnGiaoVien,btnHocVien, btnLopHoc, btnBienLai, btnThemGV, btnSuaGV, btnXoaGV, btnTimKiemGV, btnResetGV, btnResetLH;
	public JButton btnThemHV, btnSuaHV, btnXoaHV, btnHienThiHV, btnTimKiemHV ;
	public TextField txtNameGV; 
	public JTextField txtNhapMaGV;
	public JTextField txtNhapTenGV;
	public JTextField txtNhapChuyenMonGV;
	public JTextField txtNhapTrinhDoGV;
	public JTextField txtNhapSDTGV;
	public JTextField txtNhapMaHV;
	public JTextField txtNhapTenHV;
	public JTextField txtNhapSDTHV;
	
	public JRadioButton rdbtnFemaleGV, rdbtnMaleGV, rdbtMaleHV, rdbtFemaleHV;
	public JTextField txtNhapMaLH;
	public JTextField txtNhapTenLH;
	public JTextField txtNhapSiSoLH;
	public JTextField txtNhapThoiGianHocLH;
	public JTable tableLH;
	
	public JButton btnThemLH, btnSuaLH, btnXoaLH, btnHienThiLH, btnTimKiemLH;
	public JComboBox nhapTinhTrang, cbbMonDK;
	
	public JDateChooser dateGV, dateHV, dateNBD, dateNKT, dateLocNgayBD, dateLocNgayKT;
	public JTable tableBL;
	public JButton btnTimKiemBL, btnHienThiGV;
	public JTextField txtHocPhi;
	public JLabel lblSOLUONGHD, lblTONGTIEN;
	public JButton btnResetHV;
	public JComboBox cbbTenMH, cbbTenGV;
	public JComboBox cbbMaGVLH;
	public JPanel TieuDeBL_1;
	public JLabel lblNewLabel_4_2;
	public JLabel lblNewLabel_7;
	public JTextField txtMaHVDK;
	public JTable tableDK;
	public JButton btnHienThiDK;
	public JLabel lblNewLabel_10;
	public JLabel lblNewLabel_12;
	public JLabel lblNewLabel_13;
	public JLabel lblNewLabel_14;
	public JLabel lblSLHocVien, lblSLGiaoVien, lblSLLopHoc, lblSLNhanVien;
	public JTextField txtMaNV;
	public JTextField txtTenNV;
	public JTextField txtSDTNV;
	public JLabel lblNewLabel_7_1_1_1_2;
	public JTable tableNV;
	public JRadioButton rdbtnMaleNV, rdbtnFemaleNV;
	public JButton btnThemNV, btnSuaNV, btnXoaNV, btnNhanVien;
	public JDateChooser dateNV;
	public JTextField txtMKNV;

public AdminView() {
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1316, 763);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	Menu = new JPanel();
	Menu.setBounds(0, 0, 195, 703);
	Menu.setLayout(null);
	Menu.setBackground(new Color(36, 0, 72));
	Menu.setPreferredSize(new Dimension(150,703));;
	contentPane.setLayout(null);
	contentPane.add(Menu);
	
	lblNewLabel = new JLabel("PTAN  ");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Yu Mincho Demibold", Font.BOLD, 33));
	lblNewLabel.setBounds(10, 32, 146, 49);
	Menu.add(lblNewLabel);
	
	lblNewLabel_1 = new JLabel("Trung tâm dạy thêm");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	lblNewLabel_1.setBounds(20, 94, 124, 13);
	Menu.add(lblNewLabel_1);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBackground(Color.WHITE);
	separator.setBounds(10, 123, 162, 19);
	Menu.add(separator);
	
	JPanel panel_1 = new JPanel();
	panel_1.setLayout(null);
	panel_1.setBackground(new Color(51, 0, 102));
	panel_1.setBounds(0, 222, 195, 56);
	Menu.add(panel_1);
	
	btnGiaoVien = new JButton("Giáo viên");
	btnGiaoVien.setIcon(new ImageIcon(AdminView.class.getResource("/icon/icons8-teacher-24 (1).png")));
	btnGiaoVien.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(0);
		}
	});
	btnGiaoVien.setForeground(Color.WHITE);
	btnGiaoVien.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btnGiaoVien.setBackground(new Color(51, 0, 102));
	btnGiaoVien.setBounds(0, 0, 194, 56);
	panel_1.add(btnGiaoVien);
	
	panel_1_1 = new JPanel();
	panel_1_1.setLayout(null);
	panel_1_1.setBackground(new Color(36, 0, 72));
	panel_1_1.setBounds(0, 278, 195, 56);
	Menu.add(panel_1_1);
	
	btnHocVien = new JButton("Học viên");
	btnHocVien.setIcon(new ImageIcon(AdminView.class.getResource("/icon/user (11).png")));
	btnHocVien.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			tabbedPane.setSelectedIndex(1);
		}
	});
	btnHocVien.setForeground(Color.WHITE);
	btnHocVien.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btnHocVien.setBackground(new Color(36, 0, 72));
	btnHocVien.setBounds(0, 0, 195, 56);
	panel_1_1.add(btnHocVien);
	
	JPanel panel_1_2 = new JPanel();
	panel_1_2.setLayout(null);
	panel_1_2.setBackground(new Color(51, 0, 102));
	panel_1_2.setBounds(0, 332, 195, 56);
	Menu.add(panel_1_2);
	
	btnLopHoc = new JButton("Lớp học");
	btnLopHoc.setIcon(new ImageIcon(AdminView.class.getResource("/icon/presentation.png")));
	btnLopHoc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(2);
		}
	});
	btnLopHoc.setForeground(Color.WHITE);
	btnLopHoc.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btnLopHoc.setBackground(new Color(51, 0, 120));
	btnLopHoc.setBounds(0, 0, 194, 56);
	panel_1_2.add(btnLopHoc);
	
	JPanel panel_1_1_1 = new JPanel();
	panel_1_1_1.setLayout(null);
	panel_1_1_1.setBackground(new Color(36, 0, 72));
	panel_1_1_1.setBounds(0, 444, 195, 56);
	Menu.add(panel_1_1_1);
	
	btnBienLai = new JButton("Thống Kê");
	btnBienLai.setIcon(new ImageIcon(AdminView.class.getResource("/icon/icons8-receipt-24.png")));
	btnBienLai.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(3);
			lblSLHocVien.setText(Integer.toString(HocvienDAO.getInstance().getSLHocVien()));
			lblSLGiaoVien.setText(Integer.toString(GiaovienDAO.getInstance().getSLGV()));
			lblSLLopHoc.setText(Integer.toString(LopHocDAO.getInstance().getSLLH()));
		}
	});
	btnBienLai.setForeground(Color.WHITE);
	btnBienLai.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btnBienLai.setBackground(new Color(36, 0, 72));
	btnBienLai.setBounds(0, 0, 196, 56);
	panel_1_1_1.add(btnBienLai);
	
	JPanel panel_6_1_1 = new JPanel();
	panel_6_1_1.setBackground(new Color(147, 0, 73));
	panel_6_1_1.setBounds(0, 675, 197, 33);
	Menu.add(panel_6_1_1);
	
	JButton btnDangXuat = new JButton("Đăng xuất");
	btnDangXuat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			out();
		}
	});
	btnDangXuat.setForeground(Color.WHITE);
	btnDangXuat.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btnDangXuat.setBackground(new Color(51, 0, 120));
	btnDangXuat.setBounds(0, 620, 194, 56);
	Menu.add(btnDangXuat);
	
	JPanel panel_1_1_1_1 = new JPanel();
	panel_1_1_1_1.setLayout(null);
	panel_1_1_1_1.setBackground(new Color(36, 0, 72));
	panel_1_1_1_1.setBounds(0, 389, 195, 56);
	Menu.add(panel_1_1_1_1);
	
	btnNhanVien = new JButton("Nhân Viên");
	btnNhanVien.setForeground(Color.WHITE);
	btnNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 15));
	btnNhanVien.setBackground(new Color(36, 0, 72));
	btnNhanVien.setBounds(0, 0, 196, 56);
	panel_1_1_1_1.add(btnNhanVien);
	
	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(192, 0, 1308, 730);
	contentPane.add(tabbedPane);
	
	ButtonGroup group = new ButtonGroup();
	
	JPanel PanelGiaoVien = new JPanel();
	tabbedPane.addTab("New tab", null, PanelGiaoVien, null);
	PanelGiaoVien.setLayout(null);
	
	JPanel TieuDeGV = new JPanel();
	TieuDeGV.setBounds(0, 0, 1090, 251);
	TieuDeGV.setBackground(new Color(135, 123, 191));
	PanelGiaoVien.add(TieuDeGV);
	
	btnThemGV = new JButton("Thêm mới");
	btnThemGV.setBounds(144, 202, 117, 32);
	btnThemGV.setForeground(Color.WHITE);
	btnThemGV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnThemGV.setBackground(new Color(36, 0, 72));
	
	btnSuaGV = new JButton("Sửa");
	btnSuaGV.setBounds(291, 202, 71, 32);
	btnSuaGV.setForeground(Color.WHITE);
	btnSuaGV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnSuaGV.setBackground(new Color(36, 0, 72));
	
	btnXoaGV = new JButton("Xóa");
	btnXoaGV.setBounds(429, 202, 71, 32);
	btnXoaGV.setForeground(Color.WHITE);
	btnXoaGV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnXoaGV.setBackground(new Color(36, 0, 72));
	
	txtNameGV = new TextField();
	txtNameGV.setBounds(548, 202, 194, 32);
	
	btnTimKiemGV = new JButton("Tìm kiếm");
	btnTimKiemGV.setBounds(779, 202, 92, 32);
	btnTimKiemGV.setForeground(Color.WHITE);
	btnTimKiemGV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnTimKiemGV.setBackground(new Color(36, 0, 72));
	
	JLabel lblNewLabel_2 = new JLabel("Giáo viên");
	lblNewLabel_2.setBounds(423, 0, 189, 54);
	lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 40));
	lblNewLabel_2.setForeground(new Color(255, 255, 255));
	TieuDeGV.setLayout(null);
	TieuDeGV.add(btnThemGV);
	TieuDeGV.add(btnSuaGV);
	TieuDeGV.add(btnXoaGV);
	TieuDeGV.add(txtNameGV);
	TieuDeGV.add(btnTimKiemGV);
	TieuDeGV.add(lblNewLabel_2);
	
	txtNhapMaGV = new JTextField();
	txtNhapMaGV.setBounds(110, 69, 151, 30);
	TieuDeGV.add(txtNhapMaGV);
	txtNhapMaGV.setColumns(10);
	
	
	JLabel lblNewLabel_6 = new JLabel("MaGV");
	lblNewLabel_6.setBounds(25, 69, 64, 30);
	TieuDeGV.add(lblNewLabel_6);
	lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1 = new JLabel("Name");
	lblNewLabel_6_1.setBounds(25, 122, 64, 22);
	TieuDeGV.add(lblNewLabel_6_1);
	lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	txtNhapTenGV = new JTextField();
	txtNhapTenGV.setBounds(110, 121, 151, 30);
	TieuDeGV.add(txtNhapTenGV);
	txtNhapTenGV.setColumns(10);
	
	dateGV = new JDateChooser();
	dateGV.setBounds(372, 69, 154, 30);
	TieuDeGV.add(dateGV);
	dateGV.setDateFormatString("dd/MM/yyyy");
	
	JLabel lblNewLabel_6_1_1 = new JLabel("NamSinh");
	lblNewLabel_6_1_1.setBounds(283, 74, 79, 22);
	TieuDeGV.add(lblNewLabel_6_1_1);
	lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	rdbtnMaleGV = new JRadioButton("Male");
	rdbtnMaleGV.setBounds(372, 120, 70, 30);
	TieuDeGV.add(rdbtnMaleGV);
	rdbtnMaleGV.setSelected(true);
	group.add(rdbtnMaleGV);
	
	rdbtnFemaleGV = new JRadioButton("Female");
	rdbtnFemaleGV.setBounds(456, 120, 70, 30);
	TieuDeGV.add(rdbtnFemaleGV);
	group.add(rdbtnFemaleGV);
	
	JLabel lblNewLabel_6_1_2 = new JLabel("GioiTinh");
	lblNewLabel_6_1_2.setBounds(283, 122, 64, 22);
	TieuDeGV.add(lblNewLabel_6_1_2);
	lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	txtNhapChuyenMonGV = new JTextField();
	txtNhapChuyenMonGV.setBounds(655, 69, 151, 30);
	TieuDeGV.add(txtNhapChuyenMonGV);
	txtNhapChuyenMonGV.setColumns(10);
	
	JLabel lblNewLabel_6_1_3 = new JLabel("ChuyenMon");
	lblNewLabel_6_1_3.setBounds(542, 73, 103, 22);
	TieuDeGV.add(lblNewLabel_6_1_3);
	lblNewLabel_6_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	txtNhapTrinhDoGV = new JTextField();
	txtNhapTrinhDoGV.setBounds(655, 121, 151, 30);
	TieuDeGV.add(txtNhapTrinhDoGV);
	txtNhapTrinhDoGV.setColumns(10);
	
	JLabel lblNewLabel_6_1_3_1 = new JLabel("TrinhDo");
	lblNewLabel_6_1_3_1.setBounds(548, 129, 64, 22);
	TieuDeGV.add(lblNewLabel_6_1_3_1);
	lblNewLabel_6_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	txtNhapSDTGV = new JTextField();
	txtNhapSDTGV.setBounds(911, 69, 151, 30);
	TieuDeGV.add(txtNhapSDTGV);
	txtNhapSDTGV.setColumns(10);
	
	JLabel lblNewLabel_6_1_3_2 = new JLabel("SDT");
	lblNewLabel_6_1_3_2.setBounds(827, 70, 64, 22);
	TieuDeGV.add(lblNewLabel_6_1_3_2);
	lblNewLabel_6_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	
	
	btnResetGV = new JButton("Reset");
	btnResetGV.setBounds(939, 113, 82, 40);
	TieuDeGV.add(btnResetGV);
	btnResetGV.setForeground(Color.WHITE);
	btnResetGV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnResetGV.setBackground(new Color(36, 0, 72));
	
	btnHienThiGV = new JButton("Hiển thị");
	btnHienThiGV.setForeground(Color.WHITE);
	btnHienThiGV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnHienThiGV.setBackground(new Color(36, 0, 72));
	btnHienThiGV.setBounds(25, 202, 71, 32);
	TieuDeGV.add(btnHienThiGV);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setForeground(Color.WHITE);
	separator_2.setBackground(Color.WHITE);
	separator_2.setBounds(10, 178, 1058, 32);
	TieuDeGV.add(separator_2);

	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 261, 975, 398);
		PanelGiaoVien.add(scrollPane);
		
		tableGV = new JTable();
		scrollPane.setViewportView(tableGV);
		tableGV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MaGV", "name", "namSinh", "gioiTinh", "chuyenMon", "trinhDo", "SDT"
			}
		)
				{
				public boolean isCellEditable(int row, int column) {
		        return false; // Make all cells uneditable
				}	
				}
				);
		
		
	
	ButtonGroup group1 = new ButtonGroup();
	group1.add(rdbtFemaleHV);
	group1.add(rdbtMaleHV);
	
	
	JPanel PanelHocVien = new JPanel();
	tabbedPane.addTab("New tab", null, PanelHocVien, null);
	PanelHocVien.setLayout(null);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(58, 342, 870, 319);
	PanelHocVien.add(scrollPane_1);
	
	tableHV = new JTable();
	scrollPane_1.setViewportView(tableHV);
	tableHV.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"maHV", "name", "namSinh", "gioiTinh", "SDT", "tinhTrang", "matKhau"
		}
	) {
		public boolean isCellEditable(int row, int column) {
	        return false; // Make all cells uneditable
	    }	
	}	
			);
	
	
	
	JPanel TieuDeHV = new JPanel();
	TieuDeHV.setBounds(0, 10, 1095, 286);
	PanelHocVien.add(TieuDeHV);
	TieuDeHV.setBackground(new Color(135, 123, 191));
	TieuDeHV.setLayout(null);
	
	btnThemHV = new JButton("Thêm mới");
	btnThemHV.setForeground(Color.WHITE);
	btnThemHV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnThemHV.setBackground(new Color(36, 0, 72));
	btnThemHV.setBounds(10, 229, 117, 32);
	TieuDeHV.add(btnThemHV);
	
	btnSuaHV = new JButton("Sửa");
	btnSuaHV.setForeground(Color.WHITE);
	btnSuaHV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnSuaHV.setBackground(new Color(36, 0, 72));
	btnSuaHV.setBounds(138, 229, 71, 32);
	TieuDeHV.add(btnSuaHV);
	
	btnXoaHV = new JButton("Xóa");
	btnXoaHV.setForeground(Color.WHITE);
	btnXoaHV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnXoaHV.setBackground(new Color(36, 0, 72));
	btnXoaHV.setBounds(218, 229, 71, 32);
	TieuDeHV.add(btnXoaHV);
	
	btnHienThiHV = new JButton("Hiển thị");
	btnHienThiHV.setForeground(Color.WHITE);
	btnHienThiHV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnHienThiHV.setBackground(new Color(36, 0, 72));
	btnHienThiHV.setBounds(426, 229, 92, 32);
	TieuDeHV.add(btnHienThiHV);
	
	TextField textField = new TextField();
	textField.setBounds(548, 229, 179, 32);
	TieuDeHV.add(textField);
	
	JLabel lblNewLabel_5_2 = new JLabel("Họ tên:");
	lblNewLabel_5_2.setForeground(new Color(36, 0, 72));
	lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
	lblNewLabel_5_2.setBounds(548, 203, 71, 20);
	TieuDeHV.add(lblNewLabel_5_2);
	
	btnTimKiemHV = new JButton("Tìm kiếm");
	btnTimKiemHV.setForeground(Color.WHITE);
	btnTimKiemHV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnTimKiemHV.setBackground(new Color(36, 0, 72));
	btnTimKiemHV.setBounds(765, 229, 92, 32);
	TieuDeHV.add(btnTimKiemHV);
	
	JLabel lblNewLabel_3 = new JLabel("Học viên");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
	lblNewLabel_3.setBounds(399, 10, 150, 100);
	TieuDeHV.add(lblNewLabel_3);
	
	txtNhapMaHV = new JTextField();
	txtNhapMaHV.setBounds(138, 94, 151, 30);
	TieuDeHV.add(txtNhapMaHV);
	txtNhapMaHV.setColumns(10);
	
	
	JLabel lblNewLabel_6_2 = new JLabel("MaHV");
	lblNewLabel_6_2.setBounds(36, 91, 64, 30);
	TieuDeHV.add(lblNewLabel_6_2);
	lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1_4 = new JLabel("Name");
	lblNewLabel_6_1_4.setBounds(36, 146, 64, 22);
	TieuDeHV.add(lblNewLabel_6_1_4);
	lblNewLabel_6_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	txtNhapTenHV = new JTextField();
	txtNhapTenHV.setBounds(138, 145, 151, 30);
	TieuDeHV.add(txtNhapTenHV);
	txtNhapTenHV.setColumns(10);
	
	dateHV = new JDateChooser();
	dateHV.setBounds(426, 94, 148, 30);
	TieuDeHV.add(dateHV);
	dateHV.setDateFormatString("dd/MM/yyyy");
	
	JLabel lblNewLabel_6_1_1_1 = new JLabel("NamSinh");
	lblNewLabel_6_1_1_1.setBounds(328, 95, 79, 22);
	TieuDeHV.add(lblNewLabel_6_1_1_1);
	lblNewLabel_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1_2_1 = new JLabel("GioiTinh");
	lblNewLabel_6_1_2_1.setBounds(328, 146, 64, 22);
	TieuDeHV.add(lblNewLabel_6_1_2_1);
	lblNewLabel_6_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	rdbtMaleHV = new JRadioButton("Male");
	rdbtMaleHV.setBounds(426, 147, 53, 25);
	TieuDeHV.add(rdbtMaleHV);
	
	rdbtFemaleHV = new JRadioButton("Female");
	rdbtFemaleHV.setBounds(502, 147, 72, 25);
	TieuDeHV.add(rdbtFemaleHV);
	
	JLabel lblNewLabel_6_1_3_2_1 = new JLabel("SDT");
	lblNewLabel_6_1_3_2_1.setBounds(617, 95, 64, 22);
	TieuDeHV.add(lblNewLabel_6_1_3_2_1);
	lblNewLabel_6_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	txtNhapSDTHV = new JTextField();
	txtNhapSDTHV.setBounds(706, 94, 151, 30);
	TieuDeHV.add(txtNhapSDTHV);
	txtNhapSDTHV.setColumns(10);
	
	JLabel lblNewLabel_6_1_3_1_1 = new JLabel("TinhTrang");
	lblNewLabel_6_1_3_1_1.setBounds(601, 146, 87, 22);
	TieuDeHV.add(lblNewLabel_6_1_3_1_1);
	lblNewLabel_6_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	nhapTinhTrang = new JComboBox();
	nhapTinhTrang.setBounds(709, 144, 148, 30);
	TieuDeHV.add(nhapTinhTrang);
	nhapTinhTrang.addItem("active");
	nhapTinhTrang.addItem("inactive");
	
	btnResetHV = new JButton("RESET");
	btnResetHV.setForeground(Color.WHITE);
	btnResetHV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnResetHV.setBackground(new Color(36, 0, 72));
	btnResetHV.setBounds(945, 229, 92, 32);
	TieuDeHV.add(btnResetHV);
	
	
	
	
	JPanel PanelLopHoc = new JPanel();
	PanelLopHoc.setLayout(null);
	tabbedPane.addTab("New tab", null, PanelLopHoc, null);
	
	JPanel TieuDeLH = new JPanel();
	TieuDeLH.setBackground(new Color(135, 123, 191));
	TieuDeLH.setBounds(0, 10, 1094, 277);
	PanelLopHoc.add(TieuDeLH);
	TieuDeLH.setLayout(null);
	
	btnThemLH = new JButton("Thêm mới");
	btnThemLH.setBounds(10, 218, 117, 32);
	btnThemLH.setForeground(Color.WHITE);
	btnThemLH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnThemLH.setBackground(new Color(36, 0, 72));
	TieuDeLH.add(btnThemLH);
	
	btnSuaLH = new JButton("Sửa");
	btnSuaLH.setBounds(137, 218, 71, 32);
	btnSuaLH.setForeground(Color.WHITE);
	btnSuaLH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnSuaLH.setBackground(new Color(36, 0, 72));
	TieuDeLH.add(btnSuaLH);
	
	btnXoaLH = new JButton("Xóa");
	btnXoaLH.setBounds(225, 218, 71, 32);
	btnXoaLH.setForeground(Color.WHITE);
	btnXoaLH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnXoaLH.setBackground(new Color(36, 0, 72));
	TieuDeLH.add(btnXoaLH);
	
	btnHienThiLH = new JButton("Hiển thị");
	btnHienThiLH.setBounds(378, 218, 92, 32);
	btnHienThiLH.setForeground(Color.WHITE);
	btnHienThiLH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnHienThiLH.setBackground(new Color(36, 0, 72));
	TieuDeLH.add(btnHienThiLH);
	
	TextField textField_2 = new TextField();
	textField_2.setBounds(522, 229, 179, 21);
	TieuDeLH.add(textField_2);
	
	JLabel lblNewLabel_5_2_2 = new JLabel("Tên môn học");
	lblNewLabel_5_2_2.setBounds(522, 203, 98, 20);
	lblNewLabel_5_2_2.setForeground(new Color(36, 0, 72));
	lblNewLabel_5_2_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
	TieuDeLH.add(lblNewLabel_5_2_2);
	
	btnTimKiemLH = new JButton("Tìm kiếm");
	btnTimKiemLH.setBounds(788, 218, 92, 32);
	btnTimKiemLH.setForeground(Color.WHITE);
	btnTimKiemLH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnTimKiemLH.setBackground(new Color(36, 0, 72));
	TieuDeLH.add(btnTimKiemLH);
	
	JLabel lblNewLabel_4 = new JLabel("Lớp học");
	lblNewLabel_4.setBounds(412, -20, 150, 100);
	lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 24));
	TieuDeLH.add(lblNewLabel_4);
	
	JLabel lblNewLabel_6_3 = new JLabel("MaLH");
	lblNewLabel_6_3.setBounds(10, 76, 64, 30);
	TieuDeLH.add(lblNewLabel_6_3);
	lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1_5 = new JLabel("TenLop");
	lblNewLabel_6_1_5.setBounds(10, 139, 64, 22);
	TieuDeLH.add(lblNewLabel_6_1_5);
	lblNewLabel_6_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1_1_2 = new JLabel("SiSo");
	lblNewLabel_6_1_1_2.setBounds(217, 80, 79, 22);
	TieuDeLH.add(lblNewLabel_6_1_1_2);
	lblNewLabel_6_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1_2_2 = new JLabel("ThoiGianHoc");
	lblNewLabel_6_1_2_2.setBounds(217, 139, 103, 22);
	TieuDeLH.add(lblNewLabel_6_1_2_2);
	lblNewLabel_6_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1_3_3 = new JLabel("NgayBatDau");
	lblNewLabel_6_1_3_3.setBounds(446, 80, 103, 22);
	TieuDeLH.add(lblNewLabel_6_1_3_3);
	lblNewLabel_6_1_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1_3_1_2 = new JLabel("NgayKetThuc");
	lblNewLabel_6_1_3_1_2.setBounds(446, 139, 103, 22);
	TieuDeLH.add(lblNewLabel_6_1_3_1_2);
	lblNewLabel_6_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1_3_2_2 = new JLabel("TenMH");
	lblNewLabel_6_1_3_2_2.setBounds(674, 80, 64, 22);
	TieuDeLH.add(lblNewLabel_6_1_3_2_2);
	lblNewLabel_6_1_3_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JLabel lblNewLabel_6_1_3_2_2_1 = new JLabel("MaGV");
	lblNewLabel_6_1_3_2_2_1.setBounds(908, 139, 64, 22);
	TieuDeLH.add(lblNewLabel_6_1_3_2_2_1);
	lblNewLabel_6_1_3_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	txtNhapMaLH = new JTextField();
	txtNhapMaLH.setBounds(84, 72, 123, 30);
	TieuDeLH.add(txtNhapMaLH);
	txtNhapMaLH.setColumns(10);
	
	txtNhapTenLH = new JTextField();
	txtNhapTenLH.setBounds(84, 138, 123, 30);
	TieuDeLH.add(txtNhapTenLH);
	txtNhapTenLH.setColumns(10);
	
	txtNhapSiSoLH = new JTextField();
	txtNhapSiSoLH.setBounds(319, 72, 117, 30);
	TieuDeLH.add(txtNhapSiSoLH);
	txtNhapSiSoLH.setColumns(10);
	
	txtNhapThoiGianHocLH = new JTextField();
	txtNhapThoiGianHocLH.setBounds(319, 138, 117, 30);
	TieuDeLH.add(txtNhapThoiGianHocLH);
	txtNhapThoiGianHocLH.setColumns(10);
	
	dateNBD = new JDateChooser();
	dateNBD.setBounds(547, 72, 117, 30);
	TieuDeLH.add(dateNBD);
	dateNBD.setDateFormatString("dd/MM/yyyy");
	
	dateNKT = new JDateChooser();
	dateNKT.setBounds(547, 139, 117, 30);
	TieuDeLH.add(dateNKT);
	dateNKT.setDateFormatString("dd/MM/yyyy");
	
	txtHocPhi = new JTextField();
	txtHocPhi.setBounds(968, 72, 117, 30);
	TieuDeLH.add(txtHocPhi);
	txtHocPhi.setColumns(10);
	
	btnResetLH = new JButton("Reset");
	btnResetLH.setBounds(968, 214, 82, 40);
	TieuDeLH.add(btnResetLH);
	btnResetLH.setForeground(Color.WHITE);
	btnResetLH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	btnResetLH.setBackground(new Color(36, 0, 72));
	
	JLabel lblNewLabel_6_1_3_2_2_1_1 = new JLabel("HocPhi");
	lblNewLabel_6_1_3_2_2_1_1.setBounds(903, 80, 64, 22);
	TieuDeLH.add(lblNewLabel_6_1_3_2_2_1_1);
	lblNewLabel_6_1_3_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(Color.WHITE);
	separator_1.setBackground(Color.WHITE);
	separator_1.setBounds(20, 189, 1074, 19);
	TieuDeLH.add(separator_1);
	
	JLabel lblNewLabel_6_1_3_2_2_2 = new JLabel("TenGV");
	lblNewLabel_6_1_3_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_6_1_3_2_2_2.setBounds(674, 139, 64, 22);
	TieuDeLH.add(lblNewLabel_6_1_3_2_2_2);
	
	cbbTenMH = new JComboBox<String>();
	cbbTenMH.setBounds(732, 70, 148, 32);
	TieuDeLH.add(cbbTenMH);
	
	cbbTenGV = new JComboBox<String>();
	cbbTenGV.setBounds(732, 136, 148, 32);
	TieuDeLH.add(cbbTenGV);
	
	cbbMaGVLH = new JComboBox();
	cbbMaGVLH.setBounds(967, 138, 117, 32);
	TieuDeLH.add(cbbMaGVLH);
	
	
//	JScrollPane scrollPane_2 = new JScrollPane();
//	scrollPane_2.setBounds(73, 315, 848, 343);
//	PanelLopHoc.add(scrollPane_2);
//	
//	tableLH = new JTable();
//	scrollPane_2.setViewportView(tableLH);
//	tableLH.setModel(new DefaultTableModel(
//		new Object[][] {
//		},
//		new String[] {
//			"maLH", "tenLop", "siSo", "thoiGianHoc", "ngayBatDau", "ngayKetThuc", "maMH", "maGV"
//		}
//	));
	
	JScrollPane scrollPane_2 = new JScrollPane();
	scrollPane_2.setBounds(41, 297, 917, 342);
	PanelLopHoc.add(scrollPane_2);
	
		tableLH = new JTable();
		scrollPane_2.setViewportView(tableLH);
		tableLH.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] {
		        "maLH", "tenLop", "siSo", "thoiGianHoc", "ngayBatDau", "ngayKetThuc", "tenMH", "tenGV", "soLuong", "hocphi"
		    }
		) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Make all cells uneditable
		    }
		});
		JPanel PanelBienLai = new JPanel();
		PanelBienLai.setLayout(null);
		tabbedPane.addTab("New tab", null, PanelBienLai, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.inactiveCaption);
		panel_5.setBounds(10, 212, 415, 388);
		PanelBienLai.add(panel_5);
		panel_5.setLayout(null);
		
		dateLocNgayBD = new JDateChooser();
		dateLocNgayBD.setBounds(70, 75, 179, 33);
		panel_5.add(dateLocNgayBD);
		dateLocNgayBD.setDateFormatString("yyyy-MM-dd");
		
		dateLocNgayKT = new JDateChooser();
		dateLocNgayKT.setBounds(70, 169, 179, 33);
		panel_5.add(dateLocNgayKT);
		dateLocNgayKT.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblNewLabel_9 = new JLabel("TỪ");
		lblNewLabel_9.setBounds(10, 84, 67, 24);
		panel_5.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_9_1 = new JLabel("ĐẾN");
		lblNewLabel_9_1.setBounds(10, 178, 67, 24);
		panel_5.add(lblNewLabel_9_1);
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnTimKiemBL = new JButton("Hiển Thị");
		btnTimKiemBL.setBounds(70, 285, 196, 41);
		panel_5.add(btnTimKiemBL);
		btnTimKiemBL.setForeground(Color.WHITE);
		btnTimKiemBL.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnTimKiemBL.setBackground(new Color(36, 0, 72));
	
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(435, 212, 657, 388);
		PanelBienLai.add(scrollPane_3);
		
		tableBL = new JTable();
		scrollPane_3.setViewportView(tableBL);
		tableBL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MaHD", "maHV", "maLH", "hocphi", "ngayIn", "htThanhtoan"
			}
		));
		
		JLabel lblNewLabel_11 = new JLabel("SỐ HÓA ĐƠN");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_11.setBounds(470, 627, 143, 39);
		PanelBienLai.add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_1 = new JLabel("TỔNG SỐ TIỀN");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_11_1.setBounds(804, 627, 172, 39);
		PanelBienLai.add(lblNewLabel_11_1);
		
		lblSOLUONGHD = new JLabel("0");
		lblSOLUONGHD.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblSOLUONGHD.setBounds(607, 628, 91, 37);
		PanelBienLai.add(lblSOLUONGHD);
		
		lblTONGTIEN = new JLabel("0");
		lblTONGTIEN.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblTONGTIEN.setBounds(961, 628, 91, 37);
		PanelBienLai.add(lblTONGTIEN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(154, 205, 50));
		panel_2.setBounds(10, 20, 242, 170);
		PanelBienLai.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(AdminView.class.getResource("/icon/graduated.png")));
		lblNewLabel_5.setBounds(-11, 27, 124, 121);
		panel_2.add(lblNewLabel_5);
		
		lblNewLabel_10 = new JLabel("HỌC VIÊN");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10.setBounds(116, 105, 145, 33);
		panel_2.add(lblNewLabel_10);
		
		lblSLHocVien = new JLabel("New label");
		lblSLHocVien.setForeground(Color.GREEN);
		lblSLHocVien.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSLHocVien.setBounds(116, 16, 120, 68);
		panel_2.add(lblSLHocVien);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 206, 209));
		panel_2_1.setBounds(262, 20, 258, 170);
		PanelBienLai.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(AdminView.class.getResource("/icon/teacher.png")));
		lblNewLabel_12.setBounds(0, 10, 134, 139);
		panel_2_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(127, 101, -971, 35);
		panel_2_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_10_1 = new JLabel("GIÁO VIÊN");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10_1.setBounds(133, 102, 145, 33);
		panel_2_1.add(lblNewLabel_10_1);
		
		lblSLGiaoVien = new JLabel("New label");
		lblSLGiaoVien.setForeground(Color.GREEN);
		lblSLGiaoVien.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSLGiaoVien.setBounds(128, 16, 120, 68);
		panel_2_1.add(lblSLGiaoVien);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(123, 104, 238));
		panel_2_2.setBounds(530, 20, 277, 170);
		PanelBienLai.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(AdminView.class.getResource("/icon/blackboard.png")));
		lblNewLabel_13.setBounds(10, 10, 135, 134);
		panel_2_2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_10_2 = new JLabel("LỚP HỌC");
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10_2.setBounds(147, 104, 145, 33);
		panel_2_2.add(lblNewLabel_10_2);
		
		lblSLLopHoc = new JLabel("New label");
		lblSLLopHoc.setForeground(Color.GREEN);
		lblSLLopHoc.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSLLopHoc.setBounds(147, 16, 120, 68);
		panel_2_2.add(lblSLLopHoc);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBackground(new Color(218, 112, 214));
		panel_2_3.setBounds(817, 20, 275, 170);
		PanelBienLai.add(panel_2_3);
		panel_2_3.setLayout(null);
		
		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(AdminView.class.getResource("/icon/workplace.png")));
		lblNewLabel_14.setBounds(10, 15, 135, 150);
		panel_2_3.add(lblNewLabel_14);
		
		JLabel lblNewLabel_10_3 = new JLabel("NHÂN VIÊN");
		lblNewLabel_10_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10_3.setBounds(145, 105, 145, 33);
		panel_2_3.add(lblNewLabel_10_3);
		
		lblSLNhanVien = new JLabel("New label");
		lblSLNhanVien.setForeground(Color.GREEN);
		lblSLNhanVien.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSLNhanVien.setBounds(145, 16, 120, 68);
		panel_2_3.add(lblSLNhanVien);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		TieuDeBL_1 = new JPanel();
		TieuDeBL_1.setLayout(null);
		TieuDeBL_1.setBackground(new Color(135, 123, 191));
		TieuDeBL_1.setBounds(14, 10, 427, 508);
		panel.add(TieuDeBL_1);
		
		lblNewLabel_7 = new JLabel("MaHV");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_7.setBounds(22, 213, 80, 28);
		TieuDeBL_1.add(lblNewLabel_7);
		
		txtMaHVDK = new JTextField();
		txtMaHVDK.setColumns(10);
		txtMaHVDK.setBounds(112, 213, 179, 33);
		TieuDeBL_1.add(txtMaHVDK);
		
		cbbMonDK = new JComboBox();
		cbbMonDK.setBounds(127, 312, 150, 33);
		TieuDeBL_1.add(cbbMonDK);
		
		btnHienThiDK = new JButton("Hiển thị");
		btnHienThiDK.setBounds(116, 415, 161, 34);
		TieuDeBL_1.add(btnHienThiDK);
		
		lblNewLabel_4_2 = new JLabel("ĐĂNG KÍ");
		lblNewLabel_4_2.setBounds(127, 61, 150, 60);
		TieuDeBL_1.add(lblNewLabel_4_2);
		lblNewLabel_4_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 33));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(451, 10, 647, 607);
		panel.add(scrollPane_4);
		
		tableDK = new JTable();
		scrollPane_4.setViewportView(tableDK);
		tableDK.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"maLH", "tenLop", "siSo", "thoiGianHoc", "ngayBatDau", "ngayKetThuc", "tenMH", "tenGV", "soLuong", "hocphi"
			}
		) {
			public boolean isCellEditable(int row, int column) {
	        return false; 
	    }
		});
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel TieuDeBL_1_1 = new JPanel();
		TieuDeBL_1_1.setLayout(null);
		TieuDeBL_1_1.setBackground(new Color(135, 123, 191));
		TieuDeBL_1_1.setBounds(10, 10, 449, 636);
		panel_3.add(TieuDeBL_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("MaNV");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_7_1.setBounds(42, 160, 80, 28);
		TieuDeBL_1_1.add(lblNewLabel_7_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(152, 162, 179, 33);
		TieuDeBL_1_1.add(txtMaNV);
		
		btnThemNV = new JButton("THÊM");
		btnThemNV.setBounds(29, 553, 115, 34);
		TieuDeBL_1_1.add(btnThemNV);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("NHÂN VIÊN");
		lblNewLabel_4_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 33));
		lblNewLabel_4_2_1.setBounds(114, 59, 202, 60);
		TieuDeBL_1_1.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("TÊN");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_7_1_1.setBounds(42, 216, 80, 28);
		TieuDeBL_1_1.add(lblNewLabel_7_1_1);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(152, 218, 179, 33);
		TieuDeBL_1_1.add(txtTenNV);
		
		dateNV = new JDateChooser();
		dateNV.setDateFormatString("dd/MM/yyyy");
		dateNV.setBounds(152, 274, 179, 33);
		TieuDeBL_1_1.add(dateNV);
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("NGÀY SINH");
		lblNewLabel_7_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_7_1_1_1.setBounds(10, 274, 112, 28);
		TieuDeBL_1_1.add(lblNewLabel_7_1_1_1);
		
		rdbtnMaleNV = new JRadioButton("MALE");
		rdbtnMaleNV.setBounds(152, 334, 101, 34);
		TieuDeBL_1_1.add(rdbtnMaleNV);
		
		rdbtnFemaleNV = new JRadioButton("FEMALE");
		rdbtnFemaleNV.setBounds(288, 334, 95, 34);
		TieuDeBL_1_1.add(rdbtnFemaleNV);
		
		ButtonGroup group5 = new ButtonGroup();
		group5.add(rdbtnMaleNV);
		group5.add(rdbtnFemaleNV);
		
		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("GIỚI TÍNH");
		lblNewLabel_7_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_7_1_1_1_1.setBounds(10, 335, 112, 28);
		TieuDeBL_1_1.add(lblNewLabel_7_1_1_1_1);
		
		JLabel lblNewLabel_7_1_1_2 = new JLabel("SDT");
		lblNewLabel_7_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_7_1_1_2.setBounds(42, 399, 80, 28);
		TieuDeBL_1_1.add(lblNewLabel_7_1_1_2);
		
		txtSDTNV = new JTextField();
		txtSDTNV.setColumns(10);
		txtSDTNV.setBounds(152, 399, 179, 33);
		TieuDeBL_1_1.add(txtSDTNV);
		
		lblNewLabel_7_1_1_1_2 = new JLabel("MẬT KHẨU");
		lblNewLabel_7_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_7_1_1_1_2.setBounds(10, 467, 112, 28);
		TieuDeBL_1_1.add(lblNewLabel_7_1_1_1_2);
		
		btnSuaNV = new JButton("SỬA");
		btnSuaNV.setBounds(165, 553, 115, 34);
		TieuDeBL_1_1.add(btnSuaNV);
		
		btnXoaNV = new JButton("XÓA");
		btnXoaNV.setBounds(304, 553, 115, 34);
		TieuDeBL_1_1.add(btnXoaNV);
		
		txtMKNV = new JTextField();
		txtMKNV.setColumns(10);
		txtMKNV.setBounds(152, 467, 179, 33);
		TieuDeBL_1_1.add(txtMKNV);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(492, 42, 584, 549);
		panel_3.add(scrollPane_5);
		
		tableNV = new JTable();
		tableNV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Ten", "NgaySinh", "GioiTinh", "SDT", "MatKhau"
			}
		));
		scrollPane_5.setViewportView(tableNV);
		setCBBDK();
		
	
	
	
	//SU lI SU KIEN
	//GIAOVIEN
	ActionListener acgv = new GiaoVienConTroler(this);
	btnResetGV.addActionListener(acgv);
	btnThemGV.addActionListener(acgv);
	btnSuaGV.addActionListener(acgv);
	btnXoaGV.addActionListener(acgv);
	btnTimKiemGV.addActionListener(acgv);
	btnHienThiGV.addActionListener(acgv);
	
	
	
	MouseListener mlgv = new GiaoVienConTroler(this);
	tableGV.addMouseListener(mlgv);

	//LOPHOC
	ActionListener aclh = new LopHocConTroller(this);
	btnHienThiLH.addActionListener(aclh);
	btnSuaLH.addActionListener(aclh);
	btnThemLH.addActionListener(aclh);
	btnXoaLH.addActionListener(aclh);
	btnTimKiemLH.addActionListener(aclh);
	btnResetLH.addActionListener(aclh);
	cbbTenGV.addActionListener(aclh);

	
	
	MouseListener mllh = new LopHocConTroller(this);
	tableLH.addMouseListener(mllh);
	
	
	//HOC VIEN
	ActionListener hv = new HocVienConTroller(this); 
	btnHienThiHV.addActionListener(hv);
	btnXoaHV.addActionListener(hv);
	btnThemHV.addActionListener(hv);
	btnSuaHV.addActionListener(hv);
	btnResetHV.addActionListener(hv);

  
	
	MouseListener mlhv = new HocVienConTroller(this);
	tableHV.addMouseListener(mlhv);
	
	setCBBTenGV();
	setCBBMH();
	this.setVisible(true);
	
	
	//BIEN LAI
	ActionListener bl = new BienLaiController(this);
	btnTimKiemBL.addActionListener(bl);
	
	//DANG KI
	ActionListener dk = new DangKiController(this);
	btnHienThiDK.addActionListener(dk);
	
	MouseListener mldk = new DangKiController(this);
	tableDK.addMouseListener(mldk);
	
	//NhanVien
	ActionListener nv = new NhanVienController(this);
	btnThemNV.addActionListener(nv);
	btnSuaNV.addActionListener(nv);
	btnXoaNV.addActionListener(nv);
	btnNhanVien.addActionListener(nv);
	
	MouseListener mlnv = new NhanVienController(this);
	tableNV.addMouseListener(mlnv);
	
}
	public void setCBBTenGV() {
		ArrayList<Giaovien> list = GiaovienDAO.getInstance().selectAll();
		HashSet<String> uniqueItems = new HashSet<>();
		for(Giaovien gv : list) {
			uniqueItems.add(gv.getName());
		}
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cbbTenGV.getModel();
		for(String item : uniqueItems) {
			model.addElement(item);
		}
	}
	
	public void setCBBMH() {
		ArrayList<MonHoc> list = MonHocDAO.getInstance().selectAll();
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cbbTenMH.getModel();
		for(MonHoc mh : list) {
			model.addElement(mh.getTenMon());
		}
	}
	public void out() {
		this.dispose();
	}
	public void setCBBDK() {
		ArrayList<MonHoc> list = MonHocDAO.getInstance().selectAll();
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cbbMonDK.getModel();
		for(MonHoc mh : list) {
			model.addElement(mh.getTenMon());
		}
		model.addElement("All");
	}
}
