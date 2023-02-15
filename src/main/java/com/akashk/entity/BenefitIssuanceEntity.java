package com.akashk.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="benefit_issuance_tab")
public class BenefitIssuanceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "benefit_issuance_id")
	private Long benefitIssuanceId;
	@CreationTimestamp
	@Column(name= "create_at")
	private LocalDateTime createdDate;
	@Column(name = "file_nm")
	private String flieName;
	@Lob
	@Column(name = "file_data")
	private byte[] csvFile;
	
}
