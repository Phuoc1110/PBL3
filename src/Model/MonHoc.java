package Model;

public class MonHoc {
	public MonHoc(String maMH, String tenMon) {
		super();
		this.maMH = maMH;
		this.tenMon = tenMon;
	}
	private String maMH;
	private String tenMon;
	
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	@Override
	public String toString() {
		return "MonHoc [maMH=" + maMH + ", tenMon=" + tenMon + "]";
	}
}
