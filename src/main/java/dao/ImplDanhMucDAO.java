package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.DanhMuc;

public class ImplDanhMucDAO implements IDanhMucDAO{

	private SessionFactory sf;
	
	public ImplDanhMucDAO() {
		sf = HibernateHelper.getSessionFactory();
	}
	
	@Override
	public List<DanhMuc> selectAllDanhMuc() {
		Session ss = sf.openSession();
		try {
			String hql = "from DanhMuc";
			List<DanhMuc> lstDanhMuc = ss.createQuery(hql).list();
			return lstDanhMuc;
		} catch (Exception e) {
			System.out.println("err" + e.getMessage());
		}
		ss.close();
		return null;
	}

}
