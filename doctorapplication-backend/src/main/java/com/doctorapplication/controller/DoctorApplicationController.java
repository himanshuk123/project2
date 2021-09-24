package com.doctorapplication.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.doctorapplication.DAO.DoctorApplicationDao;
import com.doctorapplication.Entity.DoctorEntity;
import com.doctorapplication.exception.NotFoundException;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")

public class DoctorApplicationController {
	@Autowired
	private DoctorApplicationDao doctorapplicationdao;

	@GetMapping("/doctors")
    public List<DoctorEntity> getAllDoctorss() {
    	return doctorapplicationdao.findAll();
    }
    
    @GetMapping("/doctors/{doctor_id}")
    public DoctorEntity getDoctorByID(@PathVariable Integer doctor_id) {
    	Optional<DoctorEntity> optDoctorEntity = doctorapplicationdao.findById(doctor_id);
    	if(optDoctorEntity.isPresent()) {
    		return optDoctorEntity.get();
    	}else {
    		throw new NotFoundException("Doctor not found with id " + doctor_id);
    	}
    }
    
//    @GetMapping("/doctors/{doctor_email}")
//    public DoctorEntity getDoctorByEmail(@PathVariable Integer doctor_id)
    
    @PostMapping("/doctors")    //validation
    public DoctorEntity createDoctorEntity( @RequestBody DoctorEntity doctorentity) {
        return doctorapplicationdao.save(doctorentity);
    }
    
    @PutMapping("/doctors/{doctor_id}")
    public DoctorEntity updateDoctorEntity(@PathVariable Integer doctor_id,
                                    @RequestBody DoctorEntity doctorentityUpdated) {
        return doctorapplicationdao.findById(doctor_id)
                .map(doctorentity -> {
                	doctorentity.setDoctor_name(doctorentityUpdated.getDoctor_name());
                	doctorentity.setDoctor_city(doctorentityUpdated.getDoctor_city());
                	doctorentity.setDoctor_email(doctorentityUpdated.getDoctor_email());
                	doctorentity.setDoctor_experience(doctorentityUpdated.getDoctor_experience());
                	doctorentity.setDoctor_gender(doctorentityUpdated.getDoctor_gender());
                	doctorentity.setDoctor_phonenumber(doctorentityUpdated.getDoctor_phonenumber());
                	doctorentity.setDoctor_specialization(doctorentityUpdated.getDoctor_specialization());
                	doctorentity.setDoctor_password(doctorentityUpdated.getDoctor_password());
                	return doctorapplicationdao.save(doctorentity);
                }).orElseThrow(() -> new NotFoundException("Doctor not found with id " + doctor_id));
    }
    
    @DeleteMapping("/doctors/{doctor_id}")
    public String deleteDoctorEntity(@PathVariable Integer doctor_id) {
        return doctorapplicationdao.findById(doctor_id)
                .map(doctorentity -> {
                	doctorapplicationdao.delete(doctorentity);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new NotFoundException("Doctor not found with id " + doctor_id));
    }
}