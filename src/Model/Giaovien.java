package Model;

public class Giaovien {
	private String maGV;
	private String name;
	private String namSinh;
	private boolean gioiTinh;
	private String chuyenMon;
	private String trinhDo;
	private int SDT;
	
	public Giaovien() {
		super();
	}
	public Giaovien(String maGV, String name, String namSinh, boolean gioiTinh, String chuyenMon, String trinhDo,
			int sDT) {
		super();
		this.maGV = maGV;
		this.name = name;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.chuyenMon = chuyenMon;
		this.trinhDo = trinhDo;
		this.SDT = sDT;
	}
	
	@Override
	public String toString() {
		return "Giaovien [maGV=" + maGV + ", name=" + name + ", namSinh=" + namSinh + ", gioiTinh=" + gioiTinh
				+ ", chuyenMon=" + chuyenMon + ", trinhDo=" + trinhDo + ", SDT=" + SDT + "]";
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
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
	public String getChuyenMon() {
		return chuyenMon;
	}
	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}
	
	
}