package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.SanPham;

public class ImplSanPhamDAO implements ISanPhamDAO{

	private SessionFactory sf;
	
	public ImplSanPhamDAO() {
		sf = HibernateHelper.getSessionFactory();
	}
	
	@Override
	public List<SanPham> selectAll() {
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		try {
			String hql = "from SanPham";
			List<SanPham> lstSanPham = ss.createQuery(hql).list();
			ss.getTransaction().commit();
			return lstSanPham;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return null;
	}

	@Override
	public SanPham detail(int id) {
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		try {
			SanPham sp = ss.get(SanPham.class, id);
			return sp;
		} catch (Exception e) {
			System.out.println("Err" + e.getMessage());
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return null;
	}

	
	@Override
	public boolean insert(SanPham sp) {
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		try {
			ss.save(sp);
			ss.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Err: " + e.getMessage());
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return false;
	}

	@Override
	public boolean update(SanPham sp) {
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		try {
			ss.update(sp);
			ss.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Err: " + e.getMessage());
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		try {
			SanPham sp = ss.get(SanPham.class, id);
			ss.delete(sp);
			ss.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Err: " + e.getMessage());
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return false;
	}

	@Override
	public List<SanPham> search(String name, Double priceFrom, Double priceTo) {
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		try {
			String hql = "from SanPham WHERE tenSanPham LIKE :txtName";
			if(priceFrom != null && priceTo != null) {
				//Nhớ giữa " với AND phải có dấu cách (vì đang nối 2 chuỗi)
				hql += " AND gia >= :priceFrom AND gia <= :priceTo";
			}
			
			Query query = ss.createQuery(hql);
			query.setParameter("txtName", "%" + name + "%");
			if(priceFrom != null && priceTo != null) {
				query.setParameter("priceFrom", priceFrom);
				query.setParameter("priceTo", priceTo);
			}
			
			List<SanPham> lst = ((org.hibernate.query.Query) query).list();
			ss.getTransaction().commit();
			return lst;
			
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return null;
	}

	@Override
	public List<SanPham> sortByCategory(int maDanhMuc) {
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		try {
			String hql = "from SanPham WHERE maDanhMuc = :maDM";
			Query query = ss.createQuery(hql);
			query.setParameter("maDM", maDanhMuc);
			List<SanPham> lst = ((org.hibernate.query.Query) query).list();
			ss.getTransaction().commit();
			return lst;
		} catch (Exception e) {
			System.out.println("ERR: " + e.getMessage());
			ss.getTransaction().rollback();
		} finally {
			ss.close();
		}
		return null;
	}

}
