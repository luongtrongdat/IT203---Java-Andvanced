package btvn.session11.baitap05.interfaces;

import java.util.*;

import btvn.session11.baitap05.model.Doctor;

public interface IRepository {
    boolean add(String name, String specialty);

    Map<String, Integer> countBySpecialty();

    List<Doctor> findAll();
}
