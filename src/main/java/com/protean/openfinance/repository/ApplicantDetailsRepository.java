package com.protean.openfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protean.openfinance.entity.ApplicantDetails;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantDetailsRepository extends JpaRepository<ApplicantDetails, Long> {

    Optional<ApplicantDetails> findFirstByContactNumberAndTransactionIdOrderByCreatedOnDesc(String contactNumber, String transactionId);

    List<ApplicantDetails> findByContactNumberAndTransactionIdOrderByCreatedOnDesc(String contactNumber, String transactionId);

    List<ApplicantDetails> findAllByTransactionIdAndContactNumber(String contactNumber, String transactionId);

    List<ApplicantDetails> findByContactNumberAndStatus(String contactNumber, String status);

    boolean existsByIgmIssueId(String issueId);
}
