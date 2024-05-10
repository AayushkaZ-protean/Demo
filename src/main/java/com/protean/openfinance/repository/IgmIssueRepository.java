package com.protean.openfinance.repository;

import com.nsdl.beckn.api.model.common.Option;
import com.protean.openfinance.entity.IgmIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IgmIssueRepository extends JpaRepository<IgmIssue, Long> {
    boolean existsByIssueId(String issueId);
    List<IgmIssue> findAllByTransactionIdAndAction(String txnId, String action);
    Optional<IgmIssue> findByIssueId(String issueId);
    List<IgmIssue> findAllByTransactionIdAndStatus(String transactionId, String status);
}
