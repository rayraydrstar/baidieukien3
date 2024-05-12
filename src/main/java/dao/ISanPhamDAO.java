package dao;

import java.util.List;

import entity.SanPham;

public interface ISanPhamDAO {
	public List<SanPham> selectAll();

	public SanPham detail(int id);
	
	public boolean insert(SanPham sp);
	
	public boolean update(SanPham sp);
	
	public boolean delete(int id);
}
