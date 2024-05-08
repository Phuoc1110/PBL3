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
import Controller.GiaoVienConTroler;
import Controller.HocVienConTroller;
import Controller.HocVienConTroller;
import Controller.LopHocConTroller;
import DAO.GiaovienDAO;
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

public class AdminView extends JFrame {
	
	
	public static final long serialVersionUID = 1L;
	public JPanel contentPane, Menu ;
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
	public JComboBox nhapTinhTrang;
	public JTextField txtHocPhiBL;
	
	public JDateChooser dateGV, dateHV, dateNBD, dateNKT, dateLocNgayBD, dateLocNgayKT;
	public JTable tableBL;
	public JButton btnInBienLai, btnTimKiemBL, btnHienThiGV;
	public JComboBox cbbNhapMaLHBL, cbbNhapHTTT;
	public JTextField txtNhapMaHVBL;
	public JTextField txtTimKiemHVBL;
	public JTextField txtHocPhi;
	public JLabel lblSOLUONGHD, lblTONGTIEN;
	public JButton btnResetHV;
	public JComboBox cbbTenMH, cbbTenGV;
	public JComboBox cbbMaGVLH;

public AdminView() {
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1299, 777);
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
	panel_1.setBounds(0, 173, 195, 56);
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
	
	JPanel panel_1_1 = new JPanel();
	panel_1_1.setLayout(null);
	panel_1_1.setBackground(new Color(36, 0, 72));
	panel_1_1.setBounds(0, 228, 195, 56);
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
	panel_1_2.setBounds(0, 283, 195, 56);
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
	panel_1_1_1.setBounds(0, 338, 195, 56);
	Menu.add(panel_1_1_1);
	
	btnBienLai = new JButton("Biên lai");
	btnBienLai.setIcon(new ImageIcon(AdminView.class.getResource("/icon/icons8-receipt-24.png")));
	btnBienLai.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(3);
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
	
	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(192, 0, 1308, 730);
	contentPane.add(tabbedPane);
	
	ButtonGroup group = new ButtonGroup();
	
	JPanel PanelGiaoVien = new JPanel();
	tabbedPane.addTab("New tab", null, PanelGiaoVien, null);
	PanelGiaoVien.setLayout(null);
	
	JPanel TieuDeGV = new JPanel();
	TieuDeGV.setBounds(0, 0, 1090, 278);
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
	btnResetGV.setBounds(941, 122, 82, 40);
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

	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 320, 834, 300);
		PanelGiaoVien.add(scrollPane);
		
		tableGV = new JTable();
		scrollPane.setViewportView(tableGV);
		tableGV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MaGV", "name", "namSinh", "gioiTinh", "chuyenMon", "trinhDo", "SDT"
			}
		));
	
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
	));
	
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
		
		JPanel TieuDeBL = new JPanel();
		TieuDeBL.setLayout(null);
		TieuDeBL.setBackground(new Color(135, 123, 191));
		TieuDeBL.setBounds(0, 25, 1293, 177);
		PanelBienLai.add(TieuDeBL);
		
		dateLocNgayBD = new JDateChooser();
		dateLocNgayBD.setDateFormatString("yyyy-MM-dd");
		dateLocNgayBD.setBounds(461, 134, 179, 33);
		TieuDeBL.add(dateLocNgayBD);
		
		dateLocNgayKT = new JDateChooser();
		dateLocNgayKT.setDateFormatString("yyyy-MM-dd");
		dateLocNgayKT.setBounds(724, 134, 179, 33);
		TieuDeBL.add(dateLocNgayKT);
		
		JLabel lblNewLabel_4_1 = new JLabel("Biên lai");
		lblNewLabel_4_1.setBounds(490, 10, 150, 60);
		TieuDeBL.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 33));
		
		JLabel lblNewLabel_9 = new JLabel("TỪ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(462, 100, 67, 24);
		TieuDeBL.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("ĐẾN");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_1.setBounds(721, 100, 67, 24);
		TieuDeBL.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10 = new JLabel("MaHV");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(75, 98, 80, 28);
		TieuDeBL.add(lblNewLabel_10);
		
		btnTimKiemBL = new JButton("Hiển Thị");
		btnTimKiemBL.setForeground(Color.WHITE);
		btnTimKiemBL.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnTimKiemBL.setBackground(new Color(36, 0, 72));
		btnTimKiemBL.setBounds(1002, 126, 196, 41);
		TieuDeBL.add(btnTimKiemBL);
		
		txtTimKiemHVBL = new JTextField();
		txtTimKiemHVBL.setColumns(10);
		txtTimKiemHVBL.setBounds(70, 134, 179, 33);
		TieuDeBL.add(txtTimKiemHVBL);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.inactiveCaption);
		panel_5.setBounds(10, 212, 415, 470);
		PanelBienLai.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("MaHV");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(21, 34, 99, 41);
		panel_5.add(lblNewLabel_8);
		
		cbbNhapMaLHBL = new JComboBox();
		cbbNhapMaLHBL.setBounds(130, 110, 136, 23);
		panel_5.add(cbbNhapMaLHBL);
		
		txtHocPhiBL = new JTextField();
		txtHocPhiBL.setBounds(130, 174, 135, 22);
		panel_5.add(txtHocPhiBL);
		txtHocPhiBL.setColumns(10);
		
		JLabel lblNewLabel_8_1 = new JLabel("MaLH");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1.setBounds(21, 99, 99, 41);
		panel_5.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Học phí");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1_1.setBounds(21, 166, 99, 41);
		panel_5.add(lblNewLabel_8_1_1);
		
		btnInBienLai = new JButton("IN BIEN LAI");
		btnInBienLai.setForeground(Color.WHITE);
		btnInBienLai.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnInBienLai.setBackground(new Color(36, 0, 72));
		btnInBienLai.setBounds(100, 349, 196, 41);
		panel_5.add(btnInBienLai);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Hình thức thanh toán");
		lblNewLabel_8_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1_1_1.setBounds(117, 206, 179, 66);
		panel_5.add(lblNewLabel_8_1_1_1);
		
		cbbNhapHTTT = new JComboBox();
		cbbNhapHTTT.setModel(new DefaultComboBoxModel(new String[] {"ck", "tm"}));
		cbbNhapHTTT.setBounds(130, 282, 136, 23);
		panel_5.add(cbbNhapHTTT);
		
		txtNhapMaHVBL = new JTextField();
		txtNhapMaHVBL.setBounds(131, 47, 135, 23);
		panel_5.add(txtNhapMaHVBL);
		txtNhapMaHVBL.setColumns(10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(435, 212, 858, 388);
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
		lblNewLabel_11_1.setBounds(965, 627, 172, 39);
		PanelBienLai.add(lblNewLabel_11_1);
		
		lblSOLUONGHD = new JLabel("0");
		lblSOLUONGHD.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblSOLUONGHD.setBounds(607, 628, 91, 37);
		PanelBienLai.add(lblSOLUONGHD);
		
		lblTONGTIEN = new JLabel("0");
		lblTONGTIEN.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblTONGTIEN.setBounds(1117, 628, 91, 37);
		PanelBienLai.add(lblTONGTIEN);
		
		
		
    
	
	
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
	txtNhapMaHVBL.addActionListener(bl);
	btnTimKiemBL.addActionListener(bl);
	cbbNhapMaLHBL.addActionListener(bl);
	btnInBienLai.addActionListener(bl);
		
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
}
