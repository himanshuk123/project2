package com.doctorapplication.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DoctorDetails")
public class DoctorEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer doctor_id;
	private String doctor_name;
	private String doctor_email;
	private String doctor_specialization;
	private String doctor_gender;
	private String doctor_phonenumber;
	private Integer doctor_experience;
	private String doctor_city;
	private String doctor_password;
	public String getDoctor_password() {
		return doctor_password;
	}
	public void setDoctor_password(String doctor_password) {
		this.doctor_password = doctor_password;
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_email() {
		return doctor_email;
	}
	public void setDoctor_email(String doctor_email) {
		this.doctor_email = doctor_email;
	}
	public String getDoctor_specialization() {
		return doctor_specialization;
	}
	public void setDoctor_specialization(String doctor_specialization) {
		this.doctor_specialization = doctor_specialization;
	}
	public String getDoctor_gender() {
		return doctor_gender;
	}
	public void setDoctor_gender(String doctor_gender) {
		this.doctor_gender = doctor_gender;
	}
	public String getDoctor_phonenumber() {
		return doctor_phonenumber;
	}
	public void setDoctor_phonenumber(String doctor_phonenumber) {
		this.doctor_phonenumber = doctor_phonenumber;
	}
	public Integer getDoctor_experience() {
		return doctor_experience;
	}
	public void setDoctor_experience(Integer doctor_experience) {
		this.doctor_experience = doctor_experience;
	}
	public String getDoctor_city() {
		return doctor_city;
	}
	public void setDoctor_city(String doctor_city) {
		this.doctor_city = doctor_city;
	}
	

}