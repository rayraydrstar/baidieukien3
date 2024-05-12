package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "sanpham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaSanPham")
	private Integer maSanPham;
	
	@Column(name = "TenSanPham")
	@NotNull(message = "Nhap ten sp")
	@Length(min = 3, max = 200, message = "Do dai ten tu 3 den 200 chars")
	private String tenSanPham;
	
	@Column(name = "Gia")
	@NotNull(message = "Dien gia sp")
	private Double gia;
	
	@Column(name = "SoLuong")
	@NotNull(message = "Dien so luong sp")
	private Integer soLuong;
	
	@Column(name = "MoTa")
	@NotEmpty(message = "Dien mo ta san pham")
	private String moTa;
	
	@Column(name = "MaDanhMuc")
	@Transient
	private Integer maDanhMuc;
	
	@Column(name = "Anh")
	@NotEmpty(message = "Dien link anh san pham")
	private String anh;
	
	@ManyToOne
	@JoinColumn(name = "MaDanhMuc", referencedColumnName = "MaDanhMuc")
	private DanhMuc danhMuc;


	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SanPham(Integer maSanPham,
			@NotNull(message = "Nhap ten sp") @Length(min = 3, max = 200, message = "Do dai ten tu 3 den 200 chars") String tenSanPham,
			@NotNull(message = "Dien gia sp") Double gia, @NotNull(message = "Dien so luong sp") Integer soLuong,
			@NotEmpty(message = "Dien mo ta san pham") String moTa, Integer maDanhMuc,
			@NotEmpty(message = "Dien link anh san pham") String anh) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.gia = gia;
		this.soLuong = soLuong;
		this.moTa = moTa;
		this.maDanhMuc = maDanhMuc;
		this.anh = anh;
	}


	public Integer getMaSanPham() {
		return maSanPham;
	}


	public void setMaSanPham(Integer maSanPham) {
		this.maSanPham = maSanPham;
	}


	public String getTenSanPham() {
		return tenSanPham;
	}


	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}


	public Double getGia() {
		return gia;
	}


	public void setGia(Double gia) {
		this.gia = gia;
	}


	public Integer getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	public Integer getMaDanhMuc() {
		return maDanhMuc;
	}


	public void setMaDanhMuc(Integer maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}


	public String getAnh() {
		return anh;
	}


	public void setAnh(String anh) {
		this.anh = anh;
	}


	public DanhMuc getDanhMuc() {
		return danhMuc;
	}


	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}
	
	
	
}
