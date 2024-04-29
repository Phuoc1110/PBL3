package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import DAO.DangKiDAO;
import DAO.LopHocDAO;
import Model.DangKi;

public class CardDKLH extends JPanel {

	private static final long serialVersionUID = 1L;
	public JLabel lable, lable_NameLH;
	public JButton btnXemTTLH;
	
	/**
	 * Create the panel.
	 */
	public CardDKLH(String idlh, String idhv) {
		setBackground(new Color(240, 248, 255));
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.setPreferredSize(new Dimension(182, 170));
		setLayout(null);
		
		
		lable = new JLabel();
		lable.setIcon(new ImageIcon(CardLH.class.getResource("/icon/icons8-study-64.png")));
		lable.setBounds(57, 11, 106, 93);
		add(lable);
		
		btnXemTTLH = new JButton("Xem");
		btnXemTTLH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTLH ttlh = new TTLH(idlh);
			}
		});
		btnXemTTLH.setBounds(10, 114, 73, 26);
		add(btnXemTTLH);
		
		lable_NameLH = new JLabel();
		lable_NameLH.setBounds(47, 83, 93, 19);
		lable_NameLH.setText(LopHocDAO.getInstance().getNameLH(idlh));
		lable_NameLH.setHorizontalAlignment(SwingConstants.CENTER);
		add(lable_NameLH);
		
		JButton btnNewButton = new JButton("ĐK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangKi dk = new DangKi(idhv, idlh);
				DangKiDAO.getInstance().insert(dk);
			}
		});
		btnNewButton.setBounds(99, 114, 73, 26);
		add(btnNewButton);
		
	}

}
