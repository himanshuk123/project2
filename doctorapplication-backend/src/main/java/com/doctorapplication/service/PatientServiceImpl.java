package com.doctorapplication.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapplication.DAO.PatientApplicationDao;
import com.doctorapplication.Entity.PatientEntity;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientApplicationDao patientdao;

	@Override
	public boolean savePatientEntity(PatientEntity patiententity) {
		patientdao.save(patiententity);
		return true;
	}

	@Override
	public List<PatientEntity> getPatients() {
		return patientdao.findAll();
	}

	@Override
	public boolean deletePatient(PatientEntity patiententity) {
		patientdao.delete(patiententity);
		 return true;
				
	}

	@Override
	public List<PatientEntity> getPatientByID(PatientEntity patiententity) {
		List<PatientEntity> plist=new ArrayList<PatientEntity>();
		plist.add(patientdao.findById(patiententity.getPatient_id()).get());
		return plist;
	}

	@Override
	public boolean updatePatient(PatientEntity patiententity) {
		patientdao.saveAndFlush(patiententity);
		return true;
	}

}