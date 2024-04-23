package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Lophoc {
	private String maLH;
	private String tenLH;
	private int siSo;
	private String thoigianHoc;
	private String ngayBatDau;
	private String ngayKetThuc;
	private String maMH;
	private String maGV;
	
	
	public Lophoc(String maLH, String tenLH, int siSo, String thoigianHoc, String ngayBatDau, String ngayKetThuc,
			String maMH, String maGV) {
		super();
		this.maLH = maLH;
		this.tenLH = tenLH;
		this.siSo = siSo;
		this.thoigianHoc = thoigianHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.maMH = maMH;
		this.maGV = maGV;
	}
	
	@Override
	public String toString() {
		return "Lophoc [maLH=" + maLH + ", tenLH=" + tenLH + ", siSo=" + siSo + ", thoigianHoc=" + thoigianHoc
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", maMH=" + maMH + ", maGV=" + maGV
				+ "]";
	}

	public String getMaLH() {
		return maLH;
	}
	public void setMaLH(String maLH) {
		this.maLH = maLH;
	}
	public String getTenLH() {
		return tenLH;
	}
	public void setTenLH(String tenLH) {
		this.tenLH = tenLH;
	}
	public int getSiSo() {
		return siSo;
	}
	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}
	public String getThoigianHoc() {
		return thoigianHoc;
	}
	public void setThoigianHoc(String thoigianHoc) {
		this.thoigianHoc = thoigianHoc;
	}
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	
		
}
