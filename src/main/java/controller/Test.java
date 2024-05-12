package controller;

import java.util.List;

import dao.IDanhMucDAO;
import dao.ISanPhamDAO;
import dao.ImplDanhMucDAO;
import dao.ImplSanPhamDAO;
import entity.DanhMuc;
import entity.SanPham;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDanhMucDAO dmDAO = new ImplDanhMucDAO();
		List<DanhMuc> lstDM = dmDAO.selectAllDanhMuc();
		for(DanhMuc dm : lstDM) 
			System.out.println(dm.getTenDanhMuc());
	}

}
