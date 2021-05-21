package com.pintec10.jpacourse.patientscheduling.repos;

import com.pintec10.jpacourse.patientscheduling.entities.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    public List<Patient> findByLastName(String lastName);

    public Optional<Patient> findFirstByLastName(String lastName);
}
