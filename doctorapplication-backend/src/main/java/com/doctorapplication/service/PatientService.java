package com.doctorapplication.service;

import java.util.List;

import com.doctorapplication.Entity.PatientEntity;

public interface PatientService {
	
	public boolean savePatientEntity(PatientEntity patiententity);
	public List<PatientEntity> getPatients();
	public boolean  deletePatient(PatientEntity patiententity);
	public List<PatientEntity> getPatientByID(PatientEntity patiententity);
	public boolean updatePatient(PatientEntity patiententity);

}
