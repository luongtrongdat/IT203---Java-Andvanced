package btvn.session11.baitap05.dao;

import java.sql.*;
import java.util.*;

import btvn.session11.baitap01.DBContext;
import btvn.session11.baitap05.interfaces.IRepository;
import btvn.session11.baitap05.model.Doctor;

public class DoctorRepository implements IRepository {
    @Override
    public boolean add(String name, String specialty) {
        int result;

        try (Connection connection = DBContext.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("insert into doctors(name, specialty) values('%s', '%s')", name, specialty);
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result > 0;
    }

    @Override
    public Map<String, Integer> countBySpecialty() {
        Map<String, Integer> doctors = new HashMap<>();
        try (Connection connection = DBContext.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "select specialty, count(doctor_id) from  doctors group by doctor_id, specialty";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String specialty = resultSet.getString("specialty");
                int count = resultSet.getInt("count(doctor_id)");
                doctors.put(specialty, count);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doctors;
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = DBContext.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "select doctor_id, name, specialty from doctors";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("doctor_id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                doctors.add(new Doctor(id, name, specialty));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doctors;
    }
}