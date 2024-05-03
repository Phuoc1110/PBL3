package Model;

public class Hocvien {
	
	public Hocvien(String maHV, String name, String namSinh, boolean gioiTinh, String sdt, String tinhTrang, String matKhau) {
		super();
		this.maHV = maHV;
		this.name = name;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.tinhTrang = tinhTrang;
		this.matKhau = matKhau;
	}
	
	public Hocvien() {
		super();
	}
	private String maHV;
	private String name;
	private String namSinh;
	private boolean gioiTinh;
	private String sdt;
	private String tinhTrang;
	private String matKhau;
	
	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	//Getter setter
	public String getMaHV() {
		return maHV;
	}

	public void setMaHV(String maHV) {
		this.maHV = maHV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	
}
