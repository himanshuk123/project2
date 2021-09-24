package com.doctorapplication.service;

import java.util.List;

import com.doctorapplication.Entity.AppointmentEntity;

public interface AppointmentService {

    public boolean saveAppointmentEntity(AppointmentEntity appointmententity);
	public List<AppointmentEntity> getAppointments();
	public boolean  deleteAppointment(AppointmentEntity appointmententity);
	public boolean  statusAppointment(AppointmentEntity appointmententity);
	public List<AppointmentEntity> getAppointmentByID(AppointmentEntity appointmententity);
	public boolean updateAppointment(AppointmentEntity appointmententity);
	
}