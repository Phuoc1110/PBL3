package View;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.LopHocDAO;
import Model.Lophoc;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class tam extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tam frame = new tam();
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
	public tam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(82, 55, 659, 545);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
		
		ArrayList<Lophoc> list = LopHocDAO.getInstance().selectAll();
		ArrayList<String> listname = new ArrayList<String>();
		for(Lophoc lh : list) {
			listname.add(lh.getMaLH());
		}
		for (String classCode : listname) {
            panel.add(new CardLH(classCode));
        }
		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(tam.class.getResource("/icon/icons8-study-64.png")));
//		lblNewLabel.setBounds(55, 10, 104, 100);
//		panel_1.add(lblNewLabel);
//		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(0, 132, 85, 21);
//		panel_1.add(btnNewButton);
	}
	
	
	
}
