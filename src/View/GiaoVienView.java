package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import view.MyCalculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import Controller.GiaoVienConTroler;
import Controller.GiaoVienViewConTroller;
import DAO.GiaovienDAO;
import DAO.LopHocDAO;
import Model.Giaovien;
import Model.Lophoc;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiaoVienView extends JFrame {

	

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTabbedPane tabbedPane;
	public JTextField txtMaGV;
	public JTextField txtMatKhau;
	public JTextField txtSDTGV;
	public JTextField txtChuyenMonGV;
	public JTextField txtTrinhDoGV;
	public JDateChooser dateGV;
	public JRadioButton rdbtMaleGV, rdbtFemaleGV;
	public JButton btnSuattGV, btnLuuGV;
	public String idgv;
	public JLabel lblSetName;
	public JTable tableLHGV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoVienView frame = new GiaoVienView("109");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GiaoVienView(String id) {
		this.idgv = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1329, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Menu = new JPanel();
		Menu.setLayout(null);
		Menu.setPreferredSize(new Dimension(150, 703));
		Menu.setBackground(new Color(36, 0, 72));
		Menu.setBounds(0, 0, 195, 703);
		contentPane.add(Menu);
		
		JLabel lblNewLabel = new JLabel("PTAN  ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Mincho Demibold", Font.BOLD, 33));
		lblNewLabel.setBounds(27, 44, 146, 49);
		Menu.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(27, 102, 146, 19);
		Menu.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 0, 102));
		panel_1.setBounds(0, 173, 195, 56);
		Menu.add(panel_1);
		
		JButton btnThngTinC = new JButton("Thông tin cá nhân");
		btnThngTinC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnThngTinC.setForeground(Color.WHITE);
		btnThngTinC.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThngTinC.setBackground(new Color(51, 0, 102));
		btnThngTinC.setBounds(0, 0, 195, 56);
		panel_1.add(btnThngTinC);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(36, 0, 72));
		panel_1_1.setBounds(0, 228, 195, 56);
		Menu.add(panel_1_1);
		
		JButton btnLpHc = new JButton("Lớp Học");
		btnLpHc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				ArrayList<Lophoc> list = LopHocDAO.getInstance().selectByCondition(id);
				DefaultTableModel model = (DefaultTableModel) tableLHGV.getModel();
				model.setRowCount(0);
				for(Lophoc lh : list) {		
					String[] row = {lh.getMaLH(), lh.getTenLH(), String.valueOf(lh.getSiSo()), lh.getThoigianHoc(), lh.getNgayBatDau(), lh.getNgayKetThuc(), lh.getMaMH(), String.valueOf(lh.getSoLuong()), String.valueOf(lh.getHocphi())};		
					model.addRow(row);
				}
			}
		});
		btnLpHc.setForeground(Color.WHITE);
		btnLpHc.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLpHc.setBackground(new Color(36, 0, 72));
		btnLpHc.setBounds(0, 0, 195, 56);
		panel_1_1.add(btnLpHc);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(51, 0, 102));
		panel_1_2.setBounds(0, 283, 195, 56);
		Menu.add(panel_1_2);
		
		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.setBounds(0, 0, 196, 56);
		panel_1_2.add(btnngXut);
		btnngXut.setForeground(Color.WHITE);
		btnngXut.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnngXut.setBackground(new Color(36, 0, 72));
		
		JPanel panel_6_1_1 = new JPanel();
		panel_6_1_1.setBackground(new Color(147, 0, 73));
		panel_6_1_1.setBounds(0, 675, 197, 33);
		Menu.add(panel_6_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Trung tâm dạy thêm");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(49, 79, 124, 13);
		Menu.add(lblNewLabel_1);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(193, 25, 1122, 703);
		contentPane.add(tabbedPane);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		tabbedPane.addTab("New tab", null, panel_3_1, null);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(0, 0, 950, 95);
		panel_3_1.add(panel_4_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Thông tin cá nhân");
		lblNewLabel_2_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
		lblNewLabel_2_2.setBounds(38, 21, 243, 50);
		panel_4_1.add(lblNewLabel_2_2);
		
		btnSuattGV = new JButton("SỬA THÔNG TIN CÁ NHÂN");
		btnSuattGV.setBounds(634, 21, 223, 36);
		panel_4_1.add(btnSuattGV);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBackground(new Color(135, 123, 191));
		panel_5_1.setBounds(0, 96, 950, 137);
		panel_3_1.add(panel_5_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(GiaoVienView.class.getResource("/icon/user (13).png")));
		lblNewLabel_4_1.setBounds(33, 10, 197, 117);
		panel_5_1.add(lblNewLabel_4_1);
		
		lblSetName = new JLabel((String) null);
		lblSetName.setForeground(Color.RED);
		lblSetName.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblSetName.setEnabled(false);
		lblSetName.setBounds(225, 35, 206, 47);
		panel_5_1.add(lblSetName);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(0, 233, 950, 419);
		panel_3_1.add(panel_6_1);
		
		JLabel lblNewLabel_5_4 = new JLabel("MaGV");
		lblNewLabel_5_4.setForeground(Color.GREEN);
		lblNewLabel_5_4.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_5_4.setBounds(148, 10, 111, 32);
		panel_6_1.add(lblNewLabel_5_4);
		
		txtMaGV = new JTextField();
		txtMaGV.setText((String) null);
		txtMaGV.setEnabled(false);
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(346, 10, 185, 42);
		panel_6_1.add(txtMaGV);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setText((String) null);
		txtMatKhau.setEditable(false);
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(346, 67, 185, 42);
		panel_6_1.add(txtMatKhau);
		
		txtSDTGV = new JTextField();
		txtSDTGV.setText((String) null);
		txtSDTGV.setEditable(false);
		txtSDTGV.setColumns(10);
		txtSDTGV.setBounds(346, 348, 185, 42);
		panel_6_1.add(txtSDTGV);
		
		JLabel lblNewLabel_5_1_3 = new JLabel("Mật Khẩu");
		lblNewLabel_5_1_3.setForeground(Color.GREEN);
		lblNewLabel_5_1_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_5_1_3.setBounds(148, 67, 111, 32);
		panel_6_1.add(lblNewLabel_5_1_3);
		
		JLabel lblNewLabel_5_4_1 = new JLabel("Ngày Sinh");
		lblNewLabel_5_4_1.setForeground(Color.GREEN);
		lblNewLabel_5_4_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_5_4_1.setBounds(148, 121, 111, 38);
		panel_6_1.add(lblNewLabel_5_4_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Giới Tính");
		lblNewLabel_5_2_1.setForeground(Color.GREEN);
		lblNewLabel_5_2_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_5_2_1.setBounds(148, 183, 140, 32);
		panel_6_1.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("SDT");
		lblNewLabel_5_3_1.setForeground(Color.GREEN);
		lblNewLabel_5_3_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_5_3_1.setBounds(148, 348, 140, 32);
		panel_6_1.add(lblNewLabel_5_3_1);
		
		rdbtMaleGV = new JRadioButton("Male");
		rdbtMaleGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtMaleGV.setEnabled(false);
		rdbtMaleGV.setBounds(346, 186, 103, 31);
		panel_6_1.add(rdbtMaleGV);
		
		rdbtFemaleGV = new JRadioButton("Female");
		rdbtFemaleGV.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtFemaleGV.setEnabled(false);
		rdbtFemaleGV.setBounds(470, 186, 103, 31);
		panel_6_1.add(rdbtFemaleGV);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtFemaleGV);
		group.add(rdbtMaleGV);
		
		btnLuuGV = new JButton("LƯU");
		btnLuuGV.setBounds(632, 358, 85, 21);
		panel_6_1.add(btnLuuGV);
		
		dateGV = new JDateChooser();
		dateGV.setEnabled(false);
		dateGV.setDateFormatString("dd/MM/yyyy");
		dateGV.setBounds(346, 122, 185, 37);
		panel_6_1.add(dateGV);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("Chuyên Môn");
		lblNewLabel_5_2_1_1.setForeground(Color.GREEN);
		lblNewLabel_5_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_5_2_1_1.setBounds(148, 240, 140, 32);
		panel_6_1.add(lblNewLabel_5_2_1_1);
		
		JLabel lblNewLabel_5_2_1_2 = new JLabel("Trình Độ");
		lblNewLabel_5_2_1_2.setForeground(Color.GREEN);
		lblNewLabel_5_2_1_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_5_2_1_2.setBounds(148, 296, 140, 32);
		panel_6_1.add(lblNewLabel_5_2_1_2);
		
		txtChuyenMonGV = new JTextField();
		txtChuyenMonGV.setText((String) null);
		txtChuyenMonGV.setEditable(false);
		txtChuyenMonGV.setColumns(10);
		txtChuyenMonGV.setBounds(346, 230, 185, 42);
		panel_6_1.add(txtChuyenMonGV);
		
		txtTrinhDoGV = new JTextField();
		txtTrinhDoGV.setText((String) null);
		txtTrinhDoGV.setEditable(false);
		txtTrinhDoGV.setColumns(10);
		txtTrinhDoGV.setBounds(346, 286, 185, 42);
		panel_6_1.add(txtTrinhDoGV);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(0, 0, 1107, 103);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Danh Sách Lớp Học");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(452, 35, 198, 27);
		panel_7.add(lblNewLabel_2_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 113, 1097, 553);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 45, 1024, 456);
		panel_3.add(scrollPane);
		
		tableLHGV = new JTable();
		scrollPane.setViewportView(tableLHGV);
		tableLHGV.setModel(new DefaultTableModel(
			    new Object[][] {},
			    new String[] {
			        "maLH", "tenLop", "siSo", "thoiGianHoc", "ngayBatDau", "ngayKetThuc", "maMH", "soLuong", "hocphi"
			    }
			) {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        return false; // Make all cells uneditable
			    }
			});
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBackground(Color.WHITE);
		panel_7_1.setBounds(0, 0, 673, 103);
		panel.add(panel_7_1);
		
		setTTCoBan(id);
		
		
		ActionListener acgv = new GiaoVienViewConTroller(this);
		btnSuattGV.addActionListener(acgv);
		btnLuuGV.addActionListener(acgv);
		
		MouseListener mlgv = new GiaoVienViewConTroller(this);
		tableLHGV.addMouseListener(mlgv);
		
		this.setVisible(true);
	}
	
	public void setTTCoBan(String id) {
		Giaovien gv = GiaovienDAO.getInstance().selectById(id);
		System.out.println(gv.toString());
		lblSetName.setText(gv.getName());
		txtMaGV.setText(gv.getMaGV());
//		txtMatKhau.setText(gv.getMatKhau());
		txtChuyenMonGV.setText(gv.getChuyenMon());
		if(gv.getGioiTinh() == true) {
			rdbtMaleGV.setSelected(true);
		}
		else {
			rdbtFemaleGV.setSelected(true);
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date;
		try {
			date = dateFormat.parse(gv.getNamSinh());
			dateGV.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtSDTGV.setText(Integer.toString(gv.getSDT()));
		txtTrinhDoGV.setText(gv.getTrinhDo());
	}
//	
//	public Giaovien getThongTinGV() {
//		String maGV = txtMaGV.getText();
//		String tenGV = lblSetName.getText();
//		String matkhau = txtMatKhau.getText();
//		boolean gioitinh = false;
//		if(rdbtMaleGV.isSelected()) {
//			gioitinh = true;
//		}
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		String namsinh = dateFormat.format(dateGV.getDate());
//		int sdt = Integer.parseInt(txtSDTGV.getText());
//		String chuyenmon = txtChuyenMonGV.getText();
//		String trinhdo = txtTrinhDoGV.getText();
//		Giaovien gv = new Giaovien(maGV, tenGV, namsinh, gioitinh, chuyenmon, trinhdo, sdt, matkhau);
//		return gv;
//	}
	
	public void setNotEnable() {
		lblSetName.setEnabled(false);
		txtMaGV.setEnabled(false);
		txtChuyenMonGV.setEditable(false);
		rdbtFemaleGV.setEnabled(false);
		rdbtMaleGV.setEnabled(false);
		txtMatKhau.setEditable(false);
		dateGV.setEnabled(false);
		txtSDTGV.setEditable(false);
		txtTrinhDoGV.setEditable(false);
	}
	
	public void setEnable() {
		lblSetName.setEnabled(true);
		txtChuyenMonGV.setEditable(true);
		rdbtFemaleGV.setEnabled(true);
		rdbtMaleGV.setEnabled(true);
		txtMatKhau.setEditable(true);
		dateGV.setEnabled(true);
		txtSDTGV.setEditable(true);
		txtTrinhDoGV.setEditable(true);
	}
}