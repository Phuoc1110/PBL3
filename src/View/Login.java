package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import DAO.GiaovienDAO;
import DAO.HocvienDAO;
import Model.Giaovien;
import Model.Hocvien;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPasswordField txtPassword;
	public JTextField txtUser;
	public JButton btnDangNhapAdmin;

	
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(37, 0, 74));
		panel_2.setBounds(343, 0, 354, 459);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME PTAN!");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(98, 73, 197, 45);
		panel_2.add(lblNewLabel);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(48, 244, 237, 28);
		  
		panel_2.add(txtPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(48, 219, 93, 13);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("User");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(48, 145, 93, 13);
		panel_2.add(lblNewLabel_1_1_1);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(48, 170, 237, 28);
		panel_2.add(txtUser);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/icon/437558866_1095808641646488_4149109965979641646_n.png")));
		lblNewLabel_4.setBounds(10, 404, 60, 45);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("E:\\download\\clover-alt (2).png"));
		lblNewLabel_5.setBounds(271, 86, 33, 32);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/icon/check-mark (3).png")));
		lblNewLabel_2.setBounds(116, 30, 93, 28);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("LOGIN");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setForeground(Color.YELLOW);
		lblNewLabel_6.setBounds(144, 290, 105, 28);
		panel_2.add(lblNewLabel_6);
		
		btnDangNhapAdmin = new JButton("ADMIN");
		btnDangNhapAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUser.getText().equals("admin") && txtPassword.getText().equals("1")) {
					new AdminView();
					
				}
			}
		});
		btnDangNhapAdmin.setBounds(47, 328, 94, 32);
		panel_2.add(btnDangNhapAdmin);
		
		JButton btnNhnVin = new JButton("Nhân Viên");
		btnNhnVin.setBounds(210, 328, 94, 32);
		panel_2.add(btnNhnVin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 224, 224));
		panel_1.setBounds(0, 0, 348, 459);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/icon/4cbe9a4960afcef197be.jpg")));
		lblNewLabel_1.setBounds(40, 71, 269, 324);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/icon/17a9b7464da0e3febab1.jpg")));
		lblNewLabel_3.setBounds(0, 0, 43, 41);
		panel_1.add(lblNewLabel_3);
		
		this.setVisible(true);
	}
	
}
