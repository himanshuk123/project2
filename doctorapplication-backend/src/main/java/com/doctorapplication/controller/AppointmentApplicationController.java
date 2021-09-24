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
import com.doctorapplication.DAO.AppointmentApplicationDao;
import com.doctorapplication.Entity.AppointmentEntity;
import com.doctorapplication.exception.NotFoundException;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")

public class AppointmentApplicationController {
	@Autowired
	private AppointmentApplicationDao appointmentapplicationdao;
	
			@GetMapping("/appointments")
		    public List<AppointmentEntity> getAllAppointments() {
		    	return appointmentapplicationdao.findAll();
		    }
		    
		    @GetMapping("/appointments/{appointment_id}")
		    public AppointmentEntity getAppointmentByID(@PathVariable Integer appointment_id) {
		    	Optional<AppointmentEntity> optAppointmentEntity = appointmentapplicationdao.findById(appointment_id);
		    	if(optAppointmentEntity.isPresent()) {
		    		return optAppointmentEntity.get();
		    	}else {
		    		throw new NotFoundException("Appointment not found with id " + appointment_id);
		    	}
		    }
		    
		    @PostMapping("/appointments")    
		    public AppointmentEntity createAppointmentEntity( @RequestBody AppointmentEntity appointmententity) {
		        return appointmentapplicationdao.save(appointmententity);
		    }
		    
		    @PutMapping("/appointments/{appointment_id}")
		    public AppointmentEntity updateAppointmentEntity(@PathVariable Integer appointment_id,
		                                    @RequestBody AppointmentEntity appointmententityUpdated) {
		        return appointmentapplicationdao.findById(appointment_id)
		                .map(appointmententity -> {
		                	appointmententity.setAppointment_details(appointmententityUpdated.getAppointment_details());
		                	appointmententity.setAppointment_date(appointmententity.getAppointment_date());
		                	appointmententity.setAppointment_status(appointmententity.getAppointment_status());
		                	appointmententity.setAppointment_time(appointmententity.getAppointment_time());
		                	appointmententity.setAppointment_patientname(appointmententity.getAppointment_patientname());
		                	return appointmentapplicationdao.save(appointmententity);
		                }).orElseThrow(() -> new NotFoundException("Appointment not found with id " + appointment_id));
		    }
		    
		    
		    @DeleteMapping("/appointments/{appointment_id}")
		    public String deleteAppointmentEntity(@PathVariable Integer appointment_id) {
		        return appointmentapplicationdao.findById(appointment_id)
		                .map(appointmententity -> {
		                	appointmentapplicationdao.delete(appointmententity);
		                    return "Delete Successfully!";
		                }).orElseThrow(() -> new NotFoundException("Appointment not found with id " + appointment_id));
		    }
		}