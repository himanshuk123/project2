package com.doctorapplication.service;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doctorapplication.DAO.AppointmentApplicationDao;
import com.doctorapplication.Entity.AppointmentEntity;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentApplicationDao appointmentdao;

	@Override
	public boolean saveAppointmentEntity(AppointmentEntity appointmententity) {
		appointmentdao.save(appointmententity);
		return true;
	}

	@Override
	public List<AppointmentEntity> getAppointments() {
		return appointmentdao.findAll();
	}

	@Override
	public boolean deleteAppointment(AppointmentEntity appointmententity) {
		appointmentdao.delete(appointmententity);
		 return true;
	}

	@Override
	public boolean statusAppointment(AppointmentEntity appointmententity) {
		appointmentdao.saveAndFlush(appointmententity);
		return true;
	}

	@Override
	public List<AppointmentEntity> getAppointmentByID(AppointmentEntity appointmententity) {
		List<AppointmentEntity> alist=new ArrayList<AppointmentEntity>();
		alist.add(appointmentdao.findById(appointmententity.getAppointment_id()).get());
		return alist;
	}

	
	
	
	@Override
	public boolean updateAppointment(AppointmentEntity appointmententity) {
		appointmentdao.saveAndFlush(appointmententity);
		return true;
	}	
}