package Model;

import java.sql.Date;

public class BienLai {
	
	public BienLai(String maHD, String maHV, String maLH, int hocPhi, Date ngayIn, String htThanhToan) {
		super();
		this.maHD = maHD;
		this.maHV = maHV;
		this.maLH = maLH;
		this.hocPhi = hocPhi;
		this.ngayIn = ngayIn;
		this.htThanhToan = htThanhToan;
	}
	
	private String maHD;
	private String maHV;
	private String maLH;
	private int hocPhi;
	private Date ngayIn;
	private String htThanhToan;
	
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaHV() {
		return maHV;
	}
	public void setMaHV(String maHV) {
		this.maHV = maHV;
	}
	public String getMaLH() {
		return maLH;
	}
	public void setMaLH(String maLH) {
		this.maLH = maLH;
	}
	public int getHocPhi() {
		return hocPhi;
	}
	public void setHocPhi(int hocPhi) {
		this.hocPhi = hocPhi;
	}
	public Date getNgayIn() {
		return ngayIn;
	}
	public void setNgayIn(Date ngayIn) {
		this.ngayIn = ngayIn;
	}
	public String getHtThanhToan() {
		return htThanhToan;
	}
	public void setHtThanhToan(String htThanhToan) {
		this.htThanhToan = htThanhToan;
	}
}
