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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class nhap extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nhap frame = new nhap();
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
	public nhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 731);
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
		
		JButton btnBinLai = new JButton("Biên Lai");
		btnBinLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnBinLai.setForeground(Color.WHITE);
		btnBinLai.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnBinLai.setBackground(new Color(51, 0, 120));
		btnBinLai.setBounds(0, 0, 195, 56);
		panel_1_2.add(btnBinLai);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(36, 0, 72));
		panel_1_1_1.setBounds(0, 338, 195, 56);
		Menu.add(panel_1_1_1);
		
		JButton btnngXut = new JButton("Đăng xuất");
		btnngXut.setForeground(Color.WHITE);
		btnngXut.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnngXut.setBackground(new Color(36, 0, 72));
		btnngXut.setBounds(0, 0, 196, 56);
		panel_1_1_1.add(btnngXut);
		
		JPanel panel_6_1_1 = new JPanel();
		panel_6_1_1.setBackground(new Color(147, 0, 73));
		panel_6_1_1.setBounds(0, 675, 197, 33);
		Menu.add(panel_6_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Trung tâm dạy thêm");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(49, 79, 124, 13);
		Menu.add(lblNewLabel_1);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(72, 437, 101, 67);
		Menu.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon(nhap.class.getResource("/icon/437558866_1095808641646488_4149109965979641646_n.png")));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(193, 25, 678, 678);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(0, 0, 673, 95);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin cá nhân");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_2.setBounds(42, 35, 198, 27);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Chỉnh sửa thông tin");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3.setBounds(518, 56, 145, 16);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(135, 123, 191));
		panel_5.setBounds(0, 96, 673, 137);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("LÊ VĨNH TOÀN");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_4.setBounds(236, 59, 117, 26);
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(71, 271, 663, 419);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Tên đăng nhập");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(60, 45, 95, 20);
		panel_6.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Đơn vị:");
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(60, 87, 95, 20);
		panel_6.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Ngày sinh:");
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_5_2.setBounds(60, 135, 95, 20);
		panel_6.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Giới tính:");
		lblNewLabel_5_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_5_1_1.setBounds(60, 177, 95, 20);
		panel_6.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("Số điện thoại:");
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_5_3.setBounds(60, 226, 95, 20);
		panel_6.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_5_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_5_1_2.setBounds(60, 268, 95, 20);
		panel_6.add(lblNewLabel_5_1_2);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(228, 136, 336, 152);
		panel_6.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(new ImageIcon(nhap.class.getResource("/icon/pngtree-book-logo-classes-education-information-vector-png-image_26249126.png")));
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(0, 0, 673, 103);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Danh Sách Lớp Học");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(232, 35, 198, 27);
		panel_7.add(lblNewLabel_2_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBackground(Color.WHITE);
		panel_7_1.setBounds(0, 0, 673, 103);
		panel.add(panel_7_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Biên Lai");
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(279, 36, 198, 27);
		panel_7_1.add(lblNewLabel_2_1_1);
	}
}