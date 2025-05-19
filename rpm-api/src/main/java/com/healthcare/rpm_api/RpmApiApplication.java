package com.healthcare.rpm_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//  Dushko Sofronievski 5343
@SpringBootApplication
public class RpmApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpmApiApplication.class, args);
	}

}

// order that Patients Shows Devices , Alerts , Vitals . Patient Notes ...

// RELATIONS
// alert -> device  X
// devices -> patient X
// vitals -> patient X
// patient_notes --> patients
