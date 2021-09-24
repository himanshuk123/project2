package com.doctorapplication.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapplication.DAO.DoctorApplicationDao;
import com.doctorapplication.Entity.DoctorEntity;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorApplicationDao doctordao;

	@Override
	public boolean saveDoctorEntity(DoctorEntity doctorentity) {
		doctordao.save(doctorentity);
		return true;
	}

	@Override
	public List<DoctorEntity> getDoctors() {
		return doctordao.findAll();
	}

	@Override
	public boolean deleteDoctor(DoctorEntity doctorentity) {
		doctordao.delete(doctorentity);
		 return true;
				
	}
	@Override
	public List<DoctorEntity> getDoctorByID(DoctorEntity doctorentity) {
		List<DoctorEntity> dlist=new ArrayList<DoctorEntity>();
		dlist.add(doctordao.findById(doctorentity.getDoctor_id()).get());
		return dlist;
	}
	
	
//	@Override
//	public List<DoctorEntity> getDoctorByEmail(DoctorEntity doctorentity) {
//		List<DoctorEntity> doctor_password=new ArrayList<DoctorEntity>();
//		doctor_password.add(doctordao.findById(doctorentity.getDoctor_email()).ge);
//		return doctor_password;
//		
//	}
	
		
		
	
	@Override
	public boolean updateDoctor(DoctorEntity doctorentity) {
		doctordao.saveAndFlush(doctorentity);
		return true;
	}

}