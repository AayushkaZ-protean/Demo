package com.protean.openfinance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.protean.openfinance.entity.ApiAudit;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ApiAuditRepository extends JpaRepository<ApiAudit, Long> {

	@Query("SELECT s FROM ApiAudit s WHERE s.transactionId = :transactionId AND s.action = :action ORDER BY s.createdOn DESC")
    List<ApiAudit> findApiAuditByTransactionId(@Param("transactionId") String transactionId, @Param("action") String action);

    List<ApiAudit> findByTransactionIdAndActionOrderByCreatedOnDesc(String txnId, String action);

    List<ApiAudit> findAllByTransactionIdAndAction(String txnId, String action);

    List<ApiAudit> findByTransactionIdAndContactNumberAndActionIgnoreCase(String txn, String contactNumber, String action);
	

}
