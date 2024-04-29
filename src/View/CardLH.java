package View;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;

import DAO.DangKiDAO;
import DAO.LopHocDAO;
import Model.Hocvien;

import javax.swing.border.BevelBorder;
import java.awt.Color;

public class CardLH extends JPanel {

	private static final long serialVersionUID = 1L;
	public JLabel lable, lable_Name;
	public JButton btnXemTT;
	
	/**
	 * Create the panel.
	 */
	
	
	public CardLH(String idlh, String idhv) {
		setBackground(new Color(240, 248, 255));
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.setPreferredSize(new Dimension(182, 170));
		setLayout(null);
		
		
		lable = new JLabel();
		lable.setIcon(new ImageIcon(CardLH.class.getResource("/icon/icons8-study-64.png")));
		lable.setBounds(57, 11, 106, 93);
		add(lable);
		
		btnXemTT = new JButton("Xem");
		btnXemTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTLH ttlh = new TTLH(idlh);
			}
		});
		btnXemTT.setBounds(10, 114, 73, 26);
		add(btnXemTT);
		
		lable_Name = new JLabel();
		lable_Name.setBounds(47, 83, 93, 19);
		lable_Name.setText(LopHocDAO.getInstance().getNameLH(idlh));
		lable_Name.setHorizontalAlignment(SwingConstants.CENTER);
		add(lable_Name);
		
		JButton btnNewButton = new JButton("Xóa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangKiDAO.getInstance().delete(idhv, idlh);
			}
		});
		btnNewButton.setBounds(99, 114, 73, 26);
		add(btnNewButton);
		
		this.setVisible(true);
	}
	public static void main(String[] arg) {
		CardLH clh = new CardLH("100", "10001");
		clh.setVisible(true);
	}
}
