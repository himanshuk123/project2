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
import com.doctorapplication.DAO.PatientApplicationDao;
import com.doctorapplication.Entity.PatientEntity;
import com.doctorapplication.exception.NotFoundException;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")

public class PatientApplicationController {
	@Autowired
	private PatientApplicationDao patientapplicationdao;

		@GetMapping("/patients")
	    public List<PatientEntity> getAllPatients() {
	    	return patientapplicationdao.findAll();
	    }  
	    @GetMapping("/patients/{patient_id}")
	    public PatientEntity getPatientByID(@PathVariable Integer patient_id) {
	    	Optional<PatientEntity> optPatientEntity = patientapplicationdao.findById(patient_id);
	    	if(optPatientEntity.isPresent()) {
	    		return optPatientEntity.get();
	    	}else {
	    		throw new NotFoundException("Patient not found with id " + patient_id);
	    	}
	    }
	    
	    @PostMapping("/patients")    
	    public PatientEntity createPatientEntity( @RequestBody PatientEntity patiententity) {
	        return patientapplicationdao.save(patiententity);
	        
	    }
	    
	    @PutMapping("/patients/{patient_id}")
	    public PatientEntity updatePatientEntity(@PathVariable Integer patient_id,
	                                    @RequestBody PatientEntity patiententityUpdated) {
	        return patientapplicationdao.findById(patient_id)
	                .map(patiententity -> {
	                	patiententity.setPatient_name(patiententityUpdated.getPatient_name());
	                	patiententity.setPatient_email(patiententityUpdated.getPatient_email());
	                	patiententity.setPatient_age(patiententityUpdated.getPatient_age());
	                	patiententity.setPatient_city(patiententityUpdated.getPatient_city());
	                	patiententity.setPatient_gender(patiententityUpdated.getPatient_gender());
	                	patiententity.setPatient_phonenumber(patiententityUpdated.getPatient_phonenumber());
//	                	patiententity.setDate(patiententityUpdated.getDate());
	                	patiententity.setPatient_password(patiententityUpdated.getPatient_password());
	                	return patientapplicationdao.save(patiententity);
	                }).orElseThrow(() -> new NotFoundException("Patient not found with id " + patient_id));
	    }
	    
	    @DeleteMapping("/patients/{patient_id}")
	    public String deletePatientEntity(@PathVariable Integer patient_id) {
	        return patientapplicationdao.findById(patient_id)
	                .map(patiententity -> {
	                	patientapplicationdao.delete(patiententity);
	                    return "Delete Successfully!";
	                }).orElseThrow(() -> new NotFoundException("Patient not found with id " + patient_id));
	    }
	}