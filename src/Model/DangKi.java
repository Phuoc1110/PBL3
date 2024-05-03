package Model;

public class DangKi {
	private String maHV;
	private String maLH;
	private boolean thanhtoan;
	public DangKi(String maHV, String maLH, boolean thanhtoan) {
		super();
		this.maHV = maHV;
		this.maLH = maLH;
		this.thanhtoan = thanhtoan;
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
	
}
