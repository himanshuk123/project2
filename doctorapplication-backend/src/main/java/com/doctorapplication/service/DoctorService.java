package com.doctorapplication.service;

import java.util.List;

import com.doctorapplication.Entity.DoctorEntity;

public interface DoctorService {

	public boolean saveDoctorEntity(DoctorEntity doctorentity);
	public List<DoctorEntity> getDoctors();
	public boolean  deleteDoctor(DoctorEntity doctorentity);
	public List<DoctorEntity> getDoctorByID(DoctorEntity doctorentity);
	public boolean updateDoctor(DoctorEntity doctorentity);
	//public List<DoctorEntity> getDoctorByEmail(DoctorEntity doctorentity);
	
}