package com.akashk.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akashk.entity.BenefitIssuanceEntity;

public interface BenefitIssuanceRepository extends JpaRepository<BenefitIssuanceEntity, Serializable>{

}
