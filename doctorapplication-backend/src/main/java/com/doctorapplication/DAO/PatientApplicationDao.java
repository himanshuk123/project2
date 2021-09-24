package com.doctorapplication.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.doctorapplication.Entity.*;

@Repository
public interface PatientApplicationDao extends JpaRepository<PatientEntity,Integer>{

}