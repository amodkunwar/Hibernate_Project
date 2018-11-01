package org.gun.dao;

import org.gun.dto.GunDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.hibernateUtil.HibernateUtil;
import org.hibernate.query.Query;

public class GunDAO {
	private SessionFactory factory = HibernateUtil.getSessionFactory();

	public Integer saveGun(GunDTO dto) {
		Transaction transaction = null;
		Session session = null;
		Integer identifier = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			identifier = (Integer) session.save(dto);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return identifier;
	}

	public String getGunPriceByName(String gunName) {
		String gunType = null;
		String hql = "select gun.gunType from GunDTO gun where gun.gunName=:name";
		try (Session session = factory.openSession();) {
			Query query = session.createQuery(hql);
			query.setParameter("name", gunName);
			gunType = (String) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return gunType;

	}

	public String getGunByName(String gunName) {
		String gunType = null;
		String hql = "select gun.gunType from gun_table gun where gun.gunName=:name";

		try (Session session = factory.openSession()) {
			Query query = session.createQuery(hql);
			query.setString(0, gunName);
			gunType = (String) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return gunType;

	}

	public GunDTO getGunByName1(String gunName) {
		GunDTO gunDTO = null;
		String hql = "select gun from GunDTO gun where gun.gunName=:name";
		try (Session session = factory.openSession();) {
			Query query = session.createQuery(hql);
			query.setParameter("name", gunName);
			gunDTO = (GunDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return gunDTO;
	}

}
