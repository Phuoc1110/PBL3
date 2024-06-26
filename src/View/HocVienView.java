//package View ;
//
//import java.awt.EventQueue;
//import java.awt.FlowLayout;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import Controller.HocVienViewConTroller;
//import DAO.BienLaiDAO;
//import DAO.DangKiDAO;
//import DAO.HocvienDAO;
//import DAO.LopHocDAO;
//import Model.BienLai;
//import Model.Hocvien;
//import Model.Lophoc;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import javax.swing.JLabel;
//import java.awt.Font;
//import javax.swing.JSeparator;
//import javax.swing.JButton;
//import javax.swing.JTabbedPane;
//import java.awt.event.ActionListener;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.awt.event.ActionEvent;
//
//import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
//import javax.swing.JTextField;
//import javax.swing.JRadioButton;
//import com.toedter.calendar.JDateChooser;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JScrollPane;
//
//public class HocVienView extends JFrame {
//	
//
//	public static final long serialVersionUID = 1L;
//	public JPanel contentPane, panelDSLH, panelChenLH, panelChenDSCDK, panelDSCDK;
//	public JTabbedPane tabbedPane;
//	public JTextField txtSetMaHV;
//	public JTextField txtSetMKHV;
//	public JTextField txtSetSDTHV;
//	public JLabel lblSetName;
//	public JRadioButton rdbtMaleHV, rdbtFemaleHV;
//	public JButton btnSuattHV, btnLuuHV, btnLpHc;
//	public JDateChooser dateHVView;
//	public String idhv;
//	private JTable table;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] arg) {
//		HocVienView hvv = new HocVienView("10001");
//	}
//
//
//	/**
//	 * Create the frame.
//	 */
//	public HocVienView(String id) {
//		idhv = id;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1215, 733);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JPanel Menu = new JPanel();
//		Menu.setLayout(null);
//		Menu.setPreferredSize(new Dimension(150, 703));
//		Menu.setBackground(new Color(36, 0, 72));
//		Menu.setBounds(0, 0, 195, 703);
//		contentPane.add(Menu);
//		
//		JLabel lblNewLabel = new JLabel("PTAN  ");
//		lblNewLabel.setForeground(Color.WHITE);
//		lblNewLabel.setFont(new Font("Yu Mincho Demibold", Font.BOLD, 33));
//		lblNewLabel.setBounds(27, 44, 146, 49);
//		Menu.add(lblNewLabel);
//		
//		JSeparator separator = new JSeparator();
//		separator.setForeground(Color.WHITE);
//		separator.setBackground(Color.WHITE);
//		separator.setBounds(27, 102, 146, 19);
//		Menu.add(separator);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setLayout(null);
//		panel_1.setBackground(new Color(51, 0, 102));
//		panel_1.setBounds(0, 173, 195, 56);
//		Menu.add(panel_1);
//		
//		JButton btnThngTinC = new JButton("Thông tin cá nhân");
//		btnThngTinC.setIcon(new ImageIcon(HocVienView.class.getResource("/icon/user (11).png")));
//		btnThngTinC.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				tabbedPane.setSelectedIndex(0);
//			}
//		});
//		btnThngTinC.setForeground(Color.WHITE);
//		btnThngTinC.setFont(new Font("Segoe UI", Font.BOLD, 15));
//		btnThngTinC.setBackground(new Color(51, 0, 102));
//		btnThngTinC.setBounds(0, 0, 195, 56);
//		panel_1.add(btnThngTinC);
//		
//		JPanel panel_1_1 = new JPanel();
//		panel_1_1.setLayout(null);
//		panel_1_1.setBackground(new Color(36, 0, 72));
//		panel_1_1.setBounds(0, 228, 195, 56);
//		Menu.add(panel_1_1);
//		
//		btnLpHc = new JButton("Lớp Học");
//		btnLpHc.setIcon(new ImageIcon(HocVienView.class.getResource("/icon/presentation.png")));
//		btnLpHc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				tabbedPane.setSelectedIndex(1);
//				setCardLH();
//			}
//		});
//		btnLpHc.setForeground(Color.WHITE);
//		btnLpHc.setFont(new Font("Segoe UI", Font.BOLD, 15));
//		btnLpHc.setBackground(new Color(36, 0, 72));
//		btnLpHc.setBounds(0, 0, 195, 56);
//		panel_1_1.add(btnLpHc);
//		
//		JPanel panel_1_2 = new JPanel();
//		panel_1_2.setLayout(null);
//		panel_1_2.setBackground(new Color(51, 0, 102));
//		panel_1_2.setBounds(0, 283, 195, 56);
//		Menu.add(panel_1_2);
//		
//		JButton btnBinLai = new JButton("Đăng Kí Môn Học");
//		btnBinLai.setIcon(new ImageIcon(HocVienView.class.getResource("/icon/knowledge.png")));
//		btnBinLai.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				tabbedPane.setSelectedIndex(2);
//				setCardCDK();
//			}
//		});
//		btnBinLai.setForeground(Color.WHITE);
//		btnBinLai.setFont(new Font("Segoe UI", Font.BOLD, 15));
//		btnBinLai.setBackground(new Color(51, 0, 120));
//		btnBinLai.setBounds(0, 0, 195, 56);
//		panel_1_2.add(btnBinLai);
//		
//		JPanel panel_1_1_1 = new JPanel();
//		panel_1_1_1.setLayout(null);
//		panel_1_1_1.setBackground(new Color(36, 0, 72));
//		panel_1_1_1.setBounds(0, 338, 195, 56);
//		Menu.add(panel_1_1_1);
//		
//		JButton btnngXut = new JButton("Biên Lai");
//		btnngXut.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				tabbedPane.setSelectedIndex(3);
//				DefaultTableModel model = (DefaultTableModel) table.getModel();
//				model.setRowCount(0);
//				ArrayList<BienLai> list = BienLaiDAO.getInstance().setBienLaiforHV(id);
//				for (BienLai b : list) {
//					String[] s = {b.getMaHD(), b.getMaHV(), b.getMaLH(), Integer.toString(b.getHocPhi()), b.getNgayIn().toString(), b.getHtThanhToan()};
//					model.addRow(s);
//				}
//			}
//		});
//		btnngXut.setIcon(new ImageIcon(HocVienView.class.getResource("/icon/receipt.png")));
//		btnngXut.setForeground(Color.WHITE);
//		btnngXut.setFont(new Font("Segoe UI", Font.BOLD, 15));
//		btnngXut.setBackground(new Color(36, 0, 72));
//		btnngXut.setBounds(0, 0, 196, 56);
//		panel_1_1_1.add(btnngXut);
//		
//		JPanel panel_6_1_1 = new JPanel();
//		panel_6_1_1.setBackground(new Color(147, 0, 73));
//		panel_6_1_1.setBounds(0, 675, 197, 33);
//		Menu.add(panel_6_1_1);
//		
//		JLabel lblNewLabel_1 = new JLabel("Trung tâm dạy thêm");
//		lblNewLabel_1.setForeground(Color.WHITE);
//		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//		lblNewLabel_1.setBounds(49, 79, 124, 13);
//		Menu.add(lblNewLabel_1);
//		
//		JButton btnngXut_1 = new JButton("Đăng xuất");
//		btnngXut_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				out();
//			}
//		});
//		btnngXut_1.setIcon(new ImageIcon(HocVienView.class.getResource("/icon/logout (1).png")));
//		btnngXut_1.setForeground(Color.WHITE);
//		btnngXut_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
//		btnngXut_1.setBackground(new Color(51, 0, 120));
//		btnngXut_1.setBounds(0, 393, 195, 56);
//		Menu.add(btnngXut_1);
//		
//		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setBounds(193, 10, 1017, 693);
//		contentPane.add(tabbedPane);
//		
//		JPanel panel_3 = new JPanel();
//		tabbedPane.addTab("New tab", null, panel_3, null);
//		panel_3.setLayout(null);
//		
//		JPanel panel_4 = new JPanel();
//		panel_4.setBackground(new Color(255, 255, 255));
//		panel_4.setBounds(0, 0, 1002, 95);
//		panel_3.add(panel_4);
//		panel_4.setLayout(null);
//		
//		JLabel lblNewLabel_2 = new JLabel("Thông tin cá nhân");
//		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
//		lblNewLabel_2.setBounds(38, 21, 243, 50);
//		panel_4.add(lblNewLabel_2);
//		
//		btnSuattHV = new JButton("SỬA THÔNG TIN CÁ NHÂN");
//		btnSuattHV.setBounds(634, 21, 223, 36);
//		panel_4.add(btnSuattHV);
//		
//		JPanel panel_5 = new JPanel();
//		panel_5.setBackground(new Color(135, 123, 191));
//		panel_5.setBounds(0, 96, 1002, 137);
//		panel_3.add(panel_5);
//		panel_5.setLayout(null);
//		
//		JLabel lblNewLabel_4 = new JLabel("");
//		lblNewLabel_4.setIcon(new ImageIcon(HocVienView.class.getResource("/icon/user (13).png")));
//		lblNewLabel_4.setBounds(33, 10, 197, 117);
//		panel_5.add(lblNewLabel_4);
//		
//		lblSetName = new JLabel("Tên");
//		lblSetName.setBounds(278, 29, 206, 47);
//		panel_5.add(lblSetName);
//		lblSetName.setForeground(new Color(255, 0, 0));
//		lblSetName.setFont(new Font("Segoe UI", Font.BOLD, 24));
//		
//		JPanel panel_6 = new JPanel();
//		panel_6.setBackground(new Color(255, 255, 255));
//		panel_6.setBounds(0, 232, 1002, 419);
//		panel_3.add(panel_6);
//		panel_6.setLayout(null);
//		
//		JLabel lblNewLabel_5 = new JLabel("MaHV");
//		lblNewLabel_5.setForeground(Color.GREEN);
//		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 18));
//		lblNewLabel_5.setBounds(148, 45, 111, 32);
//		panel_6.add(lblNewLabel_5);
//		
//		txtSetMaHV = new JTextField();
//		txtSetMaHV.setBounds(346, 34, 185, 42);
//		panel_6.add(txtSetMaHV);
//		txtSetMaHV.setColumns(10);
//		
//		txtSetMKHV = new JTextField();
//		txtSetMKHV.setColumns(10);
//		txtSetMKHV.setBounds(346, 95, 185, 42);
//		panel_6.add(txtSetMKHV);
//		
//		txtSetSDTHV = new JTextField();
//		txtSetSDTHV.setColumns(10);
//		txtSetSDTHV.setBounds(346, 275, 185, 42);
//		panel_6.add(txtSetSDTHV);
//		
//		JLabel lblNewLabel_5_1 = new JLabel("Mật Khẩu");
//		lblNewLabel_5_1.setForeground(Color.GREEN);
//		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
//		lblNewLabel_5_1.setBounds(148, 107, 111, 32);
//		panel_6.add(lblNewLabel_5_1);
//		
//		JLabel lblNewLabel_5_4 = new JLabel("Ngày Sinh");
//		lblNewLabel_5_4.setForeground(Color.GREEN);
//		lblNewLabel_5_4.setFont(new Font("Segoe UI", Font.BOLD, 18));
//		lblNewLabel_5_4.setBounds(148, 164, 111, 38);
//		panel_6.add(lblNewLabel_5_4);
//		
//		JLabel lblNewLabel_5_2 = new JLabel("Giới Tính");
//		lblNewLabel_5_2.setForeground(Color.GREEN);
//		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
//		lblNewLabel_5_2.setBounds(148, 229, 140, 32);
//		panel_6.add(lblNewLabel_5_2);
//		
//		JLabel lblNewLabel_5_3 = new JLabel("SDT");
//		lblNewLabel_5_3.setForeground(Color.GREEN);
//		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
//		lblNewLabel_5_3.setBounds(148, 287, 140, 32);
//		panel_6.add(lblNewLabel_5_3);
//		
//		
//		
//		rdbtMaleHV = new JRadioButton("Male");
//		rdbtMaleHV.setFont(new Font("Tahoma", Font.BOLD, 14));
//		rdbtMaleHV.setBounds(342, 229, 103, 31);
//		panel_6.add(rdbtMaleHV);
//		
//		rdbtFemaleHV = new JRadioButton("Female");
//		rdbtFemaleHV.setFont(new Font("Tahoma", Font.BOLD, 14));
//		rdbtFemaleHV.setBounds(469, 229, 103, 31);
//		panel_6.add(rdbtFemaleHV);
//		
//		ButtonGroup group = new ButtonGroup();
//		group.add(rdbtFemaleHV);
//		group.add(rdbtMaleHV);
//		
//		btnLuuHV = new JButton("LƯU");
//		btnLuuHV.setBounds(377, 353, 85, 21);
//		panel_6.add(btnLuuHV);
//		
//		dateHVView = new JDateChooser();
//		dateHVView.setDateFormatString("dd/MM/yyyy");
//		dateHVView.setBounds(346, 165, 185, 37);
//		panel_6.add(dateHVView);
//		
//		panelChenLH = new JPanel();
//		tabbedPane.addTab("New tab", null, panelChenLH, null);
//		panelChenLH.setLayout(null);
//		
//		JPanel panel_7 = new JPanel();
//		panel_7.setBounds(0, 0, 1002, 149);
//		panel_7.setBackground(new Color(255, 255, 255));
//		panelChenLH.add(panel_7);
//		panel_7.setLayout(null);
//		
//		JLabel lblNewLabel_2_1 = new JLabel("Danh Sách Lớp Học Đã Đăng Kí");
//		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
//		lblNewLabel_2_1.setBounds(331, 36, 321, 27);
//		panel_7.add(lblNewLabel_2_1);
//		
//		panelDSLH = new JPanel();
//		panelDSLH.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
//		panelDSLH.setBounds(10, 144, 990, 484);
////		setCardLH();
////		ArrayList<String> list = DangKiDAO.getInstance().getAllLopTheoTungHV(id);
////		ArrayList<String> listname = new ArrayList<String>();
////		for(String lh : list) {
////			listname.add(lh);
////		}
////		for (String classCode : listname) {
////            panelDSLH.add(new CardLH(classCode, id));
////        }
//		
//		panelChenLH.add(panelDSLH);
//		
//		panelChenDSCDK = new JPanel();
//		tabbedPane.addTab("New tab", null, panelChenDSCDK, null);
//		panelChenDSCDK.setLayout(null);
//		
//		JPanel panel_7_1_1 = new JPanel();
//		panel_7_1_1.setLayout(null);
//		panel_7_1_1.setBackground(Color.WHITE);
//		panel_7_1_1.setBounds(0, 0, 1002, 103);
//		panelChenDSCDK.add(panel_7_1_1);
//		
//		JLabel lblNewLabel_2_1_1_1 = new JLabel("DANH SÁCH LỚP HỌC");
//		lblNewLabel_2_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
//		lblNewLabel_2_1_1_1.setBounds(402, 37, 198, 27);
//		panel_7_1_1.add(lblNewLabel_2_1_1_1);
//		
//		panelDSCDK = new JPanel();
//		panelDSCDK.setBounds(10, 113, 992, 530);
//		
////		ArrayList<String> listcdk = DangKiDAO.getInstance().getLopKhongDK(id);
////		ArrayList<String> listnamecdk = new ArrayList<String>();
////		for(String lh : listcdk) {
////			listnamecdk.add(lh);
////		}
////		for (String classCode : listnamecdk) {
////            panelDSCDK.add(new CardDKLH(classCode, id));
////        }
//		panelChenDSCDK.add(panelDSCDK);
//		
//		JPanel panel = new JPanel();
//		tabbedPane.addTab("New tab", null, panel, null);
//		panel.setLayout(null);
//		
//		JPanel panel_7_1 = new JPanel();
//		panel_7_1.setLayout(null);
//		panel_7_1.setBackground(Color.WHITE);
//		panel_7_1.setBounds(0, 0, 1002, 119);
//		panel.add(panel_7_1);
//		
//		JLabel lblNewLabel_2_1_1 = new JLabel("Biên Lai");
//		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
//		lblNewLabel_2_1_1.setBounds(462, 35, 198, 27);
//		panel_7_1.add(lblNewLabel_2_1_1);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(26, 165, 959, 445);
//		panel.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"MaHD", "maHV", "maLH", "hocphi", "ngayIn", "htThanhtoan"
//			}
//		));
//		setThongTinCoBan(id);
//		setNotEnable();
//		
//		ActionListener achv = new HocVienViewConTroller(this);
//		btnSuattHV.addActionListener(achv);
//		btnLuuHV.addActionListener(achv);
//		
//		this.setVisible(true);
//		
//		
//	}
//	public void setThongTinCoBan(String id) {
//		Hocvien hv = HocvienDAO.getInstance().selectById(id);
//		lblSetName.setText(hv.getName());
//		txtSetMaHV.setText(hv.getMaHV());
//		txtSetMKHV.setText(hv.getMatKhau());
//		if(hv.getGioiTinh()) {
//			rdbtMaleHV.setSelected(true);
//		}
//		else {
//			rdbtFemaleHV.setSelected(false);
//		}
//		txtSetSDTHV.setText(hv.getMaHV());
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		java.util.Date date;
//		try {
//			date = dateFormat.parse(hv.getNamSinh());
//			dateHVView.setDate(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public Hocvien getThongTinHV() {
//		
//		String maHV = txtSetMaHV.getText();
//		String tenHV = lblSetName.getText();
//		String matkhau = txtSetMKHV.getText();
//		boolean gioitinh = false;
//		if(rdbtMaleHV.isSelected()) {
//			gioitinh = true;
//		}
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		String namSinh = dateFormat.format(dateHVView.getDate());
//		String SDT = txtSetSDTHV.getText();
//		Hocvien hv = new Hocvien(maHV, tenHV, namSinh, gioitinh, SDT, "active", matkhau);
//		return hv;
//	}
//	public void setNotEnable() {
//		lblSetName.setEnabled(false);
//		txtSetMaHV.setEnabled(false);
//		txtSetMKHV.setEditable(false);
//		rdbtFemaleHV.setEnabled(false);
//		rdbtMaleHV.setEnabled(false);
//		txtSetSDTHV.setEditable(false);
//		dateHVView.setEnabled(false);
//	}
//	public void setEnable() {
//		lblSetName.setEnabled(true);
//		txtSetMKHV.setEditable(true);
//		rdbtFemaleHV.setEnabled(true);
//		rdbtMaleHV.setEnabled(true);
//		dateHVView.setEnabled(true);
//		txtSetSDTHV.setEditable(true);
//	}
//	public void setCardLH() {
//		panelDSLH.removeAll();
//		ArrayList<String> list = DangKiDAO.getInstance().getAllLopTheoTungHV(idhv);
//		ArrayList<String> listname = new ArrayList<String>();
//		for(String lh : list) {
//			listname.add(lh);
//		}
//		for (String classCode : listname) {
//            panelDSLH.add(new CardLH(classCode, idhv));
//        }
//		panelChenLH.add(panelDSLH);
//	}
//	public void setCardCDK() {
//		panelDSCDK.removeAll();
//		ArrayList<String> listcdk = DangKiDAO.getInstance().getLopKhongDK(idhv);
//		ArrayList<String> listnamecdk = new ArrayList<String>();
//		for(String lh : listcdk) {
//			listnamecdk.add(lh);
//		}
//		for (String classCode : listnamecdk) {
//            panelDSCDK.add(new CardDKLH(classCode, idhv));
//        }
//		panelChenDSCDK.add(panelDSCDK);
//	}
//	public void out() {
//		this.dispose();
//	}
//}