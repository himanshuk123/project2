package com.doctorapplication.Entity;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="AppointmentDetails")
public class AppointmentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer appointment_id;
	private String appointment_time;
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "patient_id")
//    @JsonIgnore
//    private PatientEntity patientEntity ;
	
	private String appointment_patientname;
	
	public String getAppointment_patientname() {
		return appointment_patientname;
	}
	public void setAppointment_patientname(String appointment_patientname) {
		this.appointment_patientname = appointment_patientname;
	}
	private String appointment_details;
	private String appointment_date;
	private String appointment_status;
	
	public Integer getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(String appointment_time) {
		this.appointment_time = appointment_time;
	}
	public String getAppointment_details() {
		return appointment_details;
	}
	public void setAppointment_details(String appointment_details) {
		this.appointment_details = appointment_details;
	}
	public String getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}
	public String getAppointment_status() {
		return appointment_status;
	}
	public void setAppointment_status(String appointment_status) {
		this.appointment_status = appointment_status;
	}
	

}