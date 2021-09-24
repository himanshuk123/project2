package com.doctorapplication.Entity;
import java.io.Serializable;
//import java.util.List;
//import java.util.Set;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;
@Entity
@Table(name="PatientDetails")
public class PatientEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer patient_id;
	@Column(name = "patient_name")
	@NotNull
	private String patient_name;
	@Column(name = "patient_email")
	@NotNull
	private String patient_email;
	
	private String patient_gender;
	
	@Column(name = "patient_phonenumber")
	@NotNull
	private String patient_phonenumber;
	private String patient_city;
	@Column(name = "patient_age")
	@NotNull
	private String patient_age;
	@Column(name = "patient_password")
	@NotNull
	private String patient_password;
	
   
   

//	@OneToMany(mappedBy = "patientEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<AppointmentEntity> appointments; 
    
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_email() {
		return patient_email;
	}
	public void setPatient_email(String patient_email) {
		this.patient_email = patient_email;
	}
	public String getPatient_gender() {
		return patient_gender;
	}
	public void setPatient_gender(String patient_gender) {
		this.patient_gender = patient_gender;
	}
	public String getPatient_phonenumber() {
		return patient_phonenumber;
	}
	public void setPatient_phonenumber(String patient_phonenumber) {
		this.patient_phonenumber = patient_phonenumber;
	}
	public String getPatient_city() {
		return patient_city;
	}
	public void setPatient_city(String patient_city) {
		this.patient_city = patient_city;
	}
	public String getPatient_age() {
		return patient_age;
	}
	public void setPatient_age(String patient_age) {
		this.patient_age = patient_age;
	}

	 public String getPatient_password() {
			return patient_password;
	}
		
	 public void setPatient_password(String patient_password) {
			this.patient_password = patient_password;
	}
	
}