package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "danhmuc")
public class DanhMuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaDanhMuc")
	private Integer maDanhMuc;
	
	@Column(name = "TenDanhMuc")
	private String tenDanhMuc;

	@OneToMany(mappedBy = "danhMuc")
	private List<SanPham> lstSP;
	
	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DanhMuc(Integer maDanhMuc, String tenDanhMuc, List<SanPham> lstSP) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
		this.lstSP = lstSP;
	}

	public Integer getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(Integer maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	
}
