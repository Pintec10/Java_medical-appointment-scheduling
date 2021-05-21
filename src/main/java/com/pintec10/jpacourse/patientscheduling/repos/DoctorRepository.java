package com.pintec10.jpacourse.patientscheduling.repos;

import com.pintec10.jpacourse.patientscheduling.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    public List<Doctor> findByLastName(String lastName);

    public Optional<Doctor> findFirstByLastName(String lastName);
}
