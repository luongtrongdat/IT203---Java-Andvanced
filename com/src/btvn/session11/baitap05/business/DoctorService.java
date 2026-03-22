package btvn.session11.baitap05.business;

import java.util.*;

import btvn.session11.baitap05.dao.DoctorRepository;
import btvn.session11.baitap05.interfaces.IRepository;
import btvn.session11.baitap05.model.Doctor;

public class DoctorService implements IRepository {
    private final DoctorRepository doctorRepository = new DoctorRepository();

    @Override
    public boolean add(String name, String specialty) {
        return doctorRepository.add(name, specialty);
    }

    @Override
    public Map<String, Integer> countBySpecialty() {
        return doctorRepository.countBySpecialty();
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}