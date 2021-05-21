package com.pintec10.jpacourse.patientscheduling.repos;

import com.pintec10.jpacourse.patientscheduling.entities.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
