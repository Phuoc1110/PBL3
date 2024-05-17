package Model;

public class NhanVien {
	private String id;
	private String Ten;
	private String matkhau;
	private int SDT;
	private String ngaysinh;
	private boolean gioitinh;
	
	public NhanVien(String id, String ten, String matkhau, int sDT, String ngaysinh, boolean gioitinh) {
		super();
		this.id = id;
		Ten = ten;
		this.matkhau = matkhau;
		SDT = sDT;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public boolean GetGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	
}
