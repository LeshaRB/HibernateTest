package by.test.hibernatetest.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import by.test.hibernatetest.dao.CarDAO;
import by.test.hibernatetest.logic.Car;
import by.test.hibernatetest.util.HibernateUtil;

public class CarDAOImpl implements CarDAO {

	public void addCar(Car car) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(car);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	public void updateCar(Car car) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(car);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	public Car getCarById(Long carID) throws SQLException {
		Session session = null;
		Car car = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			car = (Car) session.get(Car.class, carID);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return car;
	}

	public List<Car> getAllCars() throws SQLException {
		Session session = null;
		List<Car> cars = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			cars = session.createCriteria(Car.class).list();
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return cars;
	}

	public void deleteCar(Car car) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(car);
			session.getTransaction().commit();
		} catch (HibernateException hEx) {
			System.out.println(hEx.getLocalizedMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

}
