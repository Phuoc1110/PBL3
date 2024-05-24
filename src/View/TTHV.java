package View;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.DangKiDAO;
import DAO.HocvienDAO;
import Database.JDBCUtil;

import java.awt.event.ActionEvent;


public class TTHV extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public String maLH = "", tenLH = "";
	public int hocPhi = 0;
	public JTable table;
	public JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TTHV dialog = new TTHV();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TTHV() {
		setBounds(100, 100, 751, 452);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Thông Tin Học Sinh");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel.setBounds(292, 30, 158, 22);
			contentPanel.add(lblNewLabel);
		}
		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(61, 103, 603, 213);
//		contentPanel.add(scrollPane);
//		{
//			table = new JTable();
//			table.setModel(new DefaultTableModel(
//				new Object[][] {
//				},
//				new String[] {
//					"M\u00E3 H\u1ECDc Vi\u00EAn", "H\u1ECD T\u00EAn", "N\u0103m Sinh", "Gi\u1EDBi T\u00EDnh", "S\u0110T", "T\u00ECnh Tr\u1EA1ng", "Thanh Toán"
//				}
//			));
//			scrollPane.setViewportView(table);
//		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 103, 603, 213);
		contentPanel.add(scrollPane);

		DefaultTableModel model = new DefaultTableModel(
		    new Object[][] {},
		    new String[] {
		        "Mã Học Viên", "Họ Tên", "Năm Sinh", "Giới Tính", "SĐT", "Tình Trạng", "Thanh Toán"
		    }
		) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; 
		    }
		};

		table = new JTable(model);
		scrollPane.setViewportView(table);

		
		JButton btnXoaTTHV = new JButton("Delete");
		btnXoaTTHV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maHV = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				System.out.println(maHV);
				try {
					Connection cnn = JDBCUtil.getConnection();
					
					java.sql.Statement st = cnn.createStatement();
					
					String sql = "DELETE from dangki\r\n"
							+ "where maHV = '" + maHV + "';";
					System.out.println(sql);
					
					int ketqua = st.executeUpdate(sql);
					((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
					JDBCUtil.closeConnection(cnn);
					
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		btnXoaTTHV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoaTTHV.setBounds(168, 358, 127, 30);
		contentPanel.add(btnXoaTTHV);
		
		JButton btnInBienLai = new JButton("In biên lai");
		btnInBienLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String trangThaiTT = table.getModel().getValueAt(table.getSelectedRow(), 6).toString();
				if (trangThaiTT.equals("0")) {
					JOptionPane.showMessageDialog(null, "Học viên này vẫn chưa thanh toán!");
					return;
				}
				try {
					
					String fName = table.getModel().getValueAt(table.getSelectedRow(), 0).toString() + "_" + maLH;
					String file = "D:\\pdf_files\\" + fName + ".pdf"; //Vi tri in file
					String tenHV = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
					String maHV = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
					LocalDate currentDate = LocalDate.now();
					
					Document doc = new Document();
					PdfWriter.getInstance(doc, new FileOutputStream(file));
					
					doc.open();
					
					String s = "TRUNG TAM HOC THEM thong bao gui Hoa Don ban hang cho quy khach.\n\n"
							+ "Kinh gui: Quy khach " + tenHV + ".\n"
							+ "TRUNG TAM HOC THEM xin gui cho Quy khach Hoa đon ban hang voi cac thong tin nhu sau. \n\n"
							+ "               + Ma Hoc Vien: " + maHV + ";\n"
							+ "               + Date: " + currentDate + ";\n"
							+ "               + Lop Hoc Them: " + tenLH + " - " + maLH + ";\n\n"
							+ "De tra cuu them thong tin quy khach vui long lien lac qua SDT: 0335435578.\n"
							+ "Hoac gui lien lac trung tam qua email: TTHT@gmail.com.\n\n"
							+ "                                                        Tran Trong Quy Khach";
					
					Paragraph para = new Paragraph(s);
					doc.add(para);
					
					doc.close();
					
					if (Desktop.isDesktopSupported()) {
					    try {
					        File myFile = new File(file);
					        Desktop.getDesktop().open(myFile);
					    } catch (IOException ex) {
					    }
					}
					
					JOptionPane.showMessageDialog(null, "Đã tạo biên lai thành công!");
					System.out.println("Finished");
					
					
				} catch (FileNotFoundException e1) {
					System.err.println(e1);
				} catch (DocumentException e1) {
					System.err.println(e1);
				}
			}
		});
		btnInBienLai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInBienLai.setBounds(425, 358, 127, 30);
		contentPanel.add(btnInBienLai);
		
		MouseListener ml = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
			        // Show an input dialog and capture user input
					
//			        String name = JOptionPane.showInputDialog("Enter your name:");
//			        JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
					String trangThaiTT = table.getModel().getValueAt(table.getSelectedRow(), 6).toString();
					if (trangThaiTT.equals("1")) {
						JOptionPane.showMessageDialog(null, "Học viên đã thanh toán rồi!");
						return;
					}
					
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			        
			        // Show a confirm dialog
			        int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn thực hiện thanh toán không?");
			        
			        //THUC HIEN THANH TOAN
			        if (option == JOptionPane.YES_OPTION) {
			        	//Code thanh toan
			        	
			        	int column = 0;
			        	int row = table.getSelectedRow();
			        	
			        	String maHV = (String) table.getValueAt(row, column);
			        	DangKiDAO.getInstance().setDaThanhToan(maLH, maHV);
			        	table.setValueAt("1", table.getSelectedRow(), 6);
			        	
			            JOptionPane.showMessageDialog(null, "Đã thanh toán thành công!");
			        }
			        //KHONG THTT
			        else {
			            JOptionPane.showMessageDialog(null, "Đã hủy thanh toán!");
			        }

				}
			}
		};
		table.addMouseListener(ml);
		
		
	}
	
}