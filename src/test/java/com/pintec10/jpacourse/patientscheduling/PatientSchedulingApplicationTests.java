package com.pintec10.jpacourse.patientscheduling;

import com.pintec10.jpacourse.patientscheduling.entities.Appointment;
import com.pintec10.jpacourse.patientscheduling.entities.Doctor;
import com.pintec10.jpacourse.patientscheduling.entities.Insurance;
import com.pintec10.jpacourse.patientscheduling.entities.Patient;
import com.pintec10.jpacourse.patientscheduling.repos.AppointmentRepository;
import com.pintec10.jpacourse.patientscheduling.repos.DoctorRepository;
import com.pintec10.jpacourse.patientscheduling.repos.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PatientSchedulingApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	AppointmentRepository appointmentRepository;


	@Test
	void testCreateDoctor() {
		Doctor doctor = new Doctor("John", "House", "Emergency");
		doctorRepository.save(doctor);
	}

	@Test
	void testCreatePatient() {
		Patient patient = new Patient("Hernan", "Herrera", "987654321");

		Insurance insurance = new Insurance("Test Seguros", 15D);
		patient.setInsurance(insurance);

		List<Doctor> doctors = doctorRepository.findByLastName("House");
		if (doctors.size() > 0) {
			patient.setDoctors(doctors);
		} else {
			System.out.println("**** testCreatePatient: Doctor not found ****");
		}

		patientRepository.save(patient);
	}

	@Test
	void testCreateAppointment() throws Exception {
		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		Appointment appointment = new Appointment(appointmentTime, "Urgency appointment");

		Patient patient = patientRepository.findFirstByLastName("Herrera").orElse(null);
		if (patient != null) {
			appointment.setPatient(patient);
		} else {
			throw new Exception("testCreateAppointment: Patient not found");
		}

		Doctor doctor = doctorRepository.findFirstByLastName("House").orElse(null);
		if (doctor != null) {
			appointment.setDoctor(doctor);
		} else {
			throw new Exception("testCreateAppointment: Doctor not found");
		}

		appointmentRepository.save(appointment);
	}

}
