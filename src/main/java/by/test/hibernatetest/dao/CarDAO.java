package by.test.hibernatetest.dao;

import java.sql.SQLException;
import java.util.List;

import by.test.hibernatetest.logic.Car;

public interface CarDAO {
	public void addCar(Car car) throws SQLException;

	public void updateCar(Car car) throws SQLException;

	public void deleteCar(Car car) throws SQLException;

	public Car getCarById(Long carID) throws SQLException;

	public List<Car> getAllCars() throws SQLException;
}
