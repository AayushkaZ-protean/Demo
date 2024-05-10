package com.protean.openfinance.repository;

import com.protean.openfinance.entity.ApplicantDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ApplicantDetailsPagingRepository extends PagingAndSortingRepository<ApplicantDetails, Long> {

    Page<ApplicantDetails> findByAgentIdContainingIgnoreCase(String agentId, Pageable pageable);

    Page<ApplicantDetails> findByPanContainingIgnoreCase(String pan, Pageable pageable);

    // Optimized date range search with optional fromDate and toDate
    Page<ApplicantDetails> findByCreatedOnBetween(LocalDateTime fromDate, LocalDateTime toDate, Pageable pageable);

    // New method for finding all details by date
    Page<ApplicantDetails> findAllByCreatedOn(LocalDate date, Pageable pageable);

    Page<ApplicantDetails> findByPanContainingIgnoreCaseAndCreatedOnBetween(String pan, LocalDateTime fromDate, LocalDateTime toDate, Pageable pageable);

    Page<ApplicantDetails> findByAgentIdContainingIgnoreCaseAndCreatedOnBetween(String agentId, LocalDateTime fromDate, LocalDateTime toDate, Pageable pageable);


    Page<ApplicantDetails> findByCreatedOnGreaterThanEqual(LocalDateTime fromDate, Pageable pageable);

    // New default method for combined search logic (including "all by date")
    default Page<ApplicantDetails> findAll(String searchPhrase, LocalDateTime fromDate, LocalDateTime toDate, Pageable pageable) {
        if (searchPhrase == null || searchPhrase.isEmpty()) {
            return filterByDate(fromDate, toDate, pageable);
        } else if (isValidPAN(searchPhrase)) {

            if(fromDate == null && toDate ==null)
            {
                return findByPanContainingIgnoreCase(searchPhrase, pageable);
            }else{
                return findByPanContainingIgnoreCaseAndCreatedOnBetween(searchPhrase, fromDate, toDate.plusDays(1), pageable);
            }
            // Combine PAN search with date filtering
        } else {

            if(fromDate == null && toDate ==null)
            {
                return findByAgentIdContainingIgnoreCase(searchPhrase, pageable);
            }else{
                return findByAgentIdContainingIgnoreCaseAndCreatedOnBetween(searchPhrase, fromDate, toDate.plusDays(1), pageable);
            }
            // Combine Agent ID search with date filtering

        }
    }

    // Helper method for date filtering
    private Page<ApplicantDetails> filterByDate(LocalDateTime fromDate, LocalDateTime toDate, Pageable pageable) {
        if (fromDate == null && toDate == null) {
            return findAll(pageable); // Get all applicants (equivalent to pagination)
        } else if (toDate == null) {
            return findByCreatedOnGreaterThanEqual(fromDate, pageable); // Search from specific date onwards
        } else {
            return findByCreatedOnBetween(fromDate, toDate.plusDays(1), pageable); // Include toDate
        }
    }

    // Utility method for PAN validation (adapt based on your specific PAN format)
    private static boolean isValidPAN(String pan) {
        return pan != null && pan.matches("^[A-Z0-9]{10}$");
    }

}
