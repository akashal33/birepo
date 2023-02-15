package com.akashk.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.akashk.entity.BenefitIssuanceEntity;
import com.akashk.entity.CaseDetailsEntity;
import com.akashk.entity.CitizenEntity;
import com.akashk.entity.EligibilityDeterminationEntity;
import com.akashk.repository.BenefitIssuanceRepository;
import com.akashk.repository.EligibilityDeterminationRepository;

@Service
public class BenefitIssuanceServiceImpl implements BenefitIssuanceService {

	@Autowired
	private EligibilityDeterminationRepository eligibityRepo;
	@Autowired
	private BenefitIssuanceRepository benefitIssuanceRepository;

	private StringBuilder builder = null;

	@Override
	public void generate() {

		builder = new StringBuilder();

		List<EligibilityDeterminationEntity> eligibilityEntities = eligibityRepo
				.findByPlanStatusAndEndDateAfter("Approve", LocalDate.now());

		eligibilityEntities.forEach(eligibilityEntity -> {

			CaseDetailsEntity caseDetailsEntity = eligibilityEntity.getCaseDetailsEntity();
			CitizenEntity citizen = caseDetailsEntity.getCitizen();

			builder.append(caseDetailsEntity.getCaseId() + "," + citizen.getFullName() + "," + citizen.getSsnNo() + ","
					+ caseDetailsEntity.getPlanName() + "," + eligibilityEntity.getBenefitAmount());
			builder.append(System.lineSeparator());

		});

		String fileName = " bi " + LocalDate.now();
		BenefitIssuanceEntity benefitIssuanceEntity = new BenefitIssuanceEntity();
		benefitIssuanceEntity.setFlieName(fileName);
		benefitIssuanceEntity.setCsvFile(builder.toString().getBytes());
		benefitIssuanceRepository.save(benefitIssuanceEntity);
		
		// writeTofile(fileName,builder.toString());

	}

	/*
	 * private void writeTofile(String fileName, String data) { try { Path path =
	 * Files.createFile(Path.of(fileName)); Files.write(path,data.getBytes(),
	 * StandardOpenOption.APPEND); } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * }
	 */

}
