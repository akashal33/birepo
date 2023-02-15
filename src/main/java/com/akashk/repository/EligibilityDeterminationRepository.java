package com.akashk.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akashk.entity.EligibilityDeterminationEntity;

public interface EligibilityDeterminationRepository extends JpaRepository<EligibilityDeterminationEntity, Serializable>{
	
	List<EligibilityDeterminationEntity> findByPlanStatusAndEndDateAfter(String planStatus,LocalDate date);
}
